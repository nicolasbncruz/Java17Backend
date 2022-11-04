package edu.cibertec.sec04.controller;

import java.io.IOException;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.MultipartFile;
//import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.ModelAndView;

import edu.cibertec.sec04.dto.UsuarioDTO;
import edu.cibertec.sec04.entity.UsuarioEntity;
import edu.cibertec.sec04.service.UsuarioService;

@Controller
@SessionAttributes("contador")

public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;
    private Integer valor = 1;

    @RequestMapping("login")
    public String login() {
        return "login";
    }

    @RequestMapping(value = "loginAccion", method = RequestMethod.POST)
    public ModelAndView loginAccion(UsuarioEntity usuario) {
        ModelAndView mv = new ModelAndView();
        usuario = usuarioService.validarLogin(usuario);
        if (usuario == null) {
            mv = new ModelAndView("login", "msgError", "Usuario y/o Clave no existen.. Vuelve a intentar");
        } else {
            mv = new ModelAndView("menu", "usuario", usuario);
            mv.addObject("contador", 0);
            valor++;
            mv.addObject("valor", valor);
        }
        return mv;
    }

    
    @RequestMapping("usuarioListar")
    public ModelAndView usuarioListar() {
        ModelAndView mv = new ModelAndView("usuarioLista", "lista", usuarioService.listarUsuarios());
        mv.addObject("orden", "ASC");
        return mv;
    }

    
    @RequestMapping("usuarioListarPag")
    public ModelAndView usuarioListarPag(@RequestParam("pag") int pag, @RequestParam("columna") String columna, @RequestParam("orden") String orden) {

        Pageable pagina = null;
        if (orden == null || orden.equalsIgnoreCase("null") || columna == null || columna.equalsIgnoreCase("null")) {
            pagina = PageRequest.of(pag, 5);
            orden = "ASC";
        } else {
            if (orden.equals("ASC")) {
                pagina = PageRequest.of(pag, 5, Sort.by(Sort.Direction.ASC, columna));
                orden = "DESC";
            } else {
                pagina = PageRequest.of(pag, 5, Sort.by(Sort.Direction.DESC, columna));
                orden = "ASC";
            }
        }
        ModelAndView mv = new ModelAndView("usuarioLista", "lista", usuarioService.listarUsuarios(pagina));
        mv.addObject("orden", orden);
        return mv;
    }
    

    @RequestMapping("usuarioCrear")
    public ModelAndView usuarioCrear() {
        ModelAndView mv = new ModelAndView("usuarioDatos", "usuarioBean", new UsuarioDTO());
        mv.addObject("accion", "Crear");
        return mv;
    }

    
    @RequestMapping("usuarioModificar")
    public ModelAndView usuarioModificar(@RequestParam("idUsuario") Integer idUsuario) {
        ModelAndView mv = new ModelAndView("usuarioDatos", "usuarioBean", usuarioService.getUsuario(idUsuario));
        mv.addObject("accion", "Modificar");
        return mv;
    }

    
    @RequestMapping(value = "usuarioGrabar", method = RequestMethod.POST)
    public ModelAndView grabarUsuario(@RequestParam("accion") String accion, @RequestParam("archivo") MultipartFile archivo, 
    	@Validated	@ModelAttribute("usuarioBean") UsuarioEntity usuario, BindingResult resulta, ModelMap modelo) throws IOException {
        
    	ModelAndView mv = null;
        if (resulta.hasErrors()) {
            mv = new ModelAndView("usuarioDatos", "usuarioBean", usuario);
        } else {
        	

        	if (archivo.getOriginalFilename() != "" && !archivo.getOriginalFilename().equals(null)) {
        		usuario.setFoto(archivo.getBytes());
        	}
        	        	
            usuarioService.grabarUsuario(usuario);
            Integer contador = (Integer) modelo.get("contador");
            if (contador == null) {
                contador = 0;
            }
            contador++;
            mv = new ModelAndView("usuarioLista", "lista", usuarioService.listarUsuarios());
            mv.addObject("contador", contador);
        }
        mv.addObject("accion",accion);
        return mv;
    }

    
    
    @RequestMapping("usuariEliminar")
    public ModelAndView usuariEliminar(@RequestParam(name = "idUsuario") Integer idUsuario) {
    	UsuarioEntity usuario = new UsuarioEntity();
    	usuario.setIdUsuario(idUsuario);
        usuarioService.eliminarUsuario(usuario);
    	return new ModelAndView("redirect:usuarioListar");
    }

    
    //@RequestMapping("listarUsuarios")
    @RequestMapping(
            value = "listarUsuarios",
            method = RequestMethod.GET,
            produces = "application/json"
    )
    public @ResponseBody
    List<UsuarioEntity> listarUsuarios(String usuario) {
        if (usuario == null) {
            usuario = new String("");
        }
        return usuarioService.listarUsuariosByUser(usuario);
    }

//    @RequestMapping("fotoMostrar")
//    public String fotoMostrar(HttpServletRequest request, Model modelo){        
//        UsuarioEntity usuario=usuarioService.getUsuario(Integer.parseInt(request.getParameter("idUsuario")));
//        modelo.addAttribute("usuario",usuario);  
//        return  "fotoUsuario";
//    }
//    
//    @RequestMapping("fotoGrabar")
//    public ModelAndView fotoGrabar(@RequestParam("archivo") CommonsMultipartFile archivo,@RequestParam("idUsuario") Integer idUsuario  ){
//        UsuarioEntity usuario =new UsuarioEntity();
//        usuario.setIdUsuario(idUsuario);
//        usuario.setFoto(archivo.getBytes());
//        usuarioService.actualizarUsuario(usuario);
//        return new ModelAndView("usuarioLista","lista",usuarioService.listarUsuarios());
//    }
}
