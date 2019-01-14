package com.crawlerservice.model;

import com.crawlerservice.model.item.CompleteItem;

import java.util.ArrayList;
import java.util.List;

public class Feed {

    List<CompleteItem> items;

    public Feed(){

        items = new ArrayList<>();
    }

    public void addItem(CompleteItem item){

        items.add(item);
    }
}
