package controller;

import java.sql.SQLException;

import DAO.implementations.MySQLPubblicazioneDAOImpl;
import DAO.implementations.MySQLUtenteDAOImpl;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Text;
import model.*;

public class UserPageController {
	private static int idUtente;
	@FXML private AnchorPane anchorpane;
	@FXML private ImageView copertina;
	@FXML private Text titolo;
	@FXML private Text autori;
	private String autoriConc = "";
	@FXML private Text editori;
	@FXML private Text anno;
	@FXML private Text isbn;
	@FXML private Text inseritada;
	@FXML private Text descrizione;
	@FXML private Text capitoli;
	@FXML private Text likes;
	@FXML ImageView  likeButton;
	
	MySQLUtenteDAOImpl dao = new MySQLUtenteDAOImpl();
	Utente utente = dao.get_dati_utente(idUtente);
	
	public void initialize() {
		titolo.setText(utente.getNome() + " " + utente.getCognome());
	}
	
	public static void setId (int id) {
		idUtente = id;
	}
	
	@FXML
    private void handleChiudiButton(ActionEvent event) throws Exception{
    	Scene scene = anchorpane.getScene();
        BorderPane borderpane = (BorderPane) scene.lookup("#borderpane");
        borderpane.setRight(null);
    }
}
