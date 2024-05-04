package com.example.ejercicio.api;

import com.example.ejercicio.dto.pago.PagoDto;
import com.example.ejercicio.dto.pago.PagoMapper;
import com.example.ejercicio.dto.pago.PagoToSaveDto;
import com.example.ejercicio.entidades.Pago;
import com.example.ejercicio.repositorios.PagoRepository;
import com.example.ejercicio.servicios.PagoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/payments")
public class PagoController {

    private final PagoService pagoService;
    private final PagoMapper pagoMapper;

    @Autowired
    public PagoController(PagoService pagoService, PagoMapper pagoMapper) {
        this.pagoService = pagoService;
        this.pagoMapper = pagoMapper;
    }

    @GetMapping("/{id}")
    public ResponseEntity<PagoDto> getPaymentById(@PathVariable Long id) {
        PagoDto pagoDto = pagoService.obtenerPago(id);
        if (pagoDto != null) {
            return ResponseEntity.ok(pagoDto);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping
    public ResponseEntity<List<PagoDto>> getAllPayments() {
        List<PagoDto> pagoDtos = pagoService.obtenerTodosPagos();
        return ResponseEntity.ok(pagoDtos);
    }

    @GetMapping("/order/{orderId}")
    public ResponseEntity<List<PagoDto>> getPaymentsByOrder(@PathVariable Long orderId) {
        List<PagoDto> pagoDtos = pagoService.obtenerPagosPorPedidoYMetodoPago(orderId, null);
        return ResponseEntity.ok(pagoDtos);
    }

    @GetMapping("/date-range")
    public ResponseEntity<List<PagoDto>> getPaymentsByDateRange(@RequestParam LocalDateTime startDate, @RequestParam LocalDateTime endDate) {
        List<PagoDto> pagoDtos = pagoService.obtenerPagosPorFecha(startDate, endDate);
        return ResponseEntity.ok(pagoDtos);
    }

    @PostMapping
    public ResponseEntity<PagoDto> createPayment(@RequestBody PagoToSaveDto pagoToSaveDto) {
        PagoDto pagoDto = pagoService.guardarPago(pagoToSaveDto);
        return ResponseEntity.ok(pagoDto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PagoDto> updatePayment(@PathVariable Long id, @RequestBody PagoToSaveDto pagoToSaveDto) {
        PagoDto updatedPagoDto = pagoService.actualizarPago(id, pagoToSaveDto);
        if (updatedPagoDto != null) {
            return ResponseEntity.ok(updatedPagoDto);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePayment(@PathVariable Long id) {
        pagoService.removerPago(id);
        return ResponseEntity.noContent().build();
    }
}