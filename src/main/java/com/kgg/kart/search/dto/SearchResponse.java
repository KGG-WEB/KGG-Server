package com.kgg.kart.search.dto;

import lombok.Data;

@Data
public class SearchResponse {
    private String matchType;
    private String character;
    private String startTime;
    private String endTime;
    private String trackId;
    private Integer playerCount;
    private Integer matchResult;
}
