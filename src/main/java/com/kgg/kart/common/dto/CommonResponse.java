package com.kgg.kart.common.dto;

import lombok.Data;

@Data
public class CommonResponse {
    private String code="0000";
    private String message;
    private Object result=null;
}
