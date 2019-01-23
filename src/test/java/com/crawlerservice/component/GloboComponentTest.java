package com.crawlerservice.component;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class GloboComponentTest {

    private GloboComponent globoComponent;

    @Test
    public void shouldSetAllGloboComponentData(){

        globoComponent = new GloboComponent();

        String endpoint = "https://revistaautoesporte.globo.com/rss/ultimas/feed.xml";

        globoComponent.setEndpoint(endpoint);

        String endpointResponse = globoComponent.getEndpoint();

        assertThat(endpoint, is(endpointResponse));
    }
}
