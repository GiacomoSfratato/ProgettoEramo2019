package controller;

import java.util.ArrayList;

import DAO.implementations.*;
import javafx.collections.FXCollections;
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
import javafx.stage.Stage;
import model.*;

// TODO: Auto-generated Javadoc
/**
 * The Class AllUsersPageController.
 */
public class AllUsersPageController {
	
	/** The anchorpane. */
	@FXML
	private AnchorPane anchorpane = new AnchorPane();
	
	/** The titolopagina. */
	@FXML
	private Label titolopagina;
	
	/** The lista 1. */
	@FXML
	private ListView<Button> lista1 = new ListView<Button>();
	
	/** The lista 2. */
	@FXML
	private ListView<Button> lista2 = new ListView<Button>();
	
	/** The pane. */
	@FXML
	private SplitPane pane = new SplitPane();
	
	/**
	 * Initialize.
	 */
	@FXML
	private void initialize(){
		titolopagina.setText("Ecco tutti gli utenti attualmente registrati:");
		settalista();
		
		
	}
	
	/**
	 * Settalista.
	 */
	@FXML
	private void settalista() {
		MySQLUtenteDAOImpl dao = new MySQLUtenteDAOImpl();
		ObservableList<Utente> list = dao.get_utenti();
		int i = 0;
		for(Utente u : list) {
			Image icon = new Image(getClass().getResourceAsStream("/view/immagini/user.png"));
            ImageView immagine = new ImageView(icon);
            immagine.setFitHeight(55);
            immagine.setPreserveRatio(true);
            Button b = new Button("", immagine);
            b.setPrefWidth(545);
            b.setAlignment(Pos.CENTER_LEFT);
            b.setTextFill(Color.web("#375fc6"));
            
            String datiAnagrafici = u.getNome() + " " + u.getCognome();
            b.setText("  " + datiAnagrafici + "\n  " + u.getData_di_nascita());
            b.setId("" + u.getId());
            b.getStylesheets().add("/view/css/buttonlist.css");
            b.setOnAction(new EventHandler<ActionEvent>() {
                public void handle(ActionEvent e) {
                    try {
                    	int idUtente = Integer.parseInt(b.getId());
                        UserPageController.setId(idUtente);
                        Parent root = FXMLLoader.load(getClass().getResource("/view/UserPage.fxml"));
                        Scene scene = anchorpane.getScene();
                        BorderPane borderpane = (BorderPane) scene.lookup("#borderpane");
                        borderpane.setRight(root);

                    } catch (Exception ex) {
                        ex.getStackTrace();
                    }

                }
            });
            if (i % 2 == 0) lista1.getItems().add(b);
            else lista2.getItems().add(b);
            i++;
        }
		}
	}