package com.sebas.demo.services;

import java.util.List;

import com.sebas.demo.repositories.entities.SedesEntity;

public interface ServiceSede {
    
    List<SedesEntity> findAll();

    SedesEntity findById(Long id);

    SedesEntity save(SedesEntity sedesEntity);
    
    String update(SedesEntity sedesEntity);

    void delete(Long id);
}
