package vn.vivas.nfm.nifi.model;

import lombok.Getter;
import vn.vivas.nfm.nifi.model.alarm.AlarmMetadata;

@Getter
public abstract class DecodedAlarm {

    protected final AlarmMetadata alarmMetadata;

    public DecodedAlarm(AlarmMetadata alarmMetadata) {
        this.alarmMetadata = alarmMetadata;
    }

    public abstract String toJsonString();
}
