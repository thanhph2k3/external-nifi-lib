package vn.vivas.nfm.nifi.mapper;

import vn.vivas.nfm.nifi.model.Alarm;
import vn.vivas.nfm.nifi.model.raw.RawAlarm;

public interface AlarmMapper<T extends RawAlarm> {

    Class<T> getRawAlarmClass();

    Alarm map(T alarm);

    default  Alarm mapRaw(RawAlarm alarm) {
        return map(getRawAlarmClass().cast(alarm));
    }
}
