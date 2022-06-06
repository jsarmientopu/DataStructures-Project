package datos;

import java.io.Serializable;

import datos.Stack;


public class Profesor implements Serializable{
    private String nombre;
    private String apellido;
    private String asignatura;
    private Stack<String> resenas;
    

    public Profesor(String nombre, String apellido, String asignatura) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.asignatura = asignatura;
        this.resenas = new Stack<String>();
        
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getAsignatura() {
        return asignatura;
    }

    public void setAsignatura(String asignatura) {
        this.asignatura = asignatura;
    }

    public Stack<String> getResenas() {
        return resenas;
    }

    public void setResenas(Stack<String> resenas) {
        this.resenas = resenas;
    }

    
    
    
    
}
