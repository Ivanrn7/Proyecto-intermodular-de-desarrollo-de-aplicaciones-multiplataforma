package com.example.citafacil;

/*IVAN
Clase ABSTRACTA con los constructores y get/set de usuario
estos mismos atributos se pueden usar para negocio(id,direccion,etc)
 y para cliente(id,nombre,etc)*/



public abstract class Usuario {

    private String id;
    private String nombre;
    private String apellido;
    private String email;
    private String contrasena;
    private String telefono;
    private String direccion;

    public Usuario() {
    }
    public Usuario(String id, String nombre, String apellido, String email,
                   String contrasena, String telefono, String direccion) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.contrasena = contrasena;
        this.telefono = telefono;
        this.direccion = direccion;
    }
    public String getId(){
        return id
    }
    public void setId(String id) {
        this.id = id;
    }
    public string getNombre(){
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public string getApellido(){
        return apellido;
    }
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
    public string getEmail(){
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public string getContrasena(){
        return contrasena;
    }
    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }
    public string getTelefono(){
        return telefono;
    }
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
    public string getDireccion(){
        return direccion;
    }
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
}