package com.example.ejercicio.repositorios;

import com.example.ejercicio.entidades.Cliente;
import com.example.ejercicio.entidades.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;
import java.util.List;

public interface PedidoRepository extends JpaRepository<Pedido, Long> {
    // Buscar pedidos entre dos fechas
    List<Pedido> findByFechaPedidoBetween(LocalDateTime fechaInicio, LocalDateTime fechaFin);

    // Buscar pedidos por cliente y un estado
    List<Pedido> findByClienteAndStatus(Cliente cliente, Pedido.EstadoPedido status);

    // Recuperar pedidos con sus artículos usando JOIN fetch para evitar el problema N+1, para un cliente específico
    @Query("SELECT p FROM Pedido p JOIN FETCH p.itemPedidos WHERE p.cliente = :cliente")
    List<Pedido> findPedidosWithItemsByCliente(@Param("cliente") Cliente cliente);

    List<Pedido> findByClienteId(Long clienteId);

    List<Pedido> findByClienteIdAndStatus(Long clienteId, Pedido.EstadoPedido status);

    @Query("SELECT p FROM Pedido p JOIN FETCH p.itemPedidos WHERE p.cliente.id = :clienteId")
    List<Pedido> findByClienteIdWithItems(@Param("clienteId") Long clienteId);
}
