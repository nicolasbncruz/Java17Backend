/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.cibertec.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import lombok.Data;
import org.hibernate.validator.constraints.NotBlank;

/**
 *
 * @author jpere
 */
@Data
public class UsuarioDTO {
    
    private Integer idUsuario;
    
    @Size(min=3, max= 20)
    private String usuario;
    @NotNull
    @NotBlank
    private String clave;
     @Size(min=10, max= 50)
    private String nombreApellido; 
     private byte [] foto;
}
