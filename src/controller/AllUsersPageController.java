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
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import model.*;

public class AllUsersPageController {
	@FXML
	private AnchorPane anchorpane = new AnchorPane();
	@FXML
	private Label titolopagina;
	@FXML
	private ListView<Button> lista1 = new ListView<Button>();
	@FXML
	private ListView<Button> lista2 = new ListView<Button>();
	@FXML
	private SplitPane pane = new SplitPane();
	
	@FXML
	private void initialize(){
		titolopagina.setText("Ecco tutti gli utenti attualmente registrati:");
		settalista();
		
		
	}
	
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
            b.setPrefWidth(504);
            //b.setPrefHeight(58);
            b.setAlignment(Pos.CENTER_LEFT);
            b.setTextFill(Color.web("#375fc6"));
            
            String datiAnagrafici = u.getNome() + " " + u.getCognome();
            b.setText("  " + datiAnagrafici + "\n  " + u.getData_di_nascita());
            b.setId("" + u.getId());
            b.getStylesheets().add("/view/css/buttonlist.css");
            b.setOnAction(new EventHandler<ActionEvent>() {
                public void handle(ActionEvent e) {
                    try {
                    	int idOpera;
                        idOpera = Integer.parseInt(b.getId());
                        ViewPublicationController.setId(idOpera);
                        FXMLLoader fxmlLoader = new FXMLLoader();
                        fxmlLoader.setLocation(getClass().getResource("/view/UserPage.fxml"));
                        Scene scene = new Scene(fxmlLoader.load(), 525, 659);
                        Stage stage = new Stage();
                        stage.setTitle("Visualizza Opera");
                        stage.setScene(scene);
                        stage.show();

                        

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