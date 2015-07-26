package com.pt.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.stereotype.Controller;

/**
 * Spring base configuration class, injected into the rootContext in {@link AppInitializer}.
 * <p/>
 * note - we're excluding @Controllers here - those will be managed by the WebContext - see: {@link com.pt.config.WebRootConfig}
 */
@Configuration
@ComponentScan(basePackages = {"com.pt"}, excludeFilters = {@ComponentScan.Filter(type = FilterType.ANNOTATION, value = Controller.class)})
public class SpringRootConfig {
}
