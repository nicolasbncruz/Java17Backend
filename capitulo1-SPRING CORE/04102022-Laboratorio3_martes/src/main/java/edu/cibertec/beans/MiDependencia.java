/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package edu.cibertec.beans;

import org.springframework.stereotype.Component;

/**
 *
 * @author Nicolas Cruz https://profesionaljava.com
 */
@Component
public class MiDependencia {

    public MiDependencia() {
        System.out.println("Se contruye el Bean MiDependencia!");
    }
    
    public void imprimir(){
        System.out.println("IMPRIMIR");
    }
}
