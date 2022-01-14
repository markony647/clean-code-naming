package com.epam.engx.cleancode.naming.task6;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BoxedKeyValueFormatterTest {
    @Test
    public void shouldFormatKeyValue() {
        assertEquals(
                "+-------------+\n" +
                "|enable _ true|\n" +
                "+-------------+\n",
                new BoxedKeyValueFormatter().format("enable", "true"));
        assertEquals(
                "+----------+\n" +
                "|name _ Bob|\n" +
                "+----------+\n",
                new BoxedKeyValueFormatter().format("name", "Bob"));
    }
}
