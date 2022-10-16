/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.cibertec.capitulo1;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 *
 * @author Nicolas Cruz https://profesionaljava.com
 */
@Configuration
@ComponentScan// component scan - repository - service - controller a cualquiera de esos componentes los reconoce
public class AppConfig {
    
    /*@Bean
    public HolaMundo holaMundoBean(){
        return new HolaMundo();
    }*/
    
    /*
    @Bean
    public DocumentoTexto documentoTexto(){
        return new DocumentoTexto();
    }
    
    @Bean
    public DocumentoExcel documentoExcel(){
        return new DocumentoExcel();
    }
    
    @Bean
    public ImpresoraService impresoraServiceBean(){
        return new ImpresoraService();
    }    */
    
}
