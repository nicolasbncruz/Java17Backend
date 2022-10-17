/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.cibertec.beans;

import org.springframework.beans.factory.annotation.Lookup;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

/**
 *
 * @author jpere
 */
@Component
public abstract class MiClase {

    
    @Qualifier
    public void algunMetodo() {
        MiDependencia miDependencia =  instanciarMiDependencia();       
        // continuar con el método 
        miDependencia.imprimir();
    }

    @Lookup
    @Qualifier("miDependencia")
    protected abstract MiDependencia instanciarMiDependencia();

}
