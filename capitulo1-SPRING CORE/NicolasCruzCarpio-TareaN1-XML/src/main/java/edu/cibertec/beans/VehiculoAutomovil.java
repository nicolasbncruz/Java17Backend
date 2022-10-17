/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.cibertec.beans;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import org.springframework.stereotype.Controller;

/**
 *
 * @author Nicolas Cruz https://profesionaljava.com
 */
@Controller
//@Lazy(value = true)
public class VehiculoAutomovil implements Vehiculo  {
    @Override
    public String imprimir() {
        return "Imprimiedo desde el Vehiculo Automovil";
    }
    
    @PostConstruct
    public void iniciar(){
        System.out.println("Inicia la Construccion del Bean VehiculoAutomovil!!");
    }
    
    @PreDestroy
    public void destruir(){
        System.out.println("Destruyendo el Bean VehiculoAutomovil!!");
    }
}