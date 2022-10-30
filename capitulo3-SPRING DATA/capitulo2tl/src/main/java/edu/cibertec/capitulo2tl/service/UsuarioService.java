package edu.cibertec.capitulo2tl.service;

import edu.cibertec.capitulo2tl.dao.UsuarioDAO;
import edu.cibertec.capitulo2tl.model.UsuarioDTO;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioDAO usuarioDAO;

    public UsuarioDTO validarLogin(UsuarioDTO usuario) {
        return usuarioDAO.validarLogin(usuario);
    }

    public void insertarUsuario(UsuarioDTO usuario) {
        usuarioDAO.insertarUsuario(usuario);
    }

    public List<UsuarioDTO> getListaUsuarios() {
        return usuarioDAO.getListaUsuarios();
    }
    
    public UsuarioDTO getUsuario(String codigo) {
        return usuarioDAO.getUsuario(codigo);
    }

}
