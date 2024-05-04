package com.example.ejercicio.servicios;

import com.example.ejercicio.dto.pedido.PedidoDto;
import com.example.ejercicio.dto.pedido.PedidoToSaveDto;
import com.example.ejercicio.entidades.Pedido;

import java.time.LocalDateTime;
import java.util.List;

public interface PedidoService {
    PedidoDto guardarPedido(PedidoToSaveDto pedidoToSaveDto);

    PedidoDto obtenerPedido(Long pedidoId);

    List<PedidoDto> obtenerPedidosEntreFechas(LocalDateTime fechaInicio, LocalDateTime fechaFin);

    List<PedidoDto> obtenerPedidosPorClienteYEstado(Long clienteId, Pedido.EstadoPedido estado);

    List<PedidoDto> obtenerPedidosConItemsPorCliente(Long clienteId);

    void removerPedido(Long pedidoId);

    PedidoDto actualizarPedido(Long id, PedidoToSaveDto pedido);

    List<PedidoDto> obtenerTodosPedidos();
}

