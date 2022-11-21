package com.github.bgora;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Map;


class JsonMapTest {

    @Test
    void testJsonMap() {
        //given
        var settings = Map.of("url", "infobip.com",
                "type", "http",
                "protocol", "ssh");
        var expected = """
                {"url":"infobip.com","type":"http","protocol":"ssh"}""";
        JsonMap map = new JsonMap();

        //when
        var result = map.toJson();

        //then
        Assertions.assertThat(result).contains(expected);

    }

    @Test
    void testJsonMapForEmptyMap() {
        //given
        JsonMap map = new JsonMap();

        //when
        var result = map.toJson();

        //then
        Assertions.assertThat(result.isEmpty());

    }

}