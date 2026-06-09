package vn.vivas.nfm.nifi.parser;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import vn.vivas.nfm.nifi.exception.ParseException;
import vn.vivas.nfm.nifi.model.AlarmSNMPTrap;

import java.util.List;
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

    public static <T> List<T> parseObjectsFromString(
            String rawString,
            Class<T> clazz) {

        if (rawString == null || rawString.isBlank()) {
            throw new ParseException("rawString cannot be null or blank");
        }

        try {
            List<Map<String, Object>> data = OBJECT_MAPPER.readValue(
                    rawString,
                    new TypeReference<List<Map<String, Object>>>() {}
            );

            return data.stream()
                    .map(item -> OBJECT_MAPPER.convertValue(item, clazz))
                    .toList();

        } catch (JsonProcessingException e) {
            throw new ParseException(e.getMessage());
        }
    }

    public static String toJsonString(Map<String, Object> map) {
        try {
            return OBJECT_MAPPER.writeValueAsString(map);
        } catch (JsonProcessingException e) {
            throw new ParseException(e.getMessage());
        }
    }

    public static String toJsonString(Object object) {
        try {
            return OBJECT_MAPPER.writeValueAsString(object);
        } catch (JsonProcessingException e) {
            throw new ParseException(e.getMessage());
        }
    }

    public static String toJsonString(AlarmSNMPTrap alarmSnmpTrap) {
        try {
            Map<String, Object> snmpTrapMap =
                    OBJECT_MAPPER.convertValue(
                            alarmSnmpTrap.getOids(),
                            new TypeReference<>() {
                            }
                    );
            snmpTrapMap.put(AlarmSNMPTrap.OID_INGEST_TIME_MS, alarmSnmpTrap.getIngestTime());
            snmpTrapMap.put(AlarmSNMPTrap.OID_SNMP_TRAP_NAME, alarmSnmpTrap.getTrapName());
            snmpTrapMap.put(AlarmSNMPTrap.OID_PEER_ADDRESS, alarmSnmpTrap.getPeerAddress());
            snmpTrapMap.put(AlarmSNMPTrap.OID_REQUEST_ID, alarmSnmpTrap.getRequestID());
            snmpTrapMap.put(AlarmSNMPTrap.OID_SYS_UP_TIME_INSTANCE, alarmSnmpTrap.getSystemUpTime());
            return OBJECT_MAPPER.writeValueAsString(snmpTrapMap);
        } catch (JsonProcessingException e) {
            throw new ParseException(e.getMessage());
        }
    }
}