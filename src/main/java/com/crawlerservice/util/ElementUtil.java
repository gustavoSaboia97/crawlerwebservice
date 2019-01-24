package com.crawlerservice.util;

import com.crawlerservice.model.content.Content;
import com.crawlerservice.model.content.ContentItem;
import com.crawlerservice.model.content.ContentLink;
import com.crawlerservice.model.item.UncompleteItem;
import lombok.extern.slf4j.Slf4j;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.ArrayList;
import java.util.List;

import static com.crawlerservice.component.HtmlConstants.*;
import static com.crawlerservice.component.JsonConstants.*;
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

    public void getImagesFromDescription(List<Content> contents, Document description){

        Elements elements = description.select(HTML_IMAGE);

        for (Element element : elements){

            String img = element.attr(HTML_IMAGE_SOURCE);

            ContentItem contentItem = new ContentItem(IMAGE, img);

            contents.add(contentItem);
        }
    }

    public void getParagraphsFromDescription(List<Content> contents, Document description){

        Elements elements = description.select(HTML_PARAGRAPH);

        for (Element element : elements){

            String paragraph = element.text();

            ContentItem contentItem = new ContentItem(TEXT, paragraph);

            contents.add(contentItem);
        }
    }

    public void getLinksFromDescription(List<Content> contents, Document description){

        Elements elements = description.select(HTML_LIST);

        for (Element element : elements){

            Elements linksElements = element.select(HTML_LINK);

            List<String> links = new ArrayList<>();

            getLinksFromElements(linksElements, links);

            ContentLink contentLink = new ContentLink(links);

            contents.add(contentLink);
        }
    }

    public void getLinksFromElements(Elements linksElements, List<String> links){

        for (Element linkElement : linksElements){

            String link = linkElement.attr(HTML_LINK_HREF);
            links.add(link);
        }
    }
}
