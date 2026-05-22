package vn.vivas.nfm.nifi.model.raw.oracle;

import com.fasterxml.jackson.annotation.JsonProperty;
import vn.vivas.nfm.nifi.model.raw.RawAlarm;

import java.util.Map;

public class SBCApSysMgmtSAStatusChangeAlarm extends RawAlarm {

    private static final String OID_AP_SYS_MGMT_SA_HOSTNAME = "1.3.6.1.4.1.9148.3.2.5.16";
    private static final String OID_AP_SYS_MGMT_SA_IP = "1.3.6.1.4.1.9148.3.2.5.17";
    private static final String OID_AP_SYS_MGMT_SA_STATUS = "1.3.6.1.4.1.9148.3.2.5.18";
    private static final String OID_AP_SYS_MGMT_SA_STATUS_REASON = "1.3.6.1.4.1.9148.3.2.5.19";

    @JsonProperty("apSysMgmtSAHostname")
    private String apSysMgmtSAHostname;

    @JsonProperty("apSysMgmtSAIP")
    private String apSysMgmtSAIP;

    @JsonProperty("apSysMgmtSAStatus")
    private String apSysMgmtSAStatus;

    @JsonProperty("apSysMgmtSAStatusReason")
    private String apSysMgmtSAStatusReason;

    public SBCApSysMgmtSAStatusChangeAlarm(Map<String, Object> rawObject) {
        parseAlarmFromRaw(rawObject);
    }

    @Override
    protected void parseAlarmFromRaw(Map<String, Object> rawObject) {
        if (rawObject == null) {
            return;
        }

        rawObject.forEach((key, value) -> {
            String oid = extractOID(key);
            if (oid == null || this.parseCommonField(oid, value)) {
                return;
            }

            String fieldValue = parseFieldValue(value);
            switch (oid) {
                case OID_AP_SYS_MGMT_SA_HOSTNAME -> this.apSysMgmtSAHostname = fieldValue;
                case OID_AP_SYS_MGMT_SA_IP -> this.apSysMgmtSAIP = fieldValue;
                case OID_AP_SYS_MGMT_SA_STATUS -> this.apSysMgmtSAStatus = fieldValue;
                case OID_AP_SYS_MGMT_SA_STATUS_REASON -> this.apSysMgmtSAStatusReason = fieldValue;
            }
        });
    }
}
