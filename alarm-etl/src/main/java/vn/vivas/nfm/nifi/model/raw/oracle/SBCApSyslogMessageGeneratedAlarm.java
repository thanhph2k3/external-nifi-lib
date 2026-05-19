package vn.vivas.nfm.nifi.model.raw.oracle;

import vn.vivas.nfm.nifi.enums.TrapType;
import vn.vivas.nfm.nifi.model.Alarm;
import vn.vivas.nfm.nifi.model.raw.RawAlarm;

import java.util.Map;

public class SBCApSyslogMessageGeneratedAlarm extends RawAlarm {

    @Override
    public TrapType getTrapType() {
        return TrapType.SBC_AP_SYSLOG_MESSAGE_GENERATED_ALARM;
    }

    @Override
    protected void parseAlarmFromRaw(Map<String, Object> rawObject) {

    }
}