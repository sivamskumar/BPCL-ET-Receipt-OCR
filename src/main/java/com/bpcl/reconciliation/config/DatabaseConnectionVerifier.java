package com.bpcl.reconciliation.config;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile("local")
public class DatabaseConnectionVerifier implements ApplicationRunner {

    private static final Logger LOGGER =
            LoggerFactory.getLogger(DatabaseConnectionVerifier.class);

    private final DataSource dataSource;

    public DatabaseConnectionVerifier(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public void run(ApplicationArguments args) throws SQLException {

        try (Connection connection = dataSource.getConnection()) {

            DatabaseMetaData metadata = connection.getMetaData();

            LOGGER.info(
                    "Database connection verified: product={}, version={}, url={}, user={}",
                    metadata.getDatabaseProductName(),
                    metadata.getDatabaseProductVersion(),
                    metadata.getURL(),
                    metadata.getUserName());
        }
    }
}