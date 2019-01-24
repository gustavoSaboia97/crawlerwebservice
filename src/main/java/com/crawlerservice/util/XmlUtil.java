package com.crawlerservice.util;

import com.crawlerservice.model.content.Content;
import com.crawlerservice.model.content.ContentItem;
import com.crawlerservice.model.item.CompleteItem;
import com.crawlerservice.model.item.UncompleteItem;
import lombok.extern.slf4j.Slf4j;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.parser.Parser;
import org.jsoup.select.Elements;

import org.jsoup.Jsoup;

import java.util.ArrayList;
import java.util.List;

import static com.crawlerservice.component.XmlConstants.*;

@Slf4j
public class XmlUtil {

    private ElementUtil elementUtil;

    public XmlUtil(){

        elementUtil = new ElementUtil();
    }

    public List<UncompleteItem> xmlUncompleteItemParser(String xmlResponse){

        log.info("Parsing the XML to an uncompleted item");

        List<UncompleteItem> items = new ArrayList<>();

        Document doc = Jsoup.parse(xmlResponse,"", Parser.xmlParser());

        Elements itemsElements = doc.select(ITEM);

        for (Element itemElement : itemsElements ){

            UncompleteItem item = elementUtil.getUncompleteItem(itemElement);

            items.add(item);
        }

        return items;
    }

    public List<CompleteItem> getCompleteItems(List<UncompleteItem> uncompleteItems) {

        log.info("Parsing the uncomplete Items to an complete items");

        List<CompleteItem> completeItems = new ArrayList<>();

        for (UncompleteItem uncompleteItem : uncompleteItems){

            String title = uncompleteItem.getTitle();
            String link = uncompleteItem.getLink();
            String description = uncompleteItem.getDescription();

            List<Content> contents = getContentFromDescription(description);

            CompleteItem completeItem = new CompleteItem(title, link, contents);

            completeItems.add(completeItem);
        }

        return completeItems;
    }

    public List<Content> getContentFromDescription(String description){

        List<Content> contents = new ArrayList<>();

        Document doc = Jsoup.parse(description,"", Parser.xmlParser());

        elementUtil.getImagesFromDescription(contents, doc);
        elementUtil.getParagraphsFromDescription(contents, doc);
        elementUtil.getLinksFromDescription(contents, doc);

        return contents;
    }
}
