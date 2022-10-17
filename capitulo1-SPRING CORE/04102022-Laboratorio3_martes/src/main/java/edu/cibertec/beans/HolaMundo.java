/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.cibertec.beans;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 *
 * @author jpere
 */
@Component ("holaMundoBean")
@Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class HolaMundo {
    @Value("Alumnos desde anotaciones!")
    private String nombre;
    public void saludar(){
        System.out.println("Saludo usando Spring a "+this.nombre);
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
}
