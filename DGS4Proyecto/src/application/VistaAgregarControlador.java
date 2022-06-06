/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package application;

import datos.ArrayList;
import datos.Persona;
import datos.Profesor;
import datos.Stack;
import logica.logica;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class VistaAgregarControlador implements Initializable {

    @FXML private Button btnGuardar;
    @FXML private Button btnSalir;
    @FXML private TextField txtNombre;
    @FXML private TextField txtApellido;
    @FXML private TextField txtAsignatura;
    private Profesor profesor;
    private ObservableList<Profesor> profesores;
    private ArrayList<Persona> personasRegistradas;
    private Persona user;
    private ArrayList<Profesor> profesoresRegistrados;
    
    public void setPersonasRegistradas(ArrayList<Persona> personasRegistradas) {
		this.personasRegistradas = personasRegistradas;
	}
    public void setUser(Persona user) {
    	this.user = user;
    }
    public void setProfesoresRegistrados(ArrayList<Profesor> profesoresRegistrados) {
    	this.profesoresRegistrados = profesoresRegistrados;
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    public void initAtributes(ObservableList<Profesor> profesores){
        this.profesores = profesores;
    }
    
    public void initAtributes(ObservableList<Profesor> profesores, Profesor p){
        this.profesores = profesores;
        this.profesor = p;
        this.txtNombre.setText(p.getNombre());
        this.txtApellido.setText(p.getApellido());
        this.txtAsignatura.setText(p.getAsignatura());

    }

    @FXML private void guardar(ActionEvent event) {
        String nombre = this.txtNombre.getText();
        String apellido = this.txtApellido.getText();
        String asignatura = this.txtAsignatura.getText();
        Profesor p = new Profesor(nombre,apellido,asignatura);
        if(!profesores.contains(p)){
            //Modificar
            if (this.profesor != null){
               this.profesor.setNombre(nombre);
               this.profesor.setApellido(apellido);
               this.profesor.setAsignatura(asignatura);
               logica.guardarProfe(this.profesoresRegistrados);
            //Insertar    
            }else{
                this.profesor = p;
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setHeaderText(null);
                alert.setTitle("Informacion");
                alert.setContentText("Se ha añadido correctamente");
                alert.showAndWait();
            }
            Stage stage = (Stage) this.btnGuardar.getScene().getWindow();
            stage.close();
        }else{
        	Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setTitle("Error");
            alert.setContentText("La persona ya existe");
            alert.showAndWait();
        }
    }

    @FXML
    private void salir(ActionEvent event) {
        this.profesor = null;
        Stage stage = (Stage) this.btnGuardar.getScene().getWindow();
        stage.close();
    }

    public Profesor getProfesor() {
        return profesor;
    }
    
}
