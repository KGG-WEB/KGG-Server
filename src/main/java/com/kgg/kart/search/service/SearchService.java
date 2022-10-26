package com.kgg.kart.search.service;

import com.kgg.kart.common.dto.CommonResponse;
import com.kgg.kart.search.domain.Search;
import com.kgg.kart.search.dto.SearchRequest;
import com.kgg.kart.search.repository.SearchRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SearchService {
    private final SearchRepository searchRepository;
    private CommonResponse commonResponse=new CommonResponse();
    public void saveInfo(String nickname, String decode){
        Search search=new Search();
        search.setNickname(nickname);
        search.setDecode(decode);
        searchRepository.save(search);
    }
    public CommonResponse sendNexon(SearchRequest searchRequest){

        return commonResponse;
    }
}
