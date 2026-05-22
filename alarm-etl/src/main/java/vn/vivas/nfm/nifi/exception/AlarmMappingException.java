package vn.vivas.nfm.nifi.exception;

public class AlarmMappingException extends RuntimeException {

    public AlarmMappingException(String message) {
        super(message);
    }

    public AlarmMappingException(String message, Throwable cause) {
        super(message, cause);
    }
}
