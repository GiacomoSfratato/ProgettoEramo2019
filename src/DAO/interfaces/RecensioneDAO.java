package DAO.interfaces;

import java.util.*;

import javafx.collections.ObservableList;
import model.*;

/**
 * L'interfaccia RecensioneDAO
 */
public interface RecensioneDAO {
	
	/**
	 * Estrazione elenco delle recensioni approvate per una pubblicazione.
	 *
	 * @param pubblicazione the pubblicazione
	 * @return the elenco recensioni
	 */
	
	public ObservableList<Recensione> get_elenco_recensioni(Pubblicazione pubblicazione);
	
	/**
	 * Estrazione elenco delle recensioni in attesa di approvazione.
	 *
	 * @return the elenco recensioni attesa
	 */
	
	public ObservableList get_elenco_recensioni_attesa();
	
	/**
	 * Inserimento di una recensione relativa a una pubblicazione.
	 *
	 * @param pubblicazione the pubblicazione
	 * @param recensione the recensione
	 * @return true, if successful
	 */
	
	public boolean set_inserimento_recensione(Pubblicazione pubblicazione, Recensione recensione);
	
	/**
	 * Approvazione o di una recensione (da parte del moderatore).
	 *
	 * @param recensione the recensione
	 * @param giudizio the giudizio
	 * @return true, if successful
	 */
	
	public boolean set_verifica_recensione(Recensione recensione, String giudizio);
	
	
	/**
	 * Rimuovere la recensione
	 *
	 * @param recensione Recensione
	 * @return true, se va a buon fine
	 */
	public boolean set_rimuovere_recensione(Recensione recensione);
	
	/**
	 * Check che l'utente abbia o non abbia inserito già la recensione
	 *
	 * @param pubblicazione Pubblicazione
	 * @return true, se va a buon fine
	 */
	public boolean check_recensione(Pubblicazione pubblicazione);
}
