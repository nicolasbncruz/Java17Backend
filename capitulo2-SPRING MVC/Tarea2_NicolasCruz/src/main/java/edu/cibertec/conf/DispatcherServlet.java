package edu.cibertec.conf;

import javax.servlet.ServletContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.thymeleaf.spring5.SpringTemplateEngine;
import org.thymeleaf.spring5.view.ThymeleafViewResolver;
import org.thymeleaf.templateresolver.ServletContextTemplateResolver;

/**
 *
 * @author jpere
 */
@Configuration
@EnableWebMvc
@ComponentScan(basePackages = {"edu.cibertec"}) //[Component/Repository / Service /Controller]
public class DispatcherServlet { //AppConfig

    @Bean
    public ServletContextTemplateResolver templateResolver(ServletContext servletContext) {
        ServletContextTemplateResolver resolver = new ServletContextTemplateResolver(servletContext);
        resolver.setPrefix("/WEB-INF/templates/");
        resolver.setSuffix(".html");
        resolver.setTemplateMode("HTML");
        return resolver;
    }

    @Bean
    public SpringTemplateEngine templateEngine(ServletContext servletContext) {
        SpringTemplateEngine resolver = new SpringTemplateEngine();
        resolver.setTemplateResolver(templateResolver(servletContext));
        return resolver;
    }

    @Bean
    public ThymeleafViewResolver getThymeleafViewResolver(ServletContext servletContext) {
        ThymeleafViewResolver resolver = new ThymeleafViewResolver();
        resolver.setTemplateEngine(templateEngine(servletContext));
        return resolver;
    }

    @Bean
    public CommonsMultipartResolver multipartResolver() {
        CommonsMultipartResolver resolver = new CommonsMultipartResolver();
        return resolver;
    }
}
