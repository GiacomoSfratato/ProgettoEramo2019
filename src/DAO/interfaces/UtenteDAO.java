package DAO.interfaces;
import java.util.*;

import javafx.collections.ObservableList;
import javafx.collections.ObservableMap;
import model.Utente;
// TODO: Auto-generated Javadoc

/**
 * The Interface UtenteDAO.
 */
public interface UtenteDAO {
	 
		/**
		 * Modifica il tipo di un utente.
		 *
		 * @param utente the utente
		 * @param tipo the tipo
		 * @return true, if successful
		 */
		
		public boolean set_modifica_tipo_utente(Utente utente, String tipo);
		/**
		 * Modifica il livello di un utente 
		 *
		 * @param utente the utente
		 * @param livello the livello
		 * @return true, if successful
		 */
		public boolean set_modifica_livello_utente(Utente utente, String livello);
		
		/**
		 * Estrazione elenco degli utenti più “collaborativi” (cioè quelli che hanno inserito più pubblicazioni)..
		 *
		 * @return the utenti attivi
		 */
		
		public ObservableList<Utente> get_utenti_attivi();
		
		/**
		 * Inserisce un utente.
		 *
		 * @param utente the utente
		 * @return true, if successful
		 */
		public boolean set_inserimento_utente(Utente utente);
		
		/**
		 * Rimuove un utente.
		 *
		 * @param utente the utente
		 * @return true, if successful
		 */
		public boolean set_rimuovere_utente(Utente utente);
		
		/**
		 * Controlla che l'utente esista e i dati inseriti siano giusti.
		 *
		 * @param email the email
		 * @param password the password
		 * @return true, if successful
		 */
		public Utente check_utente(String email, String password);
		/**
		 * Estrae tutti gli utenti del sistema
		 *
		 * @return true, if successful
		 */
		public ObservableList<Utente> get_utenti();
		/**
		 * Estrae i dati di un utente.
		 *
		 * @param idUtente the idUtente
		 * @return the utente
		 */
		public Utente get_dati_utente(int idUtente);
	}

