package vn.vivas.nfm.nifi.model.alarm;

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

    public static AlarmSeverity tekelecMapping(int tekelecSeverity) {
        return switch (tekelecSeverity) {
            case 2 -> AlarmSeverity.WARNING;
            case 3 -> AlarmSeverity.CLEAR;
            case 4 -> AlarmSeverity.MINOR;
            case 5 -> AlarmSeverity.MAJOR;
            case 6 -> AlarmSeverity.CRITICAL;
            default -> AlarmSeverity.OTHER;
        };
    }
}
