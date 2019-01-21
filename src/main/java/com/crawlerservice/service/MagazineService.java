package com.crawlerservice.service;

import com.crawlerservice.component.GloboComponent;
import com.crawlerservice.model.Feed;
import com.crawlerservice.model.item.CompleteItem;
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

    private Feed feed;

    public MagazineService(){

        xmlUtil = new XmlUtil();
        feed = new Feed();
    }

    public Feed getFeed(){

        String xmlResponse = getRequestResponse();

        List<UncompleteItem> uncompleteItems = xmlUtil.xmlUncompleteItemParser(xmlResponse);

        List<CompleteItem> completeItems = xmlUtil.getCompleteItems(uncompleteItems);

        feed.setItems(completeItems);

        return feed;
    }

    public String getRequestResponse(){

        return serverRequestService.getRequestData(globoComponent.getEndpoint());
    }
}
