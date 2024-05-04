package com.example.ejercicio.api;

import com.example.ejercicio.dto.cliente.ClienteDto;
import com.example.ejercicio.dto.cliente.ClienteMapper;
import com.example.ejercicio.dto.cliente.ClienteToSaveDto;
import com.example.ejercicio.entidades.Cliente;
import com.example.ejercicio.repositorios.ClienteRepository;
import com.example.ejercicio.servicios.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/customers")
public class ClienteController {

    private final ClienteService clienteService;
    private final ClienteMapper clienteMapper;

    @Autowired
    public ClienteController(ClienteService clienteService, ClienteMapper clienteMapper) {
        this.clienteService = clienteService;
        this.clienteMapper = clienteMapper;
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClienteDto> getCustomerById(@PathVariable Long id) {
        ClienteDto clienteDto = clienteService.obtenerCliente(id);
        if (clienteDto != null) {
            return ResponseEntity.ok(clienteDto);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping
    public ResponseEntity<List<ClienteDto>> getAllCustomers() {
        List<ClienteDto> clienteDtos = clienteService.obtenerTodosClientes();
        return ResponseEntity.ok(clienteDtos);
    }

    @GetMapping("/email/{email}")
    public ResponseEntity<List<ClienteDto>> getCustomersByEmail(@PathVariable String email) {
        List<ClienteDto> clienteDtos = clienteService.obtenerClientesPorEmail(email);
        return ResponseEntity.ok(clienteDtos);
    }

    @GetMapping("/city")
    public ResponseEntity<List<ClienteDto>> getCustomersByCity(@RequestParam String cityName) {
        List<ClienteDto> clienteDtos = clienteService.obtenerClientesPorDireccion(cityName);
        return ResponseEntity.ok(clienteDtos);
    }

    @PostMapping
    public ResponseEntity<ClienteDto> createCustomer(@RequestBody ClienteToSaveDto clienteToSaveDto) {
        ClienteDto clienteDto = clienteService.guardarCliente(clienteToSaveDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(clienteDto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ClienteDto> updateCustomer(@PathVariable Long id, @RequestBody ClienteToSaveDto clienteToSaveDto) {
        ClienteDto clienteDto = clienteService.actualizarCliente(id, clienteToSaveDto);
        if (clienteDto != null) {
            return ResponseEntity.ok(clienteDto);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCustomer(@PathVariable Long id) {
        clienteService.removerCliente(id);
        return ResponseEntity.noContent().build();
    }
}

