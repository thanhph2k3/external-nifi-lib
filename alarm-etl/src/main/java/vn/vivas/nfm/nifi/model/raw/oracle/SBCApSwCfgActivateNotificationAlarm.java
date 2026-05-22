package vn.vivas.nfm.nifi.model.raw.oracle;

import vn.vivas.nfm.nifi.enums.TrapType;
import vn.vivas.nfm.nifi.model.raw.RawAlarm;

import java.util.Map;

public class SBCApSwCfgActivateNotificationAlarm extends RawAlarm {
    @Override
    public TrapType getTrapType() {
        return TrapType.SBC_AP_SW_CFG_ACTIVATE_NOTIFICATION;
    }

    @Override
    protected void parseAlarmFromRaw(Map<String, Object> rawObject) {

    }
}
