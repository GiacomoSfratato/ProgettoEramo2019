package controller;

import java.util.Date;

import DAO.implementations.MySQLPubblicazioneDAOImpl;
import DAO.implementations.MySQLRecensioneDAOImpl;
import DAO.implementations.MySQLUtenteDAOImpl;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.SplitPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import model.*;

public class AdministrationPageController {
	@FXML
	private Button verificaRecensioni;
	@FXML
	private Button storicoModifiche;
	@FXML
	private Button livelloUtente;
	@FXML
	private Button tipoUtente;
	@FXML
	private Button bottone1;
	@FXML
	private Button bottone2;
	@FXML
	AnchorPane pannellotabella;
	MySQLRecensioneDAOImpl recensioni = new MySQLRecensioneDAOImpl();
	MySQLPubblicazioneDAOImpl storico = new MySQLPubblicazioneDAOImpl();
	MySQLUtenteDAOImpl utenti = new MySQLUtenteDAOImpl();
	
	@FXML
	public void initialize() {
		bottone1.setVisible(false);
		bottone1.setDisable(true);
		
		bottone2.setVisible(false);
		bottone2.setDisable(true);
	}
	
	@FXML
	private void handleVerificaRecensione() throws Exception{
		ObservableList<Recensione> listarecensioni = recensioni.get_elenco_recensioni_attesa();
		TableColumn<Recensione, Integer> id_pubblicazione = new TableColumn<>("ID Pubblicazione");
		id_pubblicazione.setCellValueFactory(new PropertyValueFactory<>("id_pubblicazione"));
		
		TableColumn<Recensione, Integer> id_utente = new TableColumn<>("ID Utente");
		id_utente.setCellValueFactory(new PropertyValueFactory<>("id_utente"));
		
		TableColumn<Recensione, String> titolo = new TableColumn<>("Titolo");
		titolo.setCellValueFactory(new PropertyValueFactory<>("titolo"));
		
		TableColumn<Recensione, String> contenuto = new TableColumn<>("Recensione");
		contenuto.setCellValueFactory(new PropertyValueFactory<>("contenuto"));
		
		TableColumn<Recensione, String> approvazione = new TableColumn<>("Approvazione");
		approvazione.setCellValueFactory(new PropertyValueFactory<>("approvazione"));
		
		TableColumn<Recensione, Date> timestamp = new TableColumn<>("Data");
		timestamp.setCellValueFactory(new PropertyValueFactory<>("timestamp"));
		
		TableView<Recensione> tabrecensioni = new TableView<Recensione>();
		tabrecensioni.setItems(listarecensioni);
		tabrecensioni.getColumns().addAll(id_pubblicazione, id_utente, titolo, contenuto, approvazione, timestamp);
		tabrecensioni.getSortOrder().add(timestamp);
		pannellotabella.getChildren().clear();
		pannellotabella.getChildren().add(tabrecensioni);
		AnchorPane.setTopAnchor(tabrecensioni, 0.0);
		AnchorPane.setBottomAnchor(tabrecensioni, 0.0);
		AnchorPane.setRightAnchor(tabrecensioni, 0.0);
		AnchorPane.setLeftAnchor(tabrecensioni, 0.0);
		
		
		bottone1.setVisible(true);
		bottone1.setDisable(false);
		bottone1.setText("Accetta");
		
		bottone2.setVisible(true);
		bottone2.setDisable(false);
		bottone2.setText("Rifiuta");
		
		bottone1.setOnAction(e -> {
			Recensione selected = tabrecensioni.getSelectionModel().getSelectedItem();
			recensioni.set_verifica_recensione(selected, "approvata");
			tabrecensioni.setItems(recensioni.get_elenco_recensioni_attesa());
			tabrecensioni.getSortOrder().add(timestamp);
		});
		
		bottone2.setOnAction(e -> {
			Recensione selected = tabrecensioni.getSelectionModel().getSelectedItem();
			recensioni.set_verifica_recensione(selected, "rifiutata");
			tabrecensioni.setItems(recensioni.get_elenco_recensioni_attesa());
			tabrecensioni.getSortOrder().add(timestamp);
		});
	
	}
	
	@FXML
	private void handleStoricoModifiche(ActionEvent event) throws Exception{
		ObservableList<Storico> listarecensioni = storico.get_storico_modifiche();
		TableColumn<Storico, Integer> id_utente = new TableColumn<>("ID Utente");
		id_utente.setCellValueFactory(new PropertyValueFactory<>("id_utente"));
		
		TableColumn<Storico, Integer> id_pubblicazione = new TableColumn<>("ID Pubblicazione");
		id_pubblicazione.setCellValueFactory(new PropertyValueFactory<>("id_pubblicazione"));
		
		TableColumn<Storico, String> descrizione = new TableColumn<>("Descrizione");
		descrizione.setCellValueFactory(new PropertyValueFactory<>("descrizione"));
		
		TableColumn<Storico, Date> data = new TableColumn<>("Data");
		data.setCellValueFactory(new PropertyValueFactory<>("timestamp"));
		
		TableView<Storico> tabstorico = new TableView<Storico>();
		tabstorico.setItems(listarecensioni);
		tabstorico.getColumns().addAll(id_pubblicazione, id_utente, descrizione, data);
		tabstorico.getSortOrder().add(data);
		
		bottone1.setVisible(false);
		bottone1.setDisable(true);
		bottone2.setVisible(false);
		bottone2.setDisable(true);
		
		pannellotabella.getChildren().clear();
		pannellotabella.getChildren().add(tabstorico);
		AnchorPane.setTopAnchor(tabstorico, 0.0);
		AnchorPane.setBottomAnchor(tabstorico, 0.0);
		AnchorPane.setRightAnchor(tabstorico, 0.0);
		AnchorPane.setLeftAnchor(tabstorico, 0.0);
	}

	@FXML
	private void handleTipoUtente(ActionEvent event) throws Exception{
		ObservableList<Utente> listaUtenti = utenti.get_utenti();
		TableColumn<Utente, Integer> id_utente = new TableColumn<>("ID Utente");
		id_utente.setCellValueFactory(new PropertyValueFactory<>("id"));
		
		TableColumn<Utente, String> email = new TableColumn<>("Email");
		email.setCellValueFactory(new PropertyValueFactory<>("email"));
		
		TableColumn<Utente, String> nome = new TableColumn<>("Nome");
		nome.setCellValueFactory(new PropertyValueFactory<>("nome"));
		
		TableColumn<Utente, String> cognome = new TableColumn<>("Cognome");
		cognome.setCellValueFactory(new PropertyValueFactory<>("cognome"));
		
		TableColumn<Utente, Date> data = new TableColumn<>("Data");
		data.setCellValueFactory(new PropertyValueFactory<>("data_di_nascita"));
		
		TableColumn<Utente, String> tipo = new TableColumn<>("Tipo di utenza");
		tipo.setCellValueFactory(new PropertyValueFactory<>("tipo"));
		
		TableView<Utente> tabUtenti = new TableView<Utente>();
		tabUtenti.setItems(listaUtenti);
		tabUtenti.getColumns().addAll(id_utente, email, nome, cognome, data, tipo);
		tabUtenti.getSortOrder().add(id_utente);
		
		pannellotabella.getChildren().clear();
		pannellotabella.getChildren().add(tabUtenti);
		AnchorPane.setTopAnchor(tabUtenti, 0.0);
		AnchorPane.setBottomAnchor(tabUtenti, 0.0);
		AnchorPane.setRightAnchor(tabUtenti, 0.0);
		AnchorPane.setLeftAnchor(tabUtenti, 0.0);
		
		bottone1.setVisible(true);
		bottone1.setDisable(false);
		bottone1.setText("Attivo");
		
		bottone2.setVisible(true);
		bottone2.setDisable(false);
		bottone2.setText("Passivo");
		
		bottone1.setOnAction(e -> {
			Utente selected = tabUtenti.getSelectionModel().getSelectedItem();
			utenti.set_modifica_tipo_utente(selected, "attivo");
			tabUtenti.setItems(utenti.get_utenti());
			tabUtenti.getSortOrder().add(id_utente);
		});
		
		bottone2.setOnAction(e -> {
			Utente selected = tabUtenti.getSelectionModel().getSelectedItem();
			utenti.set_modifica_tipo_utente(selected, "passivo");
			tabUtenti.setItems(utenti.get_utenti());
			tabUtenti.getSortOrder().add(id_utente);
		});
	}
	
	@FXML
	private void handleLivelloUtente(ActionEvent event) throws Exception{
		ObservableList<Utente> listaUtenti = utenti.get_utenti();
		TableColumn<Utente, Integer> id_utente = new TableColumn<>("ID Utente");
		id_utente.setCellValueFactory(new PropertyValueFactory<>("id"));
		
		TableColumn<Utente, String> email = new TableColumn<>("Email");
		email.setCellValueFactory(new PropertyValueFactory<>("email"));
		
		TableColumn<Utente, String> nome = new TableColumn<>("Nome");
		nome.setCellValueFactory(new PropertyValueFactory<>("nome"));
		
		TableColumn<Utente, String> cognome = new TableColumn<>("Cognome");
		cognome.setCellValueFactory(new PropertyValueFactory<>("cognome"));
		
		TableColumn<Utente, Date> data = new TableColumn<>("Data");
		data.setCellValueFactory(new PropertyValueFactory<>("data_di_nascita"));
		
		TableColumn<Utente, String> livello = new TableColumn<>("Livello di autorit�");
		livello.setCellValueFactory(new PropertyValueFactory<>("livello"));
		
		TableView<Utente> tabUtenti = new TableView<Utente>();
		tabUtenti.setItems(listaUtenti);
		tabUtenti.getColumns().addAll(id_utente, email, nome, cognome, data, livello);
		tabUtenti.getSortOrder().add(id_utente);
		
		pannellotabella.getChildren().clear();
		pannellotabella.getChildren().add(tabUtenti);
		AnchorPane.setTopAnchor(tabUtenti, 0.0);
		AnchorPane.setBottomAnchor(tabUtenti, 0.0);
		AnchorPane.setRightAnchor(tabUtenti, 0.0);
		AnchorPane.setLeftAnchor(tabUtenti, 0.0);
		
		pannellotabella.getChildren().clear();
		pannellotabella.getChildren().add(tabUtenti);
		AnchorPane.setTopAnchor(tabUtenti, 0.0);
		AnchorPane.setBottomAnchor(tabUtenti, 0.0);
		AnchorPane.setRightAnchor(tabUtenti, 0.0);
		AnchorPane.setLeftAnchor(tabUtenti, 0.0);
		
		bottone1.setVisible(true);
		bottone1.setDisable(false);
		bottone1.setText("Moderatore");
		
		bottone2.setVisible(true);
		bottone2.setDisable(false);
		bottone2.setText("Base");
		
		bottone1.setOnAction(e -> {
			Utente selected = tabUtenti.getSelectionModel().getSelectedItem();
			utenti.set_modifica_livello_utente(selected, "moderatore");
			tabUtenti.setItems(utenti.get_utenti());
			tabUtenti.getSortOrder().add(id_utente);
		});
		
		bottone2.setOnAction(e -> {
			Utente selected = tabUtenti.getSelectionModel().getSelectedItem();
			utenti.set_modifica_livello_utente(selected, "base");
			tabUtenti.setItems(utenti.get_utenti());
			tabUtenti.getSortOrder().add(id_utente);
		});
	}
}
