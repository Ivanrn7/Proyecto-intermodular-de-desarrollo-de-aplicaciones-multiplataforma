package com.example.citafacil;

public class Negocio extends Usuario{
    private String id;
    private String nombre;
    private String direccion;
    private String telefono;
    private String descripcion;
    private String email;
    private String contrasena;
    private String horario;

    public Negocio(){}
    public Negocio(String id, String nombre, String direccion, String telefono,
                   String descripcion, String email, String contrasena, String horario) {
        super(id, nombre, direccion, telefono, descripcion, email, contrasena, horario);
    }
    public String getId(){
        return id;
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
    public string getDireccion(){
        return direccion;
    }
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
    public string getTelefono(){
        return telefono;
    }
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
    public string getDescripcion(){
        return descripcion;
    }
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
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
    public string getHorario(){
        return horario;
    }
    public void setHorario(String horario) {
        this.horario = horario;
    }


}
