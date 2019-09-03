package controller;

import java.sql.SQLException;

import DAO.implementations.MySQLPubblicazioneDAOImpl;
import DAO.implementations.MySQLUtenteDAOImpl;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Text;
import model.*;

// TODO: Auto-generated Javadoc
/**
 * The Class UserPageController.
 */
public class UserPageController {
	
	/** The id utente. */
	private static int idUtente;
	
	/** The anchorpane. */
	@FXML private AnchorPane anchorpane;
	
	/** The pic. */
	@FXML private ImageView pic;
	
	/** The nome cognome. */
	@FXML private Text nomeCognome;
	
	/** The nome. */
	@FXML private Text nome;
	
	/** The cognome. */
	@FXML private Text cognome;
	
	/** The email. */
	@FXML private Text email;
	
	/** The sesso. */
	@FXML private Text sesso;
	
	/** The data nascita. */
	@FXML private Text data_nascita;
	
	/** The luogo nascita. */
	@FXML private Text luogo_nascita;
	
	/** The tipo. */
	@FXML private Text tipo;
	
	/** The elimina. */
	@FXML private Button elimina;
	
	/** The pubblicazioni. */
	@FXML private Button pubblicazioni;
	
	
	/** The dao. */
	MySQLUtenteDAOImpl dao = new MySQLUtenteDAOImpl();
	
	/** The utente. */
	Utente utente = dao.get_dati_utente(idUtente);
	
	/** The nome cognome S. */
	private final String nomeCognomeS = utente.getNome() + " " + utente.getCognome();
	
	/** The nome S. */
	private final String nomeS = "Nome: " + utente.getNome();
	
	/** The cognome S. */
	private final String cognomeS = "Cognome: " + utente.getCognome();
	
	/** The email S. */
	private final String emailS = "Email: " + utente.getEmail();
	
	/** The sesso S. */
	private final String sessoS = "Sesso: " + utente.getSesso();
	
	/** The data nascita S. */
	private final String data_nascitaS = "Data di nascita: " + utente.getData_di_nascita();
	
	/** The luogo nascita S. */
	private final String luogo_nascitaS = "Luogo di nascita: " + utente.getLuogo_di_nascita();
	
	/** The tipo S. */
	private final String tipoS = "Tipo di utente: " + utente.getTipo();
	
	/**
	 * Initialize.
	 */
	public void initialize() {
		if(LibraryUser.getLivello().equals("base") && LibraryUser.getId() != utente.getId()) {
			elimina.setDisable(true);
		}
		settaUserInfo();		
	}
	
	/**
	 * Sets the id.
	 *
	 * @param id the new id
	 */
	public static void setId (int id) {
		idUtente = id;
	}
	
	/**
	 * Setta user info.
	 */
	private void settaUserInfo() {
		//Setto l'immagine del profilo
		Image icon = new Image(getClass().getResourceAsStream(utente.getPic()));
		pic.setImage(icon);
		
		//Setto le info dell'utente
		nomeCognome.setText(nomeCognomeS);
		nome.setText(nomeS);
		cognome.setText(cognomeS);
		email.setText(emailS);
		sesso.setText(sessoS);
		data_nascita.setText(data_nascitaS);
		luogo_nascita.setText(luogo_nascitaS);
		tipo.setText(tipoS);
	}
	
	/**
	 * Handle chiudi button.
	 *
	 * @param event the event
	 * @throws Exception the exception
	 */
	@FXML
    private void handleChiudiButton(ActionEvent event) throws Exception{
    	Scene scene = anchorpane.getScene();
        BorderPane borderpane = (BorderPane) scene.lookup("#borderpane");
        borderpane.setRight(null);
    }
	
	/**
	 * Handle pubblicazioni button.
	 *
	 * @param event the event
	 * @throws Exception the exception
	 */
	@FXML void handlePubblicazioniButton(ActionEvent event) throws Exception{
		UserPublicationsPageController.setID(idUtente);
		Parent root = FXMLLoader.load(getClass().getResource("/view/UserPublicationsPage.fxml"));
		Scene scene = anchorpane.getScene();
        BorderPane borderpane = (BorderPane) scene.lookup("#borderpane");
        borderpane.setCenter(root);
	}
	
	/**
	 * Handle elimina button.
	 *
	 * @param event the event
	 * @throws Exception the exception
	 */
	@FXML
	private void handleEliminaButton(ActionEvent event) throws Exception{
		dao.set_rimuovere_utente(utente);
		Scene scene = anchorpane.getScene();
        BorderPane borderpane = (BorderPane) scene.lookup("#borderpane");
        borderpane.setRight(null);
	}
}
