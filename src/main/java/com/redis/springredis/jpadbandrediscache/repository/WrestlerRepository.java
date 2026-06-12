package com.redis.springredis.jpadbandrediscache.repository;

import com.redis.springredis.jpadbandrediscache.entity.Wrestler;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WrestlerRepository extends JpaRepository<Wrestler, Integer> {
}
