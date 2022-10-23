/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.cibertec;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author Nicolas Cruz https://profesionaljava.com
 */
@Controller
public class SaludoController {
    @RequestMapping("saludo")
    public String Saludar(){       
        return "saludo";// el jsp necesita tener el mensaje
    }
       
}
