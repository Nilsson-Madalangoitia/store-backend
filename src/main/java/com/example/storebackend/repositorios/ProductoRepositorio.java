package com.example.storebackend.repositorios;

import com.example.storebackend.modelos.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductoRepositorio extends JpaRepository<Producto, Integer> {
}
