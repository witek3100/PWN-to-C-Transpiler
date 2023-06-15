// Generated from E:/Next/School/Studia/Kompilatory/TK-projekt/PWNConverter/src/antlr\PWN.g4 by ANTLR 4.12.0
package antlr;

import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link PWNParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface PWNVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link PWNParser#program}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProgram(PWNParser.ProgramContext ctx);
	/**
	 * Visit a parse tree produced by {@link PWNParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatement(PWNParser.StatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link PWNParser#loopStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLoopStatement(PWNParser.LoopStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link PWNParser#jumpStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitJumpStatement(PWNParser.JumpStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link PWNParser#jumpStatementType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitJumpStatementType(PWNParser.JumpStatementTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link PWNParser#declaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDeclaration(PWNParser.DeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link PWNParser#assignment}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssignment(PWNParser.AssignmentContext ctx);
	/**
	 * Visit a parse tree produced by {@link PWNParser#assignmentType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssignmentType(PWNParser.AssignmentTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link PWNParser#increment}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIncrement(PWNParser.IncrementContext ctx);
	/**
	 * Visit a parse tree produced by {@link PWNParser#incrementType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIncrementType(PWNParser.IncrementTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link PWNParser#index}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIndex(PWNParser.IndexContext ctx);
	/**
	 * Visit a parse tree produced by {@link PWNParser#returnStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReturnStatement(PWNParser.ReturnStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link PWNParser#ifStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIfStatement(PWNParser.IfStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link PWNParser#whileStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWhileStatement(PWNParser.WhileStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link PWNParser#iterable}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIterable(PWNParser.IterableContext ctx);
	/**
	 * Visit a parse tree produced by {@link PWNParser#forStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitForStatement(PWNParser.ForStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link PWNParser#functionDefinition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionDefinition(PWNParser.FunctionDefinitionContext ctx);
	/**
	 * Visit a parse tree produced by {@link PWNParser#argumentsDefinition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArgumentsDefinition(PWNParser.ArgumentsDefinitionContext ctx);
	/**
	 * Visit a parse tree produced by {@link PWNParser#arguments}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArguments(PWNParser.ArgumentsContext ctx);
	/**
	 * Visit a parse tree produced by {@link PWNParser#functionCall}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionCall(PWNParser.FunctionCallContext ctx);
	/**
	 * Visit a parse tree produced by {@link PWNParser#type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitType(PWNParser.TypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link PWNParser#normalType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNormalType(PWNParser.NormalTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link PWNParser#arrayType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArrayType(PWNParser.ArrayTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link PWNParser#arrayInit}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArrayInit(PWNParser.ArrayInitContext ctx);
	/**
	 * Visit a parse tree produced by the {@code orExpression}
	 * labeled alternative in {@link PWNParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOrExpression(PWNParser.OrExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code valueExpression}
	 * labeled alternative in {@link PWNParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitValueExpression(PWNParser.ValueExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code andExpression}
	 * labeled alternative in {@link PWNParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAndExpression(PWNParser.AndExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code inExpression}
	 * labeled alternative in {@link PWNParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInExpression(PWNParser.InExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code parenthesizedExpression}
	 * labeled alternative in {@link PWNParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParenthesizedExpression(PWNParser.ParenthesizedExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code additiveExpression}
	 * labeled alternative in {@link PWNParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAdditiveExpression(PWNParser.AdditiveExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code equalityExpression}
	 * labeled alternative in {@link PWNParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEqualityExpression(PWNParser.EqualityExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code comparisonExpression}
	 * labeled alternative in {@link PWNParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitComparisonExpression(PWNParser.ComparisonExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code multiplicativeExpression}
	 * labeled alternative in {@link PWNParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMultiplicativeExpression(PWNParser.MultiplicativeExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code unaryExpression}
	 * labeled alternative in {@link PWNParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUnaryExpression(PWNParser.UnaryExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link PWNParser#variableValue}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVariableValue(PWNParser.VariableValueContext ctx);
	/**
	 * Visit a parse tree produced by {@link PWNParser#value}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitValue(PWNParser.ValueContext ctx);
	/**
	 * Visit a parse tree produced by {@link PWNParser#literalValue}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLiteralValue(PWNParser.LiteralValueContext ctx);
}