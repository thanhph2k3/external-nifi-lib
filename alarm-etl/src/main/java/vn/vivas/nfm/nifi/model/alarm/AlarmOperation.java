package vn.vivas.nfm.nifi.model.alarm;

public enum AlarmOperation {

    UNKNOWN(0, "unknown"),
    RAISE(1, "raise"),
    APPEND(2, "append"),
    CLEAR(3, "clear");

    private final int id;
    private final String label;

    AlarmOperation(int id, String label) {
        this.id = id;
        this.label = label;
    }

    public int toInteger() {
        return this.id;
    }

    @Override
    public String toString() {
        return this.label;
    }

    public static AlarmOperation fromSeverity(AlarmSeverity severity) {
        return switch (severity) {
            case AlarmSeverity.WARNING, AlarmSeverity.MINOR, AlarmSeverity.MAJOR, AlarmSeverity.CRITICAL -> AlarmOperation.RAISE;
            case AlarmSeverity.APPEND ->  AlarmOperation.APPEND;
            case AlarmSeverity.CLEAR ->  AlarmOperation.CLEAR;
            default -> AlarmOperation.UNKNOWN;
        };
    }
}
