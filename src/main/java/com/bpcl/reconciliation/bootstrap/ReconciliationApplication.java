package com.bpcl.reconciliation.bootstrap;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.persistence.autoconfigure.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.bpcl.reconciliation.config.ApplicationProperties;

@SpringBootApplication(scanBasePackages = "com.bpcl.reconciliation")
@EntityScan(basePackages = "com.bpcl.reconciliation.domain")
@EnableJpaRepositories(basePackages = "com.bpcl.reconciliation.domain")
@EnableConfigurationProperties(ApplicationProperties.class)
public class ReconciliationApplication {

	public static void main(String[] args) {
		SpringApplication.run(ReconciliationApplication.class, args);
	}
}