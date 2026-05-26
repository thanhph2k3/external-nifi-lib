package vn.vivas.nfm.nifi.handler.support;

import vn.vivas.nfm.nifi.validator.SNMPValidator;

import java.util.Map;
import java.util.Objects;

public final class SnmpTrapSupport {

    private static final String OID_SNMP_TRAP_NAME = "1.3.6.1.6.3.1.1.4.1.0";

    private SnmpTrapSupport() {
    }

    public static String getTrapType(Map<String, Object> rawObject) {
        if (rawObject == null || rawObject.isEmpty()) {
            return "<empty>";
        }

        String snmpTrapName = valueByOID(rawObject, OID_SNMP_TRAP_NAME);
        if (snmpTrapName != null) {
            return snmpTrapName;
        }

        return "<unknown>";
    }

    public static String extractOID(String key) {
        if (!SNMPValidator.isValidSNMPTrapField(key)) {
            return null;
        }

        String[] parts = key.split("\\$");
        return parts.length < 2 ? null : parts[1];
    }

    public static String valueByOID(Map<String, Object> rawObject, String oid) {
        if (rawObject == null || oid == null || oid.isBlank()) {
            return null;
        }

        return rawObject.entrySet().stream()
                .filter(entry -> Objects.equals(extractOID(entry.getKey()), oid))
                .map(Map.Entry::getValue)
                .filter(Objects::nonNull)
                .map(String::valueOf)
                .findFirst()
                .orElse(null);
    }
}
