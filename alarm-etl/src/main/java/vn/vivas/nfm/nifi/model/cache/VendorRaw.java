package vn.vivas.nfm.nifi.model.cache;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class VendorRaw {
    private final String ID;
    private final String VENDOR_CODE;
    private final String VENDOR_NAME;
    private final String VENDOR_IPS;

    @JsonCreator
    public VendorRaw(
            @JsonProperty("ID") String ID,
            @JsonProperty("VENDOR_CODE") String VENDOR_CODE,
            @JsonProperty("VENDOR_NAME") String VENDOR_NAME,
            @JsonProperty("VENDOR_IPS") String VENDOR_IPS
    ) {
        this.ID = ID;
        this.VENDOR_CODE = VENDOR_CODE;
        this.VENDOR_NAME = VENDOR_NAME;
        this.VENDOR_IPS = VENDOR_IPS;
    }

    public String getID() {
        return ID;
    }

    public String getCode() {
        return VENDOR_CODE;
    }

    public String getName() {
        return VENDOR_NAME;
    }

    public String getIPS() {
        return VENDOR_IPS;
    }
}
