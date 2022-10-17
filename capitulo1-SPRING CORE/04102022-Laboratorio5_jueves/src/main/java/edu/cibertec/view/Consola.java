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

/**
 *
 * @author jpere
 */
@Configuration
@ComponentScan (basePackages={"edu.cibertec"})
@EnableAspectJAutoProxy
public class Consola {
    public static void main(String[] args) {        
        ApplicationContext cxt = new AnnotationConfigApplicationContext(Consola.class);
        HolaMundo hm1=cxt.getBean(HolaMundo.class);
        hm1.saludar();
   
    }
}
