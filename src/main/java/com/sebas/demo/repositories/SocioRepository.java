package com.sebas.demo.repositories;

import org.springframework.data.repository.CrudRepository;

import com.sebas.demo.repositories.entities.SocioEntity;

public interface SocioRepository extends CrudRepository<SocioEntity,Long>{
    
}
