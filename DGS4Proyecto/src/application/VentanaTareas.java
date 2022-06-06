package application;

import datos.Tarea;
import datos.ArrayList;
import datos.Persona;
import datos.Queue;
import logica.logica;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class VentanaTareas implements Initializable {

    @FXML private Label lbNombre;
    @FXML private Label lbFecha;
    @FXML private Label lbDescripcion;
    @FXML private Button btnAgregar;
    @FXML private Button btnMostrar;
    @FXML private Button btnSalir;
    @FXML private Button btnVolver;
    @FXML private Button btnCompletar;
    @FXML private Label lbMateria;
    @FXML private Label dT;
    @FXML private TextField descripcion;
    @FXML private DatePicker fechas;
    @FXML private TextField nombre;
    @FXML private TextField txfMateria;
    @FXML private TableView<Tarea> tblTareas;
    @FXML private TableColumn<?, ?> clDescripcion;
    @FXML private TableColumn<?, ?> clNombre;
    private Queue<Tarea> colaTareas;
    private ObservableList<Tarea> obsTareas;
    private Persona user;
	private ArrayList<Persona> personasRegistradas;
	
	public void setPersonasRegistradas(ArrayList<Persona> personasRegistradas) {
		this.personasRegistradas = personasRegistradas;
	}    
    public void setUser(Persona user) {
    	this.user = user;
    	this.colaTareas = user.getTareas();
    }
    
    @FXML
    void btnAgregarAccion(ActionEvent event) {
    	
    	if((this.nombre.getText()!=null)&&(this.descripcion!=null)) {
    		Tarea tarea = new Tarea(this.nombre.getText(),this.descripcion.getText(),this.fechas.getValue());
            this.user.getTareas().put(tarea);
    		logica.guardarInfo(this.personasRegistradas);
            this.tblTareas.setItems(obsTareas);
            this.nombre.setText(null);
            this.descripcion.setText(null);
            this.fechas.setValue(null);
            this.txfMateria.setText(null);
    	}

    }
    @FXML
    void btnMostrarAccion(ActionEvent event) {
    	Queue<Tarea> colaNewTareas = this.colaTareas;
    	this.obsTareas = FXCollections.observableArrayList();;
        for(int i=0;i<colaNewTareas.size()+1;i++){
            Tarea t = colaNewTareas.remove();
            this.obsTareas.add(t);
            colaNewTareas.put(t);
        }
        tblTareas.setItems(obsTareas);
        this.tblTareas.setVisible(true);
        this.lbNombre.setVisible(false);
        this.lbDescripcion.setVisible(false);
        this.lbMateria.setVisible(false);
        this.lbFecha.setVisible(false);
        this.nombre.setVisible(false);
        this.txfMateria.setVisible(false);
        this.btnAgregar.setVisible(false);
        this.btnVolver.setVisible(true);
        this.btnMostrar.setVisible(false);
        this.btnCompletar.setVisible(true);

    }
    @FXML
    void btnVolverAccion(ActionEvent event) {
        obsTareas = FXCollections.observableArrayList();
        this.clNombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        this.clDescripcion.setCellValueFactory(new PropertyValueFactory<>("contenido"));
        this.tblTareas.setVisible(false);
        this.lbNombre.setVisible(true);
        this.lbDescripcion.setVisible(true);
        this.lbMateria.setVisible(true);
        this.lbFecha.setVisible(true);
        this.nombre.setVisible(true);
        this.txfMateria.setVisible(true);
        this.btnAgregar.setVisible(true);
        this.btnVolver.setVisible(false);
        this.btnMostrar.setVisible(true);
        this.btnCompletar.setVisible(false);

    }

    @FXML
    void btnSalirAccion(ActionEvent event) {
    	try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/vista/App.fxml"));
			Parent root = loader.load();
			AppControlador controlador = loader.getController();
			controlador.setUser(this.user);
			controlador.setPersonasRegistradas(this.personasRegistradas);
			Scene scene = new Scene(root);
			Stage stage = new Stage();
			stage.setScene(scene);
			stage.show();
			Stage myStage = (Stage) this.btnAgregar.getScene().getWindow();
			myStage.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }

    
    @FXML
    public void completarTarea(ActionEvent event) {
    	
    	if(this.colaTareas.isEmpty()==false) {
    		this.colaTareas.remove();
        	logica.guardarInfo(personasRegistradas);
        	btnMostrarAccion(event);
    	}    	
    }
    
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
    	
        this.obsTareas = FXCollections.observableArrayList();
        this.clNombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        this.clDescripcion.setCellValueFactory(new PropertyValueFactory<>("contenido"));
        this.nombre.setText(null);
        this.descripcion.setText(null);

    }

}