package vn.vivas.nfm.nifi.services.cache;

import java.io.IOException;

public interface CacheService {
    public void put(String key, String value) throws IOException;
    public String get(String key) throws IOException;
    public boolean exists(String key) throws IOException;
    public boolean remove(String key) throws IOException;
}