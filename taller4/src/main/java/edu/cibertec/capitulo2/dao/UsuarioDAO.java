package edu.cibertec.capitulo2.dao;

import edu.cibertec.capitulo2.model.UsuarioDTO;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Repository;

@Repository
public class UsuarioDAO {
    
    private List<UsuarioDTO> listaUsuarios;

    public UsuarioDAO() {
        listaUsuarios = new ArrayList<>();
        listaUsuarios.add(new UsuarioDTO("jose", "12345", "José Perez"));
        listaUsuarios.add(new UsuarioDTO("yaddif", "54321", "Yaddif Medina"));
        listaUsuarios.add(new UsuarioDTO("carmen", "c1rm3n", "Carmen Rios"));
        listaUsuarios.add(new UsuarioDTO("maria", "m2ria", "Maria Quispe"));
    }
    
    public void insertarUsuario(UsuarioDTO usuario) {
        listaUsuarios.add(usuario);
    }

    public List<UsuarioDTO> getListaUsuarios() {
        return listaUsuarios;
    }
    
    
    
    public UsuarioDTO validarLogin(UsuarioDTO usuario) {
        if (usuario.getUsuario().equalsIgnoreCase("user") &&
                usuario.getClave().equals("12345"))
            usuario.setNombreCompleto("Nombre completo del usuario");
        else
            usuario = null;
        
        return usuario;
    }   
}
