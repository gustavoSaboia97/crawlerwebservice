package com.crawlerservice.model;

import com.crawlerservice.model.item.CompleteItem;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

public class Feed {

    @Getter @Setter
    List<CompleteItem> items;
}
