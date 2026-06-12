package com.redis.springredis.jpadbandrediscache.service;

import com.redis.springredis.jpadbandrediscache.dto.WrestlerDTO;

import java.util.List;

public interface WrestlerService {

    WrestlerDTO save(WrestlerDTO dto);
    void delete(Integer id);
    WrestlerDTO getById(Integer id);
    List<WrestlerDTO> getALl();
}
