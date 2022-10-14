package edu.cibertec.contoller;

import edu.cibertec.dto.UsuarioDTO;
import edu.cibertec.repository.UsuarioDao;
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
public class UsuarioController {
    @Autowired
    private UsuarioService usuarioService;
    @RequestMapping("login")
    public String login(){
        return "login";
    }
    @RequestMapping("loginAccion")
    public ModelAndView loginAccion(HttpServletRequest request){
        ModelAndView MV= new ModelAndView();
        UsuarioDTO usuario = new UsuarioDTO();
        usuario.setUsuario(request.getParameter("txtUsuario"));
        usuario.setClave(request.getParameter("txtClave"));
        usuario=usuarioService.validarLogin(usuario);
        if(usuario==null){
            MV=new ModelAndView("login","msgError","Usuario y/o Clave no eisten.. Vuelve a intentar");
        }else{
            MV=new ModelAndView("saludo","mensaje","Bienvenido "+usuario.getNombreApellido() ); 
        }
        return MV;
    }
}
