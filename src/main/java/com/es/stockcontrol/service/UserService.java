package com.es.stockcontrol.service;

import com.es.stockcontrol.model.User;
import com.es.stockcontrol.repository.UserRepository;
import com.es.stockcontrol.utils.Encrypt;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UserService {

    public UserRepository repository;

    public UserService() {
        repository = new UserRepository();
    }

    public User login(String nombre, String password) {
        if(password == null || password.isEmpty()){
            return null;
        }

        if(nombre == null || nombre.isEmpty()){
            return null;
        }

        if(nombre.length() > 15) return null;

        String regexNombre = "[a-zA-Z0-9]{1,15}$";
        Pattern p = Pattern.compile(regexNombre, Pattern.CASE_INSENSITIVE);
        Matcher m = p.matcher(nombre);
        if(!m.matches()) return null;

        String passHash = Encrypt.encrypPassword(password);

        return repository.login(nombre, password);
    }

    public List<User> getAllUsers() {
        List<User> lista = repository.getAllUsers();
        return lista;
    }
}
