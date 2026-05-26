package vn.vivas.nfm.nifi.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import vn.vivas.nfm.nifi.helper.AlarmHelper;

import java.util.Date;
import java.util.UUID;

public class Alarm {

    // Alarm Basic Data

    @JsonProperty("order")
    private String order;

    @JsonProperty("event_poid")
    private String eventPoid;

    @JsonProperty("probable_cause_id")
    private int probableCauseId;

    @JsonProperty("probable_cause")
    private String probableCause;

    @JsonProperty("specific_problem")
    private String specificProblem;

    @JsonProperty("problem_text")
    private String problemText;

    @JsonProperty("severity_level")
    private int severityLevel;

    @JsonProperty("severity_level_desc")
    private String severityLevelDesc;

    @JsonProperty("major_type")
    private String majorType;

    @JsonProperty("minor_type")
    private String minorType;

    @JsonProperty("details")
    private String details;

    @JsonProperty("type")
    private int type;

    @JsonProperty("type_desc")
    private String typeDesc;

    // Alarm Network Data

    @JsonProperty("protocol")
    private int protocol;

    @JsonProperty("managed_object")
    private String managedObject;

    @JsonProperty("object")
    private String object;

    @JsonProperty("sub_network")
    private String subNetwork;

    @JsonProperty("network_element")
    private String networkElement;

    @JsonProperty("peer_address")
    private String peerAddress;

    // Alarm Status Data

    @JsonProperty("created_time")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createdTime;

    @JsonProperty("created_time_ms")
    private Long createdTimeMs;

    @JsonProperty("cleared_time")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private Date clearedTime;

    @JsonProperty("cleared_time_ms")
    private Long clearedTimeMs;

    @JsonProperty("duration")
    private Long duration;

    @JsonProperty("duration_ms")
    private Long durationMs;

    @JsonProperty("status")
    private int status;

    // Other Data

    @JsonProperty("custom_event_type")
    private int customEventType;

    @JsonProperty("custom_event_id")
    private int customEventId;

    @JsonProperty("custom_event_name")
    private String customEventName;

    @JsonProperty("system_event_id")
    private int systemEventId;

    @JsonProperty("system_event_name")
    private String systemEventName;

    @JsonProperty("note")
    private String note;

    // Alarm Enrichment Data

    @JsonProperty("device_vendor_name")
    private String deviceVendorName;

    @JsonProperty("device_vendor_code")
    private String deviceVendorCode;

    @JsonProperty("device_vendor_id")
    private int deviceVendorId;

    @JsonProperty("device_area_name")
    private String deviceAreaName;

    @JsonProperty("device_area_code")
    private String deviceAreaCode;

    @JsonProperty("device_area_id")
    private int deviceAreaId;

    @JsonProperty("device_sys_group_name")
    private String deviceSysGroupName;

    @JsonProperty("device_sys_group_code")
    private String deviceSysGroupCode;

    @JsonProperty("device_sys_group_id")
    private int deviceSysGroupId;

    @JsonProperty("device_group_name")
    private String deviceGroupName;

    @JsonProperty("device_group_code")
    private String deviceGroupCode;

    @JsonProperty("device_group_id")
    private int deviceGroupId;

    @JsonProperty("device_name")
    private String deviceName;

    @JsonProperty("device_code")
    private String deviceCode;

    @JsonProperty("device_id")
    private int deviceId;

    // Alarm Raw Data

    @JsonProperty("raw_data")
    private String rawData;

    @JsonProperty("ingest_time")
    private long ingestTime;

    public Alarm() {

        this.eventPoid = UUID.randomUUID().toString();

        this.probableCauseId = 0;
        this.probableCause = "-";
        this.specificProblem = "-";
        this.problemText = "-";
        this.details = "-";

        AlarmSeverity alarmSeverity = AlarmSeverity.OTHER;
        this.severityLevel = alarmSeverity.toInteger();
        this.severityLevelDesc = alarmSeverity.toString();

        this.majorType = "-";
        this.minorType = "-";

        AlarmType alarmType = AlarmType.ALERT_ALARM;
        this.type = alarmType.toInteger();

        AlarmProtocol alarmProtocol = AlarmProtocol.SNMP_PROTOCOL;
        this.protocol = alarmProtocol.toInteger();

        this.managedObject = "-";
        this.object = "-";
        this.subNetwork = "-";
        this.networkElement = "-";
        this.peerAddress = "127.0.0.1";

        this.createdTime = new Date();
        this.createdTimeMs = System.currentTimeMillis();

        this.clearedTime = null;
        this.clearedTimeMs = null;

        this.duration = null;
        this.durationMs = null;
        this.status = 0;

        this.customEventType = 0;
        this.customEventId = 0;
        this.customEventName = "-";

        AlarmEventType alarmEventType = AlarmEventType.UNKNOWN;
        this.systemEventId = alarmEventType.toInteger();
        this.systemEventName = alarmEventType.toString();

        this.note = "-";

        // Set default metadata
        this.deviceVendorId = 0;
        this.deviceVendorCode = "-";
        this.deviceVendorName = "-";

        this.deviceAreaId = 0;
        this.deviceAreaCode = "-";
        this.deviceAreaName = "-";

        this.deviceSysGroupId = 0;
        this.deviceSysGroupCode = "-";
        this.deviceSysGroupName = "-";

        this.deviceGroupId = 0;
        this.deviceGroupCode = "-";
        this.deviceGroupName = "-";

        this.deviceId = 0;
        this.deviceCode = "-";
        this.deviceName = "-";

        this.ingestTime = System.currentTimeMillis();
    }

    public void buildAlarmDetails() {
        this.details = AlarmHelper.buildAlarmDescriptionHTML(
                this.managedObject,
                this.severityLevelDesc,
                this.systemEventName,
                this.probableCause,
                this.specificProblem,
                this.createdTime,
                this.clearedTime,
                this.peerAddress,
                this.problemText,
                this.typeDesc
        );
    }

    public String getEventPoid() {
        return eventPoid;
    }

    public void setEventPoid(String eventPoid) {
        this.eventPoid = eventPoid;
    }

    public int getProbableCauseId() {
        return probableCauseId;
    }

    public void setProbableCauseId(int probableCauseId) {
        this.probableCauseId = probableCauseId;
    }

    public String getProbableCause() {
        return probableCause;
    }

    public void setProbableCause(String probableCause) {
        this.probableCause = probableCause;
    }

    public String getSpecificProblem() {
        return specificProblem;
    }

    public void setSpecificProblem(String specificProblem) {
        this.specificProblem = specificProblem;
    }

    public String getProblemText() {
        return problemText;
    }

    public void setProblemText(String problemText) {
        this.problemText = problemText;
    }

    public int getSeverityLevel() {
        return severityLevel;
    }

    public void setSeverityLevel(int severityLevel) {
        this.severityLevel = severityLevel;
    }

    public String getSeverityLevelDesc() {
        return severityLevelDesc;
    }

    public void setSeverityLevelDesc(String severityLevelDesc) {
        this.severityLevelDesc = severityLevelDesc;
    }

    public String getMajorType() {
        return majorType;
    }

    public void setMajorType(String majorType) {
        this.majorType = majorType;
    }

    public String getMinorType() {
        return minorType;
    }

    public void setMinorType(String minorType) {
        this.minorType = minorType;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getTypeDesc() {
        return typeDesc;
    }

    public void setTypeDesc(String typeDesc) {
        this.typeDesc = typeDesc;
    }

    public int getProtocol() {
        return protocol;
    }

    public void setProtocol(int protocol) {
        this.protocol = protocol;
    }

    public String getManagedObject() {
        return managedObject;
    }

    public void setManagedObject(String managedObject) {
        this.managedObject = managedObject;
    }

    public String getObject() {
        return object;
    }

    public void setObject(String object) {
        this.object = object;
    }

    public String getSubNetwork() {
        return subNetwork;
    }

    public void setSubNetwork(String subNetwork) {
        this.subNetwork = subNetwork;
    }

    public String getNetworkElement() {
        return networkElement;
    }

    public void setNetworkElement(String networkElement) {
        this.networkElement = networkElement;
    }

    public String getPeerAddress() {
        return peerAddress;
    }

    public void setPeerAddress(String peerAddress) {
        this.peerAddress = peerAddress;
    }

    public Date getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }

    public Long getCreatedTimeMs() {
        return createdTimeMs;
    }

    public void setCreatedTimeMs(Long createdTimeMs) {
        this.createdTimeMs = createdTimeMs;
    }

    public Date getClearedTime() {
        return clearedTime;
    }

    public void setClearedTime(Date clearedTime) {
        this.clearedTime = clearedTime;
    }

    public Long getClearedTimeMs() {
        return clearedTimeMs;
    }

    public void setClearedTimeMs(Long clearedTimeMs) {
        this.clearedTimeMs = clearedTimeMs;
    }

    public Long getDuration() {
        return duration;
    }

    public void setDuration(Long duration) {
        this.duration = duration;
    }

    public Long getDurationMs() {
        return durationMs;
    }

    public void setDurationMs(Long durationMs) {
        this.durationMs = durationMs;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getCustomEventType() {
        return customEventType;
    }

    public void setCustomEventType(int customEventType) {
        this.customEventType = customEventType;
    }

    public int getCustomEventId() {
        return customEventId;
    }

    public void setCustomEventId(int customEventId) {
        this.customEventId = customEventId;
    }

    public String getCustomEventName() {
        return customEventName;
    }

    public void setCustomEventName(String customEventName) {
        this.customEventName = customEventName;
    }

    public int getSystemEventId() {
        return systemEventId;
    }

    public void setSystemEventId(int systemEventId) {
        this.systemEventId = systemEventId;
    }

    public String getSystemEventName() {
        return systemEventName;
    }

    public void setSystemEventName(String systemEventName) {
        this.systemEventName = systemEventName;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getDeviceVendorName() {
        return deviceVendorName;
    }

    public void setDeviceVendorName(String deviceVendorName) {
        this.deviceVendorName = deviceVendorName;
    }

    public String getDeviceVendorCode() {
        return deviceVendorCode;
    }

    public void setDeviceVendorCode(String deviceVendorCode) {
        this.deviceVendorCode = deviceVendorCode;
    }

    public int getDeviceVendorId() {
        return deviceVendorId;
    }

    public void setDeviceVendorId(int deviceVendorId) {
        this.deviceVendorId = deviceVendorId;
    }

    public String getDeviceAreaName() {
        return deviceAreaName;
    }

    public void setDeviceAreaName(String deviceAreaName) {
        this.deviceAreaName = deviceAreaName;
    }

    public String getDeviceAreaCode() {
        return deviceAreaCode;
    }

    public void setDeviceAreaCode(String deviceAreaCode) {
        this.deviceAreaCode = deviceAreaCode;
    }

    public int getDeviceAreaId() {
        return deviceAreaId;
    }

    public void setDeviceAreaId(int deviceAreaId) {
        this.deviceAreaId = deviceAreaId;
    }

    public String getDeviceSysGroupName() {
        return deviceSysGroupName;
    }

    public void setDeviceSysGroupName(String deviceSysGroupName) {
        this.deviceSysGroupName = deviceSysGroupName;
    }

    public String getDeviceSysGroupCode() {
        return deviceSysGroupCode;
    }

    public void setDeviceSysGroupCode(String deviceSysGroupCode) {
        this.deviceSysGroupCode = deviceSysGroupCode;
    }

    public int getDeviceSysGroupId() {
        return deviceSysGroupId;
    }

    public void setDeviceSysGroupId(int deviceSysGroupId) {
        this.deviceSysGroupId = deviceSysGroupId;
    }

    public String getDeviceGroupName() {
        return deviceGroupName;
    }

    public void setDeviceGroupName(String deviceGroupName) {
        this.deviceGroupName = deviceGroupName;
    }

    public String getDeviceGroupCode() {
        return deviceGroupCode;
    }

    public void setDeviceGroupCode(String deviceGroupCode) {
        this.deviceGroupCode = deviceGroupCode;
    }

    public int getDeviceGroupId() {
        return deviceGroupId;
    }

    public void setDeviceGroupId(int deviceGroupId) {
        this.deviceGroupId = deviceGroupId;
    }

    public String getDeviceName() {
        return deviceName;
    }

    public void setDeviceName(String deviceName) {
        this.deviceName = deviceName;
    }

    public String getDeviceCode() {
        return deviceCode;
    }

    public void setDeviceCode(String deviceCode) {
        this.deviceCode = deviceCode;
    }

    public int getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(int deviceId) {
        this.deviceId = deviceId;
    }

    public String getRawData() {
        return rawData;
    }

    public void setRawData(String rawData) {
        this.rawData = rawData;
    }

    public String getOrder() {
        return order;
    }

    public void setOrder(String order) {
        this.order = order;
    }
}