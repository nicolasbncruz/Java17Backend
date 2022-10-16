/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.cibertec.capitulo1.beans;

import org.springframework.stereotype.Component;

/**
 *
 * @author Nicolas Cruz https://profesionaljava.com
 */
@Component
public class DocumentoExcel implements Imprimible{

    @Override
    public String imprimir() {
        return "Imprimiendo desde un archivo de Excel";
    }
    
    
}
