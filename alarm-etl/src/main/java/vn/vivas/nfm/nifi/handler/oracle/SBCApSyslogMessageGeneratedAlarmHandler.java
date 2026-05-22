package vn.vivas.nfm.nifi.handler.oracle;

import vn.vivas.nfm.nifi.handler.AlarmTrapHandler;
import vn.vivas.nfm.nifi.mapper.oracle.SBCApSyslogMessageGeneratedAlarmMapper;
import vn.vivas.nfm.nifi.model.Alarm;
import vn.vivas.nfm.nifi.model.TrapID;
import vn.vivas.nfm.nifi.model.raw.oracle.SBCApSyslogMessageGeneratedAlarm;

import java.util.Map;

public class SBCApSyslogMessageGeneratedAlarmHandler implements AlarmTrapHandler<SBCApSyslogMessageGeneratedAlarm> {

    public static final TrapID TRAP_ID = TrapID.of("oracle.sbc.apSyslogMessageGenerated");

    private static final String LEGACY_NAME = "SBC_AP_SYSLOG_MESSAGE_GENERATED_ALARM";

    private final SBCApSyslogMessageGeneratedAlarmMapper mapper;

    public SBCApSyslogMessageGeneratedAlarmHandler() {
        this(new SBCApSyslogMessageGeneratedAlarmMapper());
    }

    public SBCApSyslogMessageGeneratedAlarmHandler(SBCApSyslogMessageGeneratedAlarmMapper mapper) {
        this.mapper = mapper;
    }

    @Override
    public TrapID trapId() {
        return TRAP_ID;
    }

    @Override
    public Class<SBCApSyslogMessageGeneratedAlarm> rawAlarmClass() {
        return SBCApSyslogMessageGeneratedAlarm.class;
    }

    @Override
    public boolean supports(Map<String, Object> rawObject) {
        return false;
    }

    @Override
    public SBCApSyslogMessageGeneratedAlarm parse(Map<String, Object> rawObject) {
        return new SBCApSyslogMessageGeneratedAlarm(rawObject);
    }

    @Override
    public Alarm map(SBCApSyslogMessageGeneratedAlarm rawAlarm) {
        return mapper.map(rawAlarm);
    }
}
