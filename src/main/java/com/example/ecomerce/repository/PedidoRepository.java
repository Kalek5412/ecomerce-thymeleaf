package com.example.ecomerce.repository;

import com.example.ecomerce.entity.Pedido;
import com.example.ecomerce.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PedidoRepository extends JpaRepository<Pedido,Long> {
    List<Pedido> findByUsuario (Usuario usuario);
}
