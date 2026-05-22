package vn.vivas.nfm.nifi.registry;

import vn.vivas.nfm.nifi.exception.AmbiguousTrapException;
import vn.vivas.nfm.nifi.exception.UnsupportedTrapException;
import vn.vivas.nfm.nifi.handler.AlarmTrapHandler;
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
    private final Map<TrapID, AlarmTrapHandler<? extends RawAlarm>> handlersById;

    public AlarmTrapHandlerRegistry(List<AlarmTrapHandler<? extends RawAlarm>> handlers) {
        if (handlers == null || handlers.isEmpty()) {
            throw new IllegalArgumentException("handlers must not be empty");
        }

        this.handlers = List.copyOf(handlers);
        this.handlersById = this.handlers.stream()
                .collect(Collectors.toMap(
                        AlarmTrapHandler::trapId,
                        Function.identity(),
                        (first, second) -> {
                            throw new IllegalArgumentException("Duplicate handler for trap " + first.trapId());
                        }
                ));
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
            throw new UnsupportedTrapException("Raw alarm type " + rawObject.get("type") + " is not supported");
        }

        if (matchedHandlers.size() > 1) {
            String trapIds = matchedHandlers.stream()
                    .map(handler -> handler.trapId().toString())
                    .collect(Collectors.joining(", "));
            throw new AmbiguousTrapException("Raw alarm matches multiple traps: " + trapIds);
        }

        return matchedHandlers.getFirst();
    }

    public AlarmTrapHandler<? extends RawAlarm> getHandler(TrapID trapId) {
        AlarmTrapHandler<? extends RawAlarm> handler = handlersById.get(trapId);
        if (handler == null) {
            throw new UnsupportedTrapException("Trap " + trapId + " is not supported");
        }
        return handler;
    }
}
