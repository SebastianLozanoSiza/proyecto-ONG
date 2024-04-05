package com.sebas.demo.repositories.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "detalle_envio_humanitario")
public class DetalleEnvioHumanitarioEntity{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JoinColumn(name = "id_envio")
    @ManyToOne(fetch = FetchType.LAZY)
    private EnviosEntity enviosEntity;
    
    @Column(name = "cantidad_voluntarios")
    private int cantidadVoluntarios;

    @NotEmpty(message = "No puede estar vacio")
    @Column(nullable = false, name = "profesion_voluntarios")
    private String profesionVoluntario;
}
