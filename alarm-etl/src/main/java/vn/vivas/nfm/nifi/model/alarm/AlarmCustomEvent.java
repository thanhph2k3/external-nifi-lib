package vn.vivas.nfm.nifi.model.alarm;

import lombok.Getter;

@Getter
public enum AlarmCustomEvent {
    UNKNOWN(0, 0, "-");

    private final int eventType;
    private final int eventID;
    private final String eventLabel;

    AlarmCustomEvent(int eventType, int eventID, String eventLabel) {
        this.eventType = eventType;
        this.eventID = eventID;
        this.eventLabel = eventLabel;
    }

}
