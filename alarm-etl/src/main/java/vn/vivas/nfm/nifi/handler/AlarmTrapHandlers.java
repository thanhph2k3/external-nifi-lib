package vn.vivas.nfm.nifi.handler;

import vn.vivas.nfm.nifi.handler.oracle.SBCApSwCfgActivateNotificationAlarmHandler;
import vn.vivas.nfm.nifi.handler.oracle.SBCApSysMgmtSAStatusChangeAlarmHandler;
import vn.vivas.nfm.nifi.handler.oracle.SBCApSyslogMessageGeneratedAlarmHandler;
import vn.vivas.nfm.nifi.model.raw.RawAlarm;

import java.util.ArrayList;
import java.util.List;
import java.util.ServiceLoader;

public final class AlarmTrapHandlers {

    private AlarmTrapHandlers() {
    }

    public static List<AlarmTrapHandler<? extends RawAlarm>> load() {
        List<AlarmTrapHandler<? extends RawAlarm>> handlers = new ArrayList<>(builtIn());
        loadServiceHandlers(handlers);
        return List.copyOf(handlers);
    }

    public static List<AlarmTrapHandler<? extends RawAlarm>> builtIn() {
        return List.of(
                new SBCApSysMgmtSAStatusChangeAlarmHandler(),
                new SBCApSyslogMessageGeneratedAlarmHandler(),
                new SBCApSwCfgActivateNotificationAlarmHandler()
        );
    }

    @SuppressWarnings({"rawtypes", "unchecked"})
    private static void loadServiceHandlers(List<AlarmTrapHandler<? extends RawAlarm>> handlers) {
        ServiceLoader.load(AlarmTrapHandler.class).forEach(handlers::add);
    }
}
