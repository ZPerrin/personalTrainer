package com.pt.config.db;

import org.h2.tools.Server;
import org.hibernate.jpa.HibernatePersistenceProvider;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabase;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;

import javax.sql.DataSource;
import java.sql.SQLException;

/**
 * Database configuration(s).
 * <p/>
 * dev: h2 -> localhost:8082 -> jdbc:h2:mem:testdb;MVCC=TRUE
 * // todo: prod setup
 */
@Configuration
public class DataSourceConfig {

    /**
     * H2 in-memory development database.  Plan is to develop against this,
     * and use another platform in production (MySQL?). DDL & DML scripts
     * should be bootstrapped here.
     *
     * @return
     */
    @Profile("dev")
    @Bean
    DataSource dataSource() {
        EmbeddedDatabaseBuilder builder = new EmbeddedDatabaseBuilder();
        EmbeddedDatabase h2db = builder.setType(EmbeddedDatabaseType.H2)
                .addScript("db/scripts/h2/test_DDL.sql")
                .addScript("db/scripts/h2/test_DML.sql")
                .build();
        return h2db;
    }

    @Profile("dev")
    @Bean(initMethod = "start", destroyMethod = "stop")
    public Server startDBManager() throws SQLException {
        return Server.createWebServer();
    }

    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
        LocalContainerEntityManagerFactoryBean entityManagerFactoryBean = new LocalContainerEntityManagerFactoryBean();
        entityManagerFactoryBean.setDataSource(dataSource());
        entityManagerFactoryBean.setPersistenceProviderClass(HibernatePersistenceProvider.class);
        entityManagerFactoryBean.setPackagesToScan("com.pt.persistence");
        return entityManagerFactoryBean;
    }

    @Bean
    public JpaTransactionManager transactionManager() {
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(entityManagerFactory().getObject());
        return transactionManager;
    }
}
