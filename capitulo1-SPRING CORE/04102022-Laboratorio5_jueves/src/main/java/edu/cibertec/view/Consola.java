/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package edu.cibertec.view;

import edu.cibertec.beans.HolaMundo;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author jpere
 */
@Configuration
//USANDO "ComponentScan" PARA QUE ESCANE TODOS LOS COMPONENTES AGREGADOS CON NOTACIONES
//Si las clases estan dentro del mismo paquete no es necesario agregar el basePackages en este caso  
//como esta en el paquete edu.cibertec.view tenemos que indicarle que mapee todo lo del edu.cibertec
@ComponentScan (basePackages={"edu.cibertec"}) //[Component/Repository / Service /Controller] 
@EnableAspectJAutoProxy
public class Consola {
    public static void main(String[] args) {
        //ApplicationContext cxt = new ClassPathXmlApplicationContext("beans.xml");
        ApplicationContext cxt = new AnnotationConfigApplicationContext(Consola.class);
        HolaMundo hm1=cxt.getBean(HolaMundo.class);
        hm1.saludar();
   
    }
}
