package com.indivaragroup.jdt17.spring.dasar.configuration;

import com.indivaragroup.jdt17.spring.dasar.dto.WorldDTO;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class PrimaryBeanConfiguration {
    @Primary
    @Bean
    public WorldDTO dunia1() {
        return new WorldDTO();
    }

    @Bean
    public WorldDTO dunia2() {
        return new WorldDTO();
    }

}
