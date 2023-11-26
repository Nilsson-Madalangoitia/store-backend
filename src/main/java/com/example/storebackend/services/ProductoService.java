package com.example.storebackend.services;

import com.example.storebackend.modelos.Producto;

import java.util.List;

public interface ProductoService {

    Producto agregar(Producto producto);
    Producto actualizar(Producto producto);
    List<Producto> listar();
    Producto listarPorId(Integer id);
    void eliminar(Integer id);

}
