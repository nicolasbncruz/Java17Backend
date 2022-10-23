/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.cibertec.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.validation.constraints.NotBlank;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

/**
 *
 * @author jpere
 */
@Data
@Entity
@Table(name = "usuario")
public class UsuarioEntity {

    @Id
    //PARA MYSQL
    @GeneratedValue(strategy=GenerationType.IDENTITY)
//    //PARA VARIAS BD
//    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
//    @GenericGenerator(name = "native", strategy = "native")
    private Integer idUsuario;
    @Size(min = 3, max = 20)
    @NotNull
    @NotBlank
    @Column(nullable = false)
    private String usuario;
    @NotNull
    @NotBlank
    @Column(nullable = false)
    private String clave;
    @NotNull
    @NotBlank
    @Column(nullable = false)
    private String nombreApellido;
    @Column(nullable = true)
    private byte[] foto;
    @Transient
    private String fotoBase64;
}
