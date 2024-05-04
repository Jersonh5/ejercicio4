package com.example.ejercicio.dto.itemPedido;

import com.example.ejercicio.entidades.ItemPedido;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-04-03T18:02:22-0500",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 17.0.10 (Oracle Corporation)"
)
public class ItemPedidoMapperImpl implements ItemPedidoMapper {

    @Override
    public ItemPedido itemPedidoDtoToItemPedidoEntity(ItemPedidoDto itemPedidoDto) {
        if ( itemPedidoDto == null ) {
            return null;
        }

        ItemPedido itemPedido = new ItemPedido();

        itemPedido.setId( itemPedidoDto.id() );
        itemPedido.setCantidad( itemPedidoDto.cantidad() );
        itemPedido.setPrecioUnitario( itemPedidoDto.precioUnitario() );
        itemPedido.setPedido( mapIdToPedido( itemPedidoDto.pedido() ) );
        itemPedido.setProducto( mapIdToProducto( itemPedidoDto.producto() ) );

        return itemPedido;
    }

    @Override
    public ItemPedido itemPedidoToSaveDtoToItemPedidoEntity(ItemPedidoToSaveDto itemPedidoToSaveDto) {
        if ( itemPedidoToSaveDto == null ) {
            return null;
        }

        ItemPedido itemPedido = new ItemPedido();

        itemPedido.setCantidad( itemPedidoToSaveDto.cantidad() );
        itemPedido.setPrecioUnitario( itemPedidoToSaveDto.precioUnitario() );
        itemPedido.setPedido( mapIdToPedido( itemPedidoToSaveDto.pedido() ) );
        itemPedido.setProducto( mapIdToProducto( itemPedidoToSaveDto.producto() ) );

        return itemPedido;
    }

    @Override
    public ItemPedidoDto itemPedidoEntityToItemPedidoDto(ItemPedido itemPedido) {
        if ( itemPedido == null ) {
            return null;
        }

        Long id = null;
        Integer cantidad = null;
        Double precioUnitario = null;
        Long pedido = null;
        Long producto = null;

        id = itemPedido.getId();
        cantidad = itemPedido.getCantidad();
        precioUnitario = itemPedido.getPrecioUnitario();
        pedido = mapPedidoToId( itemPedido.getPedido() );
        producto = mapProductoToId( itemPedido.getProducto() );

        ItemPedidoDto itemPedidoDto = new ItemPedidoDto( id, cantidad, precioUnitario, pedido, producto );

        return itemPedidoDto;
    }
}
