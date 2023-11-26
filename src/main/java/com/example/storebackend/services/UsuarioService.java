package com.example.storebackend.services;

import com.example.storebackend.modelos.Usuario;
import com.example.storebackend.modelos.UsuarioRol;

import java.util.Set;

public interface UsuarioService {
    public Usuario guardarUsuario(Usuario usuario, Set<UsuarioRol> usuariosRoles) throws Exception;

    public Usuario obtenerUsuario(String username);


    public void eliminarUsuario(Long usuarioId);
}
