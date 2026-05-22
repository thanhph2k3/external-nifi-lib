package vn.vivas.nfm.nifi.handler;

import vn.vivas.nfm.nifi.exception.AlarmMappingException;
import vn.vivas.nfm.nifi.model.Alarm;
import vn.vivas.nfm.nifi.model.TrapID;
import vn.vivas.nfm.nifi.model.raw.RawAlarm;

import java.util.Map;
import java.util.Objects;

public interface AlarmTrapHandler<T extends RawAlarm> {

    TrapID trapId();

    Class<T> rawAlarmClass();

    boolean supports(Map<String, Object> rawObject);

    T parse(Map<String, Object> rawObject);

    Alarm map(T rawAlarm);

    default Alarm transform(Map<String, Object> rawObject) {
        Objects.requireNonNull(rawObject, "rawObject must not be null");
        T rawAlarm = Objects.requireNonNull(parse(rawObject), "rawAlarm must not be null");
        Alarm alarm = map(rawAlarm);
        if (alarm == null) {
            throw new AlarmMappingException("Mapper returned null for trap " + trapId());
        }
        return alarm;
    }
}
