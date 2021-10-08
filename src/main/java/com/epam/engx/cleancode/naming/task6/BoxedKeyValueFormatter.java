package com.epam.engx.cleancode.naming.task6;

public class BoxedKeyValueFormatter {

    private static final String EDGE_BORDER_INDICATOR = "+";
    private static final String VERTICAL_BORDER_INDICATOR = "|";
    private static final String HORIZONTAL_BORDER_INDICATOR = "-";
    private static final String CONNECTOR_INDICATOR = " _ ";
    private static final String NEW_LINE = "\n";


    public String format(String key, String value) {
        String content = key + CONNECTOR_INDICATOR + value;
        String horizontalLine = getHorizontalLine(content.length());
        return EDGE_BORDER_INDICATOR + horizontalLine + EDGE_BORDER_INDICATOR + NEW_LINE
                + VERTICAL_BORDER_INDICATOR + content + VERTICAL_BORDER_INDICATOR + NEW_LINE
                + EDGE_BORDER_INDICATOR + horizontalLine + EDGE_BORDER_INDICATOR + NEW_LINE;
    }

    private String getHorizontalLine(int length) {
        String result = "";
        for (int i = 0; i < length; i++)
            result += HORIZONTAL_BORDER_INDICATOR;
        return result;
    }
}
