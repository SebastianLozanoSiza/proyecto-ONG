package com.sebas.demo.services.impl;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.sebas.demo.dto.PersonaDTO;
import com.sebas.demo.repositories.PersonaRepository;
import com.sebas.demo.repositories.entities.PersonaEntity;
import com.sebas.demo.services.ServicePersona;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ServicePersonaImpl implements ServicePersona{

    private PersonaRepository personaRepository;

    @Override
    public PersonaDTO obtenerPersonaPorId(Long id) {
        Optional<PersonaEntity> personaEntityOptional = personaRepository.findById(id);
        if (personaEntityOptional.isPresent()) {
            PersonaEntity personaEntity = personaEntityOptional.get();
            PersonaDTO personaDTO = new PersonaDTO();
            personaDTO.setId(personaEntity.getId());
            personaDTO.setNombre(personaEntity.getNombre());
            personaDTO.setApellido(personaEntity.getApellido());
            personaDTO.setDireccion(personaEntity.getDireccion());
            personaDTO.setTelefono(personaEntity.getTelefono());
            personaDTO.setEmail(personaEntity.getEmail());
            return personaDTO;
        }
        return null; // O manejar este caso de acuerdo a tus necesidades
    }
    
}
