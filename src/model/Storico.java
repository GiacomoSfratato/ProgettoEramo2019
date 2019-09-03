package model;

import java.util.Date;

// TODO: Auto-generated Javadoc
/**
 * The Class Storico.
 */
public class Storico {

/** The descrizione. */
private String descrizione; // anche qui si fa un check sul tipo con try-catch

/** The timestamp. */
private Date timestamp;

/** The id pubblicazione. */
private int id_utente, id_pubblicazione;

/**
 * Gets the descrizione.
 *
 * @return the descrizione
 */
public String getDescrizione() {
	return descrizione;
}

/**
 * Sets the descrizione.
 *
 * @param descrizione the new descrizione
 */
public void setDescrizione(String descrizione) {
	this.descrizione = descrizione;
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
 * Instantiates a new storico.
 *
 * @param id_utente the id utente
 * @param id_pubblicazione the id pubblicazione
 * @param descrizione the descrizione
 * @param timestamp the timestamp
 */
public Storico(int id_utente, int id_pubblicazione, String descrizione, Date timestamp) {
	super();
	this.descrizione = descrizione;
	this.timestamp = timestamp;
	this.id_utente = id_utente;
	this.id_pubblicazione = id_pubblicazione;
}

/**
 * To string.
 *
 * @return the string
 */
@Override
public String toString() {
	return "Storico [descrizione=" + descrizione + ", timestamp=" + timestamp + ", id_utente=" + id_utente
			+ ", id_pubblicazione=" + id_pubblicazione + "]";
}

}
