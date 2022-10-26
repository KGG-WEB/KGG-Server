package com.kgg.kart.search.controller;

import com.kgg.kart.common.dto.CommonResponse;
import com.kgg.kart.search.dto.SearchRequest;
import com.kgg.kart.search.service.SearchService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class SearchController {
    private final SearchService searchService;
    @RequestMapping(value="/api/v1/search", method = RequestMethod.POST) //DB에 저장해서 post
    public ResponseEntity<CommonResponse> userSearch(@RequestBody SearchRequest searchRequest){

        return ResponseEntity.ok().body(searchService.sendNexon(searchRequest));
    }

}
