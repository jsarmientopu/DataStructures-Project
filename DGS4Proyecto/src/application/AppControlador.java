package application;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import datos.ArrayList;
import datos.Persona;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;


public class AppControlador implements Initializable {
	
	@FXML private Button btna;
	@FXML private Button btnProfesores;
	@FXML private Label lblUser;
	@FXML private Label lblProx;
	@FXML private Label lblTarea;
	@FXML private Label lblDescripcion;
	private Persona user;
	private ArrayList<Persona> personasRegistradas;
	
	public void setPersonasRegistradas(ArrayList<Persona> personasRegistradas) {
		this.personasRegistradas = personasRegistradas;
	}
	public void setUser(Persona user) {
		this.user = user;
		this.lblUser.setText(this.lblUser.getText().replaceFirst("Label", this.user.getNombre()));
		if(this.user.getTareas().isEmpty()) {
			this.lblProx.setText("No hay tareas próximas");
			this.lblTarea.setText(null);
			this.lblDescripcion.setText(null);
		}else {
			this.lblTarea.setText("Tarea: "+this.user.getTareas().getFrontElement().getNombre());
			this.lblDescripcion.setText(this.user.getTareas().getFrontElement().getContenido());	
		}
	}
	
	
	 @Override
	 public void initialize(URL url, ResourceBundle rb) {
		 //TODO
	 }
	 
	 public void irTarea(MouseEvent event) {
		 
		 try {
				FXMLLoader loader = new FXMLLoader(getClass().getResource("/vista/ventana-tareas.fxml"));
				Parent root = loader.load();
				VentanaTareas controlador = loader.getController();
				controlador.setPersonasRegistradas(this.personasRegistradas);
				controlador.setUser(this.user);
				Scene scene = new Scene(root);
				Stage stage = new Stage();
				stage.setScene(scene);
				stage.show();
				stage.setOnCloseRequest(e -> reOpen());
				Stage myStage = (Stage) this.btna.getScene().getWindow();
				myStage.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		 
	 }
	 
	 public void irProfesores(MouseEvent event) {
		 
		 try {
				FXMLLoader loader = new FXMLLoader(getClass().getResource("/vista/TablaProfesores.fxml"));
				Parent root = loader.load();
				ProfesoresControlador controlador = loader.getController();
				controlador.setPersonasRegistradas(this.personasRegistradas);
				controlador.setUser(this.user);
				Scene scene = new Scene(root);
				Stage stage = new Stage();
				stage.setScene(scene);
				stage.show();
				stage.setOnCloseRequest(e -> reOpen());
				Stage myStage = (Stage) this.btna.getScene().getWindow();
				myStage.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		 
	 }
	 
	 public void reOpen() {
			try {
				FXMLLoader loader = new FXMLLoader(getClass().getResource("/vista/App.fxml"));
				Parent root = loader.load();
				AppControlador controlador = loader.getController();
				controlador.setPersonasRegistradas(this.personasRegistradas);
				controlador.setUser(this.user);
				Scene scene = new Scene(root);
				Stage stage = new Stage();
				stage.setScene(scene);
				stage.setOnCloseRequest(e -> closeWindows());
				stage.show();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	
	 public void closeWindows() {
			try {
				FXMLLoader loader = new FXMLLoader(getClass().getResource("/vista/Vista.fxml"));
				Parent root = loader.load();
				Scene scene = new Scene(root);
				Stage stage = new Stage();
				stage.setScene(scene);
				stage.show();
				Stage myStage = (Stage) this.btna.getScene().getWindow();
				myStage.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
}
