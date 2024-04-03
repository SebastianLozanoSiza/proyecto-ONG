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
@Table(name = "voluntarios")
public class VoluntarioEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JoinColumn(name = "persona_id")
    @ManyToOne(fetch = FetchType.LAZY)
    private PersonaEntity personaEntity;

    @NotEmpty(message = "No puede estar vacio")
    @Column(nullable = false)
    private String profesion;

    private Boolean disponibilidad;

    @Column(nullable = false, name = "num_trabajos")
    private int numTrabajos;

    @JoinColumn(name = "sede_id")
    @ManyToOne(fetch = FetchType.LAZY)
    private SedesEntity sedesEntity;

    
}
