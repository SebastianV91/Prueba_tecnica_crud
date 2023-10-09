package com.web.automotriz.service.impl;

import com.web.automotriz.exceptions.EtAuthException;
import com.web.automotriz.model.Usuario;
import com.web.automotriz.repository.UsuarioRepository;
import com.web.automotriz.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.regex.Pattern;

@Service
@Transactional
public class UsuarioServiceImpl implements UsuarioService {

    @Autowired
    UsuarioRepository usuarioRepository;

    @Override
    public Usuario validateUser(String email, String password) throws EtAuthException {
        return null;
    }

    @Override
    public Usuario registerUser(String nombre, String edad, String email, String password) throws EtAuthException {

        Pattern pattern = Pattern.compile("^(.+)@(.+)$");
        if(email != null) email = email.toLowerCase();
        if(!pattern.matcher(email).matches())
            throw new EtAuthException("Formato de email invalido");
        Integer count = usuarioRepository.getCountByEmail(email);
        if(count > 0)
            throw new EtAuthException("Email ya existente");
        Integer idusuario = usuarioRepository.create(nombre, edad, email, password);
        return usuarioRepository.findById(idusuario);
    }
}
