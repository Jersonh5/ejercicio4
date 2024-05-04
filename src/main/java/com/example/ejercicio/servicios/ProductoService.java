package com.example.ejercicio.servicios;

import com.example.ejercicio.dto.producto.ProductoDto;
import com.example.ejercicio.dto.producto.ProductoToSaveDto;

import java.util.List;

public interface ProductoService {
    ProductoDto guardarProducto(ProductoToSaveDto productoToSaveDto);

    ProductoDto obtenerProducto(Long productoId);

    List<ProductoDto> buscarProductosPorNombre(String terminoBusqueda);

    List<ProductoDto> buscarProductosEnStock(Integer cantidad);

    List<ProductoDto> buscarProductosPorPrecioYStock(Double precioMaximo, Integer stockMaximo);

    void removerProducto(Long productoId);

    ProductoDto actualizarProducto(Long id, ProductoToSaveDto producto);

}
