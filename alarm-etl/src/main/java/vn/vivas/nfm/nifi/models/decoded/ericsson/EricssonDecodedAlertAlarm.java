package vn.vivas.nfm.nifi.models.decoded.ericsson;

import vn.vivas.nfm.nifi.models.AlarmRouting;
import vn.vivas.nfm.nifi.models.EnrichedNode;

public class EricssonDecodedAlertAlarm extends EricssonDecodedAlarm {

    public EricssonDecodedAlertAlarm(
            EnrichedNode enrichedNode,
            AlarmRouting alarmRouting,
            String eriAlarmNObjAdditionalText,
            String eriAlarmNObjMoreAdditionalText,
            String eriAlarmNObjResourceId,
            String eriAlarmNObjAdditionalInfo,
            String eriAlarmNObjMoreAdditionalInfo,
            String eriAlarmNObjRecordType,
            String eriAlarmNObjAppendedAdditionalInfo
    ) {
        super(
                enrichedNode,
                alarmRouting,
                eriAlarmNObjAdditionalText,
                eriAlarmNObjMoreAdditionalText,
                eriAlarmNObjResourceId,
                eriAlarmNObjAdditionalInfo,
                eriAlarmNObjMoreAdditionalInfo,
                eriAlarmNObjRecordType,
                eriAlarmNObjAppendedAdditionalInfo
        );
    }
}
