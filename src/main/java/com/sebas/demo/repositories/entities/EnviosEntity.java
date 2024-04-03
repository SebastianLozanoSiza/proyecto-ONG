package com.sebas.demo.repositories.entities;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

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
@Table(name = "envios")
public class EnviosEntity{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @NotEmpty(message = "No puede estar vacio")
    @Column(nullable = false) 
    private String codigo;

    @NotEmpty(message = "No puede estar vacio")
    @Column(nullable = false) 
    private String destino;

    @Column(name="fecha_salida")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date fechaSalida;
}
