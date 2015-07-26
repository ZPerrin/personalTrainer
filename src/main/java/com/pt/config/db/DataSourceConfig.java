package com.pt.config.db;

import org.h2.tools.Server;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabase;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

import javax.sql.DataSource;
import java.sql.SQLException;

/**
 *  Database configuration(s).
 *
 *  dev: h2 -> localhost:8082 -> jdbc:h2:mem:testdb;MVCC=TRUE
 *  // todo: prod setup
 */
@Configuration
public class DataSourceConfig {

    /**
     * H2 in-memory development database.  Plan is to develop against this,
     * and use another platform in production (MySQL?). DDL & DML scripts
     * should be bootstrapped here
     * @return
     */
    @Profile("dev")
    @Bean
    DataSource dataSource() {
        EmbeddedDatabaseBuilder builder = new EmbeddedDatabaseBuilder();
        EmbeddedDatabase h2db = builder.setType(EmbeddedDatabaseType.H2)
                .addScript("db/scripts/h2/create_user.sql")
                .addScript("db/scripts/h2/user_DML.sql")
                .build();
        return h2db;
    }

    /**
     * Starts the h2 web-backed server which can be found
     * at localhost:8082.
     *
     * The jdbc connection url is currently using the default:
     *
     * @return
     * @throws SQLException
     */
    @Profile("dev")
    @Bean(initMethod = "start", destroyMethod = "stop")
    public Server startDBManager() throws SQLException {
        return Server.createWebServer();
    }
}
