/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package edu.cibertec.beans;

import org.springframework.stereotype.Component;

/**
 *
 * @author jpere
 */
@Component
public class MiDependencia {

    public MiDependencia() {
        System.out.println("Construyendo el Bean MiDependencia");
    }
    
    public void imprimir(){
        System.out.println("Metodo Imprimir");
    }
}
