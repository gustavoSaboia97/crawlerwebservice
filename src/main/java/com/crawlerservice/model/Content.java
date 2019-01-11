package com.crawlerservice.model;

import lombok.Getter;

public class Content {

    @Getter
    private String type;

    public Content(String type){

        this.type = type;
    }
}
