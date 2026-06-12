package com.redis.springredis.redisatprimarydatabase.dao;

import com.redis.springredis.redisatprimarydatabase.entity.Wrestler;
import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import java.util.Map;

@Repository
@RequiredArgsConstructor
public class WrestlerRepo {
    private final RedisTemplate<String, Object> redisTemplate;
    /*
            |---key-->value
    KEY---->|---key-->value
            |---key-->value

    we make main key and under that key; we have hashkey-value
     */

    private static final String KEY = "WRESTLER";


    //Create
    public Wrestler save(Wrestler wrestler) {
        //(KEY, hash-key, value)
        redisTemplate.opsForHash().put(KEY, wrestler.getId(), wrestler);
        return wrestler;
    }

    //Read
    public Wrestler get(Short id) {
        return (Wrestler) redisTemplate.opsForHash().get(KEY, id);
    }

    public Map<Object, Object> findAll() {
        return redisTemplate.opsForHash().entries(KEY);
    }

    //Delete
    public void delete(Short id) {
        redisTemplate.opsForHash().delete(KEY, id);
    }
}
