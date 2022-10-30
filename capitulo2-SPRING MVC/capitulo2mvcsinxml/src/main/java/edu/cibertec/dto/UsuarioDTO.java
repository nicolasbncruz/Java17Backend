/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.cibertec.dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import lombok.Data;

/**
 *
 * @author jpere
 */
@Data
public class UsuarioDTO {
    private Integer idUsuario;
    @Size(min = 3, max = 15)
    private String usuario;
    @NotNull
    @NotEmpty    
    @Size(min = 1, max = 15)    
    private String clave;
    private String nombreApellido;
    private byte[] foto;
    
}
