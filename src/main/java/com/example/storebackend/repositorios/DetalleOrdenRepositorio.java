package com.example.storebackend.repositorios;

import com.example.storebackend.modelos.DetalleOrden;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DetalleOrdenRepositorio extends JpaRepository<DetalleOrden, Long> {
}
