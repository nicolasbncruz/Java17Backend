package edu.cibertec.service;

import edu.cibertec.entity.UsuarioEntity;
import java.util.List;
import org.springframework.data.domain.Pageable;

/**
 *
 * @author jpere
 */
public interface UsuarioService {
    public UsuarioEntity  validarLogin(UsuarioEntity usuario);
    public void grabarUsuario(UsuarioEntity usuario);//Si el objeto enviado tiene el identificador va a actualizar y si no lo tiene va a crear uno nuevo
    public void eliminarUsuario(UsuarioEntity usuario);
    public List<UsuarioEntity>listarUsuarios();
    public List<UsuarioEntity>listarUsuarios(Pageable pagina);
    public List<UsuarioEntity> listarUsuariosByUser(String usuario);
    public UsuarioEntity getUsuario(Integer idUsuario);
}
