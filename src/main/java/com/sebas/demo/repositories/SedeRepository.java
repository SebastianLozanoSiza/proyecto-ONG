package com.sebas.demo.repositories;


import org.springframework.data.repository.CrudRepository;

import com.sebas.demo.repositories.entities.SedesEntity;

public interface SedeRepository extends CrudRepository<SedesEntity, Long>{
    
    SedesEntity findByNombreSede(String nombreSede);
}

