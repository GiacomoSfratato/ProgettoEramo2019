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
import javafx.scene.effect.ColorAdjust;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class LoginPageController {
	
	@FXML
	private Label errore;
	@FXML
	private Label titolopagina;
	@FXML
	private TextField email;
	@FXML
	private PasswordField password;
	@FXML
	private Button chiudi;
	@FXML
	private Button riduciaicona;
	@FXML
	private Button loginButton;
	@FXML
	private Button registrationButton;
	public static Stage stage;
	
	@FXML
	public void initialize() {
		ColorAdjust colorAdjust = new ColorAdjust();
        colorAdjust.setBrightness(-0.2);
        ColorAdjust colorAdjust2 = new ColorAdjust();
        colorAdjust2.setBrightness(-0.6);
		
		chiudi.setOnAction(e -> Main.stage.close());
		chiudi.setOnMouseEntered(e -> chiudi.getGraphic().setEffect(colorAdjust));
		chiudi.setOnMouseExited(e -> chiudi.getGraphic().setEffect(null));
		chiudi.setOnMousePressed(e -> chiudi.getGraphic().setEffect(colorAdjust2));
		
		riduciaicona.setOnAction(e -> Main.stage.setIconified(true));
		riduciaicona.setOnMouseEntered(e -> riduciaicona.getGraphic().setEffect(colorAdjust));
		riduciaicona.setOnMouseExited(e -> riduciaicona.getGraphic().setEffect(null));
		riduciaicona.setOnMousePressed(e -> riduciaicona.getGraphic().setEffect(colorAdjust2));
		
		loginButton.setOnMouseEntered(e -> loginButton.setStyle("-fx-background-color: #4688d4;"));
		loginButton.setOnMouseExited(e -> loginButton.setStyle("-fx-background-color: #52a2ff"));
		loginButton.setOnMousePressed(e -> loginButton.setStyle("-fx-background-color: #336196;"));
		
		registrationButton.setOnMouseEntered(e -> registrationButton.setStyle("-fx-background-color: #52bf39;"));
		registrationButton.setOnMouseExited(e -> registrationButton.setStyle("-fx-background-color: #65e848"));
		registrationButton.setOnMousePressed(e -> registrationButton.setStyle("-fx-background-color: #3e912c"));
		
		titolopagina.setText("Biblioteca Online");
		Main.stage.setResizable(false);
	}
	
	@FXML
	private void handleRegistrationButtonAction() throws IOException {
		
		Parent root = FXMLLoader.load(getClass().getResource("/view/RegistrationPage.fxml"));
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
			LibraryUser libraryuser = new LibraryUser(checkedUser.getEmail(), checkedUser.getPassword(), checkedUser.getLivello(), checkedUser.getNome(), checkedUser.getCognome());
			System.out.println(libraryuser);
			Parent root = FXMLLoader.load(getClass().getResource("/view/HomePage.fxml"));
			Scene scene = new Scene(root);
			Main.stage.setScene(scene);
			Main.stage.show();
		}

	}
}
	
