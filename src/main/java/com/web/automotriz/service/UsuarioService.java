package com.web.automotriz.service;

import com.web.automotriz.exceptions.EtAuthException;
import com.web.automotriz.model.Usuario;

public interface UsuarioService {

    Usuario validateUser(String email, String password) throws EtAuthException;

    Usuario registerUser(String nombre, String edad, String email, String password) throws EtAuthException;

}
