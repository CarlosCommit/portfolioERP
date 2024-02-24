package com.erp.portfolio.entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Project {

    private Integer id;
    private String title;
    private String description;
    private String urlRepo;
}
