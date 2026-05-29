package vn.vivas.nfm.nifi.models;

public abstract class DecodedAlarm {

    protected final EnrichedNode enrichedNode;
    protected final AlarmRouting alarmRouting;

    public DecodedAlarm(
            EnrichedNode enrichedNode,
            AlarmRouting alarmRouting
    ) {
        this.enrichedNode = enrichedNode;
        this.alarmRouting = alarmRouting;
    }

    public EnrichedNode getEnrichedNode() {return this.enrichedNode;}
    public AlarmRouting getAlarmRouting() {return this.alarmRouting;}
}
