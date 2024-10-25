package com.es.stockcontrol;

import com.es.stockcontrol.model.Producto;
import com.es.stockcontrol.model.Proveedor;
import com.es.stockcontrol.model.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        // Creo instancias de las clases para crear las tablas de la BBDD

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("UnidadMySQL");
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();

        List<Producto> productos = new ArrayList<>();
        Proveedor proveedor1 = new Proveedor("MárquezSA", "Gran Vía, Madrid", productos);
        Producto producto1 = new Producto("ROPCAM", "Ropa", "Camiseta", "Camiseta de marca Nike color negro", 20.00f, 12, LocalDate.now(), proveedor1);
        Producto producto2 = new Producto("DECJAR", "Decoración", "Jarrón", "Jarrón decorativo color azul" ,42.25f, 5 , LocalDate.now(), proveedor1);
        productos.add(producto1);
        productos.add(producto2);

        User user1 = new User("Mario", "m4ri0");

        em.persist(productos);
        em.persist(proveedor1);
        em.persist(user1);

        em.getTransaction().commit();
    }
}
