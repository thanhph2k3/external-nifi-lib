package vn.vivas.nfm.nifi.parser;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import vn.vivas.nfm.nifi.exception.RawAlarmParseException;

import java.util.Map;

public class RawJsonParser {

    private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();

    public static Map<String, Object> parseObjectFromString(String rawString) {
        if (rawString == null || rawString.isBlank()) {
            throw new RawAlarmParseException("Raw JSON must not be blank");
        }

        try {
            return OBJECT_MAPPER.readValue(
                    rawString,
                    new TypeReference<Map<String, Object>>() {
                    }
            );
        } catch (JsonProcessingException e) {
            throw new RawAlarmParseException("Invalid raw JSON", e);
        }
    }
}
