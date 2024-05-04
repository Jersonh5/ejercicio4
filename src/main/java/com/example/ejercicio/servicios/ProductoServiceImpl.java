package com.example.ejercicio.servicios;

import com.example.ejercicio.dto.producto.ProductoDto;
import com.example.ejercicio.dto.producto.ProductoMapper;
import com.example.ejercicio.dto.producto.ProductoToSaveDto;
import com.example.ejercicio.entidades.Producto;
import com.example.ejercicio.repositorios.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProductoServiceImpl implements ProductoService {

    private final ProductoRepository productoRepository;
    private final ProductoMapper productoMapper;

    @Autowired
    public ProductoServiceImpl(ProductoRepository productoRepository, ProductoMapper productoMapper) {
        this.productoRepository = productoRepository;
        this.productoMapper = productoMapper;
    }

    @Override
    public ProductoDto guardarProducto(ProductoToSaveDto productoToSaveDto) {
        Producto producto = productoMapper.productoToSaveDtoToProductoEntity(productoToSaveDto);
        producto = productoRepository.save(producto);
        return productoMapper.productoEntityToProductoDto(producto);
    }

    @Override
    public ProductoDto obtenerProducto(Long productoId) {
        Optional<Producto> productoOptional = productoRepository.findById(productoId);
        return productoOptional.map(productoMapper::productoEntityToProductoDto).orElse(null);
    }

    @Override
    public List<ProductoDto> buscarProductosPorNombre(String terminoBusqueda) {
        List<Producto> productos = productoRepository.findByNombreContainingIgnoreCase(terminoBusqueda);
        return productos.stream().map(productoMapper::productoEntityToProductoDto).collect(Collectors.toList());
    }

    @Override
    public List<ProductoDto> buscarProductosEnStock(Integer cantidad) {
        List<Producto> productos = productoRepository.findByStockGreaterThan(cantidad);
        return productos.stream().map(productoMapper::productoEntityToProductoDto).collect(Collectors.toList());
    }

    @Override
    public List<ProductoDto> buscarProductosPorPrecioYStock(Double precioMaximo, Integer stockMaximo) {
        List<Producto> productos = productoRepository.findByPriceLessThanEqualAndStockLessThanEqual(precioMaximo, stockMaximo);
        return productos.stream().map(productoMapper::productoEntityToProductoDto).collect(Collectors.toList());
    }

    @Override
    public void removerProducto(Long productoId) {
        productoRepository.deleteById(productoId);
    }

    @Override
    public ProductoDto actualizarProducto(Long id, ProductoToSaveDto producto) {
        Optional<Producto> productoOptional = productoRepository.findById(id);
        if (productoOptional.isPresent()) {
            Producto productoEntity = productoMapper.productoToSaveDtoToProductoEntity(producto);
            productoEntity.setId(id);
            productoEntity = productoRepository.save(productoEntity);
            return productoMapper.productoEntityToProductoDto(productoEntity);
        } else {
            // Manejo de error si el producto no existe
            return null;
        }
    }
}