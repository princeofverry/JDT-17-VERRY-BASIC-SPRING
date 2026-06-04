package com.indivaragroup.jdt17.spring.dasar.exam.configuration;

import com.indivaragroup.jdt17.spring.dasar.exam.model.Warehouse;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConfigurationWarehouse {

    // task 4 membuat configuration factory singleton
    // dengan bean berisi Main Factory dengan stockCount 1000
    @Bean
    public Warehouse warehouse() {
        return new Warehouse("Main Warehouse", 1000);
    }
}
