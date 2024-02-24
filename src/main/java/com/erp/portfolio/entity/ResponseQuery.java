package com.erp.portfolio.entity;

import lombok.Builder;

@Builder
public class ResponseQuery {
    private Integer status;
    private Integer rowsAffected;
    private String message;
}
