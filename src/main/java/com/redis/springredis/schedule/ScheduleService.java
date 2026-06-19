package com.redis.springredis.schedule;

import com.redis.springredis.jpadbandrediscache.dto.WrestlerDTO;
import com.redis.springredis.jpadbandrediscache.service.WrestlerService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class ScheduleService {

    private final WrestlerService wrestlerService;

    @Scheduled(initialDelay = 5000, fixedDelay = 60000) //60 seconds
    public void informWrestlerInfo() {
        log.info("informWrestlerInfo() START");

        //view data
        List<WrestlerDTO> allWrestlers = wrestlerService.getALl();
        for (WrestlerDTO wrestler : allWrestlers) {
            if (wrestler.isISActive()) {
                log.info("{} is still Active", wrestler.getName());
            } else {
                log.info("{} is inactive", wrestler.getName());
            }
        }
        log.info("Scheduled fetch success");
    }
}
