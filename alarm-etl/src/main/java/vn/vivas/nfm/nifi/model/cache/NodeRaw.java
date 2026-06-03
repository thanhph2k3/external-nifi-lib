package vn.vivas.nfm.nifi.model.cache;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class NodeRaw {
    private final int DEVICE_VENDOR_ID;
    private final String DEVICE_VENDOR_CODE;
    private final String DEVICE_VENDOR_NAME;
    private final int DEVICE_AREA_ID;
    private final String DEVICE_AREA_CODE;
    private final String DEVICE_AREA_NAME;
    private final int DEVICE_SYS_GROUP_ID;
    private final String DEVICE_SYS_GROUP_CODE;
    private final String DEVICE_SYS_GROUP_NAME;
    private final int DEVICE_GROUP_ID;
    private final String DEVICE_GROUP_NAME;
    private final String DEVICE_GROUP_CODE;
    private final int DEVICE_ID;
    private final String DEVICE_CODE;
    private final String DEVICE_NAME;
    private final String IP_ADDRESS;
    private final String OSS_NAME_IP;

    @JsonCreator
    public NodeRaw(
            @JsonProperty("DEVICE_VENDOR_ID") int DEVICE_VENDOR_ID,
            @JsonProperty("DEVICE_VENDOR_CODE") String DEVICE_VENDOR_CODE,
            @JsonProperty("DEVICE_VENDOR_NAME") String DEVICE_VENDOR_NAME,
            @JsonProperty("DEVICE_AREA_ID") int DEVICE_AREA_ID,
            @JsonProperty("DEVICE_AREA_CODE") String DEVICE_AREA_CODE,
            @JsonProperty("DEVICE_AREA_NAME") String DEVICE_AREA_NAME,
            @JsonProperty("DEVICE_SYS_GROUP_ID") int DEVICE_SYS_GROUP_ID,
            @JsonProperty("DEVICE_SYS_GROUP_CODE") String DEVICE_SYS_GROUP_CODE,
            @JsonProperty("DEVICE_SYS_GROUP_NAME") String DEVICE_SYS_GROUP_NAME,
            @JsonProperty("DEVICE_GROUP_ID") int DEVICE_GROUP_ID,
            @JsonProperty("DEVICE_GROUP_NAME") String DEVICE_GROUP_NAME,
            @JsonProperty("DEVICE_GROUP_CODE") String DEVICE_GROUP_CODE,
            @JsonProperty("DEVICE_ID") int DEVICE_ID,
            @JsonProperty("DEVICE_CODE") String DEVICE_CODE,
            @JsonProperty("DEVICE_NAME") String DEVICE_NAME,
            @JsonProperty("IP_ADDRESS") String IP_ADDRESS,
            @JsonProperty("OSS_NAME_IP") String OSS_NAME_IP
    ) {
        this.DEVICE_VENDOR_ID = DEVICE_VENDOR_ID;
        this.DEVICE_VENDOR_CODE = DEVICE_VENDOR_CODE;
        this.DEVICE_VENDOR_NAME = DEVICE_VENDOR_NAME;
        this.DEVICE_AREA_ID = DEVICE_AREA_ID;
        this.DEVICE_AREA_CODE = DEVICE_AREA_CODE;
        this.DEVICE_AREA_NAME = DEVICE_AREA_NAME;
        this.DEVICE_SYS_GROUP_ID = DEVICE_SYS_GROUP_ID;
        this.DEVICE_SYS_GROUP_CODE = DEVICE_SYS_GROUP_CODE;
        this.DEVICE_SYS_GROUP_NAME = DEVICE_SYS_GROUP_NAME;
        this.DEVICE_GROUP_ID = DEVICE_GROUP_ID;
        this.DEVICE_GROUP_NAME = DEVICE_GROUP_NAME;
        this.DEVICE_GROUP_CODE = DEVICE_GROUP_CODE;
        this.DEVICE_ID = DEVICE_ID;
        this.DEVICE_CODE = DEVICE_CODE;
        this.DEVICE_NAME = DEVICE_NAME;
        this.IP_ADDRESS = IP_ADDRESS;
        this.OSS_NAME_IP = OSS_NAME_IP;
    }

    public int getDeviceVendorID() {
        return DEVICE_VENDOR_ID;
    }

    public String getDeviceVendorCode() {
        return DEVICE_VENDOR_CODE;
    }

    public String getDeviceVendorName() {
        return DEVICE_VENDOR_NAME;
    }

    public int getDeviceAreaID() {
        return DEVICE_AREA_ID;
    }

    public String getDeviceAreaCode() {
        return DEVICE_AREA_CODE;
    }

    public String getDeviceAreaName() {
        return DEVICE_AREA_NAME;
    }

    public int getDeviceSysGroupID() {
        return DEVICE_SYS_GROUP_ID;
    }

    public String getDeviceSysGroupCode() {
        return DEVICE_SYS_GROUP_CODE;
    }

    public String getDeviceSysGroupName() {
        return DEVICE_SYS_GROUP_NAME;
    }

    public int getDeviceGroupID() {
        return DEVICE_GROUP_ID;
    }

    public String getDeviceGroupName() {
        return DEVICE_GROUP_NAME;
    }

    public String getDeviceGroupCode() {
        return DEVICE_GROUP_CODE;
    }

    public int getDeviceID() {
        return DEVICE_ID;
    }

    public String getDeviceCode() {
        return DEVICE_CODE;
    }

    public String getDeviceName() {
        return DEVICE_NAME;
    }

    public String getIPAddress() {
        return IP_ADDRESS;
    }

    public String getOSSNameIP() {
        return OSS_NAME_IP;
    }
}
