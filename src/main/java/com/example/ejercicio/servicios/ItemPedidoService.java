package com.example.ejercicio.servicios;

import com.example.ejercicio.dto.itemPedido.ItemPedidoDto;
import com.example.ejercicio.dto.itemPedido.ItemPedidoToSaveDto;

import java.util.List;

public interface ItemPedidoService {
    ItemPedidoDto guardarItemPedido(ItemPedidoToSaveDto itemPedidoToSaveDto);

    ItemPedidoDto obtenerItemPedido(Long itemPedidoId);

    List<ItemPedidoDto> obtenerItemsPorPedido(Long pedidoId);

    List<ItemPedidoDto> obtenerItemsPorProducto(Long productoId);

    Double calcularTotalVentasPorProducto(Long productoId);

    void removerItemPedido(Long itemPedidoId);

    ItemPedidoDto actualizarItemPedido(Long id, ItemPedidoToSaveDto itemPedidoToSaveDto);

    List<ItemPedidoDto> obtenerTodosItemPedidos();



}

