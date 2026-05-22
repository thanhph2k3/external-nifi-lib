package vn.vivas.nfm.nifi.exception;

public class RawAlarmParseException extends RuntimeException {

    public RawAlarmParseException(String message) {
        super(message);
    }

    public RawAlarmParseException(String message, Throwable cause) {
        super(message, cause);
    }
}
