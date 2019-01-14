package com.crawlerservice.util;

import com.crawlerservice.model.item.UncompleteItem;
import lombok.extern.slf4j.Slf4j;
import org.jsoup.nodes.Element;

import static com.crawlerservice.component.XmlConstants.*;

@Slf4j
public class ElementUtil {

    public UncompleteItem getUncompleteItem(Element itemElement){

        String title = itemElement.select(TITLE).text();

        String link = itemElement.select(LINK).text();

        String description = itemElement.select(DESCRIPTION).text();

        log.info("Reading Items, Title: {}, Link: {}", title, link);

        return new UncompleteItem(title, link, description);
    }
}
