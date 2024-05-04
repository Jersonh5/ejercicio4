package com.example.ejercicio.dto.itemPedido;

public record ItemPedidoDto(
        Long id,
        Integer cantidad,
        Double precioUnitario,
        Long pedido,
        Long producto) {

}
