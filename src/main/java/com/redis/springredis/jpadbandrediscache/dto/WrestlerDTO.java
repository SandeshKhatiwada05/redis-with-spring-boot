package com.redis.springredis.jpadbandrediscache.dto;


import com.redis.springredis.jpadbandrediscache.entity.Wrestler;
import jakarta.annotation.Nullable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class WrestlerDTO {

    @Nullable
    private Integer id;

    private String name;

    private String finisher;

    private String iSActive;

    public WrestlerDTO(Wrestler wrestler) {
        this.name = wrestler.getName();
        this.finisher = wrestler.getFinisher();
        this.iSActive = wrestler.getISActive();
    }
}
