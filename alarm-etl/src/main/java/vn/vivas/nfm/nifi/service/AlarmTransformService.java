package vn.vivas.nfm.nifi.service;

import vn.vivas.nfm.nifi.detector.oracle.SBCApSwCfgActivateNotificationAlarmDetector;
import vn.vivas.nfm.nifi.detector.oracle.SBCApSysMgmtSAStatusChangeAlarmDetector;
import vn.vivas.nfm.nifi.detector.oracle.SBCApSyslogMessageGeneratedAlarmDetector;
import vn.vivas.nfm.nifi.factory.RawAlarmFactory;
import vn.vivas.nfm.nifi.mapper.AlarmMapper;
import vn.vivas.nfm.nifi.mapper.oracle.SBCApSwCfgActivateNotificationAlarmMapper;
import vn.vivas.nfm.nifi.mapper.oracle.SBCApSysMgmtSAStatusChangeAlarmMapper;
import vn.vivas.nfm.nifi.mapper.oracle.SBCApSyslogMessageGeneratedAlarmMapper;
import vn.vivas.nfm.nifi.model.Alarm;
import vn.vivas.nfm.nifi.model.raw.RawAlarm;
import vn.vivas.nfm.nifi.parser.RawJsonParser;
import vn.vivas.nfm.nifi.registry.AlarmMapperRegistry;

import java.util.List;
import java.util.Map;

public class AlarmTransformService {

    private final RawAlarmFactory rawAlarmFactory;
    private final AlarmMapperRegistry alarmMapperRegistry;

    public AlarmTransformService() {
        this.rawAlarmFactory = new RawAlarmFactory(List.of(
                new SBCApSwCfgActivateNotificationAlarmDetector(),
                new SBCApSyslogMessageGeneratedAlarmDetector(),
                new SBCApSysMgmtSAStatusChangeAlarmDetector()
        ));
        this.alarmMapperRegistry = new AlarmMapperRegistry(List.of(
                new SBCApSysMgmtSAStatusChangeAlarmMapper(),
                new SBCApSyslogMessageGeneratedAlarmMapper(),
                new SBCApSwCfgActivateNotificationAlarmMapper()
        ));
    }

    public Alarm transform(String rawJson) {
        Map<String, Object> rawObject = RawJsonParser.parseObjectFromString(rawJson);
        RawAlarm rawAlarm = rawAlarmFactory.create(rawObject);
        AlarmMapper<? extends RawAlarm> mapper = alarmMapperRegistry.getMapper(rawAlarm);
        return mapper.mapRaw(rawAlarm);
    }
}
