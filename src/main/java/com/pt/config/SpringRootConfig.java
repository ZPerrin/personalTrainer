package com.pt.config;

import com.pt.config.web.WebRootConfig;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * Spring base configuration class, injected into the rootContext in {@link AppInitializer}.
 * <p/>
 * note - we're excluding @Controllers here - those will be managed by the WebContext - see: {@link WebRootConfig}
 */
@Configuration
@EnableTransactionManagement
@ComponentScan(basePackages = {"com.pt.config"})
@EnableJpaRepositories("com.pt.persistence.repository")
public class SpringRootConfig {


}
