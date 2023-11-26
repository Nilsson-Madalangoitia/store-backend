package com.example.storebackend.services;

import com.example.storebackend.excepciones.ResourceNotFoundException;
import com.example.storebackend.modelos.DetalleOrden;
import com.example.storebackend.modelos.Orden;
import com.example.storebackend.modelos.Producto;
import com.example.storebackend.repositorios.DetalleOrdenRepositorio;
import com.example.storebackend.repositorios.ProductoRepositorio;
import com.example.storebackend.validator.DetalleOrdenValidator;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
@Service
public class DetalleOrdenService {

    private final DetalleOrdenRepositorio detalleOrdenRepositorio;
    private final ProductoRepositorio productoRepositorio;

    public DetalleOrdenService(DetalleOrdenRepositorio detalleOrdenRepositorio, ProductoRepositorio productoRepositorio) {
        this.detalleOrdenRepositorio = detalleOrdenRepositorio;
        this.productoRepositorio = productoRepositorio;
    }

    @Transactional
    public DetalleOrden agregar(DetalleOrden detalleOrden){
        DetalleOrdenValidator.validate(detalleOrden);
        double total=0;
        for(Orden item:detalleOrden.getItems()){
            Producto producto = productoRepositorio.findById(item.getProducto().getId())
                    .orElseThrow(()->new ResourceNotFoundException("No existe el producto "+item.getProducto().getId()));

            item.setPrice(producto.getPrice());
            item.setTotal(producto.getPrice()*item.getQuantity());
            total+= item.getTotal();
        }
        detalleOrden.setTotal(total);
        detalleOrden.setEstado("realizado");
        detalleOrden.getItems().forEach(line->line.setDetalleorden(detalleOrden));
        return detalleOrdenRepositorio.save(detalleOrden);
    }

    @Transactional(readOnly = true)
    public List<DetalleOrden> listar(){
        return detalleOrdenRepositorio.findAll();
    }

    @Transactional
    public void eliminar(Long id){
        detalleOrdenRepositorio.deleteById(id);
    }

    public DetalleOrden listarPorId(Long id){
        Optional<DetalleOrden> detalleOrden = detalleOrdenRepositorio.findById(id);
        return detalleOrden.orElseThrow(() -> new ResourceNotFoundException("Detale de orden no found"));
    }

}
