package com.indivaragroup.jdt17.spring.dasar.configuration;


import com.indivaragroup.jdt17.spring.dasar.dto.HelloDTO;
import com.indivaragroup.jdt17.spring.dasar.dto.WorldDTO;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfiguration {

    @Bean
    public HelloDTO hello() {
        return new HelloDTO();
    }

    @Bean
    public WorldDTO world() {
        return new WorldDTO();
    }
}
