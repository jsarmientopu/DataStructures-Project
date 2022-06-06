package datos;

import java.io.Serializable;
import java.time.LocalDate;

public class Tarea implements Serializable{
    private String nombre;
    private String contenido;
    private LocalDate fechaEntrega;

    public Tarea(String nombre, String contenido, LocalDate fechaEntrega) {
        this.nombre = nombre;
        this.contenido = contenido;
        this.fechaEntrega = fechaEntrega;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    public LocalDate getFechaEntrega() {
        return fechaEntrega;
    }

    public void setFechaEntrega(LocalDate fechaEntrega) {
        this.fechaEntrega = fechaEntrega;
    }

    @Override
    public String toString() {
        return "Tarea{" +
                "nombre='" + nombre + '\'' +
                ", contenido='" + contenido + '\'' +
                ", fechaEntrega=" + fechaEntrega +
                '}';
    }
}
