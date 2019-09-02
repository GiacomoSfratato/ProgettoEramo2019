package controller;

import java.sql.SQLException;

import DAO.implementations.*;
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
		@FXML private TextArea areaRecensione;
		@FXML Button  like;
		@FXML Button chiudi;
		@FXML Button stessoAutore;
		@FXML Button visualizzaRecensioni;
		@FXML Button inserisciRecensione;
		private static int idOpera;
		final int MAX_CHARS = 400 ;		
		
		MySQLPubblicazioneDAOImpl dao = new MySQLPubblicazioneDAOImpl();
		MySQLRecensioneDAOImpl daoRecensione = new MySQLRecensioneDAOImpl();
		Pubblicazione pubbl = dao.get_estrazione_dati(idOpera);
		
		private final String titoloS = pubbl.getTitolo();
		private final String autoriS = "Autori: ";
		private final String editoriS = "Editore: " + pubbl.getEditore();
		private final String annoS = "Data di pubblicazione: " +pubbl.getMetadati().getData();
		private final String isbnS = "ISBN: " +pubbl.getMetadati().getIsbn();
		private final String inserita_daS = "Inserita da: " +pubbl.getUtente();
		private final String descrizioneS = "Descrizione:\n" +pubbl.getDescrizione();
		private final String recensioneS = "Inserisci una recensione: ";
		private final String likesS = "Likes totali: " + dao.get_likes_totali(pubbl).getLikes_totali();
		private final String IMMAGINE_PUBBLICAZIONE = "/view/immagini/libro-cerchio.png";
		
		public void initialize() throws SQLException{
			settaPagina();
		}
		
		public static void setId (int id) {
			idOpera = id;
		}
		
		private void settaPagina() {
			//setta un limite di caratteri per la recensione
			areaRecensione.setTextFormatter(new TextFormatter<String>(change -> 
        	change.getControlNewText().length() <= MAX_CHARS ? change : null));
			
			//disabilita tasto like se già presente
			if(dao.check_like(pubbl)) {
				like.setDisable(true);
			}
			
			//setta i campi text
			int size = pubbl.getAutori().size();
			for (int j = 0; j < size; j++) {
                if (j == pubbl.getAutori().size() - 1)
                    autoriConc = autoriConc + pubbl.getAutori().get(j).getNome() + " " + pubbl.getAutori().get(j).getCognome();
                else {
                    autoriConc = autoriConc + pubbl.getAutori().get(j).getNome() + " " + pubbl.getAutori().get(j).getCognome() + ", ";
                }
            }
			
			titolo.setText(titoloS);
			autori.setText(autoriS + autoriConc);
			editori.setText(editoriS);
			anno.setText(annoS);
			isbn.setText(isbnS);
			inseritada.setText(inserita_daS);
			descrizione.setText(descrizioneS);
			recensione.setText(recensioneS);
			likes.setText(likesS);
			
			Image icon = new Image(getClass().getResourceAsStream(IMMAGINE_PUBBLICAZIONE));
			immagine.setImage(icon);
			
		}
		@FXML
	    private void handleChiudiButton(ActionEvent event) throws Exception{
	    	Scene scene = anchorpane.getScene();
	        BorderPane borderpane = (BorderPane) scene.lookup("#borderpane");
	        borderpane.setRight(null);
	    }
		
		@FXML 
		private void handleLikeButton() {
			dao.set_inserimento_like(pubbl);
			likes.setText("Likes totali: " + dao.get_likes_totali(pubbl).getLikes_totali());
			like.setDisable(true);
		}
		
		@FXML
		private void handleInserisciRecensioneButton() {
			Recensione recensione = new Recensione(areaRecensione.getText());
			daoRecensione.set_inserimento_recensione(pubbl, recensione);
		}
}
