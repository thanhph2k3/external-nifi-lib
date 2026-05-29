package vn.vivas.nfm.nifi.services.alarm;

import vn.vivas.nfm.nifi.models.DecodedAlarm;
import vn.vivas.nfm.nifi.models.StandardizedAlarm;

public class AlarmStandardizeService {
    public StandardizedAlarm standardize(DecodedAlarm decodedAlarm) {
        return new StandardizedAlarm();
    }
}
