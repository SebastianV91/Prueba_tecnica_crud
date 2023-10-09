package com.web.automotriz.Controller;

import com.web.automotriz.model.Usuario;
import com.web.automotriz.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/usuario")
public class UsuarioController {

    @Autowired
    UsuarioService usuarioService;

    @PostMapping("/login")
    public ResponseEntity<Map<String, String>> loginUser(@RequestBody Map<String, Object> userMap){
        String email = (String) userMap.get("email");
        String password = (String) userMap.get("password");
        Usuario usuario = usuarioService.validateUser(email, password);
        Map<String, String> map = new HashMap<>();
        map.put("message","loggedIn succesfully");
        return new ResponseEntity<>(map, HttpStatus.OK);
    }

    @PostMapping("/registro")
    public ResponseEntity<Map<String, String>> registroUsuario(@RequestBody Map<String, Object> userMap){
        String nombre = (String) userMap.get("nombre");
        String edad = (String) userMap.get("edad");
        String email = (String) userMap.get("email");
        String password = (String) userMap.get("password");
        Usuario usuario = usuarioService.registerUser(nombre, edad, email, password);
        Map<String, String> map = new HashMap<>();
        map.put("message", "registered successfully");
        return new ResponseEntity<>(map, HttpStatus.OK);
    }

}
