package com.es.stockcontrol.service;

import com.es.stockcontrol.model.User;
import com.es.stockcontrol.repository.UserRepository;

import java.util.List;

public class UserService {
    private UserRepository repository;


    public UserService() {
        this.repository = new UserRepository();
    }

    // Método para registrar un nuevo usuario
    public User insertUser(User u) {
        String username = u.getNombre_usuario();
        String password = u.getPasword();


        if (username == null || username.isEmpty() || password == null || password.isEmpty()) {
            return null;
        }


        for (User existingUser : repository.getAllUsers()) {
            if (existingUser.getNombre_usuario().equals(username)) {
                return null;
            }
        }


        repository.getAllUsers().add(u);
        return u;
    }

    // Método para obtener todos los usuarios
    public List<User> getAllUsers() {
        return repository.getAllUsers();
    }

    // Método para iniciar sesión (login)
    public User login(String nombre_usuario, String password) {
        if (nombre_usuario == null || nombre_usuario.isEmpty() || password == null || password.isEmpty()) {
            return null;  // Si alguno de los campos es inválido, retornar nulo
        }


        return repository.login(nombre_usuario, password);
    }

    // Método para eliminar un usuario por nombre de usuario
    public boolean deleteUser(String nombre_usuario) {
        if (nombre_usuario == null || nombre_usuario.isEmpty()) {
            return false;
        }


        List<User> users = repository.getAllUsers();
        for (User user : users) {
            if (user.getNombre_usuario().equals(nombre_usuario)) {
                users.remove(user);
                return true;
            }
        }

        return false;
    }

    // Método para modificar la contraseña de un usuario
    public boolean modifyPassword(String nombre_usuario, String nuevaPassword) {
        if (nombre_usuario == null || nombre_usuario.isEmpty() || nuevaPassword == null || nuevaPassword.isEmpty()) {
            return false;
        }


        List<User> users = repository.getAllUsers();
        for (User user : users) {
            if (user.getNombre_usuario().equals(nombre_usuario)) {

                user.setPasword(nuevaPassword);
                return true;
            }
        }

        return false;
    }
}


