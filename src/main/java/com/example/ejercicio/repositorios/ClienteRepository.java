package com.example.ejercicio.repositorios;

import com.example.ejercicio.entidades.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
    //encontrar clientes por email
    List<Cliente> findByEmail(String email);

    //Encontrar clientes por dirección
    List<Cliente> findByDireccion(String direccion);

    //Encontrar clientes por todos los clientes que comiencen por un nombre
    List<Cliente> findByNombreStartingWith(String nombre);

}
