import org.antlr.v4.runtime.BaseErrorListener;
import org.antlr.v4.runtime.RecognitionException;
import org.antlr.v4.runtime.Recognizer;
import org.antlr.v4.runtime.Token;

import java.util.ArrayList;
import java.util.List;

public class PWNErrorListener extends BaseErrorListener {
    public static List<String> errors = new ArrayList<>();
    @Override
    public void syntaxError(Recognizer<?, ?> recognizer, Object offendingSymbol, int line, int charPositionInLine, String msg, RecognitionException e) {
        Token offendingToken = (Token) offendingSymbol;
        errors.add(String.format(
                "Syntax Error: \"%s\" at line %d, column %d (%s)",
                offendingToken.getText(),
                line,
                charPositionInLine + 1,
                msg
        ));
    }
}
