package com.example.ejercicio.entidades;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "pagos")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Pago {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Double totalPago;
    private LocalDateTime fechaPago;
    private MetodoPago metodoPago;

    @OneToOne
    @JoinColumn(name = "Id_pedido", nullable = false)
    private Pedido pedido;

    public enum MetodoPago {
        EFECTIVO, TARJETA_CREDITO, PAYPAL, NEQUI, DAVIPLATA, PSE
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getTotalPago() {
        return totalPago;
    }

    public void setTotalPago(Double totalPago) {
        this.totalPago = totalPago;
    }

    public LocalDateTime getFechaPago() {
        return fechaPago;
    }

    public void setFechaPago(LocalDateTime fechaPago) {
        this.fechaPago = fechaPago;
    }

    public MetodoPago getMetodoPago() {
        return metodoPago;
    }

    public void setMetodoPago(MetodoPago metodoPago) {
        this.metodoPago = metodoPago;
    }

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }
}

