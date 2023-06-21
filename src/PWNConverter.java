import antlr.PWNBaseVisitor;
import antlr.PWNParser;
import org.antlr.v4.runtime.tree.TerminalNode;

import java.util.*;

public class PWNConverter extends PWNBaseVisitor<String> {
    private final Map<String, String> typesMap = Map.of(
            "int", "int",
            "string", "char*",
            "float", "float",
            "double", "double",
            "bool", "bool",
            "void", "void"
    );
    private Map<String, String> functionReturnTypes = new HashMap<>();

    private String currentFunction;

    private Map<String, String> variableTypes = new HashMap<>();

    public List<String> errors = new ArrayList<>();

    private int forVariablesCount = 0;

    private int indentation = 1;

    private int getRandomNumber() {
        Random random = new Random();
        return 100 + random.nextInt(900); // Generate a random number between 100 and 999;
    }

    private void addError(String message, TerminalNode node) {
        errors.add(String.format(
                "Error: %s (line %d, column %d)",
                message,
                node.getSymbol().getLine(),
                node.getSymbol().getCharPositionInLine() + 1
        ));
    }

    @Override
    public String visitProgram(PWNParser.ProgramContext ctx) {
        StringBuilder code = new StringBuilder();
        code.append("#include <stdio.h>\n#include <stdbool.h>\n\n");

        for (PWNParser.FunctionDefinitionContext function : ctx.functionDefinition())
            code.append(visitFunctionDefinition(function));

        if (ctx.functionDefinition().size() != 0)
            code.append("\n");

        functionReturnTypes.put("main", "int");
        currentFunction = "main";

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

        if (variableTypes.containsKey(id)) {
            addError(String.format("variable \"%s\" already declared", id), ctx.ID());
        } else {
            variableTypes.put(id, ctx.normalType().getText() + "Array");
        }

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

    public Value evaluateArrayLiteral(PWNParser.ArrayLiteralContext ctx, String type) {
        StringBuilder array = new StringBuilder();
        array.append("{");

        int argsCount = ctx.expression().size();
        for (int i = 0; i < argsCount; i++) {
            Value expression = evaluateExpression(ctx.expression(i));
            if (!expression.type.equals(type)) {
                TerminalNode node;
                if (i == 0)
                    node = ctx.LBRACKET();
                else
                    node = ctx.COMMA(i - 1);
                addError(String.format("expression of type \"%s\" found for array of type \"%s\"", expression.type, type), node);
            }
            array.append(expression.text);
            if (i != argsCount - 1)
                array.append(", ");
        }

        array.append("}");
        return new Value(array.toString(), type);
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
        } else if (ctx instanceof PWNParser.AndExpressionContext) {
            return visitAndExpression((PWNParser.AndExpressionContext) ctx);
        } else if (ctx instanceof PWNParser.OrExpressionContext) {
            return visitOrExpression((PWNParser.OrExpressionContext) ctx);
        } else {
            throw new IllegalArgumentException("Unsupported expression: " + ctx.getText());
        }
    }

    public Value evaluateExpression(PWNParser.ExpressionContext ctx) {
        if (ctx instanceof PWNParser.ValueExpressionContext) {
            return evaluateValueExpression((PWNParser.ValueExpressionContext) ctx);
        } else if (ctx instanceof PWNParser.ParenthesizedExpressionContext) {
            return evaluateParenthesizedExpression((PWNParser.ParenthesizedExpressionContext) ctx);
        } else if (ctx instanceof PWNParser.UnaryExpressionContext) {
            return evaluateUnaryExpression((PWNParser.UnaryExpressionContext) ctx);
        } else if (ctx instanceof PWNParser.MultiplicativeExpressionContext) {
            return evaluateMultiplicativeExpression((PWNParser.MultiplicativeExpressionContext) ctx);
        } else if (ctx instanceof PWNParser.AdditiveExpressionContext) {
            return evaluateAdditiveExpression((PWNParser.AdditiveExpressionContext) ctx);
        } else if (ctx instanceof PWNParser.ComparisonExpressionContext) {
            return evaluateComparisonExpression((PWNParser.ComparisonExpressionContext) ctx);
        } else if (ctx instanceof PWNParser.EqualityExpressionContext) {
            return evaluateEqualityExpression((PWNParser.EqualityExpressionContext) ctx);
        } else if (ctx instanceof PWNParser.AndExpressionContext) {
            return evaluateAndExpression((PWNParser.AndExpressionContext) ctx);
        } else if (ctx instanceof PWNParser.OrExpressionContext) {
            return evaluateOrExpression((PWNParser.OrExpressionContext) ctx);
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

        String cType = typesMap.get(type);

        if (variableTypes.containsKey(id)) {
            addError(String.format("variable \"%s\" already declared", id), ctx.ID());
        } else {
            variableTypes.put(id, isArrayType ? type + "Array" : type);
        }

        String value;
        if (ctx.expression() != null) {
            Value expression = evaluateExpression(ctx.expression());
            if (!type.equals(expression.type)) {
                addError(String.format("cannot assign expression of type \"%s\" to variable of type \"%s\"", expression.type, type), ctx.ASSIGN());
            }
            value = expression.text;
        }
        else
            value = evaluateArrayLiteral(ctx.arrayLiteral(), type).text;

        return String.format("%s %s%s = %s;\n", cType, id, isArrayType ? "[]" : "", value);
    }

    @Override
    public String visitAssignment(PWNParser.AssignmentContext ctx) {
        String variableValue = visitVariableValue(ctx.variableValue());

        boolean isArrayAssignment = variableValue.contains("[");
        String id = variableValue;
        if (isArrayAssignment)
            id = id.substring(0, variableValue.indexOf("["));

        if (!variableTypes.containsKey(id)) {
            addError(String.format("cannot assign to undeclared variable \"%s\"", id), ctx.variableValue().ID());
        }

        Value expression = evaluateExpression(ctx.expression());

        String type = variableTypes.get(id);
        if (type != null) {
            if (!type.endsWith("Array") && isArrayAssignment) {
                addError(String.format("cannot use array assignment for non-array variable \"%s\"", id), ctx.variableValue().index().LBRACKET());
            }

            if (type.endsWith("Array") && !isArrayAssignment) {
                addError(String.format("cannot assign to an array variable \"%s\"", id), ctx.variableValue().ID());
            }

            if (type.endsWith("Array")) {
                type = type.substring(0, type.length() - 5);
            }

            if (!type.equals(expression.type)) {
                addError(String.format("cannot assign expression of type \"%s\" to a variable of type \"%s\"", expression.type, type), ctx.variableValue().ID());
            }
        }

        String assignmentType = ctx.assignmentType().getText();

        return String.format("%s %s %s;\n", variableValue, assignmentType, expression.text);
    }

    @Override
    public String visitIncrement(PWNParser.IncrementContext ctx) {
        String variableValue = visitVariableValue(ctx.variableValue());
        String incrementType = ctx.incrementType().getText();

        boolean isArrayIncrement = variableValue.contains("[");
        String id = variableValue;
        if (isArrayIncrement)
            id = id.substring(0, variableValue.indexOf("["));

        if (!variableTypes.containsKey(id)) {
            addError(String.format("cannot increment/decrement undeclared variable \"%s\"", id), ctx.variableValue().ID());
        }

        String type = variableTypes.get(id);
        if (type != null) {
            if (!type.endsWith("Array") && isArrayIncrement) {
                addError(String.format("cannot use array incrementation for non-array variable \"%s\"", id), ctx.variableValue().index().LBRACKET());
            }

            if (type.endsWith("Array") && !isArrayIncrement) {
                addError(String.format("cannot increment/decrement an array variable \"%s\"", id), ctx.variableValue().ID());
            } else {
                if (type.endsWith("Array")) {
                    type = type.substring(0, type.length() - 5);
                }

                if (!type.equals("int") && !type.equals("float")) {
                    addError(String.format("cannot increment/decrement variable of type \"%s\"", type), ctx.variableValue().ID());
                }
            }

        }

        return String.format("%s%s;\n", variableValue, incrementType);
    }

    @Override
    public String visitIndex(PWNParser.IndexContext ctx) {
        Value expression = evaluateExpression(ctx.expression());
        if (!expression.type.equals("int")) {
            addError(String.format("cannot access an array with an expression of type \"%s\"", expression.type), ctx.LBRACKET());
        }

        return String.format("[%s]", expression.text);
    }

    @Override
    public String visitReturnStatement(PWNParser.ReturnStatementContext ctx) {
        String returnType = functionReturnTypes.get(currentFunction);
        if (ctx.expression() == null) {
            if (!returnType.equals("void")) {
                addError(String.format("cannot return an empty expression in a function of return type \"%s\"", returnType), ctx.RETURN());
            }
            return "return;\n";
        }

        Value expression = evaluateExpression(ctx.expression());
        if (!returnType.equals(expression.type)) {
            addError(String.format("cannot return expression of type \"%s\" in a function of return type \"%s\"", expression.type, returnType), ctx.RETURN());
        }

        return String.format("return %s;\n", expression.text);
    }

    @Override
    public String visitIfStatement(PWNParser.IfStatementContext ctx) {
        StringBuilder ifStatement = new StringBuilder();
        Value expression = evaluateExpression(ctx.expression());

        if (!expression.type.equals("bool")) {
            addError(String.format("cannot use expression of type \"%s\" in an if statement", expression.type), ctx.LPAR());
        }

        ifStatement.append("if (").append(expression.text).append(") {\n");
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
        Value expression = evaluateExpression(ctx.expression());

        if (!expression.type.equals("bool")) {
            addError(String.format("cannot use expression of type \"%s\" in an elif statement", expression.type), ctx.LPAR());
        }

        elifStatement.append(" else if (").append(expression.text).append(") {\n");
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
        Value expression = evaluateExpression(ctx.expression());

        if (!expression.type.equals("bool")) {
            addError(String.format("cannot use expression of type \"%s\" in a while statement", expression.type), ctx.LPAR());
        }

        whileBlock.append("while (").append(expression.text).append(") {\n");
        indentation++;
        for (PWNParser.LoopStatementContext statement : ctx.loopStatement()) {
            whileBlock.append("    ".repeat(indentation)).append(visitLoopStatement(statement));
        }
        indentation--;
        whileBlock.append("    ".repeat(indentation)).append("}\n");
        return whileBlock.toString();
    }

    @Override
    public String visitForStatement(PWNParser.ForStatementContext ctx) {
        StringBuilder forBlock = new StringBuilder();
        String id = ctx.ID().getText();
        String type = ctx.normalType().getText();

        String cType = typesMap.get(type);

        if (variableTypes.containsKey(id)) {
            addError(String.format("variable \"%s\" already declared", id), ctx.ID());
        } else {
            variableTypes.put(id, ctx.normalType().getText());
        }

        indentation++;
        if (ctx.iterable().RANGE() != null) {
            String[] range = ctx.iterable().RANGE().getText().split("\\Q..\\E");  // escaping regex
            String min = range[0];
            String max = range[1];
            forBlock.append(String.format("for (%s %s = %s; %s < %s; %s++) {\n", cType, id, min, id, max, id));
        } else {
            String array = ctx.iterable().ID().getText();

            String arrayType = variableTypes.get(array);
            if (arrayType == null) {
                addError(String.format("variable \"%s\" not defined", array), ctx.iterable().ID());
            } else {
                if (!arrayType.endsWith("Array")) {
                    addError(String.format("variable \"%s\" of type \"%s\" is not an iterable", array, arrayType), ctx.iterable().ID());
                } else {
                    arrayType = arrayType.substring(0, arrayType.length() - 5);
                }

                if (!type.equals(arrayType)) {
                    addError(String.format("cannot assign array elements of type \"%s\" to variable \"%s\" of type \"%s\"", arrayType, id, type), ctx.ID());
                }
            }

            String forVariable = String.format("_i%d%d", forVariablesCount++, getRandomNumber());
            String size = String.format("sizeof(%s) / sizeof(%s[0])", array, array);
            forBlock.append(String.format("for (int %s = %d; %s < %s; %s++) {\n", forVariable, 0, forVariable, size, forVariable));
            forBlock.append("    ".repeat(indentation)).append(String.format("%s %s = %s[%s];\n", cType, id, array, forVariable));
        }
        for (PWNParser.LoopStatementContext statement : ctx.loopStatement()) {
            forBlock.append("    ".repeat(indentation)).append(visitLoopStatement(statement));
        }
        indentation--;
        forBlock.append("    ".repeat(indentation)).append("}\n");
        return forBlock.toString();
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
        if (functionReturnTypes.containsKey(name)) {
            addError(String.format("function with the name \"%s\" already defined", name), ctx.ID());
        } else {
            functionReturnTypes.put(name, type.equals("void") ? "void" : ctx.normalType().getText());
        }

        currentFunction = name;

        String argumentsDefinition = visitArgumentsDefinition(ctx.argumentsDefinition());

        function.append(String.format("%s %s(%s) {\n", type, name, argumentsDefinition));

        for (PWNParser.StatementContext statement : ctx.statement())
            function.append("    ".repeat(indentation)).append(visitStatement(statement));

        function.append("}\n");

        variableTypes = new HashMap<>(); // reset the variables

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

            if (variableTypes.containsKey(id)) {
                addError(String.format("argument with the name \"%s\" already declared", id), ctx.ID(i));
            } else {
                variableTypes.put(id, type);
            }
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

    public Value evaluateFunctionCall(PWNParser.FunctionCallContext ctx) {
        String id = ctx.ID().getText();
        String arguments = visitArguments(ctx.arguments());

        String type = functionReturnTypes.get(id);
        if (type == null) {
            addError(String.format("function \"%s\" does not exist", id), ctx.ID());
        }

        return new Value(String.format("%s(%s)", id, arguments), type != null ? type : "undefined");
    }

    @Override
    public String visitOrExpression(PWNParser.OrExpressionContext ctx) {
        String leftExpression = visitExpression(ctx.expression(0));
        String rightExpression = visitExpression(ctx.expression(1));

        return String.format("%s || %s", leftExpression, rightExpression);
    }

    public Value evaluateOrExpression(PWNParser.OrExpressionContext ctx) {
        Value leftExpression = evaluateExpression(ctx.expression(0));
        Value rightExpression = evaluateExpression(ctx.expression(1));

        if (!leftExpression.type.equals("bool") || !rightExpression.type.equals("bool")) {
            addError(String.format("unsupported operator \"or\" between types \"%s\" and \"%s\"", leftExpression.type, rightExpression.type), ctx.OR());
        }

        return new Value(String.format("%s || %s", leftExpression.text, rightExpression.text), "bool");
    }

    @Override
    public String visitValueExpression(PWNParser.ValueExpressionContext ctx) {
        return visitValue(ctx.value());
    }

    public Value evaluateValueExpression(PWNParser.ValueExpressionContext ctx) {
        return evaluateValue(ctx.value());
    }

    @Override
    public String visitAndExpression(PWNParser.AndExpressionContext ctx) {
        String leftExpression = visitExpression(ctx.expression(0));
        String rightExpression = visitExpression(ctx.expression(1));

        return String.format("%s && %s", leftExpression, rightExpression);
    }

    public Value evaluateAndExpression(PWNParser.AndExpressionContext ctx) {
        Value leftExpression = evaluateExpression(ctx.expression(0));
        Value rightExpression = evaluateExpression(ctx.expression(1));

        if (!leftExpression.type.equals("bool") || !rightExpression.type.equals("bool")) {
            addError(String.format("unsupported operator \"and\" between types \"%s\" and \"%s\"", leftExpression.type, rightExpression.type), ctx.AND());
        }

        return new Value(String.format("%s && %s", leftExpression.text, rightExpression.text), "bool");
    }

    @Override
    public String visitParenthesizedExpression(PWNParser.ParenthesizedExpressionContext ctx) {
        return String.format("(%s)", visitExpression(ctx.expression()));
    }

    public Value evaluateParenthesizedExpression(PWNParser.ParenthesizedExpressionContext ctx) {
        Value v = evaluateExpression(ctx.expression());
        v.text = String.format("(%s)", v.text);
        return v;
    }

    @Override
    public String visitAdditiveExpression(PWNParser.AdditiveExpressionContext ctx) {
        String leftExpression = visitExpression(ctx.expression(0));
        String operator = ctx.getChild(1).getText();
        String rightExpression = visitExpression(ctx.expression(1));

        return String.format("%s %s %s", leftExpression, operator, rightExpression);
    }

    public Value evaluateAdditiveExpression(PWNParser.AdditiveExpressionContext ctx) {
        Value leftExpression = evaluateExpression(ctx.expression(0));
        TerminalNode op = (TerminalNode) ctx.getChild(1);
        String operator = op.getText();
        Value rightExpression = evaluateExpression(ctx.expression(1));

        if (!(leftExpression.type.equals("int") || leftExpression.type.equals("float")) || !(rightExpression.type.equals("int") || rightExpression.type.equals("float"))) {
            addError(String.format("unsupported operator \"%s\" between types \"%s\" and \"%s\"", operator, leftExpression.type, rightExpression.type), op);
        }

        return new Value(String.format("%s %s %s", leftExpression.text, operator, rightExpression.text), leftExpression.type);
    }

    @Override
    public String visitEqualityExpression(PWNParser.EqualityExpressionContext ctx) {
        String leftExpression = visitExpression(ctx.expression(0));
        String operator = ctx.getChild(1).getText();
        String rightExpression = visitExpression(ctx.expression(1));

        return String.format("%s %s %s", leftExpression, operator, rightExpression);
    }

    public Value evaluateEqualityExpression(PWNParser.EqualityExpressionContext ctx) {
        Value leftExpression = evaluateExpression(ctx.expression(0));
        TerminalNode op = (TerminalNode) ctx.getChild(1);
        String operator = op.getText();
        Value rightExpression = evaluateExpression(ctx.expression(1));

        if (!(leftExpression.type.equals("int") || leftExpression.type.equals("float")) || !(rightExpression.type.equals("int") || rightExpression.type.equals("float"))) {
            addError(String.format("unsupported operator \"%s\" between types \"%s\" and \"%s\"", operator, leftExpression.type, rightExpression.type), op);
        }

        return new Value(String.format("%s %s %s", leftExpression.text, operator, rightExpression.text), "bool");
    }

    @Override
    public String visitComparisonExpression(PWNParser.ComparisonExpressionContext ctx) {
        String leftExpression = visitExpression(ctx.expression(0));
        String operator = ctx.getChild(1).getText();
        String rightExpression = visitExpression(ctx.expression(1));

        return String.format("%s %s %s", leftExpression, operator, rightExpression);
    }

    public Value evaluateComparisonExpression(PWNParser.ComparisonExpressionContext ctx) {
        Value leftExpression = evaluateExpression(ctx.expression(0));
        TerminalNode op = (TerminalNode) ctx.getChild(1);
        String operator = op.getText();
        Value rightExpression = evaluateExpression(ctx.expression(1));

        if (!(leftExpression.type.equals("int") || leftExpression.type.equals("float")) || !(rightExpression.type.equals("int") || rightExpression.type.equals("float"))) {
            addError(String.format("unsupported operator \"%s\" between types \"%s\" and \"%s\"", operator, leftExpression.type, rightExpression.type), op);
        }

        return new Value(String.format("%s %s %s", leftExpression.text, operator, rightExpression.text), "bool");
    }

    @Override
    public String visitMultiplicativeExpression(PWNParser.MultiplicativeExpressionContext ctx) {
        String leftExpression = visitExpression(ctx.expression(0));
        String operator = ctx.getChild(1).getText();
        String rightExpression = visitExpression(ctx.expression(1));

        return String.format("%s %s %s", leftExpression, operator, rightExpression);
    }

    public Value evaluateMultiplicativeExpression(PWNParser.MultiplicativeExpressionContext ctx) {
        Value leftExpression = evaluateExpression(ctx.expression(0));
        TerminalNode op = (TerminalNode) ctx.getChild(1);
        String operator = op.getText();
        Value rightExpression = evaluateExpression(ctx.expression(1));

        if (!(leftExpression.type.equals("int") || leftExpression.type.equals("float")) || !(rightExpression.type.equals("int") || rightExpression.type.equals("float"))) {
            addError(String.format("unsupported operator \"%s\" between types \"%s\" and \"%s\"", operator, leftExpression.type, rightExpression.type), op);
        }

        return new Value(String.format("%s %s %s", leftExpression.text, operator, rightExpression.text), leftExpression.type);
    }

    @Override
    public String visitUnaryExpression(PWNParser.UnaryExpressionContext ctx) {
        String operator = ctx.getChild(0).getText();
        String expression = visitExpression(ctx.expression());
        return operator + expression;
    }

    public Value evaluateUnaryExpression(PWNParser.UnaryExpressionContext ctx) {
        TerminalNode op = (TerminalNode) ctx.getChild(0);
        String operator = op.getText();
        Value expression = evaluateExpression(ctx.expression());
        if (!((expression.type.equals("int") || expression.type.equals("float")) && operator.equals("-")) && !(expression.type.equals("bool") && operator.equals("!"))) {
            addError(String.format("unsupported operator \"%s\" for type \"%s\"", operator, expression.type), op);
        }
        return new Value(operator + expression.text, expression.type);
    }

    @Override
    public String visitVariableValue(PWNParser.VariableValueContext ctx) {
        String id = ctx.ID().getText();
        if (ctx.index() == null)
            return id;

        return String.format("%s%s", id, visitIndex(ctx.index()));
    }

    public Value evaluateVariableValue(PWNParser.VariableValueContext ctx) {
        String id = ctx.ID().getText();

        String type = variableTypes.get(id);
        if (type == null) {
            addError(String.format("variable \"%s\" not defined", id), ctx.ID());
        }

        if (ctx.index() == null)
            return new Value(id, type != null ? type : "undefined");

        if (type != null && type.endsWith("Array")) {
            type = type.substring(0, type.length() - 5);
        }

        return new Value(String.format("%s%s", id, visitIndex(ctx.index())), type != null ? type : "undefined");
    }

    public Value evaluateValue(PWNParser.ValueContext ctx) {
        if (ctx.variableValue() != null) {
            return evaluateVariableValue(ctx.variableValue());
        } else if (ctx.literalValue() != null) {
            return evaluateLiteralValue(ctx.literalValue());
        } else if (ctx.functionCall() != null) {
            return evaluateFunctionCall(ctx.functionCall());
        } else if (ctx.value() != null) {
            Value v = evaluateValue(ctx.value());
            v.text = String.format("(%s)", v.text);
            return v;
        } else {
            throw new IllegalArgumentException("Unsupported value: " + ctx.getText());
        }
    }

    @Override
    public String visitValue(PWNParser.ValueContext ctx) {
        if (ctx.variableValue() != null) {
            return visitVariableValue(ctx.variableValue());
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

    public Value evaluateLiteralValue(PWNParser.LiteralValueContext ctx) {
        if (ctx.INT() != null)
            return new Value(ctx.getText(), "int");

        if (ctx.FLOAT() != null)
            return new Value(ctx.getText(), "float");

        if (ctx.STRING() != null)
            return new Value(ctx.getText(), "string");

        return new Value(ctx.getText(), "bool");
    }
}
