package com.example.ejercicio.dto.detalleEnvio;

public record DetalleToSaveDto(
        String direccion,
        String trasnportadora,
        Integer numeroGuia,
        Long pedido) {
}
