package org.elastos.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

@Component
public class RedisCacheUtil {

    @Autowired
    private StringRedisTemplate redis;

    public String saveData(String key, String data, long expireHours) {
        redis.boundValueOps(key).set(data);
        redis.boundValueOps(key).expire(expireHours, TimeUnit.HOURS);
        return key;
    }

    public void deleteData(String key) {
        redis.delete(key);
    }

    public String getData(String key) {
        String value = redis.boundValueOps(key).get();
        return value;
    }
}
