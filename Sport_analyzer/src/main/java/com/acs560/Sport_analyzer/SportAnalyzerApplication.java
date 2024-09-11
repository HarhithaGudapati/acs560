package com.acs560.Sport_analyzer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.acs560.Sport_analyzer.repositories","com.acs560.Sport_analyzer.controllers",
"com.acs560.Sport_analyzer.services" })
public class SportAnalyzerApplication {

    public static void main(String[] args) {
        SpringApplication.run(SportAnalyzerApplication.class, args);
    }
}
