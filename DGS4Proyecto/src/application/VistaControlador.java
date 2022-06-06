package application;

import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.stage.Stage;
import logica.logica;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DialogPane;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import java.io.IOException;
import java.net.URL;
import java.util.Date;
import java.util.ResourceBundle;
import datos.ArrayList;
import datos.Persona;


public class VistaControlador implements Initializable{
	
	@FXML private Button btnLogIn;
	@FXML private PasswordField txtPassword;
	@FXML private TextField txtUser;
	@FXML private DialogPane errorDatos;
	@FXML private Hyperlink btnRegistro;
	
	private ArrayList<Persona> personasRegistradas;
	
	public  void setPersonasRegistradas() {
		ArrayList<Persona> personasRegistradas = logica.leer();
		Date fechaJuan = new Date(121, 4, 6);
		Persona Juan = new Persona("Juan Cardenas", "JuanCardenas123", "PKS896",fechaJuan, 313326954);
		Persona Juan1 = new Persona("Juan Cardenas", "juan1", "juan123",fechaJuan, 313326954l);
		Date fechaPedro = new Date(121, 4, 6);
		Persona Pedro = new Persona("Pedro Guio", "PedroGuio987", "MLS522",fechaPedro, 305259862);
		Date fechaAntonio = new Date(121, 4, 6);
		Persona Antonio= new Persona("Antonio Acosta", "AntonioACosta635", "QWE118",fechaAntonio, 314698653);
		Date fechaArturo = new Date(121, 4, 6);
		Persona Arturo= new Persona("Arturo Hernandez", "ArturoHernandez777", "ASD995",fechaArturo, 315665244);
		Date fechaHerminda = new Date(121, 4, 6);
		Persona Herminda = new Persona("Herminda Avila", "HermindaAvila986", "XFO571",fechaHerminda, 313554862);
		personasRegistradas.add(Juan);
		personasRegistradas.add(Juan1);
		personasRegistradas.add(Pedro);
		personasRegistradas.add(Antonio);
		personasRegistradas.add(Arturo);
		personasRegistradas.add(Herminda);
		this.personasRegistradas = personasRegistradas;
	}
	
	
	@FXML
	private void hola(MouseEvent event) {
		
		setPersonasRegistradas();
		
		String password = txtPassword.getText();
		String user = txtUser.getText();
		boolean validez = false;
		Persona user1 = null;
		
		for (int i = 0; i<this.personasRegistradas.size(); i++) {
			if(this.personasRegistradas.get(i).getUsuario().equals(user) && this.personasRegistradas.get(i).getContrasenia().equals(password)) {
				user1 = this.personasRegistradas.get(i);
				validez = true;
				break;
			}
		}
		
		if(validez) {
			ponerApp(user1);
		}else {
			try {
				FXMLLoader loader = new FXMLLoader(getClass().getResource("/vista/ErrorLogIn.fxml"));
				Parent root = loader.load();
				ErrorControlador controlador = loader.getController();
				controlador.setMessage("Datos ingresados inválidos, vuelva a intentarlo");
				controlador.setTitle("Error Inicio sesión");
				Scene scene = new Scene(root);
				Stage stage = new Stage();
				stage.setScene(scene);
				stage.show();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	@FXML
	private void irRegistro(Event event) {
		
		setPersonasRegistradas();
		
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/vista/Registro.fxml"));
			Parent root = loader.load();
			RegistroControlador controlador = loader.getController();
			controlador.setPersonasRegistradas(this.personasRegistradas);
			Scene scene = new Scene(root);
			Stage stage = new Stage();
			stage.setScene(scene);
			stage.show();
			stage.setOnCloseRequest(e -> reOpen());
			Stage myStage = (Stage) this.btnLogIn.getScene().getWindow();
			myStage.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public void ponerApp(Persona user) {
		
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/vista/App.fxml"));
			Parent root = loader.load();
			AppControlador controlador = loader.getController();
			controlador.setPersonasRegistradas(this.personasRegistradas);
			controlador.setUser(user);
			Scene scene = new Scene(root);
			Stage stage = new Stage();
			stage.setScene(scene);
			stage.show();
			stage.setOnCloseRequest(e -> reOpen());
			Stage myStage = (Stage) this.btnLogIn.getScene().getWindow();
			myStage.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void reOpen() {
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/vista/Vista.fxml"));
			Parent root = loader.load();
			Scene scene = new Scene(root);
			Stage stage = new Stage();
			stage.setScene(scene);
			stage.show();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	 @Override
	 public void initialize(URL url, ResourceBundle rb) {
		 //TODO
		 setPersonasRegistradas();
	 }

	

}
