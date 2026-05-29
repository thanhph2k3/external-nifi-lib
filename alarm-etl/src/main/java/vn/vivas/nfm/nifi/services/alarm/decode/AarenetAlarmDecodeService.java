package vn.vivas.nfm.nifi.services.alarm.decode;

import vn.vivas.nfm.nifi.models.AlarmSNMPTrap;
import vn.vivas.nfm.nifi.models.decoded.aarenet.AarenetDecodedAlarm;
import vn.vivas.nfm.nifi.services.cache.CacheService;

public class AarenetAlarmDecodeService implements AlarmDecode<AarenetDecodedAlarm> {

    private final CacheService cacheService;

    public AarenetAlarmDecodeService(CacheService cacheService) {
        this.cacheService = cacheService;
    }

    @Override
    public AarenetDecodedAlarm decode(AlarmSNMPTrap trap) {
        return null;
    }
}
