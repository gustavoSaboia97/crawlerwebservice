package com.crawlerservice.model.item;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class UncompleteItemTest {

    private UncompleteItem item;

    @Test
    public void shouldSetAllUncompleteItemData(){

        String title = "title";
        String link = "link";
        String description = "description";

        item = new UncompleteItem(title, link, description);

        String titleResponse = item.getTitle();
        String linkResponse = item.getLink();
        String descriptionResponse = item.getDescription();

        assertThat(titleResponse, is(title));
        assertThat(linkResponse, is(link));
        assertThat(descriptionResponse, is(description));
    }
}
