/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.cibertec.capitulo1.service;

import edu.cibertec.capitulo1.beans.Imprimible;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/**
 *
 * @author Nicolas Cruz https://profesionaljava.com
 */
@Service
public class ImpresoraService {
    
    @Autowired//equivale a hacer un new de un objeto
    @Qualifier("documentoExcel")// elige cual de los dos tipos de hijos va a resolver
    private Imprimible documento;// esta interfaz es un padre
    
    public ImpresoraService(){        
    }        
    
    public ImpresoraService(Imprimible documento){
        this.documento = documento;
    }
    
    public void imprimirDocumento(){
        System.out.println(documento.imprimir());
    }
    
    public Imprimible getDocumento() {
        return documento;
    }

    public void setDocumento(Imprimible documento) {
        this.documento = documento;
    }
    
}
