package edu.cibertec.contoller;

import edu.cibertec.entity.CursoEntity;
import edu.cibertec.entity.MatriculaEntity;
import edu.cibertec.entity.UsuarioEntity;
import edu.cibertec.service.CursoService;
import edu.cibertec.service.MatriculaService;
import edu.cibertec.service.UsuarioService;
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
public class MatriculaController {
    @Autowired
    private MatriculaService matriculaService;
    @Autowired
    private CursoService cursoService;
    @Autowired
    private UsuarioService usuarioService;
    
    @RequestMapping("matriculaMostrar")
    public ModelAndView matriculaMostrar() {
        ModelAndView mv = new ModelAndView("matricula", "listaMat",matriculaService.listaTodas());
        mv.addObject("listaUsu",usuarioService.listarUsuarios());
        mv.addObject("listaCur",cursoService.consultarPorEstado(0));
        return mv;
    }
    
    @RequestMapping("matriculaGrabar")
    public ModelAndView matriculaGrabar(MatriculaEntity matriculaEntity, HttpServletRequest request) {
        CursoEntity curso = new CursoEntity();
        curso.setIdCurso(Integer.parseInt(request.getParameter("cmbCurso")));
        UsuarioEntity usuario = new UsuarioEntity();
        usuario.setIdUsuario(Integer.parseInt(request.getParameter("cmbCurso")));   
        
        matriculaEntity.setCurso(curso);
        matriculaEntity.setUsuario(usuario);
        
        matriculaService.grabarMatricula(matriculaEntity);
        
        return new ModelAndView("redirect:matriculaMostrar.do");
    }
}
