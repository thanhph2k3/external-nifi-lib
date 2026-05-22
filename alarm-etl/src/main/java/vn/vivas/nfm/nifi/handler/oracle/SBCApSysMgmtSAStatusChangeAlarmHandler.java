package vn.vivas.nfm.nifi.handler.oracle;

import vn.vivas.nfm.nifi.handler.AlarmTrapHandler;
import vn.vivas.nfm.nifi.mapper.oracle.SBCApSysMgmtSAStatusChangeAlarmMapper;
import vn.vivas.nfm.nifi.model.Alarm;
import vn.vivas.nfm.nifi.model.TrapID;
import vn.vivas.nfm.nifi.model.raw.oracle.SBCApSysMgmtSAStatusChangeAlarm;

import java.util.Map;

public class SBCApSysMgmtSAStatusChangeAlarmHandler implements AlarmTrapHandler<SBCApSysMgmtSAStatusChangeAlarm> {

    public static final TrapID TRAP_ID = TrapID.of("oracle.sbc.apSysMgmtSAStatusChange");

    private static final String LEGACY_NAME = "SBC_AP_SYS_MGMT_SA_STATUS_CHANGE";
    private static final String OID_AP_SYS_MGMT_SA_HOSTNAME = "1.3.6.1.4.1.9148.3.2.5.16";
    private static final String OID_AP_SYS_MGMT_SA_IP = "1.3.6.1.4.1.9148.3.2.5.17";
    private static final String OID_AP_SYS_MGMT_SA_STATUS = "1.3.6.1.4.1.9148.3.2.5.18";
    private static final String OID_AP_SYS_MGMT_SA_STATUS_REASON = "1.3.6.1.4.1.9148.3.2.5.19";

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
        return false;
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
