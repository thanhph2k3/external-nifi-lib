package vn.vivas.nfm.nifi.model;

public class AlarmEnrichmentField {
    private final int id;
    private final String code;
    private final String name;

    public AlarmEnrichmentField(int id, String code, String name) {
        this.id = id;
        this.code = code;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name;
    }
}
