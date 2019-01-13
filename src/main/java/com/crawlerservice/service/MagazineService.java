package com.crawlerservice.service;

import com.crawlerservice.component.GloboComponent;
import com.crawlerservice.helper.ServerRequest;
import com.crawlerservice.model.Feed;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class MagazineService {

    @Autowired
    private GloboComponent globoComponent;
    @Autowired
    private ServerRequest serverRequest;

    public Feed getFeed(){

        System.out.println(getRequestResponse());

        return new Feed();
    }

    public String getRequestResponse(){

        return serverRequest.getRequestData(globoComponent.getEndpoint());
    }
}
