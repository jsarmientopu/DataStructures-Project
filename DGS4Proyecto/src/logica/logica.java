package logica;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import datos.ArrayList;
import java.util.Date;
import java.util.Random;
import java.util.TreeMap;
import javax.swing.JButton;
import datos.Persona;
import datos.Profesor;
import datos.Stack;

public class logica {
		
	public static void guardarInfo( ArrayList<Persona> personas) {
			
		try {
			ObjectOutputStream escribir = new ObjectOutputStream(new FileOutputStream("Informacion.obj"));
			for(int i = 0; i < personas.size(); i++) {
				escribir.writeObject(personas.get(i));
			}
			escribir.close();
		}catch(Exception e) {
			System.out.print("mal");
			System.out.println(e);
		}
		
	}
	
	public static ArrayList<Persona> leer(){
		
		ArrayList<Persona> personasRegistradas = new ArrayList<Persona>();
		try {
			
			
//			ObjectOutputStream escribir = new ObjectOutputStream(new
//			FileOutputStream("Informacion.obj"));
//	
//			logica.guardarInfoDefault(escribir);
//		  
//			escribir.close();
		
			
			ObjectInputStream leer = new ObjectInputStream(new FileInputStream("Informacion.obj"));

			Object aux = leer.readObject();
			
			while(aux!=null) {
				if(aux instanceof Persona) {
					personasRegistradas.add((Persona)aux);
				}
				aux=leer.readObject();
				
			}
			leer.close();
		}catch(Exception f) {
		}
		return personasRegistradas;
	}
	
	public static ArrayList<Profesor> leerProfe() {
		ArrayList<Profesor> profesoresPrograma = new ArrayList<Profesor>();
		try {
			ObjectInputStream leer = new ObjectInputStream(new FileInputStream("Profesores.obj"));

			Object aux = leer.readObject();
			
			while(aux!=null) {
				if(aux instanceof Profesor) {
					profesoresPrograma.add((Profesor)aux);
				}
				aux=leer.readObject();
			}
			leer.close();
		}catch(Exception e) {
		}
		return profesoresPrograma;
	}
		
	public static void guardarProfe(ArrayList<Profesor> profesoresRegistrados) {
		try {
			ObjectOutputStream escribir = new ObjectOutputStream(new FileOutputStream("Profesores.obj"));
			for(int i = 0; i<profesoresRegistrados.size();i++) {
				escribir.writeObject(profesoresRegistrados.get(i));
			}
			escribir.close();
		}catch(Exception e) {
			System.out.print("FALLO EN GUARDADO");
		}
	}
	
	public static ArrayList<Profesor> guardarInfoDefault(ArrayList<Profesor> profesores){
		Profesor P1 = new Profesor("Jhon Alexander", "Lopez Fajardo","Estructuras de Datos" );
        Profesor P2 = new Profesor("Arcenio", "Pecha Castiblanco","Calculo Integral" );
        Profesor P3 = new Profesor("Jhonatan", "Gomez","Programacion de computadores" );
        Profesor P4= new Profesor("Charles", "Xavier","Control Mental I" );
        Profesor P5 = new Profesor("Ivan", "Duque","Como no gobernar Colombia" );
        Profesor P6 = new Profesor("Carlo", "Ancelotti","Remontadas I" );
        profesores.add(P1);
        profesores.add(P2);
        profesores.add(P3);
        profesores.add(P4);
        profesores.add(P5);
        profesores.add(P6);
        
        
        Stack<String> R1 = new Stack<String>();
        R1.push("Es el mejor profesor que he tenido en toda la carrera. Me encanta su clase");
        R1.push("De grande quiero ser como Jhon ");
        R1.push("Lo recomiendo muy buena clase");
        R1.push("Se aprende mucho sobre estructuras de datos");
        R1.push("Profe pongame 5.0 de definintiva porfa");
        P1.setResenas(R1);
        
        Stack<String> R2 = new Stack<String>();
        R2.push("Con pecha el 50 te acecha");
        R2.push("Con pecha el papa te sube como flecha");
        R2.push("Pecha es el mejor profesor de la historia");
        R2.push("Deja unos parciales muy faciles");
        
        P2.setResenas(R2);
        
        Stack<String> R3 = new Stack<String>();
        R3.push("Desde que vi con Jhonatan quiero hacer colchas durante toda mi vida");
        R3.push("Te sube mucho el autoestima con sus agradables comentarios");
        R3.push("No meta con el");
        
        P3.setResenas(R3);
        
        Stack<String> R4 = new Stack<String>();
        R4.push("Muy buena clase, Una lastima que no pueda caminar ");
        
     
        P4.setResenas(R4);
        
        Stack<String> R5 = new Stack<String>();
        R5.push("Excelente clase, te enseña con un lujo de detalles que es lo que no debes hacer para dirgir Colombia (o culaquier pais)");
        R5.push("Muy buena clase, pero me bajo nota por no colocar Colombia con P mayuscula :(");
        
        P5.setResenas(R5);
        
        Stack<String> R6 = new Stack<String>();
        R6.push("Muy bueno, gracias a el pude salvar el semestre en la ultima semana solo mascando chicle y levantando una ceja");
        
        P6.setResenas(R6);
        return profesores;
	}
	
}
