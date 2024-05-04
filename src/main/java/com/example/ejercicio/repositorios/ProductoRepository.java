package com.example.ejercicio.repositorios;

import com.example.ejercicio.entidades.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductoRepository extends JpaRepository<Producto, Long> {
    // buscar productos según un término de búsqueda
    List<Producto> findByNombreContainingIgnoreCase(String terminoBusqueda);

    // Buscar los productos que están en stock
    List<Producto> findByStockGreaterThan(Integer cantidad);

    // Buscar los productos que no superen un precio y un stock determinado
    List<Producto> findByPriceLessThanEqualAndStockLessThanEqual(Double precioMaximo, Integer stockMaximo);
}
