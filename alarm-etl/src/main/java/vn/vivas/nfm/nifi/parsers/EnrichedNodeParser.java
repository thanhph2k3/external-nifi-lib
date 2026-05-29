package vn.vivas.nfm.nifi.parsers;

import vn.vivas.nfm.nifi.exceptions.ParseException;
import vn.vivas.nfm.nifi.models.EnrichedNode;
import vn.vivas.nfm.nifi.models.alarm.AlarmMetadata;

public class EnrichedNodeParser {
    public static EnrichedNode parseEnrichedNodeFromString(String enrichedNodeRaw) {
        if (enrichedNodeRaw == null || enrichedNodeRaw.isBlank()) {
            throw new ParseException("enrichedNodeRaw cannot be null or blank");
        }

        try {
            AlarmMetadata deviceArea = new AlarmMetadata(1, "area", "area");
            AlarmMetadata deviceVendor =  new AlarmMetadata(1, "vendor", "vendor");
            AlarmMetadata deviceSysGroup = new AlarmMetadata(1, "device", "device");
            AlarmMetadata deviceGroup = new AlarmMetadata(1, "group", "group");
            AlarmMetadata device = new AlarmMetadata(1, "device", "device");
            return new EnrichedNode(deviceArea, deviceVendor, deviceSysGroup, deviceGroup, device);
        } catch (Exception e) {
            throw new ParseException(e.getMessage());
        }
    }
}
