package com.crawlerservice.helper;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ServerRequest {

    private RestTemplate restTemplate;

    public ServerRequest(){

        restTemplate = new RestTemplate();
    }

    public String getRequestData(String endpoint){

        String result = restTemplate.getForObject(endpoint, String.class);

        return result;
    }
}
