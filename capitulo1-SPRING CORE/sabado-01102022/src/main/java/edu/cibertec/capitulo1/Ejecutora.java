package edu.cibertec.capitulo1;


import edu.cibertec.capitulo1.beans.HolaMundo;
import edu.cibertec.capitulo1.service.ImpresoraService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Nicolas Cruz
 */
public class Ejecutora {
    public static void main(String[] args) {
        
        ApplicationContext cxt = new ClassPathXmlApplicationContext("beans.xml");        
        //ApplicationContext cxt = new AnnotationConfigApplicationContext(AppConfig.class);        
        HolaMundo hm = (HolaMundo) cxt.getBean("holaMundoBean");
        hm.saludar();
        ImpresoraService is = (ImpresoraService) cxt.getBean("impresoraServiceBean");
        is.imprimirDocumento();
        ((ConfigurableApplicationContext)cxt).close();
    }
    
}
