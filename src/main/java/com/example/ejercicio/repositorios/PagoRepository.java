package com.example.ejercicio.repositorios;

import com.example.ejercicio.entidades.Pago;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface PagoRepository extends JpaRepository<Pago, Long> {
    // Recuperar pagos dentro de un rango de fecha
    List<Pago> findByFechaPagoBetween(LocalDateTime fechaInicio, LocalDateTime fechaFin);

    // Recuperar pagos por un identificador de una orden y método de pago
    List<Pago> findByPedido_IdAndMetodoPago(Long idPedido, Pago.MetodoPago metodoPago);

    List<Pago> findByPedido_Id(Long idPedido);
}
