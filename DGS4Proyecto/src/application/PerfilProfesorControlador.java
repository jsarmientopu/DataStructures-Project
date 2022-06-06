package application;


import datos.Stack;
import datos.ArrayList;
import datos.Persona;
import datos.Profesor;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Modality;
import javafx.stage.Stage;



public class PerfilProfesorControlador implements Initializable {

    @FXML private Label labelNombre;
    @FXML private Label labelAsignatura;
    @FXML private Label labelResena;
    @FXML private Button btnAgregarR;
    @FXML private Button btnCerrar;
    private Profesor profesor;
    private ObservableList<Profesor> profesores;
    private ArrayList<Persona> personasRegistradas;
    private ArrayList<Profesor> profesoresRegistrados;
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
    
    public void initAtributes(ArrayList<Profesor> profesoresRegistrados, ObservableList<Profesor> profesores, Profesor p){
        this.profesores = profesores;
        this.profesor = p;
        this.labelNombre.setText(p.getNombre() +" "+ p.getApellido());
        this.labelAsignatura.setText(p.getAsignatura());
        this.labelResena.setText(ponerString(profesor.getResenas()));
        this.profesoresRegistrados=profesoresRegistrados;;
    }
    
    public String ponerString(Stack<String> resenas){
    	Stack<String> newResena = new Stack<String>();
    	newResena = resenas;
        String str = "";
        int tamano = newResena.size();
        for(int i = 0; i< tamano;i++ ){
          	str +="-"+newResena.get(i)+"\n";
        }
        return str;
    }
    
    @FXML
    private void agregarResena(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/Vista/Resena.fxml"));
            Parent root = loader.load();
            ResenaControlador controlador = loader.getController();
            controlador.initAtributes(this.profesoresRegistrados,this.labelResena, this.profesor);
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setScene(scene);
            stage.showAndWait();
            String r = controlador.devolverLabel();
            String pila = controlador.devolverResena();
            this.labelResena.setText(r);
        } catch (IOException ex) {
            	Logger.getLogger(ProfesoresControlador.class.getName()).log(Level.SEVERE, null, ex);             
        }
    }

    @FXML
    private void cerrar(ActionEvent event) {
        Stage stage = (Stage) this.btnCerrar.getScene().getWindow();
        stage.close();
    }
    
}
