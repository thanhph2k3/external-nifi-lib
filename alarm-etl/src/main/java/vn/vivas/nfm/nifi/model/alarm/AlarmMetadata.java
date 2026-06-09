package vn.vivas.nfm.nifi.model.alarm;

import lombok.Getter;
import vn.vivas.nfm.nifi.model.AlarmSNMPTrap;

@Getter
public class AlarmMetadata {
    private final String rawData;
    private final String sysUpTime;
    private final String peerAddress;
    private final long requestID;
    private final long ingestTime;

    public AlarmMetadata(AlarmSNMPTrap alarmSNMPTrap) {
        this.rawData = alarmSNMPTrap.toJsonString();
        this.sysUpTime = alarmSNMPTrap.getSystemUpTime();
        this.peerAddress = alarmSNMPTrap.getPeerAddress();
        this.requestID = alarmSNMPTrap.getRequestID();
        this.ingestTime = alarmSNMPTrap.getIngestTime();
    }
}
