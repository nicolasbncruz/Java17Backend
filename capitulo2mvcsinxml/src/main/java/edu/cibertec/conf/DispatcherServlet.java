
package edu.cibertec.conf;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

/**
 *
 * @author jpere
 */
@Configuration 
@ComponentScan (basePackages={"edu.cibertec"}) //[Component/Repository / Service /Controller]
public class DispatcherServlet { //AppConfig
 @Bean
 public InternalResourceViewResolver getInternalResourceViewResolver(){
     InternalResourceViewResolver resolver = new InternalResourceViewResolver();
     resolver.setPrefix("/WEB-INF/view/");
     resolver.setSuffix(".jsp");
     return resolver;
 }
}