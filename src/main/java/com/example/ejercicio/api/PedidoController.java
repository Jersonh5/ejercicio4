package com.example.ejercicio.api;

import com.example.ejercicio.dto.pedido.PedidoDto;
import com.example.ejercicio.dto.pedido.PedidoMapper;
import com.example.ejercicio.dto.pedido.PedidoToSaveDto;
import com.example.ejercicio.entidades.Pedido;
import com.example.ejercicio.repositorios.PedidoRepository;
import com.example.ejercicio.servicios.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/orders")
public class PedidoController {

    private final PedidoService pedidoService;
    private final PedidoMapper pedidoMapper;

    @Autowired
    public PedidoController(PedidoService pedidoService, PedidoMapper pedidoMapper) {
        this.pedidoService = pedidoService;
        this.pedidoMapper = pedidoMapper;
    }

    @GetMapping("/{id}")
    public ResponseEntity<PedidoDto> getOrderById(@PathVariable Long id) {
        PedidoDto pedidoDto = pedidoService.obtenerPedido(id);
        return pedidoDto != null ? ResponseEntity.ok(pedidoDto) : ResponseEntity.notFound().build();
    }

    @GetMapping
    public ResponseEntity<List<PedidoDto>> getAllOrders() {
        List<PedidoDto> pedidoDtos = pedidoService.obtenerTodosPedidos();
        return ResponseEntity.ok(pedidoDtos);
    }

    @GetMapping("/customer/{customerId}")
    public ResponseEntity<List<PedidoDto>> getOrdersByCustomer(@PathVariable Long customerId) {
        List<PedidoDto> pedidoDtos = pedidoService.obtenerPedidosPorClienteYEstado(customerId, null);
        return ResponseEntity.ok(pedidoDtos);
    }

    @GetMapping("/date-range")
    public ResponseEntity<List<PedidoDto>> getOrdersByDateRange(@RequestParam LocalDateTime startDate, @RequestParam LocalDateTime endDate) {
        List<PedidoDto> pedidoDtos = pedidoService.obtenerPedidosEntreFechas(startDate, endDate);
        return ResponseEntity.ok(pedidoDtos);
    }

    @PostMapping
    public ResponseEntity<PedidoDto> createOrder(@RequestBody PedidoToSaveDto pedidoToSaveDto) {
        PedidoDto pedidoDto = pedidoService.guardarPedido(pedidoToSaveDto);
        return ResponseEntity.ok(pedidoDto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PedidoDto> updateOrder(@PathVariable Long id, @RequestBody PedidoToSaveDto pedidoToSaveDto) {
        PedidoDto pedidoDto = pedidoService.actualizarPedido(id, pedidoToSaveDto);
        return pedidoDto != null ? ResponseEntity.ok(pedidoDto) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteOrder(@PathVariable Long id) {
        pedidoService.removerPedido(id);
        return ResponseEntity.noContent().build();
    }
}