package edu.cibertec.service;

import edu.cibertec.entity.UsuarioEntity;
import java.util.List;

/**
 *
 * @author jpere
 */
public interface UsuarioService {
    public UsuarioEntity  validarLogin(UsuarioEntity usuario);
    public void insertarUsuario(UsuarioEntity usuario);
    public List<UsuarioEntity>listarUsuarios();
    public UsuarioEntity getUsuario(Integer idUsuario);
    public void subirFoto(UsuarioEntity usuario) ;
}
