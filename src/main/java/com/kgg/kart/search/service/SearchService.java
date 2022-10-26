package com.kgg.kart.search.service;

import com.kgg.kart.common.dto.CommonResponse;
import com.kgg.kart.search.domain.Search;
import com.kgg.kart.search.dto.DecodeResponse;
import com.kgg.kart.search.dto.SearchRequest;
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
        return commonResponse;
    }
}
