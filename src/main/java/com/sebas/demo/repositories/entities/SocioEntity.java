package com.sebas.demo.repositories.entities;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

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
@Table(name = "socio")
public class SocioEntity{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JoinColumn(name = "persona_id")
    @ManyToOne(fetch = FetchType.LAZY)
    private PersonaEntity personaEntity;

    @NotEmpty(message = "No puede estar vacio")
    @Column(nullable = false)
    private String ciudad;

    @NotEmpty(message = "No puede estar vacio")
    @Column(nullable = false, name = "cuenta_bancaria")
    private String cuentaBancaria;

    @Column(name="fecha_pago")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date fecha_pago;

    @JoinColumn(name = "sede_id")
    @ManyToOne(fetch = FetchType.LAZY)
    private SedesEntity sedesEntity;
}
