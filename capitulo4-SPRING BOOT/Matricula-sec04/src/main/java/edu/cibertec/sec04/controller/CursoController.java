package edu.cibertec.sec04.controller;

import edu.cibertec.sec04.service.*;
import java.sql.Date;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Carlos Jesus Herrera Huaman
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
        String filtro = "";
        switch (tipoConsulta) {
            case "estado":
                Integer estado = Integer.parseInt(request.getParameter("estado"));
                filtro = "Resultado Filtrado por " + tipoConsulta + ": " + (estado==0?"Creado":estado==1?"En Proceso de Venta":"Completo");
                mv.addObject("filtro", filtro);
                mv.addObject("lista", cursoService.consultarPorEstado(estado));
                break;
            case "incompleto":
                mv.addObject("lista", cursoService.abiertoIncompleto());
                filtro = "Resultado Filtrado por cursos Incompletos";
                mv.addObject("filtro", filtro);
                break;
            case "porFecha":
                Date fecha = Date.valueOf(request.getParameter("fecha"));
                mv.addObject("lista", cursoService.consultarPorFecha(fecha));
                filtro = "Resultado Filtrado por fecha: " + fecha;
                mv.addObject("filtro", filtro);
                break;
            case "faltante":
                Integer faltante = Integer.parseInt(request.getParameter("faltante"));
                mv.addObject("lista", cursoService.consultarFaltantes(faltante));
                filtro = "Resultado Filtrado por Alumnos Faltantes, cantidad: " + faltante;
                mv.addObject("filtro", filtro);
                break;
            case "nombre":
                String nombre = request.getParameter("nombre");
                mv.addObject("lista", cursoService.consultarPorNombre(nombre));
                filtro = "Resultado Filtrado por Nombre de curso, " + nombre;
                mv.addObject("filtro", filtro);
                break;
            default:
                mv.addObject("lista", null);
                break;
        }
        return mv;
    }
}
