package vn.vivas.nfm.nifi.model.raw.ericsson;

import com.fasterxml.jackson.annotation.JsonProperty;
import vn.vivas.nfm.nifi.handler.support.SnmpTrapSupport;

import java.util.Map;

public class EricssonRawAlertAlarm extends EricssonRawAlarm {

    private static final String OID_ALERT_MAJOR_TYPE = "1.3.6.1.4.1.193.183.4.1.4.5.1.2";
    private static final String OID_ALERT_MINOR_TYPE = "1.3.6.1.4.1.193.183.4.1.4.5.1.3";
    private static final String OID_ALERT_SPECIFIC_PROBLEM = "1.3.6.1.4.1.193.183.4.1.4.5.1.4";
    private static final String OID_ALERT_MANAGED_OBJECT = "1.3.6.1.4.1.193.183.4.1.4.5.1.5";
    private static final String OID_ALERT_EVENT_TYPE = "1.3.6.1.4.1.193.183.4.1.4.5.1.6";
    private static final String OID_ALERT_EVENT_TIME = "1.3.6.1.4.1.193.183.4.1.4.5.1.7";
    private static final String OID_ALERT_PROBABLE_CAUSE = "1.3.6.1.4.1.193.183.4.1.4.5.1.8";
    private static final String OID_ALERT_SEVERITY = "1.3.6.1.4.1.193.183.4.1.4.5.1.9";
    private static final String OID_ALERT_ADDITIONAL_TEXT = "1.3.6.1.4.1.193.183.4.1.4.5.1.10";
    private static final String OID_ALERT_RESOURCE_ID = "1.3.6.1.4.1.193.183.4.1.4.5.1.11";
    private static final String OID_ALERT_ADDITIONAL_INFO = "1.3.6.1.4.1.193.183.4.1.4.5.1.12";

    @JsonProperty("eriAlarmAlertMajorType")
    protected String eriAlarmAlertMajorType;

    @JsonProperty("eriAlarmAlertMinorType")
    protected String eriAlarmAlertMinorType;

    @JsonProperty("eriAlarmAlertSpecificProblem")
    protected String eriAlarmAlertSpecificProblem;

    @JsonProperty("eriAlarmAlertManagedObject")
    protected String eriAlarmAlertManagedObject;

    @JsonProperty("eriAlarmAlertEventType")
    protected String eriAlarmAlertEventType;

    @JsonProperty("eriAlarmAlertEventTime")
    protected String eriAlarmAlertEventTime;

    @JsonProperty("eriAlarmAlertProbableCause")
    protected String eriAlarmAlertProbableCause;

    @JsonProperty("eriAlarmAlertSeverity")
    protected String eriAlarmAlertSeverity;

    @JsonProperty("eriAlarmAlertAdditionalText")
    protected String eriAlarmAlertAdditionalText;

    @JsonProperty("eriAlarmAlertResourceId")
    protected String eriAlarmAlertResourceId;

    @JsonProperty("eriAlarmAlertAdditionalInfo")
    protected String eriAlarmAlertAdditionalInfo;

    public EricssonRawAlertAlarm(Map<String, Object> rawObject) {
        super(rawObject);
        parseAlarmFromRaw(rawObject);
    }

    @Override
    protected void parseAlarmFromRaw(Map<String, Object> rawObject) {
        if (rawObject == null) {
            return;
        }

        rawObject.forEach((key, value) -> {
            String oid = SnmpTrapSupport.extractOID(key);
            if (oid == null || this.parseEricssonCommonField(oid, value) || this.parseCommonField(oid, value)) {
                return;
            }

            String fieldValue = parseFieldValue(value);
            switch (oid) {
                case OID_ALERT_MAJOR_TYPE -> this.eriAlarmAlertMajorType = fieldValue;
                case OID_ALERT_MINOR_TYPE -> this.eriAlarmAlertMinorType = fieldValue;
                case OID_ALERT_SPECIFIC_PROBLEM -> this.eriAlarmAlertSpecificProblem = fieldValue;
                case OID_ALERT_MANAGED_OBJECT -> this.eriAlarmAlertManagedObject = fieldValue;
                case OID_ALERT_EVENT_TYPE -> this.eriAlarmAlertEventType = fieldValue;
                case OID_ALERT_EVENT_TIME -> this.eriAlarmAlertEventTime = fieldValue;
                case OID_ALERT_PROBABLE_CAUSE -> this.eriAlarmAlertProbableCause = fieldValue;
                case OID_ALERT_SEVERITY -> this.eriAlarmAlertSeverity = fieldValue;
                case OID_ALERT_ADDITIONAL_TEXT -> this.eriAlarmAlertAdditionalText = fieldValue;
                case OID_ALERT_RESOURCE_ID -> this.eriAlarmAlertResourceId = fieldValue;
                case OID_ALERT_ADDITIONAL_INFO -> this.eriAlarmAlertAdditionalInfo = fieldValue;
            }
        });
    }
}
