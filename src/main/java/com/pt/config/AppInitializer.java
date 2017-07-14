package com.pt.config;

import com.pt.config.web.WebRootConfig;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

/**
 * This will bootstrap the {@link ServletContext} programmatically (in place of a traditional web.xml) part of the javax.servlet-api 3.0+ specification
 *
 * {@see <a href="http://docs.spring.io/autorepo/docs/spring-framework/3.1.x/javadoc-api/org/springframework/web/WebApplicationInitializer.html"}
 */
public class AppInitializer implements WebApplicationInitializer {

    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {

        // the root Spring context - manages all shared beans, services, etc
        AnnotationConfigWebApplicationContext rootContext = new AnnotationConfigWebApplicationContext();
        rootContext.register(SpringRootConfig.class);
        servletContext.addListener(new ContextLoaderListener(rootContext));

        // the web spring context - manages all MVC related beans (controllers, etc)
        AnnotationConfigWebApplicationContext dispatcherContext = new AnnotationConfigWebApplicationContext();
        dispatcherContext.register(WebRootConfig.class);

        // register and map the dispatcher servlet
        ServletRegistration.Dynamic dispatcherServlet = servletContext.addServlet("dispatcher", new DispatcherServlet(dispatcherContext));
        dispatcherServlet.setLoadOnStartup(1);
        dispatcherServlet.addMapping("/");
    }
}
