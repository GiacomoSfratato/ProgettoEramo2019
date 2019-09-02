package controller;

import java.sql.SQLException;

import DAO.implementations.MySQLPubblicazioneDAOImpl;
import model.*;
import javafx.event.ActionEvent;
import javafx.fxml.*;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Text;

public class ViewPublicationController {
		@FXML private AnchorPane anchorpane;
		@FXML private ImageView immagine;
		@FXML private Text titolo;
		@FXML private Text autori;
		private String autoriConc = "";
		@FXML private Text editori;
		@FXML private Text anno;
		@FXML private Text isbn;
		@FXML private Text inseritada;
		@FXML private Text descrizione;
		@FXML private Text recensione;
		@FXML private Text capitoli;
		@FXML private Text likes;
		@FXML ImageView  like;
		private static int idOpera;
		
		public static void setId (int id) {
			idOpera = id;
		}
		
		MySQLPubblicazioneDAOImpl dao = new MySQLPubblicazioneDAOImpl();
		Pubblicazione pubbl = dao.get_estrazione_dati(idOpera);
		
		private final String titoloS = pubbl.getTitolo();
		private final String autoriS = "Autori: ";
		private final String editoriS = "Editore: " + pubbl.getEditore();
		private final String annoS = "Data di pubblicazione: " +pubbl.getMetadati().getData();
		private final String isbnS = "ISBN: " +pubbl.getMetadati().getIsbn();
		private final String inserita_daS = "Inserita da: " +pubbl.getUtente();
		private final String descrizioneS = "Descrizione:\n" +pubbl.getDescrizione();
		
		
		public void initialize() throws SQLException{
			titolo.setText(titoloS);
			int size = pubbl.getAutori().size();
			for (int j = 0; j < size; j++) {
                if (j == pubbl.getAutori().size() - 1)
                    autoriConc = autoriConc + pubbl.getAutori().get(j).getNome() + " " + pubbl.getAutori().get(j).getCognome();
                else {
                    autoriConc = autoriConc + pubbl.getAutori().get(j).getNome() + " " + pubbl.getAutori().get(j).getCognome() + ", ";
                }
            }
			autori.setText(autoriS + autoriConc);
			editori.setText(editoriS);
			anno.setText("Data di pubblicazione: " +pubbl.getMetadati().getData());
			isbn.setText("ISBN: " +pubbl.getMetadati().getIsbn());
			inseritada.setText("Inserita da: " +pubbl.getUtente());
			descrizione.setText("Descrizione:\n" +pubbl.getDescrizione());
			
		}
		
		@FXML
	    private void handleChiudiButton(ActionEvent event) throws Exception{
	    	Scene scene = anchorpane.getScene();
	        BorderPane borderpane = (BorderPane) scene.lookup("#borderpane");
	        borderpane.setRight(null);
	    }
}
