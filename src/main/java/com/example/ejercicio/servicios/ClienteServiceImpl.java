package com.example.ejercicio.servicios;


import com.example.ejercicio.dto.cliente.ClienteDto;
import com.example.ejercicio.dto.cliente.ClienteMapper;
import com.example.ejercicio.dto.cliente.ClienteToSaveDto;
import com.example.ejercicio.entidades.Cliente;
import com.example.ejercicio.repositorios.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ClienteServiceImpl implements ClienteService {

    private final ClienteRepository clienteRepository;
    private final ClienteMapper clienteMapper;

    @Autowired
    public ClienteServiceImpl(ClienteRepository clienteRepository, ClienteMapper clienteMapper) {
        this.clienteRepository = clienteRepository;
        this.clienteMapper = clienteMapper;
    }

    @Override
    public ClienteDto guardarCliente(ClienteToSaveDto clienteToSaveDto) {
        Cliente cliente = clienteMapper.clienteToSaveDtoToClienteEntity(clienteToSaveDto);
        cliente = clienteRepository.save(cliente);
        return clienteMapper.clienteEntityToClienteDto(cliente);
    }

    @Override
    public ClienteDto obtenerCliente(Long clienteId) {
        Optional<Cliente> clienteOptional = clienteRepository.findById(clienteId);
        return clienteOptional.map(clienteMapper::clienteEntityToClienteDto).orElse(null);
    }

    @Override
    public List<ClienteDto> obtenerClientesPorEmail(String email) {
        List<Cliente> clientes = clienteRepository.findByEmail(email);
        return clientes.stream().map(clienteMapper::clienteEntityToClienteDto).collect(Collectors.toList());
    }

    @Override
    public List<ClienteDto> obtenerClientesPorDireccion(String direccion) {
        List<Cliente> clientes = clienteRepository.findByDireccion(direccion);
        return clientes.stream().map(clienteMapper::clienteEntityToClienteDto).collect(Collectors.toList());
    }

    @Override
    public List<ClienteDto> obtenerClientesPorNombre(String nombre) {
        List<Cliente> clientes = clienteRepository.findByNombreStartingWith(nombre);
        return clientes.stream().map(clienteMapper::clienteEntityToClienteDto).collect(Collectors.toList());
    }

    @Override
    public void removerCliente(Long clienteId) {
        clienteRepository.deleteById(clienteId);
    }

    @Override
    public ClienteDto actualizarCliente(Long id, ClienteToSaveDto clienteToSaveDto) {
        Optional<Cliente> clienteOptional = clienteRepository.findById(id);
        if (clienteOptional.isPresent()) {
            Cliente cliente = clienteMapper.clienteToSaveDtoToClienteEntity(clienteToSaveDto);
            cliente.setId(id);
            cliente = clienteRepository.save(cliente);
            return clienteMapper.clienteEntityToClienteDto(cliente);
        } else {
            // Manejo de error si el cliente no existe
            return null;
        }
    }

    @Override
    public List<ClienteDto> obtenerTodosClientes() {
        List<Cliente> clientes = clienteRepository.findAll();
        return clientes.stream().map(clienteMapper::clienteEntityToClienteDto).collect(Collectors.toList());
    }
}