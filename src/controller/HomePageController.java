package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Optional;

import DAO.implementations.MySQLPubblicazioneDAOImpl;
import DAO.implementations.MySQLRecensioneDAOImpl;
import DAO.implementations.MySQLUtenteDAOImpl;
import application.Main;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.DialogPane;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.effect.ColorAdjust;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import model.*;
public class HomePageController {
	@FXML
	private HBox topbar;
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
	private VBox bottoni;
	@FXML
	private Label cerca;
	@FXML
	private Label benvenuto;
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
	
	public static String titoloS = "";
	public static String nomeAutoreS = "";
	public static String cognomeAutoreS = "";
	public static String isbnS = "";
	public static String parolaChiaveS = "";
	
	private double xOffset = 0;
	private double yOffset = 0;
	
	
	@FXML
	public void initialize() {
		//if(LibraryUser.getLivello().contentEquals("base")) verificaRece.disableProperty().set(true);
		String nome = LibraryUser.getNome();
		String cognome = LibraryUser.getCognome();
		//String titolo = nome.substring(0, 1).toUpperCase() + nome.substring(1) + " " +cognome.substring(0, 1).toUpperCase() + cognome.substring(1);
		//benvenuto.setText("Benvenuto " + titolo + "!");
		
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
		
		topbar.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                xOffset = event.getSceneX();
                yOffset = event.getSceneY();
            }
        });
        topbar.setOnMouseDragged(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                Main.stage.setX(event.getScreenX() - xOffset);
                Main.stage.setY(event.getScreenY() - yOffset);
            }
        });
	}
	
	@FXML 
	private void handleCercaButton() throws Exception{
		titoloS = titolo.getText();
		nomeAutoreS = nomeAutore.getText();
		cognomeAutoreS = cognomeAutore.getText();
		isbnS = isbn.getText();
		parolaChiaveS = parolaChiave.getText();
		
		boolean all_empty = true;
		
		if (!(titoloS.isBlank())) {
			all_empty = false;
		}
		if (!(nomeAutoreS.isBlank())) {
			all_empty = false;
		}
		if (!(cognomeAutoreS.isBlank())) {
			all_empty = false;
		}
		if (!(isbnS.isBlank())) {
			all_empty = false;
		}
		if (!(parolaChiaveS.isBlank())) {
			all_empty = false;
		}
		
		if(all_empty) {
			cerca.setTextFill(Color.web("#ff0000"));
			cerca.setText("Specifica almeno un parametro di ricerca");
		} else {
		titolo.clear();
		nomeAutore.clear();
		cognomeAutore.clear();
		isbn.clear();
		parolaChiave.clear();
		Parent root = FXMLLoader.load(getClass().getResource("/view/PublicationSearchPage.fxml"));
		borderpane.setCenter(root); 
	}
	}
	
	@FXML
	private void handleCatalogoButton() throws Exception{
		Parent root = FXMLLoader.load(getClass().getResource("/view/AllPublicationsPage.fxml"));
		borderpane.setCenter(root);
	}
	
	@FXML
	private void handleNovitaButton() throws Exception{
		Parent root = FXMLLoader.load(getClass().getResource("/view/LastPublicationsPage.fxml"));
		borderpane.setCenter(root);
	}
	
	@FXML
	private void handleDisconnettiButton(ActionEvent event) throws Exception{
		
		Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
		DialogPane dialogPane = alert.getDialogPane();
		dialogPane.getStylesheets().add("/view/alert.css");
		alert.initStyle(StageStyle.UNDECORATED);
        alert.setTitle("LOG OUT");
        alert.setContentText("Sei sicuro di voler effettuare il log-out?");
        ButtonType buttonTypeOne = new ButtonType("SI");
        ButtonType buttonTypeCancel = new ButtonType("NO");
        alert.getButtonTypes().setAll(buttonTypeOne, buttonTypeCancel);
        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == buttonTypeOne){
            // ... user chose "One"
            try{
            	Parent root = FXMLLoader.load(getClass().getResource("/view/LoginPage.fxml"));
    			Scene scene = new Scene(root);
    			scene.setFill(Color.TRANSPARENT);
    			Main.stage.setScene(scene);
    			Main.stage.show();
    		} catch (Exception ex){
                ex.getStackTrace();
            }
        } else {
            // ... user chose CANCEL or closed the dialog
        }
    }
	
	/*@FXML
	/*private void handleApprovaRecensioneButton() throws IOException {
		if(LibraryUser.getLivello().equals("moderatore")) { 
			/*MySQLRecensioneDAOImpl dao = new MySQLRecensioneDAOImpl();
			Pubblicazione pubbl = new Pubblicazione.Builder().
			dao.set_inserimento_recensione(pubblicazione, recensione)
			
		} else {
			//eccezione
		}
	}*/
	
	/*@FXML
	private void handleRifiutaRecensioneButton() throws IOException {
		if(LibraryUser.getLivello().equals("moderatore")) { 
			/*MySQLRecensioneDAOImpl dao = new MySQLRecensioneDAOImpl();
			Pubblicazione pubbl = new Pubblicazione.Builder().
			dao.set_inserimento_recensione(pubblicazione, recensione)
			
		} else {
			//eccezione
		}
	} */
	
	private void load(String content) throws Exception {
	    Parent root = FXMLLoader.load(getClass().getResource(content));
	    borderpane.setCenter(root);
	}
	
}

	
