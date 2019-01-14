package com.crawlerservice.helper;

import com.crawlerservice.service.ServerRequestService;
import org.junit.Test;
import org.junit.runner.RunWith;

import org.mockito.InjectMocks;
import org.mockito.Mock;

import org.mockito.junit.MockitoJUnitRunner;

import org.springframework.web.client.RestTemplate;

import static org.mockito.Mockito.*;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

@RunWith(MockitoJUnitRunner.class)
public class ServerRequestServiceTest {

    @InjectMocks
    private ServerRequestService serverRequestService;

    @Mock
    private RestTemplate restTemplate;

    private String endpoint = "";

    @Test
    public void shoudRequestMagazineData() throws Exception{

        String result = "result";

        when(restTemplate.getForObject(endpoint, String.class)).thenReturn(result);

        String finalResult = serverRequestService.getRequestData(endpoint);

        verify(restTemplate).getForObject(endpoint, String.class);

        assertThat(finalResult, is(result));
    }
}
