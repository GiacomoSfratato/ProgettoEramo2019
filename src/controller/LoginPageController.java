package controller;

import DAO.implementations.*;
import model.*;
import java.io.IOException;
import java.util.Calendar;

import application.Main;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.effect.ColorAdjust;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

// TODO: Auto-generated Javadoc
/**
 * The Class LoginPageController.
 */
public class LoginPageController {
	
	/** The topbar. */
	@FXML
	private HBox topbar;
	
	/** The errore. */
	@FXML
	private Label errore;
	
	/** The titolopagina. */
	@FXML
	private Label titolopagina;
	
	/** The email. */
	@FXML
	private TextField email;
	
	/** The password. */
	@FXML
	private PasswordField password;
	
	/** The chiudi. */
	@FXML
	private Button chiudi;
	
	/** The riduciaicona. */
	@FXML
	private Button riduciaicona;
	
	/** The login button. */
	@FXML
	private Button loginButton;
	
	/** The registration button. */
	@FXML
	private Button registrationButton;
	
	/** The x offset. */
	private double xOffset = 0;
    
    /** The y offset. */
    private double yOffset = 0;
	
	/** The stage. */
	public static Stage stage;
	
	/** The conferma. */
	public static String conferma;
	
	/**
	 * Initialize.
	 */
	@FXML
	public void initialize() {
		Main.stage.setResizable(false);
	
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
		
		loginButton.setOnMouseEntered(e -> loginButton.setStyle("-fx-background-color: #4688d4;"));
		loginButton.setOnMouseExited(e -> loginButton.setStyle("-fx-background-color: #52a2ff"));
		loginButton.setOnMousePressed(e -> loginButton.setStyle("-fx-background-color: #336196;"));
		
		registrationButton.setOnMouseEntered(e -> registrationButton.setStyle("-fx-background-color: #52bf39;"));
		registrationButton.setOnMouseExited(e -> registrationButton.setStyle("-fx-background-color: #65e848"));
		registrationButton.setOnMousePressed(e -> registrationButton.setStyle("-fx-background-color: #3e912c"));
		
		titolopagina.setText("Biblioteca Online");
		Main.stage.setResizable(false);
		
		//Rendo la finestra trascinabile tramite la TopBar
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
	
	/**
	 * Handle registration button action.
	 *
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	@FXML
	private void handleRegistrationButtonAction() throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("/view/RegistrationPage.fxml"));
		Stage stage = new Stage();
		stage.setScene(new Scene(root));
		stage.initStyle(StageStyle.UNDECORATED);
		stage.showAndWait();
	   }
	
	/**
	 * Handle login button action.
	 *
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	@FXML
	private void handleLoginButtonAction() throws IOException {
		//Check che i campi non siano vuoti
		if(email.getText().isBlank() || password.getText().isBlank()) {
			email.setStyle("-fx-prompt-text-fill: #ff3c2e;");
			email.setPromptText("Campo obbligatorio");
			password.setStyle("-fx-prompt-text-fill: #ff3c2e;");
			password.setPromptText("Campo obbligatorio");
		} else {
		//Check che l'utente sia iscritto e i dati inseriti siano giusti
		MySQLUtenteDAOImpl dao = new MySQLUtenteDAOImpl();
		Utente checkedUser = dao.check_utente(email.getText(),password.getText());
		if(checkedUser.getEmail().isBlank()) { 
			errore.setStyle("-fx-prompt-text-fill: #ff3c2e;");
			errore.setText("Nome utente o password errata");
		} else {
			LibraryUser libraryuser = new LibraryUser(checkedUser.getId(), checkedUser.getEmail(), checkedUser.getPassword(), checkedUser.getLivello(), checkedUser.getNome(), checkedUser.getCognome());
			System.out.println(libraryuser);
			Parent root = FXMLLoader.load(getClass().getResource("/view/HomePage.fxml"));
			Scene scene = new Scene(root);
			scene.setFill(Color.TRANSPARENT);
			Main.stage.setScene(scene);
			Main.stage.show();
		}

	}
  }
}	
