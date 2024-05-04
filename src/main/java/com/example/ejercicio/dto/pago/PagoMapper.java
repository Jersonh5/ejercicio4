package com.example.ejercicio.dto.pago;

import com.example.ejercicio.entidades.Pago;
import com.example.ejercicio.entidades.Pedido;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Component;

@Component
@Mapper
public interface PagoMapper {
    PagoMapper INSTANCE = Mappers.getMapper(PagoMapper.class);

    Pago pagoDtoToPagoEntity(PagoDto pagoDto);

    @Mapping(target = "id", ignore = true)
    Pago pagoToSaveDtoToPagoEntity(PagoToSaveDto pagoToSaveDto);

    PagoDto pagoEntityToPagoDto(Pago pago);

    default Long mapPedidoToId(Pedido pedido) {
        return pedido != null ? pedido.getId() : null;
    }

    default Pedido mapIdToPedido(Long id) {
        Pedido pedido = new Pedido();
        pedido.setId(id);
        return pedido;
    }
}