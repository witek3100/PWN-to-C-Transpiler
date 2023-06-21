// Generated from E:/Next/School/Studia/Kompilatory/TK-projekt/src/antlr\PWN.g4 by ANTLR 4.12.0
package antlr;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue"})
public class PWNParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.12.0", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		ADD=1, DIV=2, MUL=3, MOD=4, SUB=5, SEMICOLON=6, COLON=7, LPAR=8, RPAR=9, 
		LBRACE=10, RBRACE=11, LBRACKET=12, RBRACKET=13, EQ=14, NEQ=15, ASSIGN=16, 
		BREAK=17, CONTINUE=18, ARROW=19, COMMA=20, INCREMENT=21, DECREMENT=22, 
		ADDASSIGN=23, SUBASSIGN=24, KW_INT=25, KW_STRING=26, KW_FLOAT=27, KW_DOUBLE=28, 
		KW_BOOL=29, GT=30, LT=31, GE=32, LE=33, NOT=34, OR=35, AND=36, FALSE=37, 
		TRUE=38, IN=39, IF=40, ELIF=41, ELSE=42, WHILE=43, FOR=44, FN=45, RETURN=46, 
		ID=47, INT=48, FLOAT=49, RANGE=50, STRING=51, UNTERMINATED_STRING=52, 
		WS=53;
	public static final int
		RULE_program = 0, RULE_statement = 1, RULE_loopStatement = 2, RULE_jumpStatement = 3, 
		RULE_jumpStatementType = 4, RULE_declaration = 5, RULE_arrayDeclaration = 6, 
		RULE_assignment = 7, RULE_assignmentType = 8, RULE_increment = 9, RULE_incrementType = 10, 
		RULE_index = 11, RULE_returnStatement = 12, RULE_ifStatement = 13, RULE_elifStatement = 14, 
		RULE_elseStatement = 15, RULE_whileStatement = 16, RULE_iterable = 17, 
		RULE_forStatement = 18, RULE_functionDefinition = 19, RULE_argumentsDefinition = 20, 
		RULE_arguments = 21, RULE_functionCall = 22, RULE_type = 23, RULE_normalType = 24, 
		RULE_arrayType = 25, RULE_expression = 26, RULE_variableValue = 27, RULE_value = 28, 
		RULE_arrayLiteral = 29, RULE_literalValue = 30;
	private static String[] makeRuleNames() {
		return new String[] {
			"program", "statement", "loopStatement", "jumpStatement", "jumpStatementType", 
			"declaration", "arrayDeclaration", "assignment", "assignmentType", "increment", 
			"incrementType", "index", "returnStatement", "ifStatement", "elifStatement", 
			"elseStatement", "whileStatement", "iterable", "forStatement", "functionDefinition", 
			"argumentsDefinition", "arguments", "functionCall", "type", "normalType", 
			"arrayType", "expression", "variableValue", "value", "arrayLiteral", 
			"literalValue"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'+'", "'/'", "'*'", "'%'", "'-'", "';'", "':'", "'('", "')'", 
			"'{'", "'}'", "'['", "']'", "'=='", "'=/='", "'='", "'break'", "'continue'", 
			"'->'", "','", "'++'", "'--'", "'+='", "'-='", "'int'", "'string'", "'float'", 
			"'double'", "'bool'", "'>'", "'<'", "'>='", "'<='", "'!'", "'or'", "'and'", 
			"'false'", "'true'", "'in'", "'if'", "'elif'", "'else'", "'while'", "'for'", 
			"'func'", "'return'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "ADD", "DIV", "MUL", "MOD", "SUB", "SEMICOLON", "COLON", "LPAR", 
			"RPAR", "LBRACE", "RBRACE", "LBRACKET", "RBRACKET", "EQ", "NEQ", "ASSIGN", 
			"BREAK", "CONTINUE", "ARROW", "COMMA", "INCREMENT", "DECREMENT", "ADDASSIGN", 
			"SUBASSIGN", "KW_INT", "KW_STRING", "KW_FLOAT", "KW_DOUBLE", "KW_BOOL", 
			"GT", "LT", "GE", "LE", "NOT", "OR", "AND", "FALSE", "TRUE", "IN", "IF", 
			"ELIF", "ELSE", "WHILE", "FOR", "FN", "RETURN", "ID", "INT", "FLOAT", 
			"RANGE", "STRING", "UNTERMINATED_STRING", "WS"
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
	public String getGrammarFileName() { return "PWN.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public PWNParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ProgramContext extends ParserRuleContext {
		public TerminalNode EOF() { return getToken(PWNParser.EOF, 0); }
		public List<FunctionDefinitionContext> functionDefinition() {
			return getRuleContexts(FunctionDefinitionContext.class);
		}
		public FunctionDefinitionContext functionDefinition(int i) {
			return getRuleContext(FunctionDefinitionContext.class,i);
		}
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
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PWNListener ) ((PWNListener)listener).enterProgram(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PWNListener ) ((PWNListener)listener).exitProgram(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PWNVisitor ) return ((PWNVisitor<? extends T>)visitor).visitProgram(this);
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
			setState(65);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==FN) {
				{
				{
				setState(62);
				functionDefinition();
				}
				}
				setState(67);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(69); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(68);
				statement();
				}
				}
				setState(71); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & 238594023227392L) != 0) );
			setState(73);
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
		public AssignmentContext assignment() {
			return getRuleContext(AssignmentContext.class,0);
		}
		public IncrementContext increment() {
			return getRuleContext(IncrementContext.class,0);
		}
		public DeclarationContext declaration() {
			return getRuleContext(DeclarationContext.class,0);
		}
		public ArrayDeclarationContext arrayDeclaration() {
			return getRuleContext(ArrayDeclarationContext.class,0);
		}
		public ReturnStatementContext returnStatement() {
			return getRuleContext(ReturnStatementContext.class,0);
		}
		public IfStatementContext ifStatement() {
			return getRuleContext(IfStatementContext.class,0);
		}
		public WhileStatementContext whileStatement() {
			return getRuleContext(WhileStatementContext.class,0);
		}
		public ForStatementContext forStatement() {
			return getRuleContext(ForStatementContext.class,0);
		}
		public StatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PWNListener ) ((PWNListener)listener).enterStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PWNListener ) ((PWNListener)listener).exitStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PWNVisitor ) return ((PWNVisitor<? extends T>)visitor).visitStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StatementContext statement() throws RecognitionException {
		StatementContext _localctx = new StatementContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_statement);
		try {
			setState(83);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,2,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(75);
				assignment();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(76);
				increment();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(77);
				declaration();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(78);
				arrayDeclaration();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(79);
				returnStatement();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(80);
				ifStatement();
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(81);
				whileStatement();
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(82);
				forStatement();
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
	public static class LoopStatementContext extends ParserRuleContext {
		public StatementContext statement() {
			return getRuleContext(StatementContext.class,0);
		}
		public JumpStatementContext jumpStatement() {
			return getRuleContext(JumpStatementContext.class,0);
		}
		public LoopStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_loopStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PWNListener ) ((PWNListener)listener).enterLoopStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PWNListener ) ((PWNListener)listener).exitLoopStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PWNVisitor ) return ((PWNVisitor<? extends T>)visitor).visitLoopStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LoopStatementContext loopStatement() throws RecognitionException {
		LoopStatementContext _localctx = new LoopStatementContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_loopStatement);
		try {
			setState(87);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case IF:
			case WHILE:
			case FOR:
			case RETURN:
			case ID:
				enterOuterAlt(_localctx, 1);
				{
				setState(85);
				statement();
				}
				break;
			case BREAK:
			case CONTINUE:
				enterOuterAlt(_localctx, 2);
				{
				setState(86);
				jumpStatement();
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
	public static class JumpStatementContext extends ParserRuleContext {
		public JumpStatementTypeContext jumpStatementType() {
			return getRuleContext(JumpStatementTypeContext.class,0);
		}
		public TerminalNode SEMICOLON() { return getToken(PWNParser.SEMICOLON, 0); }
		public JumpStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_jumpStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PWNListener ) ((PWNListener)listener).enterJumpStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PWNListener ) ((PWNListener)listener).exitJumpStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PWNVisitor ) return ((PWNVisitor<? extends T>)visitor).visitJumpStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final JumpStatementContext jumpStatement() throws RecognitionException {
		JumpStatementContext _localctx = new JumpStatementContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_jumpStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(89);
			jumpStatementType();
			setState(90);
			match(SEMICOLON);
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
	public static class JumpStatementTypeContext extends ParserRuleContext {
		public TerminalNode BREAK() { return getToken(PWNParser.BREAK, 0); }
		public TerminalNode CONTINUE() { return getToken(PWNParser.CONTINUE, 0); }
		public JumpStatementTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_jumpStatementType; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PWNListener ) ((PWNListener)listener).enterJumpStatementType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PWNListener ) ((PWNListener)listener).exitJumpStatementType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PWNVisitor ) return ((PWNVisitor<? extends T>)visitor).visitJumpStatementType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final JumpStatementTypeContext jumpStatementType() throws RecognitionException {
		JumpStatementTypeContext _localctx = new JumpStatementTypeContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_jumpStatementType);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(92);
			_la = _input.LA(1);
			if ( !(_la==BREAK || _la==CONTINUE) ) {
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
	public static class DeclarationContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(PWNParser.ID, 0); }
		public TerminalNode COLON() { return getToken(PWNParser.COLON, 0); }
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public TerminalNode ASSIGN() { return getToken(PWNParser.ASSIGN, 0); }
		public TerminalNode SEMICOLON() { return getToken(PWNParser.SEMICOLON, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public ArrayLiteralContext arrayLiteral() {
			return getRuleContext(ArrayLiteralContext.class,0);
		}
		public DeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_declaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PWNListener ) ((PWNListener)listener).enterDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PWNListener ) ((PWNListener)listener).exitDeclaration(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PWNVisitor ) return ((PWNVisitor<? extends T>)visitor).visitDeclaration(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DeclarationContext declaration() throws RecognitionException {
		DeclarationContext _localctx = new DeclarationContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_declaration);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(94);
			match(ID);
			setState(95);
			match(COLON);
			setState(96);
			type();
			setState(97);
			match(ASSIGN);
			setState(100);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case SUB:
			case LPAR:
			case NOT:
			case FALSE:
			case TRUE:
			case ID:
			case INT:
			case FLOAT:
			case STRING:
				{
				setState(98);
				expression(0);
				}
				break;
			case LBRACKET:
				{
				setState(99);
				arrayLiteral();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(102);
			match(SEMICOLON);
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
	public static class ArrayDeclarationContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(PWNParser.ID, 0); }
		public TerminalNode COLON() { return getToken(PWNParser.COLON, 0); }
		public NormalTypeContext normalType() {
			return getRuleContext(NormalTypeContext.class,0);
		}
		public TerminalNode LBRACKET() { return getToken(PWNParser.LBRACKET, 0); }
		public TerminalNode INT() { return getToken(PWNParser.INT, 0); }
		public TerminalNode RBRACKET() { return getToken(PWNParser.RBRACKET, 0); }
		public TerminalNode SEMICOLON() { return getToken(PWNParser.SEMICOLON, 0); }
		public ArrayDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_arrayDeclaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PWNListener ) ((PWNListener)listener).enterArrayDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PWNListener ) ((PWNListener)listener).exitArrayDeclaration(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PWNVisitor ) return ((PWNVisitor<? extends T>)visitor).visitArrayDeclaration(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ArrayDeclarationContext arrayDeclaration() throws RecognitionException {
		ArrayDeclarationContext _localctx = new ArrayDeclarationContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_arrayDeclaration);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(104);
			match(ID);
			setState(105);
			match(COLON);
			setState(106);
			normalType();
			setState(107);
			match(LBRACKET);
			setState(108);
			match(INT);
			setState(109);
			match(RBRACKET);
			setState(110);
			match(SEMICOLON);
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
	public static class AssignmentContext extends ParserRuleContext {
		public VariableValueContext variableValue() {
			return getRuleContext(VariableValueContext.class,0);
		}
		public AssignmentTypeContext assignmentType() {
			return getRuleContext(AssignmentTypeContext.class,0);
		}
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode SEMICOLON() { return getToken(PWNParser.SEMICOLON, 0); }
		public AssignmentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assignment; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PWNListener ) ((PWNListener)listener).enterAssignment(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PWNListener ) ((PWNListener)listener).exitAssignment(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PWNVisitor ) return ((PWNVisitor<? extends T>)visitor).visitAssignment(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AssignmentContext assignment() throws RecognitionException {
		AssignmentContext _localctx = new AssignmentContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_assignment);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(112);
			variableValue();
			setState(113);
			assignmentType();
			setState(114);
			expression(0);
			setState(115);
			match(SEMICOLON);
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
	public static class AssignmentTypeContext extends ParserRuleContext {
		public TerminalNode ASSIGN() { return getToken(PWNParser.ASSIGN, 0); }
		public TerminalNode ADDASSIGN() { return getToken(PWNParser.ADDASSIGN, 0); }
		public TerminalNode SUBASSIGN() { return getToken(PWNParser.SUBASSIGN, 0); }
		public AssignmentTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assignmentType; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PWNListener ) ((PWNListener)listener).enterAssignmentType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PWNListener ) ((PWNListener)listener).exitAssignmentType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PWNVisitor ) return ((PWNVisitor<? extends T>)visitor).visitAssignmentType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AssignmentTypeContext assignmentType() throws RecognitionException {
		AssignmentTypeContext _localctx = new AssignmentTypeContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_assignmentType);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(117);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 25231360L) != 0)) ) {
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
	public static class IncrementContext extends ParserRuleContext {
		public VariableValueContext variableValue() {
			return getRuleContext(VariableValueContext.class,0);
		}
		public IncrementTypeContext incrementType() {
			return getRuleContext(IncrementTypeContext.class,0);
		}
		public TerminalNode SEMICOLON() { return getToken(PWNParser.SEMICOLON, 0); }
		public IncrementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_increment; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PWNListener ) ((PWNListener)listener).enterIncrement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PWNListener ) ((PWNListener)listener).exitIncrement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PWNVisitor ) return ((PWNVisitor<? extends T>)visitor).visitIncrement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IncrementContext increment() throws RecognitionException {
		IncrementContext _localctx = new IncrementContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_increment);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(119);
			variableValue();
			setState(120);
			incrementType();
			setState(121);
			match(SEMICOLON);
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
	public static class IncrementTypeContext extends ParserRuleContext {
		public TerminalNode INCREMENT() { return getToken(PWNParser.INCREMENT, 0); }
		public TerminalNode DECREMENT() { return getToken(PWNParser.DECREMENT, 0); }
		public IncrementTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_incrementType; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PWNListener ) ((PWNListener)listener).enterIncrementType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PWNListener ) ((PWNListener)listener).exitIncrementType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PWNVisitor ) return ((PWNVisitor<? extends T>)visitor).visitIncrementType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IncrementTypeContext incrementType() throws RecognitionException {
		IncrementTypeContext _localctx = new IncrementTypeContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_incrementType);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(123);
			_la = _input.LA(1);
			if ( !(_la==INCREMENT || _la==DECREMENT) ) {
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
	public static class IndexContext extends ParserRuleContext {
		public TerminalNode LBRACKET() { return getToken(PWNParser.LBRACKET, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode RBRACKET() { return getToken(PWNParser.RBRACKET, 0); }
		public IndexContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_index; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PWNListener ) ((PWNListener)listener).enterIndex(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PWNListener ) ((PWNListener)listener).exitIndex(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PWNVisitor ) return ((PWNVisitor<? extends T>)visitor).visitIndex(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IndexContext index() throws RecognitionException {
		IndexContext _localctx = new IndexContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_index);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(125);
			match(LBRACKET);
			setState(126);
			expression(0);
			setState(127);
			match(RBRACKET);
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
		public TerminalNode RETURN() { return getToken(PWNParser.RETURN, 0); }
		public TerminalNode SEMICOLON() { return getToken(PWNParser.SEMICOLON, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public ReturnStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_returnStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PWNListener ) ((PWNListener)listener).enterReturnStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PWNListener ) ((PWNListener)listener).exitReturnStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PWNVisitor ) return ((PWNVisitor<? extends T>)visitor).visitReturnStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ReturnStatementContext returnStatement() throws RecognitionException {
		ReturnStatementContext _localctx = new ReturnStatementContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_returnStatement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(129);
			match(RETURN);
			setState(131);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 3237391728902432L) != 0)) {
				{
				setState(130);
				expression(0);
				}
			}

			setState(133);
			match(SEMICOLON);
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
		public TerminalNode IF() { return getToken(PWNParser.IF, 0); }
		public TerminalNode LPAR() { return getToken(PWNParser.LPAR, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode RPAR() { return getToken(PWNParser.RPAR, 0); }
		public TerminalNode LBRACE() { return getToken(PWNParser.LBRACE, 0); }
		public TerminalNode RBRACE() { return getToken(PWNParser.RBRACE, 0); }
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public List<ElifStatementContext> elifStatement() {
			return getRuleContexts(ElifStatementContext.class);
		}
		public ElifStatementContext elifStatement(int i) {
			return getRuleContext(ElifStatementContext.class,i);
		}
		public ElseStatementContext elseStatement() {
			return getRuleContext(ElseStatementContext.class,0);
		}
		public IfStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ifStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PWNListener ) ((PWNListener)listener).enterIfStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PWNListener ) ((PWNListener)listener).exitIfStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PWNVisitor ) return ((PWNVisitor<? extends T>)visitor).visitIfStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IfStatementContext ifStatement() throws RecognitionException {
		IfStatementContext _localctx = new IfStatementContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_ifStatement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(135);
			match(IF);
			setState(136);
			match(LPAR);
			setState(137);
			expression(0);
			setState(138);
			match(RPAR);
			setState(139);
			match(LBRACE);
			setState(143);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 238594023227392L) != 0)) {
				{
				{
				setState(140);
				statement();
				}
				}
				setState(145);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(146);
			match(RBRACE);
			setState(150);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==ELIF) {
				{
				{
				setState(147);
				elifStatement();
				}
				}
				setState(152);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(154);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ELSE) {
				{
				setState(153);
				elseStatement();
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
	public static class ElifStatementContext extends ParserRuleContext {
		public TerminalNode ELIF() { return getToken(PWNParser.ELIF, 0); }
		public TerminalNode LPAR() { return getToken(PWNParser.LPAR, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode RPAR() { return getToken(PWNParser.RPAR, 0); }
		public TerminalNode LBRACE() { return getToken(PWNParser.LBRACE, 0); }
		public TerminalNode RBRACE() { return getToken(PWNParser.RBRACE, 0); }
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public ElifStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_elifStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PWNListener ) ((PWNListener)listener).enterElifStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PWNListener ) ((PWNListener)listener).exitElifStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PWNVisitor ) return ((PWNVisitor<? extends T>)visitor).visitElifStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ElifStatementContext elifStatement() throws RecognitionException {
		ElifStatementContext _localctx = new ElifStatementContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_elifStatement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(156);
			match(ELIF);
			setState(157);
			match(LPAR);
			setState(158);
			expression(0);
			setState(159);
			match(RPAR);
			setState(160);
			match(LBRACE);
			setState(164);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 238594023227392L) != 0)) {
				{
				{
				setState(161);
				statement();
				}
				}
				setState(166);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(167);
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
	public static class ElseStatementContext extends ParserRuleContext {
		public TerminalNode ELSE() { return getToken(PWNParser.ELSE, 0); }
		public TerminalNode LBRACE() { return getToken(PWNParser.LBRACE, 0); }
		public TerminalNode RBRACE() { return getToken(PWNParser.RBRACE, 0); }
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public ElseStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_elseStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PWNListener ) ((PWNListener)listener).enterElseStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PWNListener ) ((PWNListener)listener).exitElseStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PWNVisitor ) return ((PWNVisitor<? extends T>)visitor).visitElseStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ElseStatementContext elseStatement() throws RecognitionException {
		ElseStatementContext _localctx = new ElseStatementContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_elseStatement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(169);
			match(ELSE);
			setState(170);
			match(LBRACE);
			setState(174);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 238594023227392L) != 0)) {
				{
				{
				setState(171);
				statement();
				}
				}
				setState(176);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(177);
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
	public static class WhileStatementContext extends ParserRuleContext {
		public TerminalNode WHILE() { return getToken(PWNParser.WHILE, 0); }
		public TerminalNode LPAR() { return getToken(PWNParser.LPAR, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode RPAR() { return getToken(PWNParser.RPAR, 0); }
		public TerminalNode LBRACE() { return getToken(PWNParser.LBRACE, 0); }
		public TerminalNode RBRACE() { return getToken(PWNParser.RBRACE, 0); }
		public List<LoopStatementContext> loopStatement() {
			return getRuleContexts(LoopStatementContext.class);
		}
		public LoopStatementContext loopStatement(int i) {
			return getRuleContext(LoopStatementContext.class,i);
		}
		public WhileStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_whileStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PWNListener ) ((PWNListener)listener).enterWhileStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PWNListener ) ((PWNListener)listener).exitWhileStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PWNVisitor ) return ((PWNVisitor<? extends T>)visitor).visitWhileStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final WhileStatementContext whileStatement() throws RecognitionException {
		WhileStatementContext _localctx = new WhileStatementContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_whileStatement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(179);
			match(WHILE);
			setState(180);
			match(LPAR);
			setState(181);
			expression(0);
			setState(182);
			match(RPAR);
			setState(183);
			match(LBRACE);
			setState(187);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 238594023620608L) != 0)) {
				{
				{
				setState(184);
				loopStatement();
				}
				}
				setState(189);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(190);
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
	public static class IterableContext extends ParserRuleContext {
		public TerminalNode RANGE() { return getToken(PWNParser.RANGE, 0); }
		public TerminalNode ID() { return getToken(PWNParser.ID, 0); }
		public IterableContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_iterable; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PWNListener ) ((PWNListener)listener).enterIterable(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PWNListener ) ((PWNListener)listener).exitIterable(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PWNVisitor ) return ((PWNVisitor<? extends T>)visitor).visitIterable(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IterableContext iterable() throws RecognitionException {
		IterableContext _localctx = new IterableContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_iterable);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(192);
			_la = _input.LA(1);
			if ( !(_la==ID || _la==RANGE) ) {
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
	public static class ForStatementContext extends ParserRuleContext {
		public TerminalNode FOR() { return getToken(PWNParser.FOR, 0); }
		public TerminalNode LPAR() { return getToken(PWNParser.LPAR, 0); }
		public TerminalNode ID() { return getToken(PWNParser.ID, 0); }
		public TerminalNode COLON() { return getToken(PWNParser.COLON, 0); }
		public NormalTypeContext normalType() {
			return getRuleContext(NormalTypeContext.class,0);
		}
		public TerminalNode IN() { return getToken(PWNParser.IN, 0); }
		public IterableContext iterable() {
			return getRuleContext(IterableContext.class,0);
		}
		public TerminalNode RPAR() { return getToken(PWNParser.RPAR, 0); }
		public TerminalNode LBRACE() { return getToken(PWNParser.LBRACE, 0); }
		public TerminalNode RBRACE() { return getToken(PWNParser.RBRACE, 0); }
		public List<LoopStatementContext> loopStatement() {
			return getRuleContexts(LoopStatementContext.class);
		}
		public LoopStatementContext loopStatement(int i) {
			return getRuleContext(LoopStatementContext.class,i);
		}
		public ForStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_forStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PWNListener ) ((PWNListener)listener).enterForStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PWNListener ) ((PWNListener)listener).exitForStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PWNVisitor ) return ((PWNVisitor<? extends T>)visitor).visitForStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ForStatementContext forStatement() throws RecognitionException {
		ForStatementContext _localctx = new ForStatementContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_forStatement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(194);
			match(FOR);
			setState(195);
			match(LPAR);
			setState(196);
			match(ID);
			setState(197);
			match(COLON);
			setState(198);
			normalType();
			setState(199);
			match(IN);
			setState(200);
			iterable();
			setState(201);
			match(RPAR);
			setState(202);
			match(LBRACE);
			setState(206);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 238594023620608L) != 0)) {
				{
				{
				setState(203);
				loopStatement();
				}
				}
				setState(208);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(209);
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
	public static class FunctionDefinitionContext extends ParserRuleContext {
		public TerminalNode FN() { return getToken(PWNParser.FN, 0); }
		public TerminalNode ID() { return getToken(PWNParser.ID, 0); }
		public TerminalNode LPAR() { return getToken(PWNParser.LPAR, 0); }
		public ArgumentsDefinitionContext argumentsDefinition() {
			return getRuleContext(ArgumentsDefinitionContext.class,0);
		}
		public TerminalNode RPAR() { return getToken(PWNParser.RPAR, 0); }
		public TerminalNode LBRACE() { return getToken(PWNParser.LBRACE, 0); }
		public TerminalNode RBRACE() { return getToken(PWNParser.RBRACE, 0); }
		public TerminalNode ARROW() { return getToken(PWNParser.ARROW, 0); }
		public NormalTypeContext normalType() {
			return getRuleContext(NormalTypeContext.class,0);
		}
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public FunctionDefinitionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_functionDefinition; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PWNListener ) ((PWNListener)listener).enterFunctionDefinition(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PWNListener ) ((PWNListener)listener).exitFunctionDefinition(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PWNVisitor ) return ((PWNVisitor<? extends T>)visitor).visitFunctionDefinition(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FunctionDefinitionContext functionDefinition() throws RecognitionException {
		FunctionDefinitionContext _localctx = new FunctionDefinitionContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_functionDefinition);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(211);
			match(FN);
			setState(212);
			match(ID);
			setState(213);
			match(LPAR);
			setState(214);
			argumentsDefinition();
			setState(215);
			match(RPAR);
			setState(218);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ARROW) {
				{
				setState(216);
				match(ARROW);
				setState(217);
				normalType();
				}
			}

			setState(220);
			match(LBRACE);
			setState(224);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 238594023227392L) != 0)) {
				{
				{
				setState(221);
				statement();
				}
				}
				setState(226);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(227);
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
	public static class ArgumentsDefinitionContext extends ParserRuleContext {
		public List<TerminalNode> ID() { return getTokens(PWNParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(PWNParser.ID, i);
		}
		public List<TerminalNode> COLON() { return getTokens(PWNParser.COLON); }
		public TerminalNode COLON(int i) {
			return getToken(PWNParser.COLON, i);
		}
		public List<TypeContext> type() {
			return getRuleContexts(TypeContext.class);
		}
		public TypeContext type(int i) {
			return getRuleContext(TypeContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(PWNParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(PWNParser.COMMA, i);
		}
		public ArgumentsDefinitionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_argumentsDefinition; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PWNListener ) ((PWNListener)listener).enterArgumentsDefinition(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PWNListener ) ((PWNListener)listener).exitArgumentsDefinition(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PWNVisitor ) return ((PWNVisitor<? extends T>)visitor).visitArgumentsDefinition(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ArgumentsDefinitionContext argumentsDefinition() throws RecognitionException {
		ArgumentsDefinitionContext _localctx = new ArgumentsDefinitionContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_argumentsDefinition);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(242);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ID) {
				{
				{
				setState(229);
				match(ID);
				setState(230);
				match(COLON);
				setState(231);
				type();
				}
				setState(239);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(233);
					match(COMMA);
					setState(234);
					match(ID);
					setState(235);
					match(COLON);
					setState(236);
					type();
					}
					}
					setState(241);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
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
	public static class ArgumentsContext extends ParserRuleContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(PWNParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(PWNParser.COMMA, i);
		}
		public ArgumentsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_arguments; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PWNListener ) ((PWNListener)listener).enterArguments(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PWNListener ) ((PWNListener)listener).exitArguments(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PWNVisitor ) return ((PWNVisitor<? extends T>)visitor).visitArguments(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ArgumentsContext arguments() throws RecognitionException {
		ArgumentsContext _localctx = new ArgumentsContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_arguments);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(252);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 3237391728902432L) != 0)) {
				{
				setState(244);
				expression(0);
				setState(249);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(245);
					match(COMMA);
					setState(246);
					expression(0);
					}
					}
					setState(251);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
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
	public static class FunctionCallContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(PWNParser.ID, 0); }
		public TerminalNode LPAR() { return getToken(PWNParser.LPAR, 0); }
		public ArgumentsContext arguments() {
			return getRuleContext(ArgumentsContext.class,0);
		}
		public TerminalNode RPAR() { return getToken(PWNParser.RPAR, 0); }
		public FunctionCallContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_functionCall; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PWNListener ) ((PWNListener)listener).enterFunctionCall(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PWNListener ) ((PWNListener)listener).exitFunctionCall(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PWNVisitor ) return ((PWNVisitor<? extends T>)visitor).visitFunctionCall(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FunctionCallContext functionCall() throws RecognitionException {
		FunctionCallContext _localctx = new FunctionCallContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_functionCall);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(254);
			match(ID);
			setState(255);
			match(LPAR);
			setState(256);
			arguments();
			setState(257);
			match(RPAR);
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
	public static class TypeContext extends ParserRuleContext {
		public NormalTypeContext normalType() {
			return getRuleContext(NormalTypeContext.class,0);
		}
		public ArrayTypeContext arrayType() {
			return getRuleContext(ArrayTypeContext.class,0);
		}
		public TypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_type; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PWNListener ) ((PWNListener)listener).enterType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PWNListener ) ((PWNListener)listener).exitType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PWNVisitor ) return ((PWNVisitor<? extends T>)visitor).visitType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TypeContext type() throws RecognitionException {
		TypeContext _localctx = new TypeContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_type);
		try {
			setState(261);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,19,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(259);
				normalType();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(260);
				arrayType();
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
	public static class NormalTypeContext extends ParserRuleContext {
		public TerminalNode KW_INT() { return getToken(PWNParser.KW_INT, 0); }
		public TerminalNode KW_FLOAT() { return getToken(PWNParser.KW_FLOAT, 0); }
		public TerminalNode KW_DOUBLE() { return getToken(PWNParser.KW_DOUBLE, 0); }
		public TerminalNode KW_STRING() { return getToken(PWNParser.KW_STRING, 0); }
		public TerminalNode KW_BOOL() { return getToken(PWNParser.KW_BOOL, 0); }
		public NormalTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_normalType; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PWNListener ) ((PWNListener)listener).enterNormalType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PWNListener ) ((PWNListener)listener).exitNormalType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PWNVisitor ) return ((PWNVisitor<? extends T>)visitor).visitNormalType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final NormalTypeContext normalType() throws RecognitionException {
		NormalTypeContext _localctx = new NormalTypeContext(_ctx, getState());
		enterRule(_localctx, 48, RULE_normalType);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(263);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 1040187392L) != 0)) ) {
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
	public static class ArrayTypeContext extends ParserRuleContext {
		public NormalTypeContext normalType() {
			return getRuleContext(NormalTypeContext.class,0);
		}
		public TerminalNode LBRACKET() { return getToken(PWNParser.LBRACKET, 0); }
		public TerminalNode RBRACKET() { return getToken(PWNParser.RBRACKET, 0); }
		public ArrayTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_arrayType; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PWNListener ) ((PWNListener)listener).enterArrayType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PWNListener ) ((PWNListener)listener).exitArrayType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PWNVisitor ) return ((PWNVisitor<? extends T>)visitor).visitArrayType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ArrayTypeContext arrayType() throws RecognitionException {
		ArrayTypeContext _localctx = new ArrayTypeContext(_ctx, getState());
		enterRule(_localctx, 50, RULE_arrayType);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(265);
			normalType();
			setState(266);
			match(LBRACKET);
			setState(267);
			match(RBRACKET);
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
		public ExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expression; }
	 
		public ExpressionContext() { }
		public void copyFrom(ExpressionContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class OrExpressionContext extends ExpressionContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode OR() { return getToken(PWNParser.OR, 0); }
		public OrExpressionContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PWNListener ) ((PWNListener)listener).enterOrExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PWNListener ) ((PWNListener)listener).exitOrExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PWNVisitor ) return ((PWNVisitor<? extends T>)visitor).visitOrExpression(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ValueExpressionContext extends ExpressionContext {
		public ValueContext value() {
			return getRuleContext(ValueContext.class,0);
		}
		public ValueExpressionContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PWNListener ) ((PWNListener)listener).enterValueExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PWNListener ) ((PWNListener)listener).exitValueExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PWNVisitor ) return ((PWNVisitor<? extends T>)visitor).visitValueExpression(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class AndExpressionContext extends ExpressionContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode AND() { return getToken(PWNParser.AND, 0); }
		public AndExpressionContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PWNListener ) ((PWNListener)listener).enterAndExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PWNListener ) ((PWNListener)listener).exitAndExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PWNVisitor ) return ((PWNVisitor<? extends T>)visitor).visitAndExpression(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ParenthesizedExpressionContext extends ExpressionContext {
		public TerminalNode LPAR() { return getToken(PWNParser.LPAR, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode RPAR() { return getToken(PWNParser.RPAR, 0); }
		public ParenthesizedExpressionContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PWNListener ) ((PWNListener)listener).enterParenthesizedExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PWNListener ) ((PWNListener)listener).exitParenthesizedExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PWNVisitor ) return ((PWNVisitor<? extends T>)visitor).visitParenthesizedExpression(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class AdditiveExpressionContext extends ExpressionContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode ADD() { return getToken(PWNParser.ADD, 0); }
		public TerminalNode SUB() { return getToken(PWNParser.SUB, 0); }
		public AdditiveExpressionContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PWNListener ) ((PWNListener)listener).enterAdditiveExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PWNListener ) ((PWNListener)listener).exitAdditiveExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PWNVisitor ) return ((PWNVisitor<? extends T>)visitor).visitAdditiveExpression(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class EqualityExpressionContext extends ExpressionContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode EQ() { return getToken(PWNParser.EQ, 0); }
		public TerminalNode NEQ() { return getToken(PWNParser.NEQ, 0); }
		public EqualityExpressionContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PWNListener ) ((PWNListener)listener).enterEqualityExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PWNListener ) ((PWNListener)listener).exitEqualityExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PWNVisitor ) return ((PWNVisitor<? extends T>)visitor).visitEqualityExpression(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ComparisonExpressionContext extends ExpressionContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode LT() { return getToken(PWNParser.LT, 0); }
		public TerminalNode GT() { return getToken(PWNParser.GT, 0); }
		public TerminalNode LE() { return getToken(PWNParser.LE, 0); }
		public TerminalNode GE() { return getToken(PWNParser.GE, 0); }
		public ComparisonExpressionContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PWNListener ) ((PWNListener)listener).enterComparisonExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PWNListener ) ((PWNListener)listener).exitComparisonExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PWNVisitor ) return ((PWNVisitor<? extends T>)visitor).visitComparisonExpression(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class MultiplicativeExpressionContext extends ExpressionContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode MUL() { return getToken(PWNParser.MUL, 0); }
		public TerminalNode DIV() { return getToken(PWNParser.DIV, 0); }
		public TerminalNode MOD() { return getToken(PWNParser.MOD, 0); }
		public MultiplicativeExpressionContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PWNListener ) ((PWNListener)listener).enterMultiplicativeExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PWNListener ) ((PWNListener)listener).exitMultiplicativeExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PWNVisitor ) return ((PWNVisitor<? extends T>)visitor).visitMultiplicativeExpression(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class UnaryExpressionContext extends ExpressionContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode NOT() { return getToken(PWNParser.NOT, 0); }
		public TerminalNode SUB() { return getToken(PWNParser.SUB, 0); }
		public UnaryExpressionContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PWNListener ) ((PWNListener)listener).enterUnaryExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PWNListener ) ((PWNListener)listener).exitUnaryExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PWNVisitor ) return ((PWNVisitor<? extends T>)visitor).visitUnaryExpression(this);
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
		int _startState = 52;
		enterRecursionRule(_localctx, 52, RULE_expression, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(277);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,20,_ctx) ) {
			case 1:
				{
				_localctx = new ValueExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(270);
				value();
				}
				break;
			case 2:
				{
				_localctx = new ParenthesizedExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(271);
				match(LPAR);
				setState(272);
				expression(0);
				setState(273);
				match(RPAR);
				}
				break;
			case 3:
				{
				_localctx = new UnaryExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(275);
				_la = _input.LA(1);
				if ( !(_la==SUB || _la==NOT) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(276);
				expression(7);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(299);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,22,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(297);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,21,_ctx) ) {
					case 1:
						{
						_localctx = new MultiplicativeExpressionContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(279);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(280);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 28L) != 0)) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(281);
						expression(7);
						}
						break;
					case 2:
						{
						_localctx = new AdditiveExpressionContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(282);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(283);
						_la = _input.LA(1);
						if ( !(_la==ADD || _la==SUB) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(284);
						expression(6);
						}
						break;
					case 3:
						{
						_localctx = new ComparisonExpressionContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(285);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(286);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 16106127360L) != 0)) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(287);
						expression(5);
						}
						break;
					case 4:
						{
						_localctx = new EqualityExpressionContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(288);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(289);
						_la = _input.LA(1);
						if ( !(_la==EQ || _la==NEQ) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(290);
						expression(4);
						}
						break;
					case 5:
						{
						_localctx = new AndExpressionContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(291);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(292);
						match(AND);
						setState(293);
						expression(3);
						}
						break;
					case 6:
						{
						_localctx = new OrExpressionContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(294);
						if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
						setState(295);
						match(OR);
						setState(296);
						expression(2);
						}
						break;
					}
					} 
				}
				setState(301);
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
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class VariableValueContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(PWNParser.ID, 0); }
		public IndexContext index() {
			return getRuleContext(IndexContext.class,0);
		}
		public VariableValueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_variableValue; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PWNListener ) ((PWNListener)listener).enterVariableValue(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PWNListener ) ((PWNListener)listener).exitVariableValue(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PWNVisitor ) return ((PWNVisitor<? extends T>)visitor).visitVariableValue(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VariableValueContext variableValue() throws RecognitionException {
		VariableValueContext _localctx = new VariableValueContext(_ctx, getState());
		enterRule(_localctx, 54, RULE_variableValue);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(302);
			match(ID);
			setState(304);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,23,_ctx) ) {
			case 1:
				{
				setState(303);
				index();
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
	public static class ValueContext extends ParserRuleContext {
		public VariableValueContext variableValue() {
			return getRuleContext(VariableValueContext.class,0);
		}
		public LiteralValueContext literalValue() {
			return getRuleContext(LiteralValueContext.class,0);
		}
		public FunctionCallContext functionCall() {
			return getRuleContext(FunctionCallContext.class,0);
		}
		public TerminalNode LPAR() { return getToken(PWNParser.LPAR, 0); }
		public ValueContext value() {
			return getRuleContext(ValueContext.class,0);
		}
		public TerminalNode RPAR() { return getToken(PWNParser.RPAR, 0); }
		public ValueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_value; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PWNListener ) ((PWNListener)listener).enterValue(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PWNListener ) ((PWNListener)listener).exitValue(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PWNVisitor ) return ((PWNVisitor<? extends T>)visitor).visitValue(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ValueContext value() throws RecognitionException {
		ValueContext _localctx = new ValueContext(_ctx, getState());
		enterRule(_localctx, 56, RULE_value);
		try {
			setState(313);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,24,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(306);
				variableValue();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(307);
				literalValue();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(308);
				functionCall();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				{
				setState(309);
				match(LPAR);
				setState(310);
				value();
				setState(311);
				match(RPAR);
				}
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
	public static class ArrayLiteralContext extends ParserRuleContext {
		public TerminalNode LBRACKET() { return getToken(PWNParser.LBRACKET, 0); }
		public TerminalNode RBRACKET() { return getToken(PWNParser.RBRACKET, 0); }
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(PWNParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(PWNParser.COMMA, i);
		}
		public ArrayLiteralContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_arrayLiteral; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PWNListener ) ((PWNListener)listener).enterArrayLiteral(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PWNListener ) ((PWNListener)listener).exitArrayLiteral(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PWNVisitor ) return ((PWNVisitor<? extends T>)visitor).visitArrayLiteral(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ArrayLiteralContext arrayLiteral() throws RecognitionException {
		ArrayLiteralContext _localctx = new ArrayLiteralContext(_ctx, getState());
		enterRule(_localctx, 58, RULE_arrayLiteral);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(315);
			match(LBRACKET);
			setState(324);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 3237391728902432L) != 0)) {
				{
				setState(316);
				expression(0);
				setState(321);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(317);
					match(COMMA);
					setState(318);
					expression(0);
					}
					}
					setState(323);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(326);
			match(RBRACKET);
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
	public static class LiteralValueContext extends ParserRuleContext {
		public TerminalNode INT() { return getToken(PWNParser.INT, 0); }
		public TerminalNode FLOAT() { return getToken(PWNParser.FLOAT, 0); }
		public TerminalNode STRING() { return getToken(PWNParser.STRING, 0); }
		public TerminalNode TRUE() { return getToken(PWNParser.TRUE, 0); }
		public TerminalNode FALSE() { return getToken(PWNParser.FALSE, 0); }
		public LiteralValueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_literalValue; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PWNListener ) ((PWNListener)listener).enterLiteralValue(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PWNListener ) ((PWNListener)listener).exitLiteralValue(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PWNVisitor ) return ((PWNVisitor<? extends T>)visitor).visitLiteralValue(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LiteralValueContext literalValue() throws RecognitionException {
		LiteralValueContext _localctx = new LiteralValueContext(_ctx, getState());
		enterRule(_localctx, 60, RULE_literalValue);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(328);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 3096637060677632L) != 0)) ) {
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

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 26:
			return expression_sempred((ExpressionContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean expression_sempred(ExpressionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 6);
		case 1:
			return precpred(_ctx, 5);
		case 2:
			return precpred(_ctx, 4);
		case 3:
			return precpred(_ctx, 3);
		case 4:
			return precpred(_ctx, 2);
		case 5:
			return precpred(_ctx, 1);
		}
		return true;
	}

	public static final String _serializedATN =
		"\u0004\u00015\u014b\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002"+
		"\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007\u0002"+
		"\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b\u0002"+
		"\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0002\u000f\u0007\u000f"+
		"\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011\u0002\u0012\u0007\u0012"+
		"\u0002\u0013\u0007\u0013\u0002\u0014\u0007\u0014\u0002\u0015\u0007\u0015"+
		"\u0002\u0016\u0007\u0016\u0002\u0017\u0007\u0017\u0002\u0018\u0007\u0018"+
		"\u0002\u0019\u0007\u0019\u0002\u001a\u0007\u001a\u0002\u001b\u0007\u001b"+
		"\u0002\u001c\u0007\u001c\u0002\u001d\u0007\u001d\u0002\u001e\u0007\u001e"+
		"\u0001\u0000\u0005\u0000@\b\u0000\n\u0000\f\u0000C\t\u0000\u0001\u0000"+
		"\u0004\u0000F\b\u0000\u000b\u0000\f\u0000G\u0001\u0000\u0001\u0000\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0003\u0001T\b\u0001\u0001\u0002\u0001\u0002\u0003"+
		"\u0002X\b\u0002\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0004\u0001"+
		"\u0004\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001"+
		"\u0005\u0003\u0005e\b\u0005\u0001\u0005\u0001\u0005\u0001\u0006\u0001"+
		"\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001"+
		"\u0006\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001"+
		"\b\u0001\b\u0001\t\u0001\t\u0001\t\u0001\t\u0001\n\u0001\n\u0001\u000b"+
		"\u0001\u000b\u0001\u000b\u0001\u000b\u0001\f\u0001\f\u0003\f\u0084\b\f"+
		"\u0001\f\u0001\f\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0005"+
		"\r\u008e\b\r\n\r\f\r\u0091\t\r\u0001\r\u0001\r\u0005\r\u0095\b\r\n\r\f"+
		"\r\u0098\t\r\u0001\r\u0003\r\u009b\b\r\u0001\u000e\u0001\u000e\u0001\u000e"+
		"\u0001\u000e\u0001\u000e\u0001\u000e\u0005\u000e\u00a3\b\u000e\n\u000e"+
		"\f\u000e\u00a6\t\u000e\u0001\u000e\u0001\u000e\u0001\u000f\u0001\u000f"+
		"\u0001\u000f\u0005\u000f\u00ad\b\u000f\n\u000f\f\u000f\u00b0\t\u000f\u0001"+
		"\u000f\u0001\u000f\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0001"+
		"\u0010\u0001\u0010\u0005\u0010\u00ba\b\u0010\n\u0010\f\u0010\u00bd\t\u0010"+
		"\u0001\u0010\u0001\u0010\u0001\u0011\u0001\u0011\u0001\u0012\u0001\u0012"+
		"\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0012"+
		"\u0001\u0012\u0001\u0012\u0005\u0012\u00cd\b\u0012\n\u0012\f\u0012\u00d0"+
		"\t\u0012\u0001\u0012\u0001\u0012\u0001\u0013\u0001\u0013\u0001\u0013\u0001"+
		"\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0003\u0013\u00db\b\u0013\u0001"+
		"\u0013\u0001\u0013\u0005\u0013\u00df\b\u0013\n\u0013\f\u0013\u00e2\t\u0013"+
		"\u0001\u0013\u0001\u0013\u0001\u0014\u0001\u0014\u0001\u0014\u0001\u0014"+
		"\u0001\u0014\u0001\u0014\u0001\u0014\u0001\u0014\u0005\u0014\u00ee\b\u0014"+
		"\n\u0014\f\u0014\u00f1\t\u0014\u0003\u0014\u00f3\b\u0014\u0001\u0015\u0001"+
		"\u0015\u0001\u0015\u0005\u0015\u00f8\b\u0015\n\u0015\f\u0015\u00fb\t\u0015"+
		"\u0003\u0015\u00fd\b\u0015\u0001\u0016\u0001\u0016\u0001\u0016\u0001\u0016"+
		"\u0001\u0016\u0001\u0017\u0001\u0017\u0003\u0017\u0106\b\u0017\u0001\u0018"+
		"\u0001\u0018\u0001\u0019\u0001\u0019\u0001\u0019\u0001\u0019\u0001\u001a"+
		"\u0001\u001a\u0001\u001a\u0001\u001a\u0001\u001a\u0001\u001a\u0001\u001a"+
		"\u0001\u001a\u0003\u001a\u0116\b\u001a\u0001\u001a\u0001\u001a\u0001\u001a"+
		"\u0001\u001a\u0001\u001a\u0001\u001a\u0001\u001a\u0001\u001a\u0001\u001a"+
		"\u0001\u001a\u0001\u001a\u0001\u001a\u0001\u001a\u0001\u001a\u0001\u001a"+
		"\u0001\u001a\u0001\u001a\u0001\u001a\u0005\u001a\u012a\b\u001a\n\u001a"+
		"\f\u001a\u012d\t\u001a\u0001\u001b\u0001\u001b\u0003\u001b\u0131\b\u001b"+
		"\u0001\u001c\u0001\u001c\u0001\u001c\u0001\u001c\u0001\u001c\u0001\u001c"+
		"\u0001\u001c\u0003\u001c\u013a\b\u001c\u0001\u001d\u0001\u001d\u0001\u001d"+
		"\u0001\u001d\u0005\u001d\u0140\b\u001d\n\u001d\f\u001d\u0143\t\u001d\u0003"+
		"\u001d\u0145\b\u001d\u0001\u001d\u0001\u001d\u0001\u001e\u0001\u001e\u0001"+
		"\u001e\u0000\u00014\u001f\u0000\u0002\u0004\u0006\b\n\f\u000e\u0010\u0012"+
		"\u0014\u0016\u0018\u001a\u001c\u001e \"$&(*,.02468:<\u0000\u000b\u0001"+
		"\u0000\u0011\u0012\u0002\u0000\u0010\u0010\u0017\u0018\u0001\u0000\u0015"+
		"\u0016\u0002\u0000//22\u0001\u0000\u0019\u001d\u0002\u0000\u0005\u0005"+
		"\"\"\u0001\u0000\u0002\u0004\u0002\u0000\u0001\u0001\u0005\u0005\u0001"+
		"\u0000\u001e!\u0001\u0000\u000e\u000f\u0003\u0000%&0133\u0153\u0000A\u0001"+
		"\u0000\u0000\u0000\u0002S\u0001\u0000\u0000\u0000\u0004W\u0001\u0000\u0000"+
		"\u0000\u0006Y\u0001\u0000\u0000\u0000\b\\\u0001\u0000\u0000\u0000\n^\u0001"+
		"\u0000\u0000\u0000\fh\u0001\u0000\u0000\u0000\u000ep\u0001\u0000\u0000"+
		"\u0000\u0010u\u0001\u0000\u0000\u0000\u0012w\u0001\u0000\u0000\u0000\u0014"+
		"{\u0001\u0000\u0000\u0000\u0016}\u0001\u0000\u0000\u0000\u0018\u0081\u0001"+
		"\u0000\u0000\u0000\u001a\u0087\u0001\u0000\u0000\u0000\u001c\u009c\u0001"+
		"\u0000\u0000\u0000\u001e\u00a9\u0001\u0000\u0000\u0000 \u00b3\u0001\u0000"+
		"\u0000\u0000\"\u00c0\u0001\u0000\u0000\u0000$\u00c2\u0001\u0000\u0000"+
		"\u0000&\u00d3\u0001\u0000\u0000\u0000(\u00f2\u0001\u0000\u0000\u0000*"+
		"\u00fc\u0001\u0000\u0000\u0000,\u00fe\u0001\u0000\u0000\u0000.\u0105\u0001"+
		"\u0000\u0000\u00000\u0107\u0001\u0000\u0000\u00002\u0109\u0001\u0000\u0000"+
		"\u00004\u0115\u0001\u0000\u0000\u00006\u012e\u0001\u0000\u0000\u00008"+
		"\u0139\u0001\u0000\u0000\u0000:\u013b\u0001\u0000\u0000\u0000<\u0148\u0001"+
		"\u0000\u0000\u0000>@\u0003&\u0013\u0000?>\u0001\u0000\u0000\u0000@C\u0001"+
		"\u0000\u0000\u0000A?\u0001\u0000\u0000\u0000AB\u0001\u0000\u0000\u0000"+
		"BE\u0001\u0000\u0000\u0000CA\u0001\u0000\u0000\u0000DF\u0003\u0002\u0001"+
		"\u0000ED\u0001\u0000\u0000\u0000FG\u0001\u0000\u0000\u0000GE\u0001\u0000"+
		"\u0000\u0000GH\u0001\u0000\u0000\u0000HI\u0001\u0000\u0000\u0000IJ\u0005"+
		"\u0000\u0000\u0001J\u0001\u0001\u0000\u0000\u0000KT\u0003\u000e\u0007"+
		"\u0000LT\u0003\u0012\t\u0000MT\u0003\n\u0005\u0000NT\u0003\f\u0006\u0000"+
		"OT\u0003\u0018\f\u0000PT\u0003\u001a\r\u0000QT\u0003 \u0010\u0000RT\u0003"+
		"$\u0012\u0000SK\u0001\u0000\u0000\u0000SL\u0001\u0000\u0000\u0000SM\u0001"+
		"\u0000\u0000\u0000SN\u0001\u0000\u0000\u0000SO\u0001\u0000\u0000\u0000"+
		"SP\u0001\u0000\u0000\u0000SQ\u0001\u0000\u0000\u0000SR\u0001\u0000\u0000"+
		"\u0000T\u0003\u0001\u0000\u0000\u0000UX\u0003\u0002\u0001\u0000VX\u0003"+
		"\u0006\u0003\u0000WU\u0001\u0000\u0000\u0000WV\u0001\u0000\u0000\u0000"+
		"X\u0005\u0001\u0000\u0000\u0000YZ\u0003\b\u0004\u0000Z[\u0005\u0006\u0000"+
		"\u0000[\u0007\u0001\u0000\u0000\u0000\\]\u0007\u0000\u0000\u0000]\t\u0001"+
		"\u0000\u0000\u0000^_\u0005/\u0000\u0000_`\u0005\u0007\u0000\u0000`a\u0003"+
		".\u0017\u0000ad\u0005\u0010\u0000\u0000be\u00034\u001a\u0000ce\u0003:"+
		"\u001d\u0000db\u0001\u0000\u0000\u0000dc\u0001\u0000\u0000\u0000ef\u0001"+
		"\u0000\u0000\u0000fg\u0005\u0006\u0000\u0000g\u000b\u0001\u0000\u0000"+
		"\u0000hi\u0005/\u0000\u0000ij\u0005\u0007\u0000\u0000jk\u00030\u0018\u0000"+
		"kl\u0005\f\u0000\u0000lm\u00050\u0000\u0000mn\u0005\r\u0000\u0000no\u0005"+
		"\u0006\u0000\u0000o\r\u0001\u0000\u0000\u0000pq\u00036\u001b\u0000qr\u0003"+
		"\u0010\b\u0000rs\u00034\u001a\u0000st\u0005\u0006\u0000\u0000t\u000f\u0001"+
		"\u0000\u0000\u0000uv\u0007\u0001\u0000\u0000v\u0011\u0001\u0000\u0000"+
		"\u0000wx\u00036\u001b\u0000xy\u0003\u0014\n\u0000yz\u0005\u0006\u0000"+
		"\u0000z\u0013\u0001\u0000\u0000\u0000{|\u0007\u0002\u0000\u0000|\u0015"+
		"\u0001\u0000\u0000\u0000}~\u0005\f\u0000\u0000~\u007f\u00034\u001a\u0000"+
		"\u007f\u0080\u0005\r\u0000\u0000\u0080\u0017\u0001\u0000\u0000\u0000\u0081"+
		"\u0083\u0005.\u0000\u0000\u0082\u0084\u00034\u001a\u0000\u0083\u0082\u0001"+
		"\u0000\u0000\u0000\u0083\u0084\u0001\u0000\u0000\u0000\u0084\u0085\u0001"+
		"\u0000\u0000\u0000\u0085\u0086\u0005\u0006\u0000\u0000\u0086\u0019\u0001"+
		"\u0000\u0000\u0000\u0087\u0088\u0005(\u0000\u0000\u0088\u0089\u0005\b"+
		"\u0000\u0000\u0089\u008a\u00034\u001a\u0000\u008a\u008b\u0005\t\u0000"+
		"\u0000\u008b\u008f\u0005\n\u0000\u0000\u008c\u008e\u0003\u0002\u0001\u0000"+
		"\u008d\u008c\u0001\u0000\u0000\u0000\u008e\u0091\u0001\u0000\u0000\u0000"+
		"\u008f\u008d\u0001\u0000\u0000\u0000\u008f\u0090\u0001\u0000\u0000\u0000"+
		"\u0090\u0092\u0001\u0000\u0000\u0000\u0091\u008f\u0001\u0000\u0000\u0000"+
		"\u0092\u0096\u0005\u000b\u0000\u0000\u0093\u0095\u0003\u001c\u000e\u0000"+
		"\u0094\u0093\u0001\u0000\u0000\u0000\u0095\u0098\u0001\u0000\u0000\u0000"+
		"\u0096\u0094\u0001\u0000\u0000\u0000\u0096\u0097\u0001\u0000\u0000\u0000"+
		"\u0097\u009a\u0001\u0000\u0000\u0000\u0098\u0096\u0001\u0000\u0000\u0000"+
		"\u0099\u009b\u0003\u001e\u000f\u0000\u009a\u0099\u0001\u0000\u0000\u0000"+
		"\u009a\u009b\u0001\u0000\u0000\u0000\u009b\u001b\u0001\u0000\u0000\u0000"+
		"\u009c\u009d\u0005)\u0000\u0000\u009d\u009e\u0005\b\u0000\u0000\u009e"+
		"\u009f\u00034\u001a\u0000\u009f\u00a0\u0005\t\u0000\u0000\u00a0\u00a4"+
		"\u0005\n\u0000\u0000\u00a1\u00a3\u0003\u0002\u0001\u0000\u00a2\u00a1\u0001"+
		"\u0000\u0000\u0000\u00a3\u00a6\u0001\u0000\u0000\u0000\u00a4\u00a2\u0001"+
		"\u0000\u0000\u0000\u00a4\u00a5\u0001\u0000\u0000\u0000\u00a5\u00a7\u0001"+
		"\u0000\u0000\u0000\u00a6\u00a4\u0001\u0000\u0000\u0000\u00a7\u00a8\u0005"+
		"\u000b\u0000\u0000\u00a8\u001d\u0001\u0000\u0000\u0000\u00a9\u00aa\u0005"+
		"*\u0000\u0000\u00aa\u00ae\u0005\n\u0000\u0000\u00ab\u00ad\u0003\u0002"+
		"\u0001\u0000\u00ac\u00ab\u0001\u0000\u0000\u0000\u00ad\u00b0\u0001\u0000"+
		"\u0000\u0000\u00ae\u00ac\u0001\u0000\u0000\u0000\u00ae\u00af\u0001\u0000"+
		"\u0000\u0000\u00af\u00b1\u0001\u0000\u0000\u0000\u00b0\u00ae\u0001\u0000"+
		"\u0000\u0000\u00b1\u00b2\u0005\u000b\u0000\u0000\u00b2\u001f\u0001\u0000"+
		"\u0000\u0000\u00b3\u00b4\u0005+\u0000\u0000\u00b4\u00b5\u0005\b\u0000"+
		"\u0000\u00b5\u00b6\u00034\u001a\u0000\u00b6\u00b7\u0005\t\u0000\u0000"+
		"\u00b7\u00bb\u0005\n\u0000\u0000\u00b8\u00ba\u0003\u0004\u0002\u0000\u00b9"+
		"\u00b8\u0001\u0000\u0000\u0000\u00ba\u00bd\u0001\u0000\u0000\u0000\u00bb"+
		"\u00b9\u0001\u0000\u0000\u0000\u00bb\u00bc\u0001\u0000\u0000\u0000\u00bc"+
		"\u00be\u0001\u0000\u0000\u0000\u00bd\u00bb\u0001\u0000\u0000\u0000\u00be"+
		"\u00bf\u0005\u000b\u0000\u0000\u00bf!\u0001\u0000\u0000\u0000\u00c0\u00c1"+
		"\u0007\u0003\u0000\u0000\u00c1#\u0001\u0000\u0000\u0000\u00c2\u00c3\u0005"+
		",\u0000\u0000\u00c3\u00c4\u0005\b\u0000\u0000\u00c4\u00c5\u0005/\u0000"+
		"\u0000\u00c5\u00c6\u0005\u0007\u0000\u0000\u00c6\u00c7\u00030\u0018\u0000"+
		"\u00c7\u00c8\u0005\'\u0000\u0000\u00c8\u00c9\u0003\"\u0011\u0000\u00c9"+
		"\u00ca\u0005\t\u0000\u0000\u00ca\u00ce\u0005\n\u0000\u0000\u00cb\u00cd"+
		"\u0003\u0004\u0002\u0000\u00cc\u00cb\u0001\u0000\u0000\u0000\u00cd\u00d0"+
		"\u0001\u0000\u0000\u0000\u00ce\u00cc\u0001\u0000\u0000\u0000\u00ce\u00cf"+
		"\u0001\u0000\u0000\u0000\u00cf\u00d1\u0001\u0000\u0000\u0000\u00d0\u00ce"+
		"\u0001\u0000\u0000\u0000\u00d1\u00d2\u0005\u000b\u0000\u0000\u00d2%\u0001"+
		"\u0000\u0000\u0000\u00d3\u00d4\u0005-\u0000\u0000\u00d4\u00d5\u0005/\u0000"+
		"\u0000\u00d5\u00d6\u0005\b\u0000\u0000\u00d6\u00d7\u0003(\u0014\u0000"+
		"\u00d7\u00da\u0005\t\u0000\u0000\u00d8\u00d9\u0005\u0013\u0000\u0000\u00d9"+
		"\u00db\u00030\u0018\u0000\u00da\u00d8\u0001\u0000\u0000\u0000\u00da\u00db"+
		"\u0001\u0000\u0000\u0000\u00db\u00dc\u0001\u0000\u0000\u0000\u00dc\u00e0"+
		"\u0005\n\u0000\u0000\u00dd\u00df\u0003\u0002\u0001\u0000\u00de\u00dd\u0001"+
		"\u0000\u0000\u0000\u00df\u00e2\u0001\u0000\u0000\u0000\u00e0\u00de\u0001"+
		"\u0000\u0000\u0000\u00e0\u00e1\u0001\u0000\u0000\u0000\u00e1\u00e3\u0001"+
		"\u0000\u0000\u0000\u00e2\u00e0\u0001\u0000\u0000\u0000\u00e3\u00e4\u0005"+
		"\u000b\u0000\u0000\u00e4\'\u0001\u0000\u0000\u0000\u00e5\u00e6\u0005/"+
		"\u0000\u0000\u00e6\u00e7\u0005\u0007\u0000\u0000\u00e7\u00e8\u0003.\u0017"+
		"\u0000\u00e8\u00ef\u0001\u0000\u0000\u0000\u00e9\u00ea\u0005\u0014\u0000"+
		"\u0000\u00ea\u00eb\u0005/\u0000\u0000\u00eb\u00ec\u0005\u0007\u0000\u0000"+
		"\u00ec\u00ee\u0003.\u0017\u0000\u00ed\u00e9\u0001\u0000\u0000\u0000\u00ee"+
		"\u00f1\u0001\u0000\u0000\u0000\u00ef\u00ed\u0001\u0000\u0000\u0000\u00ef"+
		"\u00f0\u0001\u0000\u0000\u0000\u00f0\u00f3\u0001\u0000\u0000\u0000\u00f1"+
		"\u00ef\u0001\u0000\u0000\u0000\u00f2\u00e5\u0001\u0000\u0000\u0000\u00f2"+
		"\u00f3\u0001\u0000\u0000\u0000\u00f3)\u0001\u0000\u0000\u0000\u00f4\u00f9"+
		"\u00034\u001a\u0000\u00f5\u00f6\u0005\u0014\u0000\u0000\u00f6\u00f8\u0003"+
		"4\u001a\u0000\u00f7\u00f5\u0001\u0000\u0000\u0000\u00f8\u00fb\u0001\u0000"+
		"\u0000\u0000\u00f9\u00f7\u0001\u0000\u0000\u0000\u00f9\u00fa\u0001\u0000"+
		"\u0000\u0000\u00fa\u00fd\u0001\u0000\u0000\u0000\u00fb\u00f9\u0001\u0000"+
		"\u0000\u0000\u00fc\u00f4\u0001\u0000\u0000\u0000\u00fc\u00fd\u0001\u0000"+
		"\u0000\u0000\u00fd+\u0001\u0000\u0000\u0000\u00fe\u00ff\u0005/\u0000\u0000"+
		"\u00ff\u0100\u0005\b\u0000\u0000\u0100\u0101\u0003*\u0015\u0000\u0101"+
		"\u0102\u0005\t\u0000\u0000\u0102-\u0001\u0000\u0000\u0000\u0103\u0106"+
		"\u00030\u0018\u0000\u0104\u0106\u00032\u0019\u0000\u0105\u0103\u0001\u0000"+
		"\u0000\u0000\u0105\u0104\u0001\u0000\u0000\u0000\u0106/\u0001\u0000\u0000"+
		"\u0000\u0107\u0108\u0007\u0004\u0000\u0000\u01081\u0001\u0000\u0000\u0000"+
		"\u0109\u010a\u00030\u0018\u0000\u010a\u010b\u0005\f\u0000\u0000\u010b"+
		"\u010c\u0005\r\u0000\u0000\u010c3\u0001\u0000\u0000\u0000\u010d\u010e"+
		"\u0006\u001a\uffff\uffff\u0000\u010e\u0116\u00038\u001c\u0000\u010f\u0110"+
		"\u0005\b\u0000\u0000\u0110\u0111\u00034\u001a\u0000\u0111\u0112\u0005"+
		"\t\u0000\u0000\u0112\u0116\u0001\u0000\u0000\u0000\u0113\u0114\u0007\u0005"+
		"\u0000\u0000\u0114\u0116\u00034\u001a\u0007\u0115\u010d\u0001\u0000\u0000"+
		"\u0000\u0115\u010f\u0001\u0000\u0000\u0000\u0115\u0113\u0001\u0000\u0000"+
		"\u0000\u0116\u012b\u0001\u0000\u0000\u0000\u0117\u0118\n\u0006\u0000\u0000"+
		"\u0118\u0119\u0007\u0006\u0000\u0000\u0119\u012a\u00034\u001a\u0007\u011a"+
		"\u011b\n\u0005\u0000\u0000\u011b\u011c\u0007\u0007\u0000\u0000\u011c\u012a"+
		"\u00034\u001a\u0006\u011d\u011e\n\u0004\u0000\u0000\u011e\u011f\u0007"+
		"\b\u0000\u0000\u011f\u012a\u00034\u001a\u0005\u0120\u0121\n\u0003\u0000"+
		"\u0000\u0121\u0122\u0007\t\u0000\u0000\u0122\u012a\u00034\u001a\u0004"+
		"\u0123\u0124\n\u0002\u0000\u0000\u0124\u0125\u0005$\u0000\u0000\u0125"+
		"\u012a\u00034\u001a\u0003\u0126\u0127\n\u0001\u0000\u0000\u0127\u0128"+
		"\u0005#\u0000\u0000\u0128\u012a\u00034\u001a\u0002\u0129\u0117\u0001\u0000"+
		"\u0000\u0000\u0129\u011a\u0001\u0000\u0000\u0000\u0129\u011d\u0001\u0000"+
		"\u0000\u0000\u0129\u0120\u0001\u0000\u0000\u0000\u0129\u0123\u0001\u0000"+
		"\u0000\u0000\u0129\u0126\u0001\u0000\u0000\u0000\u012a\u012d\u0001\u0000"+
		"\u0000\u0000\u012b\u0129\u0001\u0000\u0000\u0000\u012b\u012c\u0001\u0000"+
		"\u0000\u0000\u012c5\u0001\u0000\u0000\u0000\u012d\u012b\u0001\u0000\u0000"+
		"\u0000\u012e\u0130\u0005/\u0000\u0000\u012f\u0131\u0003\u0016\u000b\u0000"+
		"\u0130\u012f\u0001\u0000\u0000\u0000\u0130\u0131\u0001\u0000\u0000\u0000"+
		"\u01317\u0001\u0000\u0000\u0000\u0132\u013a\u00036\u001b\u0000\u0133\u013a"+
		"\u0003<\u001e\u0000\u0134\u013a\u0003,\u0016\u0000\u0135\u0136\u0005\b"+
		"\u0000\u0000\u0136\u0137\u00038\u001c\u0000\u0137\u0138\u0005\t\u0000"+
		"\u0000\u0138\u013a\u0001\u0000\u0000\u0000\u0139\u0132\u0001\u0000\u0000"+
		"\u0000\u0139\u0133\u0001\u0000\u0000\u0000\u0139\u0134\u0001\u0000\u0000"+
		"\u0000\u0139\u0135\u0001\u0000\u0000\u0000\u013a9\u0001\u0000\u0000\u0000"+
		"\u013b\u0144\u0005\f\u0000\u0000\u013c\u0141\u00034\u001a\u0000\u013d"+
		"\u013e\u0005\u0014\u0000\u0000\u013e\u0140\u00034\u001a\u0000\u013f\u013d"+
		"\u0001\u0000\u0000\u0000\u0140\u0143\u0001\u0000\u0000\u0000\u0141\u013f"+
		"\u0001\u0000\u0000\u0000\u0141\u0142\u0001\u0000\u0000\u0000\u0142\u0145"+
		"\u0001\u0000\u0000\u0000\u0143\u0141\u0001\u0000\u0000\u0000\u0144\u013c"+
		"\u0001\u0000\u0000\u0000\u0144\u0145\u0001\u0000\u0000\u0000\u0145\u0146"+
		"\u0001\u0000\u0000\u0000\u0146\u0147\u0005\r\u0000\u0000\u0147;\u0001"+
		"\u0000\u0000\u0000\u0148\u0149\u0007\n\u0000\u0000\u0149=\u0001\u0000"+
		"\u0000\u0000\u001bAGSWd\u0083\u008f\u0096\u009a\u00a4\u00ae\u00bb\u00ce"+
		"\u00da\u00e0\u00ef\u00f2\u00f9\u00fc\u0105\u0115\u0129\u012b\u0130\u0139"+
		"\u0141\u0144";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}