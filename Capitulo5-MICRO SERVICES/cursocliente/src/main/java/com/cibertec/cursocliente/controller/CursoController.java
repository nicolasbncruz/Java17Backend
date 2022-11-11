package com.cibertec.cursocliente.controller;

import com.cibertec.cursocliente.dto.CursoDTO;
import com.cibertec.cursocliente.service.CursoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CursoController {

  @Autowired
  private CursoService cursoService;

  @RequestMapping("cursoListar")
  public ModelAndView cursoMostrar(){
    ModelAndView mv = new ModelAndView("curso", "lista", cursoService.listarTodos());
    mv.addObject("cursoBean", new CursoDTO());
    return mv;
  }

  @RequestMapping("cursoGrabar")
  public ModelAndView cursoGrabar(@ModelAttribute("cursoBean") CursoDTO curso){
    ModelAndView mv = new ModelAndView("curso");
    cursoService.insertar(curso);
    mv.addObject("cursoBean", new CursoDTO());
    mv.addObject("lista",cursoService.listarTodos());
    return mv;
  }

  @RequestMapping("cursoEliminar")
  public ModelAndView cursoEliminar(@RequestParam("codigo") Integer codigo){
    cursoService.eliminar(codigo);
    ModelAndView mv = new ModelAndView("redirect:cursoListar");
    return mv;
  }


}
