package edu.cibertec.repository;

import edu.cibertec.dto.UsuarioDTO;

/**
 *
 * @author jpere
 */

public interface UsuarioDao {
    public UsuarioDTO validarLogin (UsuarioDTO usuario);
}
