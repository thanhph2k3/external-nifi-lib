package vn.vivas.nfm.nifi.model.alarm;

import lombok.Getter;
import vn.vivas.nfm.nifi.model.AlarmEnrichmentField;

@Getter
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
}
