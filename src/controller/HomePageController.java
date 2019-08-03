package controller;

import java.io.IOException;
import java.util.Calendar;

import application.Main;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class HomePageController {
	
	@FXML
	private TextField email;
	@FXML
	private PasswordField password;
	@FXML
	private Button loginButton;
	@FXML
	private Button registrationButton;
	public static Stage stage;
	
	@FXML
	public void initialize() {
		 Main.stage.setResizable(false);
	}
	
	@FXML
	private void handleButtonAction() throws IOException {
		
		Parent root = FXMLLoader.load(getClass().getResource("/view/Registration.fxml"));
		Stage stage = new Stage();
		stage.setScene(new Scene(root, 385, 395));
		stage.showAndWait();
		
		
		/*Stage appStage;
	    Parent root;
	    
	    appStage=(Stage)registrationButton.getScene().getWindow();
        root=FXMLLoader.load(getClass().getResource("Registration.fxml"));
        Scene scene=new Scene(root);
        appStage.setScene(scene);
        appStage.show();*/
	   }
}
	
