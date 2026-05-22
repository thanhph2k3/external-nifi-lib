package vn.vivas.nfm.nifi.service;

import vn.vivas.nfm.nifi.handler.AlarmTrapHandler;
import vn.vivas.nfm.nifi.handler.AlarmTrapHandlers;
import vn.vivas.nfm.nifi.model.Alarm;
import vn.vivas.nfm.nifi.model.raw.RawAlarm;
import vn.vivas.nfm.nifi.parser.RawJsonParser;
import vn.vivas.nfm.nifi.registry.AlarmTrapHandlerRegistry;

import java.util.List;
import java.util.Map;
import java.util.Objects;

public class AlarmTransformService {

    private final AlarmTrapHandlerRegistry alarmTrapHandlerRegistry;

    public AlarmTransformService() {
        this(AlarmTrapHandlers.load());
    }

    public AlarmTransformService(List<AlarmTrapHandler<? extends RawAlarm>> handlers) {
        this.alarmTrapHandlerRegistry = new AlarmTrapHandlerRegistry(
                Objects.requireNonNull(handlers, "handlers must not be null")
        );
    }

    public Alarm transform(String rawJson) {
        Map<String, Object> rawObject = RawJsonParser.parseObjectFromString(rawJson);
        return alarmTrapHandlerRegistry.transform(rawObject);
    }
}
