package com.example.ejercicio.dto.detalleEnvio;

public record DetalleEnvioDto(
        Long id,
        String direccion,
        String trasnportadora,
        Integer numeroGuia,
        Long pedido) {

}
