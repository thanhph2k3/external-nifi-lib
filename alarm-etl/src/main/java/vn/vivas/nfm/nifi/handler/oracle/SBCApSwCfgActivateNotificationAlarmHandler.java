package vn.vivas.nfm.nifi.handler.oracle;

import vn.vivas.nfm.nifi.handler.AlarmTrapHandler;
import vn.vivas.nfm.nifi.mapper.oracle.SBCApSwCfgActivateNotificationAlarmMapper;
import vn.vivas.nfm.nifi.model.Alarm;
import vn.vivas.nfm.nifi.model.TrapID;
import vn.vivas.nfm.nifi.model.raw.oracle.SBCApSwCfgActivateNotificationAlarm;

import java.util.Map;

public class SBCApSwCfgActivateNotificationAlarmHandler implements AlarmTrapHandler<SBCApSwCfgActivateNotificationAlarm> {

    public static final TrapID TRAP_ID = TrapID.of("oracle.sbc.apSwCfgActivateNotification");

    private static final String LEGACY_NAME = "SBC_AP_SW_CFG_ACTIVATE_NOTIFICATION";

    private final SBCApSwCfgActivateNotificationAlarmMapper mapper;

    public SBCApSwCfgActivateNotificationAlarmHandler() {
        this(new SBCApSwCfgActivateNotificationAlarmMapper());
    }

    public SBCApSwCfgActivateNotificationAlarmHandler(SBCApSwCfgActivateNotificationAlarmMapper mapper) {
        this.mapper = mapper;
    }

    @Override
    public TrapID trapId() {
        return TRAP_ID;
    }

    @Override
    public Class<SBCApSwCfgActivateNotificationAlarm> rawAlarmClass() {
        return SBCApSwCfgActivateNotificationAlarm.class;
    }

    @Override
    public boolean supports(Map<String, Object> rawObject) {
        return false;
    }

    @Override
    public SBCApSwCfgActivateNotificationAlarm parse(Map<String, Object> rawObject) {
        return new SBCApSwCfgActivateNotificationAlarm(rawObject);
    }

    @Override
    public Alarm map(SBCApSwCfgActivateNotificationAlarm rawAlarm) {
        return mapper.map(rawAlarm);
    }
}
