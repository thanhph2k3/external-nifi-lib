package vn.vivas.nfm.nifi.model.alarm;

public record AlarmIdentify(long requestID, String eventPOID, String minorType, String majorType, String sysUpTime) {
}