package com.example.ejercicio.dto.cliente;

import com.example.ejercicio.entidades.Cliente;
import java.util.List;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-04-03T18:02:23-0500",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 17.0.10 (Oracle Corporation)"
)
public class ClienteMapperImpl implements ClienteMapper {

    @Override
    public Cliente clienteDtoToClienteEntity(ClienteDto clienteDto) {
        if ( clienteDto == null ) {
            return null;
        }

        Cliente cliente = new Cliente();

        cliente.setId( clienteDto.id() );
        cliente.setNombre( clienteDto.nombre() );
        cliente.setEmail( clienteDto.email() );
        cliente.setDireccion( clienteDto.direccion() );
        cliente.setPedidos( mapIdsToPedidos( clienteDto.pedidos() ) );

        return cliente;
    }

    @Override
    public Cliente clienteToSaveDtoToClienteEntity(ClienteToSaveDto clienteToSaveDto) {
        if ( clienteToSaveDto == null ) {
            return null;
        }

        Cliente cliente = new Cliente();

        cliente.setNombre( clienteToSaveDto.nombre() );
        cliente.setEmail( clienteToSaveDto.email() );
        cliente.setDireccion( clienteToSaveDto.direccion() );
        cliente.setPedidos( mapIdsToPedidos( clienteToSaveDto.pedidos() ) );

        return cliente;
    }

    @Override
    public ClienteDto clienteEntityToClienteDto(Cliente cliente) {
        if ( cliente == null ) {
            return null;
        }

        Long id = null;
        String nombre = null;
        String email = null;
        String direccion = null;
        List<Long> pedidos = null;

        id = cliente.getId();
        nombre = cliente.getNombre();
        email = cliente.getEmail();
        direccion = cliente.getDireccion();
        pedidos = mapPedidosToIds( cliente.getPedidos() );

        ClienteDto clienteDto = new ClienteDto( id, nombre, email, direccion, pedidos );

        return clienteDto;
    }
}
