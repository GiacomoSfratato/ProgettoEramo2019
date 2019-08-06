package DAO.interfaces;
import java.util.*;
import model.Utente;
public interface UtenteDAO {
	 
		//Modifica del livello di un utente (da attivo a passivo e viceversa)
		public boolean set_modifica_tipo_utente(Utente utente, String tipo);
		
		//Estrazione elenco degli utenti più “collaborativi” (cioè quelli che hanno inserito più pubblicazioni).
		public HashMap<String,Integer> get_utenti_attivi();
		
		public boolean set_inserimento_utente(Utente utente);
		
		public boolean set_rimuovere_utente(Utente utente);
		
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

