// Generated from Arithmetic.g4 by ANTLR 4.7.1
package de.progbusters.parser;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class ArithmeticParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.7.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, ID=11, INTEGER=12, WS=13, LPAREN=14, RPAREN=15, CONSTKEYWORD=16, 
		PLUSOP=17, MINOP=18, MULTOP=19, DIVOP=20, LT=21, LEQ=22, GT=23, GEQ=24, 
		EQ=25, AND=26, OR=27, NOT=28, ASSIGNOP=29;
	public static final int
		RULE_program = 0, RULE_progPart = 1, RULE_statement = 2, RULE_println = 3, 
		RULE_constDeclaration = 4, RULE_varDeclaration = 5, RULE_assignment = 6, 
		RULE_functionDefinition = 7, RULE_functionCall = 8, RULE_statementList = 9, 
		RULE_parameterDeclaration = 10, RULE_expressionList = 11, RULE_branch = 12, 
		RULE_loop = 13, RULE_block = 14, RULE_expression = 15;
	public static final String[] ruleNames = {
		"program", "progPart", "statement", "println", "constDeclaration", "varDeclaration", 
		"assignment", "functionDefinition", "functionCall", "statementList", "parameterDeclaration", 
		"expressionList", "branch", "loop", "block", "expression"
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

	@Override
	public String getGrammarFileName() { return "Arithmetic.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public ArithmeticParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class ProgramContext extends ParserRuleContext {
		public List<ProgPartContext> progPart() {
			return getRuleContexts(ProgPartContext.class);
		}
		public ProgPartContext progPart(int i) {
			return getRuleContext(ProgPartContext.class,i);
		}
		public ProgramContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_program; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ArithmeticVisitor ) return ((ArithmeticVisitor<? extends T>)visitor).visitProgram(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ProgramContext program() throws RecognitionException {
		ProgramContext _localctx = new ProgramContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_program);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(33); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(32);
				progPart();
				}
				}
				setState(35); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__1) | (1L << T__2) | (1L << T__7) | (1L << T__9) | (1L << ID) | (1L << CONSTKEYWORD))) != 0) );
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

	public static class ProgPartContext extends ParserRuleContext {
		public ProgPartContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_progPart; }
	 
		public ProgPartContext() { }
		public void copyFrom(ProgPartContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class ProgPartFunctionDefContext extends ProgPartContext {
		public FunctionDefinitionContext functionDefinition() {
			return getRuleContext(FunctionDefinitionContext.class,0);
		}
		public ProgPartFunctionDefContext(ProgPartContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ArithmeticVisitor ) return ((ArithmeticVisitor<? extends T>)visitor).visitProgPartFunctionDef(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class MainStatementContext extends ProgPartContext {
		public StatementContext statement() {
			return getRuleContext(StatementContext.class,0);
		}
		public MainStatementContext(ProgPartContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ArithmeticVisitor ) return ((ArithmeticVisitor<? extends T>)visitor).visitMainStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ProgPartContext progPart() throws RecognitionException {
		ProgPartContext _localctx = new ProgPartContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_progPart);
		try {
			setState(39);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
			case 1:
				_localctx = new MainStatementContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(37);
				statement();
				}
				break;
			case 2:
				_localctx = new ProgPartFunctionDefContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(38);
				functionDefinition();
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

	public static class StatementContext extends ParserRuleContext {
		public PrintlnContext println() {
			return getRuleContext(PrintlnContext.class,0);
		}
		public ConstDeclarationContext constDeclaration() {
			return getRuleContext(ConstDeclarationContext.class,0);
		}
		public VarDeclarationContext varDeclaration() {
			return getRuleContext(VarDeclarationContext.class,0);
		}
		public AssignmentContext assignment() {
			return getRuleContext(AssignmentContext.class,0);
		}
		public BranchContext branch() {
			return getRuleContext(BranchContext.class,0);
		}
		public LoopContext loop() {
			return getRuleContext(LoopContext.class,0);
		}
		public StatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statement; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ArithmeticVisitor ) return ((ArithmeticVisitor<? extends T>)visitor).visitStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StatementContext statement() throws RecognitionException {
		StatementContext _localctx = new StatementContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_statement);
		try {
			setState(55);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__1:
				enterOuterAlt(_localctx, 1);
				{
				setState(41);
				println();
				setState(42);
				match(T__0);
				}
				break;
			case CONSTKEYWORD:
				enterOuterAlt(_localctx, 2);
				{
				setState(44);
				constDeclaration();
				setState(45);
				match(T__0);
				}
				break;
			case T__2:
				enterOuterAlt(_localctx, 3);
				{
				setState(47);
				varDeclaration();
				setState(48);
				match(T__0);
				}
				break;
			case ID:
				enterOuterAlt(_localctx, 4);
				{
				setState(50);
				assignment();
				setState(51);
				match(T__0);
				}
				break;
			case T__7:
				enterOuterAlt(_localctx, 5);
				{
				setState(53);
				branch();
				}
				break;
			case T__9:
				enterOuterAlt(_localctx, 6);
				{
				setState(54);
				loop();
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

	public static class PrintlnContext extends ParserRuleContext {
		public ExpressionContext argument;
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public PrintlnContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_println; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ArithmeticVisitor ) return ((ArithmeticVisitor<? extends T>)visitor).visitPrintln(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PrintlnContext println() throws RecognitionException {
		PrintlnContext _localctx = new PrintlnContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_println);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(57);
			match(T__1);
			setState(58);
			((PrintlnContext)_localctx).argument = expression(0);
			setState(59);
			match(RPAREN);
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

	public static class ConstDeclarationContext extends ParserRuleContext {
		public Token constName;
		public TerminalNode CONSTKEYWORD() { return getToken(ArithmeticParser.CONSTKEYWORD, 0); }
		public TerminalNode ID() { return getToken(ArithmeticParser.ID, 0); }
		public ConstDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_constDeclaration; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ArithmeticVisitor ) return ((ArithmeticVisitor<? extends T>)visitor).visitConstDeclaration(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ConstDeclarationContext constDeclaration() throws RecognitionException {
		ConstDeclarationContext _localctx = new ConstDeclarationContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_constDeclaration);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(61);
			match(CONSTKEYWORD);
			setState(62);
			((ConstDeclarationContext)_localctx).constName = match(ID);
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

	public static class VarDeclarationContext extends ParserRuleContext {
		public Token varName;
		public TerminalNode ID() { return getToken(ArithmeticParser.ID, 0); }
		public VarDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_varDeclaration; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ArithmeticVisitor ) return ((ArithmeticVisitor<? extends T>)visitor).visitVarDeclaration(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VarDeclarationContext varDeclaration() throws RecognitionException {
		VarDeclarationContext _localctx = new VarDeclarationContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_varDeclaration);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(64);
			match(T__2);
			setState(65);
			((VarDeclarationContext)_localctx).varName = match(ID);
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

	public static class AssignmentContext extends ParserRuleContext {
		public Token varName;
		public ExpressionContext expr;
		public TerminalNode ASSIGNOP() { return getToken(ArithmeticParser.ASSIGNOP, 0); }
		public TerminalNode ID() { return getToken(ArithmeticParser.ID, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public AssignmentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assignment; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ArithmeticVisitor ) return ((ArithmeticVisitor<? extends T>)visitor).visitAssignment(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AssignmentContext assignment() throws RecognitionException {
		AssignmentContext _localctx = new AssignmentContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_assignment);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(67);
			((AssignmentContext)_localctx).varName = match(ID);
			setState(68);
			match(ASSIGNOP);
			setState(69);
			((AssignmentContext)_localctx).expr = expression(0);
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

	public static class FunctionDefinitionContext extends ParserRuleContext {
		public Token functionName;
		public ParameterDeclarationContext params;
		public StatementListContext statements;
		public ExpressionContext returnValue;
		public TerminalNode LPAREN() { return getToken(ArithmeticParser.LPAREN, 0); }
		public TerminalNode RPAREN() { return getToken(ArithmeticParser.RPAREN, 0); }
		public TerminalNode ID() { return getToken(ArithmeticParser.ID, 0); }
		public ParameterDeclarationContext parameterDeclaration() {
			return getRuleContext(ParameterDeclarationContext.class,0);
		}
		public StatementListContext statementList() {
			return getRuleContext(StatementListContext.class,0);
		}
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public FunctionDefinitionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_functionDefinition; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ArithmeticVisitor ) return ((ArithmeticVisitor<? extends T>)visitor).visitFunctionDefinition(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FunctionDefinitionContext functionDefinition() throws RecognitionException {
		FunctionDefinitionContext _localctx = new FunctionDefinitionContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_functionDefinition);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(71);
			match(T__2);
			setState(72);
			((FunctionDefinitionContext)_localctx).functionName = match(ID);
			setState(73);
			match(LPAREN);
			setState(74);
			((FunctionDefinitionContext)_localctx).params = parameterDeclaration();
			setState(75);
			match(RPAREN);
			setState(76);
			match(T__3);
			setState(77);
			((FunctionDefinitionContext)_localctx).statements = statementList();
			setState(78);
			match(T__4);
			setState(79);
			((FunctionDefinitionContext)_localctx).returnValue = expression(0);
			setState(80);
			match(T__0);
			setState(81);
			match(T__5);
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

	public static class FunctionCallContext extends ParserRuleContext {
		public Token functionName;
		public ExpressionListContext arguments;
		public TerminalNode LPAREN() { return getToken(ArithmeticParser.LPAREN, 0); }
		public TerminalNode RPAREN() { return getToken(ArithmeticParser.RPAREN, 0); }
		public TerminalNode ID() { return getToken(ArithmeticParser.ID, 0); }
		public ExpressionListContext expressionList() {
			return getRuleContext(ExpressionListContext.class,0);
		}
		public FunctionCallContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_functionCall; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ArithmeticVisitor ) return ((ArithmeticVisitor<? extends T>)visitor).visitFunctionCall(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FunctionCallContext functionCall() throws RecognitionException {
		FunctionCallContext _localctx = new FunctionCallContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_functionCall);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(83);
			((FunctionCallContext)_localctx).functionName = match(ID);
			setState(84);
			match(LPAREN);
			setState(85);
			((FunctionCallContext)_localctx).arguments = expressionList();
			setState(86);
			match(RPAREN);
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

	public static class StatementListContext extends ParserRuleContext {
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public StatementListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statementList; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ArithmeticVisitor ) return ((ArithmeticVisitor<? extends T>)visitor).visitStatementList(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StatementListContext statementList() throws RecognitionException {
		StatementListContext _localctx = new StatementListContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_statementList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(91);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__1) | (1L << T__2) | (1L << T__7) | (1L << T__9) | (1L << ID) | (1L << CONSTKEYWORD))) != 0)) {
				{
				{
				setState(88);
				statement();
				}
				}
				setState(93);
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

	public static class ParameterDeclarationContext extends ParserRuleContext {
		public VarDeclarationContext varDeclaration;
		public List<VarDeclarationContext> declarations = new ArrayList<VarDeclarationContext>();
		public List<VarDeclarationContext> varDeclaration() {
			return getRuleContexts(VarDeclarationContext.class);
		}
		public VarDeclarationContext varDeclaration(int i) {
			return getRuleContext(VarDeclarationContext.class,i);
		}
		public ParameterDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_parameterDeclaration; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ArithmeticVisitor ) return ((ArithmeticVisitor<? extends T>)visitor).visitParameterDeclaration(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ParameterDeclarationContext parameterDeclaration() throws RecognitionException {
		ParameterDeclarationContext _localctx = new ParameterDeclarationContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_parameterDeclaration);
		int _la;
		try {
			setState(103);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__2:
				enterOuterAlt(_localctx, 1);
				{
				setState(94);
				((ParameterDeclarationContext)_localctx).varDeclaration = varDeclaration();
				((ParameterDeclarationContext)_localctx).declarations.add(((ParameterDeclarationContext)_localctx).varDeclaration);
				setState(99);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__6) {
					{
					{
					setState(95);
					match(T__6);
					setState(96);
					((ParameterDeclarationContext)_localctx).varDeclaration = varDeclaration();
					((ParameterDeclarationContext)_localctx).declarations.add(((ParameterDeclarationContext)_localctx).varDeclaration);
					}
					}
					setState(101);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				break;
			case RPAREN:
				enterOuterAlt(_localctx, 2);
				{
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

	public static class ExpressionListContext extends ParserRuleContext {
		public ExpressionContext expression;
		public List<ExpressionContext> expressions = new ArrayList<ExpressionContext>();
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public ExpressionListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expressionList; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ArithmeticVisitor ) return ((ArithmeticVisitor<? extends T>)visitor).visitExpressionList(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExpressionListContext expressionList() throws RecognitionException {
		ExpressionListContext _localctx = new ExpressionListContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_expressionList);
		int _la;
		try {
			setState(114);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case ID:
			case INTEGER:
			case LPAREN:
			case NOT:
				enterOuterAlt(_localctx, 1);
				{
				setState(105);
				((ExpressionListContext)_localctx).expression = expression(0);
				((ExpressionListContext)_localctx).expressions.add(((ExpressionListContext)_localctx).expression);
				setState(110);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__6) {
					{
					{
					setState(106);
					match(T__6);
					setState(107);
					((ExpressionListContext)_localctx).expression = expression(0);
					((ExpressionListContext)_localctx).expressions.add(((ExpressionListContext)_localctx).expression);
					}
					}
					setState(112);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				break;
			case RPAREN:
				enterOuterAlt(_localctx, 2);
				{
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

	public static class BranchContext extends ParserRuleContext {
		public ExpressionContext condition;
		public BlockContext onTrue;
		public BlockContext onFalse;
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public List<BlockContext> block() {
			return getRuleContexts(BlockContext.class);
		}
		public BlockContext block(int i) {
			return getRuleContext(BlockContext.class,i);
		}
		public BranchContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_branch; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ArithmeticVisitor ) return ((ArithmeticVisitor<? extends T>)visitor).visitBranch(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BranchContext branch() throws RecognitionException {
		BranchContext _localctx = new BranchContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_branch);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(116);
			match(T__7);
			setState(117);
			match(LPAREN);
			setState(118);
			((BranchContext)_localctx).condition = expression(0);
			setState(119);
			match(RPAREN);
			setState(120);
			((BranchContext)_localctx).onTrue = block();
			setState(121);
			match(T__8);
			setState(122);
			((BranchContext)_localctx).onFalse = block();
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

	public static class LoopContext extends ParserRuleContext {
		public ExpressionContext condition;
		public BlockContext onTrue;
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public LoopContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_loop; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ArithmeticVisitor ) return ((ArithmeticVisitor<? extends T>)visitor).visitLoop(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LoopContext loop() throws RecognitionException {
		LoopContext _localctx = new LoopContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_loop);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(124);
			match(T__9);
			setState(125);
			match(LPAREN);
			setState(126);
			((LoopContext)_localctx).condition = expression(0);
			setState(127);
			match(RPAREN);
			setState(128);
			((LoopContext)_localctx).onTrue = block();
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

	public static class BlockContext extends ParserRuleContext {
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
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ArithmeticVisitor ) return ((ArithmeticVisitor<? extends T>)visitor).visitBlock(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BlockContext block() throws RecognitionException {
		BlockContext _localctx = new BlockContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_block);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(130);
			match(T__3);
			setState(134);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__1) | (1L << T__2) | (1L << T__7) | (1L << T__9) | (1L << ID) | (1L << CONSTKEYWORD))) != 0)) {
				{
				{
				setState(131);
				statement();
				}
				}
				setState(136);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(137);
			match(T__5);
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

	public static class ExpressionContext extends ParserRuleContext {
		public ExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expression; }
	 
		public ExpressionContext() { }
		public void copyFrom(ExpressionContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class MultiplicationContext extends ExpressionContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode MULTOP() { return getToken(ArithmeticParser.MULTOP, 0); }
		public MultiplicationContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ArithmeticVisitor ) return ((ArithmeticVisitor<? extends T>)visitor).visitMultiplication(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class AdditionContext extends ExpressionContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode PLUSOP() { return getToken(ArithmeticParser.PLUSOP, 0); }
		public AdditionContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ArithmeticVisitor ) return ((ArithmeticVisitor<? extends T>)visitor).visitAddition(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class VariableContext extends ExpressionContext {
		public Token varName;
		public TerminalNode ID() { return getToken(ArithmeticParser.ID, 0); }
		public VariableContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ArithmeticVisitor ) return ((ArithmeticVisitor<? extends T>)visitor).visitVariable(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ConstantContext extends ExpressionContext {
		public Token constName;
		public TerminalNode ID() { return getToken(ArithmeticParser.ID, 0); }
		public ConstantContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ArithmeticVisitor ) return ((ArithmeticVisitor<? extends T>)visitor).visitConstant(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class InverseGateContext extends ExpressionContext {
		public ExpressionContext expr;
		public TerminalNode NOT() { return getToken(ArithmeticParser.NOT, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public InverseGateContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ArithmeticVisitor ) return ((ArithmeticVisitor<? extends T>)visitor).visitInverseGate(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class AndGateContext extends ExpressionContext {
		public ExpressionContext leftSide;
		public ExpressionContext rightSide;
		public TerminalNode AND() { return getToken(ArithmeticParser.AND, 0); }
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public AndGateContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ArithmeticVisitor ) return ((ArithmeticVisitor<? extends T>)visitor).visitAndGate(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ParenthesisContext extends ExpressionContext {
		public TerminalNode LPAREN() { return getToken(ArithmeticParser.LPAREN, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(ArithmeticParser.RPAREN, 0); }
		public ParenthesisContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ArithmeticVisitor ) return ((ArithmeticVisitor<? extends T>)visitor).visitParenthesis(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class SubtractionContext extends ExpressionContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode MINOP() { return getToken(ArithmeticParser.MINOP, 0); }
		public SubtractionContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ArithmeticVisitor ) return ((ArithmeticVisitor<? extends T>)visitor).visitSubtraction(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class NumberContext extends ExpressionContext {
		public TerminalNode INTEGER() { return getToken(ArithmeticParser.INTEGER, 0); }
		public NumberContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ArithmeticVisitor ) return ((ArithmeticVisitor<? extends T>)visitor).visitNumber(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ComparisonContext extends ExpressionContext {
		public Token compareOp;
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode LT() { return getToken(ArithmeticParser.LT, 0); }
		public TerminalNode LEQ() { return getToken(ArithmeticParser.LEQ, 0); }
		public TerminalNode GT() { return getToken(ArithmeticParser.GT, 0); }
		public TerminalNode GEQ() { return getToken(ArithmeticParser.GEQ, 0); }
		public TerminalNode EQ() { return getToken(ArithmeticParser.EQ, 0); }
		public ComparisonContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ArithmeticVisitor ) return ((ArithmeticVisitor<? extends T>)visitor).visitComparison(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class FunctionCallExpressionContext extends ExpressionContext {
		public FunctionCallContext functionCall() {
			return getRuleContext(FunctionCallContext.class,0);
		}
		public FunctionCallExpressionContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ArithmeticVisitor ) return ((ArithmeticVisitor<? extends T>)visitor).visitFunctionCallExpression(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class OrGateContext extends ExpressionContext {
		public ExpressionContext leftSide;
		public ExpressionContext rightSide;
		public TerminalNode OR() { return getToken(ArithmeticParser.OR, 0); }
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public OrGateContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ArithmeticVisitor ) return ((ArithmeticVisitor<? extends T>)visitor).visitOrGate(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class DivisionContext extends ExpressionContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode DIVOP() { return getToken(ArithmeticParser.DIVOP, 0); }
		public DivisionContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ArithmeticVisitor ) return ((ArithmeticVisitor<? extends T>)visitor).visitDivision(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExpressionContext expression() throws RecognitionException {
		return expression(0);
	}

	private ExpressionContext expression(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExpressionContext _localctx = new ExpressionContext(_ctx, _parentState);
		ExpressionContext _prevctx = _localctx;
		int _startState = 30;
		enterRecursionRule(_localctx, 30, RULE_expression, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(150);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,9,_ctx) ) {
			case 1:
				{
				_localctx = new NumberContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(140);
				match(INTEGER);
				}
				break;
			case 2:
				{
				_localctx = new VariableContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(141);
				((VariableContext)_localctx).varName = match(ID);
				}
				break;
			case 3:
				{
				_localctx = new ConstantContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(142);
				((ConstantContext)_localctx).constName = match(ID);
				}
				break;
			case 4:
				{
				_localctx = new ParenthesisContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(143);
				match(LPAREN);
				setState(144);
				expression(0);
				setState(145);
				match(RPAREN);
				}
				break;
			case 5:
				{
				_localctx = new InverseGateContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(147);
				match(NOT);
				setState(148);
				((InverseGateContext)_localctx).expr = expression(2);
				}
				break;
			case 6:
				{
				_localctx = new FunctionCallExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(149);
				functionCall();
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(175);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,11,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(173);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,10,_ctx) ) {
					case 1:
						{
						_localctx = new DivisionContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(152);
						if (!(precpred(_ctx, 9))) throw new FailedPredicateException(this, "precpred(_ctx, 9)");
						setState(153);
						match(DIVOP);
						setState(154);
						expression(10);
						}
						break;
					case 2:
						{
						_localctx = new MultiplicationContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(155);
						if (!(precpred(_ctx, 8))) throw new FailedPredicateException(this, "precpred(_ctx, 8)");
						setState(156);
						match(MULTOP);
						setState(157);
						expression(9);
						}
						break;
					case 3:
						{
						_localctx = new SubtractionContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(158);
						if (!(precpred(_ctx, 7))) throw new FailedPredicateException(this, "precpred(_ctx, 7)");
						setState(159);
						match(MINOP);
						setState(160);
						expression(8);
						}
						break;
					case 4:
						{
						_localctx = new AdditionContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(161);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(162);
						match(PLUSOP);
						setState(163);
						expression(7);
						}
						break;
					case 5:
						{
						_localctx = new ComparisonContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(164);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(165);
						((ComparisonContext)_localctx).compareOp = _input.LT(1);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << LT) | (1L << LEQ) | (1L << GT) | (1L << GEQ) | (1L << EQ))) != 0)) ) {
							((ComparisonContext)_localctx).compareOp = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(166);
						expression(6);
						}
						break;
					case 6:
						{
						_localctx = new AndGateContext(new ExpressionContext(_parentctx, _parentState));
						((AndGateContext)_localctx).leftSide = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(167);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(168);
						match(AND);
						setState(169);
						((AndGateContext)_localctx).rightSide = expression(5);
						}
						break;
					case 7:
						{
						_localctx = new OrGateContext(new ExpressionContext(_parentctx, _parentState));
						((OrGateContext)_localctx).leftSide = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(170);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(171);
						match(OR);
						setState(172);
						((OrGateContext)_localctx).rightSide = expression(4);
						}
						break;
					}
					} 
				}
				setState(177);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,11,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 15:
			return expression_sempred((ExpressionContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean expression_sempred(ExpressionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 9);
		case 1:
			return precpred(_ctx, 8);
		case 2:
			return precpred(_ctx, 7);
		case 3:
			return precpred(_ctx, 6);
		case 4:
			return precpred(_ctx, 5);
		case 5:
			return precpred(_ctx, 4);
		case 6:
			return precpred(_ctx, 3);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\37\u00b5\4\2\t\2"+
		"\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\3\2\6\2"+
		"$\n\2\r\2\16\2%\3\3\3\3\5\3*\n\3\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3"+
		"\4\3\4\3\4\3\4\3\4\5\4:\n\4\3\5\3\5\3\5\3\5\3\6\3\6\3\6\3\7\3\7\3\7\3"+
		"\b\3\b\3\b\3\b\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\n\3\n"+
		"\3\n\3\n\3\n\3\13\7\13\\\n\13\f\13\16\13_\13\13\3\f\3\f\3\f\7\fd\n\f\f"+
		"\f\16\fg\13\f\3\f\5\fj\n\f\3\r\3\r\3\r\7\ro\n\r\f\r\16\rr\13\r\3\r\5\r"+
		"u\n\r\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\17\3\17\3\17\3\17\3\17"+
		"\3\17\3\20\3\20\7\20\u0087\n\20\f\20\16\20\u008a\13\20\3\20\3\20\3\21"+
		"\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\5\21\u0099\n\21\3\21"+
		"\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21"+
		"\3\21\3\21\3\21\3\21\3\21\3\21\7\21\u00b0\n\21\f\21\16\21\u00b3\13\21"+
		"\3\21\2\3 \22\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36 \2\3\3\2\27\33\2"+
		"\u00bd\2#\3\2\2\2\4)\3\2\2\2\69\3\2\2\2\b;\3\2\2\2\n?\3\2\2\2\fB\3\2\2"+
		"\2\16E\3\2\2\2\20I\3\2\2\2\22U\3\2\2\2\24]\3\2\2\2\26i\3\2\2\2\30t\3\2"+
		"\2\2\32v\3\2\2\2\34~\3\2\2\2\36\u0084\3\2\2\2 \u0098\3\2\2\2\"$\5\4\3"+
		"\2#\"\3\2\2\2$%\3\2\2\2%#\3\2\2\2%&\3\2\2\2&\3\3\2\2\2\'*\5\6\4\2(*\5"+
		"\20\t\2)\'\3\2\2\2)(\3\2\2\2*\5\3\2\2\2+,\5\b\5\2,-\7\3\2\2-:\3\2\2\2"+
		"./\5\n\6\2/\60\7\3\2\2\60:\3\2\2\2\61\62\5\f\7\2\62\63\7\3\2\2\63:\3\2"+
		"\2\2\64\65\5\16\b\2\65\66\7\3\2\2\66:\3\2\2\2\67:\5\32\16\28:\5\34\17"+
		"\29+\3\2\2\29.\3\2\2\29\61\3\2\2\29\64\3\2\2\29\67\3\2\2\298\3\2\2\2:"+
		"\7\3\2\2\2;<\7\4\2\2<=\5 \21\2=>\7\21\2\2>\t\3\2\2\2?@\7\22\2\2@A\7\r"+
		"\2\2A\13\3\2\2\2BC\7\5\2\2CD\7\r\2\2D\r\3\2\2\2EF\7\r\2\2FG\7\37\2\2G"+
		"H\5 \21\2H\17\3\2\2\2IJ\7\5\2\2JK\7\r\2\2KL\7\20\2\2LM\5\26\f\2MN\7\21"+
		"\2\2NO\7\6\2\2OP\5\24\13\2PQ\7\7\2\2QR\5 \21\2RS\7\3\2\2ST\7\b\2\2T\21"+
		"\3\2\2\2UV\7\r\2\2VW\7\20\2\2WX\5\30\r\2XY\7\21\2\2Y\23\3\2\2\2Z\\\5\6"+
		"\4\2[Z\3\2\2\2\\_\3\2\2\2][\3\2\2\2]^\3\2\2\2^\25\3\2\2\2_]\3\2\2\2`e"+
		"\5\f\7\2ab\7\t\2\2bd\5\f\7\2ca\3\2\2\2dg\3\2\2\2ec\3\2\2\2ef\3\2\2\2f"+
		"j\3\2\2\2ge\3\2\2\2hj\3\2\2\2i`\3\2\2\2ih\3\2\2\2j\27\3\2\2\2kp\5 \21"+
		"\2lm\7\t\2\2mo\5 \21\2nl\3\2\2\2or\3\2\2\2pn\3\2\2\2pq\3\2\2\2qu\3\2\2"+
		"\2rp\3\2\2\2su\3\2\2\2tk\3\2\2\2ts\3\2\2\2u\31\3\2\2\2vw\7\n\2\2wx\7\20"+
		"\2\2xy\5 \21\2yz\7\21\2\2z{\5\36\20\2{|\7\13\2\2|}\5\36\20\2}\33\3\2\2"+
		"\2~\177\7\f\2\2\177\u0080\7\20\2\2\u0080\u0081\5 \21\2\u0081\u0082\7\21"+
		"\2\2\u0082\u0083\5\36\20\2\u0083\35\3\2\2\2\u0084\u0088\7\6\2\2\u0085"+
		"\u0087\5\6\4\2\u0086\u0085\3\2\2\2\u0087\u008a\3\2\2\2\u0088\u0086\3\2"+
		"\2\2\u0088\u0089\3\2\2\2\u0089\u008b\3\2\2\2\u008a\u0088\3\2\2\2\u008b"+
		"\u008c\7\b\2\2\u008c\37\3\2\2\2\u008d\u008e\b\21\1\2\u008e\u0099\7\16"+
		"\2\2\u008f\u0099\7\r\2\2\u0090\u0099\7\r\2\2\u0091\u0092\7\20\2\2\u0092"+
		"\u0093\5 \21\2\u0093\u0094\7\21\2\2\u0094\u0099\3\2\2\2\u0095\u0096\7"+
		"\36\2\2\u0096\u0099\5 \21\4\u0097\u0099\5\22\n\2\u0098\u008d\3\2\2\2\u0098"+
		"\u008f\3\2\2\2\u0098\u0090\3\2\2\2\u0098\u0091\3\2\2\2\u0098\u0095\3\2"+
		"\2\2\u0098\u0097\3\2\2\2\u0099\u00b1\3\2\2\2\u009a\u009b\f\13\2\2\u009b"+
		"\u009c\7\26\2\2\u009c\u00b0\5 \21\f\u009d\u009e\f\n\2\2\u009e\u009f\7"+
		"\25\2\2\u009f\u00b0\5 \21\13\u00a0\u00a1\f\t\2\2\u00a1\u00a2\7\24\2\2"+
		"\u00a2\u00b0\5 \21\n\u00a3\u00a4\f\b\2\2\u00a4\u00a5\7\23\2\2\u00a5\u00b0"+
		"\5 \21\t\u00a6\u00a7\f\7\2\2\u00a7\u00a8\t\2\2\2\u00a8\u00b0\5 \21\b\u00a9"+
		"\u00aa\f\6\2\2\u00aa\u00ab\7\34\2\2\u00ab\u00b0\5 \21\7\u00ac\u00ad\f"+
		"\5\2\2\u00ad\u00ae\7\35\2\2\u00ae\u00b0\5 \21\6\u00af\u009a\3\2\2\2\u00af"+
		"\u009d\3\2\2\2\u00af\u00a0\3\2\2\2\u00af\u00a3\3\2\2\2\u00af\u00a6\3\2"+
		"\2\2\u00af\u00a9\3\2\2\2\u00af\u00ac\3\2\2\2\u00b0\u00b3\3\2\2\2\u00b1"+
		"\u00af\3\2\2\2\u00b1\u00b2\3\2\2\2\u00b2!\3\2\2\2\u00b3\u00b1\3\2\2\2"+
		"\16%)9]eipt\u0088\u0098\u00af\u00b1";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}