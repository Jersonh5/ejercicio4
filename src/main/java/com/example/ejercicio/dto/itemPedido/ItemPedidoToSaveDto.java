package com.example.ejercicio.dto.itemPedido;

public record ItemPedidoToSaveDto(
        Integer cantidad,
        Double precioUnitario,
        Long pedido,
        Long producto) {
}
