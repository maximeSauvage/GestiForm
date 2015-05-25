package be.atc.gestiform;

import javax.faces.webapp.FacesServlet;
import javax.servlet.ServletContext;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.web.DispatcherServletAutoConfiguration;
import org.springframework.boot.autoconfigure.web.WebMvcAutoConfiguration;
import org.springframework.boot.context.embedded.ServletListenerRegistrationBean;
import org.springframework.boot.context.embedded.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.ServletContextAware;

import com.sun.faces.config.ConfigureListener;

@Configuration
@EnableAutoConfiguration(exclude={WebMvcAutoConfiguration.class,DispatcherServletAutoConfiguration.class})
@ComponentScan
public class GestiformApplication implements ServletContextAware {

	public static void main(String[] args) {
		SpringApplication.run(GestiformApplication.class, args);
	}

	/*
	 * Below sets up the Faces Servlet for Spring Boot
	 */

    @Bean
    public ServletRegistrationBean facesServletRegistration() {
        ServletRegistrationBean registration = new ServletRegistrationBean(
            new FacesServlet(), "*.xhtml");
        registration.setLoadOnStartup(1);
        return registration;
    }

    @Bean
    public ServletListenerRegistrationBean<ConfigureListener> jsfConfigureListener() {
        return new ServletListenerRegistrationBean<ConfigureListener>(
            new ConfigureListener());
    }

	// To get JSF working on Spring Boot without a web.xml or faces-config.xml
	// you need to force it to load its configuration files via an init
	// parameter on the ServletContext.
	// An easy way to do that is to implement ServletContextAware
	// @see
	// http://stackoverflow.com/questions/25479986/spring-boot-with-jsf-could-not-find-backup-for-factory-javax-faces-context-face
    @Override
    public void setServletContext(ServletContext servletContext) {
        servletContext.setInitParameter("com.sun.faces.forceLoadConfiguration", Boolean.TRUE.toString());       
    }
}
