package DAO.interfaces;
import java.util.*;
import model.Utente;
public interface UtenteDAO {
	 
		public static boolean set_modifica_tipo_utente(Utente utente, String tipo){return false;}
		public static HashMap<String,Integer> get_utenti_attivi(){return null;}
		public static String get_mostra_nome_utente(int id){return null;}
		public static boolean set_inserimento_utente(Utente utente){return false;}
		public static boolean set_rimovere_utente(Utente utente){return false;}
		
	/*
	 * L'interfaccia DAO per le diverse implementazioni di CustomerDAO. Definisce le operazioni CRUD.
	 
		Recupera tutti gli oggetti Customer dal DB. 
		public List getAllCustomers();
		
		Recupera un oggetto Customer esistente a partire dall'id.
		public Utente getCustomer(int id);
		
		Crea un oggetto Customer e restituisce l'id. 
		public int createCustomer(Utente customer);
		
		Aggiorna un oggetto Customer esistente.
		public boolean updateCustomer(Utente customer);
		
		Cancella un oggetto Customer esistente. 
		public boolean deleteCustomery(Utente customer); */
	}

