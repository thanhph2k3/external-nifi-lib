package vn.vivas.nfm.nifi.services.alarm;

import vn.vivas.nfm.nifi.helpers.IPHelper;
import vn.vivas.nfm.nifi.models.AlarmSNMPTrap;
import vn.vivas.nfm.nifi.models.DecodedAlarm;
import vn.vivas.nfm.nifi.models.decoded.ericsson.EricssonDecodedAlarm;
import vn.vivas.nfm.nifi.services.alarm.decode.AarenetAlarmDecodeService;
import vn.vivas.nfm.nifi.services.alarm.decode.EricssonAlarmDecodeService;
import vn.vivas.nfm.nifi.services.alarm.decode.OracleAlarmDecodeService;
import vn.vivas.nfm.nifi.services.cache.CacheService;

public class AlarmDecodeService {

    private static final String ERICSSON_IPS = "10.149.187.0/26,10.149.191.0/26,10.201.42.128/26,10.149.230.0/26,10.161.8.0/26,10.161.65.0/26,10.161.69.128/26,10.161.65.128/26";
    private static final String AARENET_IPS = "";
    private static final String NOKIA_IPS = "10.217.118.13";
    private static final String ORACLE_IPS = "10.149.206.33,10.149.206.34,10.149.206.35,10.149.206.36,10.149.206.193,10.149.206.194,10.149.206.195,10.149.206.196,10.149.206.197,10.149.206.198,10.149.206.199,10.149.207.33,10.149.207.34,10.149.207.35,10.149.207.36,10.149.207.193,10.149.207.194,10.149.207.195,10.149.207.196,10.149.207.197,10.149.207.198,10.149.207.199,10.149.206.100,10.149.206.101,10.149.206.102,10.149.207.100,10.149.207.101,10.149.207.102,10.155.19.148,10.155.19.149,10.155.19.206,10.155.19.207";
    private static final String TEKELEC_IPS = "10.204.92.3,10.204.92.4,10.204.93.3,10.204.93.4,10.161.6.6,10.161.6.7,10.204.191.3,10.204.191.4,10.204.192.3,10.204.192.4,10.161.6.53,10.161.6.54";
    private static final String NFVI_IPS = "10.201.52.4,10.201.52.64/27,10.149.215.4,10.149.215.64/27,10.149.214.4,10.149.214.64/27,10.149.188.4,10.149.188.80/28,10.201.44.36,10.201.44.96/27,10.201.42.36,10.201.97.0/27,10.161.9.4,10.161.9.48/28,10.161.7.4,10.161.7.48/28,10.161.2.52,10.149.242.36,10.149.242.16/28,10.201.115.4,10.161.4.52,10.149.238.68,10.149.238.4,10.202.82.132,10.202.82.116,10.149.198.84,10.149.198.4,10.202.50.100,10.202.50.36,10.149.174.68,10.149.174.4,10.202.39.68,10.202.39.4,10.161.12.52,10.161.12.4,10.149.238.164,10.149.238.132,10.161.13.52,10.161.13.4,10.202.48.100,10.202.48.36,10.149.175.68,10.149.175.4,10.149.208.84,10.149.208.4,10.149.244.20,10.149.244.36,10.161.11.52,10.161.11.4,10.149.197.4,10.149.237.4,10.149.225.4,10.161.10.4,10.204.227.4,10.149.202.100,10.162.0.116,10.149.197.84,10.149.237.68,10.149.225.68,10.161.10.52,10.204.227.68,10.149.202.84,10.162.0.132";
    private static final String OCS_IPS = "10.212.6.93";

    private final CacheService cacheService;

    public AlarmDecodeService(CacheService cacheService) {
        this.cacheService = cacheService;
    }

    public DecodedAlarm decode(AlarmSNMPTrap trap) {
        int factoryID = this.routingByIP(trap);
        return switch (factoryID) {
            case 1 -> (new EricssonAlarmDecodeService(cacheService)).decode(trap);
            case 2 -> (new AarenetAlarmDecodeService(cacheService)).decode(trap);
            case 4 -> (new OracleAlarmDecodeService(cacheService)).decode(trap);
            default -> throw new IllegalArgumentException("Unknown factory ID: " + factoryID);
        };
    }

    private int routingByIP(AlarmSNMPTrap trap) {
        String sourceIP = trap.getPeerAddress();
        if (IPHelper.matches(sourceIP, ERICSSON_IPS)) {
            return 1;
        } else if (IPHelper.matches(sourceIP, AARENET_IPS)) {
            return 2;
        } else if (IPHelper.matches(sourceIP, NOKIA_IPS)) {
            return 3;
        } else if (IPHelper.matches(sourceIP, ORACLE_IPS)) {
            return 4;
        } else if (IPHelper.matches(sourceIP, TEKELEC_IPS)) {
            return 5;
        } else if (IPHelper.matches(sourceIP, NFVI_IPS)) {
            return 6;
        } else if (IPHelper.matches(sourceIP, OCS_IPS)) {
            return 7;
        } else return 0;
    }
}