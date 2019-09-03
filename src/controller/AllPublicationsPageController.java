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
import model.Autore;
import model.Pubblicazione;

public class AllPublicationsPageController {
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
		titolopagina.setText("Ecco tutte le opere che ci sono in catalogo:");
		settalista();
		
	}
	
	
	@FXML
	private void settalista() {
		MySQLPubblicazioneDAOImpl dao = new MySQLPubblicazioneDAOImpl();
		ObservableList<Pubblicazione> list = dao.get_catalogo();
		int i = 0;
		
		//Rimuove pubblicazioni duplicate e unisce gli autori
		for(int j = 0; j<list.size() - 1; j++) {
			if(list.get(j).getId() == list.get(j+1).getId()) {
				Autore autore = list.get(j+1).getAutori().get(0);
				list.get(j).getAutori().add(autore);
				list.remove(j+1);
				j = -1;
			}
		}
		
		for(Pubblicazione p : list) {
			Image icon = new Image(getClass().getResourceAsStream("/view/immagini/librocolor.png"));
            ImageView immagine = new ImageView(icon);
            immagine.setFitHeight(55);
            immagine.setPreserveRatio(true);
            Button b = new Button("", immagine);
            b.setPrefWidth(545);
            b.setAlignment(Pos.CENTER_LEFT);
            b.setTextFill(Color.web("#375fc6"));
            
            String autori = "Autori: ";
            int size = p.getAutori().size();
            for (int j = 0; j < size; j++) {
                if (j == p.getAutori().size() - 1)
                    autori = autori + p.getAutori().get(j).getNome() + " " + p.getAutori().get(j).getCognome();
                else {
                    autori = autori + p.getAutori().get(j).getNome() + " " + p.getAutori().get(j).getCognome() + ", ";
                }
            }
            final String autoriPar = autori;
            b.setText("  " + p.getTitolo() + "\n  " + autori);
            b.setId("" + p.getId());
            b.getStylesheets().add("/view/css/buttonlist.css");
            b.setOnAction(new EventHandler<ActionEvent>() {
                public void handle(ActionEvent e) {
                    try {
                    	int idOpera;
                        idOpera = Integer.parseInt(b.getId());
                        ViewPublicationController.setId(idOpera);
                        ViewPublicationController.setAutori(autoriPar);
                        Parent root = FXMLLoader.load(getClass().getResource("/view/ViewPublicationPage.fxml"));
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