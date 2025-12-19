package com.example.ecomerce.service;

import com.example.ecomerce.entity.Producto;
import com.example.ecomerce.repository.ProductoRepository;
import com.example.ecomerce.service.serviceInterface.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProductoServiceImpl implements ProductoService {

    @Autowired
    ProductoRepository productoRepository;

    @Override
    public Optional<Producto> byId(Long id) {
        return productoRepository.findById(id);
    }

    @Override
    public Producto save(Producto producto) {
        return productoRepository.save(producto);
    }

    @Override
    public Producto update(Producto producto, Long id) {
        Producto prodAux=productoRepository.findById(id).get();
        prodAux.setNombre(producto.getNombre());
        prodAux.setDescripcion(producto.getDescripcion());
        prodAux.setImagen(producto.getImagen());
        prodAux.setPrecio(producto.getPrecio());
        prodAux.setCantidad(producto.getCantidad());
        return productoRepository.save(prodAux);
    }

    @Override
    public void delete(Long id) {
        productoRepository.deleteById(id);
    }
}
