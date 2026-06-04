package com.indivaragroup.jdt17.spring.dasar.exam.configuration;

import com.indivaragroup.jdt17.spring.dasar.exam.model.Factory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConfigurationFactory {

    // task 4 membuat configuration factory singleton
    // dengan bean berisi Main Factory dengan stockCount 1000
    @Bean
    public Factory factory() {
        return new Factory("Main Factory", 1000);
    }
}
