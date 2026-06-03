package vn.vivas.nfm.nifi.service;

import vn.vivas.nfm.nifi.model.DecodedAlarm;
import vn.vivas.nfm.nifi.model.DecodedAlarmWithRouting;
import vn.vivas.nfm.nifi.model.StandardizedAlarm;
import vn.vivas.nfm.nifi.model.oracle.OracleDecodedAlarm;
import vn.vivas.nfm.nifi.model.tekelec.TekelecDecodedAlarm;

public class AlarmStandardizeService {
    public AlarmStandardizeService() {

    }

    public StandardizedAlarm standardize(DecodedAlarmWithRouting decodedAlarmWithRouting) {
        return switch (decodedAlarmWithRouting.alarmEnrichment().getDeviceVendor().getCode()) {
            case "TEKELEC" -> new StandardizedAlarm((TekelecDecodedAlarm) decodedAlarmWithRouting.decodedAlarm());
            case "ORACLE" -> new StandardizedAlarm((OracleDecodedAlarm) decodedAlarmWithRouting.decodedAlarm());
            default -> throw new IllegalArgumentException("Unknown device vendor");
        };
    }
}