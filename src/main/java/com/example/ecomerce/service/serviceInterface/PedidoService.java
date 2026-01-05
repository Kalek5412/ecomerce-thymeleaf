package com.example.ecomerce.service.serviceInterface;

import com.example.ecomerce.entity.Pedido;
import com.example.ecomerce.entity.Usuario;

import java.util.List;
import java.util.Optional;

public interface PedidoService {
    List<Pedido> findAll();
    Optional<Pedido> findById(Long id);
    Pedido save (Pedido pedido);
    String generarNumeroPedido();
    List<Pedido> findByUsuario (Usuario usuario);
}
