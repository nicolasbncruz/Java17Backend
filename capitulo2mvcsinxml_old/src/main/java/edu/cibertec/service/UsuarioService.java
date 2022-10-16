package edu.cibertec.service;

import edu.cibertec.dto.UsuarioDTO;

/**
 *
 * @author jpere
 */
public interface UsuarioService {
    public UsuarioDTO  validarLogin(UsuarioDTO usuario);
}
