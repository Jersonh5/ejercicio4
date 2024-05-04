package com.example.ejercicio.dto.producto;

import java.util.List;

public record ProductoToSaveDto(
        String nombre,
        Double price,
        Integer stock,
        List<Long> itemPedidos) {

}
