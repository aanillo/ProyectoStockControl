package com.es.stockcontrol.service;

import com.es.stockcontrol.model.Producto;
import com.es.stockcontrol.repository.ProductoRepository;
import org.hibernate.procedure.ProcedureOutputs;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

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

        int stock = p.getStock();
        if(stock == 0){
            return null;
        }

        String descripcion = p.getDescripcion();

        Producto producto = new Producto(strId, categoria, nombre, descripcion, stock, precioSinIva, precioConIva, fechaHoy);
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


    public boolean modifyStock(String id, String nuevoStock) {
        if (id == null || id.isEmpty()) {
            return false;
        }

        if (nuevoStock == null || nuevoStock.isEmpty()) {
            return false;
        }

        Producto productoExistente = repository.get(id);

        if (productoExistente == null) {
            return false;
        }

        int stock = productoExistente.getStock();
        int newStock = Integer.parseInt(nuevoStock);
        int stockTotal = stock + newStock;
        productoExistente.setStock(stockTotal);
        repository.modifyStock(stockTotal);
        return true;
    }



    public Producto getConStock(String id, String categoria, String nombre, String descripcion, int stock, float precioSinIva, float precioConIva, LocalDate fechaHoy){
        if(id.isEmpty() || id == null){
            return null;
        }

        if(categoria.length() > 50 || categoria.isEmpty() || categoria == null){
            return null;
        }

        if(nombre.length() > 50 || nombre.isEmpty() || nombre == null) {
            return null;
        }


        if(precioSinIva == 0) {
            return null;
        }

        float iva = 0.21f;
        precioConIva = precioSinIva * (1 + iva);


        if(stock == 0){
            return null;
        }

        fechaHoy = LocalDate.now();

        Producto producto = new Producto(id, categoria, nombre, descripcion, stock, precioSinIva, precioConIva, fechaHoy);
        return repository.insert(producto);
    }

    public Producto getSinStock(String id, String categoria, String nombre, String descripcion, float precioSinIva, float precioConIva, LocalDate fechaHoy){
        if(id.isEmpty() || id == null){
            return null;
        }

        if(categoria.length() > 50 || categoria.isEmpty() || categoria == null){
            return null;
        }

        if(nombre.length() > 50 || nombre.isEmpty() || nombre == null) {
            return null;
        }


        if(precioSinIva == 0) {
            return null;
        }

        float iva = 0.21f;
        precioConIva = precioSinIva * (1 + iva);

        fechaHoy = LocalDate.now();

        Producto producto = new Producto(id, categoria, nombre, descripcion, precioSinIva, precioConIva, fechaHoy);
        return repository.insert(producto);
    }

    public List<Producto> getProductosConStock() {
        List<Producto> lista = repository.getProductos();
        List<Producto> listaConStock = new ArrayList<>();

        for(Producto p: lista){
            if(p.getStock() >= 0){
                listaConStock.add(p);
            }
        }
        return listaConStock;
    }

    public List<Producto> getProductosSinStock() {
        List<Producto> lista = repository.getProductos();
        List<Producto> listaSinStock = new ArrayList<>();

        for(Producto p: lista){
            if(p.getStock() == 0){
                listaSinStock.add(p);
            }
        }
        return listaSinStock;
    }
}
