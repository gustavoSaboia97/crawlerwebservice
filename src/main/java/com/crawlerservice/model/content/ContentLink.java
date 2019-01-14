package com.crawlerservice.model.content;

import lombok.Getter;

import java.util.List;

public class ContentLink extends Content {

    private static final String LINKS = "links";

    @Getter
    List<String> links;

    public ContentLink(List<String> links){

        super(LINKS);

        this.links = links;
    }
}
