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

public class UserPageController {
	private static int idUtente;
	@FXML private AnchorPane anchorpane;
	@FXML private ImageView pic;
	@FXML private Text nomeCognome;
	@FXML private Text nome;
	@FXML private Text cognome;
	@FXML private Text email;
	@FXML private Text sesso;
	@FXML private Text data_nascita;
	@FXML private Text luogo_nascita;
	@FXML private Text tipo;
	@FXML private Button elimina;
	@FXML private Button pubblicazioni;
	
	
	MySQLUtenteDAOImpl dao = new MySQLUtenteDAOImpl();
	Utente utente = dao.get_dati_utente(idUtente);
	private final String nomeSognomeS = utente.getNome() + " " + utente.getCognome();
	private final String nomeS = "Nome: " + utente.getNome();
	private final String cognomeS = "Cognome: " + utente.getCognome();
	private final String emailS = "Email: " + utente.getEmail();
	private final String sessoS = "Sesso: " + utente.getSesso();
	private final String data_nascitaS = "Data di nascita: " + utente.getData_di_nascita();
	private final String luogo_nascitaS = "Luogo di nascita: " + utente.getLuogo_di_nascita();
	private final String tipoS = "Tipo di utente: " + utente.getTipo();
	
	public void initialize() {
		if(LibraryUser.getLivello().equals("base") && LibraryUser.getId() != utente.getId()) {
			elimina.setDisable(true);
		}
		settaUserInfo();		
	}
	
	public static void setId (int id) {
		idUtente = id;
	}
	
	private void settaUserInfo() {
		Image icon = new Image(getClass().getResourceAsStream(utente.getPic()));
		pic.setImage(icon);
		nomeCognome.setText(utente.getNome() + " " + utente.getCognome());
		nome.setText(nomeS);
		cognome.setText(cognomeS);
		email.setText(emailS);
		sesso.setText(sessoS);
		data_nascita.setText(data_nascitaS);
		luogo_nascita.setText(luogo_nascitaS);
		tipo.setText(tipoS);
	}
	
	@FXML
    private void handleChiudiButton(ActionEvent event) throws Exception{
    	Scene scene = anchorpane.getScene();
        BorderPane borderpane = (BorderPane) scene.lookup("#borderpane");
        borderpane.setRight(null);
    }
	
	@FXML void handlePubblicazioniButton(ActionEvent event) throws Exception{
		UserPublicationsPageController.setID(idUtente);
		Parent root = FXMLLoader.load(getClass().getResource("/view/UserPublicationsPage.fxml"));
		Scene scene = anchorpane.getScene();
        BorderPane borderpane = (BorderPane) scene.lookup("#borderpane");
        borderpane.setCenter(root);
	}
	
	@FXML
	private void handleEliminaButton(ActionEvent event) throws Exception{
		dao.set_rimuovere_utente(utente);
		Scene scene = anchorpane.getScene();
        BorderPane borderpane = (BorderPane) scene.lookup("#borderpane");
        borderpane.setRight(null);
	}
}
