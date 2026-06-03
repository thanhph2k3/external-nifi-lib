package vn.vivas.nfm.nifi.helper;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

public class AlarmHelper {
    public static Date parseDateFromHexString(String hexString) {
        if (hexString == null || hexString.isEmpty()) {
            return Date.from(LocalDateTime.now().atZone(ZoneId.systemDefault()).toInstant());
        }
        String[] parts = hexString.split(":");

        int year = Integer.parseInt(parts[0] + parts[1], 16);
        int month = Integer.parseInt(parts[2], 16);
        int day = Integer.parseInt(parts[3], 16);
        int hour = Integer.parseInt(parts[4], 16);
        int minute = Integer.parseInt(parts[5], 16);
        int second = Integer.parseInt(parts[6], 16);

        LocalDateTime localDateTime = LocalDateTime.of(
                year,
                month,
                day,
                hour,
                minute,
                second
        );

        return Date.from(
                localDateTime.atZone(ZoneId.systemDefault()).toInstant()
        );
    }

    public static String toDateString(Date date, String format) {
        return new SimpleDateFormat(format).format(date);
    }

    public static long toMillis(Date date) {
        return date.getTime();
    }
}
