/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.cibertec.capitulo1.service;

import edu.cibertec.capitulo1.beans.Imprimible;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author Nicolas Cruz
 */
public class ImpresoraService {

    @Autowired
    public Imprimible getDocumento() {
        return documento;
    }

    public void setDocumento(Imprimible documento) {
        this.documento = documento;
    }
    
    private Imprimible documento;
    
    public void imprimirDocumento(){
        System.out.println(documento.imprimir());
    }
    
}
