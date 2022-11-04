/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.cibertec.matricula.controller;

import edu.cibertec.matricula.entity.UsuarioEntity;
import edu.cibertec.matricula.service.UsuarioService;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author jpere
 */
@RestController
@Slf4j
public class UsuarioRestController {
    @Autowired
    private UsuarioService usuarioService;

    @RequestMapping(
            value = "ServiciolistarUsuarios",
            method = RequestMethod.GET           
    )
    public List<UsuarioEntity> listarUsuarios(String usuario) {
        log.info("INICIANDO EL SERVICIO LISTAR USUARIOS");
        log.error("INICIANDO EL SERVICIO LISTAR USUARIOS");
        log.warn("INICIANDO EL SERVICIO LISTAR USUARIOS");
        if (usuario == null) {
            usuario = new String("");
        }
        log.info("FINALIZANDO EL SERVICIO LISTAR USUARIOS");
        return usuarioService.listarUsuariosByUser(usuario);
    }

}
