package com.kgg.kart.search.service;

import com.kgg.kart.common.dto.CommonResponse;
import com.kgg.kart.search.domain.Search;
import com.kgg.kart.search.dto.*;
import com.kgg.kart.search.exception.ApiException;
import com.kgg.kart.search.repository.SearchRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class SearchService {
    @Value("${nexon.kart.key}")
    private String key;
    @Value("${nexon.kart.url")
    private String baseUrl;
    private final SearchRepository searchRepository;
    private CommonResponse commonResponse=new CommonResponse();
    public String saveInfo(String nickname){
        RestTemplate restTemplate=new RestTemplate();
        Search search=new Search();
        HttpHeaders headers=new HttpHeaders();
        headers.set("Authorization", key);
        HttpEntity request=new HttpEntity(headers);
        String url=baseUrl+"/"+nickname;
        try{
            ResponseEntity<DecodeResponse> result=restTemplate.exchange(url, HttpMethod.GET, request, DecodeResponse.class);
            search.setNickname(nickname);
            search.setDecode(result.getBody().getAccessId());
            search.setLevel(result.getBody().getLevel());
            searchRepository.save(search);
        }catch(Exception e) {
            throw new ApiException("넥슨과 통신에 실패했습니다.");
        }
        return search.getDecode();
    }
    public CommonResponse sendNexon(SearchRequest searchRequest){
        String decode=saveInfo(searchRequest.getNickname());
        RestTemplate restTemplate=new RestTemplate();
        HttpHeaders headers=new HttpHeaders();
        headers.set("Authorization", key);
        HttpEntity request=new HttpEntity(headers);
        String url=baseUrl+"/"+decode;
        try{
            ResponseEntity<MatchesResponse> result=restTemplate.exchange(url, HttpMethod.GET, request, MatchesResponse.class);
            List<SearchResponse> searchResponses= new ArrayList<>();
            tenSearchResponse tenSearchResponse=new tenSearchResponse();
            for(MatchResponse match: result.getBody().getMatches()){
                SearchResponse searchResponse=new SearchResponse();
                searchResponse.setCharacter(match.getCharacter());
                searchResponse.setEndTime(match.getEndTime());
                searchResponse.setMatchResult(match.getMatchResult());
                searchResponse.setMatchType(match.getMatchType());
                searchResponse.setPlayerCount(match.getPlayerCount());
                searchResponse.setStartTime(match.getStartTime());
                searchResponse.setTrackId(match.getTrackId());
                searchResponses.add(searchResponse);
            }
            tenSearchResponse.setSearchResponses(searchResponses);
            commonResponse.setMessage("최근 10게임 전적 조회 결과입니다.");
            commonResponse.setResult(tenSearchResponse);
        }catch(Exception e) {
            throw new ApiException("넥슨과 통신에 실패했습니다.");
        }
        return commonResponse;
    }
}
