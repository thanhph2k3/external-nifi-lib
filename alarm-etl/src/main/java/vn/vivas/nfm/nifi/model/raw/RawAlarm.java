package vn.vivas.nfm.nifi.model.raw;

import com.fasterxml.jackson.annotation.JsonProperty;
import vn.vivas.nfm.nifi.enums.TrapType;
import vn.vivas.nfm.nifi.model.Alarm;
import vn.vivas.nfm.nifi.validator.SNMPValidator;

import java.util.Map;

public abstract class RawAlarm {

    protected static final String OID_SNMP_TRAP_NAME = "1.3.6.1.6.3.1.1.4.1.0";
    protected static final String OID_SYS_UP_TIME_INSTANCE = "1.3.6.1.2.1.1.3.0";
    protected static final String OID_REQUEST_ID = "requestID";

    @JsonProperty("snmpTrapName")
    protected String snmpTrapName;

    @JsonProperty("sysUpTimeInstance")
    protected String sysUpTimeInstance;

    @JsonProperty("requestID")
    protected String requestID;

    protected final TrapType trapType;

    protected RawAlarm(TrapType trapType) {
        this.trapType = trapType;
    }

    protected String extractOID(String key) {
        if (!SNMPValidator.isValidSNMPTrapField(key)) {
            return null;
        }

        String[] parts = key.split("\\$");
        if (parts.length < 2) {
            return null;
        }

        return parts[1];
    }

    protected String parseFieldValue(Object value) {
        return value == null ? null : String.valueOf(value);
    }

    protected boolean parseCommonField(String oid, Object value) {
        String fieldValue = parseFieldValue(value);
        switch (oid) {
            case OID_SNMP_TRAP_NAME -> this.snmpTrapName = fieldValue;
            case OID_SYS_UP_TIME_INSTANCE -> this.sysUpTimeInstance = fieldValue;
            case OID_REQUEST_ID -> this.requestID = fieldValue;
            default -> {
                return false;
            }
        }

        return true;
    }

    protected abstract void parseAlarmFromRaw(Map<String, Object> rawObject);

    public TrapType getTrapType() {
        return trapType;
    }
}
