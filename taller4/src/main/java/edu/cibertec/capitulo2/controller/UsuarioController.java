package edu.cibertec.capitulo2.controller;

import edu.cibertec.capitulo2.model.UsuarioDTO;
import edu.cibertec.capitulo2.service.UsuarioService;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @RequestMapping("loginMostrar")
    public String loginMostrar() {
        return "login";
    }

    @RequestMapping("loginAccion")
    public ModelAndView loginAccion(UsuarioDTO usuarioValida) {
        ModelAndView mv = null;

        UsuarioDTO ue = usuarioService.validarLogin(usuarioValida);
        if (ue == null) {
            mv = new ModelAndView("login", "msgError", "Usuario y clave no existen. Vuelva a intentar!");
        } else {
            mv = new ModelAndView("usuarioLista", "lista", usuarioService.getListaUsuarios());
        }
        return mv;
    }
    
    @RequestMapping("usuarioCrear")
    public ModelAndView crearUsuario() {
        return new ModelAndView("usuarioDatos", "usuarioBean", new UsuarioDTO());
    }

    @RequestMapping("usuarioGrabar")
    public ModelAndView grabarUsuario(@Valid @ModelAttribute("usuarioBean") UsuarioDTO usuario, BindingResult resulta) {
        ModelAndView mv = null;
        if (resulta.hasErrors())
            mv = new ModelAndView("usuarioDatos", "usuarioBean", usuario);
        else
        {
            usuarioService.insertarUsuario(usuario);
            mv = new ModelAndView("usuarioLista", "lista", usuarioService.getListaUsuarios());
        }
        return mv;
    }
}
