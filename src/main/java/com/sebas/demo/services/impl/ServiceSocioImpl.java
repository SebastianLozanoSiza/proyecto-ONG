package com.sebas.demo.services.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sebas.demo.config.SocioDTOConverte;
import com.sebas.demo.dto.PersonaDTO;
import com.sebas.demo.dto.SocioDTO;
import com.sebas.demo.repositories.PersonaRepository;
import com.sebas.demo.repositories.SedeRepository;
import com.sebas.demo.repositories.SocioRepository;
import com.sebas.demo.repositories.entities.PersonaEntity;
import com.sebas.demo.repositories.entities.SedesEntity;
import com.sebas.demo.repositories.entities.SocioEntity;
import com.sebas.demo.services.ServiceSocio;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ServiceSocioImpl implements ServiceSocio {

    @Autowired
    private SocioRepository socioRepository;

    @Autowired
    private PersonaRepository personaRepository;

    @Autowired
    private SedeRepository sedeRepository;

    @Autowired
    private SocioDTOConverte convert;

    @Override
    @Transactional(readOnly = true)
    public List<Object> findAll() {
        List<SocioEntity> sociosEntity = (List<SocioEntity>) socioRepository.findAll();
        List<Object> sociosDTO = new ArrayList<>();

        for (SocioEntity socio : sociosEntity) {
            Object socioDTO = convertSocioDTO(socio);
            sociosDTO.add(socioDTO);
        }
        return sociosDTO;
    }

    private Object convertSocioDTO(SocioEntity socio) {
        Map<String, Object> socioDTO = new HashMap<>();
        socioDTO.put("id", socio.getId());

        PersonaEntity persona = socio.getPersonaEntity();
        Map<String, Object> personaDTO = new HashMap<>();
        personaDTO.put("nombre", persona.getNombre());
        personaDTO.put("apellido", persona.getApellido());
        personaDTO.put("direccion", persona.getDireccion());
        personaDTO.put("telefono", persona.getTelefono());
        personaDTO.put("email", persona.getEmail());

        socioDTO.put("personaId", personaDTO);
        socioDTO.put("ciudad", socio.getCiudad());
        socioDTO.put("cuentaBancaria", socio.getCuentaBancaria());
        socioDTO.put("fechaPago", socio.getFechaPago());
        socioDTO.put("sedeId", socio.getSedesEntity().getId());

        return socioDTO;
    }

    /*
     * @Override
     * 
     * @Transactional(readOnly = true)
     * public List<SocioDTO> findAll() {
     * List<SocioEntity> sociosEntity =(List<SocioEntity>)
     * socioRepository.findAll();
     * return sociosEntity.stream()
     * .map(socio -> convert.convertSocioDTO(socio))
     * .toList();
     * }
     */

    @Override
    public SocioDTO findById(Long id) {
        Optional<SocioEntity> socioEntityOptional = socioRepository.findById(id);
        if (socioEntityOptional.isPresent()) {
            SocioEntity socioEntity = socioEntityOptional.get();
            return convert.convertSocioDTO(socioEntity);
        }
        return null; // Puedes manejar este caso de acuerdo a tus necesidades
    }

    @Override
    @Transactional
    public SocioDTO save(SocioDTO socio, PersonaDTO persona) {

        // Crear la persona
        PersonaEntity personaEntity = new PersonaEntity();
        personaEntity.setNombre(persona.getNombre());
        personaEntity.setApellido(persona.getApellido());
        personaEntity.setDireccion(persona.getDireccion());
        personaEntity.setTelefono(persona.getTelefono());
        personaEntity.setEmail(persona.getEmail());
        personaRepository.save(personaEntity);

        // Crear el socio relacionado con la persona y la sede
        SocioEntity socioEntity = new SocioEntity();
        socioEntity.setPersonaEntity(personaEntity);
        socioEntity.setCiudad(socio.getCiudad());
        socioEntity.setCuentaBancaria(socio.getCuentaBancaria());
        socioEntity.setFechaPago(socio.getFechaPago());

        // Obtener la sede por su ID
        Optional<SedesEntity> sedeOptional = sedeRepository.findById(socio.getSedeId());
        sedeOptional.ifPresent(sedeEntity -> socioEntity.setSedesEntity(sedeEntity));

        socioRepository.save(socioEntity);

        return convert.convertSocioDTO(socioEntity);
    }

    @Override
    public SocioDTO update(Long id, SocioDTO socio) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    @Override
    public void deleteById(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deleteById'");
    }

}
