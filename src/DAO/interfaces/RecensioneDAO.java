package DAO.interfaces;

import java.util.*;
import model.Recensione;
import model.Utente;

public interface RecensioneDAO {
	public static ArrayList<Recensione> get_elenco_recensioni(){return null;}
	public static ArrayList<Recensione> get_elenco_recensioni_attesa(){return null;}
	public static boolean set_inserimento_recensione(Recensione recensione){return false;}
	public static boolean set_rimuovere_recensione(Recensione recensione){return false;}
	public static boolean set_verifica_recensione(Utente utente, int ID_pubblicazione, String giudizio){return false;}

}
