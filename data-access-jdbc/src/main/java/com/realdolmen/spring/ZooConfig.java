package com.realdolmen.spring;

import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

@SpringBootApplication
public class ZooConfig {
    // DONE: add a datasource for the production profile.
    // We will use BasicDataSource from Apache DBCP.
    // Use connection properties for MySQL (url = "jdbc:mysql://localhost:3306/zoo", user = "root", password = "root")

    @Profile ("production")
    @Bean
    public DataSource dataSource() {
        BasicDataSource ds = new BasicDataSource();
        ds.setUrl("jdbc:mysql://localhost:3306/zoo");
        ds.setDriverClassName("com.mysql.jdbc.Driver");
        ds.setUsername("root");
        ds.setPassword("root");
        ds.setMaxActive(50);
        return ds;
    }

    // DONE: add a JDBC template
    @Bean
    public JdbcTemplate jdbcTemplate(DataSource dataSource) {
        return new JdbcTemplate(dataSource);
    }
}
