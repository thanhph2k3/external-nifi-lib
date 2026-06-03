package vn.vivas.nfm.nifi.model.alarm;

public record AlarmSource(
        String managedObject,
        String object,
        String subNetwork,
        String networkElement,
        String peerAddress
) {
}
