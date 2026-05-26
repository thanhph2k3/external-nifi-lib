package vn.vivas.nfm.nifi.helper;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HexFormat;
import java.util.List;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.util.UUID;

public final class AlarmHelper {

    private static final SimpleDateFormat DATE_FORMAT =
            new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    private AlarmHelper() {
    }

    public static String sha256(List<String> inputs) {
        try {
            String content = String.join("", inputs);

            byte[] hash = MessageDigest
                    .getInstance("SHA-256")
                    .digest(content.getBytes(StandardCharsets.UTF_8));

            return HexFormat.of().formatHex(hash);

        } catch (Exception e) {
            return UUID.randomUUID().toString() + "|" + inputs.toString();
        }
    }

    public static String buildAlarmDescriptionHTML(
            String managedObject,
            String severity,
            String eventType,
            String specificProblem,
            String probableCause,
            Date eventTime,
            Date ceaseTime,
            String sourceIpAddress,
            String problemText,
            String alarmType
    ) {
        StringBuilder htmlBuilder = new StringBuilder("<ol class=\"detail-list\">");
        appendDetailItem(htmlBuilder, "ManagedObject", managedObject);
        appendDetailItem(htmlBuilder, "Severity", severity);
        appendDetailItem(htmlBuilder, "Event Type", eventType);
        appendDetailItem(htmlBuilder, "Specific Problem", specificProblem);
        appendDetailItem(htmlBuilder, "Probable Cause", probableCause);
        appendDetailItem(htmlBuilder, "Event Time", formatDate(eventTime));
        appendDetailItem(htmlBuilder, "Cease Time", formatDate(ceaseTime));
        appendDetailItem(htmlBuilder, "Source IP Address", sourceIpAddress);
        appendDetailItem(htmlBuilder, "Problem Text", problemText);
        appendDetailItem(htmlBuilder, "Alarm Type", alarmType);
        return htmlBuilder.append("</ol>").toString();
    }

    private static void appendDetailItem(StringBuilder htmlBuilder, String label, String value) {
        htmlBuilder.append("<li class=\"detail-item\"><strong class=\"detail-label\">")
                .append(escapeHtml(label))
                .append("</strong>: <span class=\"detail-value\">")
                .append(escapeHtml(value))
                .append("</span></li>");
    }

    private static String escapeHtml(String value) {
        if (value == null) {
            return "";
        }

        return value
                .replace("&", "&amp;")
                .replace("<", "&lt;")
                .replace(">", "&gt;")
                .replace("\"", "&quot;")
                .replace("'", "&#39;");
    }

    private static String formatDate(Date date) {
        return date != null ? DATE_FORMAT.format(date) : null;
    }
}
