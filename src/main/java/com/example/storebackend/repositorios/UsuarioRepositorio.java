package com.example.storebackend.repositorios;

import com.example.storebackend.modelos.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepositorio extends JpaRepository<Usuario, Long> {
    public Usuario findByUsername(String username);
}
