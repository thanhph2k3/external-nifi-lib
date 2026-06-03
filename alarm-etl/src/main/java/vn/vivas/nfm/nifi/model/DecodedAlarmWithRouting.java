package vn.vivas.nfm.nifi.model;

import vn.vivas.nfm.nifi.model.alarm.AlarmEnrichment;

public record DecodedAlarmWithRouting(DecodedAlarm decodedAlarm, AlarmEnrichment alarmEnrichment) {
}
