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
 * @author Nicolas Cruz https://profesionaljava.com
 */
@Component
public abstract class MiClase {

    public void algunMetodo() {
        MiDependencia miDependencia =  instanciarMiDependencia();              
        miDependencia.imprimir();
    }

    @Lookup
    @Qualifier("miDependencia")
    protected abstract MiDependencia instanciarMiDependencia();

}
