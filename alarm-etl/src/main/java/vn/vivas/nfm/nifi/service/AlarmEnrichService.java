package vn.vivas.nfm.nifi.service;

import vn.vivas.nfm.nifi.model.EnrichedAlarm;
import vn.vivas.nfm.nifi.model.StandardizedAlarm;

public class AlarmEnrichService {
    public AlarmEnrichService() {

    }

    public EnrichedAlarm enrich(StandardizedAlarm standardizedAlarm) {
        return new EnrichedAlarm();
    }
}
