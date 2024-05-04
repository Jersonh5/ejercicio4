package com.example.ejercicio.repositorios;

import com.example.ejercicio.entidades.ItemPedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ItemPedidoRepository extends JpaRepository<ItemPedido, Long> {
    // Buscar Items del pedido por Pedido Id
    List<ItemPedido> findByPedidoId(Long pedidoId);

    // Buscar items del pedido para un producto específico
    List<ItemPedido> findByProductoId(Long productoId);

    // Calcular la suma del total de ventas para un producto, utilice la agregación SUM
    @Query("SELECT SUM(ip.cantidad * ip.precioUnitario) FROM ItemPedido ip WHERE ip.producto.id = :productoId")
    Double calcularTotalVentasPorProducto(@Param("productoId") Long productoId);
}
