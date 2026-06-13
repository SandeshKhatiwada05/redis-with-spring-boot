package com.redis.springredis.jpadbandrediscache.dto;


import com.redis.springredis.jpadbandrediscache.entity.Wrestler;
import jakarta.annotation.Nullable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class WrestlerDTO implements Serializable {

    @Nullable
    private Integer id;

    private String name;

    private String finisher;

    private boolean iSActive;

    public WrestlerDTO(Wrestler wrestler) {
        this.id = wrestler.getId();
        this.name = wrestler.getName();
        this.finisher = wrestler.getFinisher();
        this.iSActive = wrestler.isISActive();
    }
}
