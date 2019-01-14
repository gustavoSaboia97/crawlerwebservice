package com.crawlerservice.service;

import com.crawlerservice.component.GloboComponent;
import com.crawlerservice.model.Feed;
import com.crawlerservice.model.item.Item;
import com.crawlerservice.model.item.UncompleteItem;
import com.crawlerservice.util.XmlUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class MagazineService {

    @Autowired
    private GloboComponent globoComponent;
    @Autowired
    private ServerRequestService serverRequestService;

    private XmlUtil xmlUtil;

    public MagazineService(){

        xmlUtil = new XmlUtil();
    }

    public Feed getFeed(){

        Feed feed = new Feed();

        var xmlResponse = getRequestResponse();

        List<UncompleteItem> uncompleteItems = xmlUtil.xmlUncompleteItemParser(xmlResponse);

        return feed;
    }

    public String getRequestResponse(){

        return serverRequestService.getRequestData(globoComponent.getEndpoint());
    }
}
