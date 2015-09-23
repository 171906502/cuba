/*
 * Copyright (c) 2008-2013 Haulmont. All rights reserved.
 * Use is subject to license terms, see http://www.cuba-platform.com/license for details.
 */

package com.haulmont.cuba.core.sys.dbupdate;

import com.haulmont.bali.db.DbUtils;
import com.haulmont.bali.db.QueryRunner;
import com.haulmont.cuba.core.sys.DBNotInitializedException;
import com.haulmont.cuba.core.sys.DbUpdater;
import com.haulmont.cuba.core.sys.PostUpdateScripts;
import com.haulmont.cuba.core.sys.persistence.DbmsSpecificFactory;
import groovy.lang.Binding;
import groovy.lang.Closure;
import groovy.lang.GroovyShell;
import groovy.lang.Script;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.text.StrMatcher;
import org.apache.commons.lang.text.StrTokenizer;
import org.codehaus.groovy.control.CompilerConfiguration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.Nullable;
import javax.sql.DataSource;
import java.io.IOException;
import java.sql.*;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @author artamonov
 * @version $Id$
 */
public class DbUpdaterEngine implements DbUpdater {
    private static final String SQL_EXTENSION = "sql";
    private static final String SQL_COMMENT_PREFIX = "--";
    private static final String SQL_DELIMITER = "^";

    private static final String GROOVY_EXTENSION = "groovy";

    private static final Logger log = LoggerFactory.getLogger(DbUpdaterEngine.class);

    protected DataSource dataSource;

    protected String dbScriptsDirectory;
    protected String dbmsType;
    protected String dbmsVersion;

    protected boolean changelogTableExists = false;

    protected final Map<String, String> requiredTables = new HashMap<>();

    {
        requiredTables.put("reports", "report_report");
        requiredTables.put("workflow", "wf_proc");
        requiredTables.put("ccpayments", "cc_credit_card");
        requiredTables.put("bpm", "bpm_proc_definition");
    }

    // register handlers for script files
    protected final Map<String, FileHandler> extensionHandlers = new HashMap<>();

    {
        extensionHandlers.put(SQL_EXTENSION, this::executeSqlScript);
        extensionHandlers.put(GROOVY_EXTENSION, this::executeGroovyScript);
    }

    protected DbUpdaterEngine() {
    }

    public DataSource getDataSource() {
        return dataSource;
    }

    public List<ScriptResource> getScripts(ScriptType scriptType, @Nullable String moduleName) {
        return scriptScanner().getScripts(scriptType, moduleName);
    }

    @Override
    public void updateDatabase() {
        if (dbInitialized())
            doUpdate();
        else
            doInit();
    }

    @Override
    public List<String> findUpdateDatabaseScripts() throws DBNotInitializedException {
        List<String> list = new ArrayList<>();
        if (dbInitialized()) {
            if (!changelogTableExists) {
                throw new DBNotInitializedException(
                        "Unable to determine required updates because SYS_DB_CHANGELOG table doesn't exist");
            } else {
                List<ScriptResource> files = getUpdateScripts();
                Set<String> scripts = getExecutedScripts();
                for (ScriptResource file : files) {
                    String name = getScriptName(file);
                    if (!scripts.contains(name)) {
                        list.add(name);
                    }
                }
            }
        } else {
            throw new DBNotInitializedException(
                    "Unable to determine required updates because SEC_USER table doesn't exist");
        }
        return list;
    }

    protected ScriptScanner scriptScanner() {
        return new ScriptScanner(dbScriptsDirectory, dbmsType, dbmsVersion);
    }

    protected String dbScriptDirectoryPath() {
        return scriptScanner().dbScriptDirectoryPath();
    }

    protected void createChangelogTable() {
        String timeStampType = DbmsSpecificFactory.getDbmsFeatures().getTimeStampType();
        QueryRunner runner = new QueryRunner(getDataSource());
        try {
            runner.update("create table SYS_DB_CHANGELOG(" +
                    "SCRIPT_NAME varchar(300) not null primary key, " +
                    "CREATE_TS " + timeStampType + " default current_timestamp, " +
                    "IS_INIT integer default 0)");
        } catch (SQLException e) {
            throw new RuntimeException("An error occurred while creating changelog table", e);
        }
    }

    protected String getScriptName(ScriptResource resource) {
        String path = resource.getPath();
        return getScriptName(path);
    }

    protected String getScriptName(String path) {
        String dir = dbScriptDirectoryPath();
        path = path.replace("\\", "/");
        int indexOfDir = path.indexOf(dir);
        return path.substring(indexOfDir + dir.length() + 1).replaceAll("^/+", "");
    }

    protected boolean dbInitialized() {
        Connection connection = null;
        try {
            connection = getDataSource().getConnection();
            DatabaseMetaData dbMetaData = connection.getMetaData();
            ResultSet tables = dbMetaData.getTables(null, null, null, null);
            boolean found = false;
            while (tables.next()) {
                String tableName = tables.getString("TABLE_NAME");
                if ("SYS_DB_CHANGELOG".equalsIgnoreCase(tableName)) {
                    changelogTableExists = true;
                }
                if ("SEC_USER".equalsIgnoreCase(tableName)) {
                    found = true;
                }
            }
            return found;
        } catch (SQLException e) {
            throw new RuntimeException("An error occurred while checking database", e);
        } finally {
            if (connection != null)
                try {
                    connection.close();
                } catch (SQLException ignored) {
                }
        }
    }

    protected void doInit() {
        log.info("Initializing database");

        createChangelogTable();

        List<ScriptResource> initFiles = getInitScripts();
        try {
            for (ScriptResource file : initFiles) {
                executeScript(file);
                markScript(getScriptName(file), true);
            }
        } finally {
            prepareScripts();
        }

        log.info("Database initialized");
    }

    protected void doUpdate() {
        log.info("Updating database...");

        if (!changelogTableExists) {
            log.info("Changelog table not found, creating it and marking all scripts as executed");

            createChangelogTable();

            List<ScriptResource> initFiles = getInitScripts();
            try {
                for (ScriptResource file : initFiles) {
                    markScript(getScriptName(file), true);
                }
            } finally {
                prepareScripts();
            }

            return;
        }

        runRequiredInitScripts();

        List<ScriptResource> files = getUpdateScripts();
        Set<String> scripts = getExecutedScripts();
        for (ScriptResource file : files) {
            String name = getScriptName(file);
            if (!scripts.contains(name)) {
                if (executeScript(file)) {
                    markScript(name, false);
                }
            }
        }
        log.info("Database is up-to-date");
    }

    protected void runRequiredInitScripts() {
        for (String dirName : getModuleDirs()) {
            String moduleName = dirName.substring(3);
            String reqTable = requiredTables.get(moduleName);
            if (reqTable != null) {
                try {
                    executeSql("select * from " + reqTable + " where 0=1");
                } catch (SQLException e) {
                    String mark = dbmsType.equals("oracle") ? "ora-00942" : reqTable;
                    if (e.getMessage() != null && e.getMessage().toLowerCase().contains(mark)) {
                        // probably the required table does not exist
                        log.info("Required table for " + moduleName + " does not exist, running init scripts");
                        List<ScriptResource> initScripts = getInitScripts(dirName);
                        try {
                            for (ScriptResource file : initScripts) {
                                executeScript(file);
                                markScript(getScriptName(file), true);
                            }
                        } finally {
                            List<ScriptResource> updateFiles = getUpdateScripts(dirName);
                            for (ScriptResource file : updateFiles)
                                markScript(getScriptName(file), true);
                        }
                    } else {
                        throw new RuntimeException("An error occurred while checking required tables", e);
                    }
                }
            }
        }
    }

    /**
     * Mark all SQL updates scripts as evaluated
     * Try to execute Groovy scripts
     */
    protected void prepareScripts() {
        List<ScriptResource> updateFiles = getUpdateScripts();
        for (ScriptResource file : updateFiles)
            markScript(getScriptName(file), true);
    }

    protected Set<String> getExecutedScripts() {
        QueryRunner runner = new QueryRunner(getDataSource());
        try {
            //noinspection UnnecessaryLocalVariable
            Set<String> scripts = runner.query("select SCRIPT_NAME from SYS_DB_CHANGELOG",
                    rs -> {
                        Set<String> rows = new HashSet<>();
                        while (rs.next()) {
                            rows.add(rs.getString(1));
                        }
                        return rows;
                    });
            return scripts;
        } catch (SQLException e) {
            throw new RuntimeException("An error occurred while loading executed scripts", e);
        }
    }

    protected void markScript(String name, boolean init) {
        QueryRunner runner = new QueryRunner(getDataSource());
        try {
            runner.update("insert into SYS_DB_CHANGELOG (SCRIPT_NAME, IS_INIT) values (?, ?)",
                    new Object[]{name, init ? 1 : 0}
            );
        } catch (SQLException e) {
            throw new RuntimeException("An error occurred while updating SYS_DB_CHANGELOG", e);
        }
    }

    protected boolean isEmpty(String sql) {
        String[] lines = sql.split("\\r?\\n");
        for (String line : lines) {
            line = line.trim();
            if (!line.startsWith(SQL_COMMENT_PREFIX) && !StringUtils.isBlank(line)) {
                return false;
            }
        }
        return true;
    }

    protected boolean executeSqlScript(ScriptResource file) {
        String script;
        try {
            script = file.getContent();
        } catch (IOException e) {
            log.error(e.getMessage());
            throw new RuntimeException("An error occurred while executing SQL script", e);
        }
        StrTokenizer tokenizer = new StrTokenizer(script,
                StrMatcher.charSetMatcher(SQL_DELIMITER),
                StrMatcher.singleQuoteMatcher()
        );
        while (tokenizer.hasNext()) {
            String sql = tokenizer.nextToken().trim();
            if (!isEmpty(sql)) {
                log.debug("Executing SQL:\n" + sql);
                try {
                    executeSql(sql);
                } catch (SQLException e) {
                    log.error(e.getMessage());
                    throw new RuntimeException("An error occurred while executing SQL script", e);
                }
            }
        }
        return true;
    }

    protected void executeSql(String sql) throws SQLException {
        Connection connection = null;
        Statement statement = null;
        try {
            connection = getDataSource().getConnection();
            statement = connection.createStatement();
            statement.execute(sql);
        } finally {
            DbUtils.closeQuietly(statement);
            DbUtils.closeQuietly(connection);
        }
    }

    protected boolean executeGroovyScript(ScriptResource file) {
        try {
            ClassLoader classLoader = getClass().getClassLoader();
            CompilerConfiguration cc = new CompilerConfiguration();
            cc.setRecompileGroovySource(true);

            Binding bind = new Binding();
            bind.setProperty("ds", getDataSource());
            bind.setProperty("log", LoggerFactory.getLogger(file.getName()));
            bind.setProperty("postUpdate", new PostUpdateScripts() {
                @Override
                public void add(Closure closure) {
                    super.add(closure);

                    log.warn("Added post update action will be ignored");
                }
            });

            GroovyShell shell = new GroovyShell(classLoader, bind, cc);
            //noinspection UnnecessaryLocalVariable
            Script script = shell.parse(file.getContent());
            script.run();
        } catch (IOException e) {
            log.error(e.getMessage());
            throw new RuntimeException("An error occurred while executing Groovy script", e);
        }
        return true;
    }

    protected boolean executeScript(ScriptResource file) {
        log.info("Executing script " + getScriptName(file));
        String filename = file.getName();
        String extension = FilenameUtils.getExtension(filename);
        if (StringUtils.isNotEmpty(extension)) {
            if (extensionHandlers.containsKey(extension)) {
                FileHandler handler = extensionHandlers.get(extension);
                return handler.run(file);
            } else
                log.warn("Update script ignored, file handler for extension not found:" +
                        file.getName());
        } else
            log.warn("Update script ignored, file extension undefined:" + file.getName());
        return false;
    }

    protected List<String> getModuleDirs() {
        return scriptScanner().getModuleDirs();
    }

    protected List<ScriptResource> getInitScripts() {
        return getModuleDirs().stream()
                .flatMap(name -> getInitScripts(name).stream())
                .collect(Collectors.toList());
    }

    protected List<ScriptResource> getInitScripts(@Nullable String oneModuleDir) {
        return getScripts(ScriptType.INIT, oneModuleDir);
    }

    protected List<ScriptResource> getUpdateScripts() {
        return getModuleDirs().stream()
                .flatMap(name -> getUpdateScripts(name).stream())
                .collect(Collectors.toList());
    }

    protected List<ScriptResource> getUpdateScripts(@Nullable String oneModuleDir) {
        return getScripts(ScriptType.UPDATE, oneModuleDir);
    }

    // File extension handler
    public interface FileHandler {
        /**
         * @return need mark as executed or not
         */
        boolean run(ScriptResource file);
    }

}