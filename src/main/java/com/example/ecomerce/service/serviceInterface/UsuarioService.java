package com.example.ecomerce.service.serviceInterface;

import com.example.ecomerce.entity.Usuario;

import java.util.List;
import java.util.Optional;

public interface UsuarioService {
    Optional<Usuario> findById(Long id);
    List<Usuario> findAll();
    Usuario save (Usuario usuario);
    Optional<Usuario> findByEmail(String email);
}
