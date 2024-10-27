package com.es.stockcontrol.controller.impl;

import com.es.stockcontrol.controller.api.ProveedorControllerAPI;
import com.es.stockcontrol.model.Proveedor;
import com.es.stockcontrol.model.RespuestaHTTP;
import com.es.stockcontrol.service.ProveedorService;

import java.util.List;

public class ProveedorController implements ProveedorControllerAPI {
    private ProveedorService service;

    public ProveedorController(ProveedorService service){
        this.service = service;
    }
    public ProveedorController() {
        this.service = new ProveedorService();
    }


    @Override
    public RespuestaHTTP<List<Proveedor>> getProveedoresProducto(String idProducto) {
        try {
            List<Proveedor> proveedores = service.totalProveedores();
            return proveedores != null && !proveedores.isEmpty() ?
                    new RespuestaHTTP<>(200, "Proveedores del producto encontrados", proveedores) :
                    new RespuestaHTTP<>(404, "No se encontraron proveedores para el producto");
        } catch (Exception e) {
            return new RespuestaHTTP<>(500, "Error interno del servidor");
        }
    }

    @Override
    public RespuestaHTTP<List<Proveedor>> getTodosProveedores() {
        try {
            List<Proveedor> todosProveedores = service.totalProveedores();
            return todosProveedores != null && !todosProveedores.isEmpty() ?
                    new RespuestaHTTP<>(200, "Lista de todos los proveedores", todosProveedores) :
                    new RespuestaHTTP<>(404, "No se encontraron proveedores");
        } catch (Exception e) {
            return new RespuestaHTTP<>(500, "Error interno del servidor");
        }
    }
}
