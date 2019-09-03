package model;

import java.util.Date;

// TODO: Auto-generated Javadoc
/**
 * The Class Likes.
 */
public class Likes {

/** The id utente. */
// idea di fare un interfaccia id_pubblicazione id_utente;
	private static int id_pubblicazione, id_utente;
	
	/** The timestamp. */
	private Date timestamp;
	
	/**
	 * Gets the id pubblicazione.
	 *
	 * @return the id pubblicazione
	 */
	public static int getId_pubblicazione() {
		return id_pubblicazione;
	}
	
	/**
	 * Sets the id pubblicazione.
	 *
	 * @param id_pubblicazione the new id pubblicazione
	 */
	public static void setId_pubblicazione(int id_pubblicazione) {
		Likes.id_pubblicazione = id_pubblicazione;
	}
	
	/**
	 * Gets the id utente.
	 *
	 * @return the id utente
	 */
	public static int getId_utente() {
		return id_utente;
	}
	
	/**
	 * Sets the id utente.
	 *
	 * @param id_utente the new id utente
	 */
	public static void setId_utente(int id_utente) {
		Likes.id_utente = id_utente;
	}
	
	/**
	 * Gets the timestamp.
	 *
	 * @return the timestamp
	 */
	public Date getTimestamp() {
		return timestamp;
	}
	
	/**
	 * Sets the timestamp.
	 *
	 * @param timestamp the new timestamp
	 */
	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}
	
	/**
	 * Instantiates a new likes.
	 *
	 * @param timestamp the timestamp
	 */
	public Likes(Date timestamp) {
		super();
		this.timestamp = timestamp;
	}
	
	/**
	 * To string.
	 *
	 * @return the string
	 */
	@Override
	public String toString() {
		return "likes [timestamp=" + timestamp + "]";
	}
	
}
