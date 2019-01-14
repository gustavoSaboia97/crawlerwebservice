package com.crawlerservice.model.item;

import lombok.Getter;

public class Item {

    @Getter
    private String title;
    @Getter
    private String link;

    public Item(String title, String link){

    }
}
