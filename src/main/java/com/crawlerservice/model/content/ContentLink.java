package com.crawlerservice.model.content;

import lombok.Getter;

import java.util.List;

import static com.crawlerservice.component.JsonConstants.LINKS;

public class ContentLink extends Content {

    @Getter
    List<String> links;

    public ContentLink(List<String> links){

        super(LINKS);

        this.links = links;
    }
}
