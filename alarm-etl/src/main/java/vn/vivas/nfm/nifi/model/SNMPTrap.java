package vn.vivas.nfm.nifi.model;

import vn.vivas.nfm.nifi.parser.JsonStringParser;

import java.util.HashMap;
import java.util.Map;

public class SNMPTrap {

    public static final String OID_SNMP_TRAP_NAME = "1.3.6.1.6.3.1.1.4.1.0";
    public static final String OID_SYS_UP_TIME_INSTANCE = "1.3.6.1.2.1.1.3.0";
    public static final String OID_PEER_ADDRESS = "peerAddress";
    public static final String OID_REQUEST_ID = "requestID";
    private static final int OIDS_SIZE = 32;

    private String trapName;
    private String systemUpTime;
    private String peerAddress;

    public String getRequestID() {
        return requestID;
    }

    public String getTrapName() {
        return trapName;
    }

    public String getSystemUpTime() {
        return systemUpTime;
    }

    public String getPeerAddress() {
        return peerAddress;
    }

    public Map<String, Object> getOids() {
        return oids;
    }

    private String requestID;
    private Map<String, Object> oids;

    public SNMPTrap(Map<String, Object> trapObject) {
        trapObject.forEach((key, value) -> {
            String[] parts = key.split("\\$");
            if (parts.length > 1 && parts[0].equals("snmp")) {
                switch (parts[1]) {
                    case OID_SNMP_TRAP_NAME -> this.trapName = value.toString();
                    case OID_SYS_UP_TIME_INSTANCE -> this.systemUpTime = value.toString();
                    case OID_PEER_ADDRESS -> this.peerAddress = value.toString();
                    case OID_REQUEST_ID -> this.requestID = value.toString();
                    default -> {
                        if (key.contains(".")) this.putOID(parts[1], value);
                    }
                }
            }
        });
    }

    private void putOID(String key, Object value) {
        if (oids == null) oids = new HashMap<>(SNMPTrap.OIDS_SIZE);
        if (oids.size() >= SNMPTrap.OIDS_SIZE) {
            throw new IllegalArgumentException("OID size exceeded!");
        }
        oids.put(key, value);
    }

    public String toJsonString() {
        return JsonStringParser.toJsonString(this);
    }
}
