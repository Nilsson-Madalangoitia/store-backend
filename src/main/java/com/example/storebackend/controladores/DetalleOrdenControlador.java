package com.example.storebackend.controladores;

import com.example.storebackend.modelos.DetalleOrden;
import com.example.storebackend.services.DetalleOrdenService;
import com.example.storebackend.util.WrapperResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orden")
@CrossOrigin(origins = "*")
public class DetalleOrdenControlador {

    private final DetalleOrdenService detalleOrdenService;

    public DetalleOrdenControlador(DetalleOrdenService detalleOrdenService) {
        this.detalleOrdenService = detalleOrdenService;
    }


    @PostMapping
    public ResponseEntity<WrapperResponse<DetalleOrden>> agregar(@RequestBody DetalleOrden detalleOrden){
        DetalleOrden newOrden = detalleOrdenService.agregar(detalleOrden);
        return new WrapperResponse<>(true,"success",newOrden).createResponse();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<WrapperResponse<Void>> eliminar(@PathVariable("id") Long id){
        detalleOrdenService.eliminar(id);
        return new WrapperResponse<Void>(true, "success", null)
                .createResponse(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/listar")
    public List<DetalleOrden> listar(){
        return detalleOrdenService.listar();
    }

    @GetMapping("/listar/{id}")
    public ResponseEntity<WrapperResponse<DetalleOrden>> listarPorId(@PathVariable("id") Long id){
        DetalleOrden detalleOrden = detalleOrdenService.listarPorId(id);
        return new WrapperResponse<>(true, "success", detalleOrden).createResponse(HttpStatus.OK);
    }

}
