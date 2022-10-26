package com.kgg.kart.recommend.service;

import com.amazonaws.services.s3.AmazonS3Client;
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
    @Value("${cloud.aws.s3.bucket-img}")
    private String bucketImg;
    @Value("${cloud.aws.s3.bucket-text}")
    private String bucketText;

    private final AmazonS3Client amazonS3Client;
    private CommonResponse commonResponse=new CommonResponse();
    public CommonResponse findKart(RecommendRequest recommendRequest){
        String path=String.join("/",recommendRequest.getChecks());
        RecommendResponse recommendResponse=new RecommendResponse();
        commonResponse.setMessage("성향을 기반으로 한 추천 결과입니다.");
        recommendResponse.setKartName(amazonS3Client.getUrl(bucketText,path).toString());
        recommendResponse.setKartUrl(amazonS3Client.getUrl(bucketImg,path).toString());
        commonResponse.setResult(recommendResponse);
        return commonResponse;
    }

}
