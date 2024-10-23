package com.es.stockcontrol.controller.impl;


import com.es.stockcontrol.controller.api.UserControllerAPI;
import com.es.stockcontrol.model.RespuestaHTTP;
import com.es.stockcontrol.model.User;
import com.es.stockcontrol.service.UserService;

public class UserController implements UserControllerAPI {

    private UserService service;

    public UserController(){
        service = new UserService();
    }

    @Override
    public RespuestaHTTP<User> login(String userInput, String passInput) {
        try {
            User u = service.login(userInput, passInput);

            return u != null ?
                    new RespuestaHTTP<>(200, "Usuario " + userInput + " logueado con éxito", u) :
                    new RespuestaHTTP<>(400, "Usuario no encontrado");
        } catch (Exception e){
            return new RespuestaHTTP<>(500, "Fatal internal server");
        }
    }
}
