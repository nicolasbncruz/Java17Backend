package edu.cibertec.service.impl;

import edu.cibertec.dto.UsuarioDTO;
import edu.cibertec.repository.UsuarioDao;
import edu.cibertec.service.UsuarioService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author jpere
 */
@Service
public class UsuarioServiceImpl implements  UsuarioService{

    @Autowired
    private UsuarioDao usuarioDao;
    @Override
    public UsuarioDTO validarLogin(UsuarioDTO usuario) {
     return usuarioDao.validarLogin(usuario);
    }

    @Override
    public void insertarUsuario(UsuarioDTO usuario) {
        usuarioDao.insertarUsuario(usuario);
    }

    @Override
    public List<UsuarioDTO> listarUsuarios() {
     return usuarioDao.listarUsuarios();
    }

    @Override
   public UsuarioDTO getUsuario(Integer idUsuario) {
        return usuarioDao.getUsuario(idUsuario);
    }
    
    @Override
    public void subirFoto(UsuarioDTO usuario){
       usuarioDao.subirFoto(usuario); 
    }

    @Override
    public void usuarioModificar(Integer idUsuario) {
        usuarioDao.usuarioModificar(idUsuario);
    }

    @Override
    public void eliminarUsuario(Integer idUsuario) {
        usuarioDao.eliminarUsuario(idUsuario);
    }
}
