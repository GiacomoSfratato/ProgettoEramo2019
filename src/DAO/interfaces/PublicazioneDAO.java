/* metodi contrasegnati con // sono quelli da forse aggiungere nelle altre interface */
/*c'è altra roba da aggiungere*/
package DAO.interfaces;
import java.util.*;
import model.Publicazione;
import model.Utente;
public interface PublicazioneDAO {
	public static ArrayList<Publicazione> get_ultime_publicazioni(){return null;}
	public static ArrayList<Publicazione> get_update_recente(){return null;}
	public static ArrayList<Publicazione> get_publicazione_utente(Utente utente){return null;}
	public static ArrayList<Publicazione> get_catalogo(){return null;}
	public static Publicazione get_estrazione_dati(Publicazione publicazione){return null;} //
	public static Publicazione get_cerca_publicazione(Publicazione publicazione){return null;}
	public static ArrayList<Publicazione> get_catalogo_ristampa(){return null;} //
	public static ArrayList<Publicazione> get_catalogo_stessi_autori(Publicazione publicazione){return null;} //
	public static boolean set_inserimento_like(String email, String password,int id_publicazione){return false;} //
	public static Publicazione get_likes_totiali(){return null;} //
	public static Publicazione get_estrazione_modifiche_pubblicazione(Publicazione publicazione){return null;} //
	
}
