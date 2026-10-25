package com.example.citafacil;

public class Cliente extends Usuario {
    /*IVAN
    Como hereda de Usuario no hace falta poner atributos por que usa los mismos de quien hereda */
    public Cliente() {
        super();
    }

    public Cliente(String id,
                   String nombre,
                   String apellido,
                   String email,
                   String contrasena,
                   String telefono,
                   String direccion) {

        super(
                id,
                nombre,
                apellido,
                email,
                contrasena,
                telefono,
                direccion,
                "CLIENTE"
        );
    }
// metodo que permite mostrar toods los atributos en formato texto
    @Override
    public String toString() {
        return "Cliente{" +
                "id='" + getId() + '\'' +
                ", nombre='" + getNombre() + '\'' +
                ", apellido='" + getApellido() + '\'' +
                ", email='" + getEmail() + '\'' +
                ", telefono='" + getTelefono() + '\'' +
                ", direccion='" + getDireccion() + '\'' +
                '}';
    }
}