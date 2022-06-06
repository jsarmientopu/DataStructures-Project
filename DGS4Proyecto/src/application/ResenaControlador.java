package application;

import datos.Stack;
import datos.ArrayList;
import datos.Persona;
import datos.Profesor;
import logica.logica;
import java.net.URL;
import java.util.HashSet;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class ResenaControlador implements Initializable {

    @FXML private TextArea txtResena;
    @FXML private Button btnGuardar;
    private Profesor profesor;
    private ObservableList<Profesor> profesores;
    private Label labelResena;
    private Stack resenas;
    private String resena;
    private ArrayList<Profesor> profesoresRegistrados;
    private ArrayList<Persona> personasRegistradas;
    private Persona user;
    
    public void setPersonasRegistradas(ArrayList<Persona> personasRegistradas) {
		this.personasRegistradas = personasRegistradas;
	}
    public void setUser(Persona user) {
    	this.user = user;
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       
    }
    
    public void initAtributes(ArrayList<Profesor> profesoresRegistrados, Label labelResena, Profesor profesorEvaluado){
        this.labelResena = labelResena;
        this.profesor = profesorEvaluado;   
        this.profesoresRegistrados = profesoresRegistrados;
    }
    public String devolverLabel(){
    	return labelResena.getText();
    }
    public String devolverResena(){
    	return this.txtResena.getText();
    }
    
    
    
    @FXML
    private void Guardar(ActionEvent event) {
        resena = this.txtResena.getText();
        this.profesor.getResenas().push(resena);
        logica.guardarProfe(this.profesoresRegistrados);
        this.labelResena.setText("-"+resena+"\n-"+this.labelResena.getText());
        Stage stage = (Stage) this.btnGuardar.getScene().getWindow();
        stage.close();
    }
    
}
