package com.example.ejercicio.servicios;

import com.example.ejercicio.dto.detalleEnvio.DetalleEnvioDto;
import com.example.ejercicio.dto.detalleEnvio.DetalleEnvioMapper;
import com.example.ejercicio.dto.detalleEnvio.DetalleToSaveDto;
import com.example.ejercicio.entidades.DetalleEnvio;
import com.example.ejercicio.entidades.Pedido;
import com.example.ejercicio.repositorios.DetalleEnvioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class DetalleEnvioServiceImpl implements DetalleEnvioService {

    private final DetalleEnvioRepository detalleEnvioRepository;
    private final DetalleEnvioMapper detalleEnvioMapper;

    @Autowired
    public DetalleEnvioServiceImpl(DetalleEnvioRepository detalleEnvioRepository, DetalleEnvioMapper detalleEnvioMapper) {
        this.detalleEnvioRepository = detalleEnvioRepository;
        this.detalleEnvioMapper = detalleEnvioMapper;
    }

    @Override
    public DetalleEnvioDto guardarDetalleEnvio(DetalleToSaveDto detalleToSaveDto) {
        DetalleEnvio detalleEnvio = detalleEnvioMapper.detalleEnvioToSaveDtoToDetalleEnvioEntity(detalleToSaveDto);
        detalleEnvio = detalleEnvioRepository.save(detalleEnvio);
        return detalleEnvioMapper.detalleEnvioEntityToDetalleEnvioDto(detalleEnvio);
    }

    @Override
    public DetalleEnvioDto obtenerDetalleEnvio(Long detalleEnvioId) {
        Optional<DetalleEnvio> detalleEnvioOptional = detalleEnvioRepository.findById(detalleEnvioId);
        return detalleEnvioOptional.map(detalleEnvioMapper::detalleEnvioEntityToDetalleEnvioDto).orElse(null);
    }

    @Override
    public List<DetalleEnvioDto> obtenerDetallesEnvioPorPedido(Long pedidoId) {
        List<DetalleEnvio> detallesEnvio = detalleEnvioRepository.findByPedidoId(pedidoId);
        return detallesEnvio.stream().map(detalleEnvioMapper::detalleEnvioEntityToDetalleEnvioDto).collect(Collectors.toList());
    }

    @Override
    public List<DetalleEnvioDto> obtenerDetallesEnvioPorTransportadora(String transportadora) {
        List<DetalleEnvio> detallesEnvio = detalleEnvioRepository.findByTrasnportadora(transportadora);
        return detallesEnvio.stream().map(detalleEnvioMapper::detalleEnvioEntityToDetalleEnvioDto).collect(Collectors.toList());
    }

    @Override
    public List<DetalleEnvioDto> obtenerDetallesEnvioPorEstado(String estado) {
        List<DetalleEnvio> detallesEnvio = detalleEnvioRepository.findByPedido_Status(Pedido.EstadoPedido.valueOf(estado));
        return detallesEnvio.stream().map(detalleEnvioMapper::detalleEnvioEntityToDetalleEnvioDto).collect(Collectors.toList());
    }

    @Override
    public void removerDetalleEnvio(Long detalleEnvioId) {
        detalleEnvioRepository.deleteById(detalleEnvioId);
    }

    @Override
    public DetalleEnvioDto actualizarDetalleEnvio(Long id, DetalleToSaveDto detalleToSaveDto) {
        Optional<DetalleEnvio> detalleEnvioOptional = detalleEnvioRepository.findById(id);
        if (detalleEnvioOptional.isPresent()) {
            DetalleEnvio detalleEnvio = detalleEnvioMapper.detalleEnvioToSaveDtoToDetalleEnvioEntity(detalleToSaveDto);
            detalleEnvio.setId(id);
            detalleEnvio = detalleEnvioRepository.save(detalleEnvio);
            return detalleEnvioMapper.detalleEnvioEntityToDetalleEnvioDto(detalleEnvio);
        } else {
            // Manejo de error si el detalle de envío no existe
            return null;
        }
    }

    @Override
    public List<DetalleEnvioDto> obtenerTodosDetallesEnvio() {
        List<DetalleEnvio> detallesEnvio = detalleEnvioRepository.findAll();
        return detallesEnvio.stream().map(detalleEnvioMapper::detalleEnvioEntityToDetalleEnvioDto).collect(Collectors.toList());
    }
}