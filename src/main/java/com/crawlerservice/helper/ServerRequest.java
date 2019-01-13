package com.crawlerservice.helper;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Slf4j
@Service
public class ServerRequest {

    private RestTemplate restTemplate;

    public ServerRequest(){

        restTemplate = new RestTemplate();
    }

    public String getRequestData(String endpoint){

        log.info("Accessing the magazine endpoint: {}", endpoint);

        String result = restTemplate.getForObject(endpoint, String.class);

        return result;
    }
}
