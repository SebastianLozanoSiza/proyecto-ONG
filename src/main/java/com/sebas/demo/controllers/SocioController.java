package com.sebas.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sebas.demo.dto.PersonaDTO;
import com.sebas.demo.dto.SocioDTO;
import com.sebas.demo.services.ServiceSocio;

@RestController
@RequestMapping("/socios")
public class SocioController {

    @Autowired
    private ServiceSocio serviceSocio;

    @GetMapping("/")
    public ResponseEntity<List<Object>> getAllSocios() {
        List<Object> socios = serviceSocio.findAll();
        return ResponseEntity.ok(socios);
    }

    @PostMapping("/")
    public ResponseEntity<SocioDTO> save(@RequestBody SocioDTO socioDTO, @RequestBody PersonaDTO personaDTO) {
        SocioDTO createdSocio = serviceSocio.save(socioDTO, personaDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdSocio);
    }
}
