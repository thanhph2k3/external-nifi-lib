package vn.vivas.nfm.nifi.model;

public enum AlarmProtocol {
    SNMP_PROTOCOL("SNMP_PROTOCOL", 0),
    OTHER_PROTOCOL("OTHER_PROTOCOL", 1);

    private final int alarmProtocol;
    private final String alarmProtocolLabel;

    AlarmProtocol(String alarmProtocolLabel, int alarmProtocol) {
        this.alarmProtocol = alarmProtocol;
        this.alarmProtocolLabel = alarmProtocolLabel;
    }

    public int toInteger() {
        return alarmProtocol;
    }

    @Override
    public String toString() {
        return alarmProtocolLabel;
    }
}
