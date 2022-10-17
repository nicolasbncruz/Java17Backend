/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.cibertec.beans;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import org.springframework.stereotype.Controller;

/**
 *
 * @author Nicolas Cruz https://profesionaljava.com
 */
@Controller
public class DocumentoExcel implements Imprimible  {
    @Override
    public String imprimir() {
        return "Imprimiedo desde un archivo de excel";
    }
    
    @PostConstruct
    public void iniciar(){
        System.out.println("Se inicia la Construccion del Bean DocumentoExcel!!");
    }
    
    @PreDestroy
    public void destruir(){
        System.out.println("Se destruye el Bean DocumentoExcel");
    }
}