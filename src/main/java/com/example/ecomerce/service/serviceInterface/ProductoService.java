package com.example.ecomerce.service.serviceInterface;

import com.example.ecomerce.entity.Producto;

import java.util.List;
import java.util.Optional;

public interface ProductoService {
    public List<Producto> findAll();
    public Optional<Producto> byId(Long id);
    public Producto save(Producto producto);
    public Producto update(Producto producto);
    public void delete(Long id);
}
