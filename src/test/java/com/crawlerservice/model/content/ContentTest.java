package com.crawlerservice.model.content;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class ContentTest {

    private Content content;

    @Test
    public void shouldSetType(){

        String type = "type";

        content = new Content(type);

        String typeResponse = content.getType();

        assertThat(typeResponse, is(type));
    }
}
