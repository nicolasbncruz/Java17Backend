/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.cibertec.view;

import edu.cibertec.beans.DocumentoExcel;
import edu.cibertec.beans.DocumentoTexto;
import edu.cibertec.beans.HolaMundo;
import edu.cibertec.service.ImpresoraService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;

/**
 *
 * @author jpere
 */
@Configuration 
//USANDO "ComponentScan" PARA QUE ESCANE TODOS LOS COMPONENTES AGREGADOS CON NOTACIONES
//Si las clases estan dentro del mismo paquete no es necesario agregar el basePackages en este caso  
//como esta en el paquete edu.cibertec.view tenemos que indicarle que mapee todo lo del edu.cibertec
@ComponentScan (basePackages={"edu.cibertec"},lazyInit = true) //[Component/Repository / Service /Controller]

public class AppConfig {

//    @Bean
//    public HolaMundo holaMundoBean() {
//        return new HolaMundo();
//    }

//    @Bean
//    public DocumentoTexto documentoTexto() {
//        return new DocumentoTexto();
//    }
//
//    @Bean
//    public DocumentoExcel documentoExcel() {
//        return new DocumentoExcel();
//    }
//
//    @Bean
//    public ImpresoraService impresoraServiceBean() {
//        return new ImpresoraService();
//    }
//    
////    @Bean
////    public ImpresoraService impresoraTextoServiceBean(){
////        return new ImpresoraService(new DocumentoTexto());
////    }
////    
////    @Bean
////    public ImpresoraService impresoraExcelServiceBean(){
////        return new ImpresoraService(new DocumentoExcel());
////    }
//    
    

}
