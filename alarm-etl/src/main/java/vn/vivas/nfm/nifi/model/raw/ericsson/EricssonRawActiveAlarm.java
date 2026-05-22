package vn.vivas.nfm.nifi.model.raw.ericsson;

import com.fasterxml.jackson.annotation.JsonProperty;
import vn.vivas.nfm.nifi.enums.TrapType;
import vn.vivas.nfm.nifi.model.Alarm;

import java.util.Map;

public class EricssonRawActiveAlarm extends EricssonRawAlarm {

    private static final String OID_ACTIVE_MAJOR_TYPE = "1.3.6.1.4.1.193.183.4.1.3.5.1.2";
    private static final String OID_ACTIVE_MINOR_TYPE = "1.3.6.1.4.1.193.183.4.1.3.5.1.3";
    private static final String OID_ACTIVE_SPECIFIC_PROBLEM = "1.3.6.1.4.1.193.183.4.1.3.5.1.4";
    private static final String OID_ACTIVE_MANAGED_OBJECT = "1.3.6.1.4.1.193.183.4.1.3.5.1.5";
    private static final String OID_ACTIVE_EVENT_TYPE = "1.3.6.1.4.1.193.183.4.1.3.5.1.6";
    private static final String OID_ACTIVE_EVENT_TIME = "1.3.6.1.4.1.193.183.4.1.3.5.1.7";
    private static final String OID_ACTIVE_PROBABLE_CAUSE = "1.3.6.1.4.1.193.183.4.1.3.5.1.9";
    private static final String OID_ACTIVE_SEVERITY = "1.3.6.1.4.1.193.183.4.1.3.5.1.10";
    private static final String OID_ACTIVE_ADDITIONAL_INFO = "1.3.6.1.4.1.193.183.4.1.3.5.1.15";

    @JsonProperty("eriAlarmActiveMajorType")
    private String eriAlarmActiveMajorType;

    @JsonProperty("eriAlarmActiveMinorType")
    private String eriAlarmActiveMinorType;

    @JsonProperty("eriAlarmActiveSpecificProblem")
    private String eriAlarmActiveSpecificProblem;

    @JsonProperty("eriAlarmActiveManagedObject")
    private String eriAlarmActiveManagedObject;

    @JsonProperty("eriAlarmActiveEventType")
    private String eriAlarmActiveEventType;

    @JsonProperty("eriAlarmActiveEventTime")
    private String eriAlarmActiveEventTime;

    @JsonProperty("eriAlarmActiveProbableCause")
    private String eriAlarmActiveProbableCause;

    @JsonProperty("eriAlarmActiveSeverity")
    private String eriAlarmActiveSeverity;

    @JsonProperty("eriAlarmActiveAdditionalInfo")
    private String eriAlarmActiveAdditionalInfo;

    public EricssonRawActiveAlarm(TrapType trapType, Map<String, Object> rawObject) {
        super(trapType);
        parseAlarmFromRaw(rawObject);
    }

    @Override
    protected void parseAlarmFromRaw(Map<String, Object> rawObject) {
        if (rawObject == null) {
            return;
        }

        rawObject.forEach((key, value) -> {
            String oid = extractOID(key);
            if (oid == null || this.parseEricssonCommonField(oid, value) || this.parseCommonField(oid, value)) {
                return;
            }

            String fieldValue = parseFieldValue(value);
            switch (oid) {
                case OID_ACTIVE_MAJOR_TYPE -> this.eriAlarmActiveMajorType = fieldValue;
                case OID_ACTIVE_MINOR_TYPE -> this.eriAlarmActiveMinorType = fieldValue;
                case OID_ACTIVE_SPECIFIC_PROBLEM -> this.eriAlarmActiveSpecificProblem = fieldValue;
                case OID_ACTIVE_MANAGED_OBJECT -> this.eriAlarmActiveManagedObject = fieldValue;
                case OID_ACTIVE_EVENT_TYPE -> this.eriAlarmActiveEventType = fieldValue;
                case OID_ACTIVE_EVENT_TIME -> this.eriAlarmActiveEventTime = fieldValue;
                case OID_ACTIVE_PROBABLE_CAUSE -> this.eriAlarmActiveProbableCause = fieldValue;
                case OID_ACTIVE_SEVERITY -> this.eriAlarmActiveSeverity = fieldValue;
                case OID_ACTIVE_ADDITIONAL_INFO -> this.eriAlarmActiveAdditionalInfo = fieldValue;
            }
        });
    }
}
