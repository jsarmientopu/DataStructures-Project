package application;

import java.net.URL;
import java.util.Date;
import java.util.ResourceBundle;
import datos.ArrayList;
import datos.Persona;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.input.MouseEvent;

public class Registro2Controlador implements Initializable{

	@FXML 
	private ArrayList<Persona> personasRegistradas;

    public void setPersonasRegistradas(ArrayList<Persona> personasRegistradas) {
        this.personasRegistradas = personasRegistradas;
    }
	
    
    
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
	}

}
