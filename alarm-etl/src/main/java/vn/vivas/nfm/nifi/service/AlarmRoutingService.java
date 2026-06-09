package vn.vivas.nfm.nifi.service;

import vn.vivas.nfm.nifi.cache.CacheService;
import vn.vivas.nfm.nifi.helper.IPHelper;
import vn.vivas.nfm.nifi.model.*;
import vn.vivas.nfm.nifi.model.alarm.AlarmEnrichment;
import vn.vivas.nfm.nifi.model.cache.NodeRaw;
import vn.vivas.nfm.nifi.model.cache.VendorRaw;
import vn.vivas.nfm.nifi.parser.JsonStringParser;

import java.io.IOException;
import java.util.List;

public class AlarmRoutingService {

    public static final String VENDOR_DATA_CACHE_KEY = "nfm:alarm-etl:vendors";
    public static final String NODE_DATA_CACHE_KEY = "nfm:alarm-etl:nodes";

    private final CacheService cacheService;
    public AlarmRoutingService(CacheService cacheService) {
        this.cacheService = cacheService;
    }

    public AlarmSNMPWithRouting route(AlarmSNMPTrap alarmSNMPTrap) throws IOException {

        String nodeDataRaw = cacheService.get(NODE_DATA_CACHE_KEY);
        String vendorDataRaw = cacheService.get(VENDOR_DATA_CACHE_KEY);
        List<VendorRaw> vendorRaws =
                JsonStringParser.parseObjectsFromString(
                        vendorDataRaw,
                        VendorRaw.class);
        List<NodeRaw> nodeRaws =
                JsonStringParser.parseObjectsFromString(
                        nodeDataRaw,
                        NodeRaw.class);
        List<Vendor> vendors = vendorRaws.stream()
                .map(Vendor::new)
                .toList();
        List<Node> nodes = nodeRaws.stream()
                .map(Node::new)
                .toList();
        Vendor matchedVendor = vendors
                .stream()
                .filter(vendor -> IPHelper.matches(alarmSNMPTrap.getPeerAddress().split("/")[0], vendor.getIpAddresses()))
                .findFirst()
                .orElse(new Vendor());

        switch (matchedVendor.getCode()) {
            case Vendor.TEKELEC, Vendor.ORACLE, Vendor.NFVI -> {
                Node matchedNode = nodes
                        .stream()
                        .filter(node -> IPHelper.matches(alarmSNMPTrap.getPeerAddress().split("/")[0], node.getIpAddress()))
                        .findFirst()
                        .orElse(new Node());
                AlarmEnrichment alarmEnrichment = getEnrichment(matchedNode);
                return new AlarmSNMPWithRouting(alarmSNMPTrap, alarmEnrichment);
            }
            default -> {
                AlarmEnrichment alarmEnrichment = getEnrichment(new Node());
                return new AlarmSNMPWithRouting(alarmSNMPTrap, alarmEnrichment);
            }
        }
    }

    private static AlarmEnrichment getEnrichment(Node matchedNode) {
        AlarmEnrichmentField alarmDevice = new AlarmEnrichmentField(
                matchedNode.getDeviceID(), matchedNode.getDeviceCode(), matchedNode.getDeviceName()
        );
        AlarmEnrichmentField alarmDeviceGroup = new AlarmEnrichmentField(
                matchedNode.getDeviceGroupID(), matchedNode.getDeviceGroupCode(), matchedNode.getDeviceGroupName()
        );
        AlarmEnrichmentField alarmDeviceSysGroup = new AlarmEnrichmentField(
                matchedNode.getDeviceSysGroupID(), matchedNode.getDeviceSysGroupCode(), matchedNode.getDeviceSysGroupName()
        );
        AlarmEnrichmentField alarmDeviceVendor = new AlarmEnrichmentField(
                matchedNode.getDeviceVendorID(), matchedNode.getDeviceVendorCode(), matchedNode.getDeviceVendorName()
        );
        return new AlarmEnrichment(alarmDevice, alarmDeviceGroup, alarmDeviceSysGroup, alarmDeviceVendor);
    }
}
