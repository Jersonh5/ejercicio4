package com.example.ejercicio.dto.itemPedido;

import com.example.ejercicio.entidades.ItemPedido;
import com.example.ejercicio.entidades.Pedido;
import com.example.ejercicio.entidades.Producto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Component;

@Component
@Mapper
public interface ItemPedidoMapper {
    ItemPedidoMapper INSTANCE = Mappers.getMapper(ItemPedidoMapper.class);

    ItemPedido itemPedidoDtoToItemPedidoEntity(ItemPedidoDto itemPedidoDto);

    @Mapping(target = "id", ignore = true)
    ItemPedido itemPedidoToSaveDtoToItemPedidoEntity(ItemPedidoToSaveDto itemPedidoToSaveDto);

    ItemPedidoDto itemPedidoEntityToItemPedidoDto(ItemPedido itemPedido);

    default Long mapPedidoToId(Pedido pedido) {
        return pedido != null ? pedido.getId() : null;
    }

    default Pedido mapIdToPedido(Long id) {
        Pedido pedido = new Pedido();
        pedido.setId(id);
        return pedido;
    }

    default Long mapProductoToId(Producto producto) {
        return producto != null ? producto.getId() : null;
    }

    default Producto mapIdToProducto(Long id) {
        Producto producto = new Producto();
        producto.setId(id);
        return producto;
    }
}
