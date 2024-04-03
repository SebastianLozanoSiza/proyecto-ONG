package com.sebas.demo.repositories.entities;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "sedes")
public class SedesEntity{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty(message = "No puede estar vacio")
    @Column(nullable = false, name = "nombre_sede")
    private String nombreSede;

    @NotEmpty(message = "No puede estar vacio")
    @Column(nullable = false)
    private String direccion;

    @NotEmpty(message = "No puede estar vacio")
    @Column(nullable = false)
    private String ciudad;

    @NotEmpty(message = "No puede estar vacio")
    @Column(nullable = false, name = "nombre_director")
    private String nombreDirector;
}
