/*
 * Copyright (c) 2008-2016 Haulmont.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */
package com.haulmont.cuba.gui.export;

import com.haulmont.cuba.client.ClientConfig;
import com.haulmont.cuba.core.entity.FileDescriptor;
import com.haulmont.cuba.core.global.*;
import com.haulmont.cuba.core.sys.AppContext;
import com.haulmont.cuba.core.sys.remoting.LocalFileExchangeService;
import com.haulmont.cuba.core.sys.remoting.discovery.ServerSelector;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.conn.HttpClientConnectionManager;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.conn.BasicHttpClientConnectionManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.Nullable;
import java.io.IOException;
import java.io.InputStream;

import static com.haulmont.bali.util.Preconditions.checkNotNullArgument;

/**
 * Data provider for FileDescriptor
 */
public class FileDataProvider implements ExportDataProvider {

    private final Logger log = LoggerFactory.getLogger(FileDataProvider.class);

    protected FileDescriptor fileDescriptor;
    protected InputStream inputStream;

    protected ServerSelector serverSelector = AppBeans.get(ServerSelector.NAME);

    protected UserSessionSource userSessionSource = AppBeans.get(UserSessionSource.NAME);

    protected String fileDownloadContext;

    public FileDataProvider(FileDescriptor fileDescriptor) {
        checkNotNullArgument(fileDescriptor, "Null file descriptor");

        this.fileDescriptor = fileDescriptor;

        Configuration configuration = AppBeans.get(Configuration.NAME);
        fileDownloadContext = configuration.getConfig(ClientConfig.class).getFileDownloadContext();
    }

    @Override
    public InputStream provide() {
        String useLocalInvocation = AppContext.getProperty("cuba.useLocalServiceInvocation");
        if (Boolean.parseBoolean(useLocalInvocation)) {
            downloadLocally();
        } else {
            downloadWithServlet();
        }

        return inputStream;
    }

    protected void downloadLocally() {
        LocalFileExchangeService fileExchangeService = AppBeans.get(LocalFileExchangeService.NAME);
        inputStream = fileExchangeService.downloadFile(fileDescriptor);
    }

    protected void downloadWithServlet() {
        Object context = serverSelector.initContext();
        String selectedUrl = serverSelector.getUrl(context);
        if (selectedUrl == null) {
            throw new RuntimeFileStorageException(
                    "Unable to download file from FileStorage: no available server URLs",
                    new FileStorageException(FileStorageException.Type.IO_EXCEPTION,
                            fileDescriptor.getName())
            );
        }
        while (true) {
            String url = selectedUrl + fileDownloadContext +
                    "?s=" + userSessionSource.getUserSession().getId() +
                    "&f=" + fileDescriptor.getId().toString();

            HttpClientConnectionManager connectionManager = new BasicHttpClientConnectionManager();
            HttpClient httpClient = HttpClientBuilder.create()
                    .setConnectionManager(connectionManager)
                    .build();

            HttpGet httpGet = new HttpGet(url);

            try {
                HttpResponse httpResponse = httpClient.execute(httpGet);
                int httpStatus = httpResponse.getStatusLine().getStatusCode();
                if (httpStatus == HttpStatus.SC_OK) {
                    HttpEntity httpEntity = httpResponse.getEntity();
                    if (httpEntity != null) {
                        inputStream = httpEntity.getContent();
                        break;
                    } else {
                        log.debug("Unable to download file from {}\nHttpEntity is null", url);
                        selectedUrl = failAndGetNextUrl(context);
                        if (selectedUrl == null) {
                            throw new RuntimeFileStorageException(
                                    "Unable to download file from FileStorage",
                                    new FileStorageException(FileStorageException.Type.IO_EXCEPTION,
                                            fileDescriptor.getName())
                            );
                        }
                    }
                } else {
                    log.debug("Unable to download file from {}\n{}", url, httpResponse.getStatusLine());
                    selectedUrl = failAndGetNextUrl(context);
                    if (selectedUrl == null) {
                        throw new RuntimeFileStorageException(
                                "Unable to download file from FileStorage",
                                new FileStorageException(FileStorageException.Type.fromHttpStatus(httpStatus),
                                        fileDescriptor.getName())
                        );
                    }
                }
            } catch (IOException ex) {
                log.debug("Unable to download file from {}\n{}", url, ex);
                selectedUrl = failAndGetNextUrl(context);
                if (selectedUrl == null) {
                    throw new RuntimeFileStorageException(
                            "Unable to download file from FileStorage",
                            new FileStorageException(FileStorageException.Type.IO_EXCEPTION,
                                    fileDescriptor.getName(), ex)
                    );
                }
            }
        }
    }

    @Nullable
    private String failAndGetNextUrl(Object context) {
        serverSelector.fail(context);
        String url = serverSelector.getUrl(context);
        if (url != null)
            log.debug("Trying next URL");
        return url;
    }
}