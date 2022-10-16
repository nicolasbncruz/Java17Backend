/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.cibertec.sabado;

import edu.cibertec.sabado.beans.HolaMundo;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 *
 * @author Nicolas Cruz https://profesionaljava.com
 */
@Configuration
public class AppConfig {
    @Bean
    public HolaMundo holaMundoBean(){//este Bean se comporta igual al bean xml
        return new HolaMundo();
    }
    
}
