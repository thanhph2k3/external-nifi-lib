package vn.vivas.nfm.nifi.model.alarm;

import vn.vivas.nfm.nifi.model.AlarmEnrichmentField;

public class AlarmEnrichment {
    private final AlarmEnrichmentField device;
    private final AlarmEnrichmentField deviceGroup;
    private final AlarmEnrichmentField deviceSysGroup;
    private final AlarmEnrichmentField deviceVendor;

    public AlarmEnrichment(
            AlarmEnrichmentField device,
            AlarmEnrichmentField deviceGroup,
            AlarmEnrichmentField deviceSysGroup,
            AlarmEnrichmentField deviceVendor
    ) {
        this.device = device;
        this.deviceGroup = deviceGroup;
        this.deviceSysGroup = deviceSysGroup;
        this.deviceVendor = deviceVendor;
    }

    public AlarmEnrichmentField getDevice() {
        return device;
    }

    public AlarmEnrichmentField getDeviceGroup() {
        return deviceGroup;
    }

    public AlarmEnrichmentField getDeviceSysGroup() {
        return deviceSysGroup;
    }

    public AlarmEnrichmentField getDeviceVendor() {return deviceVendor;}
}
