package controller;

import java.net.URL;
import java.util.Calendar;
import java.util.ResourceBundle;

import DAO.implementations.MySQLUtenteDAOImpl;
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
import model.Utente;

public class RegistrationPageController{
	
	ObservableList<String> sessi = FXCollections.observableArrayList("M","F","indefinito");
	
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
		if (all_ok) {
			
		Utente utente = new Utente.Builder().
				withmail(email.getText()).
				withnome(nome.getText()).
				withcognome(cognome.getText()).
				withluogo_di_nascita(citta.getText()).
				withdata_nascita(dataDiNascita.getValue().toString()).
				withsesso(sesso.getValue()).
				withpassword(password.getText()).build();	
			MySQLUtenteDAOImpl utentedao = new MySQLUtenteDAOImpl();
			if(utentedao.set_inserimento_utente(utente)) {
		
			
			Stage stage = (Stage) confermaReg.getScene().getWindow();
			stage.close();
			}
	}
	}
}
