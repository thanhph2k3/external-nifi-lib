package vn.vivas.nfm.nifi.model.ericsson;

import vn.vivas.nfm.nifi.model.AlarmSNMPWithRouting;
import vn.vivas.nfm.nifi.model.DecodedAlarm;
import vn.vivas.nfm.nifi.model.alarm.AlarmMetadata;

public class EricssonDecodedAlarm extends DecodedAlarm {
    private final String OID_ERI_ALARM_NOBJ_ADDITIONAL_TEXT = "";
    private final String OID_ERI_ALARM_NOBJ_MORE_ADDITIONAL_TEXT = "";
    private final String OID_ERI_ALARM_NOBJ_RESOURCE_ID = "";
    private final String OID_ERI_ALARM_NOBJ_ADDITIONAL_INFO = "";
    private final String OID_ERI_ALARM_NOBJ_MORE_ADDITIONAL_INFO = "";
    private final String OID_ERI_ALARM_NOBJ_RECORD_TYPE = "";
    private final String OID_ERI_ALARM_NOBJ_APPENDED_ADDITIONAL_INFO = "";

    public EricssonDecodedAlarm(AlarmSNMPWithRouting alarmSnmpTrapWithRouting) {
        super(new AlarmMetadata(alarmSnmpTrapWithRouting.alarmSNMPTrap()));
    }

    @Override
    public String toJsonString() {
        return "";
    }
}
