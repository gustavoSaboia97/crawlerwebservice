package com.crawlerservice.model.content;

import lombok.Getter;

public class Content {

    @Getter
    private String type;

    public Content(String type){

        this.type = type;
    }
}
