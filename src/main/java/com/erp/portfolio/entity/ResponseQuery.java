package com.erp.portfolio.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class ResponseQuery {
    private Integer status;
    private Integer rowsAffected;
    private String message;
}
