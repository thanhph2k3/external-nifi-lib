package vn.vivas.nfm.nifi.model.raw.oracle;

import vn.vivas.nfm.nifi.enums.TrapType;
import vn.vivas.nfm.nifi.model.Alarm;
import vn.vivas.nfm.nifi.model.raw.RawAlarm;

import java.util.Map;

public class SBCApSyslogMessageGeneratedAlarm extends RawAlarm {

    public SBCApSyslogMessageGeneratedAlarm(TrapType trapType, Map<String, Object> rawObject) {
        super(trapType);
        parseAlarmFromRaw(rawObject);
    }

    @Override
    protected void parseAlarmFromRaw(Map<String, Object> rawObject) {

    }
}