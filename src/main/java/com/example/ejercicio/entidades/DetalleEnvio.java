package com.example.ejercicio.entidades;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "detalleEnvios")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class DetalleEnvio {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String direccion;
    private String trasnportadora;
    private Integer numeroGuia;
    @OneToOne
    @JoinColumn(name = "Id_pedido", nullable = false)
    private Pedido pedido;

    public Long getId() {
        return id;
    }

    public String getDireccion() {
        return direccion;
    }

    public String getTrasnportadora() {
        return trasnportadora;
    }

    public Integer getNumeroGuia() {
        return numeroGuia;
    }

    public Pedido getPedido() {
        return pedido;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public void setTrasnportadora(String trasnportadora) {
        this.trasnportadora = trasnportadora;
    }

    public void setNumeroGuia(Integer numeroGuia) {
        this.numeroGuia = numeroGuia;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }
}

