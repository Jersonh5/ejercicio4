package com.example.ejercicio.repositorios;

import com.example.ejercicio.entidades.DetalleEnvio;
import com.example.ejercicio.entidades.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DetalleEnvioRepository extends JpaRepository<DetalleEnvio, Long> {

    // Buscar los detalles del envío por pedido Id
    List<DetalleEnvio> findByPedidoId(Long pedidoId);

    // Buscar los detalles de envío para una transportadora
    List<DetalleEnvio> findByTrasnportadora(String transportadora);

    // Buscar los detalles de envío por estado
    List<DetalleEnvio> findByPedido_Status(Pedido.EstadoPedido estado);

}
