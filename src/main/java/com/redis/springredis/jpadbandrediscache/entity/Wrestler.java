package com.redis.springredis.jpadbandrediscache.entity;

import com.redis.springredis.jpadbandrediscache.dto.WrestlerDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Wrestler {
    @Id
    @SequenceGenerator(name = "wrestler_gen", sequenceName = "wrestler_seq", initialValue = 1, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "wrestler_gen")
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "finisher")
    private String finisher;

    @Column(name = "is_active")
    private boolean iSActive;

    public Wrestler(WrestlerDTO dto) {
        this.name = dto.getName();
        this.finisher = dto.getFinisher();
        this.iSActive = dto.isISActive();
    }
}
