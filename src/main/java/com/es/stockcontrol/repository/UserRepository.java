package com.es.stockcontrol.repository;

import com.es.stockcontrol.model.Proveedor;
import com.es.stockcontrol.model.User;

import java.util.ArrayList;
import java.util.List;

public class UserRepository {

    private List<User> usuarios;

    public UserRepository(){
        usuarios = new ArrayList<>();
    }
    public User get(String password){
        User userReturn = null;
        for (User u : usuarios) {
            if (u.getPasword().equals(password)){
                userReturn = u;
                break;
            }
        }
        return userReturn;
    }
    public List<User>totalUsuarios() {
        return usuarios;
    }
    public User insertUser(User u){
        usuarios.add(u);
        return get(u.getPasword());
    }
    public boolean deleteUser(String password) {
        for (User u : usuarios) {
            if (u.getPasword().equals(password)) {
                usuarios.remove(u);
                return true;
            }
        }
        return false;
    }
}
