package com.kgg.kart.search.domain;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Data
public class Search {
    @Id
    @GeneratedValue
    private Long mapId;
    private String nickname;
    private Integer level;
    private String decode;
}
