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
	 * Estrazione elenco dello storico delle modifiche.
	 *
	 * @return Storico delle modifiche su tutte le pubblicazioni
	 */
	public ObservableList<Storico> get_storico_modifiche();
	/**
	 * Estrazione elenco delle ultime dieci pubblicazioni inserite.
	 *
	 * @return Ultime pubblicazioni
	 */
	
	public ObservableList<Pubblicazione> get_ultime_pubblicazioni();
	
	/**
	 * Estrazione elenco delle pubblicazioni aggiornate di recente (ultimi 30 giorni).
	 *
	 * @return Aggiornate di recente
	 */
	
	public ObservableList<Pubblicazione> get_update_recente();
	
	/**
	 * Estrazione elenco delle pubblicazioni inserite da un utente.
	 *
	 * @param id the id
	 * @return Pubblicazioni inserite da un utente
	 */
	
	public ObservableList<Pubblicazione> get_pubblicazione_utente(int id);
	
	/**
	 * Estrazione catalogo, cioè elenco di tutte le pubblicazioni con titolo, autori, editore e anno di pubblicazione, ordinato per titolo.
	 *
	 * @return Tutte le pubblicazioni
	 */

	public ObservableList<Pubblicazione> get_catalogo();
	
	/**
	 * Estrazione dati di una pubblicazione specifica dato il suo ID.
	 *
	 * @param id the id
	 * @return I dati della pubblicazione
	 */
	
	public Pubblicazione get_estrazione_dati(int id);
	
	/**
	 * Ricerca di pubblicazioni per ISBN, titolo, autore, e parole chiave.
	 *
	 * @param ricerca the ricerca
	 * @return Pubblicazioni trovate
	 */
	
	public ObservableList<Pubblicazione> get_cerca_pubblicazione(String ricerca);
	
	/**
	 * Estrazione della lista delle pubblicazioni in catalogo, ognuna con la data dell’ultima ristampa.
	 *
	 * @return Pubblicazioni con data dell'ultima ristampa
	 */
	
	public ObservableList<Pubblicazione> get_catalogo_ristampa();
	
	/**
	 * Data una pubblicazione, restituire tutte le pubblicazioni del catalogo aventi gli stessi autori.
	 *
	 * @param pubblicazione the pubblicazione
	 * @return Pubblicazioni scritte dallo stesso autore
	 */
	
	public ObservableList<Pubblicazione> get_catalogo_stessi_autori(Pubblicazione pubblicazione);
	
	/**
	 * Inserimento di un like relativo a una pubblicazione.
	 *
	 * @param pubblicazione the pubblicazione
	 * @return true, se va a buon fine
	 */
	
	public boolean set_inserimento_like(Pubblicazione pubblicazione);
	
	/**
	 * Calcolo numero dei like per una pubblicazione.
	 *
	 * @param pubblicazione the pubblicazione
	 * @return Quantità di like della pubblicazione
	 */
	
	public Pubblicazione get_likes_totali(Pubblicazione pubblicazione);
	
	/**
	 * Estrazione log delle modifiche effettuare su una pubblicazione.
	 *
	 * @param pubblicazione the pubblicazione
	 * @return Storico delle modifiche su una pubblicazione
	 */
	
	public ArrayList<Storico> get_estrazione_modifiche_pubblicazione(Pubblicazione pubblicazione);
	
	/**
	 *Estrazione elenco delle pubblicazioni per le quali è disponibile un download.
	 *
	 * @return L'elenco delle pubblicazioni con download
	 */
	
	public ObservableList<Pubblicazione> get_elenco_download();
	
	/**
	 * Inserimento di una pubblicazione.
	 *
	 * @param pubblicazione Pubblicazione
	 */
	public void inserimento_pubblicazione (Pubblicazione pubblicazione);
	
	/**
	 * Inserimento di un capitolo.
	 *
	 * @param capitolo Capitolo
	 * @param pubblicazione Pubblicazione 
	 * @return true, se va a buon fine
	 */
	public boolean inserimento_capitolo (Capitolo capitolo, Pubblicazione pubblicazione);
	
	/**
	 * Inserimento di una sorgente.
	 *
	 * @param sorgente Sorgente 
	 * @param pubblicazione Pubblicazione
	 * @return true, se va a buon fine
	 */
	public boolean inserimento_sorgente (Sorgente sorgente, Pubblicazione pubblicazione);
	
	/**
	 * Inserimento di una ristampa.
	 *
	 * @param ristampa Ristampa 
	 * @param pubblicazione Pubblicazione 
	 * @return true, se va a buon fine
	 */
	public boolean inserimento_ristampa (Ristampa ristampa, Pubblicazione pubblicazione);
	
	/**
	 * Inserimento di una parola chiave.
	 *
	 * @param parola Parola chiave
	 * @param pubblicazione Pubblicazione
	 * @return true, se va a buon fine
	 */
	public boolean inserimento_parola_chiave (Parola_chiave parola, Pubblicazione pubblicazione);
	
	/**
	 * Inserimento di un autore.
	 *
	 * @param autore Autore
	 * @param pubblicazione Pubblicazione
	 * @return true, se va a buon fine
	 */
	public boolean inserimento_autore (Autore autore, Pubblicazione pubblicazione);
	
	/**
	 * Controlla se l'utente ha già inserito il like.
	 *
	 * @param pubblicazione Pubblicazione
	 * @return true, se va a buon fine
	 */
	public boolean check_like(Pubblicazione pubblicazione);
	
	/**
	 * Estrae le sorgenti di una pubblicazione
	 *
	 * @param pubblicazione Pubblicazione
	 * @return Le sorgenti
	 */
	public ObservableList<Sorgente> get_sorgenti_pubbl(Pubblicazione pubblicazione);
	
	/**
	 * Estrae i capitoli di una pubblicazione
	 *
	 * @param pubbl Pubblicazione
	 * @return I capitoli
	 */
	public ObservableList<Capitolo> get_capitoli_pubbl(Pubblicazione pubbl);
	
	/**
	 * Memorizza la modifica nello storico.
	 *
	 * @param pubblicazione Pubblicazione
	 * @param parametro Parametro
	 */
	public void modifica_pubblicazione_storico(Pubblicazione pubblicazione, String parametro);
}
