package model;

import java.util.Date;

public class likes {
// idea di fare un interfaccia id_pubblicazione id_utente;
	private static int id_pubblicazione, id_utente;
	private Date timestamp;
	public static int getId_pubblicazione() {
		return id_pubblicazione;
	}
	public static void setId_pubblicazione(int id_pubblicazione) {
		likes.id_pubblicazione = id_pubblicazione;
	}
	public static int getId_utente() {
		return id_utente;
	}
	public static void setId_utente(int id_utente) {
		likes.id_utente = id_utente;
	}
	public Date getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}
	public likes(Date timestamp) {
		super();
		this.timestamp = timestamp;
	}
	@Override
	public String toString() {
		return "likes [timestamp=" + timestamp + "]";
	}
	
}
