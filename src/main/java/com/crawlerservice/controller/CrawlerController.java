package com.crawlerservice.controller;

import com.crawlerservice.model.Feed;
import com.crawlerservice.service.MagazineService;
import com.crawlerservice.util.JsonUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.crawlerservice.component.UrlBuilder.CRAWLER_ENDPOINT;

@Slf4j
@RestController
public class CrawlerController {

    @Autowired
    private MagazineService magazineService;

    @Autowired
    private JsonUtil jsonUtil;

    @GetMapping(CRAWLER_ENDPOINT)
    public String getMagazineData(){

        log.info("GET Request at {}", CRAWLER_ENDPOINT);

        var feed = magazineService.getFeed();

        var json = jsonUtil.getJsonFromItemList(feed);

        return json;
    }
}
