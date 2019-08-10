package controller;

import java.io.IOException;
import java.util.ArrayList;

import DAO.implementations.MySQLPubblicazioneDAOImpl;
import DAO.implementations.MySQLRecensioneDAOImpl;
import DAO.implementations.MySQLUtenteDAOImpl;
import application.Main;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import model.*;
public class HomePageController {
	@FXML
	private BorderPane borderpane;
	@FXML
	private Button novita;
	@FXML
	private Button modificateRecente;
	@FXML
	private Button catalogo;
	@FXML
	private Button catalogoRistampe;
	@FXML
	private Button inserisciPubbl;
	@FXML
	private Button dispDownload;
	@FXML
	private Button topUtenti;
	@FXML
	private Button utenti;
	@FXML
	private Button verificaRece;
	@FXML
	private Button visualizzaProf;
	@FXML
	private Button disconnetti;
	@FXML
	private Button cercaPubbl;
	@FXML
	private Button chiudi;
	@FXML
	private Button riduciaicona;
	@FXML
	private Label cerca;
	@FXML
	private TextField titolo;
	@FXML
	private TextField nomeAutore;
	@FXML
	private TextField cognomeAutore;
	@FXML
	private TextField isbn;
	@FXML
	private TextField parolaChiave;
	@FXML
	private TableView<Pubblicazione> tabella;
	@FXML
	public void initialize() {
		
	}
	
	@FXML
	private void handleCatalogoButton() throws Exception{
		Parent root = FXMLLoader.load(getClass().getResource("/view/PublicationSearchPage.fxml"));
		borderpane.setCenter(root);
		
		/*MySQLPubblicazioneDAOImpl dao = new MySQLPubblicazioneDAOImpl();
		tabella = new TableView<Pubblicazione>();
		tabella.setItems(dao.get_catalogo());
		
		TableColumn<Pubblicazione, String> colonnaTitolo = new TableColumn<>("Titolo");
		colonnaTitolo.setMinWidth(300);
		colonnaTitolo.setCellValueFactory(new PropertyValueFactory<>("titolo"));
		
		TableColumn<Pubblicazione, ArrayList<Autore>> colonnaAutori = new TableColumn<>("Autori");
		colonnaAutori.setMinWidth(200);
		colonnaAutori.setCellValueFactory(new PropertyValueFactory<>("autori"));
		
		TableColumn<Pubblicazione, String> colonnaEditore = new TableColumn<>("Editore");
		colonnaEditore.setMinWidth(200);
		colonnaEditore.setCellValueFactory(new PropertyValueFactory<>("editore"));
		
		TableColumn<Pubblicazione, String> colonnaData = new TableColumn<>("Data di pubblicazione");
		colonnaData.setMinWidth(200);
		colonnaData.setCellValueFactory(new PropertyValueFactory<>("data"));
		
		
		
		tabella.getColumns().addAll(colonnaTitolo , colonnaAutori, colonnaEditore, colonnaData);
		
		
		Parent root = FXMLLoader.load(getClass().getResource("/view/PublicationList.fxml"));
		Stage stage = new Stage();
		VBox vbox = new VBox();
		vbox.getChildren().addAll(tabella);
		Scene finestraTabella = new Scene(vbox);
		stage.setScene(finestraTabella);
		stage.showAndWait();
		
		System.out.println(dao.get_catalogo());
*/	
	}
	
	
	@FXML
	private void handleApprovaRecensioneButton() throws IOException {
		if(LibraryUser.getLivello().equals("moderatore")) { 
			/*MySQLRecensioneDAOImpl dao = new MySQLRecensioneDAOImpl();
			Pubblicazione pubbl = new Pubblicazione.Builder().
			dao.set_inserimento_recensione(pubblicazione, recensione)
			*/
		} else {
			//eccezione
		}
	}
	
	@FXML
	private void handleRifiutaRecensioneButton() throws IOException {
		if(LibraryUser.getLivello().equals("moderatore")) { 
			/*MySQLRecensioneDAOImpl dao = new MySQLRecensioneDAOImpl();
			Pubblicazione pubbl = new Pubblicazione.Builder().
			dao.set_inserimento_recensione(pubblicazione, recensione)
			*/
		} else {
			//eccezione
		}
	}
	
	private void load(String content) throws Exception {
	    Parent root = FXMLLoader.load(getClass().getResource(content));
	    borderpane.setCenter(root);
	}
	
}
