package com.kgg.kart.search.dto;

import lombok.Data;

@Data
public class MatchResponse {
    private String accountNo;
    private String matchId;
    private String matchType;
    private String teamId;
    private String character;
    private String startTime;
    private String endTime;
    private String channelName;
    private String trackId;
    private Integer playerCount;
    private Integer matchResult;
    private String seasonType;
}
