package com.example.ejercicio.dto.cliente;

import java.util.List;

public record ClienteToSaveDto(
        String nombre,
        String email,
        String direccion,
        List<Long> pedidos) {
}
