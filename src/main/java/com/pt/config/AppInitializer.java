package com.pt.config;

import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

/**
 * Takes the place of web.xml because fuck xml config - part of the javax.servlet-api 3.0+ specification (requires tomcat >= 7.0.x)
 * <p/>
 * This will bootstrap the {@link ServletContext} programmatically (in place of the traditional web.xml)
 * {@see <a href="http://docs.spring.io/autorepo/docs/spring-framework/3.1.x/javadoc-api/org/springframework/web/WebApplicationInitializer.html"}
 */
public class AppInitializer implements WebApplicationInitializer {

    public void onStartup(ServletContext servletContext) throws ServletException {
        // the root Spring context - manages all shared beans, services, etc
        AnnotationConfigWebApplicationContext rootContext = new AnnotationConfigWebApplicationContext();
        matchProfileToEnv(rootContext);
        rootContext.register(SpringRootConfig.class);

        // manage the lifecycle of the root context
        servletContext.addListener(new ContextLoaderListener(rootContext));

        // the dispatcher servlet Spring context - manages all MVC related beans (controllers)
        AnnotationConfigWebApplicationContext dispatcherContext = new AnnotationConfigWebApplicationContext();
        dispatcherContext.register(WebRootConfig.class);

        // register and map the dispatcher servlet
        ServletRegistration.Dynamic dispatcherServlet = servletContext.addServlet("dispatcher", new DispatcherServlet(dispatcherContext));
        dispatcherServlet.setLoadOnStartup(1);
        dispatcherServlet.addMapping("/*");
    }

    /**
     * I wanted to key off of a single VM argument into tomcat ("app.env") so we're getting a hold of the
     * Environment of our root context here and setting things up based on that.
     *
     * note - if app.env isn't present we default to a development environment
     *
     * @param rootContext - the root Spring ApplicationContext
     */
    private void matchProfileToEnv(AnnotationConfigWebApplicationContext rootContext){
        ConfigurableEnvironment environment = rootContext.getEnvironment();
        environment.setDefaultProfiles("dev");
        String env = (String) environment.getSystemProperties().get("app.env");

        if(env != null) {
            if(env == "dev") {
                environment.setActiveProfiles("dev");
            } else if(env == "prod") {
                environment.setActiveProfiles("prod");
            }
        }
    }
}
