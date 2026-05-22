package vn.vivas.nfm.nifi.mapper.oracle;

import vn.vivas.nfm.nifi.mapper.AlarmMapper;
import vn.vivas.nfm.nifi.model.Alarm;
import vn.vivas.nfm.nifi.model.raw.oracle.SBCApSwCfgActivateNotificationAlarm;

public class SBCApSwCfgActivateNotificationAlarmMapper implements AlarmMapper<SBCApSwCfgActivateNotificationAlarm> {

    @Override
    public Class<SBCApSwCfgActivateNotificationAlarm> getRawAlarmClass() {
        return SBCApSwCfgActivateNotificationAlarm.class;
    }

    @Override
    public Alarm map(SBCApSwCfgActivateNotificationAlarm alarm) {
        return new Alarm();
    }
}
