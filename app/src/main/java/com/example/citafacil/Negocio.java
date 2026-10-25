package com.example.citafacil;

import java.time.LocalTime;
/*IVAN
Como hereda de Usuario solamente se añaden atributos propios de esta clase */
public class Negocio extends Usuario{
    private String cif;
    private String descripcion;
    private LocalTime horaInicio;
    private LocalTime horaFin;

    public Negocio() { super();}
    public Negocio(String cif,
                   String nombre,
                   String email,
                   String contrasena,
                   String telefono,
                   String direccion,
                   String descripcion,
                   LocalTime horaInicio,
                   LocalTime horaFin) {

        super(
                cif,           // id
                nombre,
                "",    // apellido vacío
                email,
                contrasena,
                telefono,
                direccion,
                "NEGOCIO"   // rol fijo
        );
        this.cif = cif;
        this.descripcion = descripcion;
        this.horaInicio = horaInicio;
        this.horaFin = horaFin;
    }


    public String getCif(){
        return cif;
    }
    public void setCif(String cif) {
        this.cif = cif;
        setId(cif);
    }
    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public LocalTime getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(LocalTime horaInicio) {
        this.horaInicio = horaInicio;
    }

    public LocalTime getHoraFin() {
        return horaFin;
    }

    public void setHoraFin(LocalTime horaFin) {
        this.horaFin = horaFin;
    }
// metodo que permite mostrar toods los atributos en formato texto
    @Override
    public String toString() {
        return "Negocio{" +
                "cif='" + cif + '\'' +
                ", nombre='" + getNombre() + '\'' +
                ", direccion='" + getDireccion() + '\'' +
                ", telefono='" + getTelefono() + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", email='" + getEmail() + '\'' +
                ", horaInicio=" + horaInicio +
                ", horaFin=" + horaFin +
                '}';
    }
}
