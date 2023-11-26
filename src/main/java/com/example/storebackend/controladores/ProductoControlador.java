package com.example.storebackend.controladores;

import com.example.storebackend.modelos.Producto;
import com.example.storebackend.services.ProductoService;
import com.example.storebackend.util.WrapperResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/producto")
@CrossOrigin(origins = "*")
public class ProductoControlador {

    private final ProductoService productoService;

    public ProductoControlador(ProductoService productoService) {
        this.productoService = productoService;
    }

    @PostMapping
    public ResponseEntity<Producto> agregar(@RequestBody Producto producto){
        Producto newProducto = productoService.agregar(producto);
        return new ResponseEntity<Producto>(newProducto, HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<Producto> actualizar(@RequestBody Producto producto){
        Producto actualizarProducto = productoService.actualizar(producto);
        return new ResponseEntity<Producto>(actualizarProducto, HttpStatus.CREATED);
    }

    @GetMapping("/listar")
    public List<Producto> listar(){
        return productoService.listar();
    }

    @GetMapping("/listar/{id}")
    public ResponseEntity<WrapperResponse<Producto>> listarPorId(@PathVariable("id") Integer id){
        Producto producto = productoService.listarPorId(id);
        return new WrapperResponse<>(true, "success", producto).createResponse(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminar(@PathVariable("id") Integer id){
        productoService.eliminar(id);
        return new ResponseEntity<String >("Producto eliminado", HttpStatus.OK);
    }

}
