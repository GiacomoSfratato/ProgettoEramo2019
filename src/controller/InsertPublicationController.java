package controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import DAO.implementations.MySQLPubblicazioneDAOImpl;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.*;
import javafx.scene.control.*;
import javafx.scene.text.*;
import model.*;

public class InsertPublicationController {
	@FXML private Text testoPagina;
	@FXML private Button conferma;
	@FXML private TextField titolo;
	@FXML private TextField editore;
	@FXML private TextField isbn;
	@FXML private TextField nrpagine;
	@FXML private TextField cognomeAutore;
	@FXML private TextField nomeAutore;
	@FXML private TextArea descrizione;
	@FXML private DatePicker datapubblicazione;
	@FXML private ComboBox<String> lingua;
	private List<String> myList;
	String fileName = "src/view/file_di_testo/lingue.txt";
	MySQLPubblicazioneDAOImpl dao = new MySQLPubblicazioneDAOImpl();
	
	@FXML
	public void initialize() {
	//popolo la lista di lingue da un file txt
		try {
			myList = Files.lines(Paths.get(fileName)).collect(Collectors.toList());
		} catch (IOException e) {
			e.printStackTrace();
		}
		lingua.setItems(FXCollections.observableArrayList(myList));
	}
	
	@FXML
	private void handleConfermaButton() {
		Autore autore = new Autore(
				nomeAutore.getText(), 
				cognomeAutore.getText()
				);
		
		ArrayList<Autore> autori = new ArrayList<Autore>();
		autori.add(autore);
		
		Metadati metadati = new Metadati(
				Integer.parseInt(nrpagine.getText()), 
				isbn.getText(), 
				lingua.getValue(), 
				datapubblicazione.getValue().toString()
				);
		
		Pubblicazione newPubbl = new Pubblicazione.Builder()
				.withtitolo(titolo.getText())
				.withdescrizione(descrizione.getText())
				.witheditore(editore.getText())
				.withautori(autori)
				.withmetadati(metadati)
				.build();		
				
		dao.inserimento_pubblicazione(newPubbl);		
	}
}

   	
