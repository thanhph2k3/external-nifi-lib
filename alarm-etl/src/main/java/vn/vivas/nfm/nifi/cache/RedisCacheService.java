package vn.vivas.nfm.nifi.cache;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.Protocol;
import redis.clients.jedis.exceptions.JedisException;

import org.apache.commons.pool2.impl.GenericObjectPoolConfig;

import java.io.IOException;
import java.net.URI;

public class RedisCacheService implements CacheService, AutoCloseable {
    private final JedisPool jedisPool;

    public RedisCacheService(JedisPool jedisPool) {
        this.jedisPool = jedisPool;
    }

    public RedisCacheService(String host, int port, String password) {
        this(createJedisPool(host, port, password));
    }

    public RedisCacheService(URI redisUri) {
        this(new JedisPool(redisUri));
    }

    @Override
    public void put(String key, String value) throws IOException {
        try (Jedis jedis = jedisPool.getResource()) {
            jedis.set(key, value);
        } catch (JedisException e) {
            throw new IOException("Failed to put value into Redis cache", e);
        }
    }

    @Override
    public String get(String key) throws IOException {
        try (Jedis jedis = jedisPool.getResource()) {
            return jedis.get(key);
        } catch (JedisException e) {
            throw new IOException("Failed to get value from Redis cache", e);
        }
    }

    @Override
    public boolean exists(String key) throws IOException {
        try (Jedis jedis = jedisPool.getResource()) {
            return jedis.exists(key);
        } catch (JedisException e) {
            throw new IOException("Failed to check Redis cache key", e);
        }
    }

    @Override
    public boolean remove(String key) throws IOException {
        try (Jedis jedis = jedisPool.getResource()) {
            return jedis.del(key) > 0;
        } catch (JedisException e) {
            throw new IOException("Failed to remove value from Redis cache", e);
        }
    }

    @Override
    public void close() {
        jedisPool.close();
    }

    private static JedisPool createJedisPool(String host, int port, String password) {
        if (password == null || password.isBlank()) {
            return new JedisPool(host, port);
        }

        return new JedisPool(
                new GenericObjectPoolConfig<>(),
                host,
                port,
                Protocol.DEFAULT_TIMEOUT,
                password
        );
    }
}