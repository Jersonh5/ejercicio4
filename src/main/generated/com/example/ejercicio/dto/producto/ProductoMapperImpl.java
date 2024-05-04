package com.example.ejercicio.dto.producto;

import com.example.ejercicio.entidades.Producto;
import java.util.List;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-04-03T18:02:22-0500",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 17.0.10 (Oracle Corporation)"
)
public class ProductoMapperImpl implements ProductoMapper {

    @Override
    public Producto productoDtoToProductoEntity(ProductoDto productoDto) {
        if ( productoDto == null ) {
            return null;
        }

        Producto producto = new Producto();

        producto.setId( productoDto.id() );
        producto.setNombre( productoDto.nombre() );
        producto.setPrice( productoDto.price() );
        producto.setStock( productoDto.stock() );
        producto.setItemPedidos( mapIdsToItemPedidos( productoDto.itemPedidos() ) );

        return producto;
    }

    @Override
    public Producto productoToSaveDtoToProductoEntity(ProductoToSaveDto productoToSaveDto) {
        if ( productoToSaveDto == null ) {
            return null;
        }

        Producto producto = new Producto();

        producto.setNombre( productoToSaveDto.nombre() );
        producto.setPrice( productoToSaveDto.price() );
        producto.setStock( productoToSaveDto.stock() );
        producto.setItemPedidos( mapIdsToItemPedidos( productoToSaveDto.itemPedidos() ) );

        return producto;
    }

    @Override
    public ProductoDto productoEntityToProductoDto(Producto producto) {
        if ( producto == null ) {
            return null;
        }

        Long id = null;
        String nombre = null;
        Double price = null;
        Integer stock = null;
        List<Long> itemPedidos = null;

        id = producto.getId();
        nombre = producto.getNombre();
        price = producto.getPrice();
        stock = producto.getStock();
        itemPedidos = mapItemPedidosToIds( producto.getItemPedidos() );

        ProductoDto productoDto = new ProductoDto( id, nombre, price, stock, itemPedidos );

        return productoDto;
    }
}
