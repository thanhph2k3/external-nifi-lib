package vn.vivas.nfm.nifi.parsers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import vn.vivas.nfm.nifi.exceptions.ParseException;

import java.util.Map;

public class JsonStringParser {
    private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();

    public static Map<String, Object> parseObjectFromString(String rawString) {
        if (rawString == null || rawString.isBlank()) {
            throw new ParseException("rawString cannot be null or blank");
        }

        try {
            return OBJECT_MAPPER.readValue(
                    rawString,
                    new TypeReference<Map<String, Object>>() {
                    }
            );
        } catch (JsonProcessingException e) {
            throw new ParseException(e.getMessage());
        }
    }
}