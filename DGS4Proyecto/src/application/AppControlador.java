package application;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;


public class AppControlador implements Initializable {
	
	@FXML
	private Button btna;
	
	
	
	 @Override
	 public void initialize(URL url, ResourceBundle rb) {
		 //TODO
	 }
	
	 public void closeWindows() {
			try {
				FXMLLoader loader = new FXMLLoader(getClass().getResource("/vista/Vista.fxml"));
				Parent root = loader.load();
				VistaControlador controlador = loader.getController();
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
