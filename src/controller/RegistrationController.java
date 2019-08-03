package controller;

import java.net.URL;
import java.util.Calendar;
import java.util.ResourceBundle;

import application.Main;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.*;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class RegistrationController{
	
	ObservableList<String> sessi = FXCollections.observableArrayList("Maschio","Femmina","Altro");
	
	private final int LUNGHEZZA_MIN_PASSWORD = 8;
	@FXML
	private Button confermaReg;
	@FXML
	private TextField email;
	@FXML
	private TextField nome;
	@FXML
	private TextField cognome;
	@FXML
	private TextField citta;
	@FXML
	private DatePicker dataDiNascita;
	@FXML
	private ComboBox<String> sesso;
	@FXML
	private PasswordField password;
	
	@FXML
	public void initialize() {
		 Main.stage.setResizable(false);
		 sesso.setItems(sessi);
	}
	
	@FXML
	public void conferma() {
		boolean all_ok = true;
		
		if (password.getText() == null || password.getText().trim().isEmpty()) {
			password.setPromptText("Campo obbligatorio");
			all_ok = false;
		}
		
		if (password.getText().length() > 1 && password.getText().length() < LUNGHEZZA_MIN_PASSWORD) {
			password.setPromptText("La password deve avere minimo " + LUNGHEZZA_MIN_PASSWORD + " caratteri");
			all_ok = false;
		}
		
		if (email.getText() == null || email.getText().trim().isEmpty()) {
			email.setPromptText("Campo obbligatorio");
			all_ok = false;
		} 
		if (all_ok == true) {
		Stage stage = (Stage) confermaReg.getScene().getWindow();
		 stage.close();
	}
	}
}
