import antlr.PWNBaseVisitor;
import antlr.PWNParser;

import java.util.Map;

public class PWNConverter extends PWNBaseVisitor<String> {
    private final Map<String, String> typesMap = Map.of(
            "int", "int",
            "string", "char*",
            "float", "float",
            "double", "double",
            "bool", "bool"
    );

    private int indentation = 1;

    @Override
    public String visitProgram(PWNParser.ProgramContext ctx) {
        StringBuilder code = new StringBuilder();
        code.append("#include <stdio.h>\n#include <stdbool.h>\n\n");

        for (PWNParser.FunctionDefinitionContext function : ctx.functionDefinition())
            code.append(visitFunctionDefinition(function));

        if (ctx.functionDefinition().size() != 0)
            code.append("\n");

        code.append("int main(void) {\n");
        for (PWNParser.StatementContext statement : ctx.statement())
            code.append("    ").append(visitStatement(statement));

        code.append("    return 0;\n}");

        return code.toString();
    }

    @Override
    public String visitStatement(PWNParser.StatementContext ctx) {
        if (ctx.assignment() != null) {
            return visitAssignment(ctx.assignment());
        } else if (ctx.increment() != null) {
            return visitIncrement(ctx.increment());
        } else if (ctx.declaration() != null) {
            return visitDeclaration(ctx.declaration());
        } else if (ctx.arrayDeclaration() != null) {
            return visitArrayDeclaration(ctx.arrayDeclaration());
        } else if (ctx.returnStatement() != null) {
            return visitReturnStatement(ctx.returnStatement());
        } else if (ctx.ifStatement() != null) {
            return visitIfStatement(ctx.ifStatement());
        } else if (ctx.whileStatement() != null) {
            return visitWhileStatement(ctx.whileStatement());
        } else if (ctx.forStatement() != null) {
            return visitForStatement(ctx.forStatement());
        } else {
            throw new IllegalArgumentException("Unsupported statement: " + ctx.getText());
        }
    }

    @Override
    public String visitArrayDeclaration(PWNParser.ArrayDeclarationContext ctx) {
        String type = typesMap.get(ctx.normalType().getText());
        String id = ctx.ID().getText();
        String size = ctx.INT().getText();
        return String.format("%s %s[%s];\n", type, id, size);
    }

    @Override
    public String visitArrayLiteral(PWNParser.ArrayLiteralContext ctx) {
        StringBuilder array = new StringBuilder();
        array.append("{");

        int argsCount = ctx.expression().size();
        for (int i = 0; i < argsCount; i++) {
            array.append(visitExpression(ctx.expression(i)));
            if (i != argsCount - 1)
                array.append(", ");
        }

        array.append("}");
        return array.toString();
    }

    @Override
    public String visitLoopStatement(PWNParser.LoopStatementContext ctx) {
        if (ctx.statement() != null) {
            return visitStatement(ctx.statement());
        } else if (ctx.jumpStatement() != null) {
            return visitJumpStatement(ctx.jumpStatement());
        } else {
            throw new IllegalArgumentException("Unsupported loop statement: " + ctx.getText());
        }
    }

    @Override
    public String visitJumpStatement(PWNParser.JumpStatementContext ctx) {
        return ctx.getText() + "\n";
    }

    public String visitExpression(PWNParser.ExpressionContext ctx) {
        if (ctx instanceof PWNParser.ValueExpressionContext) {
            return visitValueExpression((PWNParser.ValueExpressionContext) ctx);
        } else if (ctx instanceof PWNParser.ParenthesizedExpressionContext) {
            return visitParenthesizedExpression((PWNParser.ParenthesizedExpressionContext) ctx);
        } else if (ctx instanceof PWNParser.UnaryExpressionContext) {
            return visitUnaryExpression((PWNParser.UnaryExpressionContext) ctx);
        } else if (ctx instanceof PWNParser.MultiplicativeExpressionContext) {
            return visitMultiplicativeExpression((PWNParser.MultiplicativeExpressionContext) ctx);
        } else if (ctx instanceof PWNParser.AdditiveExpressionContext) {
            return visitAdditiveExpression((PWNParser.AdditiveExpressionContext) ctx);
        } else if (ctx instanceof PWNParser.ComparisonExpressionContext) {
            return visitComparisonExpression((PWNParser.ComparisonExpressionContext) ctx);
        } else if (ctx instanceof PWNParser.EqualityExpressionContext) {
            return visitEqualityExpression((PWNParser.EqualityExpressionContext) ctx);
        } else if (ctx instanceof PWNParser.InExpressionContext) {
            return visitInExpression((PWNParser.InExpressionContext) ctx);
        } else if (ctx instanceof PWNParser.AndExpressionContext) {
            return visitAndExpression((PWNParser.AndExpressionContext) ctx);
        } else if (ctx instanceof PWNParser.OrExpressionContext) {
            return visitOrExpression((PWNParser.OrExpressionContext) ctx);
        } else {
            throw new IllegalArgumentException("Unsupported expression: " + ctx.getText());
        }
    }

    @Override
    public String visitDeclaration(PWNParser.DeclarationContext ctx) {
        String id = ctx.ID().getText();
        String type = ctx.type().getText();
        boolean isArrayType = type.contains("[]");
        if (isArrayType)
            type = type.substring(0, type.length() - 2);

        type = typesMap.get(type);

        String expression = visitExpression(ctx.expression());

        return String.format("%s %s%s = %s;\n", type, id, isArrayType ? "[]" : "", expression);
    }

    @Override
    public String visitAssignment(PWNParser.AssignmentContext ctx) {
        String variableValue = visitVariableValue(ctx.variableValue());
        String assignmentType = ctx.assignmentType().getText();
        String expression = visitExpression(ctx.expression());

        return String.format("%s %s %s;\n", variableValue, assignmentType, expression);
    }

    @Override
    public String visitIncrement(PWNParser.IncrementContext ctx) {
        String variableValue = visitVariableValue(ctx.variableValue());
        String incrementType = ctx.incrementType().getText();

        return String.format("%s%s;\n", variableValue, incrementType);
    }

    @Override
    public String visitIndex(PWNParser.IndexContext ctx) {
        return String.format("[%s]", visitExpression(ctx.expression()));
    }

    @Override
    public String visitReturnStatement(PWNParser.ReturnStatementContext ctx) {
        if (ctx.expression() == null)
            return "return;\n";

        return String.format("return %s;\n", visitExpression(ctx.expression()));
    }

    @Override
    public String visitIfStatement(PWNParser.IfStatementContext ctx) {
        StringBuilder ifStatement = new StringBuilder();
        ifStatement.append("if (").append(visitExpression(ctx.expression())).append(") {\n");
        indentation++;
        for (PWNParser.StatementContext statement : ctx.statement()) {
            ifStatement.append("    ".repeat(indentation)).append(visitStatement(statement));
        }
        indentation--;
        ifStatement.append("    ".repeat(indentation)).append("}");

        for (PWNParser.ElifStatementContext elif : ctx.elifStatement()) {
            ifStatement.append(visitElifStatement(elif));
        }

        if (ctx.elseStatement() != null)
            ifStatement.append(visitElseStatement(ctx.elseStatement()));

        ifStatement.append("\n");
        return ifStatement.toString();
    }

    @Override
    public String visitElifStatement(PWNParser.ElifStatementContext ctx) {
        StringBuilder elifStatement = new StringBuilder();
        elifStatement.append(" else if (").append(visitExpression(ctx.expression())).append(") {\n");
        indentation++;
        for (PWNParser.StatementContext statement : ctx.statement()) {
            elifStatement.append("    ".repeat(indentation)).append(visitStatement(statement));
        }
        indentation--;
        elifStatement.append("    ".repeat(indentation)).append("}");

        return elifStatement.toString();
    }

    @Override
    public String visitElseStatement(PWNParser.ElseStatementContext ctx) {
        StringBuilder elseStatement = new StringBuilder();
        elseStatement.append(" else {\n");
        indentation++;
        for (PWNParser.StatementContext statement : ctx.statement()) {
            elseStatement.append("    ".repeat(indentation)).append(visitStatement(statement));
        }
        indentation--;
        elseStatement.append("    ".repeat(indentation)).append("}");

        return elseStatement.toString();
    }

    @Override
    public String visitWhileStatement(PWNParser.WhileStatementContext ctx) {
        StringBuilder whileBlock = new StringBuilder();
        whileBlock.append("while (").append(visitExpression(ctx.expression())).append(") {\n");
        indentation++;
        for (PWNParser.LoopStatementContext statement : ctx.loopStatement()) {
            whileBlock.append("    ".repeat(indentation)).append(visitLoopStatement(statement));
        }
        indentation--;
        whileBlock.append("    ".repeat(indentation)).append("}\n");
        return whileBlock.toString();
    }

    @Override
    public String visitIterable(PWNParser.IterableContext ctx) {
        return super.visitIterable(ctx);  // TODO: do this
    }

    @Override
    public String visitForStatement(PWNParser.ForStatementContext ctx) {
        return super.visitForStatement(ctx);  // TODO: do this
    }

    @Override
    public String visitFunctionDefinition(PWNParser.FunctionDefinitionContext ctx) {
        StringBuilder function = new StringBuilder();

        String type;
        if (ctx.normalType() == null)
            type = "void";
        else
            type = typesMap.get(ctx.normalType().getText());

        String name = ctx.ID().getText();
        String argumentsDefinition = visitArgumentsDefinition(ctx.argumentsDefinition());

        function.append(String.format("%s %s(%s) {\n", type, name, argumentsDefinition));

        for (PWNParser.StatementContext statement : ctx.statement())
            function.append("    ".repeat(indentation)).append(visitStatement(statement));

        function.append("}\n");

        return function.toString();
    }

    @Override
    public String visitArgumentsDefinition(PWNParser.ArgumentsDefinitionContext ctx) {
        StringBuilder arguments = new StringBuilder();
        int argsCount = ctx.ID().size();

        for (int i = 0; i < argsCount; i++) {
            String id = ctx.ID(i).getText();
            String type = ctx.type(i).getText();
            boolean isArrayType = type.contains("[]");
            if (isArrayType)
                type = type.substring(0, type.length() - 2);

            type = typesMap.get(type);

            arguments.append(type).append(" ").append(id);
            if (isArrayType)
                arguments.append("[]");

            if (i != argsCount - 1)
                arguments.append(", ");
        }

        return arguments.toString();
    }

    @Override
    public String visitArguments(PWNParser.ArgumentsContext ctx) {
        StringBuilder arguments = new StringBuilder();

        int argsCount = ctx.expression().size();

        for (int i = 0; i < argsCount; i++) {
            arguments.append(visitExpression(ctx.expression(i)));
            if (i != argsCount - 1)
                arguments.append(", ");
        }

        return arguments.toString();
    }

    @Override
    public String visitFunctionCall(PWNParser.FunctionCallContext ctx) {
        String id = ctx.ID().getText();
        String arguments = visitArguments(ctx.arguments());

        return String.format("%s(%s)", id, arguments);
    }

    @Override
    public String visitType(PWNParser.TypeContext ctx) {
        return super.visitType(ctx);  // TODO: do this
    }

    @Override
    public String visitArrayType(PWNParser.ArrayTypeContext ctx) {
        return super.visitArrayType(ctx);  // TODO: do this
    }

    @Override
    public String visitOrExpression(PWNParser.OrExpressionContext ctx) {
        String leftExpression = visitExpression(ctx.expression(0));
        String rightExpression = visitExpression(ctx.expression(1));

        return String.format("%s || %s", leftExpression, rightExpression);
    }

    @Override
    public String visitValueExpression(PWNParser.ValueExpressionContext ctx) {
        return visitValue(ctx.value());
    }

    @Override
    public String visitAndExpression(PWNParser.AndExpressionContext ctx) {
        String leftExpression = visitExpression(ctx.expression(0));
        String rightExpression = visitExpression(ctx.expression(1));

        return String.format("%s && %s", leftExpression, rightExpression);
    }

    @Override
    public String visitInExpression(PWNParser.InExpressionContext ctx) {
        return super.visitInExpression(ctx);  // TODO: do this
    }

    @Override
    public String visitParenthesizedExpression(PWNParser.ParenthesizedExpressionContext ctx) {
        return String.format("(%s)", visitExpression(ctx.expression()));
    }

    @Override
    public String visitAdditiveExpression(PWNParser.AdditiveExpressionContext ctx) {
        String leftExpression = visitExpression(ctx.expression(0));
        String operator = ctx.getChild(1).getText();
        String rightExpression = visitExpression(ctx.expression(1));

        return String.format("%s %s %s", leftExpression, operator, rightExpression);
    }

    @Override
    public String visitEqualityExpression(PWNParser.EqualityExpressionContext ctx) {
        String leftExpression = visitExpression(ctx.expression(0));
        String operator = ctx.getChild(1).getText();
        String rightExpression = visitExpression(ctx.expression(1));

        return String.format("%s %s %s", leftExpression, operator, rightExpression);
    }

    @Override
    public String visitComparisonExpression(PWNParser.ComparisonExpressionContext ctx) {
        String leftExpression = visitExpression(ctx.expression(0));
        String operator = ctx.getChild(1).getText();
        String rightExpression = visitExpression(ctx.expression(1));

        return String.format("%s %s %s", leftExpression, operator, rightExpression);
    }

    @Override
    public String visitMultiplicativeExpression(PWNParser.MultiplicativeExpressionContext ctx) {
        String leftExpression = visitExpression(ctx.expression(0));
        String operator = ctx.getChild(1).getText();
        String rightExpression = visitExpression(ctx.expression(1));

        return String.format("%s %s %s", leftExpression, operator, rightExpression);
    }

    @Override
    public String visitUnaryExpression(PWNParser.UnaryExpressionContext ctx) {
        String operator = ctx.getChild(0).getText();
        String expression = visitExpression(ctx.expression());
        return operator + expression;
    }

    @Override
    public String visitVariableValue(PWNParser.VariableValueContext ctx) {
        String id = ctx.ID().getText();
        if (ctx.index() == null)
            return id;

        return String.format("%s%s", id, visitIndex(ctx.index()));
    }

    @Override
    public String visitValue(PWNParser.ValueContext ctx) {
        if (ctx.variableValue() != null) {
            return visitVariableValue(ctx.variableValue());
        } else if (ctx.arrayLiteral() != null) {
            return visitArrayLiteral(ctx.arrayLiteral());
        } else if (ctx.literalValue() != null) {
            return visitLiteralValue(ctx.literalValue());
        } else if (ctx.functionCall() != null) {
            return visitFunctionCall(ctx.functionCall());
        } else if (ctx.value() != null) {
            return String.format("(%s)", visitValue(ctx.value()));
        } else {
            throw new IllegalArgumentException("Unsupported value: " + ctx.getText());
        }
    }

    @Override
    public String visitLiteralValue(PWNParser.LiteralValueContext ctx) {
        return ctx.getText();
    }
}
