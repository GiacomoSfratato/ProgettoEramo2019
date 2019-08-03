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
		Stage stage = (Stage) confermaReg.getScene().getWindow();
		 stage.close();
	}

}
