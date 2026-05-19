package vn.vivas.nfm.nifi.mapper;

import vn.vivas.nfm.nifi.enums.TrapType;
import vn.vivas.nfm.nifi.model.Alarm;
import vn.vivas.nfm.nifi.model.raw.RawAlarm;

public interface AlarmMapper<T extends RawAlarm> {
    TrapType getTrapType();
    Class<T> getRawAlarmClass();
    Alarm map(T alarm);
}
