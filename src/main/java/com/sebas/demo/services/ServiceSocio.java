package com.sebas.demo.services;

import java.util.List;

import com.sebas.demo.repositories.entities.PersonaEntity;
import com.sebas.demo.repositories.entities.SocioEntity;

public interface ServiceSocio {

    List<SocioEntity> findAll();

    SocioEntity findById(Long id);

    SocioEntity save(PersonaEntity persona, SocioEntity socioEntity);


    
}
