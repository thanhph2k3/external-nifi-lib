package vn.vivas.nfm.nifi.model.alarm;

public class AlarmState {
    private final int status;
    private final AlarmOperation operation;

    public AlarmState(int status, AlarmOperation operation) {
        this.status = status;
        this.operation = operation;
    }

    public int getStatus() {
        return status;
    }

    public AlarmOperation getOperation() {
        return operation;
    }
}
