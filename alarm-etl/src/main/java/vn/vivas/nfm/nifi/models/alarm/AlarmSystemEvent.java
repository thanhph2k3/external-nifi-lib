package vn.vivas.nfm.nifi.models.alarm;

public enum AlarmSystemEvent {

    UNKNOWN(0, "-"),
    OTHER(1, "Other"),
    COMMUNICATIONS_ALARM(2, "CommunicationsAlarm"),
    QUALITY_OF_SERVICE_ALARM(3, "QualityOfServiceAlarm"),
    PROCESSING_ERROR_ALARM(4, "ProcessingErrorAlarm"),
    EQUIPMENT_ALARM(5, "EquipmentAlarm"),
    ENVIRONMENT_ALARM(6, "EnvironmentAlarm"),
    INTEGRITY_VIOLATION(7, "IntegrityViolation"),
    OPERATIONAL_VIOLATION(8, "OperationalViolation"),
    PHYSICAL_VIOLATION(9, "PhysicalViolation"),
    SECURITY_SERVICE_OR_MECHANISM_VIOLATION(10, "SecurityServiceOrMechanismViolation"),
    TIME_DOMAIN_VIOLATION(11, "TimeDomainViolation"),
    SWITCHING_ALARM(12, "SwitchingAlarm"),
    HEARTBEAT_ALARM(13, "HeartbeatAlarm");

    private final int eventID;
    private final String eventLabel;

    AlarmSystemEvent(int eventID, String eventLabel) {
        this.eventID = eventID;
        this.eventLabel = eventLabel;
    }

    public int toInteger() {
        return this.eventID;
    }

    @Override
    public String toString() {
        return this.eventLabel;
    }
}
