package application;

import java.awt.Button;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.DialogPane;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class ErrorControlador implements Initializable{
	
	@FXML private DialogPane errorDatos;
	
	public void setMessage(String message) {
		errorDatos.setContentText(message);
	}
	
	public void setTitle(String title) {
		errorDatos.setHeaderText(title);
	}
	
	@FXML public void closeError(MouseEvent event) {
		Stage myStage = (Stage) this.errorDatos.getScene().getWindow();
		myStage.close();
	}
	
	 @Override
	 public void initialize(URL url, ResourceBundle rb) {
		 //TODO
	 }

}
