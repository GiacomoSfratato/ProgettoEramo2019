package DAO.interfaces;

import java.util.*;

import javafx.collections.ObservableList;
import model.*;

// TODO: Auto-generated Javadoc
/**
 * The Interface RecensioneDAO.
 */
public interface RecensioneDAO {
	
	/**
	 * Gets the elenco recensioni.
	 *
	 * @param pubblicazione the pubblicazione
	 * @return the elenco recensioni
	 */
	//Estrazione elenco delle recensioni approvate per una pubblicazione.
	public ObservableList<Recensione> get_elenco_recensioni(Pubblicazione pubblicazione);
	
	/**
	 * Gets the elenco recensioni attesa.
	 *
	 * @return the elenco recensioni attesa
	 */
	//Estrazione elenco delle recensioni in attesa di approvazione.
	public ObservableList get_elenco_recensioni_attesa();
	
	/**
	 * Sets the inserimento recensione.
	 *
	 * @param pubblicazione the pubblicazione
	 * @param recensione the recensione
	 * @return true, if successful
	 */
	//Inserimento di una recensione relativa a una pubblicazione.
	public boolean set_inserimento_recensione(Pubblicazione pubblicazione, Recensione recensione);
	
	/**
	 * Sets the verifica recensione.
	 *
	 * @param recensione the recensione
	 * @param giudizio the giudizio
	 * @return true, if successful
	 */
	//Approvazione o di una recensione (da parte del moderatore).
	public boolean set_verifica_recensione(Recensione recensione, String giudizio);
	
	
	/**
	 * Sets the rimuovere recensione.
	 *
	 * @param recensione the recensione
	 * @return true, if successful
	 */
	public boolean set_rimuovere_recensione(Recensione recensione);
	

}
