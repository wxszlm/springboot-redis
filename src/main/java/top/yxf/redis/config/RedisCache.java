package top.yxf.redis.config;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.ibatis.cache.Cache;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import top.yxf.redis.utils.ApplicationContextUtil;

import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class RedisCache implements Cache {

    private String id;

    public RedisCache(String id) {

        System.out.println("当前的id为--->" + id);

        this.id = id;
    }

    @Override
    public String getId() {
        return id;
    }

    /**
     * 放入缓存
     *
     * @param key
     * @param value
     */
    @Override
    public void putObject(Object key, Object value) {

//        System.out.println(key + "key ---》 ");
//        System.out.println(value + "value ---》 ");

        RedisTemplate redisTemplate = (RedisTemplate) ApplicationContextUtil.getBean("redisTemplate");
        ObjectMapper objectMapper = new ObjectMapper();
        // 指定要序列化的域，field,get和set,以及修饰符范围，ANY是都有包括private和public
        objectMapper.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.ANY);
        // 指定序列化输入的类型，类必须是非final修饰的，final修饰的类，比如String,Integer等会跑出异常
        objectMapper.enableDefaultTyping(ObjectMapper.DefaultTyping.NON_FINAL);
        Jackson2JsonRedisSerializer<Object> objectJackson2JsonRedisSerializer = new Jackson2JsonRedisSerializer<>(Object.class);
        objectJackson2JsonRedisSerializer.setObjectMapper(objectMapper);
        redisTemplate.setKeySerializer(new StringRedisSerializer());
        redisTemplate.setValueSerializer(objectJackson2JsonRedisSerializer);
        redisTemplate.setHashKeySerializer(new StringRedisSerializer());
        redisTemplate.setHashValueSerializer(objectJackson2JsonRedisSerializer);
        redisTemplate.opsForHash().put(id,key.toString(),value);
        redisTemplate.opsForValue().set(key.toString(),value);
    }

    /**
     * 获取缓存数据
     *
     * @param key
     * @return
     */
    @Override
    public Object getObject(Object key) {
        RedisTemplate redisTemplate = (RedisTemplate) ApplicationContextUtil.getBean("redisTemplate");
        ObjectMapper objectMapper = new ObjectMapper();
        // 指定要序列化的域，field,get和set,以及修饰符范围，ANY是都有包括private和public
        objectMapper.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.ANY);
        // 指定序列化输入的类型，类必须是非final修饰的，final修饰的类，比如String,Integer等会跑出异常
        objectMapper.enableDefaultTyping(ObjectMapper.DefaultTyping.NON_FINAL);
        Jackson2JsonRedisSerializer<Object> objectJackson2JsonRedisSerializer = new Jackson2JsonRedisSerializer<>(Object.class);
        objectJackson2JsonRedisSerializer.setObjectMapper(objectMapper);
        redisTemplate.setKeySerializer(new StringRedisSerializer());
        redisTemplate.setValueSerializer(objectJackson2JsonRedisSerializer);
        redisTemplate.setHashKeySerializer(new StringRedisSerializer());
        redisTemplate.setHashValueSerializer(objectJackson2JsonRedisSerializer);
        return redisTemplate.opsForHash().get(id,key.toString());
//        return redisTemplate.opsForValue().get(key.toString());
    }

    /**
     * 移除缓存
     *
     * @param o
     * @return
     */
    @Override
    public Object removeObject(Object o) {
        System.out.println("删除数据");

        return null;
    }

    /**
     * 清除缓存
     */
    @Override
    public void clear() {
        System.out.println("清空数据");
        RedisTemplate redisTemplate = (RedisTemplate) ApplicationContextUtil.getBean("redisTemplate");
        redisTemplate.setKeySerializer(new StringRedisSerializer());
//        redisTemplate.delete(redisTemplate.keys("*"));

        redisTemplate.setHashKeySerializer(new StringRedisSerializer());
        redisTemplate.delete(id);



    }

    /**
     * 获取缓存的大小
     *
     * @return
     */
    @Override
    public int getSize() {
        RedisTemplate redisTemplate = (RedisTemplate) ApplicationContextUtil.getBean("redisTemplate");
        return redisTemplate.keys("*").size();
    }

    /**
     * 读写锁   ReadWriteLock 读写不互斥 读读不互斥 写写不互斥  synchronized 读读互斥 读写互斥
     *
     * @return
     */
    @Override
    public ReadWriteLock getReadWriteLock() {
        return new ReentrantReadWriteLock();
    }
}
