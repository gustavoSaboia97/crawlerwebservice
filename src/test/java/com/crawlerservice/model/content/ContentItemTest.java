package com.crawlerservice.model.content;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class ContentItemTest {

    private ContentItem contentItem;

    @Test
    public void shouldSetAllContentItemData(){

        String type = "type";
        String content = "content";

        contentItem = new ContentItem(type, content);

        String typeResponse = contentItem.getType();
        String contentResponse = contentItem.getContent();

        assertThat(typeResponse, is(type));
        assertThat(contentResponse, is(content));
    }
}
