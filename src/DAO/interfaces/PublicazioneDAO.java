/* metodi contrasegnati con // sono quelli da forse aggiungere nelle altre interface */
/*c'è altra roba da aggiungere*/
package DAO.interfaces;
import java.util.*;
import model.Publicazione;
import model.Utente;
public interface PublicazioneDAO {
	public ArrayList<Publicazione> get_ultime_publicazioni();
	public ArrayList<Publicazione> get_update_recente();
	public ArrayList<Publicazione> get_publicazione_utente(Utente utente);
	public ArrayList<Publicazione> get_catalogo();
	public Publicazione get_estrazione_dati(Publicazione publicazione); //
	public Publicazione cerca_publicazione(Publicazione publicazione);
	public ArrayList<Publicazione> get_catalogo_ristampa(); //
	public ArrayList<Publicazione> get_catalogo_stessi_autori(Publicazione publicazione); //
	public Publicazione get_Likestotiali(); //
}
