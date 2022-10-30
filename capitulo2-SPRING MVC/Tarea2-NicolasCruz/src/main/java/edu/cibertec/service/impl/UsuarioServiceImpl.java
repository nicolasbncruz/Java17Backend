package edu.cibertec.service.impl;

import edu.cibertec.entity.UsuarioEntity;
import edu.cibertec.repository.UsuarioRepository;
import edu.cibertec.service.UsuarioService;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author jpere
 */
@Service
public class UsuarioServiceImpl implements UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository ;

    @Override
    public UsuarioEntity validarLogin(UsuarioEntity usuario) {
//        UsuarioEntity respuesta= null;
//        List<UsuarioEntity> listaUsuarios = listarUsuarios();
//        List<UsuarioEntity> listaUsuariosBusqueda = listaUsuarios.stream().filter(usu -> usu.getUsuario().equals(usuario.getUsuario())&&usu.getClave().equals(usuario.getClave()) ).collect(Collectors.toList());
//        if (listaUsuariosBusqueda.size() > 0) {
//           respuesta = listaUsuariosBusqueda.get(0);
//        } 
        return usuarioRepository.findByUsuarioAndClave(usuario.getUsuario(), usuario.getClave());
    }

    @Transactional
    @Override
    public void grabarUsuario(UsuarioEntity usuario) {
        usuarioRepository.save(usuario);
    }
    
    @Transactional
    @Override
    public void eliminarUsuario(UsuarioEntity usuario) {
        usuarioRepository.delete(usuario);
    }

    @Override
    public List<UsuarioEntity> listarUsuarios() {
        return usuarioRepository.findAll();
    }
    
    @Override
    public List<UsuarioEntity> listarUsuarios(Pageable pagina) {
        return usuarioRepository.findAll(pagina).getContent();
    }
    
    @Override
    public List<UsuarioEntity> listarUsuariosByUser(String usuario) {
        return usuarioRepository.findByUsuarioLike(usuario);
    }
    

    @Override
    public UsuarioEntity getUsuario(Integer idUsuario) {
        UsuarioEntity usuario = usuarioRepository.findById(idUsuario).get();
        return usuario;
    }
    
}
