package com.sebas.demo.repositories.entities;


import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "envio_sede")
public class EnvioSedeEntity{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JoinColumn(name = "envio_id")
    @ManyToOne(fetch = FetchType.LAZY)
    private EnviosEntity enviosEntity;

    @JoinColumn(name = "sede_id")
    @ManyToOne(fetch = FetchType.LAZY)
    private SedesEntity sedesEntity;

    @JoinColumn(name = "refugio_id")
    @ManyToOne(fetch = FetchType.LAZY)
    private RefugioEntity refugioEntity;

}
