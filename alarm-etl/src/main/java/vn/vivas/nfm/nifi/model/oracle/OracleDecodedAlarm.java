package vn.vivas.nfm.nifi.model.oracle;

import vn.vivas.nfm.nifi.model.AlarmSNMPWithRouting;
import vn.vivas.nfm.nifi.model.DecodedAlarm;
import vn.vivas.nfm.nifi.model.alarm.AlarmMetadata;

public class OracleDecodedAlarm extends DecodedAlarm {
    public OracleDecodedAlarm(AlarmSNMPWithRouting alarmSnmpTrapWithRouting) {
        super(new AlarmMetadata(alarmSnmpTrapWithRouting.alarmSNMPTrap()));
    }

    @Override
    public String toJsonString() {
        return "";
    }
}
