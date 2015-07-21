package com.pt.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * Spring base web configuration class, injected into the dispatcher servlet context in {@link AppInitializer}.
 * <p/>
 * note - we're excluding @Controllers here - those will be managed by the WebContext - see: {@link com.pt.config.WebRootConfig}
 */
@Configuration
@EnableWebMvc
@ComponentScan(basePackages = {"com.pt"}, useDefaultFilters = false, includeFilters = {@ComponentScan.Filter(type = FilterType.ANNOTATION, value = Controller.class)})
public class WebRootConfig extends WebMvcConfigurerAdapter {
}
