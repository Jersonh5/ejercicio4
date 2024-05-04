package com.example.ejercicio.servicios;

import com.example.ejercicio.dto.pedido.PedidoDto;
import com.example.ejercicio.dto.pedido.PedidoMapper;
import com.example.ejercicio.dto.pedido.PedidoToSaveDto;
import com.example.ejercicio.entidades.Pedido;
import com.example.ejercicio.repositorios.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
@Service
public class PedidoServiceImpl implements PedidoService {

    private final PedidoRepository pedidoRepository;
    private final PedidoMapper pedidoMapper;

    @Autowired
    public PedidoServiceImpl(PedidoRepository pedidoRepository, PedidoMapper pedidoMapper) {
        this.pedidoRepository = pedidoRepository;
        this.pedidoMapper = pedidoMapper;
    }

    @Override
    public PedidoDto guardarPedido(PedidoToSaveDto pedidoToSaveDto) {
        Pedido pedido = pedidoMapper.pedidoToSaveDtoToPedidoEntity(pedidoToSaveDto);
        pedido = pedidoRepository.save(pedido);
        return pedidoMapper.pedidoEntityToPedidoDto(pedido);
    }

    @Override
    public PedidoDto obtenerPedido(Long pedidoId) {
        Optional<Pedido> pedidoOptional = pedidoRepository.findById(pedidoId);
        return pedidoOptional.map(pedidoMapper::pedidoEntityToPedidoDto).orElse(null);
    }

    @Override
    public List<PedidoDto> obtenerPedidosEntreFechas(LocalDateTime fechaInicio, LocalDateTime fechaFin) {
        List<Pedido> pedidos = pedidoRepository.findByFechaPedidoBetween(fechaInicio, fechaFin);
        return pedidos.stream().map(pedidoMapper::pedidoEntityToPedidoDto).collect(Collectors.toList());
    }

    @Override
    public List<PedidoDto> obtenerPedidosPorClienteYEstado(Long clienteId, Pedido.EstadoPedido estado) {
        List<Pedido> pedidos = pedidoRepository.findByClienteIdAndStatus(clienteId, estado);
        return pedidos.stream().map(pedidoMapper::pedidoEntityToPedidoDto).collect(Collectors.toList());
    }

    @Override
    public List<PedidoDto> obtenerPedidosConItemsPorCliente(Long clienteId) {
        List<Pedido> pedidos = pedidoRepository.findByClienteIdWithItems(clienteId);
        return pedidos.stream().map(pedidoMapper::pedidoEntityToPedidoDto).collect(Collectors.toList());
    }

    @Override
    public void removerPedido(Long pedidoId) {
        pedidoRepository.deleteById(pedidoId);
    }

    @Override
    public PedidoDto actualizarPedido(Long id, PedidoToSaveDto pedidoToSaveDto) {
        Optional<Pedido> pedidoOptional = pedidoRepository.findById(id);
        if (pedidoOptional.isPresent()) {
            Pedido pedido = pedidoMapper.pedidoToSaveDtoToPedidoEntity(pedidoToSaveDto);
            pedido.setId(id);
            pedido = pedidoRepository.save(pedido);
            return pedidoMapper.pedidoEntityToPedidoDto(pedido);
        } else {
            // Manejo de error si el pedido no existe
            return null;
        }
    }

    @Override
    public List<PedidoDto> obtenerTodosPedidos() {
        List<Pedido> pedidos = pedidoRepository.findAll();
        return pedidos.stream().map(pedidoMapper::pedidoEntityToPedidoDto).collect(Collectors.toList());
    }
}