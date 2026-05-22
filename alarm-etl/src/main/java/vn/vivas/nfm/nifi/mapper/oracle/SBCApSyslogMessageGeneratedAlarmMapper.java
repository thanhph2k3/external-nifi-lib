package vn.vivas.nfm.nifi.mapper.oracle;

import vn.vivas.nfm.nifi.mapper.AlarmMapper;
import vn.vivas.nfm.nifi.model.Alarm;
import vn.vivas.nfm.nifi.model.raw.oracle.SBCApSyslogMessageGeneratedAlarm;

public class SBCApSyslogMessageGeneratedAlarmMapper implements AlarmMapper<SBCApSyslogMessageGeneratedAlarm> {

    @Override
    public Class<SBCApSyslogMessageGeneratedAlarm> getRawAlarmClass() {
        return SBCApSyslogMessageGeneratedAlarm.class;
    }

    @Override
    public Alarm map(SBCApSyslogMessageGeneratedAlarm alarm) {
        return new Alarm();
    }
}
