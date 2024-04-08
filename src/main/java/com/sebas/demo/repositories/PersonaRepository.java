package com.sebas.demo.repositories;

import org.springframework.data.repository.CrudRepository;

import com.sebas.demo.repositories.entities.PersonaEntity;

public interface PersonaRepository extends CrudRepository<PersonaEntity, Long> {
    
    PersonaEntity findByEmail(String email);
}
