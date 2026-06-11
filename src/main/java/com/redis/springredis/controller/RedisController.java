package com.redis.springredis.controller;

import com.redis.springredis.dao.WrestlerRepo;
import com.redis.springredis.entity.Wrestler;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("/wrestler")
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
