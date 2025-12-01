// Generated from c:/Users/Francisco Rafael/Desktop/trabalho final compiladores/código compiladores/Gramatica.g4 by ANTLR 4.13.1
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue"})
public class GramaticaParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.13.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		LET=1, ATRIB=2, PONTO_VIRG=3, CONST=4, VAR=5, FUNCAO=6, ABRE_PAREN=7, 
		FECHA_PAREN=8, SETA=9, VIRG=10, ABRE_CHAVE=11, FECHA_CHAVE=12, ATRIB_SOMA=13, 
		ATRIB_SUBT=14, ATRIB_MULT=15, ATRIB_DIV=16, ATRIB_MOD=17, ATRIB_EXP=18, 
		SE=19, SENAO_SE=20, SENAO=21, COMUTACAO=22, PADRAO=23, DOISPONTOS=24, 
		CASO=25, PAUSA=26, PARA=27, ENQUANTO=28, FACA=29, RETORNO=30, CONTINUA=31, 
		TERNARIO=32, OU=33, E=34, BIT_OU=35, BIT_XOR=36, BIT_E=37, IGUALDADE=38, 
		DESIGUALDADE=39, IGUALDADE_ESTRITA=40, DESIGUALDADE_ESTRITA=41, MAIOR=42, 
		MENOR=43, MAIOR_IGUAL=44, MENOR_IGUAL=45, SHIFT_ESQ=46, SHIFT_DIR=47, 
		MAIS=48, MENOS=49, MULT=50, DIV=51, MOD=52, EXPON=53, NAO=54, BIT_NAO=55, 
		TYPEOF=56, DELETE=57, INC_PRE=58, DEC_PRE=59, INC_POS=60, DEC_POS=61, 
		NUMERO=62, TEXTO=63, TEMPLATE=64, VERDADEIRO=65, FALSO=66, NULO=67, INDEFINIDO=68, 
		INSTANCEOF=69, IN=70, ENCADEAMENTO_OPC=71, PONTO=72, COLCHETE=73, TIPO_STRING=74, 
		TIPO_NUMBER=75, TIPO_BOOLEAN=76, TIPO_OBJECT=77, TIPO_UNDEFINED=78, TIPO_NULL=79, 
		TIPO_FUNCTION=80, TIPO_BIGINT=81, IDENT=82;
	public static final int
		RULE_programa = 0, RULE_declaracao = 1, RULE_declaracaoVariavel = 2, RULE_declaracaoFuncao = 3, 
		RULE_listaParametros = 4, RULE_bloco = 5, RULE_sentenca = 6, RULE_sentencaAtribuicao = 7, 
		RULE_atribuidor = 8, RULE_sentencaSe = 9, RULE_sentencaComutacao = 10, 
		RULE_caso = 11, RULE_sentencaPara = 12, RULE_inicPara = 13, RULE_condicaoPara = 14, 
		RULE_atualizacaoPara = 15, RULE_sentencaEnquanto = 16, RULE_sentencaFacaEnquanto = 17, 
		RULE_sentencaRetorno = 18, RULE_sentencaPausa = 19, RULE_sentencaContinua = 20, 
		RULE_expressao = 21, RULE_expressoesTerc = 22, RULE_expressaoLogicaOu = 23, 
		RULE_expressaoLogicaE = 24, RULE_expressaoBitOu = 25, RULE_expressaoBitXor = 26, 
		RULE_expressaoBitE = 27, RULE_expressaoIgualdade = 28, RULE_expressaoComparacao = 29, 
		RULE_expressaoShift = 30, RULE_expressaoAditiva = 31, RULE_expressaoMultiplicativa = 32, 
		RULE_expressaoExponenciacao = 33, RULE_expressaoUnaria = 34, RULE_operadorUnario = 35, 
		RULE_expressaoPosfixa = 36, RULE_expressaoPrimaria = 37, RULE_chamadaFuncao = 38, 
		RULE_listaArgumentos = 39, RULE_acessoPropriedade = 40, RULE_objeto = 41, 
		RULE_parChaveValor = 42, RULE_vetor = 43, RULE_tipo = 44, RULE_identificador = 45;
	private static String[] makeRuleNames() {
		return new String[] {
			"programa", "declaracao", "declaracaoVariavel", "declaracaoFuncao", "listaParametros", 
			"bloco", "sentenca", "sentencaAtribuicao", "atribuidor", "sentencaSe", 
			"sentencaComutacao", "caso", "sentencaPara", "inicPara", "condicaoPara", 
			"atualizacaoPara", "sentencaEnquanto", "sentencaFacaEnquanto", "sentencaRetorno", 
			"sentencaPausa", "sentencaContinua", "expressao", "expressoesTerc", "expressaoLogicaOu", 
			"expressaoLogicaE", "expressaoBitOu", "expressaoBitXor", "expressaoBitE", 
			"expressaoIgualdade", "expressaoComparacao", "expressaoShift", "expressaoAditiva", 
			"expressaoMultiplicativa", "expressaoExponenciacao", "expressaoUnaria", 
			"operadorUnario", "expressaoPosfixa", "expressaoPrimaria", "chamadaFuncao", 
			"listaArgumentos", "acessoPropriedade", "objeto", "parChaveValor", "vetor", 
			"tipo", "identificador"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "LET", "ATRIB", "PONTO_VIRG", "CONST", "VAR", "FUNCAO", "ABRE_PAREN", 
			"FECHA_PAREN", "SETA", "VIRG", "ABRE_CHAVE", "FECHA_CHAVE", "ATRIB_SOMA", 
			"ATRIB_SUBT", "ATRIB_MULT", "ATRIB_DIV", "ATRIB_MOD", "ATRIB_EXP", "SE", 
			"SENAO_SE", "SENAO", "COMUTACAO", "PADRAO", "DOISPONTOS", "CASO", "PAUSA", 
			"PARA", "ENQUANTO", "FACA", "RETORNO", "CONTINUA", "TERNARIO", "OU", 
			"E", "BIT_OU", "BIT_XOR", "BIT_E", "IGUALDADE", "DESIGUALDADE", "IGUALDADE_ESTRITA", 
			"DESIGUALDADE_ESTRITA", "MAIOR", "MENOR", "MAIOR_IGUAL", "MENOR_IGUAL", 
			"SHIFT_ESQ", "SHIFT_DIR", "MAIS", "MENOS", "MULT", "DIV", "MOD", "EXPON", 
			"NAO", "BIT_NAO", "TYPEOF", "DELETE", "INC_PRE", "DEC_PRE", "INC_POS", 
			"DEC_POS", "NUMERO", "TEXTO", "TEMPLATE", "VERDADEIRO", "FALSO", "NULO", 
			"INDEFINIDO", "INSTANCEOF", "IN", "ENCADEAMENTO_OPC", "PONTO", "COLCHETE", 
			"TIPO_STRING", "TIPO_NUMBER", "TIPO_BOOLEAN", "TIPO_OBJECT", "TIPO_UNDEFINED", 
			"TIPO_NULL", "TIPO_FUNCTION", "TIPO_BIGINT", "IDENT"
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
	public String getGrammarFileName() { return "Gramatica.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public GramaticaParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ProgramaContext extends ParserRuleContext {
		public TerminalNode EOF() { return getToken(GramaticaParser.EOF, 0); }
		public List<DeclaracaoContext> declaracao() {
			return getRuleContexts(DeclaracaoContext.class);
		}
		public DeclaracaoContext declaracao(int i) {
			return getRuleContext(DeclaracaoContext.class,i);
		}
		public ProgramaContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_programa; }
	}

	public final ProgramaContext programa() throws RecognitionException {
		ProgramaContext _localctx = new ProgramaContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_programa);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(95);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 4232579186L) != 0) || _la==IDENT) {
				{
				{
				setState(92);
				declaracao();
				}
				}
				setState(97);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(98);
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
	public static class DeclaracaoContext extends ParserRuleContext {
		public DeclaracaoVariavelContext declaracaoVariavel() {
			return getRuleContext(DeclaracaoVariavelContext.class,0);
		}
		public DeclaracaoFuncaoContext declaracaoFuncao() {
			return getRuleContext(DeclaracaoFuncaoContext.class,0);
		}
		public SentencaContext sentenca() {
			return getRuleContext(SentencaContext.class,0);
		}
		public DeclaracaoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_declaracao; }
	}

	public final DeclaracaoContext declaracao() throws RecognitionException {
		DeclaracaoContext _localctx = new DeclaracaoContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_declaracao);
		try {
			setState(103);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(100);
				declaracaoVariavel();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(101);
				declaracaoFuncao();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(102);
				sentenca();
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
	public static class DeclaracaoVariavelContext extends ParserRuleContext {
		public TerminalNode LET() { return getToken(GramaticaParser.LET, 0); }
		public IdentificadorContext identificador() {
			return getRuleContext(IdentificadorContext.class,0);
		}
		public TerminalNode ATRIB() { return getToken(GramaticaParser.ATRIB, 0); }
		public ExpressaoContext expressao() {
			return getRuleContext(ExpressaoContext.class,0);
		}
		public TerminalNode PONTO_VIRG() { return getToken(GramaticaParser.PONTO_VIRG, 0); }
		public TerminalNode CONST() { return getToken(GramaticaParser.CONST, 0); }
		public TerminalNode VAR() { return getToken(GramaticaParser.VAR, 0); }
		public DeclaracaoVariavelContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_declaracaoVariavel; }
	}

	public final DeclaracaoVariavelContext declaracaoVariavel() throws RecognitionException {
		DeclaracaoVariavelContext _localctx = new DeclaracaoVariavelContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_declaracaoVariavel);
		try {
			setState(127);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,2,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(105);
				match(LET);
				setState(106);
				identificador();
				setState(107);
				match(ATRIB);
				setState(108);
				expressao();
				setState(109);
				match(PONTO_VIRG);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(111);
				match(CONST);
				setState(112);
				identificador();
				setState(113);
				match(ATRIB);
				setState(114);
				expressao();
				setState(115);
				match(PONTO_VIRG);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(117);
				match(VAR);
				setState(118);
				identificador();
				setState(119);
				match(ATRIB);
				setState(120);
				expressao();
				setState(121);
				match(PONTO_VIRG);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(123);
				match(LET);
				setState(124);
				identificador();
				setState(125);
				match(PONTO_VIRG);
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
	public static class DeclaracaoFuncaoContext extends ParserRuleContext {
		public TerminalNode FUNCAO() { return getToken(GramaticaParser.FUNCAO, 0); }
		public IdentificadorContext identificador() {
			return getRuleContext(IdentificadorContext.class,0);
		}
		public TerminalNode ABRE_PAREN() { return getToken(GramaticaParser.ABRE_PAREN, 0); }
		public TerminalNode FECHA_PAREN() { return getToken(GramaticaParser.FECHA_PAREN, 0); }
		public BlocoContext bloco() {
			return getRuleContext(BlocoContext.class,0);
		}
		public ListaParametrosContext listaParametros() {
			return getRuleContext(ListaParametrosContext.class,0);
		}
		public TerminalNode CONST() { return getToken(GramaticaParser.CONST, 0); }
		public TerminalNode ATRIB() { return getToken(GramaticaParser.ATRIB, 0); }
		public TerminalNode SETA() { return getToken(GramaticaParser.SETA, 0); }
		public ExpressaoContext expressao() {
			return getRuleContext(ExpressaoContext.class,0);
		}
		public DeclaracaoFuncaoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_declaracaoFuncao; }
	}

	public final DeclaracaoFuncaoContext declaracaoFuncao() throws RecognitionException {
		DeclaracaoFuncaoContext _localctx = new DeclaracaoFuncaoContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_declaracaoFuncao);
		int _la;
		try {
			setState(162);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,7,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(129);
				match(FUNCAO);
				setState(130);
				identificador();
				setState(131);
				match(ABRE_PAREN);
				setState(133);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==IDENT) {
					{
					setState(132);
					listaParametros();
					}
				}

				setState(135);
				match(FECHA_PAREN);
				setState(136);
				bloco();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(138);
				match(CONST);
				setState(139);
				identificador();
				setState(140);
				match(ATRIB);
				setState(141);
				match(ABRE_PAREN);
				setState(143);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==IDENT) {
					{
					setState(142);
					listaParametros();
					}
				}

				setState(145);
				match(FECHA_PAREN);
				setState(146);
				match(SETA);
				setState(149);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,5,_ctx) ) {
				case 1:
					{
					setState(147);
					expressao();
					}
					break;
				case 2:
					{
					setState(148);
					bloco();
					}
					break;
				}
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(151);
				match(CONST);
				setState(152);
				identificador();
				setState(153);
				match(ATRIB);
				setState(154);
				match(FUNCAO);
				setState(155);
				match(ABRE_PAREN);
				setState(157);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==IDENT) {
					{
					setState(156);
					listaParametros();
					}
				}

				setState(159);
				match(FECHA_PAREN);
				setState(160);
				bloco();
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
	public static class ListaParametrosContext extends ParserRuleContext {
		public List<IdentificadorContext> identificador() {
			return getRuleContexts(IdentificadorContext.class);
		}
		public IdentificadorContext identificador(int i) {
			return getRuleContext(IdentificadorContext.class,i);
		}
		public List<TerminalNode> VIRG() { return getTokens(GramaticaParser.VIRG); }
		public TerminalNode VIRG(int i) {
			return getToken(GramaticaParser.VIRG, i);
		}
		public ListaParametrosContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_listaParametros; }
	}

	public final ListaParametrosContext listaParametros() throws RecognitionException {
		ListaParametrosContext _localctx = new ListaParametrosContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_listaParametros);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(164);
			identificador();
			setState(169);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==VIRG) {
				{
				{
				setState(165);
				match(VIRG);
				setState(166);
				identificador();
				}
				}
				setState(171);
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
	public static class BlocoContext extends ParserRuleContext {
		public TerminalNode ABRE_CHAVE() { return getToken(GramaticaParser.ABRE_CHAVE, 0); }
		public TerminalNode FECHA_CHAVE() { return getToken(GramaticaParser.FECHA_CHAVE, 0); }
		public List<SentencaContext> sentenca() {
			return getRuleContexts(SentencaContext.class);
		}
		public SentencaContext sentenca(int i) {
			return getRuleContext(SentencaContext.class,i);
		}
		public BlocoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_bloco; }
	}

	public final BlocoContext bloco() throws RecognitionException {
		BlocoContext _localctx = new BlocoContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_bloco);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(172);
			match(ABRE_CHAVE);
			setState(176);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 4232579072L) != 0) || _la==IDENT) {
				{
				{
				setState(173);
				sentenca();
				}
				}
				setState(178);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(179);
			match(FECHA_CHAVE);
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
	public static class SentencaContext extends ParserRuleContext {
		public SentencaAtribuicaoContext sentencaAtribuicao() {
			return getRuleContext(SentencaAtribuicaoContext.class,0);
		}
		public SentencaSeContext sentencaSe() {
			return getRuleContext(SentencaSeContext.class,0);
		}
		public SentencaComutacaoContext sentencaComutacao() {
			return getRuleContext(SentencaComutacaoContext.class,0);
		}
		public SentencaParaContext sentencaPara() {
			return getRuleContext(SentencaParaContext.class,0);
		}
		public SentencaEnquantoContext sentencaEnquanto() {
			return getRuleContext(SentencaEnquantoContext.class,0);
		}
		public SentencaFacaEnquantoContext sentencaFacaEnquanto() {
			return getRuleContext(SentencaFacaEnquantoContext.class,0);
		}
		public SentencaRetornoContext sentencaRetorno() {
			return getRuleContext(SentencaRetornoContext.class,0);
		}
		public SentencaPausaContext sentencaPausa() {
			return getRuleContext(SentencaPausaContext.class,0);
		}
		public SentencaContinuaContext sentencaContinua() {
			return getRuleContext(SentencaContinuaContext.class,0);
		}
		public ChamadaFuncaoContext chamadaFuncao() {
			return getRuleContext(ChamadaFuncaoContext.class,0);
		}
		public TerminalNode PONTO_VIRG() { return getToken(GramaticaParser.PONTO_VIRG, 0); }
		public BlocoContext bloco() {
			return getRuleContext(BlocoContext.class,0);
		}
		public SentencaContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sentenca; }
	}

	public final SentencaContext sentenca() throws RecognitionException {
		SentencaContext _localctx = new SentencaContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_sentenca);
		try {
			setState(194);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,10,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(181);
				sentencaAtribuicao();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(182);
				sentencaSe();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(183);
				sentencaComutacao();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(184);
				sentencaPara();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(185);
				sentencaEnquanto();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(186);
				sentencaFacaEnquanto();
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(187);
				sentencaRetorno();
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(188);
				sentencaPausa();
				}
				break;
			case 9:
				enterOuterAlt(_localctx, 9);
				{
				setState(189);
				sentencaContinua();
				}
				break;
			case 10:
				enterOuterAlt(_localctx, 10);
				{
				setState(190);
				chamadaFuncao();
				setState(191);
				match(PONTO_VIRG);
				}
				break;
			case 11:
				enterOuterAlt(_localctx, 11);
				{
				setState(193);
				bloco();
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
	public static class SentencaAtribuicaoContext extends ParserRuleContext {
		public IdentificadorContext identificador() {
			return getRuleContext(IdentificadorContext.class,0);
		}
		public AtribuidorContext atribuidor() {
			return getRuleContext(AtribuidorContext.class,0);
		}
		public ExpressaoContext expressao() {
			return getRuleContext(ExpressaoContext.class,0);
		}
		public TerminalNode PONTO_VIRG() { return getToken(GramaticaParser.PONTO_VIRG, 0); }
		public SentencaAtribuicaoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sentencaAtribuicao; }
	}

	public final SentencaAtribuicaoContext sentencaAtribuicao() throws RecognitionException {
		SentencaAtribuicaoContext _localctx = new SentencaAtribuicaoContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_sentencaAtribuicao);
		try {
			setState(204);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,11,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(196);
				identificador();
				setState(197);
				atribuidor();
				setState(198);
				expressao();
				setState(199);
				match(PONTO_VIRG);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(201);
				identificador();
				setState(202);
				match(PONTO_VIRG);
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
	public static class AtribuidorContext extends ParserRuleContext {
		public TerminalNode ATRIB() { return getToken(GramaticaParser.ATRIB, 0); }
		public TerminalNode ATRIB_SOMA() { return getToken(GramaticaParser.ATRIB_SOMA, 0); }
		public TerminalNode ATRIB_SUBT() { return getToken(GramaticaParser.ATRIB_SUBT, 0); }
		public TerminalNode ATRIB_MULT() { return getToken(GramaticaParser.ATRIB_MULT, 0); }
		public TerminalNode ATRIB_DIV() { return getToken(GramaticaParser.ATRIB_DIV, 0); }
		public TerminalNode ATRIB_MOD() { return getToken(GramaticaParser.ATRIB_MOD, 0); }
		public TerminalNode ATRIB_EXP() { return getToken(GramaticaParser.ATRIB_EXP, 0); }
		public AtribuidorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_atribuidor; }
	}

	public final AtribuidorContext atribuidor() throws RecognitionException {
		AtribuidorContext _localctx = new AtribuidorContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_atribuidor);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(206);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 516100L) != 0)) ) {
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
	public static class SentencaSeContext extends ParserRuleContext {
		public TerminalNode SE() { return getToken(GramaticaParser.SE, 0); }
		public List<TerminalNode> ABRE_PAREN() { return getTokens(GramaticaParser.ABRE_PAREN); }
		public TerminalNode ABRE_PAREN(int i) {
			return getToken(GramaticaParser.ABRE_PAREN, i);
		}
		public List<ExpressaoContext> expressao() {
			return getRuleContexts(ExpressaoContext.class);
		}
		public ExpressaoContext expressao(int i) {
			return getRuleContext(ExpressaoContext.class,i);
		}
		public List<TerminalNode> FECHA_PAREN() { return getTokens(GramaticaParser.FECHA_PAREN); }
		public TerminalNode FECHA_PAREN(int i) {
			return getToken(GramaticaParser.FECHA_PAREN, i);
		}
		public List<BlocoContext> bloco() {
			return getRuleContexts(BlocoContext.class);
		}
		public BlocoContext bloco(int i) {
			return getRuleContext(BlocoContext.class,i);
		}
		public List<TerminalNode> SENAO_SE() { return getTokens(GramaticaParser.SENAO_SE); }
		public TerminalNode SENAO_SE(int i) {
			return getToken(GramaticaParser.SENAO_SE, i);
		}
		public TerminalNode SENAO() { return getToken(GramaticaParser.SENAO, 0); }
		public SentencaSeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sentencaSe; }
	}

	public final SentencaSeContext sentencaSe() throws RecognitionException {
		SentencaSeContext _localctx = new SentencaSeContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_sentencaSe);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(208);
			match(SE);
			setState(209);
			match(ABRE_PAREN);
			setState(210);
			expressao();
			setState(211);
			match(FECHA_PAREN);
			setState(212);
			bloco();
			setState(221);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==SENAO_SE) {
				{
				{
				setState(213);
				match(SENAO_SE);
				setState(214);
				match(ABRE_PAREN);
				setState(215);
				expressao();
				setState(216);
				match(FECHA_PAREN);
				setState(217);
				bloco();
				}
				}
				setState(223);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(226);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==SENAO) {
				{
				setState(224);
				match(SENAO);
				setState(225);
				bloco();
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
	public static class SentencaComutacaoContext extends ParserRuleContext {
		public TerminalNode COMUTACAO() { return getToken(GramaticaParser.COMUTACAO, 0); }
		public TerminalNode ABRE_PAREN() { return getToken(GramaticaParser.ABRE_PAREN, 0); }
		public ExpressaoContext expressao() {
			return getRuleContext(ExpressaoContext.class,0);
		}
		public TerminalNode FECHA_PAREN() { return getToken(GramaticaParser.FECHA_PAREN, 0); }
		public TerminalNode ABRE_CHAVE() { return getToken(GramaticaParser.ABRE_CHAVE, 0); }
		public TerminalNode FECHA_CHAVE() { return getToken(GramaticaParser.FECHA_CHAVE, 0); }
		public List<CasoContext> caso() {
			return getRuleContexts(CasoContext.class);
		}
		public CasoContext caso(int i) {
			return getRuleContext(CasoContext.class,i);
		}
		public TerminalNode PADRAO() { return getToken(GramaticaParser.PADRAO, 0); }
		public TerminalNode DOISPONTOS() { return getToken(GramaticaParser.DOISPONTOS, 0); }
		public List<SentencaContext> sentenca() {
			return getRuleContexts(SentencaContext.class);
		}
		public SentencaContext sentenca(int i) {
			return getRuleContext(SentencaContext.class,i);
		}
		public SentencaComutacaoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sentencaComutacao; }
	}

	public final SentencaComutacaoContext sentencaComutacao() throws RecognitionException {
		SentencaComutacaoContext _localctx = new SentencaComutacaoContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_sentencaComutacao);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(228);
			match(COMUTACAO);
			setState(229);
			match(ABRE_PAREN);
			setState(230);
			expressao();
			setState(231);
			match(FECHA_PAREN);
			setState(232);
			match(ABRE_CHAVE);
			setState(236);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==CASO) {
				{
				{
				setState(233);
				caso();
				}
				}
				setState(238);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(247);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==PADRAO) {
				{
				setState(239);
				match(PADRAO);
				setState(240);
				match(DOISPONTOS);
				setState(244);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 4232579072L) != 0) || _la==IDENT) {
					{
					{
					setState(241);
					sentenca();
					}
					}
					setState(246);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(249);
			match(FECHA_CHAVE);
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
	public static class CasoContext extends ParserRuleContext {
		public TerminalNode CASO() { return getToken(GramaticaParser.CASO, 0); }
		public ExpressaoContext expressao() {
			return getRuleContext(ExpressaoContext.class,0);
		}
		public TerminalNode DOISPONTOS() { return getToken(GramaticaParser.DOISPONTOS, 0); }
		public List<SentencaContext> sentenca() {
			return getRuleContexts(SentencaContext.class);
		}
		public SentencaContext sentenca(int i) {
			return getRuleContext(SentencaContext.class,i);
		}
		public TerminalNode PAUSA() { return getToken(GramaticaParser.PAUSA, 0); }
		public TerminalNode PONTO_VIRG() { return getToken(GramaticaParser.PONTO_VIRG, 0); }
		public CasoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_caso; }
	}

	public final CasoContext caso() throws RecognitionException {
		CasoContext _localctx = new CasoContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_caso);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(251);
			match(CASO);
			setState(252);
			expressao();
			setState(253);
			match(DOISPONTOS);
			setState(257);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,17,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(254);
					sentenca();
					}
					} 
				}
				setState(259);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,17,_ctx);
			}
			setState(262);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==PAUSA) {
				{
				setState(260);
				match(PAUSA);
				setState(261);
				match(PONTO_VIRG);
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
	public static class SentencaParaContext extends ParserRuleContext {
		public TerminalNode PARA() { return getToken(GramaticaParser.PARA, 0); }
		public TerminalNode ABRE_PAREN() { return getToken(GramaticaParser.ABRE_PAREN, 0); }
		public List<TerminalNode> PONTO_VIRG() { return getTokens(GramaticaParser.PONTO_VIRG); }
		public TerminalNode PONTO_VIRG(int i) {
			return getToken(GramaticaParser.PONTO_VIRG, i);
		}
		public TerminalNode FECHA_PAREN() { return getToken(GramaticaParser.FECHA_PAREN, 0); }
		public BlocoContext bloco() {
			return getRuleContext(BlocoContext.class,0);
		}
		public InicParaContext inicPara() {
			return getRuleContext(InicParaContext.class,0);
		}
		public CondicaoParaContext condicaoPara() {
			return getRuleContext(CondicaoParaContext.class,0);
		}
		public AtualizacaoParaContext atualizacaoPara() {
			return getRuleContext(AtualizacaoParaContext.class,0);
		}
		public SentencaParaContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sentencaPara; }
	}

	public final SentencaParaContext sentencaPara() throws RecognitionException {
		SentencaParaContext _localctx = new SentencaParaContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_sentencaPara);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(264);
			match(PARA);
			setState(265);
			match(ABRE_PAREN);
			setState(267);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & -3475934487399888718L) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & 262911L) != 0)) {
				{
				setState(266);
				inicPara();
				}
			}

			setState(269);
			match(PONTO_VIRG);
			setState(271);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & -3475934487399888768L) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & 262911L) != 0)) {
				{
				setState(270);
				condicaoPara();
				}
			}

			setState(273);
			match(PONTO_VIRG);
			setState(275);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & -3475934487399888768L) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & 262911L) != 0)) {
				{
				setState(274);
				atualizacaoPara();
				}
			}

			setState(277);
			match(FECHA_PAREN);
			setState(278);
			bloco();
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
	public static class InicParaContext extends ParserRuleContext {
		public DeclaracaoVariavelContext declaracaoVariavel() {
			return getRuleContext(DeclaracaoVariavelContext.class,0);
		}
		public ExpressaoContext expressao() {
			return getRuleContext(ExpressaoContext.class,0);
		}
		public InicParaContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_inicPara; }
	}

	public final InicParaContext inicPara() throws RecognitionException {
		InicParaContext _localctx = new InicParaContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_inicPara);
		try {
			setState(282);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case LET:
			case CONST:
			case VAR:
				enterOuterAlt(_localctx, 1);
				{
				setState(280);
				declaracaoVariavel();
				}
				break;
			case ABRE_PAREN:
			case ABRE_CHAVE:
			case MAIS:
			case MENOS:
			case NAO:
			case BIT_NAO:
			case TYPEOF:
			case DELETE:
			case INC_PRE:
			case DEC_PRE:
			case NUMERO:
			case TEXTO:
			case TEMPLATE:
			case VERDADEIRO:
			case FALSO:
			case NULO:
			case INDEFINIDO:
			case INSTANCEOF:
			case IN:
			case ENCADEAMENTO_OPC:
			case COLCHETE:
			case IDENT:
				enterOuterAlt(_localctx, 2);
				{
				setState(281);
				expressao();
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
	public static class CondicaoParaContext extends ParserRuleContext {
		public ExpressaoContext expressao() {
			return getRuleContext(ExpressaoContext.class,0);
		}
		public CondicaoParaContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_condicaoPara; }
	}

	public final CondicaoParaContext condicaoPara() throws RecognitionException {
		CondicaoParaContext _localctx = new CondicaoParaContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_condicaoPara);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(284);
			expressao();
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
	public static class AtualizacaoParaContext extends ParserRuleContext {
		public ExpressaoContext expressao() {
			return getRuleContext(ExpressaoContext.class,0);
		}
		public AtualizacaoParaContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_atualizacaoPara; }
	}

	public final AtualizacaoParaContext atualizacaoPara() throws RecognitionException {
		AtualizacaoParaContext _localctx = new AtualizacaoParaContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_atualizacaoPara);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(286);
			expressao();
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
	public static class SentencaEnquantoContext extends ParserRuleContext {
		public TerminalNode ENQUANTO() { return getToken(GramaticaParser.ENQUANTO, 0); }
		public TerminalNode ABRE_PAREN() { return getToken(GramaticaParser.ABRE_PAREN, 0); }
		public ExpressaoContext expressao() {
			return getRuleContext(ExpressaoContext.class,0);
		}
		public TerminalNode FECHA_PAREN() { return getToken(GramaticaParser.FECHA_PAREN, 0); }
		public BlocoContext bloco() {
			return getRuleContext(BlocoContext.class,0);
		}
		public SentencaEnquantoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sentencaEnquanto; }
	}

	public final SentencaEnquantoContext sentencaEnquanto() throws RecognitionException {
		SentencaEnquantoContext _localctx = new SentencaEnquantoContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_sentencaEnquanto);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(288);
			match(ENQUANTO);
			setState(289);
			match(ABRE_PAREN);
			setState(290);
			expressao();
			setState(291);
			match(FECHA_PAREN);
			setState(292);
			bloco();
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
	public static class SentencaFacaEnquantoContext extends ParserRuleContext {
		public TerminalNode FACA() { return getToken(GramaticaParser.FACA, 0); }
		public BlocoContext bloco() {
			return getRuleContext(BlocoContext.class,0);
		}
		public TerminalNode ENQUANTO() { return getToken(GramaticaParser.ENQUANTO, 0); }
		public TerminalNode ABRE_PAREN() { return getToken(GramaticaParser.ABRE_PAREN, 0); }
		public ExpressaoContext expressao() {
			return getRuleContext(ExpressaoContext.class,0);
		}
		public TerminalNode FECHA_PAREN() { return getToken(GramaticaParser.FECHA_PAREN, 0); }
		public TerminalNode PONTO_VIRG() { return getToken(GramaticaParser.PONTO_VIRG, 0); }
		public SentencaFacaEnquantoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sentencaFacaEnquanto; }
	}

	public final SentencaFacaEnquantoContext sentencaFacaEnquanto() throws RecognitionException {
		SentencaFacaEnquantoContext _localctx = new SentencaFacaEnquantoContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_sentencaFacaEnquanto);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(294);
			match(FACA);
			setState(295);
			bloco();
			setState(296);
			match(ENQUANTO);
			setState(297);
			match(ABRE_PAREN);
			setState(298);
			expressao();
			setState(299);
			match(FECHA_PAREN);
			setState(300);
			match(PONTO_VIRG);
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
	public static class SentencaRetornoContext extends ParserRuleContext {
		public TerminalNode RETORNO() { return getToken(GramaticaParser.RETORNO, 0); }
		public TerminalNode PONTO_VIRG() { return getToken(GramaticaParser.PONTO_VIRG, 0); }
		public ExpressaoContext expressao() {
			return getRuleContext(ExpressaoContext.class,0);
		}
		public SentencaRetornoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sentencaRetorno; }
	}

	public final SentencaRetornoContext sentencaRetorno() throws RecognitionException {
		SentencaRetornoContext _localctx = new SentencaRetornoContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_sentencaRetorno);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(302);
			match(RETORNO);
			setState(304);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & -3475934487399888768L) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & 262911L) != 0)) {
				{
				setState(303);
				expressao();
				}
			}

			setState(306);
			match(PONTO_VIRG);
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
	public static class SentencaPausaContext extends ParserRuleContext {
		public TerminalNode PAUSA() { return getToken(GramaticaParser.PAUSA, 0); }
		public TerminalNode PONTO_VIRG() { return getToken(GramaticaParser.PONTO_VIRG, 0); }
		public SentencaPausaContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sentencaPausa; }
	}

	public final SentencaPausaContext sentencaPausa() throws RecognitionException {
		SentencaPausaContext _localctx = new SentencaPausaContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_sentencaPausa);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(308);
			match(PAUSA);
			setState(309);
			match(PONTO_VIRG);
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
	public static class SentencaContinuaContext extends ParserRuleContext {
		public TerminalNode CONTINUA() { return getToken(GramaticaParser.CONTINUA, 0); }
		public TerminalNode PONTO_VIRG() { return getToken(GramaticaParser.PONTO_VIRG, 0); }
		public SentencaContinuaContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sentencaContinua; }
	}

	public final SentencaContinuaContext sentencaContinua() throws RecognitionException {
		SentencaContinuaContext _localctx = new SentencaContinuaContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_sentencaContinua);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(311);
			match(CONTINUA);
			setState(312);
			match(PONTO_VIRG);
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
	public static class ExpressaoContext extends ParserRuleContext {
		public ExpressoesTercContext expressoesTerc() {
			return getRuleContext(ExpressoesTercContext.class,0);
		}
		public ExpressaoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expressao; }
	}

	public final ExpressaoContext expressao() throws RecognitionException {
		ExpressaoContext _localctx = new ExpressaoContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_expressao);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(314);
			expressoesTerc();
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
	public static class ExpressoesTercContext extends ParserRuleContext {
		public ExpressaoLogicaOuContext expressaoLogicaOu() {
			return getRuleContext(ExpressaoLogicaOuContext.class,0);
		}
		public TerminalNode TERNARIO() { return getToken(GramaticaParser.TERNARIO, 0); }
		public List<ExpressaoContext> expressao() {
			return getRuleContexts(ExpressaoContext.class);
		}
		public ExpressaoContext expressao(int i) {
			return getRuleContext(ExpressaoContext.class,i);
		}
		public TerminalNode DOISPONTOS() { return getToken(GramaticaParser.DOISPONTOS, 0); }
		public ExpressoesTercContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expressoesTerc; }
	}

	public final ExpressoesTercContext expressoesTerc() throws RecognitionException {
		ExpressoesTercContext _localctx = new ExpressoesTercContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_expressoesTerc);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(316);
			expressaoLogicaOu();
			setState(322);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==TERNARIO) {
				{
				setState(317);
				match(TERNARIO);
				setState(318);
				expressao();
				setState(319);
				match(DOISPONTOS);
				setState(320);
				expressao();
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
	public static class ExpressaoLogicaOuContext extends ParserRuleContext {
		public List<ExpressaoLogicaEContext> expressaoLogicaE() {
			return getRuleContexts(ExpressaoLogicaEContext.class);
		}
		public ExpressaoLogicaEContext expressaoLogicaE(int i) {
			return getRuleContext(ExpressaoLogicaEContext.class,i);
		}
		public List<TerminalNode> OU() { return getTokens(GramaticaParser.OU); }
		public TerminalNode OU(int i) {
			return getToken(GramaticaParser.OU, i);
		}
		public ExpressaoLogicaOuContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expressaoLogicaOu; }
	}

	public final ExpressaoLogicaOuContext expressaoLogicaOu() throws RecognitionException {
		ExpressaoLogicaOuContext _localctx = new ExpressaoLogicaOuContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_expressaoLogicaOu);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(324);
			expressaoLogicaE();
			setState(329);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==OU) {
				{
				{
				setState(325);
				match(OU);
				setState(326);
				expressaoLogicaE();
				}
				}
				setState(331);
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
	public static class ExpressaoLogicaEContext extends ParserRuleContext {
		public List<ExpressaoBitOuContext> expressaoBitOu() {
			return getRuleContexts(ExpressaoBitOuContext.class);
		}
		public ExpressaoBitOuContext expressaoBitOu(int i) {
			return getRuleContext(ExpressaoBitOuContext.class,i);
		}
		public List<TerminalNode> E() { return getTokens(GramaticaParser.E); }
		public TerminalNode E(int i) {
			return getToken(GramaticaParser.E, i);
		}
		public ExpressaoLogicaEContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expressaoLogicaE; }
	}

	public final ExpressaoLogicaEContext expressaoLogicaE() throws RecognitionException {
		ExpressaoLogicaEContext _localctx = new ExpressaoLogicaEContext(_ctx, getState());
		enterRule(_localctx, 48, RULE_expressaoLogicaE);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(332);
			expressaoBitOu();
			setState(337);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==E) {
				{
				{
				setState(333);
				match(E);
				setState(334);
				expressaoBitOu();
				}
				}
				setState(339);
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
	public static class ExpressaoBitOuContext extends ParserRuleContext {
		public List<ExpressaoBitXorContext> expressaoBitXor() {
			return getRuleContexts(ExpressaoBitXorContext.class);
		}
		public ExpressaoBitXorContext expressaoBitXor(int i) {
			return getRuleContext(ExpressaoBitXorContext.class,i);
		}
		public List<TerminalNode> BIT_OU() { return getTokens(GramaticaParser.BIT_OU); }
		public TerminalNode BIT_OU(int i) {
			return getToken(GramaticaParser.BIT_OU, i);
		}
		public ExpressaoBitOuContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expressaoBitOu; }
	}

	public final ExpressaoBitOuContext expressaoBitOu() throws RecognitionException {
		ExpressaoBitOuContext _localctx = new ExpressaoBitOuContext(_ctx, getState());
		enterRule(_localctx, 50, RULE_expressaoBitOu);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(340);
			expressaoBitXor();
			setState(345);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==BIT_OU) {
				{
				{
				setState(341);
				match(BIT_OU);
				setState(342);
				expressaoBitXor();
				}
				}
				setState(347);
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
	public static class ExpressaoBitXorContext extends ParserRuleContext {
		public List<ExpressaoBitEContext> expressaoBitE() {
			return getRuleContexts(ExpressaoBitEContext.class);
		}
		public ExpressaoBitEContext expressaoBitE(int i) {
			return getRuleContext(ExpressaoBitEContext.class,i);
		}
		public List<TerminalNode> BIT_XOR() { return getTokens(GramaticaParser.BIT_XOR); }
		public TerminalNode BIT_XOR(int i) {
			return getToken(GramaticaParser.BIT_XOR, i);
		}
		public ExpressaoBitXorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expressaoBitXor; }
	}

	public final ExpressaoBitXorContext expressaoBitXor() throws RecognitionException {
		ExpressaoBitXorContext _localctx = new ExpressaoBitXorContext(_ctx, getState());
		enterRule(_localctx, 52, RULE_expressaoBitXor);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(348);
			expressaoBitE();
			setState(353);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==BIT_XOR) {
				{
				{
				setState(349);
				match(BIT_XOR);
				setState(350);
				expressaoBitE();
				}
				}
				setState(355);
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
	public static class ExpressaoBitEContext extends ParserRuleContext {
		public List<ExpressaoIgualdadeContext> expressaoIgualdade() {
			return getRuleContexts(ExpressaoIgualdadeContext.class);
		}
		public ExpressaoIgualdadeContext expressaoIgualdade(int i) {
			return getRuleContext(ExpressaoIgualdadeContext.class,i);
		}
		public List<TerminalNode> BIT_E() { return getTokens(GramaticaParser.BIT_E); }
		public TerminalNode BIT_E(int i) {
			return getToken(GramaticaParser.BIT_E, i);
		}
		public ExpressaoBitEContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expressaoBitE; }
	}

	public final ExpressaoBitEContext expressaoBitE() throws RecognitionException {
		ExpressaoBitEContext _localctx = new ExpressaoBitEContext(_ctx, getState());
		enterRule(_localctx, 54, RULE_expressaoBitE);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(356);
			expressaoIgualdade();
			setState(361);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==BIT_E) {
				{
				{
				setState(357);
				match(BIT_E);
				setState(358);
				expressaoIgualdade();
				}
				}
				setState(363);
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
	public static class ExpressaoIgualdadeContext extends ParserRuleContext {
		public List<ExpressaoComparacaoContext> expressaoComparacao() {
			return getRuleContexts(ExpressaoComparacaoContext.class);
		}
		public ExpressaoComparacaoContext expressaoComparacao(int i) {
			return getRuleContext(ExpressaoComparacaoContext.class,i);
		}
		public List<TerminalNode> IGUALDADE() { return getTokens(GramaticaParser.IGUALDADE); }
		public TerminalNode IGUALDADE(int i) {
			return getToken(GramaticaParser.IGUALDADE, i);
		}
		public List<TerminalNode> DESIGUALDADE() { return getTokens(GramaticaParser.DESIGUALDADE); }
		public TerminalNode DESIGUALDADE(int i) {
			return getToken(GramaticaParser.DESIGUALDADE, i);
		}
		public List<TerminalNode> IGUALDADE_ESTRITA() { return getTokens(GramaticaParser.IGUALDADE_ESTRITA); }
		public TerminalNode IGUALDADE_ESTRITA(int i) {
			return getToken(GramaticaParser.IGUALDADE_ESTRITA, i);
		}
		public List<TerminalNode> DESIGUALDADE_ESTRITA() { return getTokens(GramaticaParser.DESIGUALDADE_ESTRITA); }
		public TerminalNode DESIGUALDADE_ESTRITA(int i) {
			return getToken(GramaticaParser.DESIGUALDADE_ESTRITA, i);
		}
		public ExpressaoIgualdadeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expressaoIgualdade; }
	}

	public final ExpressaoIgualdadeContext expressaoIgualdade() throws RecognitionException {
		ExpressaoIgualdadeContext _localctx = new ExpressaoIgualdadeContext(_ctx, getState());
		enterRule(_localctx, 56, RULE_expressaoIgualdade);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(364);
			expressaoComparacao();
			setState(369);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 4123168604160L) != 0)) {
				{
				{
				setState(365);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 4123168604160L) != 0)) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(366);
				expressaoComparacao();
				}
				}
				setState(371);
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
	public static class ExpressaoComparacaoContext extends ParserRuleContext {
		public List<ExpressaoShiftContext> expressaoShift() {
			return getRuleContexts(ExpressaoShiftContext.class);
		}
		public ExpressaoShiftContext expressaoShift(int i) {
			return getRuleContext(ExpressaoShiftContext.class,i);
		}
		public List<TerminalNode> MAIOR() { return getTokens(GramaticaParser.MAIOR); }
		public TerminalNode MAIOR(int i) {
			return getToken(GramaticaParser.MAIOR, i);
		}
		public List<TerminalNode> MENOR() { return getTokens(GramaticaParser.MENOR); }
		public TerminalNode MENOR(int i) {
			return getToken(GramaticaParser.MENOR, i);
		}
		public List<TerminalNode> MAIOR_IGUAL() { return getTokens(GramaticaParser.MAIOR_IGUAL); }
		public TerminalNode MAIOR_IGUAL(int i) {
			return getToken(GramaticaParser.MAIOR_IGUAL, i);
		}
		public List<TerminalNode> MENOR_IGUAL() { return getTokens(GramaticaParser.MENOR_IGUAL); }
		public TerminalNode MENOR_IGUAL(int i) {
			return getToken(GramaticaParser.MENOR_IGUAL, i);
		}
		public ExpressaoComparacaoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expressaoComparacao; }
	}

	public final ExpressaoComparacaoContext expressaoComparacao() throws RecognitionException {
		ExpressaoComparacaoContext _localctx = new ExpressaoComparacaoContext(_ctx, getState());
		enterRule(_localctx, 58, RULE_expressaoComparacao);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(372);
			expressaoShift();
			setState(377);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 65970697666560L) != 0)) {
				{
				{
				setState(373);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 65970697666560L) != 0)) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(374);
				expressaoShift();
				}
				}
				setState(379);
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
	public static class ExpressaoShiftContext extends ParserRuleContext {
		public List<ExpressaoAditivaContext> expressaoAditiva() {
			return getRuleContexts(ExpressaoAditivaContext.class);
		}
		public ExpressaoAditivaContext expressaoAditiva(int i) {
			return getRuleContext(ExpressaoAditivaContext.class,i);
		}
		public List<TerminalNode> SHIFT_ESQ() { return getTokens(GramaticaParser.SHIFT_ESQ); }
		public TerminalNode SHIFT_ESQ(int i) {
			return getToken(GramaticaParser.SHIFT_ESQ, i);
		}
		public List<TerminalNode> SHIFT_DIR() { return getTokens(GramaticaParser.SHIFT_DIR); }
		public TerminalNode SHIFT_DIR(int i) {
			return getToken(GramaticaParser.SHIFT_DIR, i);
		}
		public ExpressaoShiftContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expressaoShift; }
	}

	public final ExpressaoShiftContext expressaoShift() throws RecognitionException {
		ExpressaoShiftContext _localctx = new ExpressaoShiftContext(_ctx, getState());
		enterRule(_localctx, 60, RULE_expressaoShift);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(380);
			expressaoAditiva();
			setState(385);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==SHIFT_ESQ || _la==SHIFT_DIR) {
				{
				{
				setState(381);
				_la = _input.LA(1);
				if ( !(_la==SHIFT_ESQ || _la==SHIFT_DIR) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(382);
				expressaoAditiva();
				}
				}
				setState(387);
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
	public static class ExpressaoAditivaContext extends ParserRuleContext {
		public List<ExpressaoMultiplicativaContext> expressaoMultiplicativa() {
			return getRuleContexts(ExpressaoMultiplicativaContext.class);
		}
		public ExpressaoMultiplicativaContext expressaoMultiplicativa(int i) {
			return getRuleContext(ExpressaoMultiplicativaContext.class,i);
		}
		public List<TerminalNode> MAIS() { return getTokens(GramaticaParser.MAIS); }
		public TerminalNode MAIS(int i) {
			return getToken(GramaticaParser.MAIS, i);
		}
		public List<TerminalNode> MENOS() { return getTokens(GramaticaParser.MENOS); }
		public TerminalNode MENOS(int i) {
			return getToken(GramaticaParser.MENOS, i);
		}
		public ExpressaoAditivaContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expressaoAditiva; }
	}

	public final ExpressaoAditivaContext expressaoAditiva() throws RecognitionException {
		ExpressaoAditivaContext _localctx = new ExpressaoAditivaContext(_ctx, getState());
		enterRule(_localctx, 62, RULE_expressaoAditiva);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(388);
			expressaoMultiplicativa();
			setState(393);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==MAIS || _la==MENOS) {
				{
				{
				setState(389);
				_la = _input.LA(1);
				if ( !(_la==MAIS || _la==MENOS) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(390);
				expressaoMultiplicativa();
				}
				}
				setState(395);
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
	public static class ExpressaoMultiplicativaContext extends ParserRuleContext {
		public List<ExpressaoExponenciacaoContext> expressaoExponenciacao() {
			return getRuleContexts(ExpressaoExponenciacaoContext.class);
		}
		public ExpressaoExponenciacaoContext expressaoExponenciacao(int i) {
			return getRuleContext(ExpressaoExponenciacaoContext.class,i);
		}
		public List<TerminalNode> MULT() { return getTokens(GramaticaParser.MULT); }
		public TerminalNode MULT(int i) {
			return getToken(GramaticaParser.MULT, i);
		}
		public List<TerminalNode> DIV() { return getTokens(GramaticaParser.DIV); }
		public TerminalNode DIV(int i) {
			return getToken(GramaticaParser.DIV, i);
		}
		public List<TerminalNode> MOD() { return getTokens(GramaticaParser.MOD); }
		public TerminalNode MOD(int i) {
			return getToken(GramaticaParser.MOD, i);
		}
		public ExpressaoMultiplicativaContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expressaoMultiplicativa; }
	}

	public final ExpressaoMultiplicativaContext expressaoMultiplicativa() throws RecognitionException {
		ExpressaoMultiplicativaContext _localctx = new ExpressaoMultiplicativaContext(_ctx, getState());
		enterRule(_localctx, 64, RULE_expressaoMultiplicativa);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(396);
			expressaoExponenciacao();
			setState(401);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 7881299347898368L) != 0)) {
				{
				{
				setState(397);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 7881299347898368L) != 0)) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(398);
				expressaoExponenciacao();
				}
				}
				setState(403);
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
	public static class ExpressaoExponenciacaoContext extends ParserRuleContext {
		public List<ExpressaoUnariaContext> expressaoUnaria() {
			return getRuleContexts(ExpressaoUnariaContext.class);
		}
		public ExpressaoUnariaContext expressaoUnaria(int i) {
			return getRuleContext(ExpressaoUnariaContext.class,i);
		}
		public List<TerminalNode> EXPON() { return getTokens(GramaticaParser.EXPON); }
		public TerminalNode EXPON(int i) {
			return getToken(GramaticaParser.EXPON, i);
		}
		public ExpressaoExponenciacaoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expressaoExponenciacao; }
	}

	public final ExpressaoExponenciacaoContext expressaoExponenciacao() throws RecognitionException {
		ExpressaoExponenciacaoContext _localctx = new ExpressaoExponenciacaoContext(_ctx, getState());
		enterRule(_localctx, 66, RULE_expressaoExponenciacao);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(404);
			expressaoUnaria();
			setState(409);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==EXPON) {
				{
				{
				setState(405);
				match(EXPON);
				setState(406);
				expressaoUnaria();
				}
				}
				setState(411);
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
	public static class ExpressaoUnariaContext extends ParserRuleContext {
		public OperadorUnarioContext operadorUnario() {
			return getRuleContext(OperadorUnarioContext.class,0);
		}
		public ExpressaoUnariaContext expressaoUnaria() {
			return getRuleContext(ExpressaoUnariaContext.class,0);
		}
		public ExpressaoPosfixaContext expressaoPosfixa() {
			return getRuleContext(ExpressaoPosfixaContext.class,0);
		}
		public ExpressaoUnariaContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expressaoUnaria; }
	}

	public final ExpressaoUnariaContext expressaoUnaria() throws RecognitionException {
		ExpressaoUnariaContext _localctx = new ExpressaoUnariaContext(_ctx, getState());
		enterRule(_localctx, 68, RULE_expressaoUnaria);
		try {
			setState(416);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case MAIS:
			case MENOS:
			case NAO:
			case BIT_NAO:
			case TYPEOF:
			case DELETE:
			case INC_PRE:
			case DEC_PRE:
				enterOuterAlt(_localctx, 1);
				{
				setState(412);
				operadorUnario();
				setState(413);
				expressaoUnaria();
				}
				break;
			case ABRE_PAREN:
			case ABRE_CHAVE:
			case NUMERO:
			case TEXTO:
			case TEMPLATE:
			case VERDADEIRO:
			case FALSO:
			case NULO:
			case INDEFINIDO:
			case INSTANCEOF:
			case IN:
			case ENCADEAMENTO_OPC:
			case COLCHETE:
			case IDENT:
				enterOuterAlt(_localctx, 2);
				{
				setState(415);
				expressaoPosfixa();
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
	public static class OperadorUnarioContext extends ParserRuleContext {
		public TerminalNode MAIS() { return getToken(GramaticaParser.MAIS, 0); }
		public TerminalNode MENOS() { return getToken(GramaticaParser.MENOS, 0); }
		public TerminalNode NAO() { return getToken(GramaticaParser.NAO, 0); }
		public TerminalNode BIT_NAO() { return getToken(GramaticaParser.BIT_NAO, 0); }
		public TerminalNode TYPEOF() { return getToken(GramaticaParser.TYPEOF, 0); }
		public TerminalNode DELETE() { return getToken(GramaticaParser.DELETE, 0); }
		public TerminalNode INC_PRE() { return getToken(GramaticaParser.INC_PRE, 0); }
		public TerminalNode DEC_PRE() { return getToken(GramaticaParser.DEC_PRE, 0); }
		public OperadorUnarioContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_operadorUnario; }
	}

	public final OperadorUnarioContext operadorUnario() throws RecognitionException {
		OperadorUnarioContext _localctx = new OperadorUnarioContext(_ctx, getState());
		enterRule(_localctx, 70, RULE_operadorUnario);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(418);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 1135751531027496960L) != 0)) ) {
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
	public static class ExpressaoPosfixaContext extends ParserRuleContext {
		public ExpressaoPrimariaContext expressaoPrimaria() {
			return getRuleContext(ExpressaoPrimariaContext.class,0);
		}
		public List<TerminalNode> INC_POS() { return getTokens(GramaticaParser.INC_POS); }
		public TerminalNode INC_POS(int i) {
			return getToken(GramaticaParser.INC_POS, i);
		}
		public List<TerminalNode> DEC_POS() { return getTokens(GramaticaParser.DEC_POS); }
		public TerminalNode DEC_POS(int i) {
			return getToken(GramaticaParser.DEC_POS, i);
		}
		public ExpressaoPosfixaContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expressaoPosfixa; }
	}

	public final ExpressaoPosfixaContext expressaoPosfixa() throws RecognitionException {
		ExpressaoPosfixaContext _localctx = new ExpressaoPosfixaContext(_ctx, getState());
		enterRule(_localctx, 72, RULE_expressaoPosfixa);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(420);
			expressaoPrimaria();
			setState(424);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==INC_POS || _la==DEC_POS) {
				{
				{
				setState(421);
				_la = _input.LA(1);
				if ( !(_la==INC_POS || _la==DEC_POS) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				}
				}
				setState(426);
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
	public static class ExpressaoPrimariaContext extends ParserRuleContext {
		public TerminalNode NUMERO() { return getToken(GramaticaParser.NUMERO, 0); }
		public TerminalNode TEXTO() { return getToken(GramaticaParser.TEXTO, 0); }
		public TerminalNode TEMPLATE() { return getToken(GramaticaParser.TEMPLATE, 0); }
		public TerminalNode VERDADEIRO() { return getToken(GramaticaParser.VERDADEIRO, 0); }
		public TerminalNode FALSO() { return getToken(GramaticaParser.FALSO, 0); }
		public TerminalNode NULO() { return getToken(GramaticaParser.NULO, 0); }
		public TerminalNode INDEFINIDO() { return getToken(GramaticaParser.INDEFINIDO, 0); }
		public IdentificadorContext identificador() {
			return getRuleContext(IdentificadorContext.class,0);
		}
		public ObjetoContext objeto() {
			return getRuleContext(ObjetoContext.class,0);
		}
		public VetorContext vetor() {
			return getRuleContext(VetorContext.class,0);
		}
		public TerminalNode ABRE_PAREN() { return getToken(GramaticaParser.ABRE_PAREN, 0); }
		public ExpressaoContext expressao() {
			return getRuleContext(ExpressaoContext.class,0);
		}
		public TerminalNode FECHA_PAREN() { return getToken(GramaticaParser.FECHA_PAREN, 0); }
		public ChamadaFuncaoContext chamadaFuncao() {
			return getRuleContext(ChamadaFuncaoContext.class,0);
		}
		public AcessoPropriedadeContext acessoPropriedade() {
			return getRuleContext(AcessoPropriedadeContext.class,0);
		}
		public TerminalNode INSTANCEOF() { return getToken(GramaticaParser.INSTANCEOF, 0); }
		public TipoContext tipo() {
			return getRuleContext(TipoContext.class,0);
		}
		public TerminalNode IN() { return getToken(GramaticaParser.IN, 0); }
		public TerminalNode ENCADEAMENTO_OPC() { return getToken(GramaticaParser.ENCADEAMENTO_OPC, 0); }
		public ExpressaoPrimariaContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expressaoPrimaria; }
	}

	public final ExpressaoPrimariaContext expressaoPrimaria() throws RecognitionException {
		ExpressaoPrimariaContext _localctx = new ExpressaoPrimariaContext(_ctx, getState());
		enterRule(_localctx, 74, RULE_expressaoPrimaria);
		try {
			setState(449);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,38,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(427);
				match(NUMERO);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(428);
				match(TEXTO);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(429);
				match(TEMPLATE);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(430);
				match(VERDADEIRO);
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(431);
				match(FALSO);
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(432);
				match(NULO);
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(433);
				match(INDEFINIDO);
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(434);
				identificador();
				}
				break;
			case 9:
				enterOuterAlt(_localctx, 9);
				{
				setState(435);
				objeto();
				}
				break;
			case 10:
				enterOuterAlt(_localctx, 10);
				{
				setState(436);
				vetor();
				}
				break;
			case 11:
				enterOuterAlt(_localctx, 11);
				{
				setState(437);
				match(ABRE_PAREN);
				setState(438);
				expressao();
				setState(439);
				match(FECHA_PAREN);
				}
				break;
			case 12:
				enterOuterAlt(_localctx, 12);
				{
				setState(441);
				chamadaFuncao();
				}
				break;
			case 13:
				enterOuterAlt(_localctx, 13);
				{
				setState(442);
				acessoPropriedade();
				}
				break;
			case 14:
				enterOuterAlt(_localctx, 14);
				{
				setState(443);
				match(INSTANCEOF);
				setState(444);
				tipo();
				}
				break;
			case 15:
				enterOuterAlt(_localctx, 15);
				{
				setState(445);
				match(IN);
				setState(446);
				identificador();
				}
				break;
			case 16:
				enterOuterAlt(_localctx, 16);
				{
				setState(447);
				match(ENCADEAMENTO_OPC);
				setState(448);
				acessoPropriedade();
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
	public static class ChamadaFuncaoContext extends ParserRuleContext {
		public IdentificadorContext identificador() {
			return getRuleContext(IdentificadorContext.class,0);
		}
		public TerminalNode ABRE_PAREN() { return getToken(GramaticaParser.ABRE_PAREN, 0); }
		public TerminalNode FECHA_PAREN() { return getToken(GramaticaParser.FECHA_PAREN, 0); }
		public ListaArgumentosContext listaArgumentos() {
			return getRuleContext(ListaArgumentosContext.class,0);
		}
		public ChamadaFuncaoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_chamadaFuncao; }
	}

	public final ChamadaFuncaoContext chamadaFuncao() throws RecognitionException {
		ChamadaFuncaoContext _localctx = new ChamadaFuncaoContext(_ctx, getState());
		enterRule(_localctx, 76, RULE_chamadaFuncao);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(451);
			identificador();
			setState(452);
			match(ABRE_PAREN);
			setState(454);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & -3475934487399888768L) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & 262911L) != 0)) {
				{
				setState(453);
				listaArgumentos();
				}
			}

			setState(456);
			match(FECHA_PAREN);
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
	public static class ListaArgumentosContext extends ParserRuleContext {
		public List<ExpressaoContext> expressao() {
			return getRuleContexts(ExpressaoContext.class);
		}
		public ExpressaoContext expressao(int i) {
			return getRuleContext(ExpressaoContext.class,i);
		}
		public List<TerminalNode> VIRG() { return getTokens(GramaticaParser.VIRG); }
		public TerminalNode VIRG(int i) {
			return getToken(GramaticaParser.VIRG, i);
		}
		public ListaArgumentosContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_listaArgumentos; }
	}

	public final ListaArgumentosContext listaArgumentos() throws RecognitionException {
		ListaArgumentosContext _localctx = new ListaArgumentosContext(_ctx, getState());
		enterRule(_localctx, 78, RULE_listaArgumentos);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(458);
			expressao();
			setState(463);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==VIRG) {
				{
				{
				setState(459);
				match(VIRG);
				setState(460);
				expressao();
				}
				}
				setState(465);
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
	public static class AcessoPropriedadeContext extends ParserRuleContext {
		public List<IdentificadorContext> identificador() {
			return getRuleContexts(IdentificadorContext.class);
		}
		public IdentificadorContext identificador(int i) {
			return getRuleContext(IdentificadorContext.class,i);
		}
		public List<TerminalNode> PONTO() { return getTokens(GramaticaParser.PONTO); }
		public TerminalNode PONTO(int i) {
			return getToken(GramaticaParser.PONTO, i);
		}
		public List<TerminalNode> COLCHETE() { return getTokens(GramaticaParser.COLCHETE); }
		public TerminalNode COLCHETE(int i) {
			return getToken(GramaticaParser.COLCHETE, i);
		}
		public List<ExpressaoContext> expressao() {
			return getRuleContexts(ExpressaoContext.class);
		}
		public ExpressaoContext expressao(int i) {
			return getRuleContext(ExpressaoContext.class,i);
		}
		public AcessoPropriedadeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_acessoPropriedade; }
	}

	public final AcessoPropriedadeContext acessoPropriedade() throws RecognitionException {
		AcessoPropriedadeContext _localctx = new AcessoPropriedadeContext(_ctx, getState());
		enterRule(_localctx, 80, RULE_acessoPropriedade);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(466);
			identificador();
			setState(475);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,42,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					setState(473);
					_errHandler.sync(this);
					switch (_input.LA(1)) {
					case PONTO:
						{
						setState(467);
						match(PONTO);
						setState(468);
						identificador();
						}
						break;
					case COLCHETE:
						{
						setState(469);
						match(COLCHETE);
						setState(470);
						expressao();
						setState(471);
						match(COLCHETE);
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					} 
				}
				setState(477);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,42,_ctx);
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
	public static class ObjetoContext extends ParserRuleContext {
		public TerminalNode ABRE_CHAVE() { return getToken(GramaticaParser.ABRE_CHAVE, 0); }
		public TerminalNode FECHA_CHAVE() { return getToken(GramaticaParser.FECHA_CHAVE, 0); }
		public List<ParChaveValorContext> parChaveValor() {
			return getRuleContexts(ParChaveValorContext.class);
		}
		public ParChaveValorContext parChaveValor(int i) {
			return getRuleContext(ParChaveValorContext.class,i);
		}
		public List<TerminalNode> VIRG() { return getTokens(GramaticaParser.VIRG); }
		public TerminalNode VIRG(int i) {
			return getToken(GramaticaParser.VIRG, i);
		}
		public ObjetoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_objeto; }
	}

	public final ObjetoContext objeto() throws RecognitionException {
		ObjetoContext _localctx = new ObjetoContext(_ctx, getState());
		enterRule(_localctx, 82, RULE_objeto);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(478);
			match(ABRE_CHAVE);
			setState(487);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==TEXTO || _la==IDENT) {
				{
				setState(479);
				parChaveValor();
				setState(484);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==VIRG) {
					{
					{
					setState(480);
					match(VIRG);
					setState(481);
					parChaveValor();
					}
					}
					setState(486);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(489);
			match(FECHA_CHAVE);
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
	public static class ParChaveValorContext extends ParserRuleContext {
		public IdentificadorContext identificador() {
			return getRuleContext(IdentificadorContext.class,0);
		}
		public TerminalNode DOISPONTOS() { return getToken(GramaticaParser.DOISPONTOS, 0); }
		public ExpressaoContext expressao() {
			return getRuleContext(ExpressaoContext.class,0);
		}
		public TerminalNode TEXTO() { return getToken(GramaticaParser.TEXTO, 0); }
		public ParChaveValorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_parChaveValor; }
	}

	public final ParChaveValorContext parChaveValor() throws RecognitionException {
		ParChaveValorContext _localctx = new ParChaveValorContext(_ctx, getState());
		enterRule(_localctx, 84, RULE_parChaveValor);
		try {
			setState(498);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case IDENT:
				enterOuterAlt(_localctx, 1);
				{
				setState(491);
				identificador();
				setState(492);
				match(DOISPONTOS);
				setState(493);
				expressao();
				}
				break;
			case TEXTO:
				enterOuterAlt(_localctx, 2);
				{
				setState(495);
				match(TEXTO);
				setState(496);
				match(DOISPONTOS);
				setState(497);
				expressao();
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
	public static class VetorContext extends ParserRuleContext {
		public List<TerminalNode> COLCHETE() { return getTokens(GramaticaParser.COLCHETE); }
		public TerminalNode COLCHETE(int i) {
			return getToken(GramaticaParser.COLCHETE, i);
		}
		public List<ExpressaoContext> expressao() {
			return getRuleContexts(ExpressaoContext.class);
		}
		public ExpressaoContext expressao(int i) {
			return getRuleContext(ExpressaoContext.class,i);
		}
		public List<TerminalNode> VIRG() { return getTokens(GramaticaParser.VIRG); }
		public TerminalNode VIRG(int i) {
			return getToken(GramaticaParser.VIRG, i);
		}
		public VetorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_vetor; }
	}

	public final VetorContext vetor() throws RecognitionException {
		VetorContext _localctx = new VetorContext(_ctx, getState());
		enterRule(_localctx, 86, RULE_vetor);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(500);
			match(COLCHETE);
			setState(509);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,47,_ctx) ) {
			case 1:
				{
				setState(501);
				expressao();
				setState(506);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==VIRG) {
					{
					{
					setState(502);
					match(VIRG);
					setState(503);
					expressao();
					}
					}
					setState(508);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				break;
			}
			setState(511);
			match(COLCHETE);
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
	public static class TipoContext extends ParserRuleContext {
		public TerminalNode TIPO_STRING() { return getToken(GramaticaParser.TIPO_STRING, 0); }
		public TerminalNode TIPO_NUMBER() { return getToken(GramaticaParser.TIPO_NUMBER, 0); }
		public TerminalNode TIPO_BOOLEAN() { return getToken(GramaticaParser.TIPO_BOOLEAN, 0); }
		public TerminalNode TIPO_OBJECT() { return getToken(GramaticaParser.TIPO_OBJECT, 0); }
		public TerminalNode TIPO_UNDEFINED() { return getToken(GramaticaParser.TIPO_UNDEFINED, 0); }
		public TerminalNode TIPO_NULL() { return getToken(GramaticaParser.TIPO_NULL, 0); }
		public TerminalNode TIPO_FUNCTION() { return getToken(GramaticaParser.TIPO_FUNCTION, 0); }
		public TerminalNode TIPO_BIGINT() { return getToken(GramaticaParser.TIPO_BIGINT, 0); }
		public IdentificadorContext identificador() {
			return getRuleContext(IdentificadorContext.class,0);
		}
		public TipoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_tipo; }
	}

	public final TipoContext tipo() throws RecognitionException {
		TipoContext _localctx = new TipoContext(_ctx, getState());
		enterRule(_localctx, 88, RULE_tipo);
		try {
			setState(522);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case TIPO_STRING:
				enterOuterAlt(_localctx, 1);
				{
				setState(513);
				match(TIPO_STRING);
				}
				break;
			case TIPO_NUMBER:
				enterOuterAlt(_localctx, 2);
				{
				setState(514);
				match(TIPO_NUMBER);
				}
				break;
			case TIPO_BOOLEAN:
				enterOuterAlt(_localctx, 3);
				{
				setState(515);
				match(TIPO_BOOLEAN);
				}
				break;
			case TIPO_OBJECT:
				enterOuterAlt(_localctx, 4);
				{
				setState(516);
				match(TIPO_OBJECT);
				}
				break;
			case TIPO_UNDEFINED:
				enterOuterAlt(_localctx, 5);
				{
				setState(517);
				match(TIPO_UNDEFINED);
				}
				break;
			case TIPO_NULL:
				enterOuterAlt(_localctx, 6);
				{
				setState(518);
				match(TIPO_NULL);
				}
				break;
			case TIPO_FUNCTION:
				enterOuterAlt(_localctx, 7);
				{
				setState(519);
				match(TIPO_FUNCTION);
				}
				break;
			case TIPO_BIGINT:
				enterOuterAlt(_localctx, 8);
				{
				setState(520);
				match(TIPO_BIGINT);
				}
				break;
			case IDENT:
				enterOuterAlt(_localctx, 9);
				{
				setState(521);
				identificador();
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
	public static class IdentificadorContext extends ParserRuleContext {
		public TerminalNode IDENT() { return getToken(GramaticaParser.IDENT, 0); }
		public IdentificadorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_identificador; }
	}

	public final IdentificadorContext identificador() throws RecognitionException {
		IdentificadorContext _localctx = new IdentificadorContext(_ctx, getState());
		enterRule(_localctx, 90, RULE_identificador);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(524);
			match(IDENT);
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
		"\u0004\u0001R\u020f\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
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
		"(\u0007(\u0002)\u0007)\u0002*\u0007*\u0002+\u0007+\u0002,\u0007,\u0002"+
		"-\u0007-\u0001\u0000\u0005\u0000^\b\u0000\n\u0000\f\u0000a\t\u0000\u0001"+
		"\u0000\u0001\u0000\u0001\u0001\u0001\u0001\u0001\u0001\u0003\u0001h\b"+
		"\u0001\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001"+
		"\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001"+
		"\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001"+
		"\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0003\u0002\u0080"+
		"\b\u0002\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0003\u0003\u0086"+
		"\b\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001"+
		"\u0003\u0001\u0003\u0001\u0003\u0003\u0003\u0090\b\u0003\u0001\u0003\u0001"+
		"\u0003\u0001\u0003\u0001\u0003\u0003\u0003\u0096\b\u0003\u0001\u0003\u0001"+
		"\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0003\u0003\u009e"+
		"\b\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0003\u0003\u00a3\b\u0003"+
		"\u0001\u0004\u0001\u0004\u0001\u0004\u0005\u0004\u00a8\b\u0004\n\u0004"+
		"\f\u0004\u00ab\t\u0004\u0001\u0005\u0001\u0005\u0005\u0005\u00af\b\u0005"+
		"\n\u0005\f\u0005\u00b2\t\u0005\u0001\u0005\u0001\u0005\u0001\u0006\u0001"+
		"\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001"+
		"\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0003"+
		"\u0006\u00c3\b\u0006\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001"+
		"\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0003\u0007\u00cd\b\u0007\u0001"+
		"\b\u0001\b\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001"+
		"\t\u0001\t\u0001\t\u0001\t\u0005\t\u00dc\b\t\n\t\f\t\u00df\t\t\u0001\t"+
		"\u0001\t\u0003\t\u00e3\b\t\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001"+
		"\n\u0005\n\u00eb\b\n\n\n\f\n\u00ee\t\n\u0001\n\u0001\n\u0001\n\u0005\n"+
		"\u00f3\b\n\n\n\f\n\u00f6\t\n\u0003\n\u00f8\b\n\u0001\n\u0001\n\u0001\u000b"+
		"\u0001\u000b\u0001\u000b\u0001\u000b\u0005\u000b\u0100\b\u000b\n\u000b"+
		"\f\u000b\u0103\t\u000b\u0001\u000b\u0001\u000b\u0003\u000b\u0107\b\u000b"+
		"\u0001\f\u0001\f\u0001\f\u0003\f\u010c\b\f\u0001\f\u0001\f\u0003\f\u0110"+
		"\b\f\u0001\f\u0001\f\u0003\f\u0114\b\f\u0001\f\u0001\f\u0001\f\u0001\r"+
		"\u0001\r\u0003\r\u011b\b\r\u0001\u000e\u0001\u000e\u0001\u000f\u0001\u000f"+
		"\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010"+
		"\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011"+
		"\u0001\u0011\u0001\u0011\u0001\u0012\u0001\u0012\u0003\u0012\u0131\b\u0012"+
		"\u0001\u0012\u0001\u0012\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0014"+
		"\u0001\u0014\u0001\u0014\u0001\u0015\u0001\u0015\u0001\u0016\u0001\u0016"+
		"\u0001\u0016\u0001\u0016\u0001\u0016\u0001\u0016\u0003\u0016\u0143\b\u0016"+
		"\u0001\u0017\u0001\u0017\u0001\u0017\u0005\u0017\u0148\b\u0017\n\u0017"+
		"\f\u0017\u014b\t\u0017\u0001\u0018\u0001\u0018\u0001\u0018\u0005\u0018"+
		"\u0150\b\u0018\n\u0018\f\u0018\u0153\t\u0018\u0001\u0019\u0001\u0019\u0001"+
		"\u0019\u0005\u0019\u0158\b\u0019\n\u0019\f\u0019\u015b\t\u0019\u0001\u001a"+
		"\u0001\u001a\u0001\u001a\u0005\u001a\u0160\b\u001a\n\u001a\f\u001a\u0163"+
		"\t\u001a\u0001\u001b\u0001\u001b\u0001\u001b\u0005\u001b\u0168\b\u001b"+
		"\n\u001b\f\u001b\u016b\t\u001b\u0001\u001c\u0001\u001c\u0001\u001c\u0005"+
		"\u001c\u0170\b\u001c\n\u001c\f\u001c\u0173\t\u001c\u0001\u001d\u0001\u001d"+
		"\u0001\u001d\u0005\u001d\u0178\b\u001d\n\u001d\f\u001d\u017b\t\u001d\u0001"+
		"\u001e\u0001\u001e\u0001\u001e\u0005\u001e\u0180\b\u001e\n\u001e\f\u001e"+
		"\u0183\t\u001e\u0001\u001f\u0001\u001f\u0001\u001f\u0005\u001f\u0188\b"+
		"\u001f\n\u001f\f\u001f\u018b\t\u001f\u0001 \u0001 \u0001 \u0005 \u0190"+
		"\b \n \f \u0193\t \u0001!\u0001!\u0001!\u0005!\u0198\b!\n!\f!\u019b\t"+
		"!\u0001\"\u0001\"\u0001\"\u0001\"\u0003\"\u01a1\b\"\u0001#\u0001#\u0001"+
		"$\u0001$\u0005$\u01a7\b$\n$\f$\u01aa\t$\u0001%\u0001%\u0001%\u0001%\u0001"+
		"%\u0001%\u0001%\u0001%\u0001%\u0001%\u0001%\u0001%\u0001%\u0001%\u0001"+
		"%\u0001%\u0001%\u0001%\u0001%\u0001%\u0001%\u0001%\u0003%\u01c2\b%\u0001"+
		"&\u0001&\u0001&\u0003&\u01c7\b&\u0001&\u0001&\u0001\'\u0001\'\u0001\'"+
		"\u0005\'\u01ce\b\'\n\'\f\'\u01d1\t\'\u0001(\u0001(\u0001(\u0001(\u0001"+
		"(\u0001(\u0001(\u0005(\u01da\b(\n(\f(\u01dd\t(\u0001)\u0001)\u0001)\u0001"+
		")\u0005)\u01e3\b)\n)\f)\u01e6\t)\u0003)\u01e8\b)\u0001)\u0001)\u0001*"+
		"\u0001*\u0001*\u0001*\u0001*\u0001*\u0001*\u0003*\u01f3\b*\u0001+\u0001"+
		"+\u0001+\u0001+\u0005+\u01f9\b+\n+\f+\u01fc\t+\u0003+\u01fe\b+\u0001+"+
		"\u0001+\u0001,\u0001,\u0001,\u0001,\u0001,\u0001,\u0001,\u0001,\u0001"+
		",\u0003,\u020b\b,\u0001-\u0001-\u0001-\u0000\u0000.\u0000\u0002\u0004"+
		"\u0006\b\n\f\u000e\u0010\u0012\u0014\u0016\u0018\u001a\u001c\u001e \""+
		"$&(*,.02468:<>@BDFHJLNPRTVXZ\u0000\b\u0002\u0000\u0002\u0002\r\u0012\u0001"+
		"\u0000&)\u0001\u0000*-\u0001\u0000./\u0001\u000001\u0001\u000024\u0002"+
		"\u0000016;\u0001\u0000<=\u0233\u0000_\u0001\u0000\u0000\u0000\u0002g\u0001"+
		"\u0000\u0000\u0000\u0004\u007f\u0001\u0000\u0000\u0000\u0006\u00a2\u0001"+
		"\u0000\u0000\u0000\b\u00a4\u0001\u0000\u0000\u0000\n\u00ac\u0001\u0000"+
		"\u0000\u0000\f\u00c2\u0001\u0000\u0000\u0000\u000e\u00cc\u0001\u0000\u0000"+
		"\u0000\u0010\u00ce\u0001\u0000\u0000\u0000\u0012\u00d0\u0001\u0000\u0000"+
		"\u0000\u0014\u00e4\u0001\u0000\u0000\u0000\u0016\u00fb\u0001\u0000\u0000"+
		"\u0000\u0018\u0108\u0001\u0000\u0000\u0000\u001a\u011a\u0001\u0000\u0000"+
		"\u0000\u001c\u011c\u0001\u0000\u0000\u0000\u001e\u011e\u0001\u0000\u0000"+
		"\u0000 \u0120\u0001\u0000\u0000\u0000\"\u0126\u0001\u0000\u0000\u0000"+
		"$\u012e\u0001\u0000\u0000\u0000&\u0134\u0001\u0000\u0000\u0000(\u0137"+
		"\u0001\u0000\u0000\u0000*\u013a\u0001\u0000\u0000\u0000,\u013c\u0001\u0000"+
		"\u0000\u0000.\u0144\u0001\u0000\u0000\u00000\u014c\u0001\u0000\u0000\u0000"+
		"2\u0154\u0001\u0000\u0000\u00004\u015c\u0001\u0000\u0000\u00006\u0164"+
		"\u0001\u0000\u0000\u00008\u016c\u0001\u0000\u0000\u0000:\u0174\u0001\u0000"+
		"\u0000\u0000<\u017c\u0001\u0000\u0000\u0000>\u0184\u0001\u0000\u0000\u0000"+
		"@\u018c\u0001\u0000\u0000\u0000B\u0194\u0001\u0000\u0000\u0000D\u01a0"+
		"\u0001\u0000\u0000\u0000F\u01a2\u0001\u0000\u0000\u0000H\u01a4\u0001\u0000"+
		"\u0000\u0000J\u01c1\u0001\u0000\u0000\u0000L\u01c3\u0001\u0000\u0000\u0000"+
		"N\u01ca\u0001\u0000\u0000\u0000P\u01d2\u0001\u0000\u0000\u0000R\u01de"+
		"\u0001\u0000\u0000\u0000T\u01f2\u0001\u0000\u0000\u0000V\u01f4\u0001\u0000"+
		"\u0000\u0000X\u020a\u0001\u0000\u0000\u0000Z\u020c\u0001\u0000\u0000\u0000"+
		"\\^\u0003\u0002\u0001\u0000]\\\u0001\u0000\u0000\u0000^a\u0001\u0000\u0000"+
		"\u0000_]\u0001\u0000\u0000\u0000_`\u0001\u0000\u0000\u0000`b\u0001\u0000"+
		"\u0000\u0000a_\u0001\u0000\u0000\u0000bc\u0005\u0000\u0000\u0001c\u0001"+
		"\u0001\u0000\u0000\u0000dh\u0003\u0004\u0002\u0000eh\u0003\u0006\u0003"+
		"\u0000fh\u0003\f\u0006\u0000gd\u0001\u0000\u0000\u0000ge\u0001\u0000\u0000"+
		"\u0000gf\u0001\u0000\u0000\u0000h\u0003\u0001\u0000\u0000\u0000ij\u0005"+
		"\u0001\u0000\u0000jk\u0003Z-\u0000kl\u0005\u0002\u0000\u0000lm\u0003*"+
		"\u0015\u0000mn\u0005\u0003\u0000\u0000n\u0080\u0001\u0000\u0000\u0000"+
		"op\u0005\u0004\u0000\u0000pq\u0003Z-\u0000qr\u0005\u0002\u0000\u0000r"+
		"s\u0003*\u0015\u0000st\u0005\u0003\u0000\u0000t\u0080\u0001\u0000\u0000"+
		"\u0000uv\u0005\u0005\u0000\u0000vw\u0003Z-\u0000wx\u0005\u0002\u0000\u0000"+
		"xy\u0003*\u0015\u0000yz\u0005\u0003\u0000\u0000z\u0080\u0001\u0000\u0000"+
		"\u0000{|\u0005\u0001\u0000\u0000|}\u0003Z-\u0000}~\u0005\u0003\u0000\u0000"+
		"~\u0080\u0001\u0000\u0000\u0000\u007fi\u0001\u0000\u0000\u0000\u007fo"+
		"\u0001\u0000\u0000\u0000\u007fu\u0001\u0000\u0000\u0000\u007f{\u0001\u0000"+
		"\u0000\u0000\u0080\u0005\u0001\u0000\u0000\u0000\u0081\u0082\u0005\u0006"+
		"\u0000\u0000\u0082\u0083\u0003Z-\u0000\u0083\u0085\u0005\u0007\u0000\u0000"+
		"\u0084\u0086\u0003\b\u0004\u0000\u0085\u0084\u0001\u0000\u0000\u0000\u0085"+
		"\u0086\u0001\u0000\u0000\u0000\u0086\u0087\u0001\u0000\u0000\u0000\u0087"+
		"\u0088\u0005\b\u0000\u0000\u0088\u0089\u0003\n\u0005\u0000\u0089\u00a3"+
		"\u0001\u0000\u0000\u0000\u008a\u008b\u0005\u0004\u0000\u0000\u008b\u008c"+
		"\u0003Z-\u0000\u008c\u008d\u0005\u0002\u0000\u0000\u008d\u008f\u0005\u0007"+
		"\u0000\u0000\u008e\u0090\u0003\b\u0004\u0000\u008f\u008e\u0001\u0000\u0000"+
		"\u0000\u008f\u0090\u0001\u0000\u0000\u0000\u0090\u0091\u0001\u0000\u0000"+
		"\u0000\u0091\u0092\u0005\b\u0000\u0000\u0092\u0095\u0005\t\u0000\u0000"+
		"\u0093\u0096\u0003*\u0015\u0000\u0094\u0096\u0003\n\u0005\u0000\u0095"+
		"\u0093\u0001\u0000\u0000\u0000\u0095\u0094\u0001\u0000\u0000\u0000\u0096"+
		"\u00a3\u0001\u0000\u0000\u0000\u0097\u0098\u0005\u0004\u0000\u0000\u0098"+
		"\u0099\u0003Z-\u0000\u0099\u009a\u0005\u0002\u0000\u0000\u009a\u009b\u0005"+
		"\u0006\u0000\u0000\u009b\u009d\u0005\u0007\u0000\u0000\u009c\u009e\u0003"+
		"\b\u0004\u0000\u009d\u009c\u0001\u0000\u0000\u0000\u009d\u009e\u0001\u0000"+
		"\u0000\u0000\u009e\u009f\u0001\u0000\u0000\u0000\u009f\u00a0\u0005\b\u0000"+
		"\u0000\u00a0\u00a1\u0003\n\u0005\u0000\u00a1\u00a3\u0001\u0000\u0000\u0000"+
		"\u00a2\u0081\u0001\u0000\u0000\u0000\u00a2\u008a\u0001\u0000\u0000\u0000"+
		"\u00a2\u0097\u0001\u0000\u0000\u0000\u00a3\u0007\u0001\u0000\u0000\u0000"+
		"\u00a4\u00a9\u0003Z-\u0000\u00a5\u00a6\u0005\n\u0000\u0000\u00a6\u00a8"+
		"\u0003Z-\u0000\u00a7\u00a5\u0001\u0000\u0000\u0000\u00a8\u00ab\u0001\u0000"+
		"\u0000\u0000\u00a9\u00a7\u0001\u0000\u0000\u0000\u00a9\u00aa\u0001\u0000"+
		"\u0000\u0000\u00aa\t\u0001\u0000\u0000\u0000\u00ab\u00a9\u0001\u0000\u0000"+
		"\u0000\u00ac\u00b0\u0005\u000b\u0000\u0000\u00ad\u00af\u0003\f\u0006\u0000"+
		"\u00ae\u00ad\u0001\u0000\u0000\u0000\u00af\u00b2\u0001\u0000\u0000\u0000"+
		"\u00b0\u00ae\u0001\u0000\u0000\u0000\u00b0\u00b1\u0001\u0000\u0000\u0000"+
		"\u00b1\u00b3\u0001\u0000\u0000\u0000\u00b2\u00b0\u0001\u0000\u0000\u0000"+
		"\u00b3\u00b4\u0005\f\u0000\u0000\u00b4\u000b\u0001\u0000\u0000\u0000\u00b5"+
		"\u00c3\u0003\u000e\u0007\u0000\u00b6\u00c3\u0003\u0012\t\u0000\u00b7\u00c3"+
		"\u0003\u0014\n\u0000\u00b8\u00c3\u0003\u0018\f\u0000\u00b9\u00c3\u0003"+
		" \u0010\u0000\u00ba\u00c3\u0003\"\u0011\u0000\u00bb\u00c3\u0003$\u0012"+
		"\u0000\u00bc\u00c3\u0003&\u0013\u0000\u00bd\u00c3\u0003(\u0014\u0000\u00be"+
		"\u00bf\u0003L&\u0000\u00bf\u00c0\u0005\u0003\u0000\u0000\u00c0\u00c3\u0001"+
		"\u0000\u0000\u0000\u00c1\u00c3\u0003\n\u0005\u0000\u00c2\u00b5\u0001\u0000"+
		"\u0000\u0000\u00c2\u00b6\u0001\u0000\u0000\u0000\u00c2\u00b7\u0001\u0000"+
		"\u0000\u0000\u00c2\u00b8\u0001\u0000\u0000\u0000\u00c2\u00b9\u0001\u0000"+
		"\u0000\u0000\u00c2\u00ba\u0001\u0000\u0000\u0000\u00c2\u00bb\u0001\u0000"+
		"\u0000\u0000\u00c2\u00bc\u0001\u0000\u0000\u0000\u00c2\u00bd\u0001\u0000"+
		"\u0000\u0000\u00c2\u00be\u0001\u0000\u0000\u0000\u00c2\u00c1\u0001\u0000"+
		"\u0000\u0000\u00c3\r\u0001\u0000\u0000\u0000\u00c4\u00c5\u0003Z-\u0000"+
		"\u00c5\u00c6\u0003\u0010\b\u0000\u00c6\u00c7\u0003*\u0015\u0000\u00c7"+
		"\u00c8\u0005\u0003\u0000\u0000\u00c8\u00cd\u0001\u0000\u0000\u0000\u00c9"+
		"\u00ca\u0003Z-\u0000\u00ca\u00cb\u0005\u0003\u0000\u0000\u00cb\u00cd\u0001"+
		"\u0000\u0000\u0000\u00cc\u00c4\u0001\u0000\u0000\u0000\u00cc\u00c9\u0001"+
		"\u0000\u0000\u0000\u00cd\u000f\u0001\u0000\u0000\u0000\u00ce\u00cf\u0007"+
		"\u0000\u0000\u0000\u00cf\u0011\u0001\u0000\u0000\u0000\u00d0\u00d1\u0005"+
		"\u0013\u0000\u0000\u00d1\u00d2\u0005\u0007\u0000\u0000\u00d2\u00d3\u0003"+
		"*\u0015\u0000\u00d3\u00d4\u0005\b\u0000\u0000\u00d4\u00dd\u0003\n\u0005"+
		"\u0000\u00d5\u00d6\u0005\u0014\u0000\u0000\u00d6\u00d7\u0005\u0007\u0000"+
		"\u0000\u00d7\u00d8\u0003*\u0015\u0000\u00d8\u00d9\u0005\b\u0000\u0000"+
		"\u00d9\u00da\u0003\n\u0005\u0000\u00da\u00dc\u0001\u0000\u0000\u0000\u00db"+
		"\u00d5\u0001\u0000\u0000\u0000\u00dc\u00df\u0001\u0000\u0000\u0000\u00dd"+
		"\u00db\u0001\u0000\u0000\u0000\u00dd\u00de\u0001\u0000\u0000\u0000\u00de"+
		"\u00e2\u0001\u0000\u0000\u0000\u00df\u00dd\u0001\u0000\u0000\u0000\u00e0"+
		"\u00e1\u0005\u0015\u0000\u0000\u00e1\u00e3\u0003\n\u0005\u0000\u00e2\u00e0"+
		"\u0001\u0000\u0000\u0000\u00e2\u00e3\u0001\u0000\u0000\u0000\u00e3\u0013"+
		"\u0001\u0000\u0000\u0000\u00e4\u00e5\u0005\u0016\u0000\u0000\u00e5\u00e6"+
		"\u0005\u0007\u0000\u0000\u00e6\u00e7\u0003*\u0015\u0000\u00e7\u00e8\u0005"+
		"\b\u0000\u0000\u00e8\u00ec\u0005\u000b\u0000\u0000\u00e9\u00eb\u0003\u0016"+
		"\u000b\u0000\u00ea\u00e9\u0001\u0000\u0000\u0000\u00eb\u00ee\u0001\u0000"+
		"\u0000\u0000\u00ec\u00ea\u0001\u0000\u0000\u0000\u00ec\u00ed\u0001\u0000"+
		"\u0000\u0000\u00ed\u00f7\u0001\u0000\u0000\u0000\u00ee\u00ec\u0001\u0000"+
		"\u0000\u0000\u00ef\u00f0\u0005\u0017\u0000\u0000\u00f0\u00f4\u0005\u0018"+
		"\u0000\u0000\u00f1\u00f3\u0003\f\u0006\u0000\u00f2\u00f1\u0001\u0000\u0000"+
		"\u0000\u00f3\u00f6\u0001\u0000\u0000\u0000\u00f4\u00f2\u0001\u0000\u0000"+
		"\u0000\u00f4\u00f5\u0001\u0000\u0000\u0000\u00f5\u00f8\u0001\u0000\u0000"+
		"\u0000\u00f6\u00f4\u0001\u0000\u0000\u0000\u00f7\u00ef\u0001\u0000\u0000"+
		"\u0000\u00f7\u00f8\u0001\u0000\u0000\u0000\u00f8\u00f9\u0001\u0000\u0000"+
		"\u0000\u00f9\u00fa\u0005\f\u0000\u0000\u00fa\u0015\u0001\u0000\u0000\u0000"+
		"\u00fb\u00fc\u0005\u0019\u0000\u0000\u00fc\u00fd\u0003*\u0015\u0000\u00fd"+
		"\u0101\u0005\u0018\u0000\u0000\u00fe\u0100\u0003\f\u0006\u0000\u00ff\u00fe"+
		"\u0001\u0000\u0000\u0000\u0100\u0103\u0001\u0000\u0000\u0000\u0101\u00ff"+
		"\u0001\u0000\u0000\u0000\u0101\u0102\u0001\u0000\u0000\u0000\u0102\u0106"+
		"\u0001\u0000\u0000\u0000\u0103\u0101\u0001\u0000\u0000\u0000\u0104\u0105"+
		"\u0005\u001a\u0000\u0000\u0105\u0107\u0005\u0003\u0000\u0000\u0106\u0104"+
		"\u0001\u0000\u0000\u0000\u0106\u0107\u0001\u0000\u0000\u0000\u0107\u0017"+
		"\u0001\u0000\u0000\u0000\u0108\u0109\u0005\u001b\u0000\u0000\u0109\u010b"+
		"\u0005\u0007\u0000\u0000\u010a\u010c\u0003\u001a\r\u0000\u010b\u010a\u0001"+
		"\u0000\u0000\u0000\u010b\u010c\u0001\u0000\u0000\u0000\u010c\u010d\u0001"+
		"\u0000\u0000\u0000\u010d\u010f\u0005\u0003\u0000\u0000\u010e\u0110\u0003"+
		"\u001c\u000e\u0000\u010f\u010e\u0001\u0000\u0000\u0000\u010f\u0110\u0001"+
		"\u0000\u0000\u0000\u0110\u0111\u0001\u0000\u0000\u0000\u0111\u0113\u0005"+
		"\u0003\u0000\u0000\u0112\u0114\u0003\u001e\u000f\u0000\u0113\u0112\u0001"+
		"\u0000\u0000\u0000\u0113\u0114\u0001\u0000\u0000\u0000\u0114\u0115\u0001"+
		"\u0000\u0000\u0000\u0115\u0116\u0005\b\u0000\u0000\u0116\u0117\u0003\n"+
		"\u0005\u0000\u0117\u0019\u0001\u0000\u0000\u0000\u0118\u011b\u0003\u0004"+
		"\u0002\u0000\u0119\u011b\u0003*\u0015\u0000\u011a\u0118\u0001\u0000\u0000"+
		"\u0000\u011a\u0119\u0001\u0000\u0000\u0000\u011b\u001b\u0001\u0000\u0000"+
		"\u0000\u011c\u011d\u0003*\u0015\u0000\u011d\u001d\u0001\u0000\u0000\u0000"+
		"\u011e\u011f\u0003*\u0015\u0000\u011f\u001f\u0001\u0000\u0000\u0000\u0120"+
		"\u0121\u0005\u001c\u0000\u0000\u0121\u0122\u0005\u0007\u0000\u0000\u0122"+
		"\u0123\u0003*\u0015\u0000\u0123\u0124\u0005\b\u0000\u0000\u0124\u0125"+
		"\u0003\n\u0005\u0000\u0125!\u0001\u0000\u0000\u0000\u0126\u0127\u0005"+
		"\u001d\u0000\u0000\u0127\u0128\u0003\n\u0005\u0000\u0128\u0129\u0005\u001c"+
		"\u0000\u0000\u0129\u012a\u0005\u0007\u0000\u0000\u012a\u012b\u0003*\u0015"+
		"\u0000\u012b\u012c\u0005\b\u0000\u0000\u012c\u012d\u0005\u0003\u0000\u0000"+
		"\u012d#\u0001\u0000\u0000\u0000\u012e\u0130\u0005\u001e\u0000\u0000\u012f"+
		"\u0131\u0003*\u0015\u0000\u0130\u012f\u0001\u0000\u0000\u0000\u0130\u0131"+
		"\u0001\u0000\u0000\u0000\u0131\u0132\u0001\u0000\u0000\u0000\u0132\u0133"+
		"\u0005\u0003\u0000\u0000\u0133%\u0001\u0000\u0000\u0000\u0134\u0135\u0005"+
		"\u001a\u0000\u0000\u0135\u0136\u0005\u0003\u0000\u0000\u0136\'\u0001\u0000"+
		"\u0000\u0000\u0137\u0138\u0005\u001f\u0000\u0000\u0138\u0139\u0005\u0003"+
		"\u0000\u0000\u0139)\u0001\u0000\u0000\u0000\u013a\u013b\u0003,\u0016\u0000"+
		"\u013b+\u0001\u0000\u0000\u0000\u013c\u0142\u0003.\u0017\u0000\u013d\u013e"+
		"\u0005 \u0000\u0000\u013e\u013f\u0003*\u0015\u0000\u013f\u0140\u0005\u0018"+
		"\u0000\u0000\u0140\u0141\u0003*\u0015\u0000\u0141\u0143\u0001\u0000\u0000"+
		"\u0000\u0142\u013d\u0001\u0000\u0000\u0000\u0142\u0143\u0001\u0000\u0000"+
		"\u0000\u0143-\u0001\u0000\u0000\u0000\u0144\u0149\u00030\u0018\u0000\u0145"+
		"\u0146\u0005!\u0000\u0000\u0146\u0148\u00030\u0018\u0000\u0147\u0145\u0001"+
		"\u0000\u0000\u0000\u0148\u014b\u0001\u0000\u0000\u0000\u0149\u0147\u0001"+
		"\u0000\u0000\u0000\u0149\u014a\u0001\u0000\u0000\u0000\u014a/\u0001\u0000"+
		"\u0000\u0000\u014b\u0149\u0001\u0000\u0000\u0000\u014c\u0151\u00032\u0019"+
		"\u0000\u014d\u014e\u0005\"\u0000\u0000\u014e\u0150\u00032\u0019\u0000"+
		"\u014f\u014d\u0001\u0000\u0000\u0000\u0150\u0153\u0001\u0000\u0000\u0000"+
		"\u0151\u014f\u0001\u0000\u0000\u0000\u0151\u0152\u0001\u0000\u0000\u0000"+
		"\u01521\u0001\u0000\u0000\u0000\u0153\u0151\u0001\u0000\u0000\u0000\u0154"+
		"\u0159\u00034\u001a\u0000\u0155\u0156\u0005#\u0000\u0000\u0156\u0158\u0003"+
		"4\u001a\u0000\u0157\u0155\u0001\u0000\u0000\u0000\u0158\u015b\u0001\u0000"+
		"\u0000\u0000\u0159\u0157\u0001\u0000\u0000\u0000\u0159\u015a\u0001\u0000"+
		"\u0000\u0000\u015a3\u0001\u0000\u0000\u0000\u015b\u0159\u0001\u0000\u0000"+
		"\u0000\u015c\u0161\u00036\u001b\u0000\u015d\u015e\u0005$\u0000\u0000\u015e"+
		"\u0160\u00036\u001b\u0000\u015f\u015d\u0001\u0000\u0000\u0000\u0160\u0163"+
		"\u0001\u0000\u0000\u0000\u0161\u015f\u0001\u0000\u0000\u0000\u0161\u0162"+
		"\u0001\u0000\u0000\u0000\u01625\u0001\u0000\u0000\u0000\u0163\u0161\u0001"+
		"\u0000\u0000\u0000\u0164\u0169\u00038\u001c\u0000\u0165\u0166\u0005%\u0000"+
		"\u0000\u0166\u0168\u00038\u001c\u0000\u0167\u0165\u0001\u0000\u0000\u0000"+
		"\u0168\u016b\u0001\u0000\u0000\u0000\u0169\u0167\u0001\u0000\u0000\u0000"+
		"\u0169\u016a\u0001\u0000\u0000\u0000\u016a7\u0001\u0000\u0000\u0000\u016b"+
		"\u0169\u0001\u0000\u0000\u0000\u016c\u0171\u0003:\u001d\u0000\u016d\u016e"+
		"\u0007\u0001\u0000\u0000\u016e\u0170\u0003:\u001d\u0000\u016f\u016d\u0001"+
		"\u0000\u0000\u0000\u0170\u0173\u0001\u0000\u0000\u0000\u0171\u016f\u0001"+
		"\u0000\u0000\u0000\u0171\u0172\u0001\u0000\u0000\u0000\u01729\u0001\u0000"+
		"\u0000\u0000\u0173\u0171\u0001\u0000\u0000\u0000\u0174\u0179\u0003<\u001e"+
		"\u0000\u0175\u0176\u0007\u0002\u0000\u0000\u0176\u0178\u0003<\u001e\u0000"+
		"\u0177\u0175\u0001\u0000\u0000\u0000\u0178\u017b\u0001\u0000\u0000\u0000"+
		"\u0179\u0177\u0001\u0000\u0000\u0000\u0179\u017a\u0001\u0000\u0000\u0000"+
		"\u017a;\u0001\u0000\u0000\u0000\u017b\u0179\u0001\u0000\u0000\u0000\u017c"+
		"\u0181\u0003>\u001f\u0000\u017d\u017e\u0007\u0003\u0000\u0000\u017e\u0180"+
		"\u0003>\u001f\u0000\u017f\u017d\u0001\u0000\u0000\u0000\u0180\u0183\u0001"+
		"\u0000\u0000\u0000\u0181\u017f\u0001\u0000\u0000\u0000\u0181\u0182\u0001"+
		"\u0000\u0000\u0000\u0182=\u0001\u0000\u0000\u0000\u0183\u0181\u0001\u0000"+
		"\u0000\u0000\u0184\u0189\u0003@ \u0000\u0185\u0186\u0007\u0004\u0000\u0000"+
		"\u0186\u0188\u0003@ \u0000\u0187\u0185\u0001\u0000\u0000\u0000\u0188\u018b"+
		"\u0001\u0000\u0000\u0000\u0189\u0187\u0001\u0000\u0000\u0000\u0189\u018a"+
		"\u0001\u0000\u0000\u0000\u018a?\u0001\u0000\u0000\u0000\u018b\u0189\u0001"+
		"\u0000\u0000\u0000\u018c\u0191\u0003B!\u0000\u018d\u018e\u0007\u0005\u0000"+
		"\u0000\u018e\u0190\u0003B!\u0000\u018f\u018d\u0001\u0000\u0000\u0000\u0190"+
		"\u0193\u0001\u0000\u0000\u0000\u0191\u018f\u0001\u0000\u0000\u0000\u0191"+
		"\u0192\u0001\u0000\u0000\u0000\u0192A\u0001\u0000\u0000\u0000\u0193\u0191"+
		"\u0001\u0000\u0000\u0000\u0194\u0199\u0003D\"\u0000\u0195\u0196\u0005"+
		"5\u0000\u0000\u0196\u0198\u0003D\"\u0000\u0197\u0195\u0001\u0000\u0000"+
		"\u0000\u0198\u019b\u0001\u0000\u0000\u0000\u0199\u0197\u0001\u0000\u0000"+
		"\u0000\u0199\u019a\u0001\u0000\u0000\u0000\u019aC\u0001\u0000\u0000\u0000"+
		"\u019b\u0199\u0001\u0000\u0000\u0000\u019c\u019d\u0003F#\u0000\u019d\u019e"+
		"\u0003D\"\u0000\u019e\u01a1\u0001\u0000\u0000\u0000\u019f\u01a1\u0003"+
		"H$\u0000\u01a0\u019c\u0001\u0000\u0000\u0000\u01a0\u019f\u0001\u0000\u0000"+
		"\u0000\u01a1E\u0001\u0000\u0000\u0000\u01a2\u01a3\u0007\u0006\u0000\u0000"+
		"\u01a3G\u0001\u0000\u0000\u0000\u01a4\u01a8\u0003J%\u0000\u01a5\u01a7"+
		"\u0007\u0007\u0000\u0000\u01a6\u01a5\u0001\u0000\u0000\u0000\u01a7\u01aa"+
		"\u0001\u0000\u0000\u0000\u01a8\u01a6\u0001\u0000\u0000\u0000\u01a8\u01a9"+
		"\u0001\u0000\u0000\u0000\u01a9I\u0001\u0000\u0000\u0000\u01aa\u01a8\u0001"+
		"\u0000\u0000\u0000\u01ab\u01c2\u0005>\u0000\u0000\u01ac\u01c2\u0005?\u0000"+
		"\u0000\u01ad\u01c2\u0005@\u0000\u0000\u01ae\u01c2\u0005A\u0000\u0000\u01af"+
		"\u01c2\u0005B\u0000\u0000\u01b0\u01c2\u0005C\u0000\u0000\u01b1\u01c2\u0005"+
		"D\u0000\u0000\u01b2\u01c2\u0003Z-\u0000\u01b3\u01c2\u0003R)\u0000\u01b4"+
		"\u01c2\u0003V+\u0000\u01b5\u01b6\u0005\u0007\u0000\u0000\u01b6\u01b7\u0003"+
		"*\u0015\u0000\u01b7\u01b8\u0005\b\u0000\u0000\u01b8\u01c2\u0001\u0000"+
		"\u0000\u0000\u01b9\u01c2\u0003L&\u0000\u01ba\u01c2\u0003P(\u0000\u01bb"+
		"\u01bc\u0005E\u0000\u0000\u01bc\u01c2\u0003X,\u0000\u01bd\u01be\u0005"+
		"F\u0000\u0000\u01be\u01c2\u0003Z-\u0000\u01bf\u01c0\u0005G\u0000\u0000"+
		"\u01c0\u01c2\u0003P(\u0000\u01c1\u01ab\u0001\u0000\u0000\u0000\u01c1\u01ac"+
		"\u0001\u0000\u0000\u0000\u01c1\u01ad\u0001\u0000\u0000\u0000\u01c1\u01ae"+
		"\u0001\u0000\u0000\u0000\u01c1\u01af\u0001\u0000\u0000\u0000\u01c1\u01b0"+
		"\u0001\u0000\u0000\u0000\u01c1\u01b1\u0001\u0000\u0000\u0000\u01c1\u01b2"+
		"\u0001\u0000\u0000\u0000\u01c1\u01b3\u0001\u0000\u0000\u0000\u01c1\u01b4"+
		"\u0001\u0000\u0000\u0000\u01c1\u01b5\u0001\u0000\u0000\u0000\u01c1\u01b9"+
		"\u0001\u0000\u0000\u0000\u01c1\u01ba\u0001\u0000\u0000\u0000\u01c1\u01bb"+
		"\u0001\u0000\u0000\u0000\u01c1\u01bd\u0001\u0000\u0000\u0000\u01c1\u01bf"+
		"\u0001\u0000\u0000\u0000\u01c2K\u0001\u0000\u0000\u0000\u01c3\u01c4\u0003"+
		"Z-\u0000\u01c4\u01c6\u0005\u0007\u0000\u0000\u01c5\u01c7\u0003N\'\u0000"+
		"\u01c6\u01c5\u0001\u0000\u0000\u0000\u01c6\u01c7\u0001\u0000\u0000\u0000"+
		"\u01c7\u01c8\u0001\u0000\u0000\u0000\u01c8\u01c9\u0005\b\u0000\u0000\u01c9"+
		"M\u0001\u0000\u0000\u0000\u01ca\u01cf\u0003*\u0015\u0000\u01cb\u01cc\u0005"+
		"\n\u0000\u0000\u01cc\u01ce\u0003*\u0015\u0000\u01cd\u01cb\u0001\u0000"+
		"\u0000\u0000\u01ce\u01d1\u0001\u0000\u0000\u0000\u01cf\u01cd\u0001\u0000"+
		"\u0000\u0000\u01cf\u01d0\u0001\u0000\u0000\u0000\u01d0O\u0001\u0000\u0000"+
		"\u0000\u01d1\u01cf\u0001\u0000\u0000\u0000\u01d2\u01db\u0003Z-\u0000\u01d3"+
		"\u01d4\u0005H\u0000\u0000\u01d4\u01da\u0003Z-\u0000\u01d5\u01d6\u0005"+
		"I\u0000\u0000\u01d6\u01d7\u0003*\u0015\u0000\u01d7\u01d8\u0005I\u0000"+
		"\u0000\u01d8\u01da\u0001\u0000\u0000\u0000\u01d9\u01d3\u0001\u0000\u0000"+
		"\u0000\u01d9\u01d5\u0001\u0000\u0000\u0000\u01da\u01dd\u0001\u0000\u0000"+
		"\u0000\u01db\u01d9\u0001\u0000\u0000\u0000\u01db\u01dc\u0001\u0000\u0000"+
		"\u0000\u01dcQ\u0001\u0000\u0000\u0000\u01dd\u01db\u0001\u0000\u0000\u0000"+
		"\u01de\u01e7\u0005\u000b\u0000\u0000\u01df\u01e4\u0003T*\u0000\u01e0\u01e1"+
		"\u0005\n\u0000\u0000\u01e1\u01e3\u0003T*\u0000\u01e2\u01e0\u0001\u0000"+
		"\u0000\u0000\u01e3\u01e6\u0001\u0000\u0000\u0000\u01e4\u01e2\u0001\u0000"+
		"\u0000\u0000\u01e4\u01e5\u0001\u0000\u0000\u0000\u01e5\u01e8\u0001\u0000"+
		"\u0000\u0000\u01e6\u01e4\u0001\u0000\u0000\u0000\u01e7\u01df\u0001\u0000"+
		"\u0000\u0000\u01e7\u01e8\u0001\u0000\u0000\u0000\u01e8\u01e9\u0001\u0000"+
		"\u0000\u0000\u01e9\u01ea\u0005\f\u0000\u0000\u01eaS\u0001\u0000\u0000"+
		"\u0000\u01eb\u01ec\u0003Z-\u0000\u01ec\u01ed\u0005\u0018\u0000\u0000\u01ed"+
		"\u01ee\u0003*\u0015\u0000\u01ee\u01f3\u0001\u0000\u0000\u0000\u01ef\u01f0"+
		"\u0005?\u0000\u0000\u01f0\u01f1\u0005\u0018\u0000\u0000\u01f1\u01f3\u0003"+
		"*\u0015\u0000\u01f2\u01eb\u0001\u0000\u0000\u0000\u01f2\u01ef\u0001\u0000"+
		"\u0000\u0000\u01f3U\u0001\u0000\u0000\u0000\u01f4\u01fd\u0005I\u0000\u0000"+
		"\u01f5\u01fa\u0003*\u0015\u0000\u01f6\u01f7\u0005\n\u0000\u0000\u01f7"+
		"\u01f9\u0003*\u0015\u0000\u01f8\u01f6\u0001\u0000\u0000\u0000\u01f9\u01fc"+
		"\u0001\u0000\u0000\u0000\u01fa\u01f8\u0001\u0000\u0000\u0000\u01fa\u01fb"+
		"\u0001\u0000\u0000\u0000\u01fb\u01fe\u0001\u0000\u0000\u0000\u01fc\u01fa"+
		"\u0001\u0000\u0000\u0000\u01fd\u01f5\u0001\u0000\u0000\u0000\u01fd\u01fe"+
		"\u0001\u0000\u0000\u0000\u01fe\u01ff\u0001\u0000\u0000\u0000\u01ff\u0200"+
		"\u0005I\u0000\u0000\u0200W\u0001\u0000\u0000\u0000\u0201\u020b\u0005J"+
		"\u0000\u0000\u0202\u020b\u0005K\u0000\u0000\u0203\u020b\u0005L\u0000\u0000"+
		"\u0204\u020b\u0005M\u0000\u0000\u0205\u020b\u0005N\u0000\u0000\u0206\u020b"+
		"\u0005O\u0000\u0000\u0207\u020b\u0005P\u0000\u0000\u0208\u020b\u0005Q"+
		"\u0000\u0000\u0209\u020b\u0003Z-\u0000\u020a\u0201\u0001\u0000\u0000\u0000"+
		"\u020a\u0202\u0001\u0000\u0000\u0000\u020a\u0203\u0001\u0000\u0000\u0000"+
		"\u020a\u0204\u0001\u0000\u0000\u0000\u020a\u0205\u0001\u0000\u0000\u0000"+
		"\u020a\u0206\u0001\u0000\u0000\u0000\u020a\u0207\u0001\u0000\u0000\u0000"+
		"\u020a\u0208\u0001\u0000\u0000\u0000\u020a\u0209\u0001\u0000\u0000\u0000"+
		"\u020bY\u0001\u0000\u0000\u0000\u020c\u020d\u0005R\u0000\u0000\u020d["+
		"\u0001\u0000\u0000\u00001_g\u007f\u0085\u008f\u0095\u009d\u00a2\u00a9"+
		"\u00b0\u00c2\u00cc\u00dd\u00e2\u00ec\u00f4\u00f7\u0101\u0106\u010b\u010f"+
		"\u0113\u011a\u0130\u0142\u0149\u0151\u0159\u0161\u0169\u0171\u0179\u0181"+
		"\u0189\u0191\u0199\u01a0\u01a8\u01c1\u01c6\u01cf\u01d9\u01db\u01e4\u01e7"+
		"\u01f2\u01fa\u01fd\u020a";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}