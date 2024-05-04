package com.example.ejercicio.api;

import com.example.ejercicio.dto.producto.ProductoDto;
import com.example.ejercicio.dto.producto.ProductoMapper;
import com.example.ejercicio.dto.producto.ProductoToSaveDto;
import com.example.ejercicio.entidades.Producto;
import com.example.ejercicio.repositorios.ProductoRepository;
import com.example.ejercicio.servicios.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/products")
public class ProductoController {

    private final ProductoService productoService;
    private final ProductoMapper productoMapper;

    @Autowired
    public ProductoController(ProductoService productoService, ProductoMapper productoMapper) {
        this.productoService = productoService;
        this.productoMapper = productoMapper;
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductoDto> getProductById(@PathVariable Long id) {
        ProductoDto productoDto = productoService.obtenerProducto(id);
        if (productoDto != null) {
            return ResponseEntity.ok(productoDto);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/search")
    public ResponseEntity<List<ProductoDto>> searchProducts(@RequestParam String searchTerm) {
        List<ProductoDto> productoDtos = productoService.buscarProductosPorNombre(searchTerm);
        return ResponseEntity.ok(productoDtos);
    }

    @GetMapping("/instock")
    public ResponseEntity<List<ProductoDto>> getProductsInStock() {
        List<ProductoDto> productoDtos = productoService.buscarProductosEnStock(1); // Modifica el valor si necesario
        return ResponseEntity.ok(productoDtos);
    }

    @PostMapping
    public ResponseEntity<ProductoDto> createProduct(@RequestBody ProductoToSaveDto productoToSaveDto) {
        ProductoDto productoDto = productoService.guardarProducto(productoToSaveDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(productoDto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProductoDto> updateProduct(@PathVariable Long id, @RequestBody ProductoToSaveDto productoToSaveDto) {
        ProductoDto productoDto = productoService.actualizarProducto(id, productoToSaveDto);
        if (productoDto != null) {
            return ResponseEntity.ok(productoDto);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable Long id) {
        productoService.removerProducto(id);
        return ResponseEntity.noContent().build();
    }
}