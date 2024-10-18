package com.es.stockcontrol.model;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "producto")
public class Producto {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "categoria", length = 10)
    private String categoria;

    @Column(name = "nombre", length = 50, nullable = false)
    private String nombre;

    @Column(name = "descripcion")
    private String descripcion;

    @Column(name = "precio_sin_iva", nullable = false)
    private float precio_sin_iva;

    @Column(name = "precio_con_iva", nullable = false)
    private float precion_con_iva;

    @Column(name = "fecha_alta", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date fecha_alta;

    @ManyToOne
    @JoinColumn(name = "proveedor_id")
    Proveedor proveedor;

    public Producto(){

    }

    public Producto(Long id, String categoria, String nombre, String descripcion, float precio_sin_iva, float precion_con_iva, Date fecha_alta, Proveedor proveedor) {
        this.id = id;
        this.categoria = categoria;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio_sin_iva = precio_sin_iva;
        this.precion_con_iva = precion_con_iva;
        this.fecha_alta = fecha_alta;
        this.proveedor = proveedor;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public float getPrecio_sin_iva() {
        return precio_sin_iva;
    }

    public void setPrecio_sin_iva(float precio_sin_iva) {
        this.precio_sin_iva = precio_sin_iva;
    }

    public float getPrecion_con_iva() {
        return precion_con_iva;
    }

    public void setPrecion_con_iva(float precion_con_iva) {
        this.precion_con_iva = precion_con_iva;
    }

    public Date getFecha_alta() {
        return fecha_alta;
    }

    public void setFecha_alta(Date fecha_alta) {
        this.fecha_alta = fecha_alta;
    }

    public Proveedor getProveedor() {
        return proveedor;
    }

    public void setProveedor(Proveedor proveedor) {
        this.proveedor = proveedor;
    }

    @Override
    public String toString() {
        return "Producto{" +
                "id=" + id +
                ", categoria='" + categoria + '\'' +
                ", nombre='" + nombre + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", precio_sin_iva=" + precio_sin_iva +
                ", precion_con_iva=" + precion_con_iva +
                ", fecha_alta=" + fecha_alta +
                ", proveedor=" + proveedor +
                '}';
    }
}
