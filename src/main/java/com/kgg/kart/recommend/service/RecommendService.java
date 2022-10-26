package com.kgg.kart.recommend.service;

import com.kgg.kart.common.dto.CommonResponse;
import com.kgg.kart.recommend.dto.RecommendRequest;
import com.kgg.kart.recommend.dto.RecommendResponse;
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

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class RecommendService {
    private CommonResponse commonResponse=new CommonResponse();
    public CommonResponse findKart(RecommendRequest recommendRequest){
        String result=String.join("/",recommendRequest.getChecks());

        return commonResponse;
    }

}
