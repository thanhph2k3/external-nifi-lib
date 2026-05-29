package vn.vivas.nfm.nifi.services.alarm.decode;

import vn.vivas.nfm.nifi.models.AlarmSNMPTrap;
import vn.vivas.nfm.nifi.models.decoded.oracle.OracleDecodedAlarm;
import vn.vivas.nfm.nifi.services.cache.CacheService;

public class OracleAlarmDecodeService implements AlarmDecode<OracleDecodedAlarm> {

    private final CacheService cacheService;

    public OracleAlarmDecodeService(CacheService cacheService) {
        this.cacheService = cacheService;
    }

    @Override
    public OracleDecodedAlarm decode(AlarmSNMPTrap trap) {
        return null;
    }
}
