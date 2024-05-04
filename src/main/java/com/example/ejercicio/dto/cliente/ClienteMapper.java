package com.example.ejercicio.dto.cliente;


import com.example.ejercicio.entidades.Cliente;
import com.example.ejercicio.entidades.Pedido;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@Mapper
public interface ClienteMapper {
    ClienteMapper INSTANCE = Mappers.getMapper(ClienteMapper.class);

    Cliente clienteDtoToClienteEntity(ClienteDto clienteDto);

    @Mapping(target = "id", ignore = true)
    Cliente clienteToSaveDtoToClienteEntity(ClienteToSaveDto clienteToSaveDto);

    ClienteDto clienteEntityToClienteDto(Cliente cliente);

    default List<Long> mapPedidosToIds(List<Pedido> pedidos) {
        return pedidos.stream()
                .map(Pedido::getId)
                .collect(Collectors.toList());
    }

    default List<Pedido> mapIdsToPedidos(List<Long> ids) {
        return ids.stream()
                .map(id -> {
                    Pedido pedido = new Pedido();
                    pedido.setId(id);
                    return pedido;
                })
                .collect(Collectors.toList());
    }
}