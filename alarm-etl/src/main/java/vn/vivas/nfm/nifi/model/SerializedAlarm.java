package vn.vivas.nfm.nifi.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import vn.vivas.nfm.nifi.helper.AlarmHelper;

@JsonPropertyOrder({
        "request_id", "event_poid", "minor_type", "major_type", "sys_uptime",
        "probable_cause_id", "probable_cause", "specific_problem", "problem_text", "details",
        "severity", "severity_desc",
        "type", "type_desc",
        "protocol", "protocol_desc",
        "managed_object", "object", "sub_network", "network_element", "peer_address",
        "ingest_time", "created_time", "created_time_ms", "cleared_time", "cleared_time_ms", "duration",
        "status", "state",
        "system_event_id", "system_event_name",
        "custom_event_type", "custom_event_id", "custom_event_name",
        "note"
})
public record SerializedAlarm(
        @JsonProperty("request_id") Long requestId,
        @JsonProperty("event_poid") String eventPoid,
        @JsonProperty("minor_type") String minorType,
        @JsonProperty("major_type") String majorType,
        @JsonProperty("sys_uptime") String sysUpTime,

        @JsonProperty("probable_cause_id") Integer probableCauseId,
        @JsonProperty("probable_cause") String probableCause,
        @JsonProperty("specific_problem") String specificProblem,
        @JsonProperty("problem_text") String problemText,
        @JsonProperty("details") String details,

        @JsonProperty("severity") Integer severity,
        @JsonProperty("severity_desc") String severityDesc,

        @JsonProperty("type") Integer type,
        @JsonProperty("type_desc") String typeDesc,

        @JsonProperty("protocol") Integer protocol,
        @JsonProperty("protocol_desc") String protocolDesc,

        @JsonProperty("managed_object") String managedObject,
        @JsonProperty("object") String object,
        @JsonProperty("sub_network") String subNetwork,
        @JsonProperty("network_element") String networkElement,
        @JsonProperty("peer_address") String peerAddress,

        @JsonProperty("ingest_time") Long ingestTime,
        @JsonProperty("created_time") String createdTime,
        @JsonProperty("created_time_ms") Long createdTimeMs,
        @JsonProperty("cleared_time") String clearedTime,
        @JsonProperty("cleared_time_ms") Long clearedTimeMs,
        @JsonProperty("duration") Long duration,

        @JsonProperty("status") Integer status,
        @JsonProperty("state") String state,

        @JsonProperty("system_event_id") Integer systemEventId,
        @JsonProperty("system_event_name") String systemEventName,

        @JsonProperty("custom_event_type") Integer customEventType,
        @JsonProperty("custom_event_id") Integer customEventId,
        @JsonProperty("custom_event_name") String customEventName,

        @JsonProperty("note") String note
) {
    public static SerializedAlarm from(StandardizedAlarm alarm) {
        var identify = alarm.getIdentify();
        var problem = alarm.getProblem();
        var severity = alarm.getSeverity();
        var type = alarm.getType();
        var protocol = alarm.getProtocol();
        var source = alarm.getSource();
        var time = alarm.getTime();
        var state = alarm.getState();
        var customEvent = alarm.getCustomEvent();
        var systemEvent = alarm.getSystemEvent();
        var metadata = alarm.getMetadata();

        return new SerializedAlarm(
                identify.requestID(),
                identify.eventPOID(),
                identify.minorType(),
                identify.majorType(),
                identify.sysUpTime(),

                problem.probableCauseID(),
                problem.probableCause(),
                problem.specificProblem(),
                problem.problemText(),
                problem.details(),

                severity.toInteger(),
                severity.toString(),

                type.toInteger(),
                type.toString(),

                protocol.toInteger(),
                protocol.toString(),

                source.managedObject(),
                source.object(),
                source.subNetwork(),
                source.networkElement(),
                source.peerAddress(),

                metadata.getIngestTime(),
                AlarmHelper.toDateString(time.createdTime(), "yyyy-MM-dd HH:mm:ss"),
                AlarmHelper.toMillis(time.createdTime()),
                AlarmHelper.toDateString(time.clearedTime(), "yyyy-MM-dd HH:mm:ss"),
                AlarmHelper.toMillis(time.clearedTime()),
                time.duration(),

                state.getStatus(),
                state.getOperation().toString(),

                systemEvent.toInteger(),
                systemEvent.toString(),

                customEvent.getEventType(),
                customEvent.getEventID(),
                customEvent.getEventLabel(),

                alarm.getNote()
        );
    }
}