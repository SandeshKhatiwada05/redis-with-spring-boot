package com.redis.springredis.redisatprimarydatabase.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;

@Configuration
public class RedisConfiguration {

    @Bean
    public RedisConnectionFactory connectionFactory() {
        return new LettuceConnectionFactory();
    }

    @Bean
    public RedisTemplate<String, Object> redisTemplate() {
        RedisTemplate<String, Object> redisTemplate = new RedisTemplate<>();
        //1. connection factory
        redisTemplate.setConnectionFactory(connectionFactory());

        //2. key serializer
        redisTemplate.setKeySerializer(new StringRedisSerializer());

        /*
        3. Value Serializer
        For spring Boot 4 setting value serializer is different
         */
        redisTemplate.setValueSerializer(new StringRedisSerializer());
        return redisTemplate;
    }
}
