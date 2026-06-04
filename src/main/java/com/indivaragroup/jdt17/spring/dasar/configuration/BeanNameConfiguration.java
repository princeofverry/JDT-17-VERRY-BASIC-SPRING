package com.indivaragroup.jdt17.spring.dasar.configuration;

import com.indivaragroup.jdt17.spring.dasar.dto.HelloDTO;
import com.indivaragroup.jdt17.spring.dasar.dto.WorldDTO;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanNameConfiguration {

    @Bean(name = "HelloSatuKacang")
    public HelloDTO helloDTO1 () {
        return new HelloDTO();
    }

    @Bean(name = "HelloDuaKacang")
    public WorldDTO helloDTO2() {
        return new WorldDTO();
    }
}
