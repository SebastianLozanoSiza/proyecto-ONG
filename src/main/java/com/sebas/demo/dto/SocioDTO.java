package com.sebas.demo.dto;

import java.util.Date;

import lombok.Data;

@Data
public class SocioDTO {
    
    private Long id;
    private Long personaId;
    private String ciudad;
    private String cuentaBancaria;
    private Date fechaPago;
    private Long sedeId;
    
}
