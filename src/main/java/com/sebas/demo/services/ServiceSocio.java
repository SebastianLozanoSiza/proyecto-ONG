package com.sebas.demo.services;

import java.util.List;

import com.sebas.demo.dto.PersonaDTO;
import com.sebas.demo.dto.SocioDTO;

public interface ServiceSocio {

    List<Object> findAll();

    SocioDTO findById(Long id);

    SocioDTO save(SocioDTO socio, PersonaDTO persona);

    SocioDTO update(Long id, SocioDTO socio);

    void deleteById(Long id);
}
