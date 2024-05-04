package com.example.ejercicio.dto.detalleEnvio;

import com.example.ejercicio.entidades.DetalleEnvio;
import com.example.ejercicio.entidades.Pedido;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Component;

@Component
@Mapper
public interface DetalleEnvioMapper {
    DetalleEnvioMapper INSTANCE = Mappers.getMapper(DetalleEnvioMapper.class);

    DetalleEnvio detalleEnvioDtoToDetalleEnvioEntity(DetalleEnvioDto detalleEnvioDto);

    @Mapping(target = "id", ignore = true)
    DetalleEnvio detalleEnvioToSaveDtoToDetalleEnvioEntity(DetalleToSaveDto detalleToSaveDto);

    DetalleEnvioDto detalleEnvioEntityToDetalleEnvioDto(DetalleEnvio detalleEnvio);

    default Long mapPedidoToId(Pedido pedido) {
        return pedido != null ? pedido.getId() : null;
    }

    default Pedido mapIdToPedido(Long id) {
        Pedido pedido = new Pedido();
        pedido.setId(id);
        return pedido;
    }
}