package com.crawlerservice.model;

import com.crawlerservice.model.item.CompleteItem;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.mockito.Mockito.mock;

public class FeedTest {

    private Feed feed;

    @Test
    public void shouldSetCompleteItemsList(){

        feed = new Feed();

        List<CompleteItem> items = mock(ArrayList.class);

        feed.setItems(items);

        List<CompleteItem> itemsResponse = feed.getItems();

        assertThat(itemsResponse, is(items));
    }
}
