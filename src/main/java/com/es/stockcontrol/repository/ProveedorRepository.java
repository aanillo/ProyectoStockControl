package com.es.stockcontrol.repository;

import com.es.stockcontrol.model.Proveedor;

import java.util.ArrayList;
import java.util.List;

public class ProveedorRepository {
    List<Proveedor> proveedores;

    public ProveedorRepository() {
        proveedores = new ArrayList<>();
    }
    public Proveedor get(Long id){
        Proveedor proveedorReturn = null;
        for (Proveedor p : proveedores) {
            if (p.getId()==id){
                proveedorReturn = p;
                break;
            }
        }
        return proveedorReturn;
    }
    public List<Proveedor>totalProveedores() {
        return proveedores;
    }
    public Proveedor insertProveedor(Proveedor p){
        proveedores.add(p);
        return get(p.getId());
    }
    public boolean deleteProveedor(Long id) {
        for (Proveedor p : proveedores) {
            if (p.getId()==id) {
                proveedores.remove(p);
                return true;
            }
        }
        return false;
    }
    

}

