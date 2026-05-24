package vn.vivas.nfm.nifi.mapper.oracle;

import vn.vivas.nfm.nifi.helper.AlarmHelper;
import vn.vivas.nfm.nifi.mapper.AlarmMapper;
import vn.vivas.nfm.nifi.model.*;
import vn.vivas.nfm.nifi.model.raw.oracle.SBCApSysMgmtSAStatusChangeAlarm;

public class SBCApSysMgmtSAStatusChangeAlarmMapper implements AlarmMapper<SBCApSysMgmtSAStatusChangeAlarm> {

    @Override
    public Class<SBCApSysMgmtSAStatusChangeAlarm> getRawAlarmClass() {
        return SBCApSysMgmtSAStatusChangeAlarm.class;
    }

    @Override
    public Alarm map(SBCApSysMgmtSAStatusChangeAlarm alarm) {
        Alarm standardizationAlarm = new Alarm();

        AlarmType alarmType = AlarmType.ALERT_ALARM;

        String alarmProbableCause = "apSysMgmtSAStatusChangeTrap";

        AlarmSeverity alarmSeverity = AlarmSeverity.MAJOR;

        AlarmEventType alarmEventType = AlarmEventType.UNKNOWN;

        AlarmProtocol alarmProtocol = AlarmProtocol.SNMP_PROTOCOL;

        String alarmProblemText = "Session Agent: " + alarm.getApSysMgmtSAHostname() + "/" + alarm.getApSysMgmtSAIP() + ", "
                                + "change status to: " + getStatusDescription(Integer.parseInt(alarm.getApSysMgmtSAStatus())) + ", "
                                + "due to: " + getReasonFromID(Integer.parseInt(alarm.getApSysMgmtSAStatusReason()));

        String alarmObject = alarm.getApSysMgmtSAHostname() + "/" + alarm.getApSysMgmtSAIP();

        String alarmDetails = AlarmHelper.buildAlarmDescriptionHTML(
                alarmObject,
                alarmSeverity.toString(),
                alarmEventType.toString(),
                alarmProbableCause,
                alarmProbableCause,
                "",
                "",
                alarm.getApSysMgmtSAIP(),
                alarmProblemText,
                "",
                alarmType.toString()
        );

        standardizationAlarm.setEventPoid(""); // -
        standardizationAlarm.setProbableCauseId(0); // -
        standardizationAlarm.setProbableCause(alarmProbableCause);
        standardizationAlarm.setSpecificProblem(""); // -
        standardizationAlarm.setProblemText(alarmProblemText);
        standardizationAlarm.setSeverityLevel(alarmSeverity.toInteger());
        standardizationAlarm.setSeverityLevelDesc(alarmSeverity.toString());
        standardizationAlarm.setMinorType(""); // -
        standardizationAlarm.setMajorType(alarm.getSnmpTrapName());
        standardizationAlarm.setType(alarmType.toInteger());
        standardizationAlarm.setDetails(alarmDetails);

        standardizationAlarm.setProtocol(alarmProtocol.toInteger());
        standardizationAlarm.setManagedObject(alarmObject);
        standardizationAlarm.setObject(alarmObject);
        standardizationAlarm.setSubNetwork(""); // -
        standardizationAlarm.setNetworkElement(""); // -

        standardizationAlarm.setSystemEventId(alarmEventType.toInteger());
        standardizationAlarm.setSystemEventName(alarmEventType.toString());

        standardizationAlarm.setDecodeData(alarm.toString());
        standardizationAlarm.setRawData(alarm.getRawData());

        return standardizationAlarm;
    }

    private String getStatusDescription(int status) {
        return switch (status) {
            case 0 -> "inservice";
            case 1 -> "out of service";
            default -> "unknown";
        };
    }

    private String getReasonFromID(int id) {
        return switch (id) {
            case 0 -> "administrative";
            case 1 -> "oosbyproxyerror";
            case 2 -> "standby";
            case 3 -> "inservice";
            case 4 -> "constraintsexceeded";
            case 5 -> "unresponsive";
            case 6 -> "oosprovisionedresponse";
            default -> "unknown";
        };
    }
}
