package com.foolish.springcache.config;

import com.alibaba.fastjson.support.spring.FastJsonRedisSerializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.RedisConfiguration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.*;

import java.time.Duration;

/**
 * @author chaoxianfei
 * @date 2020/01/19
 * @describe
 **/
@Configuration
public class RedisConfig {

    private Duration LIVE_TO_TIME = Duration.ofDays(1);

    @Bean
    public RedisCacheManager cacheManager(RedisConnectionFactory connectionFactory){
        RedisCacheConfiguration cacheConfiguration = RedisCacheConfiguration.defaultCacheConfig()
                .entryTtl(LIVE_TO_TIME)
                .serializeKeysWith(RedisSerializationContext.SerializationPair.fromSerializer(keySerializer()))
                .serializeValuesWith(RedisSerializationContext.SerializationPair.fromSerializer(fastJsonValueSerializer()))
                .disableCachingNullValues();
        RedisCacheManager cacheManager = RedisCacheManager.builder(connectionFactory)
                .cacheDefaults(cacheConfiguration).transactionAware().build();
        return cacheManager;
    }

    @Bean
    public RedisTemplate<String,Object> redisTemplate(RedisConnectionFactory redisConnectionFactory){
        RedisTemplate<String, Object> template = new RedisTemplate<>();
        template.setConnectionFactory(redisConnectionFactory);
        template.setKeySerializer(keySerializer());
        template.setHashValueSerializer(keySerializer());
        template.setValueSerializer(fastJsonValueSerializer());
        template.setHashKeySerializer(fastJsonValueSerializer());
        //Jackson2JsonRedisSerializer serializer = new Jackson2JsonRedisSerializer<>(Object.class);
        FastJsonRedisSerializer serializer = new FastJsonRedisSerializer(Object.class);
        template.setDefaultSerializer(serializer);
        return template;
    }

    private RedisSerializer fastJsonValueSerializer() {
        return new FastJsonRedisSerializer(Object.class);
    }

    private RedisSerializer keySerializer() {
        return new StringRedisSerializer();
    }

    private RedisSerializer valueSerializer() {
        return new GenericJackson2JsonRedisSerializer();
    }
}
