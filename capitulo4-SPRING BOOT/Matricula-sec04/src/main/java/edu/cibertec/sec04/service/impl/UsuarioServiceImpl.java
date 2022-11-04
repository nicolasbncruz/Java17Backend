package edu.cibertec.sec04.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.cibertec.sec04.entity.UsuarioEntity;
import edu.cibertec.sec04.repository.UsuarioRepository;
import edu.cibertec.sec04.service.UsuarioService;

/**
*
* @author Carlos Jesus Herrera Huaman
*/
@Service
public class UsuarioServiceImpl implements UsuarioService {

   @Autowired
   private UsuarioRepository usuarioRepository ;

   @Override
   public UsuarioEntity validarLogin(UsuarioEntity usuario) {
//       UsuarioEntity respuesta= null;
//       List<UsuarioEntity> listaUsuarios = listarUsuarios();
//       List<UsuarioEntity> listaUsuariosBusqueda = listaUsuarios.stream().filter(usu -> usu.getUsuario().equals(usuario.getUsuario())&&usu.getClave().equals(usuario.getClave()) ).collect(Collectors.toList());
//       if (listaUsuariosBusqueda.size() > 0) {
//          respuesta = listaUsuariosBusqueda.get(0);
//       } 
       return usuarioRepository.findByUsuarioAndClave(usuario.getUsuario(), usuario.getClave());
   }

   @Transactional
   @Override
   public void grabarUsuario(UsuarioEntity usuario) {
       if(usuario.getIdUsuario()==null){
            usuarioRepository.insertarUsuario(usuario);
       }else{
           usuarioRepository.save(usuario);
       	//usuarioRepository.actualizarData(usuario);
       }
   }
   
   @Transactional
   @Override
   public void eliminarUsuario(UsuarioEntity usuario) {
       usuarioRepository.deleteById(usuario.getIdUsuario());
   	//usuarioRepository.delete(usuario);
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

