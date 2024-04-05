package com.sebas.demo.config;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sebas.demo.dto.SedeDTO;
import com.sebas.demo.repositories.entities.SedesEntity;

@Component
public class SedesDTOConverte {
    
    @Autowired
    private ModelMapper dbm;

    public SedeDTO convertSedesDTO(SedesEntity sedes){
        SedeDTO sedesDTO = dbm.map(sedes, SedeDTO.class);
        return sedesDTO;
    }

    public SedesEntity convertSedesEntity(SedeDTO sedesDTO){
        return dbm.map(sedesDTO, SedesEntity.class);
    }

}
