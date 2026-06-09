package vn.vivas.nfm.nifi.model;

import lombok.Getter;
import vn.vivas.nfm.nifi.model.cache.VendorRaw;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Getter
public class Vendor {
    private final int id;
    private final String code;
    private final String name;
    private final List<String> ipAddresses;

    public static final String AARENET = "AARENET";
    public static final String ERICSSON = "ERICSSON";
    public static final String NOKIA = "NOKIA";
    public static final String NFVI = "NFVI";
    public static final String OCS = "OCS";
    public static final String ORACLE = "ORACLE";
    public static final String TEKELEC = "TEKELEC";

    public Vendor() {
        this.id = 0;
        this.code = "UNKNOWN";
        this.name = "UNKNOWN";
        this.ipAddresses = new ArrayList<>();
    }

    public Vendor(int id, String code, String name, List<String> ipAddresses) {
        this.id = id;
        this.code = code;
        this.name = name;
        this.ipAddresses = ipAddresses;
    }

    public Vendor(VendorRaw vendorRaw) {
        this.id = Integer.parseInt(vendorRaw.getID());
        this.code = vendorRaw.getCode();
        this.name = vendorRaw.getName();
        this.ipAddresses = vendorRaw.getIPS() == null || vendorRaw.getIPS().isBlank()
                ? List.of()
                : Arrays.stream(vendorRaw.getIPS().split(","))
                  .map(String::trim)
                  .filter(s -> !s.isEmpty())
                  .toList();
    }
}
