package com.example.citafacil;

public abstract class Usuario {

    private String id;
    private String nombre;
    private String apellido;
    private String email;
    private String contrasena;
    private String telefono;
    private String direccion;

    public Usuario(String id, String nombre, String apellido, String email,
                   String contrasena, String telefono, String direccion) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.correo = email;
        this.contrasena = contrasena;
        this.telefono = telefono;
        this.direccion = direccion;
    }


    }
