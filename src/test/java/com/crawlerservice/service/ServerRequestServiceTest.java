package com.crawlerservice.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.web.client.RestTemplate;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class ServerRequestServiceTest {

    @InjectMocks
    private ServerRequestService serverRequestService;

    @Mock
    private RestTemplate restTemplate;

    @Test
    public void shouldReturnRequestData(){

        String endpoint = "https://revistaautoesporte.globo.com/rss/ultimas/feed.xml";

        String xml = "<nome> Gustavo </nome>";

        when(restTemplate.getForObject(endpoint, String.class)).thenReturn(xml);

        String xmlResponse = serverRequestService.getRequestData(endpoint);

        verify(restTemplate).getForObject(endpoint, String.class);

        assertThat(xmlResponse,is(xml));
    }
}
