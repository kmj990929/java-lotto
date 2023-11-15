package calculator.model;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public enum Operator {
    ADD("+"),
    SUB("-"),
    MUL("*"),
    DIV("/");

    private final String symbol;
    private static final String ERR_INVALID_SYMBOL = "Only the following symbols can be used: " + getAllSymbols();

    Operator(String symbol) {
        this.symbol = symbol;
    }

    public String getSymbol() {
        return symbol;
    }

    public static List<String> getAllSymbols() {
        return Arrays.stream(values())
                .map(Enum::name)
                .collect(Collectors.toList());
    }

    public static Operator getBySymbol(String symbol) {
        return Arrays.stream(values())
                .filter(operator -> operator.getSymbol().equals(symbol))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(ERR_INVALID_SYMBOL));
    }
}
