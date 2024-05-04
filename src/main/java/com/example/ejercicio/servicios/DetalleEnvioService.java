package com.example.ejercicio.servicios;

import com.example.ejercicio.dto.detalleEnvio.DetalleEnvioDto;
import com.example.ejercicio.dto.detalleEnvio.DetalleToSaveDto;

import java.util.List;

public interface DetalleEnvioService {
    DetalleEnvioDto guardarDetalleEnvio(DetalleToSaveDto detalleToSaveDto);

    DetalleEnvioDto obtenerDetalleEnvio(Long detalleEnvioId);

    List<DetalleEnvioDto> obtenerDetallesEnvioPorPedido(Long pedidoId);

    List<DetalleEnvioDto> obtenerDetallesEnvioPorTransportadora(String transportadora);

    List<DetalleEnvioDto> obtenerDetallesEnvioPorEstado(String estado);

    void removerDetalleEnvio(Long detalleEnvioId);

    DetalleEnvioDto actualizarDetalleEnvio(Long id, DetalleToSaveDto detalleEnvio);

    List<DetalleEnvioDto> obtenerTodosDetallesEnvio();
}