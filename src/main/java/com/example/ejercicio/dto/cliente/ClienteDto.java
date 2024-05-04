package com.example.ejercicio.dto.cliente;

import java.util.List;

public record ClienteDto(
        Long id,
        String nombre,
        String email,
        String direccion,
        List<Long> pedidos) {
}