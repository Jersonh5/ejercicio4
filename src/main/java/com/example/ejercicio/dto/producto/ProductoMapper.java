package com.example.ejercicio.dto.producto;

import com.example.ejercicio.entidades.ItemPedido;
import com.example.ejercicio.entidades.Producto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@Mapper
public interface ProductoMapper {
    ProductoMapper INSTANCE = Mappers.getMapper(ProductoMapper.class);

    Producto productoDtoToProductoEntity(ProductoDto productoDto);

    @Mapping(target = "id", ignore = true)
    Producto productoToSaveDtoToProductoEntity(ProductoToSaveDto productoToSaveDto);

    ProductoDto productoEntityToProductoDto(Producto producto);

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