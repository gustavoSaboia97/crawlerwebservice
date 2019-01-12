package com.crawlerservice.service;

import com.crawlerservice.component.GloboComponent;
import com.crawlerservice.model.Feed;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class MagazineService {

    @Autowired
    private GloboComponent globoComponent;

    public Feed getFeed(){

        log.info("Accessing the magazine endpoint: {}", globoComponent.getEndpoint());

        return new Feed();
    }
}
