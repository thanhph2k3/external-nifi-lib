package vn.vivas.nfm.nifi.services.alarm;

import vn.vivas.nfm.nifi.models.AlarmSNMPTrap;
import vn.vivas.nfm.nifi.models.DecodedAlarm;
import vn.vivas.nfm.nifi.models.SerializedAlarm;
import vn.vivas.nfm.nifi.models.StandardizedAlarm;

public class AlarmTransformService {

    private final AlarmDecodeService alarmDecodeService;
    private final AlarmStandardizeService alarmStandardizeService;
    private final AlarmSerializeService alarmSerializeService;

    public AlarmTransformService(
            AlarmDecodeService alarmDecodeService,
            AlarmStandardizeService alarmStandardizeService,
            AlarmSerializeService alarmSerializeService
    ) {
        this.alarmDecodeService = alarmDecodeService;
        this.alarmStandardizeService = alarmStandardizeService;
        this.alarmSerializeService = alarmSerializeService;
    }

    public SerializedAlarm tranform(AlarmSNMPTrap trap) {
        DecodedAlarm decodedAlarm = alarmDecodeService.decode(trap);
        StandardizedAlarm standardizedAlarm = alarmStandardizeService.standardize(decodedAlarm);
        return alarmSerializeService.serialize(standardizedAlarm);
    }
}
