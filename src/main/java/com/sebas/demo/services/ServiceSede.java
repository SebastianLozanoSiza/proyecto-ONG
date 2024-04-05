package com.sebas.demo.services;

import java.util.List;

import com.sebas.demo.dto.SedeDTO;
import com.sebas.demo.repositories.entities.SedesEntity;

public interface ServiceSede {
    
    List<SedeDTO> findAll();

    SedeDTO findById(Long id);

    SedeDTO save(SedeDTO sedeDTO);
    
    SedeDTO update(Long id, SedeDTO sedeDTO);

    void delete(Long id);

    SedeDTO findByNombre(String nombreSede);
}
