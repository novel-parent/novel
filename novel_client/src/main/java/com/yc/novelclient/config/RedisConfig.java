package com.yc.novelclient.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.listener.RedisMessageListenerContainer;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;

/**
 * @author LX
 * @date 2019/6/14 - 12:18
 */
@Configuration
public class RedisConfig {

//    @Primary
//    @Bean

    public RedisTemplate<Object,Object> redisTemplate(RedisConnectionFactory connectionFactory ){

        RedisTemplate<Object,Object> redisTemplate = new RedisTemplate<Object,Object>();
        redisTemplate.setConnectionFactory(connectionFactory);
        redisTemplate.setDefaultSerializer(new Jackson2JsonRedisSerializer<Object>(Object.class));
        return redisTemplate;
    }

    @Bean
    RedisMessageListenerContainer container(RedisConnectionFactory connectionFactory) {

        RedisMessageListenerContainer container = new RedisMessageListenerContainer();

        container.setConnectionFactory(connectionFactory);

//        container.addMessageListener(new RedisExpiredListener(), new PatternTopic("__keyevent@0__:expired"));
        return container;
    }

    /**
     *
     * 设置缓存 时间  为30分钟
     * 定制缓存的 的 一些规则
     * @param redisTemplate
     * @return
     */
    @Bean
    public RedisCacheManager novelChaptersRedisCacheManager(RedisTemplate<Object,Object> redisTemplate){

        long time = 60;
        RedisCacheManager cacheManager = new RedisCacheManager(redisTemplate);

        // key 多了一个前缀
        // 在这个地方设置了  使用前缀   会将 CacheName 作为前缀
        cacheManager.setUsePrefix(true);

        cacheManager.setDefaultExpiration(time);

        return cacheManager;
    }
}
