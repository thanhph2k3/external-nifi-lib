package vn.vivas.nfm.nifi.detector.oracle;

import vn.vivas.nfm.nifi.detector.TrapDetector;
import vn.vivas.nfm.nifi.enums.TrapType;

import java.util.Map;

public class SBCApSwCfgActivateNotificationAlarmDetector implements TrapDetector {

    @Override
    public TrapType getTrapType() {
        return TrapType.SBC_AP_SW_CFG_ACTIVATE_NOTIFICATION;
    }

    @Override
    public boolean detect(Map<String, Object> rawObject) {
        return false;
    }
}
