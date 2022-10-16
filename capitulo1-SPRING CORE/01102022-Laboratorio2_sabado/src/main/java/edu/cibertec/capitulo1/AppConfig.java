/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.cibertec.capitulo1;

import edu.cibertec.capitulo1.beans.HolaMundo;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 *
 * @author Nicolas Cruz https://profesionaljava.com
 */
@Configuration
public class AppConfig {
    
    /*
    @Bean
    public DocumentoTexto documentoTexto(){
        return new DocumentoTexto();
    }
    
    @Bean
    public DocumentoTextoExcel documentoTextoExcel(){
        return new DocumentoTextoExcel();
    }
    
    @Bean
    public ImpresoraService impresoraTextoServiceBean(){
        return new ImpresoraService();
    }
    
    @Bean
    public ImpresoraService impresoraTextoExcelServiceBean(){
        return new ImpresoraService();
    }*/
    
    @Bean
    public HolaMundo holaMundoBean(){
        return new HolaMundo();
    }
    
}
