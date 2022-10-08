/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.cibertec.sabado.beans;

/**
 *
 * @author Nicolas Cruz https://profesionaljava.com
 */
public class HolaMundo {
    
    private String nombre;
    
    public void saludar() {
        System.out.println("Saludo usando Spring Context a: "+this.nombre);
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    
    
}
