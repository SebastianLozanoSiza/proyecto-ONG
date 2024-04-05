package com.sebas.demo.services.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sebas.demo.config.SedesDTOConverte;
import com.sebas.demo.dto.SedeDTO;
import com.sebas.demo.repositories.SedeRepository;
import com.sebas.demo.repositories.entities.SedesEntity;
import com.sebas.demo.services.ServiceSede;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ServiceSedesImpl implements ServiceSede{

    @Autowired
    private SedeRepository sedeRepository;

    @Autowired
    private SedesDTOConverte convert;

    @Override
    @Transactional(readOnly = true)
    public List<SedeDTO> findAll() {
        List<SedesEntity> sedesEntity = (List<SedesEntity>) sedeRepository.findAll();
        List<SedeDTO> sedeDTO = new ArrayList<>();
        
        for (SedesEntity sede : sedesEntity) {
            sedeDTO.add(convert.convertSedesDTO(sede));
        }
        return sedeDTO;
    }


    @Override
    @Transactional(readOnly = true)
    public SedeDTO findById(Long id) {
        Optional<SedesEntity> sedeOptional = sedeRepository.findById(id);
        return sedeOptional.map(convert::convertSedesDTO).orElse(null);
    }

    @Override
    @Transactional
    public SedeDTO save(SedeDTO sedeDTO) {
        SedesEntity sedesEntity = convert.convertSedesEntity(sedeDTO);
        SedesEntity savedSedeEntity = sedeRepository.save(sedesEntity);
        return convert.convertSedesDTO(savedSedeEntity);
    }

    @Override
    @Transactional
    public SedeDTO update(Long id, SedeDTO sedeDTO) {
        Optional<SedesEntity> sedeOptional = sedeRepository.findById(id);
    
        if (sedeOptional.isPresent()) {
            SedesEntity sedeCurrent = sedeOptional.get();
            sedeCurrent.setNombreSede(sedeDTO.getNombreSede());
            sedeCurrent.setDireccion(sedeDTO.getDireccion());
            sedeCurrent.setCiudad(sedeDTO.getCiudad());
            sedeCurrent.setNombreDirector(sedeDTO.getNombreDirector());
            sedeRepository.save(sedeCurrent);
            return sedeDTO;
        }
        return null;
    }
    

    @Override
    @Transactional
    public void delete(Long id) {
        Optional<SedesEntity> sedeOptinal=sedeRepository.findById(id);
        if(sedeOptinal.isPresent()){
            sedeRepository.delete(sedeOptinal.get());
        } 
    }

    @Override
    @Transactional(readOnly = true)
    public SedeDTO findByNombre(String nombreSede) {
        SedesEntity sedeEntity = sedeRepository.findByNombreSede(nombreSede);
        return convert.convertSedesDTO(sedeEntity);
    }
    

}
