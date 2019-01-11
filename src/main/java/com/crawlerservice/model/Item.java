package com.crawlerservice.model;


import lombok.Getter;
import lombok.Setter;

public class Item {

    @Getter @Setter
    private String title;
    @Getter @Setter
    private String link;

    private Content dcCreator;
}
