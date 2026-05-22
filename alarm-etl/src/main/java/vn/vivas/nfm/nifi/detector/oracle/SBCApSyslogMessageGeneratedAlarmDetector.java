package vn.vivas.nfm.nifi.detector.oracle;

import vn.vivas.nfm.nifi.detector.TrapDetector;
import vn.vivas.nfm.nifi.enums.TrapType;

import java.util.Map;

public class SBCApSyslogMessageGeneratedAlarmDetector implements TrapDetector {
    @Override
    public TrapType getTrapType() {
        return TrapType.SBC_AP_SYSLOG_MESSAGE_GENERATED_ALARM;
    }

    @Override
    public boolean detect(Map<String, Object> rawObject) {
        return false;
    }
}
