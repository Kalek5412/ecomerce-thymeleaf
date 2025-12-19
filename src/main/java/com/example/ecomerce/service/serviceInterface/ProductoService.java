package com.example.ecomerce.service.serviceInterface;

import com.example.ecomerce.entity.Producto;

import java.util.Optional;

public interface ProductoService {
    public Optional<Producto> byId(Long id);
    public Producto save(Producto producto);
    public Producto update(Producto producto, Long id);
    public void delete(Long id);
}
