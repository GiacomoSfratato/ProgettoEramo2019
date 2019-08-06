package controller;

import java.io.IOException;

import DAO.implementations.MySQLRecensioneDAOImpl;
import DAO.implementations.MySQLUtenteDAOImpl;
import application.Main;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import model.LibraryUser;
import model.Utente;

public class MainProgramController {

	private void handleApprovaRecensioneButton() throws IOException {
		if(LibraryUser.getLivello().equals("moderatore")) { 
			/*MySQLRecensioneDAOImpl dao = new MySQLRecensioneDAOImpl();
			Pubblicazione pubbl = new Pubblicazione.Builder().
			dao.set_inserimento_recensione(pubblicazione, recensione)
			*/
		} else {
			//eccezione
		}
	}
	
	private void handleRifiutaRecensioneButton() throws IOException {
		if(LibraryUser.getLivello().equals("moderatore")) { 
			/*MySQLRecensioneDAOImpl dao = new MySQLRecensioneDAOImpl();
			Pubblicazione pubbl = new Pubblicazione.Builder().
			dao.set_inserimento_recensione(pubblicazione, recensione)
			*/
		} else {
			//eccezione
		}
	}
}
