package vn.vivas.nfm.nifi.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;

public class Alarm {

    // Alarm Basic Data

    @JsonProperty("event_poid")
    private String eventPoid;

    @JsonProperty("probable_cause_id")
    private Integer probableCauseId;

    @JsonProperty("probable_cause")
    private String probableCause;

    @JsonProperty("specific_problem")
    private String specificProblem;

    @JsonProperty("problem_text")
    private String problemText;

    @JsonProperty("severity_level")
    private Integer severityLevel;

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
    private Boolean status;

    // Other Data

    @JsonProperty("custom_event_type")
    private Integer customEventType;

    @JsonProperty("custom_event_id")
    private Integer customEventId;

    @JsonProperty("custom_event_name")
    private String customEventName;

    @JsonProperty("system_event_id")
    private Integer systemEventId;

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
    private String deviceVendorId;

    @JsonProperty("device_area_name")
    private String deviceAreaName;

    @JsonProperty("device_area_code")
    private String deviceAreaCode;

    @JsonProperty("device_area_id")
    private String deviceAreaId;

    @JsonProperty("device_sys_group_name")
    private String deviceSysGroupName;

    @JsonProperty("device_sys_group_code")
    private String deviceSysGroupCode;

    @JsonProperty("device_sys_group_id")
    private String deviceSysGroupId;

    @JsonProperty("device_group_name")
    private String deviceGroupName;

    @JsonProperty("device_group_code")
    private String deviceGroupCode;

    @JsonProperty("device_group_id")
    private String deviceGroupId;

    @JsonProperty("device_name")
    private String deviceName;

    @JsonProperty("device_code")
    private String deviceCode;

    @JsonProperty("device_id")
    private String deviceId;

    // Alarm Raw Data

    @JsonProperty("decode_data")
    private String decodeData;

    @JsonProperty("raw_data")
    private Object rawData;

    @JsonProperty("ingest_time")
    private Long ingestTime;

    public Alarm() {
    }

    public String getEventPoid() {
        return eventPoid;
    }

    public void setEventPoid(String eventPoid) {
        this.eventPoid = eventPoid;
    }

    public Integer getProbableCauseId() {
        return probableCauseId;
    }

    public void setProbableCauseId(Integer probableCauseId) {
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

    public Integer getSeverityLevel() {
        return severityLevel;
    }

    public void setSeverityLevel(Integer severityLevel) {
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

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public Integer getCustomEventType() {
        return customEventType;
    }

    public void setCustomEventType(Integer customEventType) {
        this.customEventType = customEventType;
    }

    public Integer getCustomEventId() {
        return customEventId;
    }

    public void setCustomEventId(Integer customEventId) {
        this.customEventId = customEventId;
    }

    public String getCustomEventName() {
        return customEventName;
    }

    public void setCustomEventName(String customEventName) {
        this.customEventName = customEventName;
    }

    public Integer getSystemEventId() {
        return systemEventId;
    }

    public void setSystemEventId(Integer systemEventId) {
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

    public String getDeviceVendorId() {
        return deviceVendorId;
    }

    public void setDeviceVendorId(String deviceVendorId) {
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

    public String getDeviceAreaId() {
        return deviceAreaId;
    }

    public void setDeviceAreaId(String deviceAreaId) {
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

    public String getDeviceSysGroupId() {
        return deviceSysGroupId;
    }

    public void setDeviceSysGroupId(String deviceSysGroupId) {
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

    public String getDeviceGroupId() {
        return deviceGroupId;
    }

    public void setDeviceGroupId(String deviceGroupId) {
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

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

    public Object getRawData() {
        return rawData;
    }

    public void setRawData(Object rawData) {
        this.rawData = rawData;
    }

    public String getDecodeData() {
        return decodeData;
    }

    public void setDecodeData(String decodeData) {
        this.decodeData = decodeData;
    }

    public Long getIngestTime() {
        return ingestTime;
    }

    public void setIngestTime(Long ingestTime) {
        this.ingestTime = ingestTime;
    }

    @Override
    public String toString() {
        return "Alarm";
    }
}