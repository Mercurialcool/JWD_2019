package by.vadim.shapesB.validation;

import java.util.regex.Pattern;

public class ValueValidator {
    private static final String REGEX_LONG = "[+-]?(\\d+)";
    private static final String REGEX_DOUBLE = "[+-]?(\\d+)((\\.){1}(\\d+)[fFdD]?)?";

    public boolean isDouble(String doubleAsString) {
        return Pattern.matches(REGEX_DOUBLE, doubleAsString);
    }

    public boolean isLong(String longAsString) {
        return Pattern.matches(REGEX_LONG, longAsString);
    }
}
