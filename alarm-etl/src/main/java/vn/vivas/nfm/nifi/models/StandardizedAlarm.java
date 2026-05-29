package vn.vivas.nfm.nifi.models;

import vn.vivas.nfm.nifi.models.alarm.*;

public class StandardizedAlarm {
    private AlarmIdentify identify;
    private AlarmProblem problem;
    private AlarmSeverity severity;
    private AlarmType type;
    private AlarmProtocol protocol;
    private AlarmSource source;
    private AlarmStatus status;
    private AlarmCustomEvent customEvent;
    private AlarmSystemEvent systemEvent;
    private EnrichedNode enrichedNode;
    private String note;
    private String rawData;
    private long ingestTime;

    public StandardizedAlarm() {

    }
}