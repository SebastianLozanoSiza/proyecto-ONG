package com.sebas.demo.services;

import java.util.List;

import com.sebas.demo.repositories.entities.SedesEntity;

public interface ServiceSede {
    
    List<SedesEntity> findAll();

    SedesEntity findById(Long id);

    SedesEntity save(SedesEntity sedesEntity);
    
    SedesEntity update(Long id, SedesEntity sedesEntity);

    void delete(Long id);

    SedesEntity findByNombre(String nombreSede);
}
