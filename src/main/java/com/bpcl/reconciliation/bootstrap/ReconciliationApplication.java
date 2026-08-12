package com.bpcl.reconciliation.bootstrap;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

import com.bpcl.reconciliation.config.ApplicationProperties;

@SpringBootApplication(scanBasePackages = "com.bpcl.reconciliation")
@EnableConfigurationProperties(ApplicationProperties.class)
public class ReconciliationApplication {

    public static void main(String[] args) {
        SpringApplication.run(ReconciliationApplication.class, args);
    }
}