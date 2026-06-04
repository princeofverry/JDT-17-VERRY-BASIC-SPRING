package com.indivaragroup.jdt17.spring.dasar.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JDTConfiguration {
    @Bean
    public String getInitialConfiguration() {
        return "JDT-17 = CONFIGURATION";
    }
}
