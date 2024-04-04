package com.sebas.demo.services.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sebas.demo.repositories.PersonaRepository;
import com.sebas.demo.repositories.SocioRepository;
import com.sebas.demo.repositories.entities.PersonaEntity;
import com.sebas.demo.repositories.entities.SocioEntity;
import com.sebas.demo.services.ServiceSocio;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ServiceSocioImpl implements ServiceSocio{
    
    private SocioRepository socioRepository;
    private PersonaRepository personaRepository;
    
    @Override
    @Transactional(readOnly = true)
    public List<SocioEntity> findAll() {
        return (List<SocioEntity>) socioRepository.findAll();

    }

    @Override
    @Transactional(readOnly = true)
    public SocioEntity findById(Long id) {
        return socioRepository.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public SocioEntity save(PersonaEntity persona, SocioEntity socioEntity) {
        
        if (persona != null){
            personaRepository.save(persona);
        }
        socioEntity.setPersonaEntity(persona);
        return socioRepository.save(socioEntity);
    }
    
}
