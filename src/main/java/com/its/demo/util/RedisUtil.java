package com.its.demo.util;

import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

/**
 * Redis 工具类
 *
 * @Auther: 杨金刚
 * @Date: 2019/2/7 12:31
 */
@Component
public class RedisUtil {

    private StringRedisTemplate redisTemplate;

    /**
     * 普通缓存获取
     *
     * @param key 键
     * @return 值
     */
    public String getString(String key) {
        return key == null ? null : redisTemplate.opsForValue().get(key);
    }

    /**
     * 普通缓存放入
     *
     * @param key   键
     * @param value 值
     * @return true成功 false失败
     */
    public boolean setString(String key, String value) {
        try {
            redisTemplate.opsForValue().set(key, value);

            return true;
        } catch (Exception e) {
            e.printStackTrace();

            return false;
        }

    }

    /**
     * 普通缓存放入并设置时间
     *
     * @param key   键
     * @param value 值
     * @param time  时间(秒) time要大于0 如果time小于等于0 将设置无限期
     * @return true成功 false 失败
     */
    public boolean setString(String key, String value, long time) {
        try {
            if (time > 0) {
                redisTemplate.opsForValue().set(key, value, time, TimeUnit.SECONDS);
            } else {
                setString(key, value);
            }

            return true;
        } catch (Exception e) {
            e.printStackTrace();

            return false;
        }
    }


}
