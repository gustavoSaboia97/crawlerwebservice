package com.crawlerservice.model;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

public class Feed {

    List<Item> items;

    public Feed(){

        items = new ArrayList<>();
    }

    public void addItem(Item item){

        items.add(item);
    }
}
