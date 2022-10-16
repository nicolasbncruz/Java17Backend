package edu.cibertec.capitulo2.model;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import lombok.Data;
import org.hibernate.validator.constraints.NotBlank;

@Data
public class UsuarioDTO {

    @Size(min=3, max = 20)
    private String usuario;
    
    @NotNull
    @NotBlank
    private String clave;
    private String nombreCompleto;

   
}
