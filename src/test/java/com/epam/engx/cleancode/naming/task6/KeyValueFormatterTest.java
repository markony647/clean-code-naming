package com.epam.engx.cleancode.naming.task6;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class KeyValueFormatterTest {
    @Test
    public void shouldFormatKeyValue() {
        assertEquals(
                "+-------------+\n" +
                "|enable _ true|\n" +
                "+-------------+\n",
                new KeyValueFormatter().format("enable", "true"));
        assertEquals(
                "+----------+\n" +
                "|name _ Bob|\n" +
                "+----------+\n",
                new KeyValueFormatter().format("name", "Bob"));
    }
}
