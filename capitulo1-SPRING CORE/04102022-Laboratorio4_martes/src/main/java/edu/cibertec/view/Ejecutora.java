package edu.cibertec.view;

import edu.cibertec.service.ImpresoraService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author jpere
 */
public class Ejecutora {
    public static void main(String[] args) {
        ApplicationContext cxt = new ClassPathXmlApplicationContext("beans.xml");
        //ApplicationContext cxt = new AnnotationConfigApplicationContext(AppConfig.class);
        
        ImpresoraService is = cxt.getBean(ImpresoraService.class);
        is.imprimirDocumento();
                
        ((ConfigurableApplicationContext)cxt).close();
    }
}
