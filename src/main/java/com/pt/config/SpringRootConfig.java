package com.pt.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * Spring base configuration class, injected into the rootContext in {@link AppInitializer}.
 * <p/>
 * note - we're excluding @Controllers here - those will be managed by the WebContext - see: {@link com.pt.config.WebRootConfig}
 */
@Configuration
@EnableTransactionManagement
@ComponentScan(basePackages = {"com.pt"})
@EnableJpaRepositories("com.pt.persistence.repository")
public class SpringRootConfig {


}
