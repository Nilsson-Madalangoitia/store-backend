package com.example.storebackend.validator;

import com.example.storebackend.excepciones.IncorrectResourceRequestException;
import com.example.storebackend.modelos.DetalleOrden;
import com.example.storebackend.modelos.Orden;

public class DetalleOrdenValidator {

    public static void validate(DetalleOrden detalleOrden){
        if(detalleOrden.getItems()==null || detalleOrden.getItems().isEmpty()){
            throw new IncorrectResourceRequestException("item is null");
        }

        for(Orden line: detalleOrden.getItems()){
            if(line.getProducto()==null || line.getProducto().getId()==null){
                throw new IncorrectResourceRequestException("producto is null");
            }
            if(line.getQuantity()<=0){
                throw new IncorrectResourceRequestException("cantidad 0");
            }
        }
    }

}
