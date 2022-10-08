package edu.cibertec.sabado;


import edu.cibertec.sabado.beans.HolaMundo;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

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
        ApplicationContext cxt = new ClassPathXmlApplicationContext("beans.xml");
        HolaMundo hm = (HolaMundo)cxt.getBean("holaMundoBean");
        hm.saludar();
        ((ConfigurableApplicationContext)cxt).close();
    }
}
