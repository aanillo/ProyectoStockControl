package com.es.stockcontrol.service;

import com.es.stockcontrol.model.Proveedor;
import com.es.stockcontrol.repository.ProveedorRepository;

import java.util.List;

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
        String nombre = p.getNombre();
        String direccion=p.getDireccion();
        if (p.getNombre()== null && p.getNombre().isEmpty() && p.getDireccion()== null && p.getDireccion().isEmpty()) {
            return null;
        }
        Proveedor nuevoProveedor= new Proveedor(nombre,direccion);
        p=nuevoProveedor;
        return nuevoProveedor;

    }
    public List<Proveedor> totalProveedores(){
        List<Proveedor>totalProveedores =repository.totalProveedores();
        for(Proveedor p: totalProveedores){
            return (List<Proveedor>) p;
        }
        return null;
    }
}
