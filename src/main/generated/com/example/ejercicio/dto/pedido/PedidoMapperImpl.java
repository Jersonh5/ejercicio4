package com.example.ejercicio.dto.pedido;

import com.example.ejercicio.entidades.Pedido;
import java.time.LocalDateTime;
import java.util.List;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-04-03T18:02:22-0500",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 17.0.10 (Oracle Corporation)"
)
public class PedidoMapperImpl implements PedidoMapper {

    @Override
    public Pedido pedidoDtoToPedidoEntity(PedidoDto pedidoDto) {
        if ( pedidoDto == null ) {
            return null;
        }

        Pedido pedido = new Pedido();

        pedido.setId( pedidoDto.id() );
        pedido.setFechaPedido( pedidoDto.fechaPedido() );
        pedido.setStatus( pedidoDto.status() );
        pedido.setCliente( mapIdToCliente( pedidoDto.cliente() ) );
        pedido.setItemPedidos( mapIdsToItemPedidos( pedidoDto.itemPedidos() ) );

        return pedido;
    }

    @Override
    public Pedido pedidoToSaveDtoToPedidoEntity(PedidoToSaveDto pedidoToSaveDto) {
        if ( pedidoToSaveDto == null ) {
            return null;
        }

        Pedido pedido = new Pedido();

        pedido.setFechaPedido( pedidoToSaveDto.fechaPedido() );
        pedido.setStatus( pedidoToSaveDto.status() );
        pedido.setCliente( mapIdToCliente( pedidoToSaveDto.cliente() ) );
        pedido.setItemPedidos( mapIdsToItemPedidos( pedidoToSaveDto.itemPedidos() ) );

        return pedido;
    }

    @Override
    public PedidoDto pedidoEntityToPedidoDto(Pedido pedido) {
        if ( pedido == null ) {
            return null;
        }

        Long id = null;
        LocalDateTime fechaPedido = null;
        Pedido.EstadoPedido status = null;
        Long cliente = null;
        List<Long> itemPedidos = null;

        id = pedido.getId();
        fechaPedido = pedido.getFechaPedido();
        status = pedido.getStatus();
        cliente = mapClienteToId( pedido.getCliente() );
        itemPedidos = mapItemPedidosToIds( pedido.getItemPedidos() );

        PedidoDto pedidoDto = new PedidoDto( id, fechaPedido, status, cliente, itemPedidos );

        return pedidoDto;
    }
}
