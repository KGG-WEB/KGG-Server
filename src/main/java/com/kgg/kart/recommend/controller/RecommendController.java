package com.kgg.kart.recommend.controller;

import com.kgg.kart.common.dto.CommonResponse;
import com.kgg.kart.recommend.dto.RecommendRequest;
import com.kgg.kart.recommend.service.RecommendService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class RecommendController {
    private final RecommendService recommendService;
    @RequestMapping(value="/api/v1/search", method = RequestMethod.POST)
    public ResponseEntity<CommonResponse> kartRecommend(@RequestBody RecommendRequest recommendRequest){

        return ResponseEntity.ok().body(recommendService.findKart(recommendRequest));
    }

}
