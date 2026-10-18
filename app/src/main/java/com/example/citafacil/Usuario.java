package com.example.citafacil;

public abstract class Usuario {

    private String id;
    private String nombre;
    private String apellido;
    private String correo;
    private String contrasena;
    private String email;
    private String telefono;
    private String direccion;

    public Usuario(String id, String nombre, String apellido, String correo,
                   String contrasena, String email, String telefono, String direccion) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.correo = correo;
        this.contrasena = contrasena;
        this.email = email;
        this.telefono = telefono;
        this.direccion = direccion;
    }


    }


}
