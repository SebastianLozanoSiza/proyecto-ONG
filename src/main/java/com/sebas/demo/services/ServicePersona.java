package com.sebas.demo.services;

import java.util.List;

import com.sebas.demo.repositories.entities.PersonaEntity;

public interface ServicePersona {
    
    List<PersonaEntity> findAll();

    PersonaEntity findById(Long id);

    PersonaEntity save(PersonaEntity personaEntity);
    
}
