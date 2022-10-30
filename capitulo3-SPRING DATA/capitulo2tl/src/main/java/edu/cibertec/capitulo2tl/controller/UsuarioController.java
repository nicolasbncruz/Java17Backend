package edu.cibertec.capitulo2tl.controller;

import edu.cibertec.capitulo2tl.model.UsuarioDTO;
import edu.cibertec.capitulo2tl.service.UsuarioService;
import java.util.Base64;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.ModelAndView;

@Controller
@SessionAttributes("contador")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @RequestMapping("login")
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
            mv.addObject("contador", 0);
        }
        return mv;
    }

    @RequestMapping("usuarioCrear")
    public ModelAndView crearUsuario() {
        return new ModelAndView("usuarioDatos", "usuarioBean", new UsuarioDTO());
    }

    @RequestMapping("usuarioGrabar")
    public ModelAndView grabarUsuario(@Valid @ModelAttribute("usuarioBean") UsuarioDTO usuario, BindingResult resulta, ModelMap modelo) {
        ModelAndView mv = null;
        if (resulta.hasErrors()) {
            mv = new ModelAndView("usuarioDatos", "usuarioBean", usuario);
        } else {
            usuarioService.insertarUsuario(usuario);
            mv = new ModelAndView("usuarioLista", "lista", usuarioService.getListaUsuarios());
            int contador = (int) modelo.get("contador");
            contador++;
            mv.addObject("contador", contador);
        }
        return mv;
    }

    @RequestMapping("fotoMostrar")
    public String fotoMostrar(HttpServletRequest request, Model modelo) {
        UsuarioDTO usuario = usuarioService.getUsuario(request.getParameter("codigoUsuario"));
        modelo.addAttribute("usuario", usuario);
        String foto = "";
        if (usuario.getFoto() != null && usuario.getFoto().length>0)
        	foto = Base64.getEncoder().encodeToString(usuario.getFoto());
        modelo.addAttribute("foto64", foto);
        return "fotoUsuario";
    }

    @RequestMapping("fotoGrabar")
    public ModelAndView fotoGrabar(@RequestParam("archivo") CommonsMultipartFile archivo,
            @RequestParam("codigoUsuario") String codigoUsuario) {

        UsuarioDTO usuario = usuarioService.getUsuario(codigoUsuario);
        usuario.setFoto(archivo.getBytes());

        return new ModelAndView("usuarioLista", "lista", usuarioService.getListaUsuarios());
    }
}
