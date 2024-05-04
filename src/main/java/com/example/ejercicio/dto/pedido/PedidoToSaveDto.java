package com.example.ejercicio.dto.pedido;

import com.example.ejercicio.entidades.Pedido;

import java.time.LocalDateTime;
import java.util.List;

public record PedidoToSaveDto(
        LocalDateTime fechaPedido,
        Pedido.EstadoPedido status,
        Long cliente,
        List<Long> itemPedidos) {

}
