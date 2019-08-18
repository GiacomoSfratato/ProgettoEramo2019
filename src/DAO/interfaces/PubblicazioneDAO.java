/* metodi contrassegnati con // sono quelli da forse aggiungere nelle altre interface */
/*c'Ã¨ altra roba da aggiungere*/
package DAO.interfaces;
import java.util.*;

import javafx.collections.ObservableList;
import model.*;
public interface PubblicazioneDAO {
	//Estrazione elenco delle ultime dieci pubblicazioni inserite
	public ObservableList<Pubblicazione> get_ultime_pubblicazioni();
	
	//Estrazione elenco delle pubblicazioni aggiornate di recente (ultimi 30 giorni)
	public ObservableList<Pubblicazione> get_update_recente();
	
	//Estrazione elenco delle pubblicazioni inserite da un utente
	public ObservableList<Pubblicazione> get_pubblicazione_utente(Utente utente);
	
	//Estrazione catalogo, cioè elenco di tutte le pubblicazioni con titolo, autori, editore e anno di pubblicazione, ordinato per titolo
	public ObservableList<Pubblicazione> get_catalogo();
	
	//Estrazione dati complete di una pubblicazione specifica dato il suo ID
	public Pubblicazione get_estrazione_dati(int id);
	
	//Ricerca di pubblicazioni per ISBN, titolo, autore, e parole chiave
	public ObservableList<Pubblicazione> get_cerca_pubblicazione(String ricerca);
	
	//Estrazione della lista delle pubblicazioni in catalogo, ognuna con la data dell’ultima ristampa
	public ObservableList<Pubblicazione> get_catalogo_ristampa();
	
	//Data una pubblicazione, restituire tutte le pubblicazioni del catalogo aventi gli stessi autori
	public ObservableList<Pubblicazione> get_catalogo_stessi_autori(Pubblicazione pubblicazione);
	
	//Inserimento di un like relativo a una pubblicazione
	public boolean set_inserimento_like(Pubblicazione pubblicazione);
	
	//Calcolo numero dei like per una pubblicazione
	public Pubblicazione get_likes_totali(Pubblicazione pubblicazione);
	
	//Estrazione log delle modifiche effettuare su una pubblicazione
	public ArrayList<Storico> get_estrazione_modifiche_pubblicazione(Pubblicazione pubblicazione);
	
	//Estrazione elenco delle pubblicazioni per le quali è disponibile un download
	public ObservableList<Pubblicazione> get_elenco_download();
}
