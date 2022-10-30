package edu.cibertec.contoller;

import edu.cibertec.dto.UsuarioDTO;
import edu.cibertec.service.UsuarioService;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author jpere
 */
@Controller
@SessionAttributes("contador")
public class UsuarioController {
    @Autowired
    private UsuarioService usuarioService;
    private Integer valor=1;

    @RequestMapping("login")
    public String login(){
        return "login";
    }
 
    
    /**
     * @param usuario
     * @return ModelAndView
     */
    @RequestMapping(value="loginAccion",method=RequestMethod.POST)
    public ModelAndView loginAccion(UsuarioDTO usuario){
        ModelAndView mv= new ModelAndView();
        usuario=usuarioService.validarLogin(usuario);
        if(usuario==null){
            mv=new ModelAndView("login","msgError","Usuario y/o Clave no existen.. Vuelve a intentar");
        }else{            
            mv=new ModelAndView("usuarioLista","lista",usuarioService.listarUsuarios()); 
            mv.addObject("contador",0);
            valor++;
            mv.addObject("valor",valor);
        }
        return mv;
    }
    
    /**
     * @return ModelAndView
     */

    @RequestMapping("usuarioCrear")
    public ModelAndView usuarioCrear(){
        return new ModelAndView("usuarioDatos", "usuarioBean", new UsuarioDTO());
    }
    
    /**
     * @param usuario
     * @param resulta
     * @param modelo
     * @return ModelAndView
     */
    @RequestMapping("usuarioGrabar")
    public ModelAndView grabarUsuario(@Valid @ModelAttribute("usuarioBean")
        UsuarioDTO usuario, BindingResult resulta,ModelMap modelo) {
        ModelAndView mv = null;
        if (resulta.hasErrors())
            mv = new ModelAndView("usuarioDatos", "usuarioBean", usuario);
        else
        {
            usuarioService.insertarUsuario(usuario);
            Integer contador = (Integer)modelo.get("contador");
            contador++;            
            mv = new ModelAndView("usuarioLista", "lista", usuarioService.listarUsuarios());
            mv.addObject("contador",contador);
        }
        return mv;
    }
    
    /**
     * @param request
     * @param modelo
     * @return String
     */
    @RequestMapping("fotoMostrar")
    public String fotoMostrar(HttpServletRequest request, Model modelo){
        modelo.addAttribute("usuario",usuarioService.getUsuario(Integer.parseInt(request.getParameter("idUsuario"))));       
        return  "fotoUsuario";
    }
    
    /**
     * @param archivo
     * @param idUsuario
     * @return ModelAndView
     */
    @RequestMapping("fotoGrabar")
    public ModelAndView fotoGrabar(@RequestParam("archivo") CommonsMultipartFile archivo,@RequestParam("idUsuario") Integer idUsuario  ){
        UsuarioDTO usuario =new UsuarioDTO();
        usuario.setIdUsuario(idUsuario);
        usuario.setFoto(archivo.getBytes());
        usuarioService.subirFoto(usuario);
        return new ModelAndView("usuarioLista","lista",usuarioService.listarUsuarios());
    }
}
