package com.nadhem.users.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Sucursal {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long cod_sucursal;
  private String nombre;

  @OneToMany(mappedBy = "sucursal")
  @JsonIgnore
  private List<User> usuarios;

}
