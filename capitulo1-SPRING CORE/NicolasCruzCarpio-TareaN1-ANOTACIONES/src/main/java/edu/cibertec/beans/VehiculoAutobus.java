/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.cibertec.beans;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Nicolas Cruz https://profesionaljava.com
 */
@Repository
//@Lazy(value = true)
public class VehiculoAutobus implements Vehiculo  {
    @Override
    public String imprimir() {
        return "Imprimiedo desde un Vehiculo Autobus";
    }  
    
    @PostConstruct
    public void iniciar(){
        System.out.println("Iniciando la Construccion del Bean VehiculoAutobus!!");
    }
    
    @PreDestroy
    public void destruir(){
        System.out.println("Destruyendo el Bean VehiculoAutobus!!");
    }
}
