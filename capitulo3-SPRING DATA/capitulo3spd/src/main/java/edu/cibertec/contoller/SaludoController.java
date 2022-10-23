/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.cibertec.contoller;

import java.util.HashMap;
import java.util.Map;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class SaludoController {
//    @RequestMapping("saludo")
//    public String Saludar(){
//        return "saludo.jsp";
//    }
//    @RequestMapping("saludo")
//    public String Saludar(){
//        return "saludo";
//    }
//    @RequestMapping("saludo")
//    public String Saludar(Model modelo){
//        modelo.addAttribute("mensaje1", "Bienvenido desde el controlador");
//        modelo.addAttribute("mensaje2", "JUAN CARLOS");
//        return "saludo";
//    }
    
//    @RequestMapping("saludo")
//    public ModelAndView Saludar(){
//        ModelAndView mv= new ModelAndView ();
//        mv.addObject("mensaje1", "Bienvenido desde el controlador ModelAndView");
//        mv.addObject("mensaje2", "JUAN CARLOS ModelAndView");
//        mv.setViewName("saludo");
//        return mv;
//    }
//    @RequestMapping("saludo")
//    public ModelAndView Saludar(){
//        ModelAndView mv= new ModelAndView ("saludo","mensaje1", "Bienvenido desde el controlador ModelAndView");
//        return mv;
//    }
    
//    @RequestMapping("saludo")
//    public ModelAndView Saludar(@RequestParam(name = "Nombre",required = false) String Nombre){
//        Map<String,String> mp = new HashMap<>();
//        mp.put("mensaje1", "Bienvenido desde el controlador");
//        mp.put("mensaje2", Nombre);
//        ModelAndView mv= new ModelAndView ("saludo",mp);
//        return mv;
//    }
    
//    @RequestMapping("saludo")
//    public ModelAndView Saludar(String Nombre){
//        Map<String,String> mp = new HashMap<>();
//        mp.put("mensaje1", "Bienvenido desde el controlador");
//        mp.put("mensaje2", Nombre);
//        ModelAndView mv= new ModelAndView ("saludo",mp);
//        return mv;
//    }

    
//  Ejempo con PathVariable
    @RequestMapping("saludo/{nombre}")
    public ModelAndView Saludar(@PathVariable String nombre){
        Map<String,String> mp = new HashMap<>();
        mp.put("mensaje1", "Bienvenido desde el controlador");
        mp.put("mensaje2", nombre);
        ModelAndView mv= new ModelAndView ("saludo",mp);
        return mv;
    }
    
}
