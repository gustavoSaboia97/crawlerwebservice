package com.crawlerservice.component;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "globo")
public class GloboComponent {

    @Getter @Setter
    private String endpoint;
}
