package vn.vivas.nfm.nifi.model.raw;

import com.fasterxml.jackson.annotation.JsonProperty;
import vn.vivas.nfm.nifi.handler.support.SnmpTrapSupport;

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

    @JsonProperty("rawData")
    protected String rawData;

    public RawAlarm(Map<String, Object> rawObject) {
        this.rawData = rawObject.toString();
    }

    protected String extractOID(String key) {
        return SnmpTrapSupport.extractOid(key);
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

    public String getRequestID() {
        return requestID;
    }

    public String getSysUpTimeInstance() {
        return sysUpTimeInstance;
    }

    public String getSnmpTrapName() {
        return snmpTrapName;
    }

    public String getRawData() {
        return rawData;
    }
}
