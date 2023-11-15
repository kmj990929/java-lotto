package calculator.model;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

public class ExpressionValidator {
    private static final List<String> VALID_OPERATOR = Arrays.asList("+", "-", "*", "/");
    private static final String ERR_EMPTY_EXPRESSION = "Empty input values are not allowed.";
    private static final String ERR_INVALID_SYMBOL = "Only the following symbols can be used: " + VALID_OPERATOR;
    private static final String ERR_INVALID_EXPRESSION = "Expression is not valid.";

    public static void validate(String expression) {
        if (expression == null || expression.isBlank()) {
            throw new IllegalArgumentException(ERR_EMPTY_EXPRESSION);
        }

        if (containsInvalidSymbol(expression)) {
            throw new IllegalArgumentException(ERR_INVALID_SYMBOL);
        }

        if (checkNumberOnEdge(expression)) {
            throw new IllegalArgumentException(ERR_INVALID_EXPRESSION);
        }
    }

    private static boolean containsInvalidSymbol(String expression) {
        return Pattern.compile("[^0-9+\\-*/]").matcher(expression).find();
    }

    private static boolean checkNumberOnEdge(String expression) {
        if (Expression.isNumeric(Expression.split(expression).get(-1))) {
            return true;
        }
        if (Expression.isNumeric(Expression.split(expression).get(0))) {
            return true;
        }
        return false;
    }
}
