package com.alathreon.alabot2;

import tools.jackson.core.JacksonException;
import tools.jackson.core.JsonParser;
import tools.jackson.databind.DeserializationContext;
import tools.jackson.databind.ValueDeserializer;

import java.time.format.DateTimeFormatter;

public class DateTimeFormatterDeserializer extends ValueDeserializer<DateTimeFormatter> {
    @Override
    public DateTimeFormatter deserialize(JsonParser p, DeserializationContext ctxt) throws JacksonException {
        String format = ctxt.readValue(p, String.class);
        return DateTimeFormatter.ofPattern(format);
    }
}
