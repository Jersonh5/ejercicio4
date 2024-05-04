package com.example.ejercicio.servicios;

import com.example.ejercicio.dto.pago.PagoDto;
import com.example.ejercicio.dto.pago.PagoMapper;
import com.example.ejercicio.dto.pago.PagoToSaveDto;
import com.example.ejercicio.entidades.Pago;
import com.example.ejercicio.repositorios.PagoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PagoServiceImpl implements PagoService {

    private final PagoRepository pagoRepository;
    private final PagoMapper pagoMapper;

    @Autowired
    public PagoServiceImpl(PagoRepository pagoRepository, PagoMapper pagoMapper) {
        this.pagoRepository = pagoRepository;
        this.pagoMapper = pagoMapper;
    }

    @Override
    public PagoDto guardarPago(PagoToSaveDto pagoToSaveDto) {
        Pago pago = pagoMapper.pagoToSaveDtoToPagoEntity(pagoToSaveDto);
        pago = pagoRepository.save(pago);
        return pagoMapper.pagoEntityToPagoDto(pago);
    }

    @Override
    public PagoDto obtenerPago(Long pagoId) {
        Optional<Pago> pagoOptional = pagoRepository.findById(pagoId);
        return pagoOptional.map(pagoMapper::pagoEntityToPagoDto).orElse(null);
    }

    @Override
    public List<PagoDto> obtenerPagosPorFecha(LocalDateTime fechaInicio, LocalDateTime fechaFin) {
        List<Pago> pagos = pagoRepository.findByFechaPagoBetween(fechaInicio, fechaFin);
        return pagos.stream().map(pagoMapper::pagoEntityToPagoDto).collect(Collectors.toList());
    }

    @Override
    public List<PagoDto> obtenerPagosPorPedidoYMetodoPago(Long idPedido, Pago.MetodoPago metodoPago) {
        List<Pago> pagos = pagoRepository.findByPedido_IdAndMetodoPago(idPedido, metodoPago);
        return pagos.stream().map(pagoMapper::pagoEntityToPagoDto).collect(Collectors.toList());
    }

    @Override
    public void removerPago(Long pagoId) {
        pagoRepository.deleteById(pagoId);
    }

    @Override
    public PagoDto actualizarPago(Long id, PagoToSaveDto pagoToSaveDto) {
        Optional<Pago> pagoOptional = pagoRepository.findById(id);
        if (pagoOptional.isPresent()) {
            Pago pago = pagoMapper.pagoToSaveDtoToPagoEntity(pagoToSaveDto);
            pago.setId(id);
            pago = pagoRepository.save(pago);
            return pagoMapper.pagoEntityToPagoDto(pago);
        } else {
            // Manejo de error si el pago no existe
            return null;
        }
    }

    @Override
    public List<PagoDto> obtenerTodosPagos() {
        List<Pago> pagos = pagoRepository.findAll();
        return pagos.stream().map(pagoMapper::pagoEntityToPagoDto).collect(Collectors.toList());
    }
}