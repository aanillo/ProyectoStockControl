package com.es.stockcontrol.service;

import com.es.stockcontrol.model.Producto;
import com.es.stockcontrol.repository.ProductoRepository;

import java.time.LocalDate;

public class ProductoService {

    public ProductoRepository repository;

    public ProductoService(){
        this.repository = new ProductoRepository();
    }

    public Producto insert(Producto p) {
        String letrasCat = p.getCategoria().substring(0,2);
        String letrasNom = p.getNombre().substring(0,2);
        String strId = letrasCat.concat(letrasNom);

        if(!p.getId().equals(strId)){
            return null;
        }

        String categoria = p.getCategoria();
        if(categoria.length() > 50 || categoria.isEmpty() || categoria == null){
            return null;
        }

        String nombre = p.getNombre();
        if(nombre.length() > 50 || nombre.isEmpty() || nombre == null) {
            return null;
        }

        float precioSinIva = p.getPrecio_sin_iva();
        if(precioSinIva == 0) {
            return null;
        }

        float iva = 0.21f;
        float precioConIva = precioSinIva * (1 + iva);

        LocalDate fechaHoy = LocalDate.now();
        if(!p.getFecha_alta().equals(fechaHoy)) {
            return null;
        }

        String descripcion = p.getDescripcion();

        Producto producto = new Producto(strId, categoria, nombre, descripcion, precioSinIva, precioConIva, fechaHoy);
        return repository.insert(producto);
    }

    public Producto get(String id) {
        if(id == null || id.isEmpty()){
            return null;
        }

        return repository.get(id);
    }

    public boolean delete(String id){
        if(id == null || id.isEmpty()){
            return false;
        } else {
            repository.delete(id);
            return true;
        }
    }


    public boolean modifyName(String id, String nuevoNombre) {
        if (id == null || id.isEmpty()) {
            return false;
        }

        if (nuevoNombre == null || nuevoNombre.isEmpty() || nuevoNombre.length() > 50) {
            return false;
        }

        Producto productoExistente = repository.get(id);

        if (productoExistente == null) {
            return false;
        }

        productoExistente.setNombre(nuevoNombre);
        repository.modify(nuevoNombre);
        return true;
    }


}
