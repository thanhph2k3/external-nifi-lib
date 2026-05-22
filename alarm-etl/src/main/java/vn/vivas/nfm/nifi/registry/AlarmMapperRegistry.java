package vn.vivas.nfm.nifi.registry;

import vn.vivas.nfm.nifi.enums.TrapType;
import vn.vivas.nfm.nifi.exception.UnsupportedTrapException;
import vn.vivas.nfm.nifi.mapper.AlarmMapper;
import vn.vivas.nfm.nifi.model.raw.RawAlarm;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class AlarmMapperRegistry {
    private final Map<TrapType, AlarmMapper<? extends RawAlarm>> alarmMappers;

    public AlarmMapperRegistry(List<AlarmMapper<? extends RawAlarm>> alarmMappers) {
        this.alarmMappers = alarmMappers.stream()
                .collect(Collectors.toMap(
                        AlarmMapper::getTrapType,
                        Function.identity(),
                        (first, second) -> {
                            throw new IllegalArgumentException(
                                    "Duplicate mapper for trap type " + first.getTrapType()
                            );
                        }
                ));
    }

    public AlarmMapper<? extends RawAlarm> getMapper(RawAlarm rawAlarm) {
        AlarmMapper<? extends RawAlarm> alarmMapper = this.alarmMappers.get(rawAlarm.getTrapType());
        if (alarmMapper == null) {
            throw new UnsupportedTrapException("Trap type " + rawAlarm.getTrapType() + " is not supported");
        }
        return alarmMapper;
    }
}
