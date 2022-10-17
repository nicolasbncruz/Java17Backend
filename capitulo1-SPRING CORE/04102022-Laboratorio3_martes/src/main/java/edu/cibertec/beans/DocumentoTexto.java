/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.cibertec.beans;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Nicolas Cruz https://profesionaljava.com
 */
@Repository
public class DocumentoTexto implements Imprimible  {
    @Override
    public String imprimir() {
        return "Imprimiedo desde un archivo de texto";
    }  
    
    @PostConstruct
    public void iniciar(){
        System.out.println("Se inicia la Construccion del Bean DocumentoTexto");
    }
    
    @PreDestroy
    public void destruir(){
        System.out.println("Se Destruye el Bean DocumentoTexto");
    }
}
