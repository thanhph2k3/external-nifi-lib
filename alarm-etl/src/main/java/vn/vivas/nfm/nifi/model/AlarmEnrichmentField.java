package vn.vivas.nfm.nifi.model;

import lombok.Getter;

@Getter
public class AlarmEnrichmentField {
    private final int id;
    private final String code;
    private final String name;

    public AlarmEnrichmentField(int id, String code, String name) {
        this.id = id;
        this.code = code;
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}
