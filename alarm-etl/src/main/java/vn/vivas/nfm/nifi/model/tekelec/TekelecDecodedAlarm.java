package vn.vivas.nfm.nifi.model.tekelec;

import lombok.Getter;
import vn.vivas.nfm.nifi.model.AlarmSNMPWithRouting;
import vn.vivas.nfm.nifi.model.DecodedAlarm;
import vn.vivas.nfm.nifi.model.alarm.AlarmMetadata;
import vn.vivas.nfm.nifi.parser.JsonStringParser;

import java.util.HashMap;
import java.util.Map;

@Getter
public class TekelecDecodedAlarm extends DecodedAlarm {

    public static final String OID_DATETIME_HEX = "1.3.6.1.4.1.323.5.3.3.1.1.1";
    public static final String OID_RESOURCE_NAME = "1.3.6.1.4.1.323.5.3.3.1.1.2";
    public static final String OID_SUB_RESOURCE_NAME = "1.3.6.1.4.1.323.5.3.3.1.1.3";
    public static final String OID_SEVERITY = "1.3.6.1.4.1.323.5.3.3.1.1.4";
    public static final String OID_TEXT_MESSAGE = "1.3.6.1.4.1.323.5.3.3.1.1.5";
    public static final String OID_MRN_NUMBER = "1.3.6.1.4.1.323.5.3.3.1.1.6";
    public static final String OID_ALARM_SEQUENCE_NUMBER = "1.3.6.1.4.1.323.5.3.3.1.1.7";

    private String dateTimeHex;
    private String resourceName;
    private String subResourceName;
    private int severity;
    private String textMessage;
    private int MRNNumber;
    private int alarmSequenceNumber;

    public TekelecDecodedAlarm(AlarmSNMPWithRouting alarmSnmpTrapWithRouting) {
        super(new AlarmMetadata(alarmSnmpTrapWithRouting.alarmSNMPTrap()));
        alarmSnmpTrapWithRouting.alarmSNMPTrap().getOids().forEach((key, value) -> {
            switch (key) {
                case OID_DATETIME_HEX -> this.dateTimeHex = value.toString();
                case OID_RESOURCE_NAME ->  this.resourceName = value.toString();
                case OID_SUB_RESOURCE_NAME ->   this.subResourceName = value.toString();
                case OID_SEVERITY ->  this.severity = Integer.parseInt(value.toString());
                case OID_TEXT_MESSAGE -> this.textMessage = value.toString();
                case OID_MRN_NUMBER ->   this.MRNNumber = Integer.parseInt(value.toString());
                case OID_ALARM_SEQUENCE_NUMBER -> this.alarmSequenceNumber = Integer.parseInt(value.toString());
            }
        });
    }

    @Override
    public String toJsonString() {
        Map<String, Object> map =  new HashMap<>();
        map.put("requestID", alarmMetadata.getRequestID());
        map.put("peerAddress", alarmMetadata.getPeerAddress());
        map.put("sysUptime", alarmMetadata.getSysUpTime());
        map.put("ingestTime", alarmMetadata.getIngestTime());
        map.put("dateTimeHex", dateTimeHex);
        map.put("resourceName", resourceName);
        map.put("subResourceName", subResourceName);
        map.put("severity", severity);
        map.put("textMessage", textMessage);
        map.put("MRNNumber", MRNNumber);
        map.put("alarmSequenceNumber", alarmSequenceNumber);
        return JsonStringParser.toJsonString(map);
    }
}
