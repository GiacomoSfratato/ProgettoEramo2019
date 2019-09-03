package controller;

import DAO.implementations.*;
import application.Main;
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
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import model.*;

public class ChaptersPageController {
	@FXML
	private AnchorPane anchorpane = new AnchorPane();
	@FXML
	private ListView<Button> lista1 = new ListView<Button>();
	@FXML
	private SplitPane pane = new SplitPane();
	@FXML
	private Label titolopagina;
	private static int idOpera;
	Pubblicazione pubbl = new Pubblicazione.Builder().withid(idOpera).build();
	@FXML
	private void initialize(){
		titolopagina.setText("Ecco tutti i capitoli di quest'opera");
		settalista();
		
	}
	
	
	public static void setId (int id) {
		idOpera = id;
	}
	
	@FXML
	private void settalista() {
		MySQLPubblicazioneDAOImpl dao = new MySQLPubblicazioneDAOImpl();
		ObservableList<Capitolo> list = dao.get_capitoli_pubbl(pubbl);
		if(list.size() == 0) {
			pane.setOpacity(0);
			titolopagina.setText("Non ci sono capitoli per quest'opera");
		} else {
		for(Capitolo c : list) {
			Image icon = new Image(getClass().getResourceAsStream("/view/immagini/capitolo.png"));
            ImageView immagine = new ImageView(icon);
            immagine.setFitHeight(55);
            immagine.setPreserveRatio(true);
            Button b = new Button("", immagine);
            b.setPrefWidth(500);
            b.setAlignment(Pos.CENTER_LEFT);
            b.setTextFill(Color.web("#375fc6"));
            b.setText("  Capitolo " + c.getNumero()
            		+ "\n  Titolo: " + c.getTitolo()
            		);
            
            b.getStylesheets().add("/view/css/buttonlist.css");
            b.setDisable(true);
            b.setOpacity(1);
            lista1.getItems().add(b);
            lista1.setDisable(true);
            lista1.setOpacity(1);
        }
		}
	
	}
    
}