package DAO.interfaces;

import java.util.*;

import javafx.collections.ObservableList;
import model.*;

public interface RecensioneDAO {
	
	//Estrazione elenco delle recensioni approvate per una pubblicazione.
	public ObservableList<Recensione> get_elenco_recensioni(Pubblicazione pubblicazione);
	
	//Estrazione elenco delle recensioni in attesa di approvazione.
	public ObservableList get_elenco_recensioni_attesa();
	
	//Inserimento di una recensione relativa a una pubblicazione.
	public boolean set_inserimento_recensione(Pubblicazione pubblicazione, Recensione recensione);
	
	//Approvazione o di una recensione (da parte del moderatore).
	public boolean set_verifica_recensione(Recensione recensione, String giudizio);
	
	
	public boolean set_rimuovere_recensione(Recensione recensione);
	

}
