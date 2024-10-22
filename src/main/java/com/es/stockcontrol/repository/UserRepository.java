package com.es.stockcontrol.repository;

import com.es.stockcontrol.model.Producto;
import com.es.stockcontrol.model.User;

import java.util.ArrayList;
import java.util.List;

public class UserRepository {

    List<User> bbddUsers;

    public UserRepository(){
        bbddUsers = new ArrayList<>();
    }

    public User login(String nombre, String password) {
        User user = null;

        for(User u : bbddUsers){
            if(u.getNombre_usuario().equals(nombre) && u.getPasword().equals(password)){
                user = u;
            }
        }
        return user;
    }

    public List<User> getAllUsers() {
        return bbddUsers;
    }
}
