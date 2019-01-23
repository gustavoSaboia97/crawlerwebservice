package com.crawlerservice.model.content;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.mockito.Mockito.mock;

public class ContentLinkTest {

    private ContentLink contentLink;

    @Test
    public void shouldSetAllContentLinkData(){

        List<String> links = mock(ArrayList.class);

        contentLink = new ContentLink(links);

        String type = contentLink.getType();
        List<String> linksResponse = contentLink.getLinks();

        assertThat(type, is("links"));
        assertThat(linksResponse, is(links));
    }
}
