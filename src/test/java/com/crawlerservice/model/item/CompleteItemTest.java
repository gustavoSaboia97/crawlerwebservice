package com.crawlerservice.model.item;

import com.crawlerservice.model.content.Content;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.mockito.Mockito.mock;

public class CompleteItemTest {

    private CompleteItem item;

    @Test
    public void shouldSetAllCompleteItemData(){

        String title = "title";
        String link = "link";

        List<Content> items = mock(ArrayList.class);

        item = new CompleteItem(title,link,items);

        String titleResponse = item.getTitle();
        String linkResponse = item.getLink();

        List<Content> itemsResponse = item.getContent();

        assertThat(titleResponse, is(title));
        assertThat(linkResponse, is(link));
        assertThat(itemsResponse, is(items));
    }
}
