package com.example.ecomerce.service;

import com.example.ecomerce.entity.Producto;
import com.example.ecomerce.entity.Usuario;
import com.example.ecomerce.repository.UsuarioRepository;
import com.example.ecomerce.service.serviceInterface.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class UsuarioServiceImpl implements UsuarioService {
    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public Optional<Usuario> findById(Long id) {
        return usuarioRepository.findById(id);
    }

    @Override
    public List<Usuario> findAll() {
        return List.of();
    }

    @Override
    public Usuario save(Usuario usuario) {
        return null;
    }

    @Override
    public Optional<Usuario> findByEmail(String email) {
        return Optional.empty();
    }
}
