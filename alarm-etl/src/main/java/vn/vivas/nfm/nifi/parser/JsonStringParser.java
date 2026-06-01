package vn.vivas.nfm.nifi.parser;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import vn.vivas.nfm.nifi.exception.ParseException;
import vn.vivas.nfm.nifi.model.SNMPTrap;

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
                    new TypeReference<>() {
                    }
            );
        } catch (JsonProcessingException e) {
            throw new ParseException(e.getMessage());
        }
    }

    public static String toJsonString(SNMPTrap snmpTrap) {
        try {
            Map<String, Object> snmpTrapMap =
                    OBJECT_MAPPER.convertValue(
                            snmpTrap,
                            new TypeReference<>() {
                            }
                    );
            snmpTrapMap.put(SNMPTrap.OID_SNMP_TRAP_NAME, snmpTrap.getTrapName());
            snmpTrapMap.put(SNMPTrap.OID_PEER_ADDRESS, snmpTrap.getPeerAddress());
            snmpTrapMap.put(SNMPTrap.OID_REQUEST_ID, snmpTrap.getRequestID());
            snmpTrapMap.put(SNMPTrap.OID_SYS_UP_TIME_INSTANCE, snmpTrap.getSystemUpTime());
            return OBJECT_MAPPER.writeValueAsString(snmpTrap.getOids());
        } catch (JsonProcessingException e) {
            throw new ParseException(e.getMessage());
        }
    }
}