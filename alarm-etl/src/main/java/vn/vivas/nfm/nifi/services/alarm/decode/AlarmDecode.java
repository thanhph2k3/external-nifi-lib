package vn.vivas.nfm.nifi.services.alarm.decode;

import vn.vivas.nfm.nifi.models.AlarmSNMPTrap;
import vn.vivas.nfm.nifi.models.DecodedAlarm;

public interface AlarmDecode<T extends DecodedAlarm> {
    T decode(AlarmSNMPTrap trap);
}
