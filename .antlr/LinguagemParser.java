// Generated from c:/Users/Francisco Rafael/Desktop/trabalho final compiladores/código compiladores/Linguagem.g4 by ANTLR 4.13.1
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue"})
public class LinguagemParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.13.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		Literal=1, StringLiteral=2, NumericLiteral=3, BooleanLiteral=4, BigIntLiteral=5, 
		FUNCTION=6, RETURN=7, LET=8, CONST=9, VAR=10, IF=11, ELSE=12, SWITCH=13, 
		CASE=14, DEFAULT=15, FOR=16, WHILE=17, DO=18, BREAK=19, CONTINUE=20, NEW=21, 
		IN=22, INSTANCEOF=23, TYPEOF=24, DELETE=25, NULL=26, TRUE=27, FALSE=28, 
		UNDEFINED=29, SEMI=30, COMMA=31, LPAREN=32, RPAREN=33, LBRACE=34, RBRACE=35, 
		LBRACK=36, RBRACK=37, DOT=38, COLON=39, QUESTION=40, ARROW=41, OPTIONAL_CHAIN=42, 
		PLUS=43, MINUS=44, STAR=45, SLASH=46, PERCENT=47, POWER=48, INC=49, DEC=50, 
		BANG=51, LT=52, GT=53, LE=54, GE=55, EQ=56, NE=57, SEQ=58, SNE=59, AND=60, 
		OR=61, TILDE=62, CARET=63, B_OR=64, B_AND=65, LSHIFT=66, RSHIFT=67, ASSIGN=68, 
		PLUSEQ=69, MINUSEQ=70, STAREQ=71, SLASHEQ=72, PERCENTEQ=73, POWEQ=74, 
		Number=75, BigInt=76, String=77, Identifier=78, COMMENT=79, WS=80;
	public static final int
		RULE_program = 0, RULE_statement = 1, RULE_block = 2, RULE_variableDeclaration = 3, 
		RULE_variableDeclarator = 4, RULE_functionDeclaration = 5, RULE_paramList = 6, 
		RULE_returnStatement = 7, RULE_ifStatement = 8, RULE_switchStatement = 9, 
		RULE_switchCase = 10, RULE_defaultCase = 11, RULE_forStatement = 12, RULE_forInit = 13, 
		RULE_whileStatement = 14, RULE_doWhileStatement = 15, RULE_breakStatement = 16, 
		RULE_continueStatement = 17, RULE_expression = 18, RULE_assignmentExpression = 19, 
		RULE_assignmentOperator = 20, RULE_conditionalExpression = 21, RULE_logicalOrExpression = 22, 
		RULE_logicalAndExpression = 23, RULE_bitwiseOrExpression = 24, RULE_bitwiseXorExpression = 25, 
		RULE_bitwiseAndExpression = 26, RULE_equalityExpression = 27, RULE_relationalExpression = 28, 
		RULE_shiftExpression = 29, RULE_additiveExpression = 30, RULE_multiplicativeExpression = 31, 
		RULE_exponentExpression = 32, RULE_unaryExpression = 33, RULE_postfixExpression = 34, 
		RULE_postfixOp = 35, RULE_primaryExpression = 36, RULE_functionExpression = 37, 
		RULE_arrowFunction = 38, RULE_objectLiteral = 39, RULE_property = 40, 
		RULE_arrayLiteral = 41, RULE_argList = 42;
	private static String[] makeRuleNames() {
		return new String[] {
			"program", "statement", "block", "variableDeclaration", "variableDeclarator", 
			"functionDeclaration", "paramList", "returnStatement", "ifStatement", 
			"switchStatement", "switchCase", "defaultCase", "forStatement", "forInit", 
			"whileStatement", "doWhileStatement", "breakStatement", "continueStatement", 
			"expression", "assignmentExpression", "assignmentOperator", "conditionalExpression", 
			"logicalOrExpression", "logicalAndExpression", "bitwiseOrExpression", 
			"bitwiseXorExpression", "bitwiseAndExpression", "equalityExpression", 
			"relationalExpression", "shiftExpression", "additiveExpression", "multiplicativeExpression", 
			"exponentExpression", "unaryExpression", "postfixExpression", "postfixOp", 
			"primaryExpression", "functionExpression", "arrowFunction", "objectLiteral", 
			"property", "arrayLiteral", "argList"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, null, null, null, null, null, "'function'", "'return'", "'let'", 
			"'const'", "'var'", "'if'", "'else'", "'switch'", "'case'", "'default'", 
			"'for'", "'while'", "'do'", "'break'", "'continue'", "'new'", "'in'", 
			"'instanceof'", "'typeof'", "'delete'", "'null'", "'true'", "'false'", 
			"'undefined'", "';'", "','", "'('", "')'", "'{'", "'}'", "'['", "']'", 
			"'.'", "':'", "'?'", "'=>'", "'?.'", "'+'", "'-'", "'*'", "'/'", "'%'", 
			"'**'", "'++'", "'--'", "'!'", "'<'", "'>'", "'<='", "'>='", "'=='", 
			"'!='", "'==='", "'!=='", "'&&'", "'||'", "'~'", "'^'", "'|'", "'&'", 
			"'<<'", "'>>'", "'='", "'+='", "'-='", "'*='", "'/='", "'%='", "'**='"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "Literal", "StringLiteral", "NumericLiteral", "BooleanLiteral", 
			"BigIntLiteral", "FUNCTION", "RETURN", "LET", "CONST", "VAR", "IF", "ELSE", 
			"SWITCH", "CASE", "DEFAULT", "FOR", "WHILE", "DO", "BREAK", "CONTINUE", 
			"NEW", "IN", "INSTANCEOF", "TYPEOF", "DELETE", "NULL", "TRUE", "FALSE", 
			"UNDEFINED", "SEMI", "COMMA", "LPAREN", "RPAREN", "LBRACE", "RBRACE", 
			"LBRACK", "RBRACK", "DOT", "COLON", "QUESTION", "ARROW", "OPTIONAL_CHAIN", 
			"PLUS", "MINUS", "STAR", "SLASH", "PERCENT", "POWER", "INC", "DEC", "BANG", 
			"LT", "GT", "LE", "GE", "EQ", "NE", "SEQ", "SNE", "AND", "OR", "TILDE", 
			"CARET", "B_OR", "B_AND", "LSHIFT", "RSHIFT", "ASSIGN", "PLUSEQ", "MINUSEQ", 
			"STAREQ", "SLASHEQ", "PERCENTEQ", "POWEQ", "Number", "BigInt", "String", 
			"Identifier", "COMMENT", "WS"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "Linguagem.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public LinguagemParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ProgramContext extends ParserRuleContext {
		public TerminalNode EOF() { return getToken(LinguagemParser.EOF, 0); }
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public ProgramContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_program; }
	}

	public final ProgramContext program() throws RecognitionException {
		ProgramContext _localctx = new ProgramContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_program);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(89);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 4615653147702931426L) != 0) || _la==Identifier) {
				{
				{
				setState(86);
				statement();
				}
				}
				setState(91);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(92);
			match(EOF);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class StatementContext extends ParserRuleContext {
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public VariableDeclarationContext variableDeclaration() {
			return getRuleContext(VariableDeclarationContext.class,0);
		}
		public TerminalNode SEMI() { return getToken(LinguagemParser.SEMI, 0); }
		public ReturnStatementContext returnStatement() {
			return getRuleContext(ReturnStatementContext.class,0);
		}
		public FunctionDeclarationContext functionDeclaration() {
			return getRuleContext(FunctionDeclarationContext.class,0);
		}
		public BreakStatementContext breakStatement() {
			return getRuleContext(BreakStatementContext.class,0);
		}
		public ContinueStatementContext continueStatement() {
			return getRuleContext(ContinueStatementContext.class,0);
		}
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public IfStatementContext ifStatement() {
			return getRuleContext(IfStatementContext.class,0);
		}
		public SwitchStatementContext switchStatement() {
			return getRuleContext(SwitchStatementContext.class,0);
		}
		public ForStatementContext forStatement() {
			return getRuleContext(ForStatementContext.class,0);
		}
		public WhileStatementContext whileStatement() {
			return getRuleContext(WhileStatementContext.class,0);
		}
		public DoWhileStatementContext doWhileStatement() {
			return getRuleContext(DoWhileStatementContext.class,0);
		}
		public StatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statement; }
	}

	public final StatementContext statement() throws RecognitionException {
		StatementContext _localctx = new StatementContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_statement);
		try {
			setState(113);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(94);
				block();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(95);
				variableDeclaration();
				setState(96);
				match(SEMI);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(98);
				returnStatement();
				setState(99);
				match(SEMI);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(101);
				functionDeclaration();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(102);
				breakStatement();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(103);
				continueStatement();
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(104);
				expression();
				setState(105);
				match(SEMI);
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(107);
				ifStatement();
				}
				break;
			case 9:
				enterOuterAlt(_localctx, 9);
				{
				setState(108);
				switchStatement();
				}
				break;
			case 10:
				enterOuterAlt(_localctx, 10);
				{
				setState(109);
				forStatement();
				}
				break;
			case 11:
				enterOuterAlt(_localctx, 11);
				{
				setState(110);
				whileStatement();
				}
				break;
			case 12:
				enterOuterAlt(_localctx, 12);
				{
				setState(111);
				doWhileStatement();
				}
				break;
			case 13:
				enterOuterAlt(_localctx, 13);
				{
				setState(112);
				match(SEMI);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class BlockContext extends ParserRuleContext {
		public TerminalNode LBRACE() { return getToken(LinguagemParser.LBRACE, 0); }
		public TerminalNode RBRACE() { return getToken(LinguagemParser.RBRACE, 0); }
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public BlockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_block; }
	}

	public final BlockContext block() throws RecognitionException {
		BlockContext _localctx = new BlockContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_block);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(115);
			match(LBRACE);
			setState(119);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 4615653147702931426L) != 0) || _la==Identifier) {
				{
				{
				setState(116);
				statement();
				}
				}
				setState(121);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(122);
			match(RBRACE);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class VariableDeclarationContext extends ParserRuleContext {
		public List<VariableDeclaratorContext> variableDeclarator() {
			return getRuleContexts(VariableDeclaratorContext.class);
		}
		public VariableDeclaratorContext variableDeclarator(int i) {
			return getRuleContext(VariableDeclaratorContext.class,i);
		}
		public TerminalNode LET() { return getToken(LinguagemParser.LET, 0); }
		public TerminalNode CONST() { return getToken(LinguagemParser.CONST, 0); }
		public TerminalNode VAR() { return getToken(LinguagemParser.VAR, 0); }
		public List<TerminalNode> COMMA() { return getTokens(LinguagemParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(LinguagemParser.COMMA, i);
		}
		public VariableDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_variableDeclaration; }
	}

	public final VariableDeclarationContext variableDeclaration() throws RecognitionException {
		VariableDeclarationContext _localctx = new VariableDeclarationContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_variableDeclaration);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(124);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 1792L) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(125);
			variableDeclarator();
			setState(130);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(126);
				match(COMMA);
				setState(127);
				variableDeclarator();
				}
				}
				setState(132);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class VariableDeclaratorContext extends ParserRuleContext {
		public TerminalNode Identifier() { return getToken(LinguagemParser.Identifier, 0); }
		public TerminalNode ASSIGN() { return getToken(LinguagemParser.ASSIGN, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public VariableDeclaratorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_variableDeclarator; }
	}

	public final VariableDeclaratorContext variableDeclarator() throws RecognitionException {
		VariableDeclaratorContext _localctx = new VariableDeclaratorContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_variableDeclarator);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(133);
			match(Identifier);
			setState(136);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ASSIGN) {
				{
				setState(134);
				match(ASSIGN);
				setState(135);
				expression();
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class FunctionDeclarationContext extends ParserRuleContext {
		public TerminalNode FUNCTION() { return getToken(LinguagemParser.FUNCTION, 0); }
		public TerminalNode Identifier() { return getToken(LinguagemParser.Identifier, 0); }
		public TerminalNode LPAREN() { return getToken(LinguagemParser.LPAREN, 0); }
		public TerminalNode RPAREN() { return getToken(LinguagemParser.RPAREN, 0); }
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public ParamListContext paramList() {
			return getRuleContext(ParamListContext.class,0);
		}
		public FunctionDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_functionDeclaration; }
	}

	public final FunctionDeclarationContext functionDeclaration() throws RecognitionException {
		FunctionDeclarationContext _localctx = new FunctionDeclarationContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_functionDeclaration);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(138);
			match(FUNCTION);
			setState(139);
			match(Identifier);
			setState(140);
			match(LPAREN);
			setState(142);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==Identifier) {
				{
				setState(141);
				paramList();
				}
			}

			setState(144);
			match(RPAREN);
			setState(145);
			block();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ParamListContext extends ParserRuleContext {
		public List<TerminalNode> Identifier() { return getTokens(LinguagemParser.Identifier); }
		public TerminalNode Identifier(int i) {
			return getToken(LinguagemParser.Identifier, i);
		}
		public List<TerminalNode> COMMA() { return getTokens(LinguagemParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(LinguagemParser.COMMA, i);
		}
		public ParamListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_paramList; }
	}

	public final ParamListContext paramList() throws RecognitionException {
		ParamListContext _localctx = new ParamListContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_paramList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(147);
			match(Identifier);
			setState(152);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(148);
				match(COMMA);
				setState(149);
				match(Identifier);
				}
				}
				setState(154);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ReturnStatementContext extends ParserRuleContext {
		public TerminalNode RETURN() { return getToken(LinguagemParser.RETURN, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public ReturnStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_returnStatement; }
	}

	public final ReturnStatementContext returnStatement() throws RecognitionException {
		ReturnStatementContext _localctx = new ReturnStatementContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_returnStatement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(155);
			match(RETURN);
			setState(157);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 4615653146627145826L) != 0) || _la==Identifier) {
				{
				setState(156);
				expression();
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class IfStatementContext extends ParserRuleContext {
		public TerminalNode IF() { return getToken(LinguagemParser.IF, 0); }
		public TerminalNode LPAREN() { return getToken(LinguagemParser.LPAREN, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(LinguagemParser.RPAREN, 0); }
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public TerminalNode ELSE() { return getToken(LinguagemParser.ELSE, 0); }
		public IfStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ifStatement; }
	}

	public final IfStatementContext ifStatement() throws RecognitionException {
		IfStatementContext _localctx = new IfStatementContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_ifStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(159);
			match(IF);
			setState(160);
			match(LPAREN);
			setState(161);
			expression();
			setState(162);
			match(RPAREN);
			setState(163);
			statement();
			setState(166);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,8,_ctx) ) {
			case 1:
				{
				setState(164);
				match(ELSE);
				setState(165);
				statement();
				}
				break;
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class SwitchStatementContext extends ParserRuleContext {
		public TerminalNode SWITCH() { return getToken(LinguagemParser.SWITCH, 0); }
		public TerminalNode LPAREN() { return getToken(LinguagemParser.LPAREN, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(LinguagemParser.RPAREN, 0); }
		public TerminalNode LBRACE() { return getToken(LinguagemParser.LBRACE, 0); }
		public TerminalNode RBRACE() { return getToken(LinguagemParser.RBRACE, 0); }
		public List<SwitchCaseContext> switchCase() {
			return getRuleContexts(SwitchCaseContext.class);
		}
		public SwitchCaseContext switchCase(int i) {
			return getRuleContext(SwitchCaseContext.class,i);
		}
		public List<DefaultCaseContext> defaultCase() {
			return getRuleContexts(DefaultCaseContext.class);
		}
		public DefaultCaseContext defaultCase(int i) {
			return getRuleContext(DefaultCaseContext.class,i);
		}
		public SwitchStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_switchStatement; }
	}

	public final SwitchStatementContext switchStatement() throws RecognitionException {
		SwitchStatementContext _localctx = new SwitchStatementContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_switchStatement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(168);
			match(SWITCH);
			setState(169);
			match(LPAREN);
			setState(170);
			expression();
			setState(171);
			match(RPAREN);
			setState(172);
			match(LBRACE);
			setState(177);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==CASE || _la==DEFAULT) {
				{
				setState(175);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case CASE:
					{
					setState(173);
					switchCase();
					}
					break;
				case DEFAULT:
					{
					setState(174);
					defaultCase();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(179);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(180);
			match(RBRACE);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class SwitchCaseContext extends ParserRuleContext {
		public TerminalNode CASE() { return getToken(LinguagemParser.CASE, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode COLON() { return getToken(LinguagemParser.COLON, 0); }
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public SwitchCaseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_switchCase; }
	}

	public final SwitchCaseContext switchCase() throws RecognitionException {
		SwitchCaseContext _localctx = new SwitchCaseContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_switchCase);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(182);
			match(CASE);
			setState(183);
			expression();
			setState(184);
			match(COLON);
			setState(188);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 4615653147702931426L) != 0) || _la==Identifier) {
				{
				{
				setState(185);
				statement();
				}
				}
				setState(190);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class DefaultCaseContext extends ParserRuleContext {
		public TerminalNode DEFAULT() { return getToken(LinguagemParser.DEFAULT, 0); }
		public TerminalNode COLON() { return getToken(LinguagemParser.COLON, 0); }
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public DefaultCaseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_defaultCase; }
	}

	public final DefaultCaseContext defaultCase() throws RecognitionException {
		DefaultCaseContext _localctx = new DefaultCaseContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_defaultCase);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(191);
			match(DEFAULT);
			setState(192);
			match(COLON);
			setState(196);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 4615653147702931426L) != 0) || _la==Identifier) {
				{
				{
				setState(193);
				statement();
				}
				}
				setState(198);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ForStatementContext extends ParserRuleContext {
		public TerminalNode FOR() { return getToken(LinguagemParser.FOR, 0); }
		public TerminalNode LPAREN() { return getToken(LinguagemParser.LPAREN, 0); }
		public List<TerminalNode> SEMI() { return getTokens(LinguagemParser.SEMI); }
		public TerminalNode SEMI(int i) {
			return getToken(LinguagemParser.SEMI, i);
		}
		public TerminalNode RPAREN() { return getToken(LinguagemParser.RPAREN, 0); }
		public StatementContext statement() {
			return getRuleContext(StatementContext.class,0);
		}
		public ForInitContext forInit() {
			return getRuleContext(ForInitContext.class,0);
		}
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public ForStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_forStatement; }
	}

	public final ForStatementContext forStatement() throws RecognitionException {
		ForStatementContext _localctx = new ForStatementContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_forStatement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(199);
			match(FOR);
			setState(200);
			match(LPAREN);
			setState(202);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 4615653146627147618L) != 0) || _la==Identifier) {
				{
				setState(201);
				forInit();
				}
			}

			setState(204);
			match(SEMI);
			setState(206);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 4615653146627145826L) != 0) || _la==Identifier) {
				{
				setState(205);
				expression();
				}
			}

			setState(208);
			match(SEMI);
			setState(210);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 4615653146627145826L) != 0) || _la==Identifier) {
				{
				setState(209);
				expression();
				}
			}

			setState(212);
			match(RPAREN);
			setState(213);
			statement();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ForInitContext extends ParserRuleContext {
		public VariableDeclarationContext variableDeclaration() {
			return getRuleContext(VariableDeclarationContext.class,0);
		}
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public ForInitContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_forInit; }
	}

	public final ForInitContext forInit() throws RecognitionException {
		ForInitContext _localctx = new ForInitContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_forInit);
		try {
			setState(217);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case LET:
			case CONST:
			case VAR:
				enterOuterAlt(_localctx, 1);
				{
				setState(215);
				variableDeclaration();
				}
				break;
			case Literal:
			case BigIntLiteral:
			case FUNCTION:
			case NEW:
			case TYPEOF:
			case DELETE:
			case LPAREN:
			case LBRACE:
			case LBRACK:
			case PLUS:
			case MINUS:
			case INC:
			case DEC:
			case BANG:
			case TILDE:
			case Identifier:
				enterOuterAlt(_localctx, 2);
				{
				setState(216);
				expression();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class WhileStatementContext extends ParserRuleContext {
		public TerminalNode WHILE() { return getToken(LinguagemParser.WHILE, 0); }
		public TerminalNode LPAREN() { return getToken(LinguagemParser.LPAREN, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(LinguagemParser.RPAREN, 0); }
		public StatementContext statement() {
			return getRuleContext(StatementContext.class,0);
		}
		public WhileStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_whileStatement; }
	}

	public final WhileStatementContext whileStatement() throws RecognitionException {
		WhileStatementContext _localctx = new WhileStatementContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_whileStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(219);
			match(WHILE);
			setState(220);
			match(LPAREN);
			setState(221);
			expression();
			setState(222);
			match(RPAREN);
			setState(223);
			statement();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class DoWhileStatementContext extends ParserRuleContext {
		public TerminalNode DO() { return getToken(LinguagemParser.DO, 0); }
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public TerminalNode WHILE() { return getToken(LinguagemParser.WHILE, 0); }
		public TerminalNode LPAREN() { return getToken(LinguagemParser.LPAREN, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(LinguagemParser.RPAREN, 0); }
		public TerminalNode SEMI() { return getToken(LinguagemParser.SEMI, 0); }
		public DoWhileStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_doWhileStatement; }
	}

	public final DoWhileStatementContext doWhileStatement() throws RecognitionException {
		DoWhileStatementContext _localctx = new DoWhileStatementContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_doWhileStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(225);
			match(DO);
			setState(226);
			block();
			setState(227);
			match(WHILE);
			setState(228);
			match(LPAREN);
			setState(229);
			expression();
			setState(230);
			match(RPAREN);
			setState(232);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,17,_ctx) ) {
			case 1:
				{
				setState(231);
				match(SEMI);
				}
				break;
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class BreakStatementContext extends ParserRuleContext {
		public TerminalNode BREAK() { return getToken(LinguagemParser.BREAK, 0); }
		public TerminalNode SEMI() { return getToken(LinguagemParser.SEMI, 0); }
		public TerminalNode Identifier() { return getToken(LinguagemParser.Identifier, 0); }
		public BreakStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_breakStatement; }
	}

	public final BreakStatementContext breakStatement() throws RecognitionException {
		BreakStatementContext _localctx = new BreakStatementContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_breakStatement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(234);
			match(BREAK);
			setState(236);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==Identifier) {
				{
				setState(235);
				match(Identifier);
				}
			}

			setState(238);
			match(SEMI);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ContinueStatementContext extends ParserRuleContext {
		public TerminalNode CONTINUE() { return getToken(LinguagemParser.CONTINUE, 0); }
		public TerminalNode SEMI() { return getToken(LinguagemParser.SEMI, 0); }
		public TerminalNode Identifier() { return getToken(LinguagemParser.Identifier, 0); }
		public ContinueStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_continueStatement; }
	}

	public final ContinueStatementContext continueStatement() throws RecognitionException {
		ContinueStatementContext _localctx = new ContinueStatementContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_continueStatement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(240);
			match(CONTINUE);
			setState(242);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==Identifier) {
				{
				setState(241);
				match(Identifier);
				}
			}

			setState(244);
			match(SEMI);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ExpressionContext extends ParserRuleContext {
		public AssignmentExpressionContext assignmentExpression() {
			return getRuleContext(AssignmentExpressionContext.class,0);
		}
		public ExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expression; }
	}

	public final ExpressionContext expression() throws RecognitionException {
		ExpressionContext _localctx = new ExpressionContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_expression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(246);
			assignmentExpression();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class AssignmentExpressionContext extends ParserRuleContext {
		public ConditionalExpressionContext conditionalExpression() {
			return getRuleContext(ConditionalExpressionContext.class,0);
		}
		public AssignmentOperatorContext assignmentOperator() {
			return getRuleContext(AssignmentOperatorContext.class,0);
		}
		public AssignmentExpressionContext assignmentExpression() {
			return getRuleContext(AssignmentExpressionContext.class,0);
		}
		public AssignmentExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assignmentExpression; }
	}

	public final AssignmentExpressionContext assignmentExpression() throws RecognitionException {
		AssignmentExpressionContext _localctx = new AssignmentExpressionContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_assignmentExpression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(248);
			conditionalExpression();
			setState(252);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,20,_ctx) ) {
			case 1:
				{
				setState(249);
				assignmentOperator();
				setState(250);
				assignmentExpression();
				}
				break;
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class AssignmentOperatorContext extends ParserRuleContext {
		public TerminalNode ASSIGN() { return getToken(LinguagemParser.ASSIGN, 0); }
		public TerminalNode PLUSEQ() { return getToken(LinguagemParser.PLUSEQ, 0); }
		public TerminalNode MINUSEQ() { return getToken(LinguagemParser.MINUSEQ, 0); }
		public TerminalNode STAREQ() { return getToken(LinguagemParser.STAREQ, 0); }
		public TerminalNode SLASHEQ() { return getToken(LinguagemParser.SLASHEQ, 0); }
		public TerminalNode PERCENTEQ() { return getToken(LinguagemParser.PERCENTEQ, 0); }
		public TerminalNode POWEQ() { return getToken(LinguagemParser.POWEQ, 0); }
		public AssignmentOperatorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assignmentOperator; }
	}

	public final AssignmentOperatorContext assignmentOperator() throws RecognitionException {
		AssignmentOperatorContext _localctx = new AssignmentOperatorContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_assignmentOperator);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(254);
			_la = _input.LA(1);
			if ( !(((((_la - 68)) & ~0x3f) == 0 && ((1L << (_la - 68)) & 127L) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ConditionalExpressionContext extends ParserRuleContext {
		public LogicalOrExpressionContext logicalOrExpression() {
			return getRuleContext(LogicalOrExpressionContext.class,0);
		}
		public TerminalNode QUESTION() { return getToken(LinguagemParser.QUESTION, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode COLON() { return getToken(LinguagemParser.COLON, 0); }
		public AssignmentExpressionContext assignmentExpression() {
			return getRuleContext(AssignmentExpressionContext.class,0);
		}
		public ConditionalExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_conditionalExpression; }
	}

	public final ConditionalExpressionContext conditionalExpression() throws RecognitionException {
		ConditionalExpressionContext _localctx = new ConditionalExpressionContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_conditionalExpression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(256);
			logicalOrExpression();
			setState(262);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,21,_ctx) ) {
			case 1:
				{
				setState(257);
				match(QUESTION);
				setState(258);
				expression();
				setState(259);
				match(COLON);
				setState(260);
				assignmentExpression();
				}
				break;
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class LogicalOrExpressionContext extends ParserRuleContext {
		public List<LogicalAndExpressionContext> logicalAndExpression() {
			return getRuleContexts(LogicalAndExpressionContext.class);
		}
		public LogicalAndExpressionContext logicalAndExpression(int i) {
			return getRuleContext(LogicalAndExpressionContext.class,i);
		}
		public List<TerminalNode> OR() { return getTokens(LinguagemParser.OR); }
		public TerminalNode OR(int i) {
			return getToken(LinguagemParser.OR, i);
		}
		public LogicalOrExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_logicalOrExpression; }
	}

	public final LogicalOrExpressionContext logicalOrExpression() throws RecognitionException {
		LogicalOrExpressionContext _localctx = new LogicalOrExpressionContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_logicalOrExpression);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(264);
			logicalAndExpression();
			setState(269);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,22,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(265);
					match(OR);
					setState(266);
					logicalAndExpression();
					}
					} 
				}
				setState(271);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,22,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class LogicalAndExpressionContext extends ParserRuleContext {
		public List<BitwiseOrExpressionContext> bitwiseOrExpression() {
			return getRuleContexts(BitwiseOrExpressionContext.class);
		}
		public BitwiseOrExpressionContext bitwiseOrExpression(int i) {
			return getRuleContext(BitwiseOrExpressionContext.class,i);
		}
		public List<TerminalNode> AND() { return getTokens(LinguagemParser.AND); }
		public TerminalNode AND(int i) {
			return getToken(LinguagemParser.AND, i);
		}
		public LogicalAndExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_logicalAndExpression; }
	}

	public final LogicalAndExpressionContext logicalAndExpression() throws RecognitionException {
		LogicalAndExpressionContext _localctx = new LogicalAndExpressionContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_logicalAndExpression);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(272);
			bitwiseOrExpression();
			setState(277);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,23,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(273);
					match(AND);
					setState(274);
					bitwiseOrExpression();
					}
					} 
				}
				setState(279);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,23,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class BitwiseOrExpressionContext extends ParserRuleContext {
		public List<BitwiseXorExpressionContext> bitwiseXorExpression() {
			return getRuleContexts(BitwiseXorExpressionContext.class);
		}
		public BitwiseXorExpressionContext bitwiseXorExpression(int i) {
			return getRuleContext(BitwiseXorExpressionContext.class,i);
		}
		public List<TerminalNode> B_OR() { return getTokens(LinguagemParser.B_OR); }
		public TerminalNode B_OR(int i) {
			return getToken(LinguagemParser.B_OR, i);
		}
		public BitwiseOrExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_bitwiseOrExpression; }
	}

	public final BitwiseOrExpressionContext bitwiseOrExpression() throws RecognitionException {
		BitwiseOrExpressionContext _localctx = new BitwiseOrExpressionContext(_ctx, getState());
		enterRule(_localctx, 48, RULE_bitwiseOrExpression);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(280);
			bitwiseXorExpression();
			setState(285);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,24,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(281);
					match(B_OR);
					setState(282);
					bitwiseXorExpression();
					}
					} 
				}
				setState(287);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,24,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class BitwiseXorExpressionContext extends ParserRuleContext {
		public List<BitwiseAndExpressionContext> bitwiseAndExpression() {
			return getRuleContexts(BitwiseAndExpressionContext.class);
		}
		public BitwiseAndExpressionContext bitwiseAndExpression(int i) {
			return getRuleContext(BitwiseAndExpressionContext.class,i);
		}
		public List<TerminalNode> CARET() { return getTokens(LinguagemParser.CARET); }
		public TerminalNode CARET(int i) {
			return getToken(LinguagemParser.CARET, i);
		}
		public BitwiseXorExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_bitwiseXorExpression; }
	}

	public final BitwiseXorExpressionContext bitwiseXorExpression() throws RecognitionException {
		BitwiseXorExpressionContext _localctx = new BitwiseXorExpressionContext(_ctx, getState());
		enterRule(_localctx, 50, RULE_bitwiseXorExpression);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(288);
			bitwiseAndExpression();
			setState(293);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,25,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(289);
					match(CARET);
					setState(290);
					bitwiseAndExpression();
					}
					} 
				}
				setState(295);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,25,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class BitwiseAndExpressionContext extends ParserRuleContext {
		public List<EqualityExpressionContext> equalityExpression() {
			return getRuleContexts(EqualityExpressionContext.class);
		}
		public EqualityExpressionContext equalityExpression(int i) {
			return getRuleContext(EqualityExpressionContext.class,i);
		}
		public List<TerminalNode> B_AND() { return getTokens(LinguagemParser.B_AND); }
		public TerminalNode B_AND(int i) {
			return getToken(LinguagemParser.B_AND, i);
		}
		public BitwiseAndExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_bitwiseAndExpression; }
	}

	public final BitwiseAndExpressionContext bitwiseAndExpression() throws RecognitionException {
		BitwiseAndExpressionContext _localctx = new BitwiseAndExpressionContext(_ctx, getState());
		enterRule(_localctx, 52, RULE_bitwiseAndExpression);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(296);
			equalityExpression();
			setState(301);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,26,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(297);
					match(B_AND);
					setState(298);
					equalityExpression();
					}
					} 
				}
				setState(303);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,26,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class EqualityExpressionContext extends ParserRuleContext {
		public List<RelationalExpressionContext> relationalExpression() {
			return getRuleContexts(RelationalExpressionContext.class);
		}
		public RelationalExpressionContext relationalExpression(int i) {
			return getRuleContext(RelationalExpressionContext.class,i);
		}
		public List<TerminalNode> EQ() { return getTokens(LinguagemParser.EQ); }
		public TerminalNode EQ(int i) {
			return getToken(LinguagemParser.EQ, i);
		}
		public List<TerminalNode> NE() { return getTokens(LinguagemParser.NE); }
		public TerminalNode NE(int i) {
			return getToken(LinguagemParser.NE, i);
		}
		public List<TerminalNode> SEQ() { return getTokens(LinguagemParser.SEQ); }
		public TerminalNode SEQ(int i) {
			return getToken(LinguagemParser.SEQ, i);
		}
		public List<TerminalNode> SNE() { return getTokens(LinguagemParser.SNE); }
		public TerminalNode SNE(int i) {
			return getToken(LinguagemParser.SNE, i);
		}
		public EqualityExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_equalityExpression; }
	}

	public final EqualityExpressionContext equalityExpression() throws RecognitionException {
		EqualityExpressionContext _localctx = new EqualityExpressionContext(_ctx, getState());
		enterRule(_localctx, 54, RULE_equalityExpression);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(304);
			relationalExpression();
			setState(309);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,27,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(305);
					_la = _input.LA(1);
					if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 1080863910568919040L) != 0)) ) {
					_errHandler.recoverInline(this);
					}
					else {
						if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
						_errHandler.reportMatch(this);
						consume();
					}
					setState(306);
					relationalExpression();
					}
					} 
				}
				setState(311);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,27,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class RelationalExpressionContext extends ParserRuleContext {
		public List<ShiftExpressionContext> shiftExpression() {
			return getRuleContexts(ShiftExpressionContext.class);
		}
		public ShiftExpressionContext shiftExpression(int i) {
			return getRuleContext(ShiftExpressionContext.class,i);
		}
		public List<TerminalNode> LT() { return getTokens(LinguagemParser.LT); }
		public TerminalNode LT(int i) {
			return getToken(LinguagemParser.LT, i);
		}
		public List<TerminalNode> GT() { return getTokens(LinguagemParser.GT); }
		public TerminalNode GT(int i) {
			return getToken(LinguagemParser.GT, i);
		}
		public List<TerminalNode> LE() { return getTokens(LinguagemParser.LE); }
		public TerminalNode LE(int i) {
			return getToken(LinguagemParser.LE, i);
		}
		public List<TerminalNode> GE() { return getTokens(LinguagemParser.GE); }
		public TerminalNode GE(int i) {
			return getToken(LinguagemParser.GE, i);
		}
		public List<TerminalNode> IN() { return getTokens(LinguagemParser.IN); }
		public TerminalNode IN(int i) {
			return getToken(LinguagemParser.IN, i);
		}
		public List<TerminalNode> INSTANCEOF() { return getTokens(LinguagemParser.INSTANCEOF); }
		public TerminalNode INSTANCEOF(int i) {
			return getToken(LinguagemParser.INSTANCEOF, i);
		}
		public RelationalExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_relationalExpression; }
	}

	public final RelationalExpressionContext relationalExpression() throws RecognitionException {
		RelationalExpressionContext _localctx = new RelationalExpressionContext(_ctx, getState());
		enterRule(_localctx, 56, RULE_relationalExpression);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(312);
			shiftExpression();
			setState(317);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,28,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(313);
					_la = _input.LA(1);
					if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 67553994423140352L) != 0)) ) {
					_errHandler.recoverInline(this);
					}
					else {
						if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
						_errHandler.reportMatch(this);
						consume();
					}
					setState(314);
					shiftExpression();
					}
					} 
				}
				setState(319);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,28,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ShiftExpressionContext extends ParserRuleContext {
		public List<AdditiveExpressionContext> additiveExpression() {
			return getRuleContexts(AdditiveExpressionContext.class);
		}
		public AdditiveExpressionContext additiveExpression(int i) {
			return getRuleContext(AdditiveExpressionContext.class,i);
		}
		public List<TerminalNode> LSHIFT() { return getTokens(LinguagemParser.LSHIFT); }
		public TerminalNode LSHIFT(int i) {
			return getToken(LinguagemParser.LSHIFT, i);
		}
		public List<TerminalNode> RSHIFT() { return getTokens(LinguagemParser.RSHIFT); }
		public TerminalNode RSHIFT(int i) {
			return getToken(LinguagemParser.RSHIFT, i);
		}
		public ShiftExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_shiftExpression; }
	}

	public final ShiftExpressionContext shiftExpression() throws RecognitionException {
		ShiftExpressionContext _localctx = new ShiftExpressionContext(_ctx, getState());
		enterRule(_localctx, 58, RULE_shiftExpression);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(320);
			additiveExpression();
			setState(325);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,29,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(321);
					_la = _input.LA(1);
					if ( !(_la==LSHIFT || _la==RSHIFT) ) {
					_errHandler.recoverInline(this);
					}
					else {
						if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
						_errHandler.reportMatch(this);
						consume();
					}
					setState(322);
					additiveExpression();
					}
					} 
				}
				setState(327);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,29,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class AdditiveExpressionContext extends ParserRuleContext {
		public List<MultiplicativeExpressionContext> multiplicativeExpression() {
			return getRuleContexts(MultiplicativeExpressionContext.class);
		}
		public MultiplicativeExpressionContext multiplicativeExpression(int i) {
			return getRuleContext(MultiplicativeExpressionContext.class,i);
		}
		public List<TerminalNode> PLUS() { return getTokens(LinguagemParser.PLUS); }
		public TerminalNode PLUS(int i) {
			return getToken(LinguagemParser.PLUS, i);
		}
		public List<TerminalNode> MINUS() { return getTokens(LinguagemParser.MINUS); }
		public TerminalNode MINUS(int i) {
			return getToken(LinguagemParser.MINUS, i);
		}
		public AdditiveExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_additiveExpression; }
	}

	public final AdditiveExpressionContext additiveExpression() throws RecognitionException {
		AdditiveExpressionContext _localctx = new AdditiveExpressionContext(_ctx, getState());
		enterRule(_localctx, 60, RULE_additiveExpression);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(328);
			multiplicativeExpression();
			setState(333);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,30,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(329);
					_la = _input.LA(1);
					if ( !(_la==PLUS || _la==MINUS) ) {
					_errHandler.recoverInline(this);
					}
					else {
						if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
						_errHandler.reportMatch(this);
						consume();
					}
					setState(330);
					multiplicativeExpression();
					}
					} 
				}
				setState(335);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,30,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class MultiplicativeExpressionContext extends ParserRuleContext {
		public List<ExponentExpressionContext> exponentExpression() {
			return getRuleContexts(ExponentExpressionContext.class);
		}
		public ExponentExpressionContext exponentExpression(int i) {
			return getRuleContext(ExponentExpressionContext.class,i);
		}
		public List<TerminalNode> STAR() { return getTokens(LinguagemParser.STAR); }
		public TerminalNode STAR(int i) {
			return getToken(LinguagemParser.STAR, i);
		}
		public List<TerminalNode> SLASH() { return getTokens(LinguagemParser.SLASH); }
		public TerminalNode SLASH(int i) {
			return getToken(LinguagemParser.SLASH, i);
		}
		public List<TerminalNode> PERCENT() { return getTokens(LinguagemParser.PERCENT); }
		public TerminalNode PERCENT(int i) {
			return getToken(LinguagemParser.PERCENT, i);
		}
		public MultiplicativeExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_multiplicativeExpression; }
	}

	public final MultiplicativeExpressionContext multiplicativeExpression() throws RecognitionException {
		MultiplicativeExpressionContext _localctx = new MultiplicativeExpressionContext(_ctx, getState());
		enterRule(_localctx, 62, RULE_multiplicativeExpression);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(336);
			exponentExpression();
			setState(341);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,31,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(337);
					_la = _input.LA(1);
					if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 246290604621824L) != 0)) ) {
					_errHandler.recoverInline(this);
					}
					else {
						if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
						_errHandler.reportMatch(this);
						consume();
					}
					setState(338);
					exponentExpression();
					}
					} 
				}
				setState(343);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,31,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ExponentExpressionContext extends ParserRuleContext {
		public UnaryExpressionContext unaryExpression() {
			return getRuleContext(UnaryExpressionContext.class,0);
		}
		public TerminalNode POWER() { return getToken(LinguagemParser.POWER, 0); }
		public ExponentExpressionContext exponentExpression() {
			return getRuleContext(ExponentExpressionContext.class,0);
		}
		public ExponentExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_exponentExpression; }
	}

	public final ExponentExpressionContext exponentExpression() throws RecognitionException {
		ExponentExpressionContext _localctx = new ExponentExpressionContext(_ctx, getState());
		enterRule(_localctx, 64, RULE_exponentExpression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(344);
			unaryExpression();
			setState(347);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,32,_ctx) ) {
			case 1:
				{
				setState(345);
				match(POWER);
				setState(346);
				exponentExpression();
				}
				break;
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class UnaryExpressionContext extends ParserRuleContext {
		public UnaryExpressionContext unaryExpression() {
			return getRuleContext(UnaryExpressionContext.class,0);
		}
		public TerminalNode BANG() { return getToken(LinguagemParser.BANG, 0); }
		public TerminalNode TILDE() { return getToken(LinguagemParser.TILDE, 0); }
		public TerminalNode PLUS() { return getToken(LinguagemParser.PLUS, 0); }
		public TerminalNode MINUS() { return getToken(LinguagemParser.MINUS, 0); }
		public TerminalNode INC() { return getToken(LinguagemParser.INC, 0); }
		public TerminalNode DEC() { return getToken(LinguagemParser.DEC, 0); }
		public TerminalNode TYPEOF() { return getToken(LinguagemParser.TYPEOF, 0); }
		public TerminalNode DELETE() { return getToken(LinguagemParser.DELETE, 0); }
		public PostfixExpressionContext postfixExpression() {
			return getRuleContext(PostfixExpressionContext.class,0);
		}
		public UnaryExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_unaryExpression; }
	}

	public final UnaryExpressionContext unaryExpression() throws RecognitionException {
		UnaryExpressionContext _localctx = new UnaryExpressionContext(_ctx, getState());
		enterRule(_localctx, 66, RULE_unaryExpression);
		int _la;
		try {
			setState(352);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case TYPEOF:
			case DELETE:
			case PLUS:
			case MINUS:
			case INC:
			case DEC:
			case BANG:
			case TILDE:
				enterOuterAlt(_localctx, 1);
				{
				setState(349);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 4615653056430735360L) != 0)) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(350);
				unaryExpression();
				}
				break;
			case Literal:
			case BigIntLiteral:
			case FUNCTION:
			case NEW:
			case LPAREN:
			case LBRACE:
			case LBRACK:
			case Identifier:
				enterOuterAlt(_localctx, 2);
				{
				setState(351);
				postfixExpression();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class PostfixExpressionContext extends ParserRuleContext {
		public PrimaryExpressionContext primaryExpression() {
			return getRuleContext(PrimaryExpressionContext.class,0);
		}
		public List<PostfixOpContext> postfixOp() {
			return getRuleContexts(PostfixOpContext.class);
		}
		public PostfixOpContext postfixOp(int i) {
			return getRuleContext(PostfixOpContext.class,i);
		}
		public PostfixExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_postfixExpression; }
	}

	public final PostfixExpressionContext postfixExpression() throws RecognitionException {
		PostfixExpressionContext _localctx = new PostfixExpressionContext(_ctx, getState());
		enterRule(_localctx, 68, RULE_postfixExpression);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(354);
			primaryExpression();
			setState(358);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,34,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(355);
					postfixOp();
					}
					} 
				}
				setState(360);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,34,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class PostfixOpContext extends ParserRuleContext {
		public TerminalNode INC() { return getToken(LinguagemParser.INC, 0); }
		public TerminalNode DEC() { return getToken(LinguagemParser.DEC, 0); }
		public TerminalNode DOT() { return getToken(LinguagemParser.DOT, 0); }
		public TerminalNode Identifier() { return getToken(LinguagemParser.Identifier, 0); }
		public TerminalNode OPTIONAL_CHAIN() { return getToken(LinguagemParser.OPTIONAL_CHAIN, 0); }
		public TerminalNode LBRACK() { return getToken(LinguagemParser.LBRACK, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode RBRACK() { return getToken(LinguagemParser.RBRACK, 0); }
		public TerminalNode LPAREN() { return getToken(LinguagemParser.LPAREN, 0); }
		public TerminalNode RPAREN() { return getToken(LinguagemParser.RPAREN, 0); }
		public ArgListContext argList() {
			return getRuleContext(ArgListContext.class,0);
		}
		public PostfixOpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_postfixOp; }
	}

	public final PostfixOpContext postfixOp() throws RecognitionException {
		PostfixOpContext _localctx = new PostfixOpContext(_ctx, getState());
		enterRule(_localctx, 70, RULE_postfixOp);
		int _la;
		try {
			setState(376);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case INC:
				enterOuterAlt(_localctx, 1);
				{
				setState(361);
				match(INC);
				}
				break;
			case DEC:
				enterOuterAlt(_localctx, 2);
				{
				setState(362);
				match(DEC);
				}
				break;
			case DOT:
				enterOuterAlt(_localctx, 3);
				{
				setState(363);
				match(DOT);
				setState(364);
				match(Identifier);
				}
				break;
			case OPTIONAL_CHAIN:
				enterOuterAlt(_localctx, 4);
				{
				setState(365);
				match(OPTIONAL_CHAIN);
				setState(366);
				match(Identifier);
				}
				break;
			case LBRACK:
				enterOuterAlt(_localctx, 5);
				{
				setState(367);
				match(LBRACK);
				setState(368);
				expression();
				setState(369);
				match(RBRACK);
				}
				break;
			case LPAREN:
				enterOuterAlt(_localctx, 6);
				{
				setState(371);
				match(LPAREN);
				setState(373);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 4615653146627145826L) != 0) || _la==Identifier) {
					{
					setState(372);
					argList();
					}
				}

				setState(375);
				match(RPAREN);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class PrimaryExpressionContext extends ParserRuleContext {
		public TerminalNode Literal() { return getToken(LinguagemParser.Literal, 0); }
		public TerminalNode BigIntLiteral() { return getToken(LinguagemParser.BigIntLiteral, 0); }
		public TerminalNode Identifier() { return getToken(LinguagemParser.Identifier, 0); }
		public TerminalNode LPAREN() { return getToken(LinguagemParser.LPAREN, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(LinguagemParser.RPAREN, 0); }
		public ObjectLiteralContext objectLiteral() {
			return getRuleContext(ObjectLiteralContext.class,0);
		}
		public ArrayLiteralContext arrayLiteral() {
			return getRuleContext(ArrayLiteralContext.class,0);
		}
		public FunctionExpressionContext functionExpression() {
			return getRuleContext(FunctionExpressionContext.class,0);
		}
		public ArrowFunctionContext arrowFunction() {
			return getRuleContext(ArrowFunctionContext.class,0);
		}
		public TerminalNode NEW() { return getToken(LinguagemParser.NEW, 0); }
		public ArgListContext argList() {
			return getRuleContext(ArgListContext.class,0);
		}
		public PrimaryExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_primaryExpression; }
	}

	public final PrimaryExpressionContext primaryExpression() throws RecognitionException {
		PrimaryExpressionContext _localctx = new PrimaryExpressionContext(_ctx, getState());
		enterRule(_localctx, 72, RULE_primaryExpression);
		int _la;
		try {
			setState(396);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,38,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(378);
				match(Literal);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(379);
				match(BigIntLiteral);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(380);
				match(Identifier);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(381);
				match(LPAREN);
				setState(382);
				expression();
				setState(383);
				match(RPAREN);
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(385);
				objectLiteral();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(386);
				arrayLiteral();
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(387);
				functionExpression();
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(388);
				arrowFunction();
				}
				break;
			case 9:
				enterOuterAlt(_localctx, 9);
				{
				setState(389);
				match(NEW);
				setState(390);
				match(Identifier);
				setState(391);
				match(LPAREN);
				setState(393);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 4615653146627145826L) != 0) || _la==Identifier) {
					{
					setState(392);
					argList();
					}
				}

				setState(395);
				match(RPAREN);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class FunctionExpressionContext extends ParserRuleContext {
		public TerminalNode FUNCTION() { return getToken(LinguagemParser.FUNCTION, 0); }
		public TerminalNode LPAREN() { return getToken(LinguagemParser.LPAREN, 0); }
		public TerminalNode RPAREN() { return getToken(LinguagemParser.RPAREN, 0); }
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public TerminalNode Identifier() { return getToken(LinguagemParser.Identifier, 0); }
		public ParamListContext paramList() {
			return getRuleContext(ParamListContext.class,0);
		}
		public FunctionExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_functionExpression; }
	}

	public final FunctionExpressionContext functionExpression() throws RecognitionException {
		FunctionExpressionContext _localctx = new FunctionExpressionContext(_ctx, getState());
		enterRule(_localctx, 74, RULE_functionExpression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(398);
			match(FUNCTION);
			setState(400);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==Identifier) {
				{
				setState(399);
				match(Identifier);
				}
			}

			setState(402);
			match(LPAREN);
			setState(404);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==Identifier) {
				{
				setState(403);
				paramList();
				}
			}

			setState(406);
			match(RPAREN);
			setState(407);
			block();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ArrowFunctionContext extends ParserRuleContext {
		public TerminalNode Identifier() { return getToken(LinguagemParser.Identifier, 0); }
		public TerminalNode ARROW() { return getToken(LinguagemParser.ARROW, 0); }
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode LPAREN() { return getToken(LinguagemParser.LPAREN, 0); }
		public TerminalNode RPAREN() { return getToken(LinguagemParser.RPAREN, 0); }
		public ParamListContext paramList() {
			return getRuleContext(ParamListContext.class,0);
		}
		public ArrowFunctionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_arrowFunction; }
	}

	public final ArrowFunctionContext arrowFunction() throws RecognitionException {
		ArrowFunctionContext _localctx = new ArrowFunctionContext(_ctx, getState());
		enterRule(_localctx, 76, RULE_arrowFunction);
		int _la;
		try {
			setState(425);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case Identifier:
				enterOuterAlt(_localctx, 1);
				{
				setState(409);
				match(Identifier);
				setState(410);
				match(ARROW);
				setState(413);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,41,_ctx) ) {
				case 1:
					{
					setState(411);
					block();
					}
					break;
				case 2:
					{
					setState(412);
					expression();
					}
					break;
				}
				}
				break;
			case LPAREN:
				enterOuterAlt(_localctx, 2);
				{
				setState(415);
				match(LPAREN);
				setState(417);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==Identifier) {
					{
					setState(416);
					paramList();
					}
				}

				setState(419);
				match(RPAREN);
				setState(420);
				match(ARROW);
				setState(423);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,43,_ctx) ) {
				case 1:
					{
					setState(421);
					block();
					}
					break;
				case 2:
					{
					setState(422);
					expression();
					}
					break;
				}
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ObjectLiteralContext extends ParserRuleContext {
		public TerminalNode LBRACE() { return getToken(LinguagemParser.LBRACE, 0); }
		public TerminalNode RBRACE() { return getToken(LinguagemParser.RBRACE, 0); }
		public List<PropertyContext> property() {
			return getRuleContexts(PropertyContext.class);
		}
		public PropertyContext property(int i) {
			return getRuleContext(PropertyContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(LinguagemParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(LinguagemParser.COMMA, i);
		}
		public ObjectLiteralContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_objectLiteral; }
	}

	public final ObjectLiteralContext objectLiteral() throws RecognitionException {
		ObjectLiteralContext _localctx = new ObjectLiteralContext(_ctx, getState());
		enterRule(_localctx, 78, RULE_objectLiteral);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(427);
			match(LBRACE);
			setState(436);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==Identifier) {
				{
				setState(428);
				property();
				setState(433);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(429);
					match(COMMA);
					setState(430);
					property();
					}
					}
					setState(435);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(438);
			match(RBRACE);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class PropertyContext extends ParserRuleContext {
		public TerminalNode Identifier() { return getToken(LinguagemParser.Identifier, 0); }
		public TerminalNode COLON() { return getToken(LinguagemParser.COLON, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public PropertyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_property; }
	}

	public final PropertyContext property() throws RecognitionException {
		PropertyContext _localctx = new PropertyContext(_ctx, getState());
		enterRule(_localctx, 80, RULE_property);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(440);
			match(Identifier);
			setState(441);
			match(COLON);
			setState(442);
			expression();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ArrayLiteralContext extends ParserRuleContext {
		public TerminalNode LBRACK() { return getToken(LinguagemParser.LBRACK, 0); }
		public TerminalNode RBRACK() { return getToken(LinguagemParser.RBRACK, 0); }
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(LinguagemParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(LinguagemParser.COMMA, i);
		}
		public ArrayLiteralContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_arrayLiteral; }
	}

	public final ArrayLiteralContext arrayLiteral() throws RecognitionException {
		ArrayLiteralContext _localctx = new ArrayLiteralContext(_ctx, getState());
		enterRule(_localctx, 82, RULE_arrayLiteral);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(444);
			match(LBRACK);
			setState(453);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 4615653146627145826L) != 0) || _la==Identifier) {
				{
				setState(445);
				expression();
				setState(450);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(446);
					match(COMMA);
					setState(447);
					expression();
					}
					}
					setState(452);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(455);
			match(RBRACK);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ArgListContext extends ParserRuleContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(LinguagemParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(LinguagemParser.COMMA, i);
		}
		public ArgListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_argList; }
	}

	public final ArgListContext argList() throws RecognitionException {
		ArgListContext _localctx = new ArgListContext(_ctx, getState());
		enterRule(_localctx, 84, RULE_argList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(457);
			expression();
			setState(462);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(458);
				match(COMMA);
				setState(459);
				expression();
				}
				}
				setState(464);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static final String _serializedATN =
		"\u0004\u0001P\u01d2\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002"+
		"\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007\u0002"+
		"\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b\u0002"+
		"\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0002\u000f\u0007\u000f"+
		"\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011\u0002\u0012\u0007\u0012"+
		"\u0002\u0013\u0007\u0013\u0002\u0014\u0007\u0014\u0002\u0015\u0007\u0015"+
		"\u0002\u0016\u0007\u0016\u0002\u0017\u0007\u0017\u0002\u0018\u0007\u0018"+
		"\u0002\u0019\u0007\u0019\u0002\u001a\u0007\u001a\u0002\u001b\u0007\u001b"+
		"\u0002\u001c\u0007\u001c\u0002\u001d\u0007\u001d\u0002\u001e\u0007\u001e"+
		"\u0002\u001f\u0007\u001f\u0002 \u0007 \u0002!\u0007!\u0002\"\u0007\"\u0002"+
		"#\u0007#\u0002$\u0007$\u0002%\u0007%\u0002&\u0007&\u0002\'\u0007\'\u0002"+
		"(\u0007(\u0002)\u0007)\u0002*\u0007*\u0001\u0000\u0005\u0000X\b\u0000"+
		"\n\u0000\f\u0000[\t\u0000\u0001\u0000\u0001\u0000\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0003\u0001"+
		"r\b\u0001\u0001\u0002\u0001\u0002\u0005\u0002v\b\u0002\n\u0002\f\u0002"+
		"y\t\u0002\u0001\u0002\u0001\u0002\u0001\u0003\u0001\u0003\u0001\u0003"+
		"\u0001\u0003\u0005\u0003\u0081\b\u0003\n\u0003\f\u0003\u0084\t\u0003\u0001"+
		"\u0004\u0001\u0004\u0001\u0004\u0003\u0004\u0089\b\u0004\u0001\u0005\u0001"+
		"\u0005\u0001\u0005\u0001\u0005\u0003\u0005\u008f\b\u0005\u0001\u0005\u0001"+
		"\u0005\u0001\u0005\u0001\u0006\u0001\u0006\u0001\u0006\u0005\u0006\u0097"+
		"\b\u0006\n\u0006\f\u0006\u009a\t\u0006\u0001\u0007\u0001\u0007\u0003\u0007"+
		"\u009e\b\u0007\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b"+
		"\u0003\b\u00a7\b\b\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001"+
		"\t\u0005\t\u00b0\b\t\n\t\f\t\u00b3\t\t\u0001\t\u0001\t\u0001\n\u0001\n"+
		"\u0001\n\u0001\n\u0005\n\u00bb\b\n\n\n\f\n\u00be\t\n\u0001\u000b\u0001"+
		"\u000b\u0001\u000b\u0005\u000b\u00c3\b\u000b\n\u000b\f\u000b\u00c6\t\u000b"+
		"\u0001\f\u0001\f\u0001\f\u0003\f\u00cb\b\f\u0001\f\u0001\f\u0003\f\u00cf"+
		"\b\f\u0001\f\u0001\f\u0003\f\u00d3\b\f\u0001\f\u0001\f\u0001\f\u0001\r"+
		"\u0001\r\u0003\r\u00da\b\r\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e"+
		"\u0001\u000e\u0001\u000e\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f"+
		"\u0001\u000f\u0001\u000f\u0001\u000f\u0003\u000f\u00e9\b\u000f\u0001\u0010"+
		"\u0001\u0010\u0003\u0010\u00ed\b\u0010\u0001\u0010\u0001\u0010\u0001\u0011"+
		"\u0001\u0011\u0003\u0011\u00f3\b\u0011\u0001\u0011\u0001\u0011\u0001\u0012"+
		"\u0001\u0012\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0003\u0013"+
		"\u00fd\b\u0013\u0001\u0014\u0001\u0014\u0001\u0015\u0001\u0015\u0001\u0015"+
		"\u0001\u0015\u0001\u0015\u0001\u0015\u0003\u0015\u0107\b\u0015\u0001\u0016"+
		"\u0001\u0016\u0001\u0016\u0005\u0016\u010c\b\u0016\n\u0016\f\u0016\u010f"+
		"\t\u0016\u0001\u0017\u0001\u0017\u0001\u0017\u0005\u0017\u0114\b\u0017"+
		"\n\u0017\f\u0017\u0117\t\u0017\u0001\u0018\u0001\u0018\u0001\u0018\u0005"+
		"\u0018\u011c\b\u0018\n\u0018\f\u0018\u011f\t\u0018\u0001\u0019\u0001\u0019"+
		"\u0001\u0019\u0005\u0019\u0124\b\u0019\n\u0019\f\u0019\u0127\t\u0019\u0001"+
		"\u001a\u0001\u001a\u0001\u001a\u0005\u001a\u012c\b\u001a\n\u001a\f\u001a"+
		"\u012f\t\u001a\u0001\u001b\u0001\u001b\u0001\u001b\u0005\u001b\u0134\b"+
		"\u001b\n\u001b\f\u001b\u0137\t\u001b\u0001\u001c\u0001\u001c\u0001\u001c"+
		"\u0005\u001c\u013c\b\u001c\n\u001c\f\u001c\u013f\t\u001c\u0001\u001d\u0001"+
		"\u001d\u0001\u001d\u0005\u001d\u0144\b\u001d\n\u001d\f\u001d\u0147\t\u001d"+
		"\u0001\u001e\u0001\u001e\u0001\u001e\u0005\u001e\u014c\b\u001e\n\u001e"+
		"\f\u001e\u014f\t\u001e\u0001\u001f\u0001\u001f\u0001\u001f\u0005\u001f"+
		"\u0154\b\u001f\n\u001f\f\u001f\u0157\t\u001f\u0001 \u0001 \u0001 \u0003"+
		" \u015c\b \u0001!\u0001!\u0001!\u0003!\u0161\b!\u0001\"\u0001\"\u0005"+
		"\"\u0165\b\"\n\"\f\"\u0168\t\"\u0001#\u0001#\u0001#\u0001#\u0001#\u0001"+
		"#\u0001#\u0001#\u0001#\u0001#\u0001#\u0001#\u0003#\u0176\b#\u0001#\u0003"+
		"#\u0179\b#\u0001$\u0001$\u0001$\u0001$\u0001$\u0001$\u0001$\u0001$\u0001"+
		"$\u0001$\u0001$\u0001$\u0001$\u0001$\u0001$\u0003$\u018a\b$\u0001$\u0003"+
		"$\u018d\b$\u0001%\u0001%\u0003%\u0191\b%\u0001%\u0001%\u0003%\u0195\b"+
		"%\u0001%\u0001%\u0001%\u0001&\u0001&\u0001&\u0001&\u0003&\u019e\b&\u0001"+
		"&\u0001&\u0003&\u01a2\b&\u0001&\u0001&\u0001&\u0001&\u0003&\u01a8\b&\u0003"+
		"&\u01aa\b&\u0001\'\u0001\'\u0001\'\u0001\'\u0005\'\u01b0\b\'\n\'\f\'\u01b3"+
		"\t\'\u0003\'\u01b5\b\'\u0001\'\u0001\'\u0001(\u0001(\u0001(\u0001(\u0001"+
		")\u0001)\u0001)\u0001)\u0005)\u01c1\b)\n)\f)\u01c4\t)\u0003)\u01c6\b)"+
		"\u0001)\u0001)\u0001*\u0001*\u0001*\u0005*\u01cd\b*\n*\f*\u01d0\t*\u0001"+
		"*\u0000\u0000+\u0000\u0002\u0004\u0006\b\n\f\u000e\u0010\u0012\u0014\u0016"+
		"\u0018\u001a\u001c\u001e \"$&(*,.02468:<>@BDFHJLNPRT\u0000\b\u0001\u0000"+
		"\b\n\u0001\u0000DJ\u0001\u00008;\u0002\u0000\u0016\u001747\u0001\u0000"+
		"BC\u0001\u0000+,\u0001\u0000-/\u0004\u0000\u0018\u0019+,13>>\u01ee\u0000"+
		"Y\u0001\u0000\u0000\u0000\u0002q\u0001\u0000\u0000\u0000\u0004s\u0001"+
		"\u0000\u0000\u0000\u0006|\u0001\u0000\u0000\u0000\b\u0085\u0001\u0000"+
		"\u0000\u0000\n\u008a\u0001\u0000\u0000\u0000\f\u0093\u0001\u0000\u0000"+
		"\u0000\u000e\u009b\u0001\u0000\u0000\u0000\u0010\u009f\u0001\u0000\u0000"+
		"\u0000\u0012\u00a8\u0001\u0000\u0000\u0000\u0014\u00b6\u0001\u0000\u0000"+
		"\u0000\u0016\u00bf\u0001\u0000\u0000\u0000\u0018\u00c7\u0001\u0000\u0000"+
		"\u0000\u001a\u00d9\u0001\u0000\u0000\u0000\u001c\u00db\u0001\u0000\u0000"+
		"\u0000\u001e\u00e1\u0001\u0000\u0000\u0000 \u00ea\u0001\u0000\u0000\u0000"+
		"\"\u00f0\u0001\u0000\u0000\u0000$\u00f6\u0001\u0000\u0000\u0000&\u00f8"+
		"\u0001\u0000\u0000\u0000(\u00fe\u0001\u0000\u0000\u0000*\u0100\u0001\u0000"+
		"\u0000\u0000,\u0108\u0001\u0000\u0000\u0000.\u0110\u0001\u0000\u0000\u0000"+
		"0\u0118\u0001\u0000\u0000\u00002\u0120\u0001\u0000\u0000\u00004\u0128"+
		"\u0001\u0000\u0000\u00006\u0130\u0001\u0000\u0000\u00008\u0138\u0001\u0000"+
		"\u0000\u0000:\u0140\u0001\u0000\u0000\u0000<\u0148\u0001\u0000\u0000\u0000"+
		">\u0150\u0001\u0000\u0000\u0000@\u0158\u0001\u0000\u0000\u0000B\u0160"+
		"\u0001\u0000\u0000\u0000D\u0162\u0001\u0000\u0000\u0000F\u0178\u0001\u0000"+
		"\u0000\u0000H\u018c\u0001\u0000\u0000\u0000J\u018e\u0001\u0000\u0000\u0000"+
		"L\u01a9\u0001\u0000\u0000\u0000N\u01ab\u0001\u0000\u0000\u0000P\u01b8"+
		"\u0001\u0000\u0000\u0000R\u01bc\u0001\u0000\u0000\u0000T\u01c9\u0001\u0000"+
		"\u0000\u0000VX\u0003\u0002\u0001\u0000WV\u0001\u0000\u0000\u0000X[\u0001"+
		"\u0000\u0000\u0000YW\u0001\u0000\u0000\u0000YZ\u0001\u0000\u0000\u0000"+
		"Z\\\u0001\u0000\u0000\u0000[Y\u0001\u0000\u0000\u0000\\]\u0005\u0000\u0000"+
		"\u0001]\u0001\u0001\u0000\u0000\u0000^r\u0003\u0004\u0002\u0000_`\u0003"+
		"\u0006\u0003\u0000`a\u0005\u001e\u0000\u0000ar\u0001\u0000\u0000\u0000"+
		"bc\u0003\u000e\u0007\u0000cd\u0005\u001e\u0000\u0000dr\u0001\u0000\u0000"+
		"\u0000er\u0003\n\u0005\u0000fr\u0003 \u0010\u0000gr\u0003\"\u0011\u0000"+
		"hi\u0003$\u0012\u0000ij\u0005\u001e\u0000\u0000jr\u0001\u0000\u0000\u0000"+
		"kr\u0003\u0010\b\u0000lr\u0003\u0012\t\u0000mr\u0003\u0018\f\u0000nr\u0003"+
		"\u001c\u000e\u0000or\u0003\u001e\u000f\u0000pr\u0005\u001e\u0000\u0000"+
		"q^\u0001\u0000\u0000\u0000q_\u0001\u0000\u0000\u0000qb\u0001\u0000\u0000"+
		"\u0000qe\u0001\u0000\u0000\u0000qf\u0001\u0000\u0000\u0000qg\u0001\u0000"+
		"\u0000\u0000qh\u0001\u0000\u0000\u0000qk\u0001\u0000\u0000\u0000ql\u0001"+
		"\u0000\u0000\u0000qm\u0001\u0000\u0000\u0000qn\u0001\u0000\u0000\u0000"+
		"qo\u0001\u0000\u0000\u0000qp\u0001\u0000\u0000\u0000r\u0003\u0001\u0000"+
		"\u0000\u0000sw\u0005\"\u0000\u0000tv\u0003\u0002\u0001\u0000ut\u0001\u0000"+
		"\u0000\u0000vy\u0001\u0000\u0000\u0000wu\u0001\u0000\u0000\u0000wx\u0001"+
		"\u0000\u0000\u0000xz\u0001\u0000\u0000\u0000yw\u0001\u0000\u0000\u0000"+
		"z{\u0005#\u0000\u0000{\u0005\u0001\u0000\u0000\u0000|}\u0007\u0000\u0000"+
		"\u0000}\u0082\u0003\b\u0004\u0000~\u007f\u0005\u001f\u0000\u0000\u007f"+
		"\u0081\u0003\b\u0004\u0000\u0080~\u0001\u0000\u0000\u0000\u0081\u0084"+
		"\u0001\u0000\u0000\u0000\u0082\u0080\u0001\u0000\u0000\u0000\u0082\u0083"+
		"\u0001\u0000\u0000\u0000\u0083\u0007\u0001\u0000\u0000\u0000\u0084\u0082"+
		"\u0001\u0000\u0000\u0000\u0085\u0088\u0005N\u0000\u0000\u0086\u0087\u0005"+
		"D\u0000\u0000\u0087\u0089\u0003$\u0012\u0000\u0088\u0086\u0001\u0000\u0000"+
		"\u0000\u0088\u0089\u0001\u0000\u0000\u0000\u0089\t\u0001\u0000\u0000\u0000"+
		"\u008a\u008b\u0005\u0006\u0000\u0000\u008b\u008c\u0005N\u0000\u0000\u008c"+
		"\u008e\u0005 \u0000\u0000\u008d\u008f\u0003\f\u0006\u0000\u008e\u008d"+
		"\u0001\u0000\u0000\u0000\u008e\u008f\u0001\u0000\u0000\u0000\u008f\u0090"+
		"\u0001\u0000\u0000\u0000\u0090\u0091\u0005!\u0000\u0000\u0091\u0092\u0003"+
		"\u0004\u0002\u0000\u0092\u000b\u0001\u0000\u0000\u0000\u0093\u0098\u0005"+
		"N\u0000\u0000\u0094\u0095\u0005\u001f\u0000\u0000\u0095\u0097\u0005N\u0000"+
		"\u0000\u0096\u0094\u0001\u0000\u0000\u0000\u0097\u009a\u0001\u0000\u0000"+
		"\u0000\u0098\u0096\u0001\u0000\u0000\u0000\u0098\u0099\u0001\u0000\u0000"+
		"\u0000\u0099\r\u0001\u0000\u0000\u0000\u009a\u0098\u0001\u0000\u0000\u0000"+
		"\u009b\u009d\u0005\u0007\u0000\u0000\u009c\u009e\u0003$\u0012\u0000\u009d"+
		"\u009c\u0001\u0000\u0000\u0000\u009d\u009e\u0001\u0000\u0000\u0000\u009e"+
		"\u000f\u0001\u0000\u0000\u0000\u009f\u00a0\u0005\u000b\u0000\u0000\u00a0"+
		"\u00a1\u0005 \u0000\u0000\u00a1\u00a2\u0003$\u0012\u0000\u00a2\u00a3\u0005"+
		"!\u0000\u0000\u00a3\u00a6\u0003\u0002\u0001\u0000\u00a4\u00a5\u0005\f"+
		"\u0000\u0000\u00a5\u00a7\u0003\u0002\u0001\u0000\u00a6\u00a4\u0001\u0000"+
		"\u0000\u0000\u00a6\u00a7\u0001\u0000\u0000\u0000\u00a7\u0011\u0001\u0000"+
		"\u0000\u0000\u00a8\u00a9\u0005\r\u0000\u0000\u00a9\u00aa\u0005 \u0000"+
		"\u0000\u00aa\u00ab\u0003$\u0012\u0000\u00ab\u00ac\u0005!\u0000\u0000\u00ac"+
		"\u00b1\u0005\"\u0000\u0000\u00ad\u00b0\u0003\u0014\n\u0000\u00ae\u00b0"+
		"\u0003\u0016\u000b\u0000\u00af\u00ad\u0001\u0000\u0000\u0000\u00af\u00ae"+
		"\u0001\u0000\u0000\u0000\u00b0\u00b3\u0001\u0000\u0000\u0000\u00b1\u00af"+
		"\u0001\u0000\u0000\u0000\u00b1\u00b2\u0001\u0000\u0000\u0000\u00b2\u00b4"+
		"\u0001\u0000\u0000\u0000\u00b3\u00b1\u0001\u0000\u0000\u0000\u00b4\u00b5"+
		"\u0005#\u0000\u0000\u00b5\u0013\u0001\u0000\u0000\u0000\u00b6\u00b7\u0005"+
		"\u000e\u0000\u0000\u00b7\u00b8\u0003$\u0012\u0000\u00b8\u00bc\u0005\'"+
		"\u0000\u0000\u00b9\u00bb\u0003\u0002\u0001\u0000\u00ba\u00b9\u0001\u0000"+
		"\u0000\u0000\u00bb\u00be\u0001\u0000\u0000\u0000\u00bc\u00ba\u0001\u0000"+
		"\u0000\u0000\u00bc\u00bd\u0001\u0000\u0000\u0000\u00bd\u0015\u0001\u0000"+
		"\u0000\u0000\u00be\u00bc\u0001\u0000\u0000\u0000\u00bf\u00c0\u0005\u000f"+
		"\u0000\u0000\u00c0\u00c4\u0005\'\u0000\u0000\u00c1\u00c3\u0003\u0002\u0001"+
		"\u0000\u00c2\u00c1\u0001\u0000\u0000\u0000\u00c3\u00c6\u0001\u0000\u0000"+
		"\u0000\u00c4\u00c2\u0001\u0000\u0000\u0000\u00c4\u00c5\u0001\u0000\u0000"+
		"\u0000\u00c5\u0017\u0001\u0000\u0000\u0000\u00c6\u00c4\u0001\u0000\u0000"+
		"\u0000\u00c7\u00c8\u0005\u0010\u0000\u0000\u00c8\u00ca\u0005 \u0000\u0000"+
		"\u00c9\u00cb\u0003\u001a\r\u0000\u00ca\u00c9\u0001\u0000\u0000\u0000\u00ca"+
		"\u00cb\u0001\u0000\u0000\u0000\u00cb\u00cc\u0001\u0000\u0000\u0000\u00cc"+
		"\u00ce\u0005\u001e\u0000\u0000\u00cd\u00cf\u0003$\u0012\u0000\u00ce\u00cd"+
		"\u0001\u0000\u0000\u0000\u00ce\u00cf\u0001\u0000\u0000\u0000\u00cf\u00d0"+
		"\u0001\u0000\u0000\u0000\u00d0\u00d2\u0005\u001e\u0000\u0000\u00d1\u00d3"+
		"\u0003$\u0012\u0000\u00d2\u00d1\u0001\u0000\u0000\u0000\u00d2\u00d3\u0001"+
		"\u0000\u0000\u0000\u00d3\u00d4\u0001\u0000\u0000\u0000\u00d4\u00d5\u0005"+
		"!\u0000\u0000\u00d5\u00d6\u0003\u0002\u0001\u0000\u00d6\u0019\u0001\u0000"+
		"\u0000\u0000\u00d7\u00da\u0003\u0006\u0003\u0000\u00d8\u00da\u0003$\u0012"+
		"\u0000\u00d9\u00d7\u0001\u0000\u0000\u0000\u00d9\u00d8\u0001\u0000\u0000"+
		"\u0000\u00da\u001b\u0001\u0000\u0000\u0000\u00db\u00dc\u0005\u0011\u0000"+
		"\u0000\u00dc\u00dd\u0005 \u0000\u0000\u00dd\u00de\u0003$\u0012\u0000\u00de"+
		"\u00df\u0005!\u0000\u0000\u00df\u00e0\u0003\u0002\u0001\u0000\u00e0\u001d"+
		"\u0001\u0000\u0000\u0000\u00e1\u00e2\u0005\u0012\u0000\u0000\u00e2\u00e3"+
		"\u0003\u0004\u0002\u0000\u00e3\u00e4\u0005\u0011\u0000\u0000\u00e4\u00e5"+
		"\u0005 \u0000\u0000\u00e5\u00e6\u0003$\u0012\u0000\u00e6\u00e8\u0005!"+
		"\u0000\u0000\u00e7\u00e9\u0005\u001e\u0000\u0000\u00e8\u00e7\u0001\u0000"+
		"\u0000\u0000\u00e8\u00e9\u0001\u0000\u0000\u0000\u00e9\u001f\u0001\u0000"+
		"\u0000\u0000\u00ea\u00ec\u0005\u0013\u0000\u0000\u00eb\u00ed\u0005N\u0000"+
		"\u0000\u00ec\u00eb\u0001\u0000\u0000\u0000\u00ec\u00ed\u0001\u0000\u0000"+
		"\u0000\u00ed\u00ee\u0001\u0000\u0000\u0000\u00ee\u00ef\u0005\u001e\u0000"+
		"\u0000\u00ef!\u0001\u0000\u0000\u0000\u00f0\u00f2\u0005\u0014\u0000\u0000"+
		"\u00f1\u00f3\u0005N\u0000\u0000\u00f2\u00f1\u0001\u0000\u0000\u0000\u00f2"+
		"\u00f3\u0001\u0000\u0000\u0000\u00f3\u00f4\u0001\u0000\u0000\u0000\u00f4"+
		"\u00f5\u0005\u001e\u0000\u0000\u00f5#\u0001\u0000\u0000\u0000\u00f6\u00f7"+
		"\u0003&\u0013\u0000\u00f7%\u0001\u0000\u0000\u0000\u00f8\u00fc\u0003*"+
		"\u0015\u0000\u00f9\u00fa\u0003(\u0014\u0000\u00fa\u00fb\u0003&\u0013\u0000"+
		"\u00fb\u00fd\u0001\u0000\u0000\u0000\u00fc\u00f9\u0001\u0000\u0000\u0000"+
		"\u00fc\u00fd\u0001\u0000\u0000\u0000\u00fd\'\u0001\u0000\u0000\u0000\u00fe"+
		"\u00ff\u0007\u0001\u0000\u0000\u00ff)\u0001\u0000\u0000\u0000\u0100\u0106"+
		"\u0003,\u0016\u0000\u0101\u0102\u0005(\u0000\u0000\u0102\u0103\u0003$"+
		"\u0012\u0000\u0103\u0104\u0005\'\u0000\u0000\u0104\u0105\u0003&\u0013"+
		"\u0000\u0105\u0107\u0001\u0000\u0000\u0000\u0106\u0101\u0001\u0000\u0000"+
		"\u0000\u0106\u0107\u0001\u0000\u0000\u0000\u0107+\u0001\u0000\u0000\u0000"+
		"\u0108\u010d\u0003.\u0017\u0000\u0109\u010a\u0005=\u0000\u0000\u010a\u010c"+
		"\u0003.\u0017\u0000\u010b\u0109\u0001\u0000\u0000\u0000\u010c\u010f\u0001"+
		"\u0000\u0000\u0000\u010d\u010b\u0001\u0000\u0000\u0000\u010d\u010e\u0001"+
		"\u0000\u0000\u0000\u010e-\u0001\u0000\u0000\u0000\u010f\u010d\u0001\u0000"+
		"\u0000\u0000\u0110\u0115\u00030\u0018\u0000\u0111\u0112\u0005<\u0000\u0000"+
		"\u0112\u0114\u00030\u0018\u0000\u0113\u0111\u0001\u0000\u0000\u0000\u0114"+
		"\u0117\u0001\u0000\u0000\u0000\u0115\u0113\u0001\u0000\u0000\u0000\u0115"+
		"\u0116\u0001\u0000\u0000\u0000\u0116/\u0001\u0000\u0000\u0000\u0117\u0115"+
		"\u0001\u0000\u0000\u0000\u0118\u011d\u00032\u0019\u0000\u0119\u011a\u0005"+
		"@\u0000\u0000\u011a\u011c\u00032\u0019\u0000\u011b\u0119\u0001\u0000\u0000"+
		"\u0000\u011c\u011f\u0001\u0000\u0000\u0000\u011d\u011b\u0001\u0000\u0000"+
		"\u0000\u011d\u011e\u0001\u0000\u0000\u0000\u011e1\u0001\u0000\u0000\u0000"+
		"\u011f\u011d\u0001\u0000\u0000\u0000\u0120\u0125\u00034\u001a\u0000\u0121"+
		"\u0122\u0005?\u0000\u0000\u0122\u0124\u00034\u001a\u0000\u0123\u0121\u0001"+
		"\u0000\u0000\u0000\u0124\u0127\u0001\u0000\u0000\u0000\u0125\u0123\u0001"+
		"\u0000\u0000\u0000\u0125\u0126\u0001\u0000\u0000\u0000\u01263\u0001\u0000"+
		"\u0000\u0000\u0127\u0125\u0001\u0000\u0000\u0000\u0128\u012d\u00036\u001b"+
		"\u0000\u0129\u012a\u0005A\u0000\u0000\u012a\u012c\u00036\u001b\u0000\u012b"+
		"\u0129\u0001\u0000\u0000\u0000\u012c\u012f\u0001\u0000\u0000\u0000\u012d"+
		"\u012b\u0001\u0000\u0000\u0000\u012d\u012e\u0001\u0000\u0000\u0000\u012e"+
		"5\u0001\u0000\u0000\u0000\u012f\u012d\u0001\u0000\u0000\u0000\u0130\u0135"+
		"\u00038\u001c\u0000\u0131\u0132\u0007\u0002\u0000\u0000\u0132\u0134\u0003"+
		"8\u001c\u0000\u0133\u0131\u0001\u0000\u0000\u0000\u0134\u0137\u0001\u0000"+
		"\u0000\u0000\u0135\u0133\u0001\u0000\u0000\u0000\u0135\u0136\u0001\u0000"+
		"\u0000\u0000\u01367\u0001\u0000\u0000\u0000\u0137\u0135\u0001\u0000\u0000"+
		"\u0000\u0138\u013d\u0003:\u001d\u0000\u0139\u013a\u0007\u0003\u0000\u0000"+
		"\u013a\u013c\u0003:\u001d\u0000\u013b\u0139\u0001\u0000\u0000\u0000\u013c"+
		"\u013f\u0001\u0000\u0000\u0000\u013d\u013b\u0001\u0000\u0000\u0000\u013d"+
		"\u013e\u0001\u0000\u0000\u0000\u013e9\u0001\u0000\u0000\u0000\u013f\u013d"+
		"\u0001\u0000\u0000\u0000\u0140\u0145\u0003<\u001e\u0000\u0141\u0142\u0007"+
		"\u0004\u0000\u0000\u0142\u0144\u0003<\u001e\u0000\u0143\u0141\u0001\u0000"+
		"\u0000\u0000\u0144\u0147\u0001\u0000\u0000\u0000\u0145\u0143\u0001\u0000"+
		"\u0000\u0000\u0145\u0146\u0001\u0000\u0000\u0000\u0146;\u0001\u0000\u0000"+
		"\u0000\u0147\u0145\u0001\u0000\u0000\u0000\u0148\u014d\u0003>\u001f\u0000"+
		"\u0149\u014a\u0007\u0005\u0000\u0000\u014a\u014c\u0003>\u001f\u0000\u014b"+
		"\u0149\u0001\u0000\u0000\u0000\u014c\u014f\u0001\u0000\u0000\u0000\u014d"+
		"\u014b\u0001\u0000\u0000\u0000\u014d\u014e\u0001\u0000\u0000\u0000\u014e"+
		"=\u0001\u0000\u0000\u0000\u014f\u014d\u0001\u0000\u0000\u0000\u0150\u0155"+
		"\u0003@ \u0000\u0151\u0152\u0007\u0006\u0000\u0000\u0152\u0154\u0003@"+
		" \u0000\u0153\u0151\u0001\u0000\u0000\u0000\u0154\u0157\u0001\u0000\u0000"+
		"\u0000\u0155\u0153\u0001\u0000\u0000\u0000\u0155\u0156\u0001\u0000\u0000"+
		"\u0000\u0156?\u0001\u0000\u0000\u0000\u0157\u0155\u0001\u0000\u0000\u0000"+
		"\u0158\u015b\u0003B!\u0000\u0159\u015a\u00050\u0000\u0000\u015a\u015c"+
		"\u0003@ \u0000\u015b\u0159\u0001\u0000\u0000\u0000\u015b\u015c\u0001\u0000"+
		"\u0000\u0000\u015cA\u0001\u0000\u0000\u0000\u015d\u015e\u0007\u0007\u0000"+
		"\u0000\u015e\u0161\u0003B!\u0000\u015f\u0161\u0003D\"\u0000\u0160\u015d"+
		"\u0001\u0000\u0000\u0000\u0160\u015f\u0001\u0000\u0000\u0000\u0161C\u0001"+
		"\u0000\u0000\u0000\u0162\u0166\u0003H$\u0000\u0163\u0165\u0003F#\u0000"+
		"\u0164\u0163\u0001\u0000\u0000\u0000\u0165\u0168\u0001\u0000\u0000\u0000"+
		"\u0166\u0164\u0001\u0000\u0000\u0000\u0166\u0167\u0001\u0000\u0000\u0000"+
		"\u0167E\u0001\u0000\u0000\u0000\u0168\u0166\u0001\u0000\u0000\u0000\u0169"+
		"\u0179\u00051\u0000\u0000\u016a\u0179\u00052\u0000\u0000\u016b\u016c\u0005"+
		"&\u0000\u0000\u016c\u0179\u0005N\u0000\u0000\u016d\u016e\u0005*\u0000"+
		"\u0000\u016e\u0179\u0005N\u0000\u0000\u016f\u0170\u0005$\u0000\u0000\u0170"+
		"\u0171\u0003$\u0012\u0000\u0171\u0172\u0005%\u0000\u0000\u0172\u0179\u0001"+
		"\u0000\u0000\u0000\u0173\u0175\u0005 \u0000\u0000\u0174\u0176\u0003T*"+
		"\u0000\u0175\u0174\u0001\u0000\u0000\u0000\u0175\u0176\u0001\u0000\u0000"+
		"\u0000\u0176\u0177\u0001\u0000\u0000\u0000\u0177\u0179\u0005!\u0000\u0000"+
		"\u0178\u0169\u0001\u0000\u0000\u0000\u0178\u016a\u0001\u0000\u0000\u0000"+
		"\u0178\u016b\u0001\u0000\u0000\u0000\u0178\u016d\u0001\u0000\u0000\u0000"+
		"\u0178\u016f\u0001\u0000\u0000\u0000\u0178\u0173\u0001\u0000\u0000\u0000"+
		"\u0179G\u0001\u0000\u0000\u0000\u017a\u018d\u0005\u0001\u0000\u0000\u017b"+
		"\u018d\u0005\u0005\u0000\u0000\u017c\u018d\u0005N\u0000\u0000\u017d\u017e"+
		"\u0005 \u0000\u0000\u017e\u017f\u0003$\u0012\u0000\u017f\u0180\u0005!"+
		"\u0000\u0000\u0180\u018d\u0001\u0000\u0000\u0000\u0181\u018d\u0003N\'"+
		"\u0000\u0182\u018d\u0003R)\u0000\u0183\u018d\u0003J%\u0000\u0184\u018d"+
		"\u0003L&\u0000\u0185\u0186\u0005\u0015\u0000\u0000\u0186\u0187\u0005N"+
		"\u0000\u0000\u0187\u0189\u0005 \u0000\u0000\u0188\u018a\u0003T*\u0000"+
		"\u0189\u0188\u0001\u0000\u0000\u0000\u0189\u018a\u0001\u0000\u0000\u0000"+
		"\u018a\u018b\u0001\u0000\u0000\u0000\u018b\u018d\u0005!\u0000\u0000\u018c"+
		"\u017a\u0001\u0000\u0000\u0000\u018c\u017b\u0001\u0000\u0000\u0000\u018c"+
		"\u017c\u0001\u0000\u0000\u0000\u018c\u017d\u0001\u0000\u0000\u0000\u018c"+
		"\u0181\u0001\u0000\u0000\u0000\u018c\u0182\u0001\u0000\u0000\u0000\u018c"+
		"\u0183\u0001\u0000\u0000\u0000\u018c\u0184\u0001\u0000\u0000\u0000\u018c"+
		"\u0185\u0001\u0000\u0000\u0000\u018dI\u0001\u0000\u0000\u0000\u018e\u0190"+
		"\u0005\u0006\u0000\u0000\u018f\u0191\u0005N\u0000\u0000\u0190\u018f\u0001"+
		"\u0000\u0000\u0000\u0190\u0191\u0001\u0000\u0000\u0000\u0191\u0192\u0001"+
		"\u0000\u0000\u0000\u0192\u0194\u0005 \u0000\u0000\u0193\u0195\u0003\f"+
		"\u0006\u0000\u0194\u0193\u0001\u0000\u0000\u0000\u0194\u0195\u0001\u0000"+
		"\u0000\u0000\u0195\u0196\u0001\u0000\u0000\u0000\u0196\u0197\u0005!\u0000"+
		"\u0000\u0197\u0198\u0003\u0004\u0002\u0000\u0198K\u0001\u0000\u0000\u0000"+
		"\u0199\u019a\u0005N\u0000\u0000\u019a\u019d\u0005)\u0000\u0000\u019b\u019e"+
		"\u0003\u0004\u0002\u0000\u019c\u019e\u0003$\u0012\u0000\u019d\u019b\u0001"+
		"\u0000\u0000\u0000\u019d\u019c\u0001\u0000\u0000\u0000\u019e\u01aa\u0001"+
		"\u0000\u0000\u0000\u019f\u01a1\u0005 \u0000\u0000\u01a0\u01a2\u0003\f"+
		"\u0006\u0000\u01a1\u01a0\u0001\u0000\u0000\u0000\u01a1\u01a2\u0001\u0000"+
		"\u0000\u0000\u01a2\u01a3\u0001\u0000\u0000\u0000\u01a3\u01a4\u0005!\u0000"+
		"\u0000\u01a4\u01a7\u0005)\u0000\u0000\u01a5\u01a8\u0003\u0004\u0002\u0000"+
		"\u01a6\u01a8\u0003$\u0012\u0000\u01a7\u01a5\u0001\u0000\u0000\u0000\u01a7"+
		"\u01a6\u0001\u0000\u0000\u0000\u01a8\u01aa\u0001\u0000\u0000\u0000\u01a9"+
		"\u0199\u0001\u0000\u0000\u0000\u01a9\u019f\u0001\u0000\u0000\u0000\u01aa"+
		"M\u0001\u0000\u0000\u0000\u01ab\u01b4\u0005\"\u0000\u0000\u01ac\u01b1"+
		"\u0003P(\u0000\u01ad\u01ae\u0005\u001f\u0000\u0000\u01ae\u01b0\u0003P"+
		"(\u0000\u01af\u01ad\u0001\u0000\u0000\u0000\u01b0\u01b3\u0001\u0000\u0000"+
		"\u0000\u01b1\u01af\u0001\u0000\u0000\u0000\u01b1\u01b2\u0001\u0000\u0000"+
		"\u0000\u01b2\u01b5\u0001\u0000\u0000\u0000\u01b3\u01b1\u0001\u0000\u0000"+
		"\u0000\u01b4\u01ac\u0001\u0000\u0000\u0000\u01b4\u01b5\u0001\u0000\u0000"+
		"\u0000\u01b5\u01b6\u0001\u0000\u0000\u0000\u01b6\u01b7\u0005#\u0000\u0000"+
		"\u01b7O\u0001\u0000\u0000\u0000\u01b8\u01b9\u0005N\u0000\u0000\u01b9\u01ba"+
		"\u0005\'\u0000\u0000\u01ba\u01bb\u0003$\u0012\u0000\u01bbQ\u0001\u0000"+
		"\u0000\u0000\u01bc\u01c5\u0005$\u0000\u0000\u01bd\u01c2\u0003$\u0012\u0000"+
		"\u01be\u01bf\u0005\u001f\u0000\u0000\u01bf\u01c1\u0003$\u0012\u0000\u01c0"+
		"\u01be\u0001\u0000\u0000\u0000\u01c1\u01c4\u0001\u0000\u0000\u0000\u01c2"+
		"\u01c0\u0001\u0000\u0000\u0000\u01c2\u01c3\u0001\u0000\u0000\u0000\u01c3"+
		"\u01c6\u0001\u0000\u0000\u0000\u01c4\u01c2\u0001\u0000\u0000\u0000\u01c5"+
		"\u01bd\u0001\u0000\u0000\u0000\u01c5\u01c6\u0001\u0000\u0000\u0000\u01c6"+
		"\u01c7\u0001\u0000\u0000\u0000\u01c7\u01c8\u0005%\u0000\u0000\u01c8S\u0001"+
		"\u0000\u0000\u0000\u01c9\u01ce\u0003$\u0012\u0000\u01ca\u01cb\u0005\u001f"+
		"\u0000\u0000\u01cb\u01cd\u0003$\u0012\u0000\u01cc\u01ca\u0001\u0000\u0000"+
		"\u0000\u01cd\u01d0\u0001\u0000\u0000\u0000\u01ce\u01cc\u0001\u0000\u0000"+
		"\u0000\u01ce\u01cf\u0001\u0000\u0000\u0000\u01cfU\u0001\u0000\u0000\u0000"+
		"\u01d0\u01ce\u0001\u0000\u0000\u00002Yqw\u0082\u0088\u008e\u0098\u009d"+
		"\u00a6\u00af\u00b1\u00bc\u00c4\u00ca\u00ce\u00d2\u00d9\u00e8\u00ec\u00f2"+
		"\u00fc\u0106\u010d\u0115\u011d\u0125\u012d\u0135\u013d\u0145\u014d\u0155"+
		"\u015b\u0160\u0166\u0175\u0178\u0189\u018c\u0190\u0194\u019d\u01a1\u01a7"+
		"\u01a9\u01b1\u01b4\u01c2\u01c5\u01ce";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}