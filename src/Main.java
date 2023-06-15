import antlr.PWNLexer;
import antlr.PWNParser;

import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        PWNParser parser = getParser("examples/simple.pwn");

        ParseTree tree = parser.program();

        PWNConverter converter = new PWNConverter();
        String result = converter.visit(tree);
        System.out.println(result);
    }

    private static PWNParser getParser(String fileName) throws IOException {
        CharStream input = CharStreams.fromFileName(fileName);
        PWNLexer lexer = new PWNLexer(input);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        return new PWNParser(tokens);
    }
}