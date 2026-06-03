package vn.vivas.nfm.nifi.model;

import vn.vivas.nfm.nifi.model.cache.NodeRaw;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Node {

    private final int deviceVendorId;
    private final String deviceVendorCode;
    private final String deviceVendorName;
    private final int deviceAreaId;
    private final String deviceAreaCode;
    private final String deviceAreaName;
    private final int deviceSysGroupId;
    private final String deviceSysGroupCode;
    private final String deviceSysGroupName;
    private final int deviceGroupId;
    private final String deviceGroupName;
    private final String deviceGroupCode;
    private final int deviceId;
    private final String deviceCode;
    private final String deviceName;
    private final List<String> ipAddress;
    private final String ossNameIp;

    public Node() {
        this.deviceVendorId = 0;
        this.deviceVendorCode = "UNKNOWN";
        this.deviceVendorName = "Unknown";
        this.deviceAreaId = 0;
        this.deviceAreaCode = "UNKNOWN";
        this.deviceAreaName = "Unknown";
        this.deviceSysGroupId = 0;
        this.deviceSysGroupCode = "UNKNOWN";
        this.deviceSysGroupName = "Unknown";
        this.deviceGroupId = 0;
        this.deviceGroupName = "Unknown";
        this.deviceGroupCode = "UNKNOWN";
        this.deviceId = 0;
        this.deviceCode = "UNKNOWN";
        this.deviceName = "Unknown";
        this.ipAddress = new ArrayList<>();
        this.ossNameIp = "";
    }

    public Node(NodeRaw nodeRaw) {
        this.deviceVendorId = nodeRaw.getDeviceVendorID();
        this.deviceVendorCode = nodeRaw.getDeviceVendorCode();
        this.deviceVendorName = nodeRaw.getDeviceVendorName();

        this.deviceAreaId = nodeRaw.getDeviceAreaID();
        this.deviceAreaCode = nodeRaw.getDeviceAreaCode();
        this.deviceAreaName = nodeRaw.getDeviceAreaName();

        this.deviceSysGroupId = nodeRaw.getDeviceSysGroupID();
        this.deviceSysGroupCode = nodeRaw.getDeviceSysGroupCode();
        this.deviceSysGroupName = nodeRaw.getDeviceSysGroupName();

        this.deviceGroupId = nodeRaw.getDeviceGroupID();
        this.deviceGroupName = nodeRaw.getDeviceGroupName();
        this.deviceGroupCode = nodeRaw.getDeviceGroupCode();

        this.deviceId = nodeRaw.getDeviceID();
        this.deviceCode = nodeRaw.getDeviceCode();
        this.deviceName = nodeRaw.getDeviceName();

        this.ipAddress = nodeRaw.getIPAddress() == null || nodeRaw.getIPAddress().isBlank()
                ? List.of()
                : Arrays.stream(nodeRaw.getIPAddress().split(","))
                  .map(String::trim)
                  .filter(s -> !s.isEmpty())
                  .toList();
        this.ossNameIp = nodeRaw.getOSSNameIP();
    }

    public int getDeviceVendorID() {
        return deviceVendorId;
    }

    public String getDeviceVendorCode() {
        return deviceVendorCode;
    }

    public String getDeviceVendorName() {
        return deviceVendorName;
    }

    public int getDeviceAreaID() {
        return deviceAreaId;
    }

    public String getDeviceAreaCode() {
        return deviceAreaCode;
    }

    public String getDeviceAreaName() {
        return deviceAreaName;
    }

    public int getDeviceSysGroupID() {
        return deviceSysGroupId;
    }

    public String getDeviceSysGroupCode() {
        return deviceSysGroupCode;
    }

    public String getDeviceSysGroupName() {
        return deviceSysGroupName;
    }

    public int getDeviceGroupID() {
        return deviceGroupId;
    }

    public String getDeviceGroupName() {
        return deviceGroupName;
    }

    public String getDeviceGroupCode() {
        return deviceGroupCode;
    }

    public int getDeviceID() {
        return deviceId;
    }

    public String getDeviceCode() {
        return deviceCode;
    }

    public String getDeviceName() {
        return deviceName;
    }

    public List<String> getIpAddress() {
        return ipAddress;
    }

    public String getOSSNameIP() {
        return ossNameIp;
    }
}