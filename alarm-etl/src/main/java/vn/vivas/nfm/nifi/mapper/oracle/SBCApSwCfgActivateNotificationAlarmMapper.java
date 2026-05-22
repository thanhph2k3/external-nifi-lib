package vn.vivas.nfm.nifi.mapper.oracle;

import vn.vivas.nfm.nifi.enums.TrapType;
import vn.vivas.nfm.nifi.mapper.AlarmMapper;
import vn.vivas.nfm.nifi.model.Alarm;
import vn.vivas.nfm.nifi.model.raw.oracle.SBCApSwCfgActivateNotificationAlarm;

public class SBCApSwCfgActivateNotificationAlarmMapper implements AlarmMapper<SBCApSwCfgActivateNotificationAlarm> {
    @Override
    public TrapType getTrapType() {
        return TrapType.SBC_AP_SW_CFG_ACTIVATE_NOTIFICATION;
    }

    @Override
    public Class<SBCApSwCfgActivateNotificationAlarm> getRawAlarmClass() {
        return SBCApSwCfgActivateNotificationAlarm.class;
    }

    @Override
    public Alarm map(SBCApSwCfgActivateNotificationAlarm alarm) {
        return null;
    }
}
