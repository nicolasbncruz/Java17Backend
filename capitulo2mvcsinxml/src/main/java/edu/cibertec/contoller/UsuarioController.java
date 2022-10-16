package edu.cibertec.contoller;

import edu.cibertec.dto.UsuarioDTO;
import edu.cibertec.service.UsuarioService;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author jpere
 */
@Controller
public class UsuarioController {
    @Autowired
    private UsuarioService usuarioService;
    @RequestMapping("login")
    public String login(){
        return "login";
    }
    @RequestMapping(value="loginAccion",method=RequestMethod.POST)
    public ModelAndView loginAccion(UsuarioDTO usuario){
        ModelAndView MV= new ModelAndView();
        usuario=usuarioService.validarLogin(usuario);
        if(usuario==null){
            MV=new ModelAndView("login","msgError","Usuario y/o Clave no eisten.. Vuelve a intentar");
        }else{
            MV=new ModelAndView("usuarioLista","lista",usuarioService.listarUsuarios()); 
        }
        return MV;
    }
    
    @RequestMapping("usuarioCrear")
    public ModelAndView usuarioCrear(){
        return new ModelAndView("usuarioDatos", "usuarioBean", new UsuarioDTO());
    }
    
     @RequestMapping("usuarioGrabar")
    public ModelAndView grabarUsuario(@Valid @ModelAttribute("usuarioBean")
        UsuarioDTO usuario, BindingResult resulta) {
        ModelAndView mv = null;
        if (resulta.hasErrors())
            mv = new ModelAndView("usuarioDatos", "usuarioBean", usuario);
        else
        {
            usuarioService.insertarUsuario(usuario);
            mv = new ModelAndView("usuarioLista", "lista", usuarioService.listarUsuarios());
        }
        return mv;
    }
    
    
    @RequestMapping("fotoMostrar")
    public String fotoMostrar(HttpServletRequest httpServletRequest, Model modelo){
        modelo.addAttribute("usuario", usuarioService.getUsuario(Integer.parseInt(httpServletRequest.getParameter("codigoUssuario"))));
        return "fotoUsuario";
    }
    
    @RequestMapping("fotoGrabar")
    public ModelAndView fotoGrabar(@RequestParam("archivo") Commons){
        return new ModelAndView("usuarioDatos", "usuarioBean", new UsuarioDTO());
    }
    
}
