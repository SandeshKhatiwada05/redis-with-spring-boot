package com.redis.springredis.jpadbandrediscache.service;

import com.redis.springredis.jpadbandrediscache.dto.WrestlerDTO;
import com.redis.springredis.jpadbandrediscache.entity.Wrestler;
import com.redis.springredis.jpadbandrediscache.exception.NoValueException;
import com.redis.springredis.jpadbandrediscache.repository.WrestlerRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
@CacheConfig(cacheNames = "wrestler")
public class WrestlerServiceImpl implements WrestlerService {

    private final WrestlerRepository wrestlerRepository;

    @Override
    @CachePut(key = "#result.id")
    public WrestlerDTO save(WrestlerDTO dto) {
        log.info("save() START: Storing information in both database and redis");
        Wrestler wrestler = new Wrestler(dto);
        wrestlerRepository.save(wrestler);
        log.info("Added {} to repository", dto.getName());
        return dto;
    }

    @Override
    @CacheEvict(key = "#id")
    public void delete(Integer id) {
        log.info("delete() START: Deleting Wrestler of Id {}", id);
        if (id == null || ObjectUtils.isEmpty(wrestlerRepository.findById(id))) {
            log.error("No such entity in repository found");
            throw new NoValueException("No Wrestler with id " + id);
        }
        wrestlerRepository.deleteById(id);
        log.info("Wrestler with id {} deleted successfully", id);
    }

    @Override
    @Cacheable(key = "#id")
    public WrestlerDTO getById(Integer id) {
        log.info("getById() START: Cache miss");
        if (id == null || ObjectUtils.isEmpty(wrestlerRepository.findById(id))) {
            log.error("No such Wrestler in repository found");
            throw new NoValueException("No Wrestler with id " + id);
        }
        Wrestler wrestler = wrestlerRepository.findById(id).orElse(null);
        if (ObjectUtils.isEmpty(wrestler)) {
            log.info("No Wrestler in repository found, returning null");
            return null;
        }
        return new WrestlerDTO(wrestler);
    }

    @Override
    //No annotation required
    public List<WrestlerDTO> getALl() {
        log.info("getALl() START");
        List<Wrestler> wrestlerList = wrestlerRepository.findAll();
        List<WrestlerDTO> wrestlerDTOList = new ArrayList<>();
        for (Wrestler wrestler : wrestlerList) {
            wrestlerDTOList.add(new WrestlerDTO(wrestler));
        }
        log.info("getAll() COMPLETE: Fetched all wrestlers from the repository");
        return wrestlerDTOList;
    }
}
