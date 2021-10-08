package com.epam.engx.cleancode.naming.task6;

public class BoxedKeyValueFormatter {

    private static final String EDGE_INDICATOR = "+";
    private static final String BORDER_INDICATOR = "|";
    private static final String LINE_INDICATOR = "-";
    private static final String CONNECTOR_INDICATOR = " _ ";
    private static final String NEW_LINE = "\n";


    public String format(String key, String value) {
        String content = key + CONNECTOR_INDICATOR + value;
        String line = generateHorizontalSegment(content.length());
        return EDGE_INDICATOR + line + EDGE_INDICATOR + NEW_LINE
                + BORDER_INDICATOR + content + BORDER_INDICATOR + NEW_LINE
                + EDGE_INDICATOR + line + EDGE_INDICATOR + NEW_LINE;
    }

    private String generateHorizontalSegment(int length) {
        String result = "";
        for (int i = 0; i < length; i++)
            result += LINE_INDICATOR;
        return result;
    }
}
