package edu.cibertec.capitulo1;


import edu.cibertec.capitulo1.service.ImpresoraService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Nicolas Cruz https://profesionaljava.com
 */
public class Ejecutora {
    public static void main(String[] args) {
        
        //ApplicationContext cxt = new ClassPathXmlApplicationContext("beans.xml");        
        ApplicationContext cxt = new AnnotationConfigApplicationContext(AppConfig.class);        
        ImpresoraService is = cxt.getBean(ImpresoraService.class);
        //ImpresoraService is = (ImpresoraService) cxt.getBean("impresoraService");
        is.imprimirDocumento();
        ((ConfigurableApplicationContext)cxt).close();
    }
    
}
