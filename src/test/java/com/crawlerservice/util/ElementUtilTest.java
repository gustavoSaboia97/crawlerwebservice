package com.crawlerservice.util;

import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.junit.Before;
import org.junit.Test;

import static com.crawlerservice.component.XmlConstants.*;
import static org.mockito.Mockito.*;

public class ElementUtilTest {

    private ElementUtil elementUtil;

    private String content = "CONTENT";

    @Before
    public void setup(){

        elementUtil = new ElementUtil();
    }

    @Test
    public void shouldCreateAnUncompletedItem(){

        Elements xmlElements = mock(Elements.class);
        Element element = mock(Element.class);

        when(element.select(TITLE)).thenReturn(xmlElements);
        when(element.select(LINK)).thenReturn(xmlElements);
        when(element.select(DESCRIPTION)).thenReturn(xmlElements);
        when(xmlElements.text()).thenReturn(content);

        elementUtil.getUncompleteItem(element);

        verify(element).select(TITLE);
        verify(element).select(LINK);
        verify(element).select(DESCRIPTION);
        verify(xmlElements, times(3)).text();
    }
}
