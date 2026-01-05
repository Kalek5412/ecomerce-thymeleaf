package com.example.ecomerce.service;

import com.example.ecomerce.entity.DetallePedido;
import com.example.ecomerce.repository.DetallePedidoRepository;
import com.example.ecomerce.service.serviceInterface.DetallePedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DetallePedidoServiceImpl implements DetallePedidoService {

    @Autowired
    private DetallePedidoRepository detallePedidoRepository;

    @Override
    public DetallePedido save(DetallePedido detalleOrden) {
        return detallePedidoRepository.save(detalleOrden);
    }
}
