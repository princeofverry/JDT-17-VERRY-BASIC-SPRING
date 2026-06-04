package com.indivaragroup.jdt17.spring.dasar.dependency.injection;

import com.indivaragroup.jdt17.spring.dasar.dependency.injection.dto.HelloInjection;
import com.indivaragroup.jdt17.spring.dasar.dependency.injection.dto.WorldInjection;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class HelloWorldWithInjection {
    @Bean
    public HelloInjection foo() {
        return new HelloInjection();
    }

    @Bean
    public WorldInjection bar() {
        return new WorldInjection();
    }

    @Bean
    public HelloWorldInjection helloWorldInjection(
            HelloInjection helloInjection,
            WorldInjection worldInjection
    ) {
        return new HelloWorldInjection(helloInjection, worldInjection);
    }
}
