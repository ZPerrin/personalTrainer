package com.pt.config;

import org.springframework.context.annotation.Bean;
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
@ComponentScan(basePackages = {"com.pt"}, useDefaultFilters = false, excludeFilters = {@ComponentScan.Filter(type = FilterType.ANNOTATION, value = Controller.class)})
public class SpringRootConfig {

    public static class MyClass {

        MyClass(String text) {
            this.text = text;
        }

        String text;
        public String getText() {
            return text;
        }

        public void setText(String text) {
            this.text = text;
        }
    }

    @Bean
    MyClass myclass() {
        return new MyClass("Hello World!!!!");
    }
}
