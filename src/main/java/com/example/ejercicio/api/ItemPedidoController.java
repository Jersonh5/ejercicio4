package com.example.ejercicio.api;

import com.example.ejercicio.dto.itemPedido.ItemPedidoDto;
import com.example.ejercicio.dto.itemPedido.ItemPedidoToSaveDto;
import com.example.ejercicio.servicios.ItemPedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/order-items")
public class ItemPedidoController {

    private final ItemPedidoService itemPedidoService;

    @Autowired
    public ItemPedidoController(ItemPedidoService itemPedidoService) {
        this.itemPedidoService = itemPedidoService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<ItemPedidoDto> getItemPedidoById(@PathVariable Long id) {
        ItemPedidoDto itemPedidoDto = itemPedidoService.obtenerItemPedido(id);
        if (itemPedidoDto != null) {
            return ResponseEntity.ok(itemPedidoDto);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping
    public ResponseEntity<List<ItemPedidoDto>> getAllItems() {
        List<ItemPedidoDto> itemPedidoDtos = itemPedidoService.obtenerTodosItemPedidos();
        return ResponseEntity.ok(itemPedidoDtos);
    }

    @GetMapping("/order/{orderId}")
    public ResponseEntity<List<ItemPedidoDto>> getItemsByOrderId(@PathVariable Long orderId) {
        List<ItemPedidoDto> itemPedidoDtos = itemPedidoService.obtenerItemsPorPedido(orderId);
        return ResponseEntity.ok(itemPedidoDtos);
    }

    @GetMapping("/product/{productId}")
    public ResponseEntity<List<ItemPedidoDto>> getItemsByProductId(@PathVariable Long productId) {
        List<ItemPedidoDto> itemPedidoDtos = itemPedidoService.obtenerItemsPorProducto(productId);
        return ResponseEntity.ok(itemPedidoDtos);
    }

    @PostMapping
    public ResponseEntity<ItemPedidoDto> createItemPedido(@RequestBody ItemPedidoToSaveDto itemPedidoToSaveDto) {
        ItemPedidoDto newItemPedidoDto = itemPedidoService.guardarItemPedido(itemPedidoToSaveDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(newItemPedidoDto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ItemPedidoDto> updateItemPedido(@PathVariable Long id, @RequestBody ItemPedidoToSaveDto itemPedidoToSaveDto) {
        ItemPedidoDto updatedItemPedidoDto = itemPedidoService.actualizarItemPedido(id, itemPedidoToSaveDto);
        if (updatedItemPedidoDto != null) {
            return ResponseEntity.ok(updatedItemPedidoDto);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteItemPedido(@PathVariable Long id) {
        itemPedidoService.removerItemPedido(id);
        return ResponseEntity.noContent().build();
    }
}
