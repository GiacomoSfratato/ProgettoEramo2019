package application;

import DAO.interfaces.UtenteDAO;

public class Main {
	public static void main(String[] argv) {
	UtenteDAO utente = new Utente.Builder().withmail("ciao@cia.ex").withpassword("marks124").build(); // example of utente
	System.out.println(utente.toString()); 
	MySQLUtenteDAOImpl x = new MySQLUtenteDAOImpl();
	System.out.println(x.get_utenti_attivi()); 
	System.out.println(x.set_inserimento_utente(utente)); 
	System.out.println(x.set_rimovere_utente(utente));
	System.out.println(x.get_mostra_nome_utente(6));  
	
	MySQLPubblicazioneDAOImpl y = new MySQLPubblicazioneDAOImpl();
	System.out.print(y.get_ultime_publicazioni());
	System.out.print(y.get_update_recente()); 
	
	System.out.println(y.get_pubblicazione_utente(new Utente.Builder().withmail("fulviolapenna@gmail.com").build()));
}
}