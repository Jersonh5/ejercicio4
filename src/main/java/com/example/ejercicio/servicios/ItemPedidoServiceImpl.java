package com.example.ejercicio.servicios;

import com.example.ejercicio.dto.itemPedido.ItemPedidoDto;
import com.example.ejercicio.dto.itemPedido.ItemPedidoMapper;
import com.example.ejercicio.dto.itemPedido.ItemPedidoToSaveDto;
import com.example.ejercicio.entidades.ItemPedido;
import com.example.ejercicio.repositorios.ItemPedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ItemPedidoServiceImpl implements ItemPedidoService {

    private final ItemPedidoRepository itemPedidoRepository;
    private final ItemPedidoMapper itemPedidoMapper;

    @Autowired
    public ItemPedidoServiceImpl(ItemPedidoRepository itemPedidoRepository, ItemPedidoMapper itemPedidoMapper) {
        this.itemPedidoRepository = itemPedidoRepository;
        this.itemPedidoMapper = itemPedidoMapper;
    }

    @Override
    public ItemPedidoDto guardarItemPedido(ItemPedidoToSaveDto itemPedidoToSaveDto) {
        ItemPedido itemPedido = itemPedidoMapper.itemPedidoToSaveDtoToItemPedidoEntity(itemPedidoToSaveDto);
        itemPedido = itemPedidoRepository.save(itemPedido);
        return itemPedidoMapper.itemPedidoEntityToItemPedidoDto(itemPedido);
    }

    @Override
    public ItemPedidoDto obtenerItemPedido(Long itemPedidoId) {
        Optional<ItemPedido> itemPedidoOptional = itemPedidoRepository.findById(itemPedidoId);
        return itemPedidoOptional.map(itemPedidoMapper::itemPedidoEntityToItemPedidoDto).orElse(null);
    }

    @Override
    public List<ItemPedidoDto> obtenerItemsPorPedido(Long pedidoId) {
        List<ItemPedido> itemsPedido = itemPedidoRepository.findByPedidoId(pedidoId);
        return itemsPedido.stream().map(itemPedidoMapper::itemPedidoEntityToItemPedidoDto).collect(Collectors.toList());
    }

    @Override
    public List<ItemPedidoDto> obtenerItemsPorProducto(Long productoId) {
        List<ItemPedido> itemsPedido = itemPedidoRepository.findByProductoId(productoId);
        return itemsPedido.stream().map(itemPedidoMapper::itemPedidoEntityToItemPedidoDto).collect(Collectors.toList());
    }

    @Override
    public Double calcularTotalVentasPorProducto(Long productoId) {
        return itemPedidoRepository.calcularTotalVentasPorProducto(productoId);
    }

    @Override
    public void removerItemPedido(Long itemPedidoId) {
        itemPedidoRepository.deleteById(itemPedidoId);
    }

    @Override
    public ItemPedidoDto actualizarItemPedido(Long id, ItemPedidoToSaveDto itemPedidoToSaveDto) {
        Optional<ItemPedido> itemPedidoOptional = itemPedidoRepository.findById(id);
        if (itemPedidoOptional.isPresent()) {
            ItemPedido itemPedido = itemPedidoMapper.itemPedidoToSaveDtoToItemPedidoEntity(itemPedidoToSaveDto);
            itemPedido.setId(id);
            itemPedido = itemPedidoRepository.save(itemPedido);
            return itemPedidoMapper.itemPedidoEntityToItemPedidoDto(itemPedido);
        } else {
            // Manejo de error si el item de pedido no existe
            return null;
        }
    }

    @Override
    public List<ItemPedidoDto> obtenerTodosItemPedidos() {
        return itemPedidoRepository.findAll()
                .stream()
                .map(itemPedidoMapper::itemPedidoEntityToItemPedidoDto)
                .collect(Collectors.toList());
    }
}
