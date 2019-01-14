package com.crawlerservice.model.item;

import lombok.Getter;

public class UncompleteItem extends Item {

    @Getter
    private String description;

    public UncompleteItem(String title, String link, String description){

        super(title, link);

        this.description = description;
    }
}
