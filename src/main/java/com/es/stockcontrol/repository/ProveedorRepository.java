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
    public List<Proveedor>totalProveedores()
}

