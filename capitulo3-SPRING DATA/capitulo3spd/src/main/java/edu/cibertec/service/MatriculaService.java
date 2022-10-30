/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package edu.cibertec.service;

import edu.cibertec.entity.MatriculaEntity;
import java.util.List;

/**
 *
 * @author jpere
 */
public interface MatriculaService {
    public List<MatriculaEntity> listaTodas();
    public void grabarMatricula(MatriculaEntity matriculaEntity);
    
}
