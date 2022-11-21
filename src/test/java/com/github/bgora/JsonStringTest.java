package com.github.bgora;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Map;


class JsonStringTest {

    @Test
    void testJsonString() {
        //given
        var givenJson = """
                {"type":"http","protocol":"ssh","url":"infobip.com"}""";
        var jsonString = new JsonString();

        //when
        var result = jsonString.jsonToMap();

        //then
        Assertions.assertThat(result.isPresent());
        Assertions.assertThat(result.get()).extracting("url", "type", "protocol")
                .contains("infobip.com", "http", "ssh");

    }

    @Test
    void testJsonStringForEmptyString() {
        //given
        var jsonString = new JsonString();

        //when
        var result = jsonString.jsonToMap();

        //then
        Assertions.assertThat(result.isEmpty());

    }
}