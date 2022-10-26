package com.kgg.kart.recommend.dto;

import lombok.Data;

import java.util.List;

@Data
public class RecommendRequest {
    private List<String> checks;
}
