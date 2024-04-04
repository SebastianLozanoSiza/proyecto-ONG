package com.sebas.demo.services.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sebas.demo.repositories.PersonaRepository;
import com.sebas.demo.repositories.entities.PersonaEntity;
import com.sebas.demo.services.ServicePersona;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ServicePersonaImpl implements ServicePersona{
    
    private PersonaRepository personaRepository;
    
    @Override
    @Transactional(readOnly = true)
    public List<PersonaEntity> findAll() {
        return (List<PersonaEntity>) personaRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public PersonaEntity findById(Long id) {
        return personaRepository.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public PersonaEntity save(PersonaEntity personaEntity) {
        return personaRepository.save(personaEntity);
    }
    
}
