package com.es.stockcontrol.controller.impl;

import com.es.stockcontrol.controller.api.ProveedorControllerAPI;
import com.es.stockcontrol.model.Proveedor;
import com.es.stockcontrol.model.RespuestaHTTP;
import com.es.stockcontrol.service.ProveedorService;

import javax.xml.ws.Service;
import java.util.List;

public class ProveedorController implements ProveedorControllerAPI {
    private ProveedorService service;
    public ProveedorController(){
        this.service=new ProveedorService();
    }
    @Override
    public RespuestaHTTP<List<Proveedor>> getProveedoresProducto(String idProducto) {

        return null;
    }

    @Override
    public RespuestaHTTP<List<Proveedor>> getTodosProveedores() {

        return null;
    }
}
