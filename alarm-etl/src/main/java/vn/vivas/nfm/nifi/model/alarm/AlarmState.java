package vn.vivas.nfm.nifi.model.alarm;

import lombok.Getter;

@Getter
public class AlarmState {
    private final int status;
    private final AlarmOperation operation;

    public AlarmState(int status, AlarmOperation operation) {
        this.status = status;
        this.operation = operation;
    }
}
