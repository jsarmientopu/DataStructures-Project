package application;

import datos.ArrayList;
import logica.logica;
import datos.Persona;
import datos.Profesor;
import datos.Stack;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author santy
 */
public class ProfesoresControlador implements Initializable {

    @FXML private TableView<Profesor> tblProfesores;
    @FXML private TableColumn colNombre;
    @FXML private TableColumn colApellido;
    @FXML private TableColumn colAsignatura;
    @FXML private TableColumn colInfo;
    @FXML private Button btnAgregar;
    @FXML private Button btnModificar;
    @FXML private Button btnEliminar;
    @FXML private Button btnPerfil;
    private TextField txtNombre;
    private TextField txtApellido;
    private TextField txtAsignatura;
    private ArrayList<Profesor> profesoresRegistrados;
    private ObservableList<Profesor> profesores;
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
        // TODO
    	this.profesoresRegistrados=logica.leerProfe();
    	ArrayList<Profesor> listProfe = this.profesoresRegistrados;
        this.profesores = FXCollections.observableArrayList();
    	for(int i = 0; i<listProfe.size();i++) {
    		this.profesores.add(listProfe.get(i));
    	}
    	this.tblProfesores.setItems(this.profesores);
        this.colNombre.setCellValueFactory(new PropertyValueFactory("nombre"));
        this.colApellido.setCellValueFactory(new PropertyValueFactory("apellido"));
        this.colAsignatura.setCellValueFactory(new PropertyValueFactory("asignatura"));
    }   
    
    @FXML
    private void seleccionar(MouseEvent event) {
        Profesor p = this.tblProfesores.getSelectionModel().getSelectedItem();
        
        
    }

    @FXML
    private void modificar(ActionEvent event) {
        Profesor p = this.tblProfesores.getSelectionModel().getSelectedItem();
        
	    if (p == null){
	        Alert alert = new Alert(Alert.AlertType.ERROR);
	        alert.setHeaderText(null);
	        alert.setTitle("Error");
	        alert.setContentText("Debes seleccionar un profesor para modificar");
        } else{
	        try {
	            FXMLLoader loader = new FXMLLoader(getClass().getResource("/vista/VistaAgregar.fxml"));
	            Parent root = loader.load();
	            VistaAgregarControlador controlador = loader.getController();
	            controlador.setPersonasRegistradas(this.personasRegistradas);
	            controlador.setUser(this.user);
	            controlador.initAtributes(profesores,p);
	            Scene scene = new Scene(root);
	            Stage stage = new Stage();
	            stage.initModality(Modality.APPLICATION_MODAL);
	            stage.setScene(scene);
	            stage.showAndWait();
	            Profesor aux = controlador.getProfesor();
	            if (aux!= null){
	                this.tblProfesores.refresh();
	            }      
	        } catch (IOException ex) {
	            Logger.getLogger(ProfesoresControlador.class.getName()).log(Level.SEVERE, null, ex);     
	        }
        }
    }

    @FXML
    private void eliminar(ActionEvent event) {
        Profesor p = this.tblProfesores.getSelectionModel().getSelectedItem();
        if (p == null){
	        Alert alert = new Alert(Alert.AlertType.ERROR);
	        alert.setHeaderText(null);
	        alert.setTitle("Error");
	        alert.setContentText("Debes seleccionar un profesor para modificar");
	        alert.showAndWait(); 
        } else{
	        this.profesores.remove(p);
	        this.tblProfesores.refresh();
	        Alert alert = new Alert(Alert.AlertType.INFORMATION);
	        alert.setHeaderText(null);
	        alert.setTitle("informacion");
	        alert.setContentText("El dato ha sido eliminado correctamente");
	        alert.showAndWait();
        }
    }

    @FXML
    private void agregar(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/vista/VistaAgregar.fxml"));
            Parent root = loader.load();
            VistaAgregarControlador controlador = loader.getController();
            controlador.setPersonasRegistradas(this.personasRegistradas);
            controlador.setProfesoresRegistrados(this.profesoresRegistrados);
            controlador.setUser(this.user);
            controlador.initAtributes(profesores);        
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setScene(scene);
            stage.showAndWait();
            Profesor p = controlador.getProfesor();
            if (p != null){
            	this.profesoresRegistrados.add(p);
            	this.profesores.add(p);
            	logica.guardarProfe(this.profesoresRegistrados);
            	tblProfesores.refresh();
            }      
        } catch (IOException ex) {
            Logger.getLogger(ProfesoresControlador.class.getName()).log(Level.SEVERE, null, ex);     
        }
    }
    

    @FXML
    private void verPerfil(ActionEvent event) {
        Profesor p = this.tblProfesores.getSelectionModel().getSelectedItem();
        if (p == null){
	        Alert alert = new Alert(Alert.AlertType.ERROR);
	        alert.setHeaderText(null);
	        alert.setTitle("Error");
	        alert.setContentText("Debes seleccionar un profesor para ver su perfil"); 
        } else{
	        try {
	            FXMLLoader loader = new FXMLLoader(getClass().getResource("/vista/PerfilProfesor.fxml"));
	            Parent root = loader.load();
	            PerfilProfesorControlador controlador = loader.getController();
	            controlador.setPersonasRegistradas(this.personasRegistradas);
	            controlador.setUser(this.user);
	            controlador.initAtributes(this.profesoresRegistrados, this.profesores,p);
	            Scene scene = new Scene(root);
	            Stage stage = new Stage();
	            stage.initModality(Modality.APPLICATION_MODAL);
	            stage.setScene(scene);
	            stage.showAndWait();
            } catch (IOException ex) {
            	Logger.getLogger(ProfesoresControlador.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
}
