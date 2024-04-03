package com.sebas.demo.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sebas.demo.repositories.SedeRepository;
import com.sebas.demo.repositories.entities.SedesEntity;
import com.sebas.demo.services.ServiceSede;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ServiceSedesImpl implements ServiceSede{

    private SedeRepository sedeRepository;

    @Override
    @Transactional(readOnly = true)
    public List<SedesEntity> findAll() {
        return (List<SedesEntity>) sedeRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public SedesEntity findById(Long id) {
        return sedeRepository.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public SedesEntity save(SedesEntity sedesEntity) {
        return sedeRepository.save(sedesEntity);
    }

    @Override
    @Transactional
    public SedesEntity update(Long id, SedesEntity sedesEntity) {
        Optional<SedesEntity> sedeCurrentOptional = sedeRepository.findById(id);

        if (sedeCurrentOptional.isPresent()) {
            SedesEntity sedeCurrent = sedeCurrentOptional.get();
            sedeCurrent.setNombreSede(sedesEntity.getNombreSede());
            sedeCurrent.setDireccion(sedesEntity.getDireccion());
            sedeCurrent.setCiudad(sedesEntity.getCiudad());
            sedeCurrent.setNombreDirector(sedesEntity.getNombreDirector());
            sedeRepository.save(sedeCurrent);
            return sedeCurrent;
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
    public SedesEntity findByNombre(String nombreSede) {
        return sedeRepository.findByNombreSede(nombreSede);
    }

    
    
}
