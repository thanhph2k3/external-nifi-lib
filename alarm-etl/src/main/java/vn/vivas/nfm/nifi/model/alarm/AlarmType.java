package vn.vivas.nfm.nifi.model.alarm;

public enum AlarmType {

    ACTIVE_ALARM("Alarm", 1),
    ALERT_ALARM("Alert", 2);

    private final int alarmType;
    private final String alarmTypeLabel;

    AlarmType(String alarmTypeLabel, int alarmType) {
        this.alarmType = alarmType;
        this.alarmTypeLabel = alarmTypeLabel;
    }

    public int toInteger() {
        return alarmType;
    }

    @Override
    public String toString() {
        return alarmTypeLabel;
    }
}
