package com.javarush.jira.testconfigue;

import javax.sql.DataSource;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

@TestConfiguration
public class TestDataSourceConfig {

    @Bean
    @Profile("!application-test-h2") // Профиль для PostgreSQL
    @ConfigurationProperties("spring.datasource")
    public DataSource dataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean
    @Profile("application-test-h2") // Профиль для H2
    @ConfigurationProperties("spring.datasource.test-h2")
    public DataSource h2DataSource() {
        return DataSourceBuilder.create().build();
    }
}
