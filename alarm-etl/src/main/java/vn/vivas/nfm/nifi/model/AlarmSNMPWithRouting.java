package vn.vivas.nfm.nifi.model;

import vn.vivas.nfm.nifi.model.alarm.AlarmEnrichment;

public record AlarmSNMPWithRouting(AlarmSNMPTrap alarmSNMPTrap, AlarmEnrichment alarmEnrichment) {
}
