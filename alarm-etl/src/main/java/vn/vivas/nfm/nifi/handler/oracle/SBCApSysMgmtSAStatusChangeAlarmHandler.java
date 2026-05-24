package vn.vivas.nfm.nifi.handler.oracle;

import vn.vivas.nfm.nifi.handler.AlarmTrapHandler;
import vn.vivas.nfm.nifi.handler.support.SnmpTrapSupport;
import vn.vivas.nfm.nifi.mapper.oracle.SBCApSysMgmtSAStatusChangeAlarmMapper;
import vn.vivas.nfm.nifi.model.Alarm;
import vn.vivas.nfm.nifi.model.TrapID;
import vn.vivas.nfm.nifi.model.raw.oracle.SBCApSysMgmtSAStatusChangeAlarm;

import java.util.Map;

public class SBCApSysMgmtSAStatusChangeAlarmHandler implements AlarmTrapHandler<SBCApSysMgmtSAStatusChangeAlarm> {

    public static final TrapID TRAP_ID = TrapID.of("1.3.6.1.4.1.9148.3.2.6.0.15");

    private final SBCApSysMgmtSAStatusChangeAlarmMapper mapper;

    public SBCApSysMgmtSAStatusChangeAlarmHandler() {
        this(new SBCApSysMgmtSAStatusChangeAlarmMapper());
    }

    public SBCApSysMgmtSAStatusChangeAlarmHandler(SBCApSysMgmtSAStatusChangeAlarmMapper mapper) {
        this.mapper = mapper;
    }

    @Override
    public TrapID trapId() {
        return TRAP_ID;
    }

    @Override
    public Class<SBCApSysMgmtSAStatusChangeAlarm> rawAlarmClass() {
        return SBCApSysMgmtSAStatusChangeAlarm.class;
    }

    @Override
    public boolean supports(Map<String, Object> rawObject) {
        return SnmpTrapSupport.describeTrap(rawObject).equals(trapId().value());
    }

    @Override
    public SBCApSysMgmtSAStatusChangeAlarm parse(Map<String, Object> rawObject) {
        return new SBCApSysMgmtSAStatusChangeAlarm(rawObject);
    }

    @Override
    public Alarm map(SBCApSysMgmtSAStatusChangeAlarm rawAlarm) {
        return mapper.map(rawAlarm);
    }
}
