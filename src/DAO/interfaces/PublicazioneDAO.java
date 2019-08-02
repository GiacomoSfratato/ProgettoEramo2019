/* metodi contrasegnati con // sono quelli da forse aggiungere nelle altre interface */
/*c'è altra roba da aggiungere*/
package DAO.interfaces;
import java.util.*;
import model.Pubblicazione;
import model.Utente;
public interface PublicazioneDAO {
	public static ArrayList<Pubblicazione> get_ultime_publicazioni(){return null;}
	public static ArrayList<Pubblicazione> get_update_recente(){return null;}
	public static ArrayList<Pubblicazione> get_publicazione_utente(Utente utente){return null;}
	public static ArrayList<Pubblicazione> get_catalogo(){return null;}
	public static Pubblicazione get_estrazione_dati(Pubblicazione publicazione){return null;} //
	public static Pubblicazione get_cerca_publicazione(Pubblicazione publicazione){return null;}
	public static ArrayList<Pubblicazione> get_catalogo_ristampa(){return null;} //
	public static ArrayList<Pubblicazione> get_catalogo_stessi_autori(Pubblicazione publicazione){return null;} //
	public static boolean set_inserimento_like(String email, String password,int id_publicazione){return false;} //
	public static Pubblicazione get_likes_totiali(){return null;} //
	public static Pubblicazione get_estrazione_modifiche_pubblicazione(Pubblicazione publicazione){return null;} //
	
}
