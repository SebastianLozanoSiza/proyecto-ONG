package com.sebas.demo.controllers;

import org.springframework.web.bind.annotation.RestController;

import com.sebas.demo.repositories.entities.SedesEntity;
import com.sebas.demo.services.ServiceSede;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
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
    public ResponseEntity<Map<String, Object>> findAllById(@PathVariable Long id) {

        Map<String, Object> response = new HashMap<>();

        SedesEntity sedes = serviceSede.findById(id);

        if (sedes != null) {
            response.put("sedes", sedes);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } else {
            response.put("mensaje", new String("No existe ninguna sede con ese id:"));
            return new ResponseEntity<>(response, HttpStatus.NO_CONTENT);
        }

    }

    @GetMapping("/byNombre/{nombreSede}")
    public ResponseEntity<Map<String, Object>> findAllById(@PathVariable String nombreSede) {

        Map<String, Object> response = new HashMap<>();

        SedesEntity sedes = serviceSede.findByNombre(nombreSede);

        if (sedes != null) {
            response.put("sedes", sedes);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } else {
            response.put("mensaje", new String("No existe ninguna sede con ese Nombre"));
            return new ResponseEntity<>(response, HttpStatus.NO_CONTENT);
        }

    }

    @PostMapping("/")
    public ResponseEntity<Map<String, Object>> save(@Valid @RequestBody SedesEntity sedes, BindingResult result) {

        SedesEntity sedeNew = null;

        Map<String, Object> response = new HashMap<>();

        if (result.hasErrors()) {
            List<String> errors = result.getFieldErrors()
                    .stream()
                    .map(err -> "El campo " + err.getField() + " " + err.getDefaultMessage())
                    .collect(Collectors.toList());
            response.put("errors", errors);
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }
        try {

            sedeNew = serviceSede.save(sedes);

        } catch (DataAccessException e) {
            response.put("mensaje", "Error al realizar el insert en la base de datos");
            response.put("error", e.getMessage().concat(":").concat(e.getMostSpecificCause().getMessage()));
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);

        }

        response.put("mensaje", "La sede ha sido creada con éxito");
        response.put("sedes", sedeNew);

        return new ResponseEntity<>(response, HttpStatus.OK);

    }

    @PutMapping("/{id}")
    public ResponseEntity<Map<String, Object>> update(@Valid @RequestBody SedesEntity sedes, BindingResult result,
            @PathVariable Long id) {

        SedesEntity sedeUpdate = null;

        Map<String, Object> response = new HashMap<>();

        if (result.hasErrors()) {
            List<String> errors = result.getFieldErrors()
                    .stream()
                    .map(err -> "El campo " + err.getField() + " " + err.getDefaultMessage())
                    .collect(Collectors.toList());
            response.put("errors", errors);
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }
        try {

            sedeUpdate = serviceSede.update(id, sedes);

        } catch (DataAccessException e) {
            response.put("mensaje", "Error al realizar el upate en la base de datos");
            response.put("error", e.getMessage().concat(":").concat(e.getMostSpecificCause().getMessage()));
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);

        }

        response.put("mensaje", "La sede ha sido actualizada con éxito");
        response.put("sedes", sedeUpdate);

        return new ResponseEntity<>(response, HttpStatus.OK);

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String, Object>> delete(@PathVariable Long id) {

        Map<String, Object> response = new HashMap<>();
        try {
            serviceSede.delete(id);
        } catch (DataAccessException e) {
            response.put("mensaje", "Error al realizar el insert en la base de datos");
            response.put("error", e.getMessage().concat(":").concat(e.getMostSpecificCause().getMessage()));
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        response.put("mensaje", "La sede ha sido eliminada con éxito");
        return new ResponseEntity<>(response, HttpStatus.OK);
    }


}
