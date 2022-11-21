package com.github.bgora;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;


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
        assertThat(result.isPresent());
        assertThat(result.get()).extracting("url", "type", "protocol")
                .contains("infobip.com", "http", "ssh");

    }

    @Test
    void testJsonStringForEmptyString() {
        //given
        var jsonString = new JsonString();

        //when
        var result = jsonString.jsonToMap();

        //then
        assertThat(result.isEmpty());

    }
}