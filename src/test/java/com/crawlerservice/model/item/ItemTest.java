package com.crawlerservice.model.item;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class ItemTest {

    private Item item;

    @Test
    public void shouldSetItemData(){

        String title = "title";
        String link = "link";

        item = new Item(title, link);

        String titleResponse = item.getTitle();
        String linkResponse = item.getLink();

        assertThat(titleResponse, is(title));
        assertThat(linkResponse, is(link));
    }
}
