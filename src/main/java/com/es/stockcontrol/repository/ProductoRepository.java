package com.es.stockcontrol.repository;

import com.es.stockcontrol.model.Producto;

import java.util.ArrayList;
import java.util.List;

public class ProductoRepository {

    private List<Producto> bbddProducto;

    public ProductoRepository(){
        bbddProducto = new ArrayList<>();
    }

    public Producto get(String nombre){
        Producto producto = null;

        for(Producto p : bbddProducto){
            if(p.getNombre().equals(nombre)){
                producto = p;
            }
        }
        return producto;
    }



    public Producto insert(Producto p) {
        bbddProducto.add(p);
        return get(p.getNombre());
    }

    public boolean delete(String nombre){
        for(Producto p : bbddProducto){
            if(p.getNombre().equals(nombre)){
                bbddProducto.remove(p);
            }
        }
        return true;
    }

    public Producto modify(String nuevoNombre){
        for(Producto p : bbddProducto){
            if(p.getNombre().equals(nuevoNombre)){
                p.setNombre(nuevoNombre);
                return p;
            }
        }
        return null;
    }

    public Producto modifyStock(int nuevoStock){
        for(Producto p : bbddProducto){
            if(p.getStock() >= 0){
                p.setStock(nuevoStock);
                return p;
            }
        }
        return null;
    }

    public List<Producto> getProductos() {
        return bbddProducto;
    }

}
