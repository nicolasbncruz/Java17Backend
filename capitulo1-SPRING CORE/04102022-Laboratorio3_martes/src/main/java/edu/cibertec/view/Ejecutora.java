package edu.cibertec.view;

import edu.cibertec.beans.HolaMundo;
import edu.cibertec.beans.MiClase;
import edu.cibertec.service.ImpresoraService;
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
        HolaMundo hm= new HolaMundo();
        System.out.println(hm.getNombre()==null);
        
        HolaMundo hm1=(HolaMundo) cxt.getBean(HolaMundo.class);
        hm1.saludar();
        HolaMundo hm2=(HolaMundo) cxt.getBean(HolaMundo.class);
        hm2.saludar();
       
        hm2.setNombre("Nicolas");
        System.out.println(hm1==hm2);
        System.out.println(hm1.getNombre());
//        //Creando un Bean por tipo con etiquetas
//        ImpresoraService is=(ImpresoraService) cxt.getBean("impresoraExcelServiceBean");
//        is.imprimirDocumento();
//        is=(ImpresoraService) cxt.getBean("impresoraTextoServiceBean");
//        is.imprimirDocumento();
        //Considerando un solo Bean con clase
        ImpresoraService is = cxt.getBean(ImpresoraService.class);
        is.imprimirDocumento();
        
        MiClase mc =  cxt.getBean(MiClase.class);
        mc.algunMetodo();

        
        ((ConfigurableApplicationContext)cxt).close();
    }
}
