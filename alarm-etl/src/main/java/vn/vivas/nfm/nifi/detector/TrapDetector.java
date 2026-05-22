package vn.vivas.nfm.nifi.detector;

import vn.vivas.nfm.nifi.enums.TrapType;

import java.util.Map;

public interface TrapDetector {
    TrapType getTrapType();
    boolean detect(Map<String, Object> rawObject);
}
