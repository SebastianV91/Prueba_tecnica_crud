package com.web.automotriz.model;


public class Usuario {

    private Integer idusuario;

    private String nombre;

    private String edad;

    private String email;

    private String password;

    public Usuario(Integer idusuario, String nombre, String edad, String email, String password) {
        this.idusuario = idusuario;
        this.nombre = nombre;
        this.edad = edad;
        this.email = email;
        this.password = password;
    }

    public Integer getIdusuario() {
        return idusuario;
    }

    public void setIdusuario(Integer idusuario) {
        this.idusuario = idusuario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEdad() {
        return edad;
    }

    public void setEdad(String edad) {
        this.edad = edad;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
