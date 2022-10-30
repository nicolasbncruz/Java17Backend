/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package edu.cibertec.repository;

import edu.cibertec.entity.MatriculaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author jpere
 */
public interface MatriculaRepository extends JpaRepository<MatriculaEntity, Integer>{
    
}
