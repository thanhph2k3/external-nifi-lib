package vn.vivas.nfm.nifi.validator;

import java.util.Objects;

public class SNMPValidator {

    public static boolean isValidSNMPTrapField(String snmpTrapFieldName) {
        if (snmpTrapFieldName == null || snmpTrapFieldName.isBlank()) {
            return false;
        }

        if (snmpTrapFieldName.equals("snmp$requestID")) return true;

        String[] parts = snmpTrapFieldName.split("\\$");

        return parts.length == 3
                && Objects.equals(parts[0], "snmp");
    }
}