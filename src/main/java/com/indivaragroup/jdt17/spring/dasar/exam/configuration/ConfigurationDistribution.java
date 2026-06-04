package com.indivaragroup.jdt17.spring.dasar.exam.configuration;

import com.indivaragroup.jdt17.spring.dasar.exam.DistributionService;
import com.indivaragroup.jdt17.spring.dasar.exam.model.Factory;
import com.indivaragroup.jdt17.spring.dasar.exam.service.Sales;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConfigurationDistribution {

    // task 7
    // menyambungkan (wiring) semua distribusi antara gudang, sales, dan dan service
    @Bean
    public DistributionService distributionService(
            Factory factory,
            @Qualifier("motor1") Sales motor1,
            @Qualifier("motor2") Sales motor2,
            @Qualifier("motor3") Sales motor3,
            @Qualifier("mobil1") Sales mobil1,
            @Qualifier("mobil2") Sales mobil2
    ) {
        return new DistributionService(
                factory, motor1, motor2, motor3, mobil1, mobil2
        );
    }
}
