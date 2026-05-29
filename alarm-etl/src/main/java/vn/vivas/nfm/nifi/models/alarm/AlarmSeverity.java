package vn.vivas.nfm.nifi.models.alarm;

public enum AlarmSeverity {

    CLEAR(6, "CLEAR"),
    APPEND(5, "APPEND"),
    OTHER(4, "OTHER"),
    CRITICAL(3, "CRITICAL"),
    MAJOR(2, "MAJOR"),
    MINOR(1, "MINOR"),
    WARNING(0, "WARNING");

    private final int level;
    private final String label;

    AlarmSeverity(int level, String label) {
        this.level = level;
        this.label = label;
    }

    public int toInteger() {
        return level;
    }

    @Override
    public String toString() {
        return label;
    }
}