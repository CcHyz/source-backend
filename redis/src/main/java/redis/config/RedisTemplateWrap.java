package redis.config;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.util.ReflectionUtils;

import javax.annotation.Resource;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Map;

/**
 * redis封装.
 *
 * @param <K> 键
 * @param <V> 值
 * @author Cc 2024/9/6 9:22
 */
@Component
public class RedisTemplateWrap<K, V> {
    @Resource
    private RedisTemplate<K, V> redisTemplate;

    /**
     * 设置数据.
     *
     * @param key    键
     * @param object 值
     */
    public void set(K key, V object) {
        redisTemplate.opsForValue().set(key, object);
    }

    /**
     * 设置数组对象数据-固定key.
     *
     * @param key    键
     * @param object 值
     */
    public <T extends V> void setCollection(K key, Collection<T> object) {
        object.forEach(v -> {
            redisTemplate.opsForList().rightPush(key, v);
        });
    }

    /**
     * 设置数组对象数据-单对象.
     *
     * @param key    键
     * @param object 值
     */
    public <T extends V> void setCollection(K key, T object) {
        redisTemplate.opsForList().rightPush(key, object);
    }

    /**
     * 设置数组对象数据-自定义key.
     *
     * @param key    键
     * @param addKey 通过此字段名获取T中的字段值拼接Key
     * @param object 值
     */
    public <T extends V> void setCollection(K key, String[] addKey, Collection<T> object) {
        object.forEach(v -> {
            K ks = key;
            if (key instanceof String) {
                Class<?> classV = v.getClass();
                StringBuilder stringBuilder = new StringBuilder();
                Arrays.asList(addKey).forEach(ak -> {
                    Field field = ReflectionUtils.findField(classV, ak);
                    if (field != null) {
                        ReflectionUtils.makeAccessible(field);
                        Object valueByKey = ReflectionUtils.getField(field, v);
                        stringBuilder.append(valueByKey);
                    }
                });
                ks = (K) (key + stringBuilder.toString());
            }
            redisTemplate.opsForList().rightPush(ks, v);
        });
    }

    /**
     * 设置HASH数据.
     *
     * @param key   键
     * @param value 值
     */
    public void setHash(K key, Map<?, ?> value) {
        if (Boolean.TRUE.equals(redisTemplate.hasKey(key))) {
            value.forEach((keys, values) -> redisTemplate.opsForHash().putIfAbsent(key, keys, values));
        }
        redisTemplate.opsForHash().putAll(key, value);
    }

    /**
     * 获取HASH数据.
     *
     * @param key     键
     * @param hashKey 值
     */
    public <HK, T> T getHash(K key, HK hashKey, Class<T> object) {
        return (T) redisTemplate.opsForHash().get(key, hashKey);
    }

    /**
     * 获取数据.
     *
     * @param key 键
     * @return T
     */
    public <T> T get(K key, Class<T> entityClass) {
        return (T) redisTemplate.opsForValue().get(key);
    }

    /**
     * 获取数据.
     *
     * @param key 键
     * @return V
     */
    public V get(K key) {
        return redisTemplate.opsForValue().get(key);
    }


    /**
     * 获取List数据.
     *
     * @param key 键
     * @return List<T>
     */
    public <T> List<T> getList(K key, Class<T> object) {
        V v = redisTemplate.opsForValue().get(key);
        if (v != null) {
            return (List<T>) v;
        }
        return null;
    }
}
