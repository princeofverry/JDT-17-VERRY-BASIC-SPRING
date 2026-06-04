package com.indivaragroup.jdt17.spring.dasar.exam.configuration;

import com.indivaragroup.jdt17.spring.dasar.exam.model.Factory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConfigurationFactory {

    // singleton
    @Bean
    public Factory factory() {
        return new Factory("Main Factory", 1000);
    }
}
