package com.cccs7.user.cache;

import com.cccs7.redis.init.AbstractCache;
import com.cccs7.redis.util.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

@Component
public class SysUserCache extends AbstractCache {

    private static final String SYS_USER_CACHE_KEY = "SYS_USER";

    @Autowired
    private RedisTemplate redisTemplate;

    @Autowired
    private RedisUtil redisUtil;

    @Override
    public void initCache() {
        redisUtil.set("age", "18");
    }

    @Override
    public <T> T getCache(String key) {

        if (redisTemplate.hasKey(key).booleanValue()) {
            reloadCache();
        }
        return (T) redisTemplate.opsForValue().get(key);
    }

    @Override
    public void clearCache() {
        super.clearCache();
    }

    @Override
    public void reloadCache() {
        redisTemplate.delete(SysUserCache.SYS_USER_CACHE_KEY);
    }
}
