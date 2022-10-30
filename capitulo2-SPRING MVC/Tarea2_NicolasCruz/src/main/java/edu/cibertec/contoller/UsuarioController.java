package edu.cibertec.contoller;

import edu.cibertec.dto.UsuarioDTO;
import edu.cibertec.service.UsuarioService;
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
    @RequestMapping("loginMostrar")
    public String login(){
        return "login";
    }
    @RequestMapping(value="loginAccion",method=RequestMethod.POST)
    public ModelAndView loginAccion(UsuarioDTO usuario){
        ModelAndView mv= new ModelAndView();
        usuario=usuarioService.validarLogin(usuario);
        if(usuario==null){
            mv=new ModelAndView("login","msgError","Usuario y/o Clave no eisten.. Vuelve a intentar");
        }else{            
            mv=new ModelAndView("usuarioLista","lista",usuarioService.listarUsuarios()); 
            mv.addObject("contador",0);
            valor++;
            mv.addObject("valor",valor);
        }
        return mv;
    }
    
    @RequestMapping("usuarioCrear")
    public ModelAndView usuarioCrear(){
        return new ModelAndView("usuarioDatos", "usuarioBean", new UsuarioDTO());
    }
    
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
            if(contador==null){
                contador=0;
            }
            contador++;            
            mv = new ModelAndView("usuarioLista", "lista", usuarioService.listarUsuarios());
            mv.addObject("contador",contador);
        }
        return mv;
    }        
    
    @RequestMapping("usuarioGrabar")
    public ModelAndView grabarUsuario(@RequestParam("archivo") CommonsMultipartFile archivo, @Valid @ModelAttribute("usuarioBean") UsuarioDTO usuario, BindingResult resulta, ModelMap modelo) {
        ModelAndView mv = null;
        if (resulta.hasErrors()) {
            mv = new ModelAndView("usuarioDatos", "usuarioBean", usuario);
        } else {
            usuario.setFoto(archivo.getBytes());
            usuarioService.insertarUsuario(usuario);
            Integer contador = (Integer) modelo.get("contador");
            if (contador == null) {
                contador = 0;
            }
            contador++;
            mv = new ModelAndView("usuarioLista", "lista", usuarioService.listarUsuarios());
            mv.addObject("contador", contador);
        }
        return mv;
    }
    
    @RequestMapping("usuarioModificar")
    public ModelAndView usuarioModificar(@RequestParam("idUsuario") Integer idUsuario) {
        ModelAndView mv = new ModelAndView("usuarioDatos", "usuarioBean", usuarioService.getUsuario(idUsuario));
        mv.addObject("accion", "Modificar");
        return mv;
    }
    
    @RequestMapping("usuariEliminar")
    public ModelAndView usuariEliminar(Integer idUsuario) {
        usuarioService.eliminarUsuario(idUsuario);
        return new ModelAndView("redirect:usuarioListar.do");
    }
    
    @RequestMapping("fotoMostrar")
    public String fotoMostrar(HttpServletRequest request, Model modelo){
        
        UsuarioDTO usuario=usuarioService.getUsuario(Integer.parseInt(request.getParameter("idUsuario")));
        String foto="";
        if(usuario.getFoto()!=null&&usuario.getFoto().length>0){
            foto=Base64.getEncoder().encodeToString(usuario.getFoto());
        }
        usuario.setFotoBase64(foto);
        modelo.addAttribute("usuario",usuario);  
        return  "fotoUsuario";
    }
    
    @RequestMapping("fotoGrabar")
    public ModelAndView fotoGrabar(@RequestParam("archivo") CommonsMultipartFile archivo,@RequestParam("idUsuario") Integer idUsuario  ){
        UsuarioDTO usuario =new UsuarioDTO();
        usuario.setIdUsuario(idUsuario);
        usuario.setFoto(archivo.getBytes());
        usuarioService.subirFoto(usuario);
        return new ModelAndView("usuarioLista","lista",usuarioService.listarUsuarios());
    }
    
    
}
