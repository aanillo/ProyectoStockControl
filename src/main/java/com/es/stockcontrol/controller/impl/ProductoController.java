package com.es.stockcontrol.controller.impl;

import com.es.stockcontrol.controller.api.ProductoControllerAPI;
import com.es.stockcontrol.model.Producto;
import com.es.stockcontrol.model.RespuestaHTTP;
import com.es.stockcontrol.service.ProductoService;

import java.util.List;

public class ProductoController implements ProductoControllerAPI {

    private ProductoService service;

    public ProductoController() {
        this.service = new ProductoService();
    }

    @Override
    public RespuestaHTTP<Producto> altaProducto(Producto p) {
        try {
            // TODO: Implementar la logica de insertUserEmail
            Producto productoInsertado = service.insert(p);
            return productoInsertado != null ?
                    new RespuestaHTTP(200, "Producto "+ productoInsertado.getNombre() +" insertado", productoInsertado) :
                    new RespuestaHTTP(400, "Producto NO insertado");
        } catch (Exception e) {
            return new RespuestaHTTP(500, "Fatal internal Error");
        }
    }


    @Override
    public RespuestaHTTP<Producto> bajaProducto(String id) {

        try {
            // TODO: Implementar la logica de deleteUserEmail
            return service.delete(id) ?
                    new RespuestaHTTP(200, "Producto "+ id +" eliminado") :
                    new RespuestaHTTP(400, "Usuario NO eliminado");

        } catch (Exception e) {
            return new RespuestaHTTP(500, "Fatal internal Error");
        }
    }

    @Override
    public RespuestaHTTP<Producto> modificarNombreProducto(String id, String nuevoNombre) {
        try {
            return service.modifyName(id, nuevoNombre) ?
                    new RespuestaHTTP<>(200, "Nombre " + nuevoNombre + " modificado") :
                    new RespuestaHTTP<>(400, "Nombre no modificado");

        } catch (Exception e) {
            return new RespuestaHTTP(500, "Fatal internal Error");
        }

    }

    @Override
    public RespuestaHTTP<Producto> modificarStockProducto(String id, String nuevoStock) {
        return null;
    }

    @Override
    public RespuestaHTTP<Producto> getProducto(String id) {
        try {
            Producto productoEncontrado = service.get(id);
            return productoEncontrado != null ?
                    new RespuestaHTTP<>(200, "Producto " + id + " encontrado") :
                    new RespuestaHTTP<>(400, "Producto no obtenido");

        } catch (Exception e){
            return new RespuestaHTTP<>(500, "Fatal internal Error");
        }
    }

    @Override
    public RespuestaHTTP<List<Producto>> getProductosConStock() {
        try {
            List<Producto> productosConStock = service.getProductosConStock();
            return productosConStock != null ?
                    new RespuestaHTTP<>(200, "Productos con stock ") :
                    new RespuestaHTTP<>(400, "Productos no encontrados");

        } catch (Exception e){
            return new RespuestaHTTP<>(500, "Fatal internal Error");
        }
    }

    @Override
    public RespuestaHTTP<List<Producto>> getProductosSinStock() {
        try {
            List<Producto> productosSinStock = service.getProductosSinStock();
            return productosSinStock != null ?
                    new RespuestaHTTP<>(200, "Productos sin stock") :
                    new RespuestaHTTP<>(400, "Productos no encontrados");

        } catch (Exception e){
            return new RespuestaHTTP<>(500, "Fatal internal Error");
        }
    }
}
