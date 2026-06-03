package vn.vivas.nfm.nifi.model;

import vn.vivas.nfm.nifi.model.alarm.AlarmMetadata;

public abstract class DecodedAlarm {

    protected final AlarmMetadata alarmMetadata;

    public DecodedAlarm(AlarmMetadata alarmMetadata) {
        this.alarmMetadata = alarmMetadata;
    }

    public AlarmMetadata getAlarmMetadata() {
        return alarmMetadata;
    }

    public abstract String toJsonString();
}
