package vn.vivas.nfm.nifi.services.alarm;

import vn.vivas.nfm.nifi.models.SerializedAlarm;
import vn.vivas.nfm.nifi.models.StandardizedAlarm;

public class AlarmSerializeService {
    public SerializedAlarm serialize(StandardizedAlarm alarm) {
        return new SerializedAlarm();
    }
}
