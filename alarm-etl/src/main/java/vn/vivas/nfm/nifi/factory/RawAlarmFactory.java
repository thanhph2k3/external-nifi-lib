package vn.vivas.nfm.nifi.factory;

import vn.vivas.nfm.nifi.detector.TrapDetector;
import vn.vivas.nfm.nifi.enums.TrapType;
import vn.vivas.nfm.nifi.exception.UnsupportedTrapException;
import vn.vivas.nfm.nifi.model.raw.RawAlarm;
import vn.vivas.nfm.nifi.model.raw.oracle.SBCApSwCfgActivateNotificationAlarm;
import vn.vivas.nfm.nifi.model.raw.oracle.SBCApSysMgmtSAStatusChangeAlarm;
import vn.vivas.nfm.nifi.model.raw.oracle.SBCApSyslogMessageGeneratedAlarm;

import java.util.List;
import java.util.Map;
import java.util.Objects;

public class RawAlarmFactory {

    private final List<TrapDetector> trapDetectors;

    public RawAlarmFactory(List<TrapDetector> detectors) {
        this.trapDetectors = List.copyOf(Objects.requireNonNull(detectors, "detectors must not be null"));
    }

    public RawAlarm create(Map<String, Object> rawObject) {
        Objects.requireNonNull(rawObject, "rawAlarm must not be null");
        TrapType trapType = detectTrapType(rawObject);
        return createByTrapType(trapType, rawObject);
    }

    private TrapType detectTrapType(Map<String, Object> rawObject) {
        TrapDetector matchedTrapDetector = trapDetectors.stream()
                .filter(trapDetector -> trapDetector.detect(rawObject))
                .findFirst()
                .orElse(null);
        if (matchedTrapDetector == null) {
            throw new UnsupportedTrapException("Raw alarm type " + rawObject.get("type") + " is not supported");
        }
        return matchedTrapDetector.getTrapType();
    }

    private RawAlarm createByTrapType(TrapType trapType, Map<String, Object> rawObject) {
        return switch (trapType) {
            case SBC_AP_SYS_MGMT_SA_STATUS_CHANGE ->  new SBCApSysMgmtSAStatusChangeAlarm(trapType, rawObject);
            case SBC_AP_SYSLOG_MESSAGE_GENERATED_ALARM ->   new SBCApSyslogMessageGeneratedAlarm(trapType, rawObject);
            case SBC_AP_SW_CFG_ACTIVATE_NOTIFICATION -> new SBCApSwCfgActivateNotificationAlarm(trapType, rawObject);
            default ->  throw new UnsupportedTrapException("Raw alarm type " + trapType + " is not supported");
        };
    }
}
