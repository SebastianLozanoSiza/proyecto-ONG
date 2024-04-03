package com.sebas.demo.controllers;

import org.springframework.web.bind.annotation.RestController;

import com.sebas.demo.repositories.entities.SedesEntity;
import com.sebas.demo.services.ServiceSede;

import lombok.AllArgsConstructor;

import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;

@RestController
@RequestMapping("/sedes")
@AllArgsConstructor
public class SedesController {

    private ServiceSede serviceSede;

    @GetMapping("/")
    public List<SedesEntity> findAll() {
        return serviceSede.findAll();
    }

    @GetMapping("/{id}")
    public SedesEntity findAllByString(@PathVariable Long id) {
        return serviceSede.findById(id);
    }

    @PostMapping("/")
    public SedesEntity save(@RequestBody SedesEntity sedesEntity) {
        return serviceSede.save(sedesEntity);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        serviceSede.delete(id);
    }   

    @PutMapping("/")
    public String update(@RequestBody SedesEntity sedesEntity) {
        return serviceSede.update(sedesEntity);
    }

}
