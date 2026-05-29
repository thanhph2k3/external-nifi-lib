package vn.vivas.nfm.nifi.mappers;

import vn.vivas.nfm.nifi.models.StandardizedAlarm;
import vn.vivas.nfm.nifi.models.AlarmSNMPTrap;

public interface Mapper {
    StandardizedAlarm map(AlarmSNMPTrap alarmSNMPTrap);
}