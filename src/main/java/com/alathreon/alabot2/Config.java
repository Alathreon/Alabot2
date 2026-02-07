package com.alathreon.alabot2;

import tools.jackson.databind.annotation.JsonDeserialize;

import java.time.format.DateTimeFormatter;

public record Config(String token, long statusUpdateChannel, @JsonDeserialize(using = DateTimeFormatterDeserializer.class) DateTimeFormatter shortDateTimeFormat) {
}
