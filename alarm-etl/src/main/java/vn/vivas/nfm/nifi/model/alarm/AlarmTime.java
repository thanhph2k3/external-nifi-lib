package vn.vivas.nfm.nifi.model.alarm;

import java.util.Date;

public record AlarmTime(
        long ingestTime,
        Date createdTime,
        Date clearedTime,
        long duration
) {
}