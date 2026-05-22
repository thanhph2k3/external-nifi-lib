package vn.vivas.nfm.nifi.model.raw.ericsson;

import com.fasterxml.jackson.annotation.JsonProperty;
import vn.vivas.nfm.nifi.model.raw.RawAlarm;

public abstract class EricssonRawAlarm extends RawAlarm {

    protected static final String OID_NOBJ_ADDITIONAL_TEXT = "1.3.6.1.4.1.193.183.4.1.2.1";
    protected static final String OID_NOBJ_MORE_ADDITIONAL_TEXT = "1.3.6.1.4.1.193.183.4.1.2.2";
    protected static final String OID_NOBJ_RESOURCE_ID = "1.3.6.1.4.1.193.183.4.1.2.3";
    protected static final String OID_NOBJ_ADDITIONAL_INFO = "1.3.6.1.4.1.193.183.4.1.2.4";
    protected static final String OID_NOBJ_MORE_ADDITIONAL_INFO = "1.3.6.1.4.1.193.183.4.1.2.5";
    protected static final String OID_NOBJ_RECORD_TYPE = "1.3.6.1.4.1.193.183.4.1.2.6";
    protected static final String OID_NOBJ_APPENDED_ADDITIONAL_INFO = "1.3.6.1.4.1.193.183.4.1.2.7";

    @JsonProperty("eriAlarmNObjAdditionalInfo")
    protected String eriAlarmNObjAdditionalInfo;

    @JsonProperty("eriAlarmNObjMoreAdditionalInfo")
    protected String eriAlarmNObjMoreAdditionalInfo;

    @JsonProperty("eriAlarmNObjAppendedAdditionalInfo")
    protected String eriAlarmNObjAppendedAdditionalInfo;

    @JsonProperty("eriAlarmNObjAdditionalText")
    protected String eriAlarmNObjAdditionalText;

    @JsonProperty("eriAlarmNObjMoreAdditionalText")
    protected String eriAlarmNObjMoreAdditionalText;

    @JsonProperty("eriAlarmNObjResourceId")
    protected String eriAlarmNObjResourceId;

    @JsonProperty("eriAlarmNObjRecordType")
    protected String eriAlarmNObjRecordType;

    protected boolean parseEricssonCommonField(String oid, Object value) {
        String fieldValue = parseFieldValue(value);
        switch (oid) {
            case OID_NOBJ_ADDITIONAL_TEXT -> this.eriAlarmNObjAdditionalText = fieldValue;
            case OID_NOBJ_MORE_ADDITIONAL_TEXT -> this.eriAlarmNObjMoreAdditionalText = fieldValue;
            case OID_NOBJ_RESOURCE_ID -> this.eriAlarmNObjResourceId = fieldValue;
            case OID_NOBJ_ADDITIONAL_INFO -> this.eriAlarmNObjAdditionalInfo = fieldValue;
            case OID_NOBJ_MORE_ADDITIONAL_INFO -> this.eriAlarmNObjMoreAdditionalInfo = fieldValue;
            case OID_NOBJ_RECORD_TYPE -> this.eriAlarmNObjRecordType = fieldValue;
            case OID_NOBJ_APPENDED_ADDITIONAL_INFO -> this.eriAlarmNObjAppendedAdditionalInfo = fieldValue;
            default -> {
                return false;
            }
        }

        return true;
    }
}
