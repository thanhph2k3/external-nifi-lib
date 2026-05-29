package vn.vivas.nfm.nifi.models.decoded.oracle;

import vn.vivas.nfm.nifi.models.AlarmRouting;
import vn.vivas.nfm.nifi.models.DecodedAlarm;
import vn.vivas.nfm.nifi.models.EnrichedNode;

public class OracleDecodedAlarm extends DecodedAlarm {
    public OracleDecodedAlarm(EnrichedNode enrichedNode, AlarmRouting alarmRouting) {
        super(enrichedNode, alarmRouting);
    }
}