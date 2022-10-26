package com.kgg.kart.search.exception;

import com.kgg.kart.common.dto.CommonResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice("com.kgg.kart.search")
public class SearchExceptionHandler {
    private CommonResponse commonResponse=new CommonResponse();
    @ExceptionHandler(ApiException.class)
    public ResponseEntity<CommonResponse> apiConnectError(Exception e){
        commonResponse.setCode("2000");
        commonResponse.setMessage(e.getMessage());
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(commonResponse);
    }
}
