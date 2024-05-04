package com.example.ejercicio.dto.detalleEnvio;

import com.example.ejercicio.entidades.DetalleEnvio;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-04-03T18:02:23-0500",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 17.0.10 (Oracle Corporation)"
)
public class DetalleEnvioMapperImpl implements DetalleEnvioMapper {

    @Override
    public DetalleEnvio detalleEnvioDtoToDetalleEnvioEntity(DetalleEnvioDto detalleEnvioDto) {
        if ( detalleEnvioDto == null ) {
            return null;
        }

        DetalleEnvio detalleEnvio = new DetalleEnvio();

        detalleEnvio.setId( detalleEnvioDto.id() );
        detalleEnvio.setDireccion( detalleEnvioDto.direccion() );
        detalleEnvio.setTrasnportadora( detalleEnvioDto.trasnportadora() );
        detalleEnvio.setNumeroGuia( detalleEnvioDto.numeroGuia() );
        detalleEnvio.setPedido( mapIdToPedido( detalleEnvioDto.pedido() ) );

        return detalleEnvio;
    }

    @Override
    public DetalleEnvio detalleEnvioToSaveDtoToDetalleEnvioEntity(DetalleToSaveDto detalleToSaveDto) {
        if ( detalleToSaveDto == null ) {
            return null;
        }

        DetalleEnvio detalleEnvio = new DetalleEnvio();

        detalleEnvio.setDireccion( detalleToSaveDto.direccion() );
        detalleEnvio.setTrasnportadora( detalleToSaveDto.trasnportadora() );
        detalleEnvio.setNumeroGuia( detalleToSaveDto.numeroGuia() );
        detalleEnvio.setPedido( mapIdToPedido( detalleToSaveDto.pedido() ) );

        return detalleEnvio;
    }

    @Override
    public DetalleEnvioDto detalleEnvioEntityToDetalleEnvioDto(DetalleEnvio detalleEnvio) {
        if ( detalleEnvio == null ) {
            return null;
        }

        Long id = null;
        String direccion = null;
        String trasnportadora = null;
        Integer numeroGuia = null;
        Long pedido = null;

        id = detalleEnvio.getId();
        direccion = detalleEnvio.getDireccion();
        trasnportadora = detalleEnvio.getTrasnportadora();
        numeroGuia = detalleEnvio.getNumeroGuia();
        pedido = mapPedidoToId( detalleEnvio.getPedido() );

        DetalleEnvioDto detalleEnvioDto = new DetalleEnvioDto( id, direccion, trasnportadora, numeroGuia, pedido );

        return detalleEnvioDto;
    }
}
