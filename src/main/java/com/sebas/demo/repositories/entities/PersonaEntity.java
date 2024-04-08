package com.sebas.demo.repositories.entities;


import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "persona")
public class PersonaEntity implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @NotEmpty(message = "No puede estar vacio")
    @Column(nullable = false) 
    private String nombre;

    @NotEmpty(message = "No puede estar vacio")
    @Column(nullable = false) 
    private String apellido;

    @NotEmpty(message = "No puede estar vacio")
    @Column(nullable = false) 
    private String direccion;

    @NotEmpty(message = "No puede estar vacio")
    @Column(nullable = false) 
    private String telefono;

    @Email(message="No cumple con el formato de una cuenta de correo")
    @Column(nullable = false, unique = true)
    private String email;
}
