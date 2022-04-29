package application;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import datos.ArrayList;
import datos.Persona;
import datos.Usuario;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class RegistroControlador implements Initializable{

	@FXML private TextField txtName;
	@FXML private TextField txtApellido;
	@FXML private DatePicker date;
	@FXML private TextField txtContacto;
	@FXML private TextField txtUser;
	@FXML private TextField txtPassword;
	@FXML private TextField txtPassword2;
	@FXML private Button btnCont;
	private ArrayList<Persona> personasRegistradas;

    public void setPersonasRegistradas(ArrayList<Persona> personasRegistradas) {
        this.personasRegistradas = personasRegistradas;
    }
	
	@FXML private void continuar(Event event) {
		
		boolean validez = true;
		String password = txtPassword.getText();
		String password2 = txtPassword2.getText();
		String user = txtUser.getText();
		String name = txtName.getText();
		String apellido = txtApellido.getText();
		String contacto = txtContacto.getText();
		if(password.compareTo(password2)!=0||password.length()<5||user.equals("Usuario")||user.length()<4||name.equals("Nombres")||apellido.equals("Apellidos")||contacto.equals("Contacto")||contacto.length()<7) {
			validez = false;
		}	
		for(int i = 0; i<personasRegistradas.size(); i++) {
			if (personasRegistradas.get(i).getUsuario().equals(user)) {
				validez = false;
			}
		}
		if(validez) {
			irRegistro2();
		}else {
			ponerError();
		}
		
	}
	
	public void irRegistro2(){
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/vista/Registro2.fxml"));
			Parent root = loader.load();
			Registro2Controlador controlador = loader.getController();
			controlador.setPersonasRegistradas(personasRegistradas);
			Scene scene = new Scene(root);
			Stage stage = new Stage();
			stage.setScene(scene);
			stage.show();
			Stage myStage = (Stage) this.txtContacto.getScene().getWindow();
			myStage.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void ponerError() {
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/vista/ErrorLogIn.fxml"));
			Parent root = loader.load();
			ErrorControlador controlador = loader.getController();
			controlador.setMessage("Datos ingresados inválidos, tenga en cuenta las indicaciones (Puede ser que ese usuario ya exsista)");
			controlador.setTitle("Error datos registro");
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
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
	}

	
	
}
