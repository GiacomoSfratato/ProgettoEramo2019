package controller;

import java.awt.Desktop;
import java.net.URI;
import DAO.implementations.MySQLPubblicazioneDAOImpl;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.SplitPane;
import javafx.scene.control.Tooltip;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import model.Pubblicazione;

public class DispDownloadPublicationsPageController {
	@FXML
	private AnchorPane anchorpane = new AnchorPane();
	@FXML
	private ListView<Button> lista1 = new ListView<Button>();
	@FXML
	private ListView<Button> lista2 = new ListView<Button>();
	@FXML
	private SplitPane pane = new SplitPane();
	
	@FXML
	private void initialize(){
		AnchorPane.setTopAnchor(pane,0.0);
		AnchorPane.setBottomAnchor(pane,0.0);
		AnchorPane.setLeftAnchor(pane,0.0);
		AnchorPane.setRightAnchor(pane,0.0);
		settalista();
		
	}
	
	
	@FXML
	private void settalista() {
		MySQLPubblicazioneDAOImpl dao = new MySQLPubblicazioneDAOImpl();
		ObservableList<Pubblicazione> list = dao.get_elenco_download();
		int i = 0;
		for(Pubblicazione p : list) {
			String url = "URL: ";
            url = url + p.getSorgenti().get(0).getURI();
			
            Tooltip tip = new Tooltip("Clicca qui per aprire il link");
            
            //Setto l'immagine
            Image icon = new Image(getClass().getResourceAsStream("/view/immagini/librocolor.png"));
            ImageView immagine = new ImageView(icon);
            immagine.setFitHeight(55);
            immagine.setPreserveRatio(true);
            
            //Setto ciascun button
            Button b = new Button("", immagine);
            b.setPrefWidth(504);
            b.setAlignment(Pos.CENTER_LEFT);
            b.setTextFill(Color.web("#375fc6"));
            b.setText("  " + p.getTitolo() + "\n  " + url);
            b.setId("" + p.getId());
            b.getStylesheets().add("/view/css/buttonlist.css");
            b.setTooltip(tip);
            b.setOnAction(new EventHandler<ActionEvent>() {
                public void handle(ActionEvent e) {
                    try {
                    	Desktop d = Desktop.getDesktop();
                    	d.browse(new URI(p.getSorgenti().get(0).getURI()));
                    } catch (Exception ex) {
                        ex.getStackTrace();
                    }

                }
            });
            
            //Aggiungo i Button alle due listview
            if (i % 2 == 0) lista1.getItems().add(b);
            else lista2.getItems().add(b);
            i++;
        }
		}
	}

