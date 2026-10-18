package com.example.citafacil;

public class Cliente extends Usuario{
    private String id;
    private String nombre;
    private String apellido;
    private String email;
    private String contrasena;
    private String telefono;
    private String direccion;

    public Cliente(String id, String nombre, String apellido, String email,
                   String contrasena, String telefono, String direccion) {
        super(id, nombre, apellido, email, contrasena, telefono, direccion);
    }
    public String getId(){
        return id;}
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
