package com.example.ejercicio.dto.pago;

import com.example.ejercicio.entidades.Pago;
import java.time.LocalDateTime;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-04-03T18:02:23-0500",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 17.0.10 (Oracle Corporation)"
)
public class PagoMapperImpl implements PagoMapper {

    @Override
    public Pago pagoDtoToPagoEntity(PagoDto pagoDto) {
        if ( pagoDto == null ) {
            return null;
        }

        Pago pago = new Pago();

        pago.setId( pagoDto.id() );
        pago.setTotalPago( pagoDto.totalPago() );
        pago.setFechaPago( pagoDto.fechaPago() );
        pago.setMetodoPago( pagoDto.metodoPago() );
        pago.setPedido( mapIdToPedido( pagoDto.pedido() ) );

        return pago;
    }

    @Override
    public Pago pagoToSaveDtoToPagoEntity(PagoToSaveDto pagoToSaveDto) {
        if ( pagoToSaveDto == null ) {
            return null;
        }

        Pago pago = new Pago();

        pago.setTotalPago( pagoToSaveDto.totalPago() );
        pago.setFechaPago( pagoToSaveDto.fechaPago() );
        pago.setMetodoPago( pagoToSaveDto.metodoPago() );
        pago.setPedido( mapIdToPedido( pagoToSaveDto.pedido() ) );

        return pago;
    }

    @Override
    public PagoDto pagoEntityToPagoDto(Pago pago) {
        if ( pago == null ) {
            return null;
        }

        Long id = null;
        Double totalPago = null;
        LocalDateTime fechaPago = null;
        Pago.MetodoPago metodoPago = null;
        Long pedido = null;

        id = pago.getId();
        totalPago = pago.getTotalPago();
        fechaPago = pago.getFechaPago();
        metodoPago = pago.getMetodoPago();
        pedido = mapPedidoToId( pago.getPedido() );

        PagoDto pagoDto = new PagoDto( id, totalPago, fechaPago, metodoPago, pedido );

        return pagoDto;
    }
}
