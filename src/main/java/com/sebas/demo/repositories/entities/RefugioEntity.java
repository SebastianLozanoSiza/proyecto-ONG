package com.sebas.demo.repositories.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "refugio")
public class RefugioEntity{

    private Long id;

    private String nombreRefugio;

    private String nombreCiudad;
    
}
