package com.example.ejercicio.dto.pago;
import com.example.ejercicio.entidades.Pago.MetodoPago;
import java.time.LocalDateTime;

public record PagoDto(
        Long id,
        Double totalPago,
        LocalDateTime fechaPago,
        MetodoPago metodoPago,
        Long pedido) {
}
