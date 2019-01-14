package com.crawlerservice.model.item;

import com.crawlerservice.model.content.Content;
import lombok.Getter;

import java.util.List;

public class CompleteItem extends Item{

    @Getter
    private List<Content> content;

    public CompleteItem(String title, String link, List<Content> content){

        super(title, link);

        this.content = content;
    }
}
