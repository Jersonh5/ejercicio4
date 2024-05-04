package com.example.ejercicio.api;

import com.example.ejercicio.dto.detalleEnvio.DetalleEnvioDto;
import com.example.ejercicio.dto.detalleEnvio.DetalleToSaveDto;
import com.example.ejercicio.servicios.DetalleEnvioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/shipping")
public class DetalleEnvioController {

    private final DetalleEnvioService detalleEnvioService;

    @Autowired
    public DetalleEnvioController(DetalleEnvioService detalleEnvioService) {
        this.detalleEnvioService = detalleEnvioService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<DetalleEnvioDto> getShippingById(@PathVariable Long id) {
        DetalleEnvioDto detalleEnvioDto = detalleEnvioService.obtenerDetalleEnvio(id);
        return detalleEnvioDto != null ? ResponseEntity.ok(detalleEnvioDto) : ResponseEntity.notFound().build();
    }

    @GetMapping
    public ResponseEntity<List<DetalleEnvioDto>> getAllShippings() {
        List<DetalleEnvioDto> detalleEnvioDtos = detalleEnvioService.obtenerTodosDetallesEnvio();
        return ResponseEntity.ok(detalleEnvioDtos);
    }

    @GetMapping("/order/{orderId}")
    public ResponseEntity<List<DetalleEnvioDto>> getShippingsByOrder(@PathVariable Long orderId) {
        List<DetalleEnvioDto> detalleEnvioDtos = detalleEnvioService.obtenerDetallesEnvioPorPedido(orderId);
        return ResponseEntity.ok(detalleEnvioDtos);
    }

    @GetMapping("/carrier")
    public ResponseEntity<List<DetalleEnvioDto>> getShippingsByCarrier(@RequestParam String name) {
        List<DetalleEnvioDto> detalleEnvioDtos = detalleEnvioService.obtenerDetallesEnvioPorTransportadora(name);
        return ResponseEntity.ok(detalleEnvioDtos);
    }

    @PostMapping
    public ResponseEntity<DetalleEnvioDto> createShipping(@RequestBody DetalleToSaveDto detalleToSaveDto) {
        DetalleEnvioDto detalleEnvioDto = detalleEnvioService.guardarDetalleEnvio(detalleToSaveDto);
        return ResponseEntity.ok(detalleEnvioDto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<DetalleEnvioDto> updateShipping(@PathVariable Long id, @RequestBody DetalleToSaveDto detalleToSaveDto) {
        DetalleEnvioDto detalleEnvioDto = detalleEnvioService.actualizarDetalleEnvio(id, detalleToSaveDto);
        return detalleEnvioDto != null ? ResponseEntity.ok(detalleEnvioDto) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteShipping(@PathVariable Long id) {
        detalleEnvioService.removerDetalleEnvio(id);
        return ResponseEntity.noContent().build();
    }
}