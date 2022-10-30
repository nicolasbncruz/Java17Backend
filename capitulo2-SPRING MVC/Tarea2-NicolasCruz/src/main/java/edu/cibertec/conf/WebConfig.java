//package edu.cibertec.conf;
//
//import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;
//
//public class WebConfig extends AbstractAnnotationConfigDispatcherServletInitializer{ //AppInit
//
//    @Override
//    protected Class<?>[] getRootConfigClasses() {
//       return null;
//    }
//
//    @Override
//    protected Class<?>[] getServletConfigClasses() {
//      return new Class[]{DispatcherServlet.class};
//    }
//
//    @Override
//    protected String[] getServletMappings() {
//      return new String[]{"*.do"};
//    }
//    
//}

package edu.cibertec.conf;

import javax.servlet.ServletContext;
import javax.servlet.ServletRegistration;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;

public class WebConfig implements WebApplicationInitializer{//AppInit/WebInit

    @Override
    public void onStartup(ServletContext sc){
        AnnotationConfigWebApplicationContext webContext = new AnnotationConfigWebApplicationContext();
        webContext.setConfigLocation("edu.cibertec.conf.DispatcherServlet");
        ServletRegistration.Dynamic registration = sc.addServlet("DispatcherServlet", new org.springframework.web.servlet.DispatcherServlet(webContext));
        registration.setLoadOnStartup(1);
        registration.addMapping("*.do");
    }
    
}
