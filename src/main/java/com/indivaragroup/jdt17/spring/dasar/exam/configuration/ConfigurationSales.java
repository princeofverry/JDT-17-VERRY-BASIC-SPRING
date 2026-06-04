package com.indivaragroup.jdt17.spring.dasar.exam.configuration;

import com.indivaragroup.jdt17.spring.dasar.exam.service.Sales;
import com.indivaragroup.jdt17.spring.dasar.exam.service.carSales;
import com.indivaragroup.jdt17.spring.dasar.exam.service.motorCycleSales;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConfigurationSales {

//
//| Bean | Qualifier | Class | Nama | Wilayah |
//            |------|-----------|-------|------|---------|
//            | 1 | `"motor1"` | SalesMotor | Andi | Zona A |
//            | 2 | `"motor2"` | SalesMotor | Budi | Zona B |
//            | 3 | `"motor3"` | SalesMotor | Cici | Zona C |
//            | 4 | `"mobil1"` | SalesMobil | Dedi | Zona D |
//            | 5 | `"mobil2"` | SalesMobil | Eka  | Zona E |
//
    @Bean
    public Sales motor1(){
        return new motorCycleSales("Andi", "Zona A");
    }

    @Bean
    public Sales motor2() {
        return new motorCycleSales("Budi", "Zona B");
    }

    @Bean
    public Sales motor3() {
        return new motorCycleSales("Cici", "Zona C");
    }

    @Bean
    public Sales mobil1() {
        return new carSales("Dedi", "Zona D");
    }

    @Bean
    public Sales mobil2() {
        return new carSales("Eka", "Zona E");
    }
}
