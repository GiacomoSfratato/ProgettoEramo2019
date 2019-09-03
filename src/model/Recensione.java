package model;

import java.util.Date;

// TODO: Auto-generated Javadoc
/**
 * The Class Recensione.
 */
public class Recensione {

/** The id pubblicazione. */
private int id_utente, id_pubblicazione;

/** The titolo. */
private String titolo;

/** The autore. */
private String autore;

/** The approvazione. */
private String contenuto, approvazione;

/** The timestamp. */
private Date timestamp;

/**
 * Instantiates a new recensione.
 *
 * @param autore the autore
 * @param contenuto the contenuto
 * @param approvazione the approvazione
 * @param timestamp the timestamp
 */
public Recensione(String autore, String contenuto, String approvazione, Date timestamp) {
	super();
	this.autore = autore;
	this.contenuto = contenuto;
	this.approvazione = approvazione;
	this.timestamp = timestamp;
}

/**
 * Instantiates a new recensione.
 *
 * @param titolo the titolo
 * @param autore the autore
 * @param contenuto the contenuto
 * @param approvazione the approvazione
 * @param timestamp the timestamp
 */
public Recensione(String titolo, String autore, String contenuto, String approvazione, Date timestamp) {
	super();
	this.titolo = titolo;
	this.autore = autore;
	this.contenuto = contenuto;
	this.approvazione = approvazione;
	this.timestamp = timestamp;
}

/**
 * Instantiates a new recensione.
 *
 * @param id_pubblicazione the id pubblicazione
 * @param id_utente the id utente
 * @param titolo the titolo
 * @param contenuto the contenuto
 * @param approvazione the approvazione
 * @param timestamp the timestamp
 */
public Recensione (int id_pubblicazione, int id_utente, String titolo, String contenuto, String approvazione, Date timestamp) {
	this.id_pubblicazione = id_pubblicazione;
	this.id_utente = id_utente;
	this.titolo = titolo;
	this.contenuto = contenuto;
	this.approvazione = approvazione;
	this.timestamp = timestamp;
}

/**
 * Instantiates a new recensione.
 *
 * @param contenuto the contenuto
 */
public Recensione(String contenuto) {
	this.contenuto = contenuto;
}

/**
 * Gets the id utente.
 *
 * @return the id utente
 */
public int getId_utente() {
	return id_utente;
}

/**
 * Sets the id utente.
 *
 * @param id_utente the new id utente
 */
public void setId_utente(int id_utente) {
	this.id_utente = id_utente;
}

/**
 * Gets the id pubblicazione.
 *
 * @return the id pubblicazione
 */
public int getId_pubblicazione() {
	return id_pubblicazione;
}

/**
 * Sets the id pubblicazione.
 *
 * @param id_pubblicazione the new id pubblicazione
 */
public void setId_pubblicazione(int id_pubblicazione) {
	this.id_pubblicazione = id_pubblicazione;
}

/**
 * Gets the titolo.
 *
 * @return the titolo
 */
public String getTitolo() {
	return titolo;
}

/**
 * Sets the titolo.
 *
 * @param titolo the new titolo
 */
public void setTitolo(String titolo) {
	this.titolo = titolo;
}

/**
 * Gets the autore.
 *
 * @return the autore
 */
public String getAutore() {
	return autore;
}

/**
 * Sets the autore.
 *
 * @param autore the new autore
 */
public void setAutore(String autore) {
	this.autore = autore;
}

/**
 * Gets the contenuto.
 *
 * @return the contenuto
 */
public String getContenuto() {
	return contenuto;
}

/**
 * Sets the contenuto.
 *
 * @param contenuto the new contenuto
 */
public void setContenuto(String contenuto) {
	this.contenuto = contenuto;
}

/**
 * Gets the approvazione.
 *
 * @return the approvazione
 */
public String getApprovazione() {
	return approvazione;
}

/**
 * Sets the approvazione.
 *
 * @param approvazione the new approvazione
 */
public void setApprovazione(String approvazione) {
	this.approvazione = approvazione;
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
 * To string.
 *
 * @return the string
 */
@Override
public String toString() {
	return "\nRecensione:\n" + "Titolo: " + titolo +"\n" + "Autore: " + autore +"\n" + "Contenuto: \"" + contenuto +"\"\n" + "Approvazione: " + approvazione +"\n" + "Data: " + timestamp +"\n";
}

}
