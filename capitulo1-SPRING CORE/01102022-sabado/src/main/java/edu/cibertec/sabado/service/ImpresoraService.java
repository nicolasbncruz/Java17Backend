/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.cibertec.sabado.service;

import edu.cibertec.sabado.beans.Imprimible;

/**
 *
 * @author Nicolas Cruz https://profesionaljava.com
 */
public class ImpresoraService {
    private Imprimible document;
    
    public void imprimirDocumento(){
        System.out.println(document.imprimir());
    }

    public Imprimible getDocument() {
        return document;
    }

    public void setDocument(Imprimible document) {
        this.document = document;
    }
    
    
    
}
