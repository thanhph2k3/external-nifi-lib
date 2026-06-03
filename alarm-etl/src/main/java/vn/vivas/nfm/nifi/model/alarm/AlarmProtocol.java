package vn.vivas.nfm.nifi.model.alarm;

public enum AlarmProtocol {
    SNMP_PROTOCOL("SNMP_PROTOCOL", 0),
    HTTP_PROTOCOL("HTTP_PROTOCOL", 1),
    OTHER_PROTOCOL("OTHER_PROTOCOL", 2);

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
