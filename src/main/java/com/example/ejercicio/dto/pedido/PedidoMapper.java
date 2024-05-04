package com.example.ejercicio.dto.pedido;


import com.example.ejercicio.entidades.Pedido;
import com.example.ejercicio.entidades.Cliente;
import com.example.ejercicio.entidades.ItemPedido;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@Mapper
public interface PedidoMapper {
    PedidoMapper INSTANCE = Mappers.getMapper(PedidoMapper.class);

    Pedido pedidoDtoToPedidoEntity(PedidoDto pedidoDto);

    @Mapping(target = "id", ignore = true)
    Pedido pedidoToSaveDtoToPedidoEntity(PedidoToSaveDto pedidoToSaveDto);

    PedidoDto pedidoEntityToPedidoDto(Pedido pedido);

    default Long mapClienteToId(Cliente cliente) {
        return cliente != null ? cliente.getId() : null;
    }

    default Cliente mapIdToCliente(Long id) {
        Cliente cliente = new Cliente();
        cliente.setId(id);
        return cliente;
    }

    default List<Long> mapItemPedidosToIds(List<ItemPedido> itemPedidos) {
        return itemPedidos.stream()
                .map(ItemPedido::getId)
                .collect(Collectors.toList());
    }

    default List<ItemPedido> mapIdsToItemPedidos(List<Long> ids) {
        return ids.stream()
                .map(id -> {
                    ItemPedido itemPedido = new ItemPedido();
                    itemPedido.setId(id);
                    return itemPedido;
                })
                .collect(Collectors.toList());
    }
}
