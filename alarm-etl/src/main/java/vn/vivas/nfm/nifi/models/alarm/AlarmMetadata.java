package vn.vivas.nfm.nifi.models.alarm;

public class AlarmMetadata {
    private int id;
    private String code;
    private String name;

    public AlarmMetadata(int id, String code, String name) {
        this.id = id;
        this.code = code;
        this.name = name;
    }
}
