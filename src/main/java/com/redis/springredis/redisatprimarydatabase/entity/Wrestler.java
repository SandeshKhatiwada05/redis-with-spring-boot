package com.redis.springredis.redisatprimarydatabase.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Wrestler implements Serializable {
    private Short id;
    private String wrestlerName;
    private boolean isActive;
}
