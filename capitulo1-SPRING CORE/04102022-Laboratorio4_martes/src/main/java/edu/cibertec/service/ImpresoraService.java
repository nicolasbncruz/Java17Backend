/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.cibertec.service;

import edu.cibertec.beans.DocumentoTexto;
import edu.cibertec.beans.Imprimible;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.DependsOn;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

/**
 *
 * @author jpere
 */
@Service
//@DependsOn(value = {
//        "documentoTexto",
//        "documentoExcel"
//    })
public class ImpresoraService {
//    @Autowired
//    @Qualifier("documentoExcel")
    private Imprimible documento;

    public ImpresoraService() {
    }
    
    @Autowired
    public ImpresoraService(@Qualifier("documentoExcel") Imprimible documento) {
        this.documento = documento;
    }
    
    public void imprimirDocumento(){
        System.out.println(this.documento.imprimir()); 
    }

    public Imprimible getDocumento() {
        return  this.documento;
    }

//    @Autowired
//    @Qualifier("documentoExcel")
    public void setDocumento(Imprimible documento) {
        this.documento = documento;
    }
    
    
}
