package com.crawlerservice.controller;

import com.crawlerservice.model.Feed;
import com.crawlerservice.service.MagazineService;

import com.crawlerservice.util.JsonUtil;
import org.junit.Test;
import org.junit.runner.RunWith;

import org.mockito.InjectMocks;
import org.mockito.Mock;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class CrawlerControllerTest {

    @InjectMocks
    private CrawlerController crawlerController;

    @Mock
    private JsonUtil jsonUtil;

    @Mock
    private MagazineService magazineService;

    @Test
    public void shouldReturnJsonObject() throws Exception {

        Feed feed = mock(Feed.class);

        String fakeJson = "{ \'json\' : \'fakeJson\'}";

        when(magazineService.getFeed()).thenReturn(feed);
        when(jsonUtil.getJsonFromItemList(feed)).thenReturn(fakeJson);

        String receivedJson = crawlerController.getMagazineData();

        verify(magazineService).getFeed();
        verify(jsonUtil).getJsonFromItemList(feed);

        assertThat(receivedJson,is(fakeJson));
    }
}
