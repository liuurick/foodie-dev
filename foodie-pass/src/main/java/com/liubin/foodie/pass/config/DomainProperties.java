package com.liubin.foodie.pass.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * @author liubin
 * @date 2022/3/17
 */
@Data
@Configuration
@ConfigurationProperties(prefix = "passport")
public class DomainProperties {

    private String domain;

    private String timeout;

}
