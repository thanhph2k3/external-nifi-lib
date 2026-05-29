package vn.vivas.nfm.nifi.models;

import vn.vivas.nfm.nifi.models.alarm.AlarmType;

public class AlarmRouting {
    private final AlarmType alarmType;
    private final int factoryID;
    private final int deviceGroupID;

    public AlarmRouting(AlarmType alarmType, int factoryID, int deviceGroupID) {
        this.alarmType = alarmType;
        this.factoryID = factoryID;
        this.deviceGroupID = deviceGroupID;
    }
}
