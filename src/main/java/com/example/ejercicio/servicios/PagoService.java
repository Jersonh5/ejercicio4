package com.example.ejercicio.servicios;

import com.example.ejercicio.dto.pago.PagoDto;
import com.example.ejercicio.dto.pago.PagoToSaveDto;
import com.example.ejercicio.entidades.Pago;

import java.time.LocalDateTime;
import java.util.List;

public interface PagoService {
    PagoDto guardarPago(PagoToSaveDto pagoToSaveDto);

    PagoDto obtenerPago(Long pagoId);

    List<PagoDto> obtenerPagosPorFecha(LocalDateTime fechaInicio, LocalDateTime fechaFin);

    List<PagoDto> obtenerPagosPorPedidoYMetodoPago(Long idPedido, Pago.MetodoPago metodoPago);

    void removerPago(Long pagoId);

    PagoDto actualizarPago(Long id, PagoToSaveDto pagoToSaveDto);

    List<PagoDto> obtenerTodosPagos();
}
