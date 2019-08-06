package controller;

import DAO.implementations.*;
import model.*;
import java.io.IOException;
import java.util.Calendar;

import application.Main;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class HomePageController {
	
	@FXML
	private Label errore;
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
	private void handleRegistrationButtonAction() throws IOException {
		
		Parent root = FXMLLoader.load(getClass().getResource("/view/Registration.fxml"));
		Stage stage = new Stage();
		stage.setScene(new Scene(root, 385, 395));
		stage.showAndWait();
		errore.setTextFill(Color.web("#18d100"));
		errore.setText("Registrazione completata con successo!");
		
		/*Stage appStage;
	    Parent root;
	    
	    appStage=(Stage)registrationButton.getScene().getWindow();
        root=FXMLLoader.load(getClass().getResource("Registration.fxml"));
        Scene scene=new Scene(root);
        appStage.setScene(scene);
        appStage.show();*/
	   }
	
	@FXML
	private void handleLoginButtonAction() throws IOException {
		MySQLUtenteDAOImpl dao = new MySQLUtenteDAOImpl();
		Utente loginUser = new Utente.Builder().withmail(email.getText()).withpassword(password.getText()).build();
		Utente checkedUser = dao.check_utente(loginUser);
		if(checkedUser.getEmail().isBlank()) { 
			errore.setText("Nome utente o password errata");
		} else {
			LibraryUser libraryuser = new LibraryUser(checkedUser.getEmail(), checkedUser.getPassword(), checkedUser.getLivello());
			System.out.println(libraryuser);
			Parent root = FXMLLoader.load(getClass().getResource("/view/MainProgram.fxml"));
			Scene scene = new Scene(root);
			Main.stage.setScene(scene);
			Main.stage.show();
		}
	}
}
	
