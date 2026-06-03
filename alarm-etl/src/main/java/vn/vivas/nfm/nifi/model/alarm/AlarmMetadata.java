package vn.vivas.nfm.nifi.model.alarm;

import vn.vivas.nfm.nifi.model.AlarmSNMPTrap;

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

    public String getRawData() {
        return rawData;
    }

    public String getSysUpTime() {
        return sysUpTime;
    }

    public String getPeerAddress() {
        return peerAddress;
    }

    public long getRequestID() {
        return requestID;
    }

    public long getIngestTime() {
        return ingestTime;
    }
}
