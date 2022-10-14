package edu.cibertec.service.impl;

import edu.cibertec.dto.UsuarioDTO;
import edu.cibertec.repository.UsuarioDao;
import edu.cibertec.service.UsuarioService;
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
    
}
