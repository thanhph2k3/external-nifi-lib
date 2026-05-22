package vn.vivas.nfm.nifi.mapper.oracle;

import vn.vivas.nfm.nifi.enums.TrapType;
import vn.vivas.nfm.nifi.mapper.AlarmMapper;
import vn.vivas.nfm.nifi.model.Alarm;
import vn.vivas.nfm.nifi.model.raw.oracle.SBCApSyslogMessageGeneratedAlarm;

public class SBCApSyslogMessageGeneratedAlarmMapper implements AlarmMapper<SBCApSyslogMessageGeneratedAlarm> {
    @Override
    public TrapType getTrapType() {
        return TrapType.SBC_AP_SYSLOG_MESSAGE_GENERATED_ALARM;
    }

    @Override
    public Class<SBCApSyslogMessageGeneratedAlarm> getRawAlarmClass() {
        return SBCApSyslogMessageGeneratedAlarm.class;
    }

    @Override
    public Alarm map(SBCApSyslogMessageGeneratedAlarm alarm) {
        return new Alarm();
    }
}
