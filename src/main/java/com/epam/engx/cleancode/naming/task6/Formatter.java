package com.epam.engx.cleancode.naming.task6;

public class Formatter {

    private static final String PLUS = "+";
    private static final String PIPE = "|";
    private static final String MINUS = "-";
    private static final String UNDERSCORE = "_";
    private static final String WHITESPACE = " ";
    private static final String NEW_LINE = "\n";
    private static final String UNDERSCORE_SURROUNDED_WITH_SPACES = WHITESPACE + UNDERSCORE + WHITESPACE;


    public String formatKeyValue(String key, String value) {
        String content = key + UNDERSCORE_SURROUNDED_WITH_SPACES + value;
        String minuses = repeatMinus(content.length());
        return PLUS + minuses + PLUS + NEW_LINE
                + PIPE + content + PIPE + NEW_LINE
                + PLUS + minuses + PLUS + NEW_LINE;
    }

    private String repeatMinus(int times) {
        String result = "";
        for (int i = 0; i < times; i++)
            result += MINUS;
        return result;
    }
}
