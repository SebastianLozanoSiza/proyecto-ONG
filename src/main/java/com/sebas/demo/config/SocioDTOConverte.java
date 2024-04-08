package com.sebas.demo.config;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sebas.demo.dto.SocioDTO;
import com.sebas.demo.repositories.entities.SocioEntity;

@Component
public class SocioDTOConverte {

    @Autowired
    private ModelMapper dbm;
    
    public SocioDTO convertSocioDTO(SocioEntity socio){
        SocioDTO socioDTO = dbm.map(socio, SocioDTO.class);
        if (socio.getPersonaEntity()!=null) {
            socioDTO.setPersonaId(socio.getPersonaEntity().getId());
        }
        return socioDTO;
    }

    public SocioEntity convertSocioEntity(SocioDTO socioDTO){
        return dbm.map(socioDTO, SocioEntity.class);
    }
}
