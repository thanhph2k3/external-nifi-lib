package vn.vivas.nfm.nifi.models.decoded.aarenet;

import vn.vivas.nfm.nifi.models.AlarmRouting;
import vn.vivas.nfm.nifi.models.DecodedAlarm;
import vn.vivas.nfm.nifi.models.EnrichedNode;

public class AarenetDecodedAlarm extends DecodedAlarm {
    public AarenetDecodedAlarm(EnrichedNode enrichedNode, AlarmRouting alarmRouting) {
        super(enrichedNode, alarmRouting);
    }
}
