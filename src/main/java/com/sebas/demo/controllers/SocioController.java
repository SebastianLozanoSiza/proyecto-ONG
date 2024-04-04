package com.sebas.demo.controllers;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sebas.demo.repositories.entities.PersonaEntity;
import com.sebas.demo.repositories.entities.SedesEntity;
import com.sebas.demo.repositories.entities.SocioEntity;
import com.sebas.demo.services.ServiceSocio;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/socio")
@AllArgsConstructor
public class SocioController {

    private ServiceSocio serviceSocio;

    @GetMapping("/")
    public List<SocioEntity> findAll() {
        return serviceSocio.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Map<String, Object>> findAllById(@PathVariable Long id) {

        Map<String, Object> response = new HashMap<>();

        SocioEntity socio = serviceSocio.findById(id);

        if (socio != null) {
            response.put("socio", socio);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } else {
            response.put("mensaje", new String("No existe ningun socio con ese id:"));
            return new ResponseEntity<>(response, HttpStatus.NO_CONTENT);
        }

    }

    @PostMapping("/")
    public ResponseEntity<Map<String, Object>> save(@Valid @RequestBody Iterable<Object> data, BindingResult result) {

        SocioEntity socioNew = null;

        List<Object> datos = new ArrayList<>();

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
            if (4 > 2) {
                for (Object d : data){
                    datos.add(d);
                }


                @SuppressWarnings("unchecked")
                Map<String, Object> personaData = (Map<String, Object>) datos.get(0);
                String nombre = (String) personaData.get("nombre");
                String apellido = (String) personaData.get("apellido");
                String email = (String) personaData.get("email");
                String telefono = (String) personaData.get("telefono");
                String direccion = (String) personaData.get("direccion");

                PersonaEntity persona = new PersonaEntity();
                persona.setNombre(nombre);
                persona.setApellido(apellido);
                persona.setEmail(email);
                persona.setTelefono(telefono);
                persona.setDireccion(direccion);

                @SuppressWarnings("unchecked")
                Map<String, Object> socioData = (Map<String, Object>) datos.get(1);
                String ciudad = (String) socioData.get("ciudad");
                String cuentaBancaria = (String) socioData.get("cuentaBancaria");
                String fechaPagoString = (String) socioData.get("fecha_pago");
                SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
                Date fechaPago = formatter.parse(fechaPagoString);
                SedesEntity sedesEntity = new SedesEntity();
                sedesEntity.setId((Long) socioData.get("sedesEntity.id"));

                SocioEntity socio = new SocioEntity();
                socio.setCiudad(ciudad);
                socio.setCuentaBancaria(cuentaBancaria);
                socio.setFecha_pago(fechaPago);
                socio.setSedesEntity(sedesEntity);

                socioNew = serviceSocio.save(persona, socio); 
            }
        } catch (DataAccessException e) {
            response.put("mensaje", "Error al realizar el insert en la base de datos");
            response.put("error", e.getMessage().concat(":").concat(e.getMostSpecificCause().getMessage()));
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);

        } catch (ParseException e){
            response.put("mensaje", "Error al parsear en la base de datos");
            response.put("error", e.getMessage().concat(":").concat(e.getMessage()));
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        response.put("mensaje", "El socio ha sido creado con éxito");
        response.put("socio", socioNew);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

}
