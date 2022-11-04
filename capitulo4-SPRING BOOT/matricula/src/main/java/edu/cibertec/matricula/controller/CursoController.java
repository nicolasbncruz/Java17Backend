package edu.cibertec.matricula.controller;

import edu.cibertec.matricula.service.CursoService;
import java.sql.Date;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author jpere
 */
@Controller
public class CursoController {

    @Autowired
    private CursoService cursoService;

    @RequestMapping("cursoMostrar")
    public String cursoMostrar() {
        return "cursoBusqueda";
    }

    @RequestMapping("cursoBusqueda")
    public ModelAndView cursoBusqueda(HttpServletRequest request) {
        ModelAndView mv = new ModelAndView("cursoBusqueda");
        String tipoConsulta = request.getParameter("tipo");
        switch (tipoConsulta) {
            case "estado":
                Integer estado = Integer.parseInt(request.getParameter("estado"));
                mv.addObject("lista", cursoService.consultarPorEstado(estado));
                break;
            case "incompleto":
                mv.addObject("lista", cursoService.abiertoIncompleto());
                break;
            case "porFecha":
                Date fecha = Date.valueOf(request.getParameter("fecha"));
                mv.addObject("lista", cursoService.consultarPorFecha(fecha));
                break;
            case "faltante":
                Integer faltante = Integer.parseInt(request.getParameter("faltante"));
                mv.addObject("lista", cursoService.consultarFaltantes(faltante));
                break;
            case "nombre":
                String nombre = request.getParameter("nombre");
                mv.addObject("lista", cursoService.consultarPorNombre(nombre));
                break;
            default:
                mv.addObject("lista", null);
                break;
        }
        return mv;
    }
}
