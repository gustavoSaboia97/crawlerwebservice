package com.crawlerservice.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Slf4j
@Service
public class ServerRequestService {

    private RestTemplate restTemplate;

    public ServerRequestService(){

        restTemplate = new RestTemplate();
    }

    public String getRequestData(String endpoint){

        log.info("Accessing the magazine endpoint: {}", endpoint);

        return restTemplate.getForObject(endpoint, String.class);
    }
}
