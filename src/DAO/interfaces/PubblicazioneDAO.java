/* metodi contrassegnati con // sono quelli da forse aggiungere nelle altre interface */
/*c'Ã¨ altra roba da aggiungere*/
package DAO.interfaces;
import java.util.*;

import javafx.collections.ObservableList;
import model.*;
// TODO: Auto-generated Javadoc

/**
 * The Interface PubblicazioneDAO.
 */
public interface PubblicazioneDAO {
	
	/**
	 * Gets the ultime pubblicazioni.
	 *
	 * @return the ultime pubblicazioni
	 */
	//Estrazione elenco delle ultime dieci pubblicazioni inserite
	public ObservableList<Pubblicazione> get_ultime_pubblicazioni();
	
	/**
	 * Gets the update recente.
	 *
	 * @return the update recente
	 */
	//Estrazione elenco delle pubblicazioni aggiornate di recente (ultimi 30 giorni)
	public ObservableList<Pubblicazione> get_update_recente();
	
	/**
	 * Gets the pubblicazione utente.
	 *
	 * @param id the id
	 * @return the pubblicazione utente
	 */
	//Estrazione elenco delle pubblicazioni inserite da un utente
	public ObservableList<Pubblicazione> get_pubblicazione_utente(int id);
	
	/**
	 * Gets the catalogo.
	 *
	 * @return the catalogo
	 */
	//Estrazione catalogo, cioè elenco di tutte le pubblicazioni con titolo, autori, editore e anno di pubblicazione, ordinato per titolo
	public ObservableList<Pubblicazione> get_catalogo();
	
	/**
	 * Gets the estrazione dati.
	 *
	 * @param id the id
	 * @return the estrazione dati
	 */
	//Estrazione dati complete di una pubblicazione specifica dato il suo ID
	public Pubblicazione get_estrazione_dati(int id);
	
	/**
	 * Gets the cerca pubblicazione.
	 *
	 * @param ricerca the ricerca
	 * @return the cerca pubblicazione
	 */
	//Ricerca di pubblicazioni per ISBN, titolo, autore, e parole chiave
	public ObservableList<Pubblicazione> get_cerca_pubblicazione(String ricerca);
	
	/**
	 * Gets the catalogo ristampa.
	 *
	 * @return the catalogo ristampa
	 */
	//Estrazione della lista delle pubblicazioni in catalogo, ognuna con la data dell’ultima ristampa
	public ObservableList<Pubblicazione> get_catalogo_ristampa();
	
	/**
	 * Gets the catalogo stessi autori.
	 *
	 * @param pubblicazione the pubblicazione
	 * @return the catalogo stessi autori
	 */
	//Data una pubblicazione, restituire tutte le pubblicazioni del catalogo aventi gli stessi autori
	public ObservableList<Pubblicazione> get_catalogo_stessi_autori(Pubblicazione pubblicazione);
	
	/**
	 * Sets the inserimento like.
	 *
	 * @param pubblicazione the pubblicazione
	 * @return true, if successful
	 */
	//Inserimento di un like relativo a una pubblicazione
	public boolean set_inserimento_like(Pubblicazione pubblicazione);
	
	/**
	 * Gets the likes totali.
	 *
	 * @param pubblicazione the pubblicazione
	 * @return the likes totali
	 */
	//Calcolo numero dei like per una pubblicazione
	public Pubblicazione get_likes_totali(Pubblicazione pubblicazione);
	
	/**
	 * Gets the estrazione modifiche pubblicazione.
	 *
	 * @param pubblicazione the pubblicazione
	 * @return the estrazione modifiche pubblicazione
	 */
	//Estrazione log delle modifiche effettuare su una pubblicazione
	public ArrayList<Storico> get_estrazione_modifiche_pubblicazione(Pubblicazione pubblicazione);
	
	/**
	 * Gets the elenco download.
	 *
	 * @return the elenco download
	 */
	//Estrazione elenco delle pubblicazioni per le quali è disponibile un download
	public ObservableList<Pubblicazione> get_elenco_download();
}
