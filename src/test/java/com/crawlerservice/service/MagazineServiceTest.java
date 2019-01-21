package com.crawlerservice.service;


import com.crawlerservice.component.GloboComponent;
import com.crawlerservice.model.Feed;
import com.crawlerservice.model.item.CompleteItem;
import com.crawlerservice.model.item.UncompleteItem;
import com.crawlerservice.util.XmlUtil;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

@RunWith(MockitoJUnitRunner.class)
public class MagazineServiceTest {

    @Spy
    @InjectMocks
    private MagazineService magazineService;

    @Mock
    private GloboComponent globoComponent;
    @Mock
    private ServerRequestService serverRequestService;
    @Mock
    private XmlUtil xmlUtil;
    @Mock
    private Feed feed;

    private String xml;

    @Before
    public void setup(){

        xml = "<nome> Gustavo </nome>";
    }

    @Test
    public void shoudReturnFeed(){

        List<UncompleteItem> uncompleteItems = mock(ArrayList.class);
        List<CompleteItem> completeItems = mock(ArrayList.class);

        doReturn(xml).when(magazineService).getRequestResponse();
        when(xmlUtil.xmlUncompleteItemParser(xml)).thenReturn(uncompleteItems);
        when(xmlUtil.getCompleteItems(uncompleteItems)).thenReturn(completeItems);

        magazineService.getFeed();

        verify(magazineService).getRequestResponse();
        verify(xmlUtil).xmlUncompleteItemParser(xml);
        verify(xmlUtil).getCompleteItems(uncompleteItems);
    }

    @Test
    public void shoudReturnCompleteXml(){

        String endpoint = "https://revistaautoesporte.globo.com/rss/ultimas/feed.xml";

        when(globoComponent.getEndpoint()).thenReturn(endpoint);
        when(serverRequestService.getRequestData(endpoint)).thenReturn(xml);

        String xmlResponse = magazineService.getRequestResponse();

        verify(serverRequestService).getRequestData(endpoint);

        assertThat(xmlResponse,is(xml));
    }
}
