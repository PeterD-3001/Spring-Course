package com.realdolmen.spring;

import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Profile;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

@ComponentScan
@EnableTransactionManagement
public class ZooConfig {
    @Bean
    public PlatformTransactionManager transactionManager(EntityManagerFactory entityManagerFactory) {
        return new JpaTransactionManager(entityManagerFactory);
    }

    // TODO: Configure a DataSource for MySQL in the production profile (BasicDataSource)
    @Bean
    @Profile ("test")
    public DataSource testdataSource() {
         return new EmbeddedDatabaseBuilder()
                .setType(EmbeddedDatabaseType.H2)
                .addScript("classpath:schema.sql")
                .build();
    }

    @Bean
    @Profile ("production")
    public DataSource proddataSource() {
        DriverManagerDataSource ds = new DriverManagerDataSource();
        ds.setDriverClassName("com.mysql.jdbc.Driver");
        ds.setUrl("jdbc:mysql://localhost:3306/zoo");
        ds.setUsername("root");
        ds.setPassword("root");
        return ds;
    }


    // TODO: configure an embedded DataSource for H2 in the test profile
    @Bean
    public JpaVendorAdapter jpaVendorAdapter(Database db) {
        HibernateJpaVendorAdapter jva = new HibernateJpaVendorAdapter();
        jva.setDatabase(db);
        // jva.setGenerateDdl(false);
        // jva.setShowSql(true);
        return jva;
    }

    // TODO: Configure an EntityManagerFactory bean for use with Hibernate
    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactoryBean(DataSource myDataSource, JpaVendorAdapter jva) {
        LocalContainerEntityManagerFactoryBean emfb = new LocalContainerEntityManagerFactoryBean();
        emfb.setDataSource(myDataSource);
        emfb.setJpaVendorAdapter(jva);
        emfb.setPackagesToScan("com.realdolmen.spring");
        return emfb;
    }

    // TODO: Make sure your EntityManagerFactoryBean is set up for using dialect H2
    // in test and dialect MySQL in production
    @Profile("test")
    @Bean
    public Database testDb()
    {
     return Database.H2;

    }

    @Profile("production")
    @Bean
    public Database prodDb()
    {
        return Database.H2;
    }
}
