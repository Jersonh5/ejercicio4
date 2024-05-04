package com.example.ejercicio.servicios;

import com.example.ejercicio.dto.cliente.ClienteDto;
import com.example.ejercicio.dto.cliente.ClienteToSaveDto;

import java.util.List;

public interface ClienteService {
    ClienteDto guardarCliente(ClienteToSaveDto clienteToSaveDto);

    ClienteDto obtenerCliente(Long clienteId);

    List<ClienteDto> obtenerClientesPorEmail(String email);

    List<ClienteDto> obtenerClientesPorDireccion(String direccion);

    List<ClienteDto> obtenerClientesPorNombre(String nombre);

    void removerCliente(Long clienteId);

    ClienteDto actualizarCliente(Long id, ClienteToSaveDto cliente);

    List<ClienteDto> obtenerTodosClientes(); // Método para obtener todos los clientes
}

