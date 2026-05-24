package vn.vivas.nfm.nifi.handler.support;

import vn.vivas.nfm.nifi.validator.SNMPValidator;

import java.util.Map;
import java.util.Objects;

public final class SnmpTrapSupport {

    private static final String FIELD_TRAP_NAME = "trap_name";
    private static final String OID_SNMP_TRAP_NAME = "1.3.6.1.6.3.1.1.4.1.0";

    private SnmpTrapSupport() {
    }

    public static String describeTrap(Map<String, Object> rawObject) {
        if (rawObject == null || rawObject.isEmpty()) {
            return "<empty>";
        }

        String trapName = value(rawObject, FIELD_TRAP_NAME);
        if (trapName != null) {
            return trapName;
        }

        String snmpTrapName = valueByOid(rawObject, OID_SNMP_TRAP_NAME);
        if (snmpTrapName != null) {
            return snmpTrapName;
        }

        return "<unknown>";
    }

    public static String extractOid(String key) {
        if (!SNMPValidator.isValidSNMPTrapField(key)) {
            return null;
        }

        String[] parts = key.split("\\$");
        return parts.length < 2 ? null : parts[1];
    }

    public static String valueByOid(Map<String, Object> rawObject, String oid) {
        if (rawObject == null || oid == null || oid.isBlank()) {
            return null;
        }

        return rawObject.entrySet().stream()
                .filter(entry -> Objects.equals(extractOid(entry.getKey()), oid))
                .map(Map.Entry::getValue)
                .filter(Objects::nonNull)
                .map(String::valueOf)
                .findFirst()
                .orElse(null);
    }

    private static String value(Map<String, Object> rawObject, String fieldName) {
        Object value = rawObject.get(fieldName);
        return value == null ? null : String.valueOf(value);
    }
}
