package vn.vivas.nfm.nifi.detector.oracle;

import vn.vivas.nfm.nifi.detector.TrapDetector;
import vn.vivas.nfm.nifi.enums.TrapType;

import java.util.Map;

public class SBCApSysMgmtSAStatusChangeAlarmDetector implements TrapDetector {
    @Override
    public TrapType getTrapType() {
        return TrapType.SBC_AP_SYS_MGMT_SA_STATUS_CHANGE;
    }

    @Override
    public boolean detect(Map<String, Object> rawObject) {
        return false;
    }
}
