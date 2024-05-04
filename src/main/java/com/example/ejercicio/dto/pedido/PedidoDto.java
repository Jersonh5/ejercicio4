package com.example.ejercicio.dto.pedido;

import java.time.LocalDateTime;
import java.util.List;

import com.example.ejercicio.entidades.Pedido.EstadoPedido;
public record PedidoDto(
        Long id,
        LocalDateTime fechaPedido,
        EstadoPedido status,
        Long cliente,
        List<Long> itemPedidos) {
}
