package com.example.ejercicio.dto.producto;

import java.util.List;

public record ProductoDto(
        Long id,
        String nombre,
        Double price,
        Integer stock,
        List<Long> itemPedidos) {
}
