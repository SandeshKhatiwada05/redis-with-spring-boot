package com.redis.springredis.jpadbandrediscache;

import com.redis.springredis.jpadbandrediscache.dto.WrestlerDTO;
import com.redis.springredis.jpadbandrediscache.service.WrestlerService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/wrestler")
public class WrestlerController {

    private final WrestlerService wrestlerService;

    //Insert value
    @PostMapping
    public WrestlerDTO saveWrester(@RequestBody WrestlerDTO wrestlerDTO) {
        return wrestlerService.save(wrestlerDTO);
    }

    //View by id
    @GetMapping("/{id}")
    public WrestlerDTO getById(@PathVariable Integer id) {
        return wrestlerService.getById(id);
    }

    //view all data
    @GetMapping
    public List<WrestlerDTO> getWrestler() {
        return wrestlerService.getALl();
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Integer id) {
        wrestlerService.delete(id);
    }
}
