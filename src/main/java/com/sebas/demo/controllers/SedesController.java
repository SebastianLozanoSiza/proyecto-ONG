package com.sebas.demo.controllers;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sebas.demo.dto.SedeDTO;
import com.sebas.demo.services.ServiceSede;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/sedes")
public class SedesController {

    @Autowired
    private ServiceSede serviceSede;

    @GetMapping("/")
    public List<SedeDTO> findAll() {
        return serviceSede.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id) {
        SedeDTO sede = serviceSede.findById(id);
        return ResponseEntity.ok(sede != null ? sede : "No existe ninguna sede con ese id");
    }

    @GetMapping("/byNombre/{nombreSede}")
    public ResponseEntity<?> findByNombre(@PathVariable String nombreSede) {
        SedeDTO sede = serviceSede.findByNombre(nombreSede);
        return ResponseEntity.ok(sede != null ? sede : "No existe ninguna sede con ese nombre");
    }

    @PostMapping("/")
    public ResponseEntity<?> save(@Valid @RequestBody SedeDTO sedeDTO, BindingResult result) {
        if (result.hasErrors()) {
            List<String> errors = result.getFieldErrors()
                    .stream()
                    .map(err -> "El campo " + err.getField() + " " + err.getDefaultMessage())
                    .collect(Collectors.toList());
            return ResponseEntity.badRequest().body(errors);
        }

        SedeDTO savedSede = serviceSede.save(sedeDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedSede);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@Valid @RequestBody SedeDTO sedeDTO, BindingResult result, @PathVariable Long id) {
        if (result.hasErrors()) {
            List<String> errors = result.getFieldErrors()
                    .stream()
                    .map(err -> "El campo " + err.getField() + " " + err.getDefaultMessage())
                    .collect(Collectors.toList());
            return ResponseEntity.badRequest().body(errors);
        }

        SedeDTO updatedSede = serviceSede.update(id, sedeDTO);
        return ResponseEntity.ok(updatedSede);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        serviceSede.delete(id);
        return ResponseEntity.ok("La sede ha sido eliminada con éxito");
    }
}
