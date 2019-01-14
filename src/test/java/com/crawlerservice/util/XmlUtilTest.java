package com.crawlerservice.util;

import com.crawlerservice.model.item.UncompleteItem;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.parser.Parser;
import org.jsoup.select.Elements;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import java.util.ArrayList;
import java.util.Iterator;

import static com.crawlerservice.component.XmlConstants.*;
import static org.mockito.Mockito.*;
import static org.mockito.MockitoAnnotations.initMocks;

@RunWith(PowerMockRunner.class)
@PrepareForTest({Jsoup.class, Parser.class})
public class XmlUtilTest {

    @InjectMocks
    private XmlUtil xmlUtil;

    @Mock
    private ArrayList<UncompleteItem> items;
    @Mock
    private Parser parser;
    @Mock
    private Document doc;
    @Mock
    private Elements itemsElements;
    @Mock
    private ElementUtil elementUtil;

    private String xmlResponse;

    @Before
    public void setup(){

        initMocks(this);

        xmlResponse = "<item>CompleteItem</item>";
    }

    @Test
    public void shoudReadXmlData() throws Exception{

        Iterator<Element> elementIterator = mock(Iterator.class);
        Element element = mock(Element.class);

        UncompleteItem uncompleteItem = mock(UncompleteItem.class);

        PowerMockito.mockStatic(Jsoup.class);
        PowerMockito.mockStatic(Parser.class);

        PowerMockito.whenNew(ArrayList.class).withNoArguments().thenReturn(items);

        PowerMockito.when(Parser.xmlParser()).thenReturn(parser);
        PowerMockito.when(Jsoup.parse(xmlResponse, "", Parser.xmlParser())).thenReturn(doc);

        when(doc.select(ITEM)).thenReturn(itemsElements);

        when(itemsElements.iterator()).thenReturn(elementIterator);
        when(elementIterator.hasNext()).thenReturn(true).thenReturn(false);
        when(elementIterator.next()).thenReturn(element);

        when(elementUtil.getUncompleteItem(element)).thenReturn(uncompleteItem);

        xmlUtil.xmlUncompleteItemParser(xmlResponse);

        PowerMockito.verifyStatic(Jsoup.class);
            Jsoup.parse(xmlResponse, "", Parser.xmlParser());

        verify(doc).select(ITEM);
        verify(elementUtil).getUncompleteItem(element);
    }
}
