package vn.vivas.nfm.nifi.mapper.oracle;

import vn.vivas.nfm.nifi.mapper.AlarmMapper;
import vn.vivas.nfm.nifi.model.Alarm;
import vn.vivas.nfm.nifi.model.raw.oracle.SBCApSysMgmtSAStatusChangeAlarm;

public class SBCApSysMgmtSAStatusChangeAlarmMapper implements AlarmMapper<SBCApSysMgmtSAStatusChangeAlarm> {

    @Override
    public Class<SBCApSysMgmtSAStatusChangeAlarm> getRawAlarmClass() {
        return SBCApSysMgmtSAStatusChangeAlarm.class;
    }

    @Override
    public Alarm map(SBCApSysMgmtSAStatusChangeAlarm alarm) {
        return new Alarm();
    }
}
