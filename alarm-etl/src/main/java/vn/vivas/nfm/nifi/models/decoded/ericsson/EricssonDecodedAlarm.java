package vn.vivas.nfm.nifi.models.decoded.ericsson;

import vn.vivas.nfm.nifi.models.AlarmRouting;
import vn.vivas.nfm.nifi.models.DecodedAlarm;
import vn.vivas.nfm.nifi.models.EnrichedNode;
import vn.vivas.nfm.nifi.models.alarm.AlarmMetadata;

public abstract class EricssonDecodedAlarm extends DecodedAlarm {

    protected final String eriAlarmNObjAdditionalText;
    protected final String eriAlarmNObjMoreAdditionalText;
    protected final String eriAlarmNObjResourceId;
    protected final String eriAlarmNObjAdditionalInfo;
    protected final String eriAlarmNObjMoreAdditionalInfo;
    protected final String eriAlarmNObjRecordType;
    protected final String eriAlarmNObjAppendedAdditionalInfo;

    public EricssonDecodedAlarm(
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
        super(enrichedNode, alarmRouting);
        this.eriAlarmNObjAdditionalText = eriAlarmNObjAdditionalText;
        this.eriAlarmNObjMoreAdditionalText = eriAlarmNObjMoreAdditionalText;
        this.eriAlarmNObjResourceId = eriAlarmNObjResourceId;
        this.eriAlarmNObjAdditionalInfo = eriAlarmNObjAdditionalInfo;
        this.eriAlarmNObjMoreAdditionalInfo = eriAlarmNObjMoreAdditionalInfo;
        this.eriAlarmNObjRecordType = eriAlarmNObjRecordType;
        this.eriAlarmNObjAppendedAdditionalInfo = eriAlarmNObjAppendedAdditionalInfo;
    }
}
