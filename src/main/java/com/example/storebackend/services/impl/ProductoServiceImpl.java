package com.example.storebackend.services.impl;

import com.example.storebackend.excepciones.ResourceNotFoundException;
import com.example.storebackend.modelos.Producto;
import com.example.storebackend.repositorios.ProductoRepositorio;
import com.example.storebackend.services.ProductoService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductoServiceImpl implements ProductoService {

    private final ProductoRepositorio productoRepositorio;

    public ProductoServiceImpl(ProductoRepositorio productoRepositorio) {
        this.productoRepositorio = productoRepositorio;
    }

    @Override
    public Producto agregar(Producto producto) {
        return productoRepositorio.save(producto);
    }

    @Override
    public Producto actualizar(Producto producto) {
        return productoRepositorio.save(producto);
    }

    @Override
    public List<Producto> listar() {
        return productoRepositorio.findAll();
    }

    @Override
    public Producto listarPorId(Integer id){
        Optional<Producto> plato = productoRepositorio.findById(id);
        return plato.orElseThrow(() -> new ResourceNotFoundException("Producto no found"));
    }
    @Override
    public void eliminar(Integer id) {
        productoRepositorio.deleteById(id);
    }

}
