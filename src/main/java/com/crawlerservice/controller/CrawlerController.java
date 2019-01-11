package com.crawlerservice.controller;

import com.crawlerservice.model.Feed;
import com.crawlerservice.service.FeedService;
import com.crawlerservice.util.JsonUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.crawlerservice.component.UrlBuilder.CRAWLER_ENDPOINT;

@Slf4j
@RestController
public class CrawlerController {

    @GetMapping(CRAWLER_ENDPOINT)
    public String getMagazineData(){

        log.info("GET Request at {}", CRAWLER_ENDPOINT);

        FeedService feedService = new FeedService();

        JsonUtil jsonUtil = new JsonUtil();

        Feed feed = feedService.getFeed();

        String json = jsonUtil.getJsonFromItemList(feed);

        return json;
    }
}
