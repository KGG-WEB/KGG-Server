package com.kgg.kart.search.dto;

import lombok.Data;

import java.util.List;

@Data
public class MatchesResponse {
    private List<MatchResponse> matches;
}
