package com.kgg.kart.search.controller;

import com.kgg.kart.common.dto.CommonResponse;
import com.kgg.kart.search.dto.SearchRequest;
import com.kgg.kart.search.service.SearchService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class SearchController {
    private final SearchService searchService;
    @RequestMapping(value="/api/v1/search", method = RequestMethod.GET)
    public ResponseEntity<CommonResponse> scrapSave(@RequestParam SearchRequest searchRequest){

        return ResponseEntity.ok().body(searchService.sendNexon(searchRequest));
    }

}
