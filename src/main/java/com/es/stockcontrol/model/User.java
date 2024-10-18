package com.es.stockcontrol.model;

import jakarta.persistence.*;

@Entity
@Table(name= "usuario")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String nombre_usuario;
    @Column(name="pasword",length = 20,nullable = false)
    private String pasword;

    public User() {
    }

    public User(String nombre_usuario, String pasword) {
        this.nombre_usuario = nombre_usuario;
        this.pasword = pasword;
    }

    public String getNombre_usuario() {
        return nombre_usuario;
    }

    public void setNombre_usuario(String nombre_usuario) {
        this.nombre_usuario = nombre_usuario;
    }

    public String getPasword() {
        return pasword;
    }

    public void setPasword(String pasword) {
        this.pasword = pasword;
    }
}
