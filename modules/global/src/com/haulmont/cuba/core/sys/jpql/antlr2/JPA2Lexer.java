// $ANTLR 3.5.2 JPA2.g 2016-02-28 17:29:05

package com.haulmont.cuba.core.sys.jpql.antlr2;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class JPA2Lexer extends Lexer {
	public static final int EOF=-1;
	public static final int T__55=55;
	public static final int T__56=56;
	public static final int T__57=57;
	public static final int T__58=58;
	public static final int T__59=59;
	public static final int T__60=60;
	public static final int T__61=61;
	public static final int T__62=62;
	public static final int T__63=63;
	public static final int T__64=64;
	public static final int T__65=65;
	public static final int T__66=66;
	public static final int T__67=67;
	public static final int T__68=68;
	public static final int T__69=69;
	public static final int T__70=70;
	public static final int T__71=71;
	public static final int T__72=72;
	public static final int T__73=73;
	public static final int T__74=74;
	public static final int T__75=75;
	public static final int T__76=76;
	public static final int T__77=77;
	public static final int T__78=78;
	public static final int T__79=79;
	public static final int T__80=80;
	public static final int T__81=81;
	public static final int T__82=82;
	public static final int T__83=83;
	public static final int T__84=84;
	public static final int T__85=85;
	public static final int T__86=86;
	public static final int T__87=87;
	public static final int T__88=88;
	public static final int T__89=89;
	public static final int T__90=90;
	public static final int T__91=91;
	public static final int T__92=92;
	public static final int T__93=93;
	public static final int T__94=94;
	public static final int T__95=95;
	public static final int T__96=96;
	public static final int T__97=97;
	public static final int T__98=98;
	public static final int T__99=99;
	public static final int T__100=100;
	public static final int T__101=101;
	public static final int T__102=102;
	public static final int T__103=103;
	public static final int T__104=104;
	public static final int T__105=105;
	public static final int T__106=106;
	public static final int T__107=107;
	public static final int T__108=108;
	public static final int T__109=109;
	public static final int T__110=110;
	public static final int T__111=111;
	public static final int T__112=112;
	public static final int T__113=113;
	public static final int T__114=114;
	public static final int T__115=115;
	public static final int T__116=116;
	public static final int T__117=117;
	public static final int T__118=118;
	public static final int T__119=119;
	public static final int T__120=120;
	public static final int T__121=121;
	public static final int T__122=122;
	public static final int T__123=123;
	public static final int T__124=124;
	public static final int T__125=125;
	public static final int T__126=126;
	public static final int T__127=127;
	public static final int T__128=128;
	public static final int T__129=129;
	public static final int T__130=130;
	public static final int T__131=131;
	public static final int T__132=132;
	public static final int T__133=133;
	public static final int T__134=134;
	public static final int T__135=135;
	public static final int T__136=136;
	public static final int AND=4;
	public static final int ASC=5;
	public static final int AVG=6;
	public static final int BY=7;
	public static final int COMMENT=8;
	public static final int COUNT=9;
	public static final int DESC=10;
	public static final int DISTINCT=11;
	public static final int ESCAPE_CHARACTER=12;
	public static final int FETCH=13;
	public static final int GROUP=14;
	public static final int HAVING=15;
	public static final int IN=16;
	public static final int INNER=17;
	public static final int INT_NUMERAL=18;
	public static final int JOIN=19;
	public static final int LEFT=20;
	public static final int LINE_COMMENT=21;
	public static final int LOWER=22;
	public static final int LPAREN=23;
	public static final int MAX=24;
	public static final int MIN=25;
	public static final int NAMED_PARAMETER=26;
	public static final int NOT=27;
	public static final int OR=28;
	public static final int ORDER=29;
	public static final int OUTER=30;
	public static final int RPAREN=31;
	public static final int RUSSIAN_SYMBOLS=32;
	public static final int STRING_LITERAL=33;
	public static final int SUM=34;
	public static final int TRIM_CHARACTER=35;
	public static final int T_AGGREGATE_EXPR=36;
	public static final int T_COLLECTION_MEMBER=37;
	public static final int T_CONDITION=38;
	public static final int T_GROUP_BY=39;
	public static final int T_ID_VAR=40;
	public static final int T_JOIN_VAR=41;
	public static final int T_ORDER_BY=42;
	public static final int T_ORDER_BY_FIELD=43;
	public static final int T_PARAMETER=44;
	public static final int T_QUERY=45;
	public static final int T_SELECTED_ENTITY=46;
	public static final int T_SELECTED_FIELD=47;
	public static final int T_SELECTED_ITEM=48;
	public static final int T_SELECTED_ITEMS=49;
	public static final int T_SIMPLE_CONDITION=50;
	public static final int T_SOURCE=51;
	public static final int T_SOURCES=52;
	public static final int WORD=53;
	public static final int WS=54;

	// delegates
	// delegators
	public Lexer[] getDelegates() {
		return new Lexer[] {};
	}

	public JPA2Lexer() {} 
	public JPA2Lexer(CharStream input) {
		this(input, new RecognizerSharedState());
	}
	public JPA2Lexer(CharStream input, RecognizerSharedState state) {
		super(input,state);
	}
	@Override public String getGrammarFileName() { return "JPA2.g"; }

	// $ANTLR start "AND"
	public final void mAND() throws RecognitionException {
		try {
			int _type = AND;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// JPA2.g:7:5: ( 'AND' )
			// JPA2.g:7:7: 'AND'
			{
			match("AND"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "AND"

	// $ANTLR start "ASC"
	public final void mASC() throws RecognitionException {
		try {
			int _type = ASC;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// JPA2.g:8:5: ( 'ASC' )
			// JPA2.g:8:7: 'ASC'
			{
			match("ASC"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "ASC"

	// $ANTLR start "AVG"
	public final void mAVG() throws RecognitionException {
		try {
			int _type = AVG;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// JPA2.g:9:5: ( 'AVG' )
			// JPA2.g:9:7: 'AVG'
			{
			match("AVG"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "AVG"

	// $ANTLR start "BY"
	public final void mBY() throws RecognitionException {
		try {
			int _type = BY;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// JPA2.g:10:4: ( 'BY' )
			// JPA2.g:10:6: 'BY'
			{
			match("BY"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "BY"

	// $ANTLR start "COUNT"
	public final void mCOUNT() throws RecognitionException {
		try {
			int _type = COUNT;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// JPA2.g:11:7: ( 'COUNT' )
			// JPA2.g:11:9: 'COUNT'
			{
			match("COUNT"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "COUNT"

	// $ANTLR start "DESC"
	public final void mDESC() throws RecognitionException {
		try {
			int _type = DESC;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// JPA2.g:12:6: ( 'DESC' )
			// JPA2.g:12:8: 'DESC'
			{
			match("DESC"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "DESC"

	// $ANTLR start "DISTINCT"
	public final void mDISTINCT() throws RecognitionException {
		try {
			int _type = DISTINCT;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// JPA2.g:13:10: ( 'DISTINCT' )
			// JPA2.g:13:12: 'DISTINCT'
			{
			match("DISTINCT"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "DISTINCT"

	// $ANTLR start "FETCH"
	public final void mFETCH() throws RecognitionException {
		try {
			int _type = FETCH;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// JPA2.g:14:7: ( 'FETCH' )
			// JPA2.g:14:9: 'FETCH'
			{
			match("FETCH"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "FETCH"

	// $ANTLR start "GROUP"
	public final void mGROUP() throws RecognitionException {
		try {
			int _type = GROUP;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// JPA2.g:15:7: ( 'GROUP' )
			// JPA2.g:15:9: 'GROUP'
			{
			match("GROUP"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "GROUP"

	// $ANTLR start "HAVING"
	public final void mHAVING() throws RecognitionException {
		try {
			int _type = HAVING;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// JPA2.g:16:8: ( 'HAVING' )
			// JPA2.g:16:10: 'HAVING'
			{
			match("HAVING"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "HAVING"

	// $ANTLR start "INNER"
	public final void mINNER() throws RecognitionException {
		try {
			int _type = INNER;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// JPA2.g:17:7: ( 'INNER' )
			// JPA2.g:17:9: 'INNER'
			{
			match("INNER"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "INNER"

	// $ANTLR start "JOIN"
	public final void mJOIN() throws RecognitionException {
		try {
			int _type = JOIN;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// JPA2.g:18:6: ( 'JOIN' )
			// JPA2.g:18:8: 'JOIN'
			{
			match("JOIN"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "JOIN"

	// $ANTLR start "LEFT"
	public final void mLEFT() throws RecognitionException {
		try {
			int _type = LEFT;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// JPA2.g:19:6: ( 'LEFT' )
			// JPA2.g:19:8: 'LEFT'
			{
			match("LEFT"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "LEFT"

	// $ANTLR start "LOWER"
	public final void mLOWER() throws RecognitionException {
		try {
			int _type = LOWER;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// JPA2.g:20:7: ( 'LOWER' )
			// JPA2.g:20:9: 'LOWER'
			{
			match("LOWER"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "LOWER"

	// $ANTLR start "LPAREN"
	public final void mLPAREN() throws RecognitionException {
		try {
			int _type = LPAREN;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// JPA2.g:21:8: ( '(' )
			// JPA2.g:21:10: '('
			{
			match('('); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "LPAREN"

	// $ANTLR start "MAX"
	public final void mMAX() throws RecognitionException {
		try {
			int _type = MAX;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// JPA2.g:22:5: ( 'MAX' )
			// JPA2.g:22:7: 'MAX'
			{
			match("MAX"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "MAX"

	// $ANTLR start "MIN"
	public final void mMIN() throws RecognitionException {
		try {
			int _type = MIN;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// JPA2.g:23:5: ( 'MIN' )
			// JPA2.g:23:7: 'MIN'
			{
			match("MIN"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "MIN"

	// $ANTLR start "OR"
	public final void mOR() throws RecognitionException {
		try {
			int _type = OR;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// JPA2.g:24:4: ( 'OR' )
			// JPA2.g:24:6: 'OR'
			{
			match("OR"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "OR"

	// $ANTLR start "ORDER"
	public final void mORDER() throws RecognitionException {
		try {
			int _type = ORDER;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// JPA2.g:25:7: ( 'ORDER' )
			// JPA2.g:25:9: 'ORDER'
			{
			match("ORDER"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "ORDER"

	// $ANTLR start "OUTER"
	public final void mOUTER() throws RecognitionException {
		try {
			int _type = OUTER;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// JPA2.g:26:7: ( 'OUTER' )
			// JPA2.g:26:9: 'OUTER'
			{
			match("OUTER"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "OUTER"

	// $ANTLR start "RPAREN"
	public final void mRPAREN() throws RecognitionException {
		try {
			int _type = RPAREN;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// JPA2.g:27:8: ( ')' )
			// JPA2.g:27:10: ')'
			{
			match(')'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "RPAREN"

	// $ANTLR start "SUM"
	public final void mSUM() throws RecognitionException {
		try {
			int _type = SUM;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// JPA2.g:28:5: ( 'SUM' )
			// JPA2.g:28:7: 'SUM'
			{
			match("SUM"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "SUM"

	// $ANTLR start "T__55"
	public final void mT__55() throws RecognitionException {
		try {
			int _type = T__55;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// JPA2.g:29:7: ( '${' )
			// JPA2.g:29:9: '${'
			{
			match("${"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__55"

	// $ANTLR start "T__56"
	public final void mT__56() throws RecognitionException {
		try {
			int _type = T__56;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// JPA2.g:30:7: ( '*' )
			// JPA2.g:30:9: '*'
			{
			match('*'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__56"

	// $ANTLR start "T__57"
	public final void mT__57() throws RecognitionException {
		try {
			int _type = T__57;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// JPA2.g:31:7: ( '+' )
			// JPA2.g:31:9: '+'
			{
			match('+'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__57"

	// $ANTLR start "T__58"
	public final void mT__58() throws RecognitionException {
		try {
			int _type = T__58;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// JPA2.g:32:7: ( ',' )
			// JPA2.g:32:9: ','
			{
			match(','); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__58"

	// $ANTLR start "T__59"
	public final void mT__59() throws RecognitionException {
		try {
			int _type = T__59;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// JPA2.g:33:7: ( '-' )
			// JPA2.g:33:9: '-'
			{
			match('-'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__59"

	// $ANTLR start "T__60"
	public final void mT__60() throws RecognitionException {
		try {
			int _type = T__60;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// JPA2.g:34:7: ( '.' )
			// JPA2.g:34:9: '.'
			{
			match('.'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__60"

	// $ANTLR start "T__61"
	public final void mT__61() throws RecognitionException {
		try {
			int _type = T__61;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// JPA2.g:35:7: ( '/' )
			// JPA2.g:35:9: '/'
			{
			match('/'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__61"

	// $ANTLR start "T__62"
	public final void mT__62() throws RecognitionException {
		try {
			int _type = T__62;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// JPA2.g:36:7: ( '0x' )
			// JPA2.g:36:9: '0x'
			{
			match("0x"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__62"

	// $ANTLR start "T__63"
	public final void mT__63() throws RecognitionException {
		try {
			int _type = T__63;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// JPA2.g:37:7: ( '<' )
			// JPA2.g:37:9: '<'
			{
			match('<'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__63"

	// $ANTLR start "T__64"
	public final void mT__64() throws RecognitionException {
		try {
			int _type = T__64;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// JPA2.g:38:7: ( '<=' )
			// JPA2.g:38:9: '<='
			{
			match("<="); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__64"

	// $ANTLR start "T__65"
	public final void mT__65() throws RecognitionException {
		try {
			int _type = T__65;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// JPA2.g:39:7: ( '<>' )
			// JPA2.g:39:9: '<>'
			{
			match("<>"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__65"

	// $ANTLR start "T__66"
	public final void mT__66() throws RecognitionException {
		try {
			int _type = T__66;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// JPA2.g:40:7: ( '=' )
			// JPA2.g:40:9: '='
			{
			match('='); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__66"

	// $ANTLR start "T__67"
	public final void mT__67() throws RecognitionException {
		try {
			int _type = T__67;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// JPA2.g:41:7: ( '>' )
			// JPA2.g:41:9: '>'
			{
			match('>'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__67"

	// $ANTLR start "T__68"
	public final void mT__68() throws RecognitionException {
		try {
			int _type = T__68;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// JPA2.g:42:7: ( '>=' )
			// JPA2.g:42:9: '>='
			{
			match(">="); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__68"

	// $ANTLR start "T__69"
	public final void mT__69() throws RecognitionException {
		try {
			int _type = T__69;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// JPA2.g:43:7: ( '?' )
			// JPA2.g:43:9: '?'
			{
			match('?'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__69"

	// $ANTLR start "T__70"
	public final void mT__70() throws RecognitionException {
		try {
			int _type = T__70;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// JPA2.g:44:7: ( '@BETWEEN' )
			// JPA2.g:44:9: '@BETWEEN'
			{
			match("@BETWEEN"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__70"

	// $ANTLR start "T__71"
	public final void mT__71() throws RecognitionException {
		try {
			int _type = T__71;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// JPA2.g:45:7: ( '@DATEAFTER' )
			// JPA2.g:45:9: '@DATEAFTER'
			{
			match("@DATEAFTER"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__71"

	// $ANTLR start "T__72"
	public final void mT__72() throws RecognitionException {
		try {
			int _type = T__72;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// JPA2.g:46:7: ( '@DATEBEFORE' )
			// JPA2.g:46:9: '@DATEBEFORE'
			{
			match("@DATEBEFORE"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__72"

	// $ANTLR start "T__73"
	public final void mT__73() throws RecognitionException {
		try {
			int _type = T__73;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// JPA2.g:47:7: ( '@DATEEQUALS' )
			// JPA2.g:47:9: '@DATEEQUALS'
			{
			match("@DATEEQUALS"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__73"

	// $ANTLR start "T__74"
	public final void mT__74() throws RecognitionException {
		try {
			int _type = T__74;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// JPA2.g:48:7: ( '@TODAY' )
			// JPA2.g:48:9: '@TODAY'
			{
			match("@TODAY"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__74"

	// $ANTLR start "T__75"
	public final void mT__75() throws RecognitionException {
		try {
			int _type = T__75;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// JPA2.g:49:7: ( 'ABS(' )
			// JPA2.g:49:9: 'ABS('
			{
			match("ABS("); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__75"

	// $ANTLR start "T__76"
	public final void mT__76() throws RecognitionException {
		try {
			int _type = T__76;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// JPA2.g:50:7: ( 'ALL' )
			// JPA2.g:50:9: 'ALL'
			{
			match("ALL"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__76"

	// $ANTLR start "T__77"
	public final void mT__77() throws RecognitionException {
		try {
			int _type = T__77;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// JPA2.g:51:7: ( 'ANY' )
			// JPA2.g:51:9: 'ANY'
			{
			match("ANY"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__77"

	// $ANTLR start "T__78"
	public final void mT__78() throws RecognitionException {
		try {
			int _type = T__78;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// JPA2.g:52:7: ( 'AS' )
			// JPA2.g:52:9: 'AS'
			{
			match("AS"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__78"

	// $ANTLR start "T__79"
	public final void mT__79() throws RecognitionException {
		try {
			int _type = T__79;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// JPA2.g:53:7: ( 'BETWEEN' )
			// JPA2.g:53:9: 'BETWEEN'
			{
			match("BETWEEN"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__79"

	// $ANTLR start "T__80"
	public final void mT__80() throws RecognitionException {
		try {
			int _type = T__80;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// JPA2.g:54:7: ( 'BOTH' )
			// JPA2.g:54:9: 'BOTH'
			{
			match("BOTH"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__80"

	// $ANTLR start "T__81"
	public final void mT__81() throws RecognitionException {
		try {
			int _type = T__81;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// JPA2.g:55:7: ( 'CASE' )
			// JPA2.g:55:9: 'CASE'
			{
			match("CASE"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__81"

	// $ANTLR start "T__82"
	public final void mT__82() throws RecognitionException {
		try {
			int _type = T__82;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// JPA2.g:56:7: ( 'COALESCE(' )
			// JPA2.g:56:9: 'COALESCE('
			{
			match("COALESCE("); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__82"

	// $ANTLR start "T__83"
	public final void mT__83() throws RecognitionException {
		try {
			int _type = T__83;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// JPA2.g:57:7: ( 'CONCAT(' )
			// JPA2.g:57:9: 'CONCAT('
			{
			match("CONCAT("); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__83"

	// $ANTLR start "T__84"
	public final void mT__84() throws RecognitionException {
		try {
			int _type = T__84;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// JPA2.g:58:7: ( 'CURRENT_DATE' )
			// JPA2.g:58:9: 'CURRENT_DATE'
			{
			match("CURRENT_DATE"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__84"

	// $ANTLR start "T__85"
	public final void mT__85() throws RecognitionException {
		try {
			int _type = T__85;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// JPA2.g:59:7: ( 'CURRENT_TIME' )
			// JPA2.g:59:9: 'CURRENT_TIME'
			{
			match("CURRENT_TIME"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__85"

	// $ANTLR start "T__86"
	public final void mT__86() throws RecognitionException {
		try {
			int _type = T__86;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// JPA2.g:60:7: ( 'CURRENT_TIMESTAMP' )
			// JPA2.g:60:9: 'CURRENT_TIMESTAMP'
			{
			match("CURRENT_TIMESTAMP"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__86"

	// $ANTLR start "T__87"
	public final void mT__87() throws RecognitionException {
		try {
			int _type = T__87;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// JPA2.g:61:7: ( 'DAY' )
			// JPA2.g:61:9: 'DAY'
			{
			match("DAY"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__87"

	// $ANTLR start "T__88"
	public final void mT__88() throws RecognitionException {
		try {
			int _type = T__88;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// JPA2.g:62:7: ( 'DELETE' )
			// JPA2.g:62:9: 'DELETE'
			{
			match("DELETE"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__88"

	// $ANTLR start "T__89"
	public final void mT__89() throws RecognitionException {
		try {
			int _type = T__89;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// JPA2.g:63:7: ( 'ELSE' )
			// JPA2.g:63:9: 'ELSE'
			{
			match("ELSE"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__89"

	// $ANTLR start "T__90"
	public final void mT__90() throws RecognitionException {
		try {
			int _type = T__90;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// JPA2.g:64:7: ( 'EMPTY' )
			// JPA2.g:64:9: 'EMPTY'
			{
			match("EMPTY"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__90"

	// $ANTLR start "T__91"
	public final void mT__91() throws RecognitionException {
		try {
			int _type = T__91;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// JPA2.g:65:7: ( 'END' )
			// JPA2.g:65:9: 'END'
			{
			match("END"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__91"

	// $ANTLR start "T__92"
	public final void mT__92() throws RecognitionException {
		try {
			int _type = T__92;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// JPA2.g:66:7: ( 'ENTRY(' )
			// JPA2.g:66:9: 'ENTRY('
			{
			match("ENTRY("); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__92"

	// $ANTLR start "T__93"
	public final void mT__93() throws RecognitionException {
		try {
			int _type = T__93;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// JPA2.g:67:7: ( 'ESCAPE' )
			// JPA2.g:67:9: 'ESCAPE'
			{
			match("ESCAPE"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__93"

	// $ANTLR start "T__94"
	public final void mT__94() throws RecognitionException {
		try {
			int _type = T__94;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// JPA2.g:68:7: ( 'EXISTS' )
			// JPA2.g:68:9: 'EXISTS'
			{
			match("EXISTS"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__94"

	// $ANTLR start "T__95"
	public final void mT__95() throws RecognitionException {
		try {
			int _type = T__95;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// JPA2.g:69:7: ( 'FROM' )
			// JPA2.g:69:9: 'FROM'
			{
			match("FROM"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__95"

	// $ANTLR start "T__96"
	public final void mT__96() throws RecognitionException {
		try {
			int _type = T__96;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// JPA2.g:70:7: ( 'FUNCTION(' )
			// JPA2.g:70:9: 'FUNCTION('
			{
			match("FUNCTION("); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__96"

	// $ANTLR start "T__97"
	public final void mT__97() throws RecognitionException {
		try {
			int _type = T__97;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// JPA2.g:71:7: ( 'HOUR' )
			// JPA2.g:71:9: 'HOUR'
			{
			match("HOUR"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__97"

	// $ANTLR start "T__98"
	public final void mT__98() throws RecognitionException {
		try {
			int _type = T__98;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// JPA2.g:72:7: ( 'INDEX(' )
			// JPA2.g:72:9: 'INDEX('
			{
			match("INDEX("); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__98"

	// $ANTLR start "T__99"
	public final void mT__99() throws RecognitionException {
		try {
			int _type = T__99;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// JPA2.g:73:7: ( 'IS' )
			// JPA2.g:73:9: 'IS'
			{
			match("IS"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__99"

	// $ANTLR start "T__100"
	public final void mT__100() throws RecognitionException {
		try {
			int _type = T__100;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// JPA2.g:74:8: ( 'KEY(' )
			// JPA2.g:74:10: 'KEY('
			{
			match("KEY("); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__100"

	// $ANTLR start "T__101"
	public final void mT__101() throws RecognitionException {
		try {
			int _type = T__101;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// JPA2.g:75:8: ( 'LEADING' )
			// JPA2.g:75:10: 'LEADING'
			{
			match("LEADING"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__101"

	// $ANTLR start "T__102"
	public final void mT__102() throws RecognitionException {
		try {
			int _type = T__102;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// JPA2.g:76:8: ( 'LENGTH(' )
			// JPA2.g:76:10: 'LENGTH('
			{
			match("LENGTH("); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__102"

	// $ANTLR start "T__103"
	public final void mT__103() throws RecognitionException {
		try {
			int _type = T__103;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// JPA2.g:77:8: ( 'LIKE' )
			// JPA2.g:77:10: 'LIKE'
			{
			match("LIKE"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__103"

	// $ANTLR start "T__104"
	public final void mT__104() throws RecognitionException {
		try {
			int _type = T__104;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// JPA2.g:78:8: ( 'LOCATE(' )
			// JPA2.g:78:10: 'LOCATE('
			{
			match("LOCATE("); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__104"

	// $ANTLR start "T__105"
	public final void mT__105() throws RecognitionException {
		try {
			int _type = T__105;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// JPA2.g:79:8: ( 'MEMBER' )
			// JPA2.g:79:10: 'MEMBER'
			{
			match("MEMBER"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__105"

	// $ANTLR start "T__106"
	public final void mT__106() throws RecognitionException {
		try {
			int _type = T__106;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// JPA2.g:80:8: ( 'MINUTE' )
			// JPA2.g:80:10: 'MINUTE'
			{
			match("MINUTE"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__106"

	// $ANTLR start "T__107"
	public final void mT__107() throws RecognitionException {
		try {
			int _type = T__107;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// JPA2.g:81:8: ( 'MOD(' )
			// JPA2.g:81:10: 'MOD('
			{
			match("MOD("); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__107"

	// $ANTLR start "T__108"
	public final void mT__108() throws RecognitionException {
		try {
			int _type = T__108;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// JPA2.g:82:8: ( 'MONTH' )
			// JPA2.g:82:10: 'MONTH'
			{
			match("MONTH"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__108"

	// $ANTLR start "T__109"
	public final void mT__109() throws RecognitionException {
		try {
			int _type = T__109;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// JPA2.g:83:8: ( 'NEW' )
			// JPA2.g:83:10: 'NEW'
			{
			match("NEW"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__109"

	// $ANTLR start "T__110"
	public final void mT__110() throws RecognitionException {
		try {
			int _type = T__110;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// JPA2.g:84:8: ( 'NOW' )
			// JPA2.g:84:10: 'NOW'
			{
			match("NOW"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__110"

	// $ANTLR start "T__111"
	public final void mT__111() throws RecognitionException {
		try {
			int _type = T__111;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// JPA2.g:85:8: ( 'NULL' )
			// JPA2.g:85:10: 'NULL'
			{
			match("NULL"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__111"

	// $ANTLR start "T__112"
	public final void mT__112() throws RecognitionException {
		try {
			int _type = T__112;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// JPA2.g:86:8: ( 'NULLIF(' )
			// JPA2.g:86:10: 'NULLIF('
			{
			match("NULLIF("); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__112"

	// $ANTLR start "T__113"
	public final void mT__113() throws RecognitionException {
		try {
			int _type = T__113;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// JPA2.g:87:8: ( 'OBJECT' )
			// JPA2.g:87:10: 'OBJECT'
			{
			match("OBJECT"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__113"

	// $ANTLR start "T__114"
	public final void mT__114() throws RecognitionException {
		try {
			int _type = T__114;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// JPA2.g:88:8: ( 'OF' )
			// JPA2.g:88:10: 'OF'
			{
			match("OF"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__114"

	// $ANTLR start "T__115"
	public final void mT__115() throws RecognitionException {
		try {
			int _type = T__115;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// JPA2.g:89:8: ( 'ON' )
			// JPA2.g:89:10: 'ON'
			{
			match("ON"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__115"

	// $ANTLR start "T__116"
	public final void mT__116() throws RecognitionException {
		try {
			int _type = T__116;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// JPA2.g:90:8: ( 'SECOND' )
			// JPA2.g:90:10: 'SECOND'
			{
			match("SECOND"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__116"

	// $ANTLR start "T__117"
	public final void mT__117() throws RecognitionException {
		try {
			int _type = T__117;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// JPA2.g:91:8: ( 'SELECT' )
			// JPA2.g:91:10: 'SELECT'
			{
			match("SELECT"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__117"

	// $ANTLR start "T__118"
	public final void mT__118() throws RecognitionException {
		try {
			int _type = T__118;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// JPA2.g:92:8: ( 'SET' )
			// JPA2.g:92:10: 'SET'
			{
			match("SET"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__118"

	// $ANTLR start "T__119"
	public final void mT__119() throws RecognitionException {
		try {
			int _type = T__119;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// JPA2.g:93:8: ( 'SIZE(' )
			// JPA2.g:93:10: 'SIZE('
			{
			match("SIZE("); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__119"

	// $ANTLR start "T__120"
	public final void mT__120() throws RecognitionException {
		try {
			int _type = T__120;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// JPA2.g:94:8: ( 'SOME' )
			// JPA2.g:94:10: 'SOME'
			{
			match("SOME"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__120"

	// $ANTLR start "T__121"
	public final void mT__121() throws RecognitionException {
		try {
			int _type = T__121;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// JPA2.g:95:8: ( 'SQRT(' )
			// JPA2.g:95:10: 'SQRT('
			{
			match("SQRT("); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__121"

	// $ANTLR start "T__122"
	public final void mT__122() throws RecognitionException {
		try {
			int _type = T__122;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// JPA2.g:96:8: ( 'SUBSTRING(' )
			// JPA2.g:96:10: 'SUBSTRING('
			{
			match("SUBSTRING("); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__122"

	// $ANTLR start "T__123"
	public final void mT__123() throws RecognitionException {
		try {
			int _type = T__123;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// JPA2.g:97:8: ( 'THEN' )
			// JPA2.g:97:10: 'THEN'
			{
			match("THEN"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__123"

	// $ANTLR start "T__124"
	public final void mT__124() throws RecognitionException {
		try {
			int _type = T__124;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// JPA2.g:98:8: ( 'TRAILING' )
			// JPA2.g:98:10: 'TRAILING'
			{
			match("TRAILING"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__124"

	// $ANTLR start "T__125"
	public final void mT__125() throws RecognitionException {
		try {
			int _type = T__125;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// JPA2.g:99:8: ( 'TREAT(' )
			// JPA2.g:99:10: 'TREAT('
			{
			match("TREAT("); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__125"

	// $ANTLR start "T__126"
	public final void mT__126() throws RecognitionException {
		try {
			int _type = T__126;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// JPA2.g:100:8: ( 'TRIM(' )
			// JPA2.g:100:10: 'TRIM('
			{
			match("TRIM("); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__126"

	// $ANTLR start "T__127"
	public final void mT__127() throws RecognitionException {
		try {
			int _type = T__127;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// JPA2.g:101:8: ( 'TYPE(' )
			// JPA2.g:101:10: 'TYPE('
			{
			match("TYPE("); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__127"

	// $ANTLR start "T__128"
	public final void mT__128() throws RecognitionException {
		try {
			int _type = T__128;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// JPA2.g:102:8: ( 'UPDATE' )
			// JPA2.g:102:10: 'UPDATE'
			{
			match("UPDATE"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__128"

	// $ANTLR start "T__129"
	public final void mT__129() throws RecognitionException {
		try {
			int _type = T__129;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// JPA2.g:103:8: ( 'UPPER(' )
			// JPA2.g:103:10: 'UPPER('
			{
			match("UPPER("); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__129"

	// $ANTLR start "T__130"
	public final void mT__130() throws RecognitionException {
		try {
			int _type = T__130;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// JPA2.g:104:8: ( 'VALUE(' )
			// JPA2.g:104:10: 'VALUE('
			{
			match("VALUE("); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__130"

	// $ANTLR start "T__131"
	public final void mT__131() throws RecognitionException {
		try {
			int _type = T__131;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// JPA2.g:105:8: ( 'WHEN' )
			// JPA2.g:105:10: 'WHEN'
			{
			match("WHEN"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__131"

	// $ANTLR start "T__132"
	public final void mT__132() throws RecognitionException {
		try {
			int _type = T__132;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// JPA2.g:106:8: ( 'WHERE' )
			// JPA2.g:106:10: 'WHERE'
			{
			match("WHERE"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__132"

	// $ANTLR start "T__133"
	public final void mT__133() throws RecognitionException {
		try {
			int _type = T__133;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// JPA2.g:107:8: ( 'YEAR' )
			// JPA2.g:107:10: 'YEAR'
			{
			match("YEAR"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__133"

	// $ANTLR start "T__134"
	public final void mT__134() throws RecognitionException {
		try {
			int _type = T__134;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// JPA2.g:108:8: ( 'false' )
			// JPA2.g:108:10: 'false'
			{
			match("false"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__134"

	// $ANTLR start "T__135"
	public final void mT__135() throws RecognitionException {
		try {
			int _type = T__135;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// JPA2.g:109:8: ( 'true' )
			// JPA2.g:109:10: 'true'
			{
			match("true"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__135"

	// $ANTLR start "T__136"
	public final void mT__136() throws RecognitionException {
		try {
			int _type = T__136;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// JPA2.g:110:8: ( '}' )
			// JPA2.g:110:10: '}'
			{
			match('}'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__136"

	// $ANTLR start "NOT"
	public final void mNOT() throws RecognitionException {
		try {
			int _type = NOT;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// JPA2.g:305:4: ( 'NOT' )
			// JPA2.g:305:6: 'NOT'
			{
			match("NOT"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "NOT"

	// $ANTLR start "IN"
	public final void mIN() throws RecognitionException {
		try {
			int _type = IN;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// JPA2.g:307:3: ( 'IN' )
			// JPA2.g:307:5: 'IN'
			{
			match("IN"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "IN"

	// $ANTLR start "TRIM_CHARACTER"
	public final void mTRIM_CHARACTER() throws RecognitionException {
		try {
			int _type = TRIM_CHARACTER;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// JPA2.g:526:5: ( '\\'.\\'' )
			// JPA2.g:526:7: '\\'.\\''
			{
			match("'.'"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "TRIM_CHARACTER"

	// $ANTLR start "STRING_LITERAL"
	public final void mSTRING_LITERAL() throws RecognitionException {
		try {
			int _type = STRING_LITERAL;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// JPA2.g:529:5: ( '\\'' (~ ( '\\'' | '\"' ) )* '\\'' )
			// JPA2.g:529:7: '\\'' (~ ( '\\'' | '\"' ) )* '\\''
			{
			match('\''); 
			// JPA2.g:529:12: (~ ( '\\'' | '\"' ) )*
			loop1:
			while (true) {
				int alt1=2;
				int LA1_0 = input.LA(1);
				if ( ((LA1_0 >= '\u0000' && LA1_0 <= '!')||(LA1_0 >= '#' && LA1_0 <= '&')||(LA1_0 >= '(' && LA1_0 <= '\uFFFF')) ) {
					alt1=1;
				}

				switch (alt1) {
				case 1 :
					// JPA2.g:
					{
					if ( (input.LA(1) >= '\u0000' && input.LA(1) <= '!')||(input.LA(1) >= '#' && input.LA(1) <= '&')||(input.LA(1) >= '(' && input.LA(1) <= '\uFFFF') ) {
						input.consume();
					}
					else {
						MismatchedSetException mse = new MismatchedSetException(null,input);
						recover(mse);
						throw mse;
					}
					}
					break;

				default :
					break loop1;
				}
			}

			match('\''); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "STRING_LITERAL"

	// $ANTLR start "WORD"
	public final void mWORD() throws RecognitionException {
		try {
			int _type = WORD;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// JPA2.g:532:5: ( ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' | '$' )* )
			// JPA2.g:532:7: ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' | '$' )*
			{
			if ( (input.LA(1) >= 'A' && input.LA(1) <= 'Z')||input.LA(1)=='_'||(input.LA(1) >= 'a' && input.LA(1) <= 'z') ) {
				input.consume();
			}
			else {
				MismatchedSetException mse = new MismatchedSetException(null,input);
				recover(mse);
				throw mse;
			}
			// JPA2.g:532:31: ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' | '$' )*
			loop2:
			while (true) {
				int alt2=2;
				int LA2_0 = input.LA(1);
				if ( (LA2_0=='$'||(LA2_0 >= '0' && LA2_0 <= '9')||(LA2_0 >= 'A' && LA2_0 <= 'Z')||LA2_0=='_'||(LA2_0 >= 'a' && LA2_0 <= 'z')) ) {
					alt2=1;
				}

				switch (alt2) {
				case 1 :
					// JPA2.g:
					{
					if ( input.LA(1)=='$'||(input.LA(1) >= '0' && input.LA(1) <= '9')||(input.LA(1) >= 'A' && input.LA(1) <= 'Z')||input.LA(1)=='_'||(input.LA(1) >= 'a' && input.LA(1) <= 'z') ) {
						input.consume();
					}
					else {
						MismatchedSetException mse = new MismatchedSetException(null,input);
						recover(mse);
						throw mse;
					}
					}
					break;

				default :
					break loop2;
				}
			}

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "WORD"

	// $ANTLR start "RUSSIAN_SYMBOLS"
	public final void mRUSSIAN_SYMBOLS() throws RecognitionException {
		try {
			int _type = RUSSIAN_SYMBOLS;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// JPA2.g:535:5: ( ( '\\u0400' .. '\\u04FF' | '\\u0500' .. '\\u052F' ) )
			// JPA2.g:535:7: ( '\\u0400' .. '\\u04FF' | '\\u0500' .. '\\u052F' )
			{
			if ( (input.LA(1) >= '\u0400' && input.LA(1) <= '\u052F') ) {
				input.consume();
			}
			else {
				MismatchedSetException mse = new MismatchedSetException(null,input);
				recover(mse);
				throw mse;
			}
			if ( 1 == 1) throw new IllegalArgumentException("Incorrect symbol");
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "RUSSIAN_SYMBOLS"

	// $ANTLR start "NAMED_PARAMETER"
	public final void mNAMED_PARAMETER() throws RecognitionException {
		try {
			int _type = NAMED_PARAMETER;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// JPA2.g:538:5: ( ':' ( '(?i)' | '(?I)' )? ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' | '$' )* ( ( '.' ) ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' | '$' )+ )* )
			// JPA2.g:538:7: ':' ( '(?i)' | '(?I)' )? ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' | '$' )* ( ( '.' ) ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' | '$' )+ )*
			{
			match(':'); 
			// JPA2.g:538:11: ( '(?i)' | '(?I)' )?
			int alt3=3;
			int LA3_0 = input.LA(1);
			if ( (LA3_0=='(') ) {
				int LA3_1 = input.LA(2);
				if ( (LA3_1=='?') ) {
					int LA3_3 = input.LA(3);
					if ( (LA3_3=='i') ) {
						alt3=1;
					}
					else if ( (LA3_3=='I') ) {
						alt3=2;
					}
				}
			}
			switch (alt3) {
				case 1 :
					// JPA2.g:538:12: '(?i)'
					{
					match("(?i)"); 

					}
					break;
				case 2 :
					// JPA2.g:538:19: '(?I)'
					{
					match("(?I)"); 

					}
					break;

			}

			if ( (input.LA(1) >= 'A' && input.LA(1) <= 'Z')||input.LA(1)=='_'||(input.LA(1) >= 'a' && input.LA(1) <= 'z') ) {
				input.consume();
			}
			else {
				MismatchedSetException mse = new MismatchedSetException(null,input);
				recover(mse);
				throw mse;
			}
			// JPA2.g:538:52: ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' | '$' )*
			loop4:
			while (true) {
				int alt4=2;
				int LA4_0 = input.LA(1);
				if ( (LA4_0=='$'||(LA4_0 >= '0' && LA4_0 <= '9')||(LA4_0 >= 'A' && LA4_0 <= 'Z')||LA4_0=='_'||(LA4_0 >= 'a' && LA4_0 <= 'z')) ) {
					alt4=1;
				}

				switch (alt4) {
				case 1 :
					// JPA2.g:
					{
					if ( input.LA(1)=='$'||(input.LA(1) >= '0' && input.LA(1) <= '9')||(input.LA(1) >= 'A' && input.LA(1) <= 'Z')||input.LA(1)=='_'||(input.LA(1) >= 'a' && input.LA(1) <= 'z') ) {
						input.consume();
					}
					else {
						MismatchedSetException mse = new MismatchedSetException(null,input);
						recover(mse);
						throw mse;
					}
					}
					break;

				default :
					break loop4;
				}
			}

			// JPA2.g:538:90: ( ( '.' ) ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' | '$' )+ )*
			loop6:
			while (true) {
				int alt6=2;
				int LA6_0 = input.LA(1);
				if ( (LA6_0=='.') ) {
					alt6=1;
				}

				switch (alt6) {
				case 1 :
					// JPA2.g:538:91: ( '.' ) ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' | '$' )+
					{
					// JPA2.g:538:91: ( '.' )
					// JPA2.g:538:92: '.'
					{
					match('.'); 
					}

					// JPA2.g:538:97: ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' | '$' )+
					int cnt5=0;
					loop5:
					while (true) {
						int alt5=2;
						int LA5_0 = input.LA(1);
						if ( (LA5_0=='$'||(LA5_0 >= '0' && LA5_0 <= '9')||(LA5_0 >= 'A' && LA5_0 <= 'Z')||LA5_0=='_'||(LA5_0 >= 'a' && LA5_0 <= 'z')) ) {
							alt5=1;
						}

						switch (alt5) {
						case 1 :
							// JPA2.g:
							{
							if ( input.LA(1)=='$'||(input.LA(1) >= '0' && input.LA(1) <= '9')||(input.LA(1) >= 'A' && input.LA(1) <= 'Z')||input.LA(1)=='_'||(input.LA(1) >= 'a' && input.LA(1) <= 'z') ) {
								input.consume();
							}
							else {
								MismatchedSetException mse = new MismatchedSetException(null,input);
								recover(mse);
								throw mse;
							}
							}
							break;

						default :
							if ( cnt5 >= 1 ) break loop5;
							EarlyExitException eee = new EarlyExitException(5, input);
							throw eee;
						}
						cnt5++;
					}

					}
					break;

				default :
					break loop6;
				}
			}

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "NAMED_PARAMETER"

	// $ANTLR start "WS"
	public final void mWS() throws RecognitionException {
		try {
			int _type = WS;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// JPA2.g:540:5: ( ( ' ' | '\\r' | '\\t' | '\\u000C' | '\\n' ) )
			// JPA2.g:540:7: ( ' ' | '\\r' | '\\t' | '\\u000C' | '\\n' )
			{
			if ( (input.LA(1) >= '\t' && input.LA(1) <= '\n')||(input.LA(1) >= '\f' && input.LA(1) <= '\r')||input.LA(1)==' ' ) {
				input.consume();
			}
			else {
				MismatchedSetException mse = new MismatchedSetException(null,input);
				recover(mse);
				throw mse;
			}
			_channel=HIDDEN;
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "WS"

	// $ANTLR start "COMMENT"
	public final void mCOMMENT() throws RecognitionException {
		try {
			int _type = COMMENT;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// JPA2.g:544:5: ( '/*' ( . )* '*/' )
			// JPA2.g:544:7: '/*' ( . )* '*/'
			{
			match("/*"); 

			// JPA2.g:544:12: ( . )*
			loop7:
			while (true) {
				int alt7=2;
				int LA7_0 = input.LA(1);
				if ( (LA7_0=='*') ) {
					int LA7_1 = input.LA(2);
					if ( (LA7_1=='/') ) {
						alt7=2;
					}
					else if ( ((LA7_1 >= '\u0000' && LA7_1 <= '.')||(LA7_1 >= '0' && LA7_1 <= '\uFFFF')) ) {
						alt7=1;
					}

				}
				else if ( ((LA7_0 >= '\u0000' && LA7_0 <= ')')||(LA7_0 >= '+' && LA7_0 <= '\uFFFF')) ) {
					alt7=1;
				}

				switch (alt7) {
				case 1 :
					// JPA2.g:544:12: .
					{
					matchAny(); 
					}
					break;

				default :
					break loop7;
				}
			}

			match("*/"); 

			_channel=HIDDEN;
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "COMMENT"

	// $ANTLR start "LINE_COMMENT"
	public final void mLINE_COMMENT() throws RecognitionException {
		try {
			int _type = LINE_COMMENT;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// JPA2.g:547:5: ( '//' (~ ( '\\n' | '\\r' ) )* ( '\\r' )? '\\n' )
			// JPA2.g:547:7: '//' (~ ( '\\n' | '\\r' ) )* ( '\\r' )? '\\n'
			{
			match("//"); 

			// JPA2.g:547:12: (~ ( '\\n' | '\\r' ) )*
			loop8:
			while (true) {
				int alt8=2;
				int LA8_0 = input.LA(1);
				if ( ((LA8_0 >= '\u0000' && LA8_0 <= '\t')||(LA8_0 >= '\u000B' && LA8_0 <= '\f')||(LA8_0 >= '\u000E' && LA8_0 <= '\uFFFF')) ) {
					alt8=1;
				}

				switch (alt8) {
				case 1 :
					// JPA2.g:
					{
					if ( (input.LA(1) >= '\u0000' && input.LA(1) <= '\t')||(input.LA(1) >= '\u000B' && input.LA(1) <= '\f')||(input.LA(1) >= '\u000E' && input.LA(1) <= '\uFFFF') ) {
						input.consume();
					}
					else {
						MismatchedSetException mse = new MismatchedSetException(null,input);
						recover(mse);
						throw mse;
					}
					}
					break;

				default :
					break loop8;
				}
			}

			// JPA2.g:547:26: ( '\\r' )?
			int alt9=2;
			int LA9_0 = input.LA(1);
			if ( (LA9_0=='\r') ) {
				alt9=1;
			}
			switch (alt9) {
				case 1 :
					// JPA2.g:547:26: '\\r'
					{
					match('\r'); 
					}
					break;

			}

			match('\n'); 
			_channel=HIDDEN;
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "LINE_COMMENT"

	// $ANTLR start "ESCAPE_CHARACTER"
	public final void mESCAPE_CHARACTER() throws RecognitionException {
		try {
			int _type = ESCAPE_CHARACTER;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// JPA2.g:550:5: ( '\\'' (~ ( '\\'' | '\\\\' ) ) '\\'' )
			// JPA2.g:550:7: '\\'' (~ ( '\\'' | '\\\\' ) ) '\\''
			{
			match('\''); 
			if ( (input.LA(1) >= '\u0000' && input.LA(1) <= '&')||(input.LA(1) >= '(' && input.LA(1) <= '[')||(input.LA(1) >= ']' && input.LA(1) <= '\uFFFF') ) {
				input.consume();
			}
			else {
				MismatchedSetException mse = new MismatchedSetException(null,input);
				recover(mse);
				throw mse;
			}
			match('\''); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "ESCAPE_CHARACTER"

	// $ANTLR start "INT_NUMERAL"
	public final void mINT_NUMERAL() throws RecognitionException {
		try {
			int _type = INT_NUMERAL;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// JPA2.g:553:5: ( ( '0' .. '9' )+ )
			// JPA2.g:553:7: ( '0' .. '9' )+
			{
			// JPA2.g:553:7: ( '0' .. '9' )+
			int cnt10=0;
			loop10:
			while (true) {
				int alt10=2;
				int LA10_0 = input.LA(1);
				if ( ((LA10_0 >= '0' && LA10_0 <= '9')) ) {
					alt10=1;
				}

				switch (alt10) {
				case 1 :
					// JPA2.g:
					{
					if ( (input.LA(1) >= '0' && input.LA(1) <= '9') ) {
						input.consume();
					}
					else {
						MismatchedSetException mse = new MismatchedSetException(null,input);
						recover(mse);
						throw mse;
					}
					}
					break;

				default :
					if ( cnt10 >= 1 ) break loop10;
					EarlyExitException eee = new EarlyExitException(10, input);
					throw eee;
				}
				cnt10++;
			}

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "INT_NUMERAL"

	@Override
	public void mTokens() throws RecognitionException {
		// JPA2.g:1:8: ( AND | ASC | AVG | BY | COUNT | DESC | DISTINCT | FETCH | GROUP | HAVING | INNER | JOIN | LEFT | LOWER | LPAREN | MAX | MIN | OR | ORDER | OUTER | RPAREN | SUM | T__55 | T__56 | T__57 | T__58 | T__59 | T__60 | T__61 | T__62 | T__63 | T__64 | T__65 | T__66 | T__67 | T__68 | T__69 | T__70 | T__71 | T__72 | T__73 | T__74 | T__75 | T__76 | T__77 | T__78 | T__79 | T__80 | T__81 | T__82 | T__83 | T__84 | T__85 | T__86 | T__87 | T__88 | T__89 | T__90 | T__91 | T__92 | T__93 | T__94 | T__95 | T__96 | T__97 | T__98 | T__99 | T__100 | T__101 | T__102 | T__103 | T__104 | T__105 | T__106 | T__107 | T__108 | T__109 | T__110 | T__111 | T__112 | T__113 | T__114 | T__115 | T__116 | T__117 | T__118 | T__119 | T__120 | T__121 | T__122 | T__123 | T__124 | T__125 | T__126 | T__127 | T__128 | T__129 | T__130 | T__131 | T__132 | T__133 | T__134 | T__135 | T__136 | NOT | IN | TRIM_CHARACTER | STRING_LITERAL | WORD | RUSSIAN_SYMBOLS | NAMED_PARAMETER | WS | COMMENT | LINE_COMMENT | ESCAPE_CHARACTER | INT_NUMERAL )
		int alt11=116;
		alt11 = dfa11.predict(input);
		switch (alt11) {
			case 1 :
				// JPA2.g:1:10: AND
				{
				mAND(); 

				}
				break;
			case 2 :
				// JPA2.g:1:14: ASC
				{
				mASC(); 

				}
				break;
			case 3 :
				// JPA2.g:1:18: AVG
				{
				mAVG(); 

				}
				break;
			case 4 :
				// JPA2.g:1:22: BY
				{
				mBY(); 

				}
				break;
			case 5 :
				// JPA2.g:1:25: COUNT
				{
				mCOUNT(); 

				}
				break;
			case 6 :
				// JPA2.g:1:31: DESC
				{
				mDESC(); 

				}
				break;
			case 7 :
				// JPA2.g:1:36: DISTINCT
				{
				mDISTINCT(); 

				}
				break;
			case 8 :
				// JPA2.g:1:45: FETCH
				{
				mFETCH(); 

				}
				break;
			case 9 :
				// JPA2.g:1:51: GROUP
				{
				mGROUP(); 

				}
				break;
			case 10 :
				// JPA2.g:1:57: HAVING
				{
				mHAVING(); 

				}
				break;
			case 11 :
				// JPA2.g:1:64: INNER
				{
				mINNER(); 

				}
				break;
			case 12 :
				// JPA2.g:1:70: JOIN
				{
				mJOIN(); 

				}
				break;
			case 13 :
				// JPA2.g:1:75: LEFT
				{
				mLEFT(); 

				}
				break;
			case 14 :
				// JPA2.g:1:80: LOWER
				{
				mLOWER(); 

				}
				break;
			case 15 :
				// JPA2.g:1:86: LPAREN
				{
				mLPAREN(); 

				}
				break;
			case 16 :
				// JPA2.g:1:93: MAX
				{
				mMAX(); 

				}
				break;
			case 17 :
				// JPA2.g:1:97: MIN
				{
				mMIN(); 

				}
				break;
			case 18 :
				// JPA2.g:1:101: OR
				{
				mOR(); 

				}
				break;
			case 19 :
				// JPA2.g:1:104: ORDER
				{
				mORDER(); 

				}
				break;
			case 20 :
				// JPA2.g:1:110: OUTER
				{
				mOUTER(); 

				}
				break;
			case 21 :
				// JPA2.g:1:116: RPAREN
				{
				mRPAREN(); 

				}
				break;
			case 22 :
				// JPA2.g:1:123: SUM
				{
				mSUM(); 

				}
				break;
			case 23 :
				// JPA2.g:1:127: T__55
				{
				mT__55(); 

				}
				break;
			case 24 :
				// JPA2.g:1:133: T__56
				{
				mT__56(); 

				}
				break;
			case 25 :
				// JPA2.g:1:139: T__57
				{
				mT__57(); 

				}
				break;
			case 26 :
				// JPA2.g:1:145: T__58
				{
				mT__58(); 

				}
				break;
			case 27 :
				// JPA2.g:1:151: T__59
				{
				mT__59(); 

				}
				break;
			case 28 :
				// JPA2.g:1:157: T__60
				{
				mT__60(); 

				}
				break;
			case 29 :
				// JPA2.g:1:163: T__61
				{
				mT__61(); 

				}
				break;
			case 30 :
				// JPA2.g:1:169: T__62
				{
				mT__62(); 

				}
				break;
			case 31 :
				// JPA2.g:1:175: T__63
				{
				mT__63(); 

				}
				break;
			case 32 :
				// JPA2.g:1:181: T__64
				{
				mT__64(); 

				}
				break;
			case 33 :
				// JPA2.g:1:187: T__65
				{
				mT__65(); 

				}
				break;
			case 34 :
				// JPA2.g:1:193: T__66
				{
				mT__66(); 

				}
				break;
			case 35 :
				// JPA2.g:1:199: T__67
				{
				mT__67(); 

				}
				break;
			case 36 :
				// JPA2.g:1:205: T__68
				{
				mT__68(); 

				}
				break;
			case 37 :
				// JPA2.g:1:211: T__69
				{
				mT__69(); 

				}
				break;
			case 38 :
				// JPA2.g:1:217: T__70
				{
				mT__70(); 

				}
				break;
			case 39 :
				// JPA2.g:1:223: T__71
				{
				mT__71(); 

				}
				break;
			case 40 :
				// JPA2.g:1:229: T__72
				{
				mT__72(); 

				}
				break;
			case 41 :
				// JPA2.g:1:235: T__73
				{
				mT__73(); 

				}
				break;
			case 42 :
				// JPA2.g:1:241: T__74
				{
				mT__74(); 

				}
				break;
			case 43 :
				// JPA2.g:1:247: T__75
				{
				mT__75(); 

				}
				break;
			case 44 :
				// JPA2.g:1:253: T__76
				{
				mT__76(); 

				}
				break;
			case 45 :
				// JPA2.g:1:259: T__77
				{
				mT__77(); 

				}
				break;
			case 46 :
				// JPA2.g:1:265: T__78
				{
				mT__78(); 

				}
				break;
			case 47 :
				// JPA2.g:1:271: T__79
				{
				mT__79(); 

				}
				break;
			case 48 :
				// JPA2.g:1:277: T__80
				{
				mT__80(); 

				}
				break;
			case 49 :
				// JPA2.g:1:283: T__81
				{
				mT__81(); 

				}
				break;
			case 50 :
				// JPA2.g:1:289: T__82
				{
				mT__82(); 

				}
				break;
			case 51 :
				// JPA2.g:1:295: T__83
				{
				mT__83(); 

				}
				break;
			case 52 :
				// JPA2.g:1:301: T__84
				{
				mT__84(); 

				}
				break;
			case 53 :
				// JPA2.g:1:307: T__85
				{
				mT__85(); 

				}
				break;
			case 54 :
				// JPA2.g:1:313: T__86
				{
				mT__86(); 

				}
				break;
			case 55 :
				// JPA2.g:1:319: T__87
				{
				mT__87(); 

				}
				break;
			case 56 :
				// JPA2.g:1:325: T__88
				{
				mT__88(); 

				}
				break;
			case 57 :
				// JPA2.g:1:331: T__89
				{
				mT__89(); 

				}
				break;
			case 58 :
				// JPA2.g:1:337: T__90
				{
				mT__90(); 

				}
				break;
			case 59 :
				// JPA2.g:1:343: T__91
				{
				mT__91(); 

				}
				break;
			case 60 :
				// JPA2.g:1:349: T__92
				{
				mT__92(); 

				}
				break;
			case 61 :
				// JPA2.g:1:355: T__93
				{
				mT__93(); 

				}
				break;
			case 62 :
				// JPA2.g:1:361: T__94
				{
				mT__94(); 

				}
				break;
			case 63 :
				// JPA2.g:1:367: T__95
				{
				mT__95(); 

				}
				break;
			case 64 :
				// JPA2.g:1:373: T__96
				{
				mT__96(); 

				}
				break;
			case 65 :
				// JPA2.g:1:379: T__97
				{
				mT__97(); 

				}
				break;
			case 66 :
				// JPA2.g:1:385: T__98
				{
				mT__98(); 

				}
				break;
			case 67 :
				// JPA2.g:1:391: T__99
				{
				mT__99(); 

				}
				break;
			case 68 :
				// JPA2.g:1:397: T__100
				{
				mT__100(); 

				}
				break;
			case 69 :
				// JPA2.g:1:404: T__101
				{
				mT__101(); 

				}
				break;
			case 70 :
				// JPA2.g:1:411: T__102
				{
				mT__102(); 

				}
				break;
			case 71 :
				// JPA2.g:1:418: T__103
				{
				mT__103(); 

				}
				break;
			case 72 :
				// JPA2.g:1:425: T__104
				{
				mT__104(); 

				}
				break;
			case 73 :
				// JPA2.g:1:432: T__105
				{
				mT__105(); 

				}
				break;
			case 74 :
				// JPA2.g:1:439: T__106
				{
				mT__106(); 

				}
				break;
			case 75 :
				// JPA2.g:1:446: T__107
				{
				mT__107(); 

				}
				break;
			case 76 :
				// JPA2.g:1:453: T__108
				{
				mT__108(); 

				}
				break;
			case 77 :
				// JPA2.g:1:460: T__109
				{
				mT__109(); 

				}
				break;
			case 78 :
				// JPA2.g:1:467: T__110
				{
				mT__110(); 

				}
				break;
			case 79 :
				// JPA2.g:1:474: T__111
				{
				mT__111(); 

				}
				break;
			case 80 :
				// JPA2.g:1:481: T__112
				{
				mT__112(); 

				}
				break;
			case 81 :
				// JPA2.g:1:488: T__113
				{
				mT__113(); 

				}
				break;
			case 82 :
				// JPA2.g:1:495: T__114
				{
				mT__114(); 

				}
				break;
			case 83 :
				// JPA2.g:1:502: T__115
				{
				mT__115(); 

				}
				break;
			case 84 :
				// JPA2.g:1:509: T__116
				{
				mT__116(); 

				}
				break;
			case 85 :
				// JPA2.g:1:516: T__117
				{
				mT__117(); 

				}
				break;
			case 86 :
				// JPA2.g:1:523: T__118
				{
				mT__118(); 

				}
				break;
			case 87 :
				// JPA2.g:1:530: T__119
				{
				mT__119(); 

				}
				break;
			case 88 :
				// JPA2.g:1:537: T__120
				{
				mT__120(); 

				}
				break;
			case 89 :
				// JPA2.g:1:544: T__121
				{
				mT__121(); 

				}
				break;
			case 90 :
				// JPA2.g:1:551: T__122
				{
				mT__122(); 

				}
				break;
			case 91 :
				// JPA2.g:1:558: T__123
				{
				mT__123(); 

				}
				break;
			case 92 :
				// JPA2.g:1:565: T__124
				{
				mT__124(); 

				}
				break;
			case 93 :
				// JPA2.g:1:572: T__125
				{
				mT__125(); 

				}
				break;
			case 94 :
				// JPA2.g:1:579: T__126
				{
				mT__126(); 

				}
				break;
			case 95 :
				// JPA2.g:1:586: T__127
				{
				mT__127(); 

				}
				break;
			case 96 :
				// JPA2.g:1:593: T__128
				{
				mT__128(); 

				}
				break;
			case 97 :
				// JPA2.g:1:600: T__129
				{
				mT__129(); 

				}
				break;
			case 98 :
				// JPA2.g:1:607: T__130
				{
				mT__130(); 

				}
				break;
			case 99 :
				// JPA2.g:1:614: T__131
				{
				mT__131(); 

				}
				break;
			case 100 :
				// JPA2.g:1:621: T__132
				{
				mT__132(); 

				}
				break;
			case 101 :
				// JPA2.g:1:628: T__133
				{
				mT__133(); 

				}
				break;
			case 102 :
				// JPA2.g:1:635: T__134
				{
				mT__134(); 

				}
				break;
			case 103 :
				// JPA2.g:1:642: T__135
				{
				mT__135(); 

				}
				break;
			case 104 :
				// JPA2.g:1:649: T__136
				{
				mT__136(); 

				}
				break;
			case 105 :
				// JPA2.g:1:656: NOT
				{
				mNOT(); 

				}
				break;
			case 106 :
				// JPA2.g:1:660: IN
				{
				mIN(); 

				}
				break;
			case 107 :
				// JPA2.g:1:663: TRIM_CHARACTER
				{
				mTRIM_CHARACTER(); 

				}
				break;
			case 108 :
				// JPA2.g:1:678: STRING_LITERAL
				{
				mSTRING_LITERAL(); 

				}
				break;
			case 109 :
				// JPA2.g:1:693: WORD
				{
				mWORD(); 

				}
				break;
			case 110 :
				// JPA2.g:1:698: RUSSIAN_SYMBOLS
				{
				mRUSSIAN_SYMBOLS(); 

				}
				break;
			case 111 :
				// JPA2.g:1:714: NAMED_PARAMETER
				{
				mNAMED_PARAMETER(); 

				}
				break;
			case 112 :
				// JPA2.g:1:730: WS
				{
				mWS(); 

				}
				break;
			case 113 :
				// JPA2.g:1:733: COMMENT
				{
				mCOMMENT(); 

				}
				break;
			case 114 :
				// JPA2.g:1:741: LINE_COMMENT
				{
				mLINE_COMMENT(); 

				}
				break;
			case 115 :
				// JPA2.g:1:754: ESCAPE_CHARACTER
				{
				mESCAPE_CHARACTER(); 

				}
				break;
			case 116 :
				// JPA2.g:1:771: INT_NUMERAL
				{
				mINT_NUMERAL(); 

				}
				break;

		}
	}


	protected DFA11 dfa11 = new DFA11(this);
	static final String DFA11_eotS =
		"\1\uffff\12\51\1\uffff\2\51\1\uffff\1\51\6\uffff\1\130\1\55\1\134\1\uffff"+
		"\1\136\2\uffff\12\51\7\uffff\1\51\1\173\3\51\1\177\16\51\1\u0093\1\u0094"+
		"\10\51\1\u00a2\2\51\1\u00a5\1\u00a6\5\51\14\uffff\22\51\4\uffff\1\u00c9"+
		"\1\u00ca\1\u00cb\1\uffff\1\u00cc\1\51\1\u00ce\1\uffff\12\51\1\u00d9\10"+
		"\51\2\uffff\7\51\1\u00e9\1\u00eb\4\51\1\uffff\2\51\2\uffff\1\u00f2\3\51"+
		"\1\u00f6\3\51\1\uffff\2\51\1\u00fd\4\51\1\u0102\1\u0103\1\u0104\15\51"+
		"\10\uffff\1\51\1\u0115\3\51\1\u0119\1\51\1\u011b\2\51\1\uffff\1\51\1\u011f"+
		"\3\51\1\u0123\2\51\1\u0126\1\u0127\4\51\1\u012c\1\uffff\1\51\1\uffff\1"+
		"\51\1\uffff\4\51\1\uffff\3\51\1\uffff\1\51\1\u0137\1\51\1\uffff\1\u013a"+
		"\1\51\1\uffff\3\51\4\uffff\1\u0140\1\u0141\7\51\1\u0149\1\51\1\u014b\1"+
		"\51\1\u014d\1\uffff\1\51\1\uffff\1\u014f\2\51\1\uffff\1\51\1\uffff\2\51"+
		"\1\u0155\1\uffff\1\51\1\u0157\1\51\1\uffff\1\u0159\1\51\2\uffff\2\51\1"+
		"\u015d\1\51\1\uffff\2\51\1\u0161\1\u0162\1\u0163\4\51\5\uffff\1\u016b"+
		"\4\51\2\uffff\2\51\2\uffff\3\51\1\uffff\1\u0175\1\uffff\1\u0176\1\uffff"+
		"\1\51\1\uffff\3\51\1\u017b\1\51\1\uffff\1\51\1\uffff\1\u017e\2\uffff\2"+
		"\51\1\uffff\1\51\1\u0182\1\u0183\3\uffff\1\u0184\1\51\1\u0186\1\u0187"+
		"\5\uffff\1\u0188\1\u0189\2\51\1\uffff\1\u018c\4\uffff\1\u018d\1\51\1\uffff"+
		"\1\51\1\uffff\2\51\1\uffff\1\u0192\5\uffff\1\51\5\uffff\1\51\2\uffff\2"+
		"\51\1\u0198\1\51\1\uffff\1\51\1\u019b\1\uffff\2\51\2\uffff\1\51\1\uffff"+
		"\2\51\1\uffff\2\51\1\u01a3\1\u01a5\1\uffff\1\51\1\uffff\3\51\1\u01aa\1"+
		"\uffff";
	static final String DFA11_eofS =
		"\u01ab\uffff";
	static final String DFA11_minS =
		"\1\11\1\102\1\105\2\101\1\105\1\122\1\101\1\116\1\117\1\105\1\uffff\1"+
		"\101\1\102\1\uffff\1\105\6\uffff\1\52\1\170\1\75\1\uffff\1\75\1\uffff"+
		"\1\102\1\114\2\105\1\110\1\120\1\101\1\110\1\105\1\141\1\162\1\uffff\1"+
		"\0\5\uffff\1\104\1\44\1\107\1\123\1\114\1\44\2\124\1\101\1\123\1\122\1"+
		"\114\1\123\1\131\1\124\1\117\1\116\1\117\1\126\1\125\2\44\1\111\1\101"+
		"\1\103\1\113\1\130\1\116\1\115\1\104\1\44\1\124\1\112\2\44\1\102\1\103"+
		"\1\132\1\115\1\122\12\uffff\1\101\1\uffff\1\123\1\120\1\104\1\103\1\111"+
		"\1\131\1\127\1\124\1\114\1\105\1\101\1\120\1\104\1\114\1\105\1\101\1\154"+
		"\1\165\2\0\2\uffff\3\44\1\uffff\1\44\1\50\1\44\1\uffff\1\127\1\110\1\116"+
		"\1\114\1\103\1\105\1\122\1\103\1\105\1\124\1\44\1\103\1\115\1\103\1\125"+
		"\1\111\1\122\2\105\2\uffff\1\116\1\124\1\104\1\107\1\105\1\101\1\105\2"+
		"\44\1\102\1\50\1\124\1\105\1\uffff\2\105\2\uffff\1\44\1\123\1\117\1\105"+
		"\1\44\2\105\2\124\1\105\1\124\1\44\1\122\1\101\1\123\1\50\3\44\1\114\1"+
		"\116\1\111\1\101\1\115\1\105\1\101\1\105\1\125\1\116\1\122\1\163\1\145"+
		"\10\uffff\1\105\1\44\1\124\1\105\1\101\1\44\1\105\1\44\1\124\1\111\1\uffff"+
		"\1\110\1\44\1\124\1\120\1\116\1\44\1\122\1\130\2\44\1\111\1\124\1\122"+
		"\1\124\1\44\1\uffff\1\124\1\uffff\1\105\1\uffff\1\110\2\122\1\103\1\uffff"+
		"\1\124\1\116\1\103\1\uffff\1\50\1\44\1\50\1\105\1\44\1\131\1\uffff\1\131"+
		"\1\120\1\124\4\uffff\2\44\1\114\1\124\2\50\1\124\1\122\1\105\1\44\1\105"+
		"\1\44\1\145\1\44\1\uffff\1\105\1\uffff\1\44\1\123\1\124\1\uffff\1\116"+
		"\1\uffff\1\105\1\116\1\44\1\uffff\1\111\1\44\1\107\1\uffff\1\44\1\50\2"+
		"\uffff\1\116\1\110\1\44\1\105\1\uffff\1\105\1\122\3\44\1\124\1\122\1\104"+
		"\1\124\3\uffff\1\101\1\uffff\1\44\1\50\1\105\1\123\1\106\2\uffff\1\111"+
		"\1\50\2\uffff\1\105\2\50\1\uffff\1\44\1\uffff\1\44\1\uffff\1\116\1\uffff"+
		"\1\103\1\50\1\124\1\44\1\103\1\uffff\1\117\1\uffff\1\44\2\uffff\1\107"+
		"\1\50\1\uffff\1\50\2\44\3\uffff\1\44\1\111\2\44\5\uffff\2\44\1\50\1\116"+
		"\1\uffff\1\44\4\uffff\1\44\1\105\1\uffff\1\137\1\uffff\1\124\1\116\1\uffff"+
		"\1\44\5\uffff\1\116\5\uffff\1\107\2\uffff\1\50\1\104\1\44\1\50\1\uffff"+
		"\1\107\1\44\1\uffff\1\101\1\111\2\uffff\1\50\1\uffff\1\124\1\115\1\uffff"+
		"\2\105\2\44\1\uffff\1\124\1\uffff\1\101\1\115\1\120\1\44\1\uffff";
	static final String DFA11_maxS =
		"\1\u052f\1\126\1\131\1\125\1\111\1\125\1\122\1\117\1\123\2\117\1\uffff"+
		"\1\117\1\125\1\uffff\1\125\6\uffff\1\57\1\170\1\76\1\uffff\1\75\1\uffff"+
		"\1\124\1\130\1\105\1\125\1\131\1\120\1\101\1\110\1\105\1\141\1\162\1\uffff"+
		"\1\uffff\5\uffff\1\131\1\172\1\107\1\123\1\114\1\172\2\124\1\125\1\123"+
		"\1\122\2\123\1\131\1\124\1\117\1\116\1\117\1\126\1\125\2\172\1\111\1\116"+
		"\1\127\1\113\1\130\1\116\1\115\1\116\1\172\1\124\1\112\2\172\1\115\1\124"+
		"\1\132\1\115\1\122\12\uffff\1\101\1\uffff\1\123\1\120\1\124\1\103\1\111"+
		"\1\131\2\127\1\114\1\105\1\111\2\120\1\114\1\105\1\101\1\154\1\165\2\uffff"+
		"\2\uffff\3\172\1\uffff\1\172\1\50\1\172\1\uffff\1\127\1\110\1\116\1\114"+
		"\1\103\1\105\1\122\1\103\1\105\1\124\1\172\1\103\1\115\1\103\1\125\1\111"+
		"\1\122\2\105\2\uffff\1\116\1\124\1\104\1\107\1\105\1\101\1\105\2\172\1"+
		"\102\1\50\1\124\1\105\1\uffff\2\105\2\uffff\1\172\1\123\1\117\1\105\1"+
		"\172\2\105\2\124\1\105\1\124\1\172\1\122\1\101\1\123\1\50\3\172\1\114"+
		"\1\116\1\111\1\101\1\115\1\105\1\101\1\105\1\125\2\122\1\163\1\145\10"+
		"\uffff\1\105\1\172\1\124\1\105\1\101\1\172\1\105\1\172\1\124\1\111\1\uffff"+
		"\1\110\1\172\1\124\1\120\1\116\1\172\1\122\1\130\2\172\1\111\1\124\1\122"+
		"\1\124\1\172\1\uffff\1\124\1\uffff\1\105\1\uffff\1\110\2\122\1\103\1\uffff"+
		"\1\124\1\116\1\103\1\uffff\1\50\1\172\1\50\1\105\1\172\1\131\1\uffff\1"+
		"\131\1\120\1\124\4\uffff\2\172\1\114\1\124\2\50\1\124\1\122\1\105\1\172"+
		"\1\105\1\172\1\145\1\172\1\uffff\1\105\1\uffff\1\172\1\123\1\124\1\uffff"+
		"\1\116\1\uffff\1\105\1\116\1\172\1\uffff\1\111\1\172\1\107\1\uffff\1\172"+
		"\1\50\2\uffff\1\116\1\110\1\172\1\105\1\uffff\1\105\1\122\3\172\1\124"+
		"\1\122\1\104\1\124\3\uffff\1\105\1\uffff\1\172\1\50\1\105\1\123\1\106"+
		"\2\uffff\1\111\1\50\2\uffff\1\105\2\50\1\uffff\1\172\1\uffff\1\172\1\uffff"+
		"\1\116\1\uffff\1\103\1\50\1\124\1\172\1\103\1\uffff\1\117\1\uffff\1\172"+
		"\2\uffff\1\107\1\50\1\uffff\1\50\2\172\3\uffff\1\172\1\111\2\172\5\uffff"+
		"\2\172\1\50\1\116\1\uffff\1\172\4\uffff\1\172\1\105\1\uffff\1\137\1\uffff"+
		"\1\124\1\116\1\uffff\1\172\5\uffff\1\116\5\uffff\1\107\2\uffff\1\50\1"+
		"\124\1\172\1\50\1\uffff\1\107\1\172\1\uffff\1\101\1\111\2\uffff\1\50\1"+
		"\uffff\1\124\1\115\1\uffff\2\105\2\172\1\uffff\1\124\1\uffff\1\101\1\115"+
		"\1\120\1\172\1\uffff";
	static final String DFA11_acceptS =
		"\13\uffff\1\17\2\uffff\1\25\1\uffff\1\27\1\30\1\31\1\32\1\33\1\34\3\uffff"+
		"\1\42\1\uffff\1\45\13\uffff\1\150\1\uffff\1\155\1\156\1\157\1\160\1\164"+
		"\50\uffff\1\161\1\162\1\35\1\36\1\40\1\41\1\37\1\44\1\43\1\46\1\uffff"+
		"\1\52\24\uffff\1\163\1\154\3\uffff\1\56\3\uffff\1\4\23\uffff\1\152\1\103"+
		"\15\uffff\1\22\2\uffff\1\122\1\123\40\uffff\1\153\1\154\1\1\1\55\1\2\1"+
		"\3\1\53\1\54\12\uffff\1\67\17\uffff\1\20\1\uffff\1\21\1\uffff\1\113\4"+
		"\uffff\1\26\3\uffff\1\126\6\uffff\1\73\3\uffff\1\104\1\115\1\116\1\151"+
		"\16\uffff\1\153\1\uffff\1\60\3\uffff\1\61\1\uffff\1\6\3\uffff\1\77\3\uffff"+
		"\1\101\2\uffff\1\14\1\15\4\uffff\1\107\11\uffff\1\127\1\130\1\131\1\uffff"+
		"\1\71\5\uffff\1\117\1\133\2\uffff\1\136\1\137\3\uffff\1\143\1\uffff\1"+
		"\145\1\uffff\1\147\1\uffff\1\5\5\uffff\1\10\1\uffff\1\11\1\uffff\1\13"+
		"\1\102\2\uffff\1\16\3\uffff\1\114\1\23\1\24\4\uffff\1\47\1\50\1\51\1\72"+
		"\1\74\4\uffff\1\135\1\uffff\1\141\1\142\1\144\1\146\2\uffff\1\63\1\uffff"+
		"\1\70\2\uffff\1\12\1\uffff\1\106\1\110\1\112\1\111\1\121\1\uffff\1\124"+
		"\1\125\1\75\1\76\1\120\1\uffff\1\140\1\57\4\uffff\1\105\2\uffff\1\62\2"+
		"\uffff\1\7\1\100\1\uffff\1\134\2\uffff\1\132\4\uffff\1\64\1\uffff\1\65"+
		"\4\uffff\1\66";
	static final String DFA11_specialS =
		"\50\uffff\1\2\113\uffff\1\1\1\0\u0135\uffff}>";
	static final String[] DFA11_transitionS = {
			"\2\54\1\uffff\2\54\22\uffff\1\54\3\uffff\1\20\2\uffff\1\50\1\13\1\16"+
			"\1\21\1\22\1\23\1\24\1\25\1\26\1\27\11\55\1\53\1\uffff\1\30\1\31\1\32"+
			"\1\33\1\34\1\1\1\2\1\3\1\4\1\35\1\5\1\6\1\7\1\10\1\11\1\36\1\12\1\14"+
			"\1\37\1\15\3\51\1\17\1\40\1\41\1\42\1\43\1\51\1\44\1\51\4\uffff\1\51"+
			"\1\uffff\5\51\1\45\15\51\1\46\6\51\2\uffff\1\47\u0382\uffff\u0130\52",
			"\1\61\11\uffff\1\62\1\uffff\1\56\4\uffff\1\57\2\uffff\1\60",
			"\1\64\11\uffff\1\65\11\uffff\1\63",
			"\1\67\15\uffff\1\66\5\uffff\1\70",
			"\1\73\3\uffff\1\71\3\uffff\1\72",
			"\1\74\14\uffff\1\75\2\uffff\1\76",
			"\1\77",
			"\1\100\15\uffff\1\101",
			"\1\102\4\uffff\1\103",
			"\1\104",
			"\1\105\3\uffff\1\107\5\uffff\1\106",
			"",
			"\1\110\3\uffff\1\112\3\uffff\1\111\5\uffff\1\113",
			"\1\116\3\uffff\1\117\7\uffff\1\120\3\uffff\1\114\2\uffff\1\115",
			"",
			"\1\122\3\uffff\1\123\5\uffff\1\124\1\uffff\1\125\3\uffff\1\121",
			"",
			"",
			"",
			"",
			"",
			"",
			"\1\126\4\uffff\1\127",
			"\1\131",
			"\1\132\1\133",
			"",
			"\1\135",
			"",
			"\1\137\1\uffff\1\140\17\uffff\1\141",
			"\1\142\1\143\1\144\4\uffff\1\145\4\uffff\1\146",
			"\1\147",
			"\1\150\11\uffff\1\151\5\uffff\1\152",
			"\1\153\11\uffff\1\154\6\uffff\1\155",
			"\1\156",
			"\1\157",
			"\1\160",
			"\1\161",
			"\1\162",
			"\1\163",
			"",
			"\42\165\1\166\4\165\1\167\6\165\1\164\55\165\1\167\uffa3\165",
			"",
			"",
			"",
			"",
			"",
			"\1\170\24\uffff\1\171",
			"\1\51\13\uffff\12\51\7\uffff\2\51\1\172\27\51\4\uffff\1\51\1\uffff\32"+
			"\51",
			"\1\174",
			"\1\175",
			"\1\176",
			"\1\51\13\uffff\12\51\7\uffff\32\51\4\uffff\1\51\1\uffff\32\51",
			"\1\u0080",
			"\1\u0081",
			"\1\u0083\14\uffff\1\u0084\6\uffff\1\u0082",
			"\1\u0085",
			"\1\u0086",
			"\1\u0088\6\uffff\1\u0087",
			"\1\u0089",
			"\1\u008a",
			"\1\u008b",
			"\1\u008c",
			"\1\u008d",
			"\1\u008e",
			"\1\u008f",
			"\1\u0090",
			"\1\51\13\uffff\12\51\7\uffff\3\51\1\u0092\11\51\1\u0091\14\51\4\uffff"+
			"\1\51\1\uffff\32\51",
			"\1\51\13\uffff\12\51\7\uffff\32\51\4\uffff\1\51\1\uffff\32\51",
			"\1\u0095",
			"\1\u0097\4\uffff\1\u0096\7\uffff\1\u0098",
			"\1\u009a\23\uffff\1\u0099",
			"\1\u009b",
			"\1\u009c",
			"\1\u009d",
			"\1\u009e",
			"\1\u009f\11\uffff\1\u00a0",
			"\1\51\13\uffff\12\51\7\uffff\3\51\1\u00a1\26\51\4\uffff\1\51\1\uffff"+
			"\32\51",
			"\1\u00a3",
			"\1\u00a4",
			"\1\51\13\uffff\12\51\7\uffff\32\51\4\uffff\1\51\1\uffff\32\51",
			"\1\51\13\uffff\12\51\7\uffff\32\51\4\uffff\1\51\1\uffff\32\51",
			"\1\u00a8\12\uffff\1\u00a7",
			"\1\u00a9\10\uffff\1\u00aa\7\uffff\1\u00ab",
			"\1\u00ac",
			"\1\u00ad",
			"\1\u00ae",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"\1\u00af",
			"",
			"\1\u00b0",
			"\1\u00b1",
			"\1\u00b2\17\uffff\1\u00b3",
			"\1\u00b4",
			"\1\u00b5",
			"\1\u00b6",
			"\1\u00b7",
			"\1\u00b9\2\uffff\1\u00b8",
			"\1\u00ba",
			"\1\u00bb",
			"\1\u00bc\3\uffff\1\u00bd\3\uffff\1\u00be",
			"\1\u00bf",
			"\1\u00c0\13\uffff\1\u00c1",
			"\1\u00c2",
			"\1\u00c3",
			"\1\u00c4",
			"\1\u00c5",
			"\1\u00c6",
			"\42\167\1\uffff\4\167\1\u00c7\uffd8\167",
			"\42\167\1\uffff\4\167\1\u00c8\uffd8\167",
			"",
			"",
			"\1\51\13\uffff\12\51\7\uffff\32\51\4\uffff\1\51\1\uffff\32\51",
			"\1\51\13\uffff\12\51\7\uffff\32\51\4\uffff\1\51\1\uffff\32\51",
			"\1\51\13\uffff\12\51\7\uffff\32\51\4\uffff\1\51\1\uffff\32\51",
			"",
			"\1\51\13\uffff\12\51\7\uffff\32\51\4\uffff\1\51\1\uffff\32\51",
			"\1\u00cd",
			"\1\51\13\uffff\12\51\7\uffff\32\51\4\uffff\1\51\1\uffff\32\51",
			"",
			"\1\u00cf",
			"\1\u00d0",
			"\1\u00d1",
			"\1\u00d2",
			"\1\u00d3",
			"\1\u00d4",
			"\1\u00d5",
			"\1\u00d6",
			"\1\u00d7",
			"\1\u00d8",
			"\1\51\13\uffff\12\51\7\uffff\32\51\4\uffff\1\51\1\uffff\32\51",
			"\1\u00da",
			"\1\u00db",
			"\1\u00dc",
			"\1\u00dd",
			"\1\u00de",
			"\1\u00df",
			"\1\u00e0",
			"\1\u00e1",
			"",
			"",
			"\1\u00e2",
			"\1\u00e3",
			"\1\u00e4",
			"\1\u00e5",
			"\1\u00e6",
			"\1\u00e7",
			"\1\u00e8",
			"\1\51\13\uffff\12\51\7\uffff\32\51\4\uffff\1\51\1\uffff\32\51",
			"\1\51\13\uffff\12\51\7\uffff\24\51\1\u00ea\5\51\4\uffff\1\51\1\uffff"+
			"\32\51",
			"\1\u00ec",
			"\1\u00ed",
			"\1\u00ee",
			"\1\u00ef",
			"",
			"\1\u00f0",
			"\1\u00f1",
			"",
			"",
			"\1\51\13\uffff\12\51\7\uffff\32\51\4\uffff\1\51\1\uffff\32\51",
			"\1\u00f3",
			"\1\u00f4",
			"\1\u00f5",
			"\1\51\13\uffff\12\51\7\uffff\32\51\4\uffff\1\51\1\uffff\32\51",
			"\1\u00f7",
			"\1\u00f8",
			"\1\u00f9",
			"\1\u00fa",
			"\1\u00fb",
			"\1\u00fc",
			"\1\51\13\uffff\12\51\7\uffff\32\51\4\uffff\1\51\1\uffff\32\51",
			"\1\u00fe",
			"\1\u00ff",
			"\1\u0100",
			"\1\u0101",
			"\1\51\13\uffff\12\51\7\uffff\32\51\4\uffff\1\51\1\uffff\32\51",
			"\1\51\13\uffff\12\51\7\uffff\32\51\4\uffff\1\51\1\uffff\32\51",
			"\1\51\13\uffff\12\51\7\uffff\32\51\4\uffff\1\51\1\uffff\32\51",
			"\1\u0105",
			"\1\u0106",
			"\1\u0107",
			"\1\u0108",
			"\1\u0109",
			"\1\u010a",
			"\1\u010b",
			"\1\u010c",
			"\1\u010d",
			"\1\u010e\3\uffff\1\u010f",
			"\1\u0110",
			"\1\u0111",
			"\1\u0112",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"\1\u0114",
			"\1\51\13\uffff\12\51\7\uffff\32\51\4\uffff\1\51\1\uffff\32\51",
			"\1\u0116",
			"\1\u0117",
			"\1\u0118",
			"\1\51\13\uffff\12\51\7\uffff\32\51\4\uffff\1\51\1\uffff\32\51",
			"\1\u011a",
			"\1\51\13\uffff\12\51\7\uffff\32\51\4\uffff\1\51\1\uffff\32\51",
			"\1\u011c",
			"\1\u011d",
			"",
			"\1\u011e",
			"\1\51\13\uffff\12\51\7\uffff\32\51\4\uffff\1\51\1\uffff\32\51",
			"\1\u0120",
			"\1\u0121",
			"\1\u0122",
			"\1\51\13\uffff\12\51\7\uffff\32\51\4\uffff\1\51\1\uffff\32\51",
			"\1\u0124",
			"\1\u0125",
			"\1\51\13\uffff\12\51\7\uffff\32\51\4\uffff\1\51\1\uffff\32\51",
			"\1\51\13\uffff\12\51\7\uffff\32\51\4\uffff\1\51\1\uffff\32\51",
			"\1\u0128",
			"\1\u0129",
			"\1\u012a",
			"\1\u012b",
			"\1\51\13\uffff\12\51\7\uffff\32\51\4\uffff\1\51\1\uffff\32\51",
			"",
			"\1\u012d",
			"",
			"\1\u012e",
			"",
			"\1\u012f",
			"\1\u0130",
			"\1\u0131",
			"\1\u0132",
			"",
			"\1\u0133",
			"\1\u0134",
			"\1\u0135",
			"",
			"\1\u0136",
			"\1\51\13\uffff\12\51\7\uffff\32\51\4\uffff\1\51\1\uffff\32\51",
			"\1\u0138",
			"\1\u0139",
			"\1\51\13\uffff\12\51\7\uffff\32\51\4\uffff\1\51\1\uffff\32\51",
			"\1\u013b",
			"",
			"\1\u013c",
			"\1\u013d",
			"\1\u013e",
			"",
			"",
			"",
			"",
			"\1\51\13\uffff\12\51\7\uffff\10\51\1\u013f\21\51\4\uffff\1\51\1\uffff"+
			"\32\51",
			"\1\51\13\uffff\12\51\7\uffff\32\51\4\uffff\1\51\1\uffff\32\51",
			"\1\u0142",
			"\1\u0143",
			"\1\u0144",
			"\1\u0145",
			"\1\u0146",
			"\1\u0147",
			"\1\u0148",
			"\1\51\13\uffff\12\51\7\uffff\32\51\4\uffff\1\51\1\uffff\32\51",
			"\1\u014a",
			"\1\51\13\uffff\12\51\7\uffff\32\51\4\uffff\1\51\1\uffff\32\51",
			"\1\u014c",
			"\1\51\13\uffff\12\51\7\uffff\32\51\4\uffff\1\51\1\uffff\32\51",
			"",
			"\1\u014e",
			"",
			"\1\51\13\uffff\12\51\7\uffff\32\51\4\uffff\1\51\1\uffff\32\51",
			"\1\u0150",
			"\1\u0151",
			"",
			"\1\u0152",
			"",
			"\1\u0153",
			"\1\u0154",
			"\1\51\13\uffff\12\51\7\uffff\32\51\4\uffff\1\51\1\uffff\32\51",
			"",
			"\1\u0156",
			"\1\51\13\uffff\12\51\7\uffff\32\51\4\uffff\1\51\1\uffff\32\51",
			"\1\u0158",
			"",
			"\1\51\13\uffff\12\51\7\uffff\32\51\4\uffff\1\51\1\uffff\32\51",
			"\1\u015a",
			"",
			"",
			"\1\u015b",
			"\1\u015c",
			"\1\51\13\uffff\12\51\7\uffff\32\51\4\uffff\1\51\1\uffff\32\51",
			"\1\u015e",
			"",
			"\1\u015f",
			"\1\u0160",
			"\1\51\13\uffff\12\51\7\uffff\32\51\4\uffff\1\51\1\uffff\32\51",
			"\1\51\13\uffff\12\51\7\uffff\32\51\4\uffff\1\51\1\uffff\32\51",
			"\1\51\13\uffff\12\51\7\uffff\32\51\4\uffff\1\51\1\uffff\32\51",
			"\1\u0164",
			"\1\u0165",
			"\1\u0166",
			"\1\u0167",
			"",
			"",
			"",
			"\1\u0168\1\u0169\2\uffff\1\u016a",
			"",
			"\1\51\13\uffff\12\51\7\uffff\32\51\4\uffff\1\51\1\uffff\32\51",
			"\1\u016c",
			"\1\u016d",
			"\1\u016e",
			"\1\u016f",
			"",
			"",
			"\1\u0170",
			"\1\u0171",
			"",
			"",
			"\1\u0172",
			"\1\u0173",
			"\1\u0174",
			"",
			"\1\51\13\uffff\12\51\7\uffff\32\51\4\uffff\1\51\1\uffff\32\51",
			"",
			"\1\51\13\uffff\12\51\7\uffff\32\51\4\uffff\1\51\1\uffff\32\51",
			"",
			"\1\u0177",
			"",
			"\1\u0178",
			"\1\u0179",
			"\1\u017a",
			"\1\51\13\uffff\12\51\7\uffff\32\51\4\uffff\1\51\1\uffff\32\51",
			"\1\u017c",
			"",
			"\1\u017d",
			"",
			"\1\51\13\uffff\12\51\7\uffff\32\51\4\uffff\1\51\1\uffff\32\51",
			"",
			"",
			"\1\u017f",
			"\1\u0180",
			"",
			"\1\u0181",
			"\1\51\13\uffff\12\51\7\uffff\32\51\4\uffff\1\51\1\uffff\32\51",
			"\1\51\13\uffff\12\51\7\uffff\32\51\4\uffff\1\51\1\uffff\32\51",
			"",
			"",
			"",
			"\1\51\13\uffff\12\51\7\uffff\32\51\4\uffff\1\51\1\uffff\32\51",
			"\1\u0185",
			"\1\51\13\uffff\12\51\7\uffff\32\51\4\uffff\1\51\1\uffff\32\51",
			"\1\51\13\uffff\12\51\7\uffff\32\51\4\uffff\1\51\1\uffff\32\51",
			"",
			"",
			"",
			"",
			"",
			"\1\51\13\uffff\12\51\7\uffff\32\51\4\uffff\1\51\1\uffff\32\51",
			"\1\51\13\uffff\12\51\7\uffff\32\51\4\uffff\1\51\1\uffff\32\51",
			"\1\u018a",
			"\1\u018b",
			"",
			"\1\51\13\uffff\12\51\7\uffff\32\51\4\uffff\1\51\1\uffff\32\51",
			"",
			"",
			"",
			"",
			"\1\51\13\uffff\12\51\7\uffff\32\51\4\uffff\1\51\1\uffff\32\51",
			"\1\u018e",
			"",
			"\1\u018f",
			"",
			"\1\u0190",
			"\1\u0191",
			"",
			"\1\51\13\uffff\12\51\7\uffff\32\51\4\uffff\1\51\1\uffff\32\51",
			"",
			"",
			"",
			"",
			"",
			"\1\u0193",
			"",
			"",
			"",
			"",
			"",
			"\1\u0194",
			"",
			"",
			"\1\u0195",
			"\1\u0196\17\uffff\1\u0197",
			"\1\51\13\uffff\12\51\7\uffff\32\51\4\uffff\1\51\1\uffff\32\51",
			"\1\u0199",
			"",
			"\1\u019a",
			"\1\51\13\uffff\12\51\7\uffff\32\51\4\uffff\1\51\1\uffff\32\51",
			"",
			"\1\u019c",
			"\1\u019d",
			"",
			"",
			"\1\u019e",
			"",
			"\1\u019f",
			"\1\u01a0",
			"",
			"\1\u01a1",
			"\1\u01a2",
			"\1\51\13\uffff\12\51\7\uffff\32\51\4\uffff\1\51\1\uffff\32\51",
			"\1\51\13\uffff\12\51\7\uffff\22\51\1\u01a4\7\51\4\uffff\1\51\1\uffff"+
			"\32\51",
			"",
			"\1\u01a6",
			"",
			"\1\u01a7",
			"\1\u01a8",
			"\1\u01a9",
			"\1\51\13\uffff\12\51\7\uffff\32\51\4\uffff\1\51\1\uffff\32\51",
			""
	};

	static final short[] DFA11_eot = DFA.unpackEncodedString(DFA11_eotS);
	static final short[] DFA11_eof = DFA.unpackEncodedString(DFA11_eofS);
	static final char[] DFA11_min = DFA.unpackEncodedStringToUnsignedChars(DFA11_minS);
	static final char[] DFA11_max = DFA.unpackEncodedStringToUnsignedChars(DFA11_maxS);
	static final short[] DFA11_accept = DFA.unpackEncodedString(DFA11_acceptS);
	static final short[] DFA11_special = DFA.unpackEncodedString(DFA11_specialS);
	static final short[][] DFA11_transition;

	static {
		int numStates = DFA11_transitionS.length;
		DFA11_transition = new short[numStates][];
		for (int i=0; i<numStates; i++) {
			DFA11_transition[i] = DFA.unpackEncodedString(DFA11_transitionS[i]);
		}
	}

	protected class DFA11 extends DFA {

		public DFA11(BaseRecognizer recognizer) {
			this.recognizer = recognizer;
			this.decisionNumber = 11;
			this.eot = DFA11_eot;
			this.eof = DFA11_eof;
			this.min = DFA11_min;
			this.max = DFA11_max;
			this.accept = DFA11_accept;
			this.special = DFA11_special;
			this.transition = DFA11_transition;
		}
		@Override
		public String getDescription() {
			return "1:1: Tokens : ( AND | ASC | AVG | BY | COUNT | DESC | DISTINCT | FETCH | GROUP | HAVING | INNER | JOIN | LEFT | LOWER | LPAREN | MAX | MIN | OR | ORDER | OUTER | RPAREN | SUM | T__55 | T__56 | T__57 | T__58 | T__59 | T__60 | T__61 | T__62 | T__63 | T__64 | T__65 | T__66 | T__67 | T__68 | T__69 | T__70 | T__71 | T__72 | T__73 | T__74 | T__75 | T__76 | T__77 | T__78 | T__79 | T__80 | T__81 | T__82 | T__83 | T__84 | T__85 | T__86 | T__87 | T__88 | T__89 | T__90 | T__91 | T__92 | T__93 | T__94 | T__95 | T__96 | T__97 | T__98 | T__99 | T__100 | T__101 | T__102 | T__103 | T__104 | T__105 | T__106 | T__107 | T__108 | T__109 | T__110 | T__111 | T__112 | T__113 | T__114 | T__115 | T__116 | T__117 | T__118 | T__119 | T__120 | T__121 | T__122 | T__123 | T__124 | T__125 | T__126 | T__127 | T__128 | T__129 | T__130 | T__131 | T__132 | T__133 | T__134 | T__135 | T__136 | NOT | IN | TRIM_CHARACTER | STRING_LITERAL | WORD | RUSSIAN_SYMBOLS | NAMED_PARAMETER | WS | COMMENT | LINE_COMMENT | ESCAPE_CHARACTER | INT_NUMERAL );";
		}
		@Override
		public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
			IntStream input = _input;
			int _s = s;
			switch ( s ) {
					case 0 : 
						int LA11_117 = input.LA(1);
						s = -1;
						if ( (LA11_117=='\'') ) {s = 200;}
						else if ( ((LA11_117 >= '\u0000' && LA11_117 <= '!')||(LA11_117 >= '#' && LA11_117 <= '&')||(LA11_117 >= '(' && LA11_117 <= '\uFFFF')) ) {s = 119;}
						if ( s>=0 ) return s;
						break;

					case 1 : 
						int LA11_116 = input.LA(1);
						s = -1;
						if ( (LA11_116=='\'') ) {s = 199;}
						else if ( ((LA11_116 >= '\u0000' && LA11_116 <= '!')||(LA11_116 >= '#' && LA11_116 <= '&')||(LA11_116 >= '(' && LA11_116 <= '\uFFFF')) ) {s = 119;}
						if ( s>=0 ) return s;
						break;

					case 2 : 
						int LA11_40 = input.LA(1);
						s = -1;
						if ( (LA11_40=='.') ) {s = 116;}
						else if ( ((LA11_40 >= '\u0000' && LA11_40 <= '!')||(LA11_40 >= '#' && LA11_40 <= '&')||(LA11_40 >= '(' && LA11_40 <= '-')||(LA11_40 >= '/' && LA11_40 <= '[')||(LA11_40 >= ']' && LA11_40 <= '\uFFFF')) ) {s = 117;}
						else if ( (LA11_40=='\"') ) {s = 118;}
						else if ( (LA11_40=='\''||LA11_40=='\\') ) {s = 119;}
						if ( s>=0 ) return s;
						break;
			}
			NoViableAltException nvae =
				new NoViableAltException(getDescription(), 11, _s, input);
			error(nvae);
			throw nvae;
		}
	}

}
