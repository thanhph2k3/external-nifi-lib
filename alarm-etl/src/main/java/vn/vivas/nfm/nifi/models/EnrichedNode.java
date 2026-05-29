package vn.vivas.nfm.nifi.models;

import vn.vivas.nfm.nifi.models.alarm.AlarmMetadata;

public record EnrichedNode(AlarmMetadata deviceArea, AlarmMetadata deviceVendor, AlarmMetadata deviceSysGroup,
                           AlarmMetadata deviceGroup, AlarmMetadata device) {
}
