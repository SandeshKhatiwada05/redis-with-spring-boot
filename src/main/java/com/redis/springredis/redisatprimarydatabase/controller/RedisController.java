package com.redis.springredis.redisatprimarydatabase.controller;

import com.redis.springredis.redisatprimarydatabase.dao.WrestlerRepo;
import com.redis.springredis.redisatprimarydatabase.entity.Wrestler;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("/wrestlerRedis")
public class RedisController {

    private final WrestlerRepo wrestlerRepo;

    @PostMapping
    public Wrestler saveWrestler(@RequestBody Wrestler wrestler) {
        return wrestlerRepo.save(wrestler);
    }

    @GetMapping("/{id}")
    public Wrestler getWrestler(@PathVariable Short id) {
        return wrestlerRepo.get(id);
    }

    @GetMapping
    public Map<Object, Object> getAllWrestlers() {
        return wrestlerRepo.findAll();
    }

    @DeleteMapping("/{id}")
    public void deleteWrestler(@PathVariable Short id) {
        wrestlerRepo.delete(id);
    }
}
