package edu.cibertec.service;

import edu.cibertec.dto.UsuarioDTO;
import java.util.List;

/**
 *
 * @author jpere
 */
public interface UsuarioService {
    public UsuarioDTO  validarLogin(UsuarioDTO usuario);
    public void insertarUsuario(UsuarioDTO usuario);
    public List<UsuarioDTO>listarUsuarios();
    public UsuarioDTO getUsuario(Integer idUsuario);
    public void subirFoto(UsuarioDTO usuario) ;
    public void usuarioModificar(Integer idUsuario);
    public void eliminarUsuario(Integer idUsuario);
}
