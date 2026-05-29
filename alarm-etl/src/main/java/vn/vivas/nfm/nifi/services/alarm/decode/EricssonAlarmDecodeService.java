package vn.vivas.nfm.nifi.services.alarm.decode;

import vn.vivas.nfm.nifi.models.AlarmSNMPTrap;
import vn.vivas.nfm.nifi.models.decoded.ericsson.EricssonDecodedAlarm;
import vn.vivas.nfm.nifi.services.cache.CacheService;

public class EricssonAlarmDecodeService implements AlarmDecode<EricssonDecodedAlarm> {

    private final CacheService cacheService;

    public EricssonAlarmDecodeService(CacheService cacheService) {
        this.cacheService = cacheService;
    }

    @Override
    public EricssonDecodedAlarm decode(AlarmSNMPTrap trap) {
        return null;
    }
}
