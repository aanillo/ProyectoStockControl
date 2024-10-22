package com.es.stockcontrol.service;

import com.es.stockcontrol.model.Proveedor;
import com.es.stockcontrol.repository.ProveedorRepository;

public class ProveedorService {
    ProveedorRepository repository;

    public ProveedorService(){
        this.repository=new ProveedorRepository();
    }

    public ProveedorRepository getRepository(String nombre, int longitud, String direccion) {

        if (nombre != null && !nombre.isEmpty() && nombre.length() <= longitud && direccion != null && !direccion.isEmpty()) {

            return repository;
        }

        return null;
    }
    public Proveedor insertProveedor (Proveedor p){

        if (p.getNombre()!= null && !p.getNombre().isEmpty() && p.getNombre().length() <= longitud && direccion != null && !direccion.isEmpty()) {


        }

    }
}
