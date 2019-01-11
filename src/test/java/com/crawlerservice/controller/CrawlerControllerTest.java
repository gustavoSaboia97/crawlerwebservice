package com.crawlerservice.controller;

import com.crawlerservice.model.Feed;
import com.crawlerservice.service.FeedService;
import com.crawlerservice.util.JsonUtil;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import org.mockito.Mock;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.MockitoAnnotations.initMocks;

import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import org.powermock.api.mockito.PowerMockito;

@RunWith(PowerMockRunner.class)
@PrepareForTest(CrawlerController.class)
public class CrawlerControllerTest {

    private CrawlerController crawlerController;

    @Mock
    private FeedService feedService;
    @Mock
    private JsonUtil jsonUtil;

    @Before
    public void setup(){

        initMocks(this);

        this.crawlerController = new CrawlerController();
    }

    @Test
    public void shouldReturnJsonObject() throws Exception {

        Feed feed = mock(Feed.class);

        String fakeJson = "{ \'json\' : \'fakeJson\'}";

        PowerMockito.whenNew(FeedService.class).withNoArguments().thenReturn(feedService);
        PowerMockito.whenNew(JsonUtil.class).withNoArguments().thenReturn(jsonUtil);

        when(feedService.getFeed()).thenReturn(feed);
        when(jsonUtil.getJsonFromItemList(feed)).thenReturn(fakeJson);

        String receivedJson = crawlerController.getMagazineData();

        verify(feedService).getFeed();
        verify(jsonUtil).getJsonFromItemList(feed);

        assertThat(receivedJson,is(fakeJson));
    }
}
