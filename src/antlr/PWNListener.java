// Generated from E:/Next/School/Studia/Kompilatory/TK-projekt/src/antlr\PWN.g4 by ANTLR 4.12.0
package antlr;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link PWNParser}.
 */
public interface PWNListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link PWNParser#program}.
	 * @param ctx the parse tree
	 */
	void enterProgram(PWNParser.ProgramContext ctx);
	/**
	 * Exit a parse tree produced by {@link PWNParser#program}.
	 * @param ctx the parse tree
	 */
	void exitProgram(PWNParser.ProgramContext ctx);
	/**
	 * Enter a parse tree produced by {@link PWNParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterStatement(PWNParser.StatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link PWNParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitStatement(PWNParser.StatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link PWNParser#loopStatement}.
	 * @param ctx the parse tree
	 */
	void enterLoopStatement(PWNParser.LoopStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link PWNParser#loopStatement}.
	 * @param ctx the parse tree
	 */
	void exitLoopStatement(PWNParser.LoopStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link PWNParser#jumpStatement}.
	 * @param ctx the parse tree
	 */
	void enterJumpStatement(PWNParser.JumpStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link PWNParser#jumpStatement}.
	 * @param ctx the parse tree
	 */
	void exitJumpStatement(PWNParser.JumpStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link PWNParser#jumpStatementType}.
	 * @param ctx the parse tree
	 */
	void enterJumpStatementType(PWNParser.JumpStatementTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link PWNParser#jumpStatementType}.
	 * @param ctx the parse tree
	 */
	void exitJumpStatementType(PWNParser.JumpStatementTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link PWNParser#declaration}.
	 * @param ctx the parse tree
	 */
	void enterDeclaration(PWNParser.DeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link PWNParser#declaration}.
	 * @param ctx the parse tree
	 */
	void exitDeclaration(PWNParser.DeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link PWNParser#arrayDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterArrayDeclaration(PWNParser.ArrayDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link PWNParser#arrayDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitArrayDeclaration(PWNParser.ArrayDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link PWNParser#assignment}.
	 * @param ctx the parse tree
	 */
	void enterAssignment(PWNParser.AssignmentContext ctx);
	/**
	 * Exit a parse tree produced by {@link PWNParser#assignment}.
	 * @param ctx the parse tree
	 */
	void exitAssignment(PWNParser.AssignmentContext ctx);
	/**
	 * Enter a parse tree produced by {@link PWNParser#assignmentType}.
	 * @param ctx the parse tree
	 */
	void enterAssignmentType(PWNParser.AssignmentTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link PWNParser#assignmentType}.
	 * @param ctx the parse tree
	 */
	void exitAssignmentType(PWNParser.AssignmentTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link PWNParser#increment}.
	 * @param ctx the parse tree
	 */
	void enterIncrement(PWNParser.IncrementContext ctx);
	/**
	 * Exit a parse tree produced by {@link PWNParser#increment}.
	 * @param ctx the parse tree
	 */
	void exitIncrement(PWNParser.IncrementContext ctx);
	/**
	 * Enter a parse tree produced by {@link PWNParser#incrementType}.
	 * @param ctx the parse tree
	 */
	void enterIncrementType(PWNParser.IncrementTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link PWNParser#incrementType}.
	 * @param ctx the parse tree
	 */
	void exitIncrementType(PWNParser.IncrementTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link PWNParser#index}.
	 * @param ctx the parse tree
	 */
	void enterIndex(PWNParser.IndexContext ctx);
	/**
	 * Exit a parse tree produced by {@link PWNParser#index}.
	 * @param ctx the parse tree
	 */
	void exitIndex(PWNParser.IndexContext ctx);
	/**
	 * Enter a parse tree produced by {@link PWNParser#returnStatement}.
	 * @param ctx the parse tree
	 */
	void enterReturnStatement(PWNParser.ReturnStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link PWNParser#returnStatement}.
	 * @param ctx the parse tree
	 */
	void exitReturnStatement(PWNParser.ReturnStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link PWNParser#ifStatement}.
	 * @param ctx the parse tree
	 */
	void enterIfStatement(PWNParser.IfStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link PWNParser#ifStatement}.
	 * @param ctx the parse tree
	 */
	void exitIfStatement(PWNParser.IfStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link PWNParser#elifStatement}.
	 * @param ctx the parse tree
	 */
	void enterElifStatement(PWNParser.ElifStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link PWNParser#elifStatement}.
	 * @param ctx the parse tree
	 */
	void exitElifStatement(PWNParser.ElifStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link PWNParser#elseStatement}.
	 * @param ctx the parse tree
	 */
	void enterElseStatement(PWNParser.ElseStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link PWNParser#elseStatement}.
	 * @param ctx the parse tree
	 */
	void exitElseStatement(PWNParser.ElseStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link PWNParser#whileStatement}.
	 * @param ctx the parse tree
	 */
	void enterWhileStatement(PWNParser.WhileStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link PWNParser#whileStatement}.
	 * @param ctx the parse tree
	 */
	void exitWhileStatement(PWNParser.WhileStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link PWNParser#iterable}.
	 * @param ctx the parse tree
	 */
	void enterIterable(PWNParser.IterableContext ctx);
	/**
	 * Exit a parse tree produced by {@link PWNParser#iterable}.
	 * @param ctx the parse tree
	 */
	void exitIterable(PWNParser.IterableContext ctx);
	/**
	 * Enter a parse tree produced by {@link PWNParser#forStatement}.
	 * @param ctx the parse tree
	 */
	void enterForStatement(PWNParser.ForStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link PWNParser#forStatement}.
	 * @param ctx the parse tree
	 */
	void exitForStatement(PWNParser.ForStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link PWNParser#functionDefinition}.
	 * @param ctx the parse tree
	 */
	void enterFunctionDefinition(PWNParser.FunctionDefinitionContext ctx);
	/**
	 * Exit a parse tree produced by {@link PWNParser#functionDefinition}.
	 * @param ctx the parse tree
	 */
	void exitFunctionDefinition(PWNParser.FunctionDefinitionContext ctx);
	/**
	 * Enter a parse tree produced by {@link PWNParser#argumentsDefinition}.
	 * @param ctx the parse tree
	 */
	void enterArgumentsDefinition(PWNParser.ArgumentsDefinitionContext ctx);
	/**
	 * Exit a parse tree produced by {@link PWNParser#argumentsDefinition}.
	 * @param ctx the parse tree
	 */
	void exitArgumentsDefinition(PWNParser.ArgumentsDefinitionContext ctx);
	/**
	 * Enter a parse tree produced by {@link PWNParser#arguments}.
	 * @param ctx the parse tree
	 */
	void enterArguments(PWNParser.ArgumentsContext ctx);
	/**
	 * Exit a parse tree produced by {@link PWNParser#arguments}.
	 * @param ctx the parse tree
	 */
	void exitArguments(PWNParser.ArgumentsContext ctx);
	/**
	 * Enter a parse tree produced by {@link PWNParser#functionCall}.
	 * @param ctx the parse tree
	 */
	void enterFunctionCall(PWNParser.FunctionCallContext ctx);
	/**
	 * Exit a parse tree produced by {@link PWNParser#functionCall}.
	 * @param ctx the parse tree
	 */
	void exitFunctionCall(PWNParser.FunctionCallContext ctx);
	/**
	 * Enter a parse tree produced by {@link PWNParser#type}.
	 * @param ctx the parse tree
	 */
	void enterType(PWNParser.TypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link PWNParser#type}.
	 * @param ctx the parse tree
	 */
	void exitType(PWNParser.TypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link PWNParser#normalType}.
	 * @param ctx the parse tree
	 */
	void enterNormalType(PWNParser.NormalTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link PWNParser#normalType}.
	 * @param ctx the parse tree
	 */
	void exitNormalType(PWNParser.NormalTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link PWNParser#arrayType}.
	 * @param ctx the parse tree
	 */
	void enterArrayType(PWNParser.ArrayTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link PWNParser#arrayType}.
	 * @param ctx the parse tree
	 */
	void exitArrayType(PWNParser.ArrayTypeContext ctx);
	/**
	 * Enter a parse tree produced by the {@code orExpression}
	 * labeled alternative in {@link PWNParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterOrExpression(PWNParser.OrExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code orExpression}
	 * labeled alternative in {@link PWNParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitOrExpression(PWNParser.OrExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code valueExpression}
	 * labeled alternative in {@link PWNParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterValueExpression(PWNParser.ValueExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code valueExpression}
	 * labeled alternative in {@link PWNParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitValueExpression(PWNParser.ValueExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code andExpression}
	 * labeled alternative in {@link PWNParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterAndExpression(PWNParser.AndExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code andExpression}
	 * labeled alternative in {@link PWNParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitAndExpression(PWNParser.AndExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code inExpression}
	 * labeled alternative in {@link PWNParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterInExpression(PWNParser.InExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code inExpression}
	 * labeled alternative in {@link PWNParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitInExpression(PWNParser.InExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code parenthesizedExpression}
	 * labeled alternative in {@link PWNParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterParenthesizedExpression(PWNParser.ParenthesizedExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code parenthesizedExpression}
	 * labeled alternative in {@link PWNParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitParenthesizedExpression(PWNParser.ParenthesizedExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code additiveExpression}
	 * labeled alternative in {@link PWNParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterAdditiveExpression(PWNParser.AdditiveExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code additiveExpression}
	 * labeled alternative in {@link PWNParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitAdditiveExpression(PWNParser.AdditiveExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code equalityExpression}
	 * labeled alternative in {@link PWNParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterEqualityExpression(PWNParser.EqualityExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code equalityExpression}
	 * labeled alternative in {@link PWNParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitEqualityExpression(PWNParser.EqualityExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code comparisonExpression}
	 * labeled alternative in {@link PWNParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterComparisonExpression(PWNParser.ComparisonExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code comparisonExpression}
	 * labeled alternative in {@link PWNParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitComparisonExpression(PWNParser.ComparisonExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code multiplicativeExpression}
	 * labeled alternative in {@link PWNParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterMultiplicativeExpression(PWNParser.MultiplicativeExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code multiplicativeExpression}
	 * labeled alternative in {@link PWNParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitMultiplicativeExpression(PWNParser.MultiplicativeExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code unaryExpression}
	 * labeled alternative in {@link PWNParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterUnaryExpression(PWNParser.UnaryExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code unaryExpression}
	 * labeled alternative in {@link PWNParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitUnaryExpression(PWNParser.UnaryExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link PWNParser#variableValue}.
	 * @param ctx the parse tree
	 */
	void enterVariableValue(PWNParser.VariableValueContext ctx);
	/**
	 * Exit a parse tree produced by {@link PWNParser#variableValue}.
	 * @param ctx the parse tree
	 */
	void exitVariableValue(PWNParser.VariableValueContext ctx);
	/**
	 * Enter a parse tree produced by {@link PWNParser#value}.
	 * @param ctx the parse tree
	 */
	void enterValue(PWNParser.ValueContext ctx);
	/**
	 * Exit a parse tree produced by {@link PWNParser#value}.
	 * @param ctx the parse tree
	 */
	void exitValue(PWNParser.ValueContext ctx);
	/**
	 * Enter a parse tree produced by {@link PWNParser#arrayLiteral}.
	 * @param ctx the parse tree
	 */
	void enterArrayLiteral(PWNParser.ArrayLiteralContext ctx);
	/**
	 * Exit a parse tree produced by {@link PWNParser#arrayLiteral}.
	 * @param ctx the parse tree
	 */
	void exitArrayLiteral(PWNParser.ArrayLiteralContext ctx);
	/**
	 * Enter a parse tree produced by {@link PWNParser#literalValue}.
	 * @param ctx the parse tree
	 */
	void enterLiteralValue(PWNParser.LiteralValueContext ctx);
	/**
	 * Exit a parse tree produced by {@link PWNParser#literalValue}.
	 * @param ctx the parse tree
	 */
	void exitLiteralValue(PWNParser.LiteralValueContext ctx);
}