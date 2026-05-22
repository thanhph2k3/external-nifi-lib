package vn.vivas.nfm.nifi.model.raw.oracle;

import vn.vivas.nfm.nifi.enums.TrapType;
import vn.vivas.nfm.nifi.model.raw.RawAlarm;

import java.util.Map;

public class SBCApSwCfgActivateNotificationAlarm extends RawAlarm {
    public SBCApSwCfgActivateNotificationAlarm(TrapType trapType, Map<String, Object> rawObject) {
        super(trapType);
        parseAlarmFromRaw(rawObject);
    }

    @Override
    protected void parseAlarmFromRaw(Map<String, Object> rawObject) {

    }
}
