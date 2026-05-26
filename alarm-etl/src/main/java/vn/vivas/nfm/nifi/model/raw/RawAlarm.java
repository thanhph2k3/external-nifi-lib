package vn.vivas.nfm.nifi.model.raw;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.ObjectMapper;
import vn.vivas.nfm.nifi.handler.support.SnmpTrapSupport;

import java.util.Map;

public abstract class RawAlarm {

    protected static final String OID_SNMP_TRAP_NAME = "1.3.6.1.6.3.1.1.4.1.0";
    protected static final String OID_SYS_UP_TIME_INSTANCE = "1.3.6.1.2.1.1.3.0";
    protected static final String OID_PEER_ADDRESS = "peerAddress";
    protected static final String OID_REQUEST_ID = "requestID";
    protected static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();

    @JsonProperty("snmpTrapName")
    protected String snmpTrapName;

    @JsonProperty("sysUpTimeInstance")
    protected String sysUpTimeInstance;

    @JsonProperty("requestID")
    protected String requestID;

    @JsonProperty("peerAddress")
    protected String peerAddress;

    @JsonProperty("rawData")
    protected String rawData;

    public RawAlarm(Map<String, Object> rawObject) {
        try {
            this.rawData = OBJECT_MAPPER.writeValueAsString(rawObject);
        } catch (Exception e) {
            this.rawData = rawObject.toString();
        }
    }

    protected String parseFieldValue(Object value) {
        return value == null ? null : String.valueOf(value);
    }

    protected boolean parseCommonField(String oid, Object value) {
        String fieldValue = parseFieldValue(value);
        switch (oid) {
            case OID_SNMP_TRAP_NAME -> this.snmpTrapName = fieldValue;
            case OID_SYS_UP_TIME_INSTANCE -> this.sysUpTimeInstance = fieldValue;
            case OID_PEER_ADDRESS -> this.peerAddress = fieldValue;
            case OID_REQUEST_ID -> this.requestID = fieldValue;
            default -> {
                return false;
            }
        }

        return true;
    }

    protected abstract void parseAlarmFromRaw(Map<String, Object> rawObject);

    public String getPeerAddress() {
        return peerAddress;
    }

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
