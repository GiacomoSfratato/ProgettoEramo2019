package controller;

import DAO.implementations.MySQLPubblicazioneDAOImpl;
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
import model.Pubblicazione;

public class ReprintedPublicationsPageController {
	@FXML
	private AnchorPane anchorpane = new AnchorPane();
	@FXML
	private ListView<Button> lista1 = new ListView<Button>();
	@FXML
	private ListView<Button> lista2 = new ListView<Button>();
	@FXML
	private SplitPane pane = new SplitPane();
	@FXML
	private Label titolopagina;
	
	@FXML
	private void initialize(){
		titolopagina.setText("Cercavi delle opere ristampate? Serviti pure:");
		settalista();
		
	}
	
	
	@FXML
	private void settalista() {
		MySQLPubblicazioneDAOImpl dao = new MySQLPubblicazioneDAOImpl();
		ObservableList<Pubblicazione> list = dao.get_catalogo_ristampa();
		int i = 0;
		for(Pubblicazione p : list) {
			Image icon = new Image(getClass().getResourceAsStream("/view/immagini/librocolor.png"));
            ImageView immagine = new ImageView(icon);
            immagine.setFitHeight(55);
            immagine.setPreserveRatio(true);
            Button b = new Button("", immagine);
            b.setPrefWidth(504);
            //b.setPrefHeight(58);
            b.setAlignment(Pos.CENTER_LEFT);
            b.setTextFill(Color.web("#375fc6"));
            
            
            b.setText("  " + p.getTitolo() + "\n  Editore: "
            		    + p.getEditore() + "\n  Ultima ristampa: "
            		    + p.getData());
            b.setId("" + p.getId());
            b.getStylesheets().add("/view/css/buttonlist.css");
            b.setOnAction(new EventHandler<ActionEvent>() {
                public void handle(ActionEvent e) {
                    try {
                    	
                    	int idOpera;
                        idOpera = Integer.parseInt(b.getId());
                        ViewPublicationController.setId(idOpera);
                        Parent root = FXMLLoader.load(getClass().getResource("/view/ViewPublicationPage.fxml"));
                        Scene scene = anchorpane.getScene();
                        BorderPane borderpane = (BorderPane) scene.lookup("#borderpane");
                        borderpane.setRight(root);
                        
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }

                }
            });
            if (i % 2 == 0) lista1.getItems().add(b);
            else lista2.getItems().add(b);
            i++;
        }
		}
	

    
}