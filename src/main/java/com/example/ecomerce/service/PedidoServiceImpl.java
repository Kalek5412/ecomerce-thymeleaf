package com.example.ecomerce.service;

import com.example.ecomerce.entity.Pedido;
import com.example.ecomerce.entity.Usuario;
import com.example.ecomerce.repository.PedidoRepository;
import com.example.ecomerce.service.serviceInterface.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PedidoServiceImpl implements PedidoService {

    @Autowired
    private PedidoRepository pedidoRepository;


    @Override
    public List<Pedido> findAll() {
        return pedidoRepository.findAll();
    }

    @Override
    public Optional<Pedido> findById(Long id) {
        return pedidoRepository.findById(id);
    }

    @Override
    public Pedido save(Pedido pedido) {
        return pedidoRepository.save(pedido);
    }

    @Override
    public String generarNumeroPedido() {
        int numero=0;
        String numeroConcatenado="";
        List<Pedido> ordenes = findAll();
        List<Integer> numeros= new ArrayList<Integer>();
        ordenes.stream().forEach(o -> numeros.add( Integer.parseInt( o.getNumero())));
        if (ordenes.isEmpty()) {
            numero=1;
        }else {
            numero= numeros.stream().max(Integer::compare).get();
            numero++;
        }
        if (numero<10) { //0000001000
            numeroConcatenado="000000000"+String.valueOf(numero);
        }else if(numero<100) {
            numeroConcatenado="00000000"+String.valueOf(numero);
        }else if(numero<1000) {
            numeroConcatenado="0000000"+String.valueOf(numero);
        }else if(numero<10000) {
            numeroConcatenado="0000000"+String.valueOf(numero);
        }
        return numeroConcatenado;
    }

    @Override
    public List<Pedido> findByUsuario(Usuario usuario) {
        return pedidoRepository.findByUsuario(usuario);
    }
}
