package com.example.ejercicio.dto.pago;

import com.example.ejercicio.entidades.Pago;

import java.time.LocalDateTime;

public record PagoToSaveDto(
        Double totalPago,
        LocalDateTime fechaPago,
        Pago.MetodoPago metodoPago,
        Long pedido) {

}
