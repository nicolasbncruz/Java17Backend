/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.cibertec;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Nicolas Cruz https://profesionaljava.com
 */
@Controller
public class SaludoController {
    /*@RequestMapping("saludo")
    public String Saludar(){       
        return "saludo";// el jsp necesita tener el mensaje
    }*/
    
    /*@RequestMapping("saludo")
    public String Saludar(Model modelo){
        modelo.addAttribute("mensaje", "Bienvenido desde el controlador!!!");
        return "saludo";
    }*/
    
    @RequestMapping("saludo")
    public ModelAndView Saludar(){
        ModelAndView mv = new ModelAndView();
        mv.addObject("mensaje1", "Bienvenido desde el controlador!!!");
        mv.addObject("mensaje2", "Nicolas Cruz Carpio ModelAndView!!");
        mv.setViewName("saludo");
        return mv;
    }
    
    /*@RequestMapping("saludo")
    public ModelAndView Saludar(){
        ModelAndView mv = new ModelAndView("saludo", "mensaje1", "bienvenido desde el controlador Model And view");        
        return mv;
    }*/
    
    /*
    @RequestMapping("saludo")
    public ModelAndView Saludar(@RequestParam("Nombre")String Nombre){
        Map<String, String> mp = new HashMap<>();
        mp.put("mensaje1", "Bienvenido desde el controlador!!!");        
        mp.put("mensaje2", Nombre);
        ModelAndView mv = new ModelAndView("saludo", mp);
        return mv;
    } */
        
}
