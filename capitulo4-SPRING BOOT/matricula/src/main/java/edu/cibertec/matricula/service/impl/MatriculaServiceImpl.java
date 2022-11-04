/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.cibertec.matricula.service.impl;

import edu.cibertec.matricula.entity.AuditoriaEntity;
import edu.cibertec.matricula.entity.MatriculaEntity;
import edu.cibertec.matricula.repository.AuditoriaRepository;
import edu.cibertec.matricula.repository.MatriculaRepository;
import edu.cibertec.matricula.service.MatriculaService;
import java.sql.Date;
import java.util.Calendar;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author jpere
 */
@Service
public class MatriculaServiceImpl implements MatriculaService {

    @Autowired
    private MatriculaRepository matriculaRepository;
    @Autowired
    private AuditoriaRepository auditoriaRepository;

    @Override
    public List<MatriculaEntity> listaTodas() {
       return matriculaRepository.findAll();
    }

    @Override
    @Transactional (propagation = Propagation.REQUIRED)
    public void grabarMatricula(MatriculaEntity matriculaEntity) {
        matriculaRepository.save(matriculaEntity);
        AuditoriaEntity auditoriaEntity = new AuditoriaEntity() ;
        auditoriaEntity.setFechaHora(new Date(Calendar.getInstance().getTimeInMillis()));
        auditoriaEntity.setUsuario(matriculaEntity.getUsuario());
        auditoriaEntity.setOperacion("Insertando Matricula: "+matriculaEntity.getIdMatricula());
        auditoriaRepository.save(auditoriaEntity);
    }
}
