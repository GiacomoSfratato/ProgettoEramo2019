package controller;

import java.sql.SQLException;

import DAO.implementations.*;
import model.*;
import javafx.event.ActionEvent;
import javafx.fxml.*;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Text;

// TODO: Auto-generated Javadoc
/**
 * The Class ViewPublicationController.
 */
public class ViewPublicationController {
		
		/** The anchorpane. */
		@FXML private AnchorPane anchorpane;
		
		/** The titolo. */
		@FXML private Text titolo;
		
		/** The autori. */
		@FXML private Text autori;
		
		/** The editori. */
		@FXML private Text editori;
		
		/** The anno. */
		@FXML private Text anno;
		
		/** The isbn. */
		@FXML private Text isbn;
		
		/** The inseritada. */
		@FXML private Text inseritada;
		
		/** The descrizione. */
		@FXML private Text descrizione;
		
		/** The recensione. */
		@FXML private Text recensione;
		
		/** The likes. */
		@FXML private Text likes;
		
		/** The area recensione. */
		@FXML private TextArea areaRecensione;
		
		/** The nrcapitolo. */
		@FXML private TextField nrcapitolo;
		
		/** The titolocapitolo. */
		@FXML private TextField titolocapitolo;
		
		/** The uri. */
		@FXML private TextField URI;
		
		/** The tiposorgente. */
		@FXML private TextField tiposorgente;
		
		/** The formatosorgente. */
		@FXML private TextField formatosorgente;
		
		/** The descrizionesorgente. */
		@FXML private TextField descrizionesorgente;
		
		/** The parolachiave. */
		@FXML private TextField parolachiave;
		
		/** The quantitaristampa. */
		@FXML private TextField quantitaristampa;
		
		/** The nomeautore. */
		@FXML private TextField nomeautore;
		
		/** The cognomeautore. */
		@FXML private TextField cognomeautore;
		
		/** The dataristampa. */
		@FXML DatePicker dataristampa;
		
		/** The like. */
		@FXML private Button like;
		
		/** The chiudi. */
		@FXML private Button chiudi;
		
		/** The stesso autore. */
		@FXML private Button stessoAutore;
		
		/** The visualizza recensioni. */
		@FXML private Button visualizzaRecensioni;
		
		/** The visualizza sorgenti. */
		@FXML private Button visualizzaSorgenti;
		
		/** The inserisci recensione. */
		@FXML private Button inserisciRecensione;
		
		/** The aggiungi capitolo. */
		@FXML private Button aggiungiCapitolo;
		
		/** The aggiungi sorgente. */
		@FXML private Button aggiungiSorgente;
		
		/** The inserisci parola chiave. */
		@FXML private Button inserisciParolaChiave;
		
		/** The inserisci ristampa. */
		@FXML private Button inserisciRistampa;
		
		/** The inserisci autore. */
		@FXML private Button inserisciAutore;
		
		/** The visualizza capitoli. */
		@FXML private Button visualizzaCapitoli;
		
		/** The autori conc. */
		private static String autoriConc = "";
		
		/** The id opera. */
		private static int idOpera;
		
		/** The max chars. */
		final int MAX_CHARS = 400 ;		
		
		/** The dao. */
		MySQLPubblicazioneDAOImpl dao = new MySQLPubblicazioneDAOImpl();
		
		/** The dao recensione. */
		MySQLRecensioneDAOImpl daoRecensione = new MySQLRecensioneDAOImpl();
		
		/** The pubbl. */
		Pubblicazione pubbl = dao.get_estrazione_dati(idOpera);
		
		/** The titolo S. */
		private final String titoloS = pubbl.getTitolo();
		
		/** The autori S. */
		private final String autoriS = autoriConc;
		
		/** The editori S. */
		private final String editoriS = "Editore: " + pubbl.getEditore();
		
		/** The anno S. */
		private final String annoS = "Data di pubblicazione: " +pubbl.getMetadati().getData();
		
		/** The isbn S. */
		private final String isbnS = "ISBN: " +pubbl.getMetadati().getIsbn();
		
		/** The inserita da S. */
		private final String inserita_daS = "Inserita da: " +pubbl.getUtente();
		
		/** The descrizione S. */
		private final String descrizioneS = "Descrizione:\n" +pubbl.getDescrizione();
		
		/** The likes S. */
		private final String likesS = "Likes totali: " + dao.get_likes_totali(pubbl).getLikes_totali();
		
		/** The modifica parametro. */
		private final String modifica_parametro = "modifica";
		
		/** The like parametro. */
		private final String like_parametro = "like";
		
		/**
		 * Initialize.
		 */
		public void initialize() {
			settaPagina();
		}
		
		/**
		 * Sets the id.
		 *
		 * @param id the new id
		 */
		public static void setId (int id) {
			idOpera = id;
		}
		
		/**
		 * Sets the autori.
		 *
		 * @param autori the new autori
		 */
		public static void setAutori(String autori) {
			autoriConc = autori;
		}
		
		/**
		 * Setta pagina.
		 */
		private void settaPagina() {
			//setta un limite di caratteri per la recensione
			areaRecensione.setTextFormatter(new TextFormatter<String>(change -> 
        	change.getControlNewText().length() <= MAX_CHARS ? change : null));
			
			//disabilita tasto like se già presente
			boolean check_like = dao.check_like(pubbl);
			like.setDisable(check_like);
			
			//disabilita inserisci recensione e area testuale se già presente
			boolean check_recensione = daoRecensione.check_recensione(pubbl);
			areaRecensione.setDisable(check_recensione);
			inserisciRecensione.setDisable(check_recensione);
			if(check_recensione) {
			areaRecensione.setPromptText("Recensione inserita");
			}
			
			//Setto le info della pubblicazione
			
			titolo.setText(titoloS);
			autori.setText(autoriS);
			editori.setText(editoriS);
			anno.setText(annoS);
			isbn.setText(isbnS);
			inseritada.setText(inserita_daS);
			descrizione.setText(descrizioneS);
			likes.setText(likesS);
			
			Tooltip tipautore = new Tooltip("Visualizza le opere di " + autoriConc);
			stessoAutore.setTooltip(tipautore);	
			
			Tooltip tiplike = new Tooltip("Lascia un like!");
			like.setTooltip(tiplike);
			
			Tooltip tiprecensoni = new Tooltip("Visualizza le recensioni di " + titoloS);
			visualizzaRecensioni.setTooltip(tiprecensoni);	
			
			Tooltip tipsorgenti = new Tooltip("Visualizza le sorgenti di " + titoloS);
			visualizzaSorgenti.setTooltip(tipsorgenti);	
			
			Tooltip tipcapitoli = new Tooltip("Visualizza i capitoli di " + titoloS);
			visualizzaCapitoli.setTooltip(tipcapitoli);	
		
			
		}
		
		/**
		 * Handle chiudi button.
		 *
		 * @param event the event
		 * @throws Exception the exception
		 */
		@FXML
	    private void handleChiudiButton(ActionEvent event) throws Exception{
	    	Scene scene = anchorpane.getScene();
	        BorderPane borderpane = (BorderPane) scene.lookup("#borderpane");
	        borderpane.setRight(null);
	    }
		
		/**
		 * Handle like button.
		 *
		 * @param event the event
		 * @throws Exception the exception
		 */
		@FXML 
		private void handleLikeButton(ActionEvent event) throws Exception{
			like.setDisable(dao.set_inserimento_like(pubbl));
			likes.setText("Likes totali: " + dao.get_likes_totali(pubbl).getLikes_totali());
			dao.modifica_pubblicazione_storico(pubbl, like_parametro);	
		}
		
		/**
		 * Handle stesso autore button.
		 *
		 * @param event the event
		 * @throws Exception the exception
		 */
		@FXML
		private void handleStessoAutoreButton(ActionEvent event) throws Exception{
            SameAuthorPublicationsPageController.setId(pubbl.getId());
			Parent root = FXMLLoader.load(getClass().getResource("/view/SameAuthorPublicationsPage.fxml"));
            Scene scene = anchorpane.getScene();
            BorderPane borderpane = (BorderPane) scene.lookup("#borderpane");
            borderpane.setCenter(root);
		}
		
		/**
		 * Handle visualizza recensioni button.
		 *
		 * @param event the event
		 * @throws Exception the exception
		 */
		@FXML
		private void handleVisualizzaRecensioniButton(ActionEvent event) throws Exception{
            ReviewsPageController.setId(pubbl.getId());
			Parent root = FXMLLoader.load(getClass().getResource("/view/ReviewsPage.fxml"));
            Scene scene = anchorpane.getScene();
            BorderPane borderpane = (BorderPane) scene.lookup("#borderpane");
            borderpane.setCenter(root);
		}
		
		/**
		 * Handle visualizza sorgenti button.
		 *
		 * @param event the event
		 * @throws Exception the exception
		 */
		@FXML
		private void handleVisualizzaSorgentiButton(ActionEvent event) throws Exception{
            SourcesPageController.setId(pubbl.getId());
			Parent root = FXMLLoader.load(getClass().getResource("/view/SourcesPage.fxml"));
            Scene scene = anchorpane.getScene();
            BorderPane borderpane = (BorderPane) scene.lookup("#borderpane");
            borderpane.setCenter(root);
		}
		
		/**
		 * Handle visualizza capitoli button.
		 *
		 * @param event the event
		 * @throws Exception the exception
		 */
		@FXML
		private void handleVisualizzaCapitoliButton(ActionEvent event) throws Exception{
			ChaptersPageController.setId(pubbl.getId());
			Parent root = FXMLLoader.load(getClass().getResource("/view/ChaptersPage.fxml"));
            Scene scene = anchorpane.getScene();
            BorderPane borderpane = (BorderPane) scene.lookup("#borderpane");
            borderpane.setCenter(root);
		}
		
		/**
		 * Handle inserisci recensione button.
		 *
		 * @param event the event
		 * @throws Exception the exception
		 */
		@FXML
		private void handleInserisciRecensioneButton(ActionEvent event) throws Exception{
			//Check che il campo non sia vuoto
			if(areaRecensione.getText().isBlank()) {
				areaRecensione.setPromptText("Inserisci una recensione");
			} else {
			Recensione recensione = new Recensione(areaRecensione.getText());
			daoRecensione.set_inserimento_recensione(pubbl, recensione);
			inserisciRecensione.setDisable(true);
			areaRecensione.clear();
			areaRecensione.setPromptText("Recensione inserita");
			areaRecensione.setDisable(true);
		}
	}	
		
		/**
		 * Handle aggiungi capitolo button.
		 *
		 * @param event the event
		 * @throws Exception the exception
		 */
		@FXML
		private void handleAggiungiCapitoloButton(ActionEvent event) throws Exception{
			//Check che i campi non siano vuoti
			if(nrcapitolo.getText().isBlank() || titolocapitolo.getText().isBlank()) {
			  if(nrcapitolo.getText().isBlank()) {
				  nrcapitolo.setPromptText("Obbligatorio");
			  }
			  
			  if(titolocapitolo.getText().isBlank()){
				  titolocapitolo.setPromptText("Obbligatorio");
			  }
		  } else {
				Capitolo capitolo = new Capitolo(Integer.parseInt(nrcapitolo.getText()), titolocapitolo.getText());
				if(dao.inserimento_capitolo(capitolo, pubbl)) {
				  nrcapitolo.clear();
				  titolocapitolo.clear();
				  titolocapitolo.setPromptText("Success!");
				} else {
					nrcapitolo.clear();
					nrcapitolo.setPromptText("Numero già presente");
				}
			dao.modifica_pubblicazione_storico(pubbl, modifica_parametro);
		  }
		}	
		
		/**
		 * Handle aggiungi sorgente button.
		 *
		 * @param event the event
		 * @throws Exception the exception
		 */
		@FXML
		private void handleAggiungiSorgenteButton(ActionEvent event) throws Exception{
			//Check che i campi non siano vuoti
			if(URI.getText().isBlank() || tiposorgente.getText().isBlank() || formatosorgente.getText().isBlank() || descrizionesorgente.getText().isBlank()) {
				if(URI.getText().isBlank()) {
					URI.setPromptText("Obbligatorio");
				}
				
				if(tiposorgente.getText().isBlank()) {
					tiposorgente.setPromptText("Obbligatorio");
				}
				
				if(formatosorgente.getText().isBlank()) {
					formatosorgente.setPromptText("Obbligatorio");
				}
				
				if(descrizionesorgente.getText().isBlank()) {
					descrizionesorgente.setPromptText("Obbligatorio");
				}
			} else {
			Sorgente sorgente = new Sorgente(URI.getText(), tiposorgente.getText(), formatosorgente.getText(), descrizionesorgente.getText());
				if(dao.inserimento_sorgente(sorgente, pubbl)) {
					URI.clear();
					URI.setPromptText("Success!");
					tiposorgente.clear();
					formatosorgente.clear();
					descrizionesorgente.clear();
				} else {
					//errore
				}
				dao.modifica_pubblicazione_storico(pubbl, modifica_parametro);
			}
		}
		
		/**
		 * Handle aggiungi parola chiave button.
		 *
		 * @param event the event
		 * @throws Exception the exception
		 */
		@FXML
		private void handleAggiungiParolaChiaveButton(ActionEvent event) throws Exception{
			//Check che il campo non sia vuoto
			if(parolachiave.getText().isBlank()) {
				parolachiave.setPromptText("Obbligatorio");
			} else {
				Parola_chiave parola = new Parola_chiave(parolachiave.getText());
				if(dao.inserimento_parola_chiave(parola, pubbl)) {
					parolachiave.clear();
					parolachiave.setPromptText("Success!");
				} else {
					//errore
				}
				dao.modifica_pubblicazione_storico(pubbl, modifica_parametro);
			}
		}
		
		/**
		 * Handle aggiungi ristampa button.
		 *
		 * @param event the event
		 * @throws Exception the exception
		 */
		@FXML
		private void handleAggiungiRistampaButton (ActionEvent event) throws Exception{
			//Check che i campi non siano vuoti
			if(dataristampa.getValue() == null || quantitaristampa.getText().isBlank()) {
				if(dataristampa.getValue() == null) {
					dataristampa.setPromptText("Obbligatorio");
				}
				
				if(quantitaristampa.getText().isBlank()) {
					quantitaristampa.setPromptText("Obbligatorio");
				}
			} else {
				Ristampa ristampa = new Ristampa(dataristampa.getValue().toString(), Integer.parseInt(quantitaristampa.getText()));
				if(dao.inserimento_ristampa(ristampa, pubbl)){
					dataristampa.setValue(null);
					dataristampa.setPromptText("Success!");
					quantitaristampa.clear();
				} else {
					//errore
				}
			dao.modifica_pubblicazione_storico(pubbl, modifica_parametro);
		}
	}	
		
		/**
		 * Handle aggiungi autore button.
		 *
		 * @param event the event
		 * @throws Exception the exception
		 */
		@FXML
		private void handleAggiungiAutoreButton (ActionEvent event) throws Exception{
			//Check che i campi non siano vuoti
			if(nomeautore.getText().isBlank()|| cognomeautore.getText().isBlank()) {
				if(nomeautore.getText().isBlank()) {
					nomeautore.setPromptText("Obbligatorio");
				}
				
				if(cognomeautore.getText().isBlank()) {
					cognomeautore.setPromptText("Obbligatorio");
				}
			} else {
			
				Autore autore = new Autore(nomeautore.getText(), cognomeautore.getText());
				if(dao.inserimento_autore(autore, pubbl)) {
					nomeautore.clear();
					cognomeautore.clear();
					nomeautore.setPromptText("Success!");
				} else {
					//errore
				}
				dao.modifica_pubblicazione_storico(pubbl, modifica_parametro);
			}
		}

}
