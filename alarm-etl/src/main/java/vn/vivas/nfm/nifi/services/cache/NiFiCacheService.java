package vn.vivas.nfm.nifi.services.cache;

import org.apache.nifi.distributed.cache.client.Deserializer;
import org.apache.nifi.distributed.cache.client.DistributedMapCacheClient;
import org.apache.nifi.distributed.cache.client.Serializer;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class NiFiCacheService implements CacheService {
    private final DistributedMapCacheClient cacheClient;

    private final Serializer<String> stringSerializer = (value, out) ->
            out.write(value.getBytes(StandardCharsets.UTF_8));

    private final Deserializer<String> stringDeserializer = bytes ->
            (bytes == null || bytes.length == 0) ? null : new String(bytes, StandardCharsets.UTF_8);

    public NiFiCacheService(DistributedMapCacheClient cacheClient) {
        this.cacheClient = cacheClient;
    }

    public void put(String key, String value) throws IOException {
        cacheClient.put(key, value, stringSerializer, stringSerializer);
    }

    public String get(String key) throws IOException {
        return cacheClient.get(key, stringSerializer, stringDeserializer);
    }

    public boolean exists(String key) throws IOException {
        return cacheClient.containsKey(key, stringSerializer);
    }

    public boolean remove(String key) throws IOException {
        return cacheClient.remove(key, stringSerializer);
    }
}
