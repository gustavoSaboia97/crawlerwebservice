package com.crawlerservice.model.content;

import lombok.Getter;

public class ContentItem extends Content {

    @Getter
    private String content;

    public ContentItem(String type, String content){

        super(type);
        this.content = content;
    }
}
