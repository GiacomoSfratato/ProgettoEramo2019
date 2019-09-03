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
import javafx.scene.input.KeyCode;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import model.*;

// TODO: Auto-generated Javadoc
/**
 * The Class HomePageController.
 */
public class HomePageController {
	
	/** The topbar. */
	@FXML	private HBox topbar;
	
	/** The borderpane. */
	@FXML	private BorderPane borderpane;
	
	/** The novita. */
	@FXML	private Button novita;
	
	/** The modificate recente. */
	@FXML	private Button modificateRecente;
	
	/** The catalogo. */
	@FXML	private Button catalogo;
	
	/** The catalogo ristampe. */
	@FXML	private Button catalogoRistampe;
	
	/** The inserisci pubbl. */
	@FXML	private Button inserisciPubbl;
	
	/** The disp download. */
	@FXML	private Button dispDownload;
	
	/** The top utenti. */
	@FXML	private Button topUtenti;
	
	/** The utenti. */
	@FXML	private Button utenti;
	
	/** The verifica rece. */
	@FXML	private Button verificaRece;
	
	/** The visualizza prof. */
	@FXML	private Button visualizzaProf;
	
	/** The disconnetti. */
	@FXML	private Button disconnetti;
	
	/** The cerca pubbl. */
	@FXML	private Button cercaPubbl;
	
	/** The chiudi. */
	@FXML	private Button chiudi;
	
	/** The riduciaicona. */
	@FXML	private Button riduciaicona;
	
	/** The bottoni. */
	@FXML 	private VBox bottoni;
	
	/** The benvenuto. */
	@FXML	private Label benvenuto;
	
	/** The ricerca. */
	@FXML	private TextField ricerca;
	
	/** The ricerca S. */
	public static String ricercaS = "";
	
	/** The x offset. */
	private double xOffset = 0;
	
	/** The y offset. */
	private double yOffset = 0;
	
	
	/**
	 * Initialize.
	 *
	 * @throws Exception the exception
	 */
	@FXML
	public void initialize() throws Exception{
		if(LibraryUser.getLivello().contentEquals("base")) verificaRece.disableProperty().set(true);
		String nome = LibraryUser.getNome();
		String cognome = LibraryUser.getCognome();
		String titolo = nome.substring(0, 1).toUpperCase() + nome.substring(1) + " " +cognome.substring(0, 1).toUpperCase() + cognome.substring(1);
		benvenuto.setText("Benvenuto " + titolo);
		
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
		
		
		//Rendo la finestra trascinabile tramite le TopBar				
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
        
        //Carico la pagina delle pubblicazioni caricate di recente
        Parent root = FXMLLoader.load(getClass().getResource("/view/LastPublicationsPage.fxml"));
		borderpane.setCenter(root);
        
	}
	
	/**
	 * Handle cerca button.
	 *
	 * @throws Exception the exception
	 */
	@FXML 
	private void handleCercaButton() throws Exception{
		ricercaS = ricerca.getText();
		
		if(ricercaS.isBlank()) {
			ricerca.setStyle("-fx-prompt-text-fill: #ff3c2e;");
			ricerca.setPromptText("Specifica cosa vuoi cercare");
			ricerca.setOnMousePressed(e -> ricerca.setPromptText(""));
		} else {
		ricerca.clear();
		Parent root = FXMLLoader.load(getClass().getResource("/view/PublicationSearchPage.fxml"));
		borderpane.setCenter(root); 
	}
	}
	
	/**
	 * Handle catalogo button.
	 *
	 * @throws Exception the exception
	 */
	@FXML
	private void handleCatalogoButton() throws Exception{
		Parent root = FXMLLoader.load(getClass().getResource("/view/AllPublicationsPage.fxml"));
		borderpane.setCenter(root);
	}
	
	/**
	 * Handle novita button.
	 *
	 * @throws Exception the exception
	 */
	@FXML
	private void handleNovitaButton() throws Exception{
		Parent root = FXMLLoader.load(getClass().getResource("/view/LastPublicationsPage.fxml"));
		borderpane.setCenter(root);
	}
	
	/**
	 * Handle disconnetti button.
	 *
	 * @param event the event
	 * @throws Exception the exception
	 */
	@FXML
	private void handleDisconnettiButton(ActionEvent event) throws Exception{
		
		Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
		DialogPane dialogPane = alert.getDialogPane();
		dialogPane.getStylesheets().add("/view/css/alert.css");
		alert.initStyle(StageStyle.UNDECORATED);
		alert.setGraphic(null);
        alert.setContentText("Sei sicuro di voler effettuare il log-out?");
        ButtonType buttonTypeOne = new ButtonType("SI");
        ButtonType buttonTypeCancel = new ButtonType("NO");
        alert.getButtonTypes().setAll(buttonTypeOne, buttonTypeCancel);
        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == buttonTypeOne){
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
            //l'utente ha scelto "NO"
        }
    }
	
	/**
	 * Handle disp download button.
	 *
	 * @param event the event
	 * @throws Exception the exception
	 */
	@FXML
	private void handleDispDownloadButton(ActionEvent event) throws Exception{
		Parent root = FXMLLoader.load(getClass().getResource("/view/DispDownloadPublicationsPage.fxml"));
		borderpane.setCenter(root);
	}
	
	/**
	 * Handle utenti button.
	 *
	 * @param event the event
	 * @throws Exception the exception
	 */
	@FXML
	private void handleUtentiButton(ActionEvent event) throws Exception{
		Parent root = FXMLLoader.load(getClass().getResource("/view/AllUsers.fxml"));
		borderpane.setCenter(root);
	}
	
	/**
	 * Handle top utenti button.
	 *
	 * @param event the event
	 * @throws Exception the exception
	 */
	@FXML
	private void handleTopUtentiButton(ActionEvent event) throws Exception{
		Parent root = FXMLLoader.load(getClass().getResource("/view/TopUsers.fxml"));
		borderpane.setCenter(root);
	}
	
	/**
	 * Handle user click.
	 *
	 * @throws Exception the exception
	 */
	public void handleUserClick () throws Exception {
		Parent root = FXMLLoader.load(getClass().getResource("/view/TopUsers.fxml"));
		borderpane.setCenter(root);
	}
	
	/**
	 * Handle profilo button.
	 *
	 * @param event the event
	 * @throws Exception the exception
	 */
	public void handleProfiloButton(ActionEvent event) throws Exception{
		UserPageController.setId(LibraryUser.getId());
		Parent root = FXMLLoader.load(getClass().getResource("/view/UserPage.fxml"));
		borderpane.setRight(root);
	}
	
	/**
	 * Handle ristampe button.
	 *
	 * @param event the event
	 * @throws Exception the exception
	 */
	public void handleRistampeButton(ActionEvent event) throws Exception{
		Parent root = FXMLLoader.load(getClass().getResource("/view/ReprintedPublicationsPage.fxml"));
		borderpane.setCenter(root);
	}
	
	/**
	 * Handle modifiche button.
	 *
	 * @param event the event
	 * @throws Exception the exception
	 */
	public void handleModificheButton(ActionEvent event) throws Exception{
		Parent root = FXMLLoader.load(getClass().getResource("/view/UpdatedPublicationsPage.fxml"));
		borderpane.setCenter(root);
	}
	
	/**
	 * Handle amministrazione button.
	 *
	 * @param event the event
	 * @throws Exception the exception
	 */
	public void handleAmministrazioneButton(ActionEvent event) throws Exception{
		borderpane.setRight(null);
		Parent root = FXMLLoader.load(getClass().getResource("/view/AdministrationPage.fxml"));
		borderpane.setCenter(root);
	}
	
	/**
	 * Handle inserisci pubblicazione button.
	 *
	 * @param event the event
	 * @throws Exception the exception
	 */
	@FXML
	public void handleInserisciPubblicazioneButton(ActionEvent event) throws Exception{
		Parent root = FXMLLoader.load(getClass().getResource("/view/InsertPublication.fxml"));
		borderpane.setCenter(root);
	}
}

	
