package vn.vivas.nfm.nifi.service;

import vn.vivas.nfm.nifi.model.AlarmSNMPWithRouting;
import vn.vivas.nfm.nifi.model.DecodedAlarm;
import vn.vivas.nfm.nifi.model.ericsson.EricssonDecodedAlarm;
import vn.vivas.nfm.nifi.model.oracle.OracleDecodedAlarm;
import vn.vivas.nfm.nifi.model.tekelec.TekelecDecodedAlarm;

public class AlarmDecodeService {
    public AlarmDecodeService() {

    }

    public DecodedAlarm decode(AlarmSNMPWithRouting alarmSnmpTrapWithRouting) {
        return switch (alarmSnmpTrapWithRouting.alarmEnrichment().getDeviceVendor().getCode()) {
            case "ERICSSON" -> decodeEricssonAlarm(alarmSnmpTrapWithRouting);
            case "TEKELEC" -> decodeTekelecAlarm(alarmSnmpTrapWithRouting);
            case "ORACLE" -> decodeOracleAlarm(alarmSnmpTrapWithRouting);
            default -> throw new IllegalArgumentException("Unknown device vendor");
        };
    }

    private EricssonDecodedAlarm decodeEricssonAlarm(AlarmSNMPWithRouting alarmSnmpTrapWithRouting) {
        return new EricssonDecodedAlarm(alarmSnmpTrapWithRouting);
    }

    private TekelecDecodedAlarm decodeTekelecAlarm(AlarmSNMPWithRouting alarmSnmpTrapWithRouting) {
        return new TekelecDecodedAlarm(alarmSnmpTrapWithRouting);
    }

    private OracleDecodedAlarm decodeOracleAlarm(AlarmSNMPWithRouting alarmSnmpTrapWithRouting) {
        return new OracleDecodedAlarm(alarmSnmpTrapWithRouting);
    }
}