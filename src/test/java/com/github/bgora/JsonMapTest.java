package com.github.bgora;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Map;


class JsonMapTest {

    @Test
    void testJsonMap() throws JsonProcessingException {
        //given
        var settings = Map.of("url", "infobip.com",
                "type", "http",
                "protocol", "ssh");
        var expected = """
               {"url":"infobip.com","type":"http","protocol":"ssh"}""";
        JsonMap map = new JsonMap(settings);

        //when
        var result = map.toJson();

        //then
        Assertions.assertThat(result).contains(expected);

    }

    @Test
    void testJsonString() throws JsonProcessingException {
        //given
        var givenJson = """
               {"type":"http","protocol":"ssh","url":"infobip.com"}""";
        var jsonString = new JsonString(givenJson);

        //when
        var result = jsonString.jsonToMap();

        //then
        Assertions.assertThat(result).extracting("url", "type", "protocol")
                .contains("infobip.com", "http", "ssh");

    }
}