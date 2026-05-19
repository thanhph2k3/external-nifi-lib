package vn.vivas.nfm.nifi.parser;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.Map;

public class RawJsonParser {
    public static Map<String, Object> parseObjectFromString(String rawString) {
        try {
            return new ObjectMapper().readValue(
                    rawString,
                    new TypeReference<Map<String, Object>>() {
                    }
            );
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}
