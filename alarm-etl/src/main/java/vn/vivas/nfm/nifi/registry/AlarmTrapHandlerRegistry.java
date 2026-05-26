package vn.vivas.nfm.nifi.registry;

import vn.vivas.nfm.nifi.exception.AmbiguousTrapException;
import vn.vivas.nfm.nifi.exception.UnsupportedTrapException;
import vn.vivas.nfm.nifi.handler.AlarmTrapHandler;
import vn.vivas.nfm.nifi.handler.support.SnmpTrapSupport;
import vn.vivas.nfm.nifi.model.Alarm;
import vn.vivas.nfm.nifi.model.TrapID;
import vn.vivas.nfm.nifi.model.raw.RawAlarm;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.function.Function;
import java.util.stream.Collectors;

public class AlarmTrapHandlerRegistry {

    private final List<AlarmTrapHandler<? extends RawAlarm>> handlers;

    public AlarmTrapHandlerRegistry(List<AlarmTrapHandler<? extends RawAlarm>> handlers) {
        if (handlers == null || handlers.isEmpty()) {
            throw new IllegalArgumentException("handlers must not be empty");
        }

        this.handlers = List.copyOf(handlers);
    }

    public Alarm transform(Map<String, Object> rawObject) {
        return findHandler(rawObject).transform(rawObject);
    }

    public AlarmTrapHandler<? extends RawAlarm> findHandler(Map<String, Object> rawObject) {
        Objects.requireNonNull(rawObject, "rawObject must not be null");

        List<AlarmTrapHandler<? extends RawAlarm>> matchedHandlers = handlers.stream()
                .filter(handler -> handler.supports(rawObject))
                .toList();

        if (matchedHandlers.isEmpty()) {
            throw new UnsupportedTrapException(
                    "Alarm trap " + SnmpTrapSupport.getTrapType(rawObject) + " is not supported"
            );
        }

        if (matchedHandlers.size() > 1) {
            String trapIds = matchedHandlers.stream()
                    .map(handler -> handler.trapId().toString())
                    .collect(Collectors.joining(", "));
            throw new AmbiguousTrapException("Raw alarm matches multiple traps: " + trapIds);
        }

        return matchedHandlers.getFirst();
    }
}
