// Generated from Arithmetic.g4 by ANTLR 4.7.1
package de.progbusters.parser;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class ArithmeticLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.7.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, ID=11, INTEGER=12, WS=13, LPAREN=14, RPAREN=15, CONSTKEYWORD=16, 
		PLUSOP=17, MINOP=18, MULTOP=19, DIVOP=20, LT=21, LEQ=22, GT=23, GEQ=24, 
		EQ=25, AND=26, OR=27, NOT=28, ASSIGNOP=29;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "T__6", "T__7", "T__8", 
		"T__9", "ID", "INTEGER", "WS", "LPAREN", "RPAREN", "CONSTKEYWORD", "PLUSOP", 
		"MINOP", "MULTOP", "DIVOP", "LT", "LEQ", "GT", "GEQ", "EQ", "AND", "OR", 
		"NOT", "ASSIGNOP"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "';'", "'println('", "'int'", "'{'", "'return'", "'}'", "','", "'if'", 
		"'else'", "'while'", null, null, null, "'('", "')'", "'const int'", "'+'", 
		"'-'", "'*'", "'/'", "'<'", "'<='", "'>'", "'>='", "'=='", "'&&'", "'||'", 
		"'!'", "'='"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, null, null, null, null, null, null, null, "ID", 
		"INTEGER", "WS", "LPAREN", "RPAREN", "CONSTKEYWORD", "PLUSOP", "MINOP", 
		"MULTOP", "DIVOP", "LT", "LEQ", "GT", "GEQ", "EQ", "AND", "OR", "NOT", 
		"ASSIGNOP"
	};
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


	public ArithmeticLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "Arithmetic.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getChannelNames() { return channelNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\37\u00a7\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31"+
		"\t\31\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\3\2\3\2\3\3\3"+
		"\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\4\3\4\3\4\3\4\3\5\3\5\3\6\3\6\3\6\3\6"+
		"\3\6\3\6\3\6\3\7\3\7\3\b\3\b\3\t\3\t\3\t\3\n\3\n\3\n\3\n\3\n\3\13\3\13"+
		"\3\13\3\13\3\13\3\13\3\f\3\f\7\fj\n\f\f\f\16\fm\13\f\3\r\6\rp\n\r\r\r"+
		"\16\rq\3\16\6\16u\n\16\r\16\16\16v\3\16\3\16\3\17\3\17\3\20\3\20\3\21"+
		"\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\22\3\22\3\23\3\23\3\24"+
		"\3\24\3\25\3\25\3\26\3\26\3\27\3\27\3\27\3\30\3\30\3\31\3\31\3\31\3\32"+
		"\3\32\3\32\3\33\3\33\3\33\3\34\3\34\3\34\3\35\3\35\3\36\3\36\2\2\37\3"+
		"\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33\17\35\20\37"+
		"\21!\22#\23%\24\'\25)\26+\27-\30/\31\61\32\63\33\65\34\67\359\36;\37\3"+
		"\2\6\4\2C\\c|\5\2\62;C\\c|\3\2\62;\5\2\13\f\17\17\"\"\2\u00a9\2\3\3\2"+
		"\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17"+
		"\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2"+
		"\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3"+
		"\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2\2\61\3"+
		"\2\2\2\2\63\3\2\2\2\2\65\3\2\2\2\2\67\3\2\2\2\29\3\2\2\2\2;\3\2\2\2\3"+
		"=\3\2\2\2\5?\3\2\2\2\7H\3\2\2\2\tL\3\2\2\2\13N\3\2\2\2\rU\3\2\2\2\17W"+
		"\3\2\2\2\21Y\3\2\2\2\23\\\3\2\2\2\25a\3\2\2\2\27g\3\2\2\2\31o\3\2\2\2"+
		"\33t\3\2\2\2\35z\3\2\2\2\37|\3\2\2\2!~\3\2\2\2#\u0088\3\2\2\2%\u008a\3"+
		"\2\2\2\'\u008c\3\2\2\2)\u008e\3\2\2\2+\u0090\3\2\2\2-\u0092\3\2\2\2/\u0095"+
		"\3\2\2\2\61\u0097\3\2\2\2\63\u009a\3\2\2\2\65\u009d\3\2\2\2\67\u00a0\3"+
		"\2\2\29\u00a3\3\2\2\2;\u00a5\3\2\2\2=>\7=\2\2>\4\3\2\2\2?@\7r\2\2@A\7"+
		"t\2\2AB\7k\2\2BC\7p\2\2CD\7v\2\2DE\7n\2\2EF\7p\2\2FG\7*\2\2G\6\3\2\2\2"+
		"HI\7k\2\2IJ\7p\2\2JK\7v\2\2K\b\3\2\2\2LM\7}\2\2M\n\3\2\2\2NO\7t\2\2OP"+
		"\7g\2\2PQ\7v\2\2QR\7w\2\2RS\7t\2\2ST\7p\2\2T\f\3\2\2\2UV\7\177\2\2V\16"+
		"\3\2\2\2WX\7.\2\2X\20\3\2\2\2YZ\7k\2\2Z[\7h\2\2[\22\3\2\2\2\\]\7g\2\2"+
		"]^\7n\2\2^_\7u\2\2_`\7g\2\2`\24\3\2\2\2ab\7y\2\2bc\7j\2\2cd\7k\2\2de\7"+
		"n\2\2ef\7g\2\2f\26\3\2\2\2gk\t\2\2\2hj\t\3\2\2ih\3\2\2\2jm\3\2\2\2ki\3"+
		"\2\2\2kl\3\2\2\2l\30\3\2\2\2mk\3\2\2\2np\t\4\2\2on\3\2\2\2pq\3\2\2\2q"+
		"o\3\2\2\2qr\3\2\2\2r\32\3\2\2\2su\t\5\2\2ts\3\2\2\2uv\3\2\2\2vt\3\2\2"+
		"\2vw\3\2\2\2wx\3\2\2\2xy\b\16\2\2y\34\3\2\2\2z{\7*\2\2{\36\3\2\2\2|}\7"+
		"+\2\2} \3\2\2\2~\177\7e\2\2\177\u0080\7q\2\2\u0080\u0081\7p\2\2\u0081"+
		"\u0082\7u\2\2\u0082\u0083\7v\2\2\u0083\u0084\7\"\2\2\u0084\u0085\7k\2"+
		"\2\u0085\u0086\7p\2\2\u0086\u0087\7v\2\2\u0087\"\3\2\2\2\u0088\u0089\7"+
		"-\2\2\u0089$\3\2\2\2\u008a\u008b\7/\2\2\u008b&\3\2\2\2\u008c\u008d\7,"+
		"\2\2\u008d(\3\2\2\2\u008e\u008f\7\61\2\2\u008f*\3\2\2\2\u0090\u0091\7"+
		">\2\2\u0091,\3\2\2\2\u0092\u0093\7>\2\2\u0093\u0094\7?\2\2\u0094.\3\2"+
		"\2\2\u0095\u0096\7@\2\2\u0096\60\3\2\2\2\u0097\u0098\7@\2\2\u0098\u0099"+
		"\7?\2\2\u0099\62\3\2\2\2\u009a\u009b\7?\2\2\u009b\u009c\7?\2\2\u009c\64"+
		"\3\2\2\2\u009d\u009e\7(\2\2\u009e\u009f\7(\2\2\u009f\66\3\2\2\2\u00a0"+
		"\u00a1\7~\2\2\u00a1\u00a2\7~\2\2\u00a28\3\2\2\2\u00a3\u00a4\7#\2\2\u00a4"+
		":\3\2\2\2\u00a5\u00a6\7?\2\2\u00a6<\3\2\2\2\6\2kqv\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}