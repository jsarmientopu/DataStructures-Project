package datos;

import java.io.Serializable;
import java.util.Date;

public class Persona implements Serializable{

	private String nombre;
	private String usuario;
	private String contrasenia;
	private Date fechaNacimiento;
	private long numeroContacto;
	private Queue<Tarea> Tareas;
	
	public Persona(String nombre, String usuario, String contrasenia, Date fechaNacimiento, long numeroContacto) {
		this.nombre = nombre;
		this.usuario = usuario;
		this.contrasenia = contrasenia;
		this.fechaNacimiento = fechaNacimiento;
		this.numeroContacto = numeroContacto;
		this.Tareas = new Queue<Tarea>();
	}
		
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	public String getContrasenia() {
		return contrasenia;
	}
	public void setContrasenia(String contrasenia) {
		this.contrasenia = contrasenia;
	}
	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}
	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}
	public long getNumeroContacto() {
		return numeroContacto;
	}
	public void setNumeroContacto(long numeroContacto) {
		this.numeroContacto = numeroContacto;
	}
	public Queue<Tarea> getTareas() {
		return Tareas;
	}
	public void setTareas(Queue<Tarea> tareas) {
		Tareas = tareas;
	}

	@Override
	public String toString() {
		return "Persona [nombre=" + nombre + ", usuario=" + usuario + ", contrasenia=" + contrasenia
				+ ", fechaNacimiento=" + fechaNacimiento + ", numeroContacto=" + numeroContacto 
				+ "]";
	}
	
	
}
