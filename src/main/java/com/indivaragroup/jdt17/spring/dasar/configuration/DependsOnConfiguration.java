package com.indivaragroup.jdt17.spring.dasar.configuration;

import com.indivaragroup.jdt17.spring.dasar.dto.HelloDTO;
import com.indivaragroup.jdt17.spring.dasar.dto.WorldDTO;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;
import org.springframework.context.annotation.Primary;

@Configuration
public class DependsOnConfiguration {
    @Bean
    @DependsOn(value = {"bar"})
    public HelloDTO foo() {
        System.out.println("CREATE FOO");
        return new HelloDTO();
    }

    @Bean
    public WorldDTO bar() {
        System.out.println("CREATE BAR");
        return new WorldDTO();
    }
}
