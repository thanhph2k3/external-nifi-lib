package vn.vivas.nfm.nifi.mapper.oracle;

import vn.vivas.nfm.nifi.enums.TrapType;
import vn.vivas.nfm.nifi.mapper.AlarmMapper;
import vn.vivas.nfm.nifi.model.Alarm;
import vn.vivas.nfm.nifi.model.raw.oracle.SBCApSysMgmtSAStatusChangeAlarm;

public class SBCApSysMgmtSAStatusChangeAlarmMapper implements AlarmMapper<SBCApSysMgmtSAStatusChangeAlarm> {
    @Override
    public TrapType getTrapType() {
        return TrapType.SBC_AP_SYS_MGMT_SA_STATUS_CHANGE;
    }

    @Override
    public Class<SBCApSysMgmtSAStatusChangeAlarm> getRawAlarmClass() {
        return SBCApSysMgmtSAStatusChangeAlarm.class;
    }

    @Override
    public Alarm map(SBCApSysMgmtSAStatusChangeAlarm alarm) {
        return new Alarm();
    }
}
