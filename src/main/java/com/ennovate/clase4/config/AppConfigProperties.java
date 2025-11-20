package com.ennovate.clase4.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "config.app")
@Data
public class AppConfigProperties {
    private String country;
    private String clientId;
}
