package controller;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Random;
import java.util.ResourceBundle;
import java.util.stream.Collectors;

import DAO.implementations.MySQLUtenteDAOImpl;
import application.Main;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.*;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import model.Utente;

// TODO: Auto-generated Javadoc
/**
 * The Class RegistrationPageController.
 */
public class RegistrationPageController{
	
	/** The sessi. */
	ObservableList<String> sessi = FXCollections.observableArrayList("M","F","indefinito");
	
	/** The lunghezza min password. */
	private final int LUNGHEZZA_MIN_PASSWORD = 8;
	
	/** The conferma reg. */
	@FXML
	private Button confermaReg;
	
	/** The annulla. */
	@FXML
	private Button annulla;
	
	/** The email. */
	@FXML
	private TextField email;
	
	/** The nome. */
	@FXML
	private TextField nome;
	
	/** The cognome. */
	@FXML
	private TextField cognome;
	
	/** The paese. */
	@FXML
	private ComboBox<String> paese;
	
	/** The data di nascita. */
	@FXML
	private DatePicker dataDiNascita;
	
	/** The sesso. */
	@FXML
	private ComboBox<String> sesso;
	
	/** The password. */
	@FXML
	private PasswordField password;
	
	/** The lista paesi. */
	private List<String> listaPaesi;
	
	/** The paesi. */
	String paesi = "src/view/file_di_testo/paesi.txt";
	
	/** The Constant GENERIC_USER_PIC. */
	final static String GENERIC_USER_PIC = "/view/immagini/avatars/generic-user.png";
	
	/** The Constant MALE_USER_PIC. */
	final static String MALE_USER_PIC = "/view/immagini/avatars/Male/boy.png";
	
	/** The Constant FEMALE_USER_PIC. */
	final static String FEMALE_USER_PIC = "/view/immagini/avatars/Female/girl.png";
	
	/** The utentedao. */
	MySQLUtenteDAOImpl utentedao = new MySQLUtenteDAOImpl();
	
	
	/**
	 * Initialize.
	 */
	@FXML
	public void initialize() {
		 Main.stage.setResizable(false);
		 
		 //Setto la ComboBox con i sessi
		 sesso.setItems(sessi);
		 
		 //Setto la ComboBox con i paesi da un file .txt
		 try {
			 listaPaesi = Files.lines(Paths.get(paesi)).collect(Collectors.toList());
			} catch (IOException e) {
				e.printStackTrace();
			}
			paese.setItems(FXCollections.observableArrayList(listaPaesi));
		}
	
	
	/**
	 * Conferma.
	 */
	@FXML
	public void conferma() {		
		//Check che i campi siano riempiti correttamente
		if (check_registrazione()) {
		Utente utente = new Utente.Builder().
				withmail(email.getText()).
				withnome(nome.getText()).
				withcognome(cognome.getText()).
				withluogo_di_nascita(paese.getValue()).
				withdata_nascita(dataDiNascita.getValue().toString()).
				withsesso(sesso.getValue()).
				withpassword(password.getText()).
				withpic(get_file_path()).
				build();
		
			if(utentedao.set_inserimento_utente(utente)) {
				Scene scene = Main.stage.getScene();
				Label label = (Label) scene.lookup("#errore");
				label.setTextFill(Color.web("#18d100"));
				label.setText("Registrazione avvenuta con successo!");
				Stage stage = (Stage) confermaReg.getScene().getWindow();
				stage.close();
			}
		}
	}
	
	/**
	 * Annulla.
	 */
	public void annulla() {
		//L'utente ha annullato la registrazione
		Stage stage = (Stage) annulla.getScene().getWindow();
		stage.close();
	}
	
	/**
	 * Check registrazione.
	 *
	 * @return true, if successful
	 */
	private boolean check_registrazione() {		//controlla che i campi siano validi
		boolean all_ok = true;
		if(nome.getText().isBlank()) {
			nome.setPromptText("Campo obbligatorio");
			all_ok = false;
		}
		
		if(cognome.getText().isBlank()) {
			cognome.setPromptText("Campo obbligatorio");
			all_ok = false;
		}
		
		if(paese.getValue() == null) {
			paese.setPromptText("Campo obbligatorio");
			all_ok = false;
		}
		
		if(dataDiNascita.getValue() == null) {
			dataDiNascita.setPromptText("Campo obbligatorio");
			all_ok = false;
		}
		
		if (password.getText().isBlank()) {
			password.setPromptText("Campo obbligatorio");
			all_ok = false;
		}
		
		if (password.getText().length() > 0 && password.getText().length() < LUNGHEZZA_MIN_PASSWORD) {
			password.clear();
			password.setPromptText("Minimo " + LUNGHEZZA_MIN_PASSWORD + " caratteri");
			all_ok = false;
		}
		
		if (email.getText().isBlank()) {
			email.setPromptText("Campo obbligatorio");
			all_ok = false;
		} 
		
		if(sesso.getValue() == null) {
			sesso.setPromptText("Campo obbligatorio");
			all_ok = false;
		}
		
		return all_ok;
	}

	
	/**
	 * Gets the file path.
	 *
	 * @return the file path
	 */
	private String get_file_path() {  //Setta l'immagine profilo di default in base al sesso scelto in fase di registrazione
		String pic = "";
		switch (sesso.getValue()) {
		case "M":
			pic = MALE_USER_PIC;
			break;
		case "F":
			pic = FEMALE_USER_PIC;
			break;
		case "indefinito":
			pic = GENERIC_USER_PIC;
			break;
		}
		return pic;
	}
	
}

