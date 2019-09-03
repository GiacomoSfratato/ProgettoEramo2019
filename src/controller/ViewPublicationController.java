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

public class ViewPublicationController {
		@FXML private AnchorPane anchorpane;
		@FXML private Text titolo;
		@FXML private Text autori;
		@FXML private Text editori;
		@FXML private Text anno;
		@FXML private Text isbn;
		@FXML private Text inseritada;
		@FXML private Text descrizione;
		@FXML private Text recensione;
		@FXML private Text likes;
		@FXML private TextArea areaRecensione;
		@FXML private TextField nrcapitolo;
		@FXML private TextField titolocapitolo;
		@FXML private TextField URI;
		@FXML private TextField tiposorgente;
		@FXML private TextField formatosorgente;
		@FXML private TextField descrizionesorgente;
		@FXML private TextField parolachiave;
		@FXML private TextField quantitaristampa;
		@FXML private TextField nomeautore;
		@FXML private TextField cognomeautore;
		@FXML DatePicker dataristampa;
		@FXML private Button like;
		@FXML private Button chiudi;
		@FXML private Button stessoAutore;
		@FXML private Button visualizzaRecensioni;
		@FXML private Button visualizzaSorgenti;
		@FXML private Button inserisciRecensione;
		@FXML private Button aggiungiCapitolo;
		@FXML private Button aggiungiSorgente;
		@FXML private Button inserisciParolaChiave;
		@FXML private Button inserisciRistampa;
		@FXML private Button inserisciAutore;
		@FXML private Button visualizzaCapitoli;
		private String autoriConc = "";
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
		private final String likesS = "Likes totali: " + dao.get_likes_totali(pubbl).getLikes_totali();
		
		private final String modifica_parametro = "modifica";
		private final String like_parametro = "like";
		
		public void initialize() {
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
		@FXML
	    private void handleChiudiButton(ActionEvent event) throws Exception{
	    	Scene scene = anchorpane.getScene();
	        BorderPane borderpane = (BorderPane) scene.lookup("#borderpane");
	        borderpane.setRight(null);
	    }
		
		@FXML 
		private void handleLikeButton(ActionEvent event) throws Exception{
			like.setDisable(dao.set_inserimento_like(pubbl));
			likes.setText("Likes totali: " + dao.get_likes_totali(pubbl).getLikes_totali());
			dao.modifica_pubblicazione_storico(pubbl, like_parametro);	
		}
		
		@FXML
		private void handleStessoAutoreButton(ActionEvent event) throws Exception{
            SameAuthorPublicationsPageController.setId(pubbl.getId());
			Parent root = FXMLLoader.load(getClass().getResource("/view/SameAuthorPublicationsPage.fxml"));
            Scene scene = anchorpane.getScene();
            BorderPane borderpane = (BorderPane) scene.lookup("#borderpane");
            borderpane.setCenter(root);
		}
		
		@FXML
		private void handleVisualizzaRecensioniButton(ActionEvent event) throws Exception{
            ReviewsPageController.setId(pubbl.getId());
			Parent root = FXMLLoader.load(getClass().getResource("/view/ReviewsPage.fxml"));
            Scene scene = anchorpane.getScene();
            BorderPane borderpane = (BorderPane) scene.lookup("#borderpane");
            borderpane.setCenter(root);
		}
		
		@FXML
		private void handleVisualizzaSorgentiButton(ActionEvent event) throws Exception{
            SourcesPageController.setId(pubbl.getId());
			Parent root = FXMLLoader.load(getClass().getResource("/view/SourcesPage.fxml"));
            Scene scene = anchorpane.getScene();
            BorderPane borderpane = (BorderPane) scene.lookup("#borderpane");
            borderpane.setCenter(root);
		}
		
		@FXML
		private void handleVisualizzaCapitoliButton(ActionEvent event) throws Exception{
			ChaptersPageController.setId(pubbl.getId());
			Parent root = FXMLLoader.load(getClass().getResource("/view/ChaptersPage.fxml"));
            Scene scene = anchorpane.getScene();
            BorderPane borderpane = (BorderPane) scene.lookup("#borderpane");
            borderpane.setCenter(root);
		}
		
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
