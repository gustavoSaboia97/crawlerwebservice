package com.crawlerservice.service;


import com.crawlerservice.component.GloboComponent;
import com.crawlerservice.model.Feed;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.Mockito.mock;

@RunWith(MockitoJUnitRunner.class)
public class MagazineServiceTest {

    @InjectMocks
    private MagazineService magazineService;

    @Mock
    private GloboComponent globoComponent;

    @Test
    public void shoudReturnFeed(){

        Feed feed = mock(Feed.class);

    }

}
