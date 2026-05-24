package vn.vivas.nfm.nifi.helper;

public final class AlarmHelper {

    private AlarmHelper() {
    }

    public static String buildAlarmDescriptionHTML(
            String managedObject,
            String severity,
            String eventType,
            String specificProblem,
            String probableCause,
            String eventTime,
            String ceaseTime,
            String sourceIpAddress,
            String problemText,
            String additionalText,
            String alarmType
    ) {
        StringBuilder htmlBuilder = new StringBuilder("<ol class=\"detail-list\">");
        appendDetailItem(htmlBuilder, "ManagedObject", managedObject);
        appendDetailItem(htmlBuilder, "Severity", severity);
        appendDetailItem(htmlBuilder, "Event Type", eventType);
        appendDetailItem(htmlBuilder, "Specific Problem", specificProblem);
        appendDetailItem(htmlBuilder, "Probable Cause", probableCause);
        appendDetailItem(htmlBuilder, "Event Time", eventTime);
        appendDetailItem(htmlBuilder, "Cease Time", ceaseTime);
        appendDetailItem(htmlBuilder, "Source IP Address", sourceIpAddress);
        appendDetailItem(htmlBuilder, "Problem Text", problemText);
        appendDetailItem(htmlBuilder, "AdditionalText", additionalText);
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
}
