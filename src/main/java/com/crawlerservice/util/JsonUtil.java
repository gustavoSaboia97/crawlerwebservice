package com.crawlerservice.util;

import com.crawlerservice.model.Feed;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class JsonUtil {

    public String getJsonFromItemList(Feed feed){

        ObjectMapper mapper = new ObjectMapper();

        String json = new String();

        try{

            json = mapper.writeValueAsString(feed);
        }
        catch(JsonProcessingException e){

            log.error("Error converting feed to json");
        }

        return json;
    }
}
