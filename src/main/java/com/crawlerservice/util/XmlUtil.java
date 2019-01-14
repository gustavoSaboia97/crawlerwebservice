package com.crawlerservice.util;

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

        List<UncompleteItem> items = new ArrayList<UncompleteItem>();

        Document doc = Jsoup.parse(xmlResponse,"", Parser.xmlParser());

        Elements itemsElements = doc.select(ITEM);

        for (Element itemElement : itemsElements ){

            UncompleteItem item = elementUtil.getUncompleteItem(itemElement);

            items.add(item);
        }

        return items;
    }
}
