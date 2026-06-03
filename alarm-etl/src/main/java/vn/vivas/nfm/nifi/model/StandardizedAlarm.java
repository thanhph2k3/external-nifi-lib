package vn.vivas.nfm.nifi.model;

import lombok.Getter;
import vn.vivas.nfm.nifi.helper.AlarmHelper;
import vn.vivas.nfm.nifi.model.alarm.*;
import vn.vivas.nfm.nifi.model.oracle.OracleDecodedAlarm;
import vn.vivas.nfm.nifi.model.tekelec.TekelecDecodedAlarm;
import vn.vivas.nfm.nifi.parser.JsonStringParser;

import java.util.Date;

@Getter
public class StandardizedAlarm {
    private AlarmIdentify identify;
    private AlarmProblem problem;
    private AlarmSeverity severity;
    private AlarmType type;
    private AlarmProtocol protocol;
    private AlarmSource source;
    private AlarmTime time;
    private AlarmState state;
    private AlarmCustomEvent customEvent;
    private AlarmSystemEvent systemEvent;
    private AlarmMetadata metadata;

    private String note;

    public StandardizedAlarm(TekelecDecodedAlarm tekelecDecodedAlarm) {
        this.identify = new AlarmIdentify(
                tekelecDecodedAlarm.alarmMetadata.getRequestID(),
                "-",
                "-",
                "-",
                tekelecDecodedAlarm.alarmMetadata.getSysUpTime()
        );
        this.problem = new AlarmProblem(
                tekelecDecodedAlarm.getMRNNumber(),
                tekelecDecodedAlarm.getTextMessage(),
                tekelecDecodedAlarm.getTextMessage()
        );
        this.severity = AlarmSeverity.tekelecMapping(tekelecDecodedAlarm.getSeverity());
        this.type = AlarmType.ACTIVE_ALARM;
        this.protocol = AlarmProtocol.SNMP_PROTOCOL;
        this.source = new AlarmSource(
                tekelecDecodedAlarm.getResourceName() + "/" + tekelecDecodedAlarm.getSubResourceName(),
                tekelecDecodedAlarm.getResourceName() + "/" + tekelecDecodedAlarm.getSubResourceName(),
                "-",
                tekelecDecodedAlarm.getResourceName(),
                tekelecDecodedAlarm.alarmMetadata.getPeerAddress()
        );
        this.time = new AlarmTime(
                tekelecDecodedAlarm.alarmMetadata.getIngestTime(),
                AlarmHelper.parseDateFromHexString(tekelecDecodedAlarm.getDateTimeHex()),
                (new Date()),
                0
        );
        this.state = new AlarmState(
                AlarmSeverity.tekelecMapping(tekelecDecodedAlarm.getSeverity()).equals(AlarmSeverity.CLEAR) ? 1 : 0,
                AlarmOperation.fromSeverity(AlarmSeverity.tekelecMapping(tekelecDecodedAlarm.getSeverity()))
        );
        this.customEvent = AlarmCustomEvent.UNKNOWN;
        this.systemEvent = AlarmSystemEvent.UNKNOWN;
        this.metadata = tekelecDecodedAlarm.alarmMetadata;
    }

    public StandardizedAlarm(OracleDecodedAlarm  oracleDecodedAlarm) {

    }

    public String toJsonString() {
        return JsonStringParser.toJsonString(SerializedAlarm.from(this));
    }

}