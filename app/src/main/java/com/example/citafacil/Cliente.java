package com.example.citafacil;

public class Cliente extends Usuario{
    private String id;
    private String nombre;
    private String apellido;
    private String email;
    private String contrasena;
    private String telefono;
    private String direccion;

    public Cliente(){}

    public Cliente(String id, String nombre, String apellido, String email,
                   String contrasena, String telefono, String direccion) {
        super(id, nombre, apellido, email, contrasena, telefono, direccion);
    }

}
