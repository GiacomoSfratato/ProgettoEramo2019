package model;

import java.util.*;

// TODO: Auto-generated Javadoc
/**
 * The Class Metadati.
 */
public class Metadati {

/** The id pubblicazione. */
private static int id_pubblicazione;

/** The nrpagine. */
private int nrpagine;

/** The data. */
private String isbn, lingua, data;

/** The parole chiave. */
private ArrayList<Parola_chiave> parole_chiave;

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
	Metadati.id_pubblicazione = id_pubblicazione;
}

/**
 * Gets the nrpagine.
 *
 * @return the nrpagine
 */
public int getNrpagine() {
	return nrpagine;
}

/**
 * Sets the nrpagine.
 *
 * @param nrpagine the new nrpagine
 */
public void setNrpagine(int nrpagine) {
	this.nrpagine = nrpagine;
}

/**
 * Gets the isbn.
 *
 * @return the isbn
 */
public String getIsbn() {
	return isbn;
}

/**
 * Sets the isbn.
 *
 * @param isbn the new isbn
 */
public void setIsbn(String isbn) {
	this.isbn = isbn;
}

/**
 * Gets the lingua.
 *
 * @return the lingua
 */
public String getLingua() {
	return lingua;
}

/**
 * Sets the lingua.
 *
 * @param lingua the new lingua
 */
public void setLingua(String lingua) {
	this.lingua = lingua;
}

/**
 * Gets the data.
 *
 * @return the data
 */
public String getData() {
	return data;
}

/**
 * Sets the data.
 *
 * @param data the new data
 */
public void setData(String data) {
	this.data = data;
}

/**
 * Gets the parole chiave.
 *
 * @return the parole chiave
 */
public ArrayList<Parola_chiave> getParole_chiave() {
	return parole_chiave;
}

/**
 * Sets the parole chiave.
 *
 * @param parole_chiave the new parole chiave
 */
public void setParole_chiave(ArrayList<Parola_chiave> parole_chiave) {
	this.parole_chiave = parole_chiave;
}

/**
 * Instantiates a new metadati.
 *
 * @param nrpagine the nrpagine
 * @param isbn the isbn
 * @param lingua the lingua
 * @param data the data
 * @param parole_chiave the parole chiave
 */
public Metadati(int nrpagine, String isbn, String lingua, String data, ArrayList<Parola_chiave> parole_chiave) {
	super();
	this.nrpagine = nrpagine;
	this.isbn = isbn;
	this.lingua = lingua;
	this.data = data;
	this.parole_chiave = parole_chiave;
}

/**
 * Instantiates a new metadati.
 *
 * @param nrpagine the nrpagine
 * @param isbn the isbn
 * @param lingua the lingua
 * @param data the data
 */
public Metadati(int nrpagine, String isbn, String lingua, String data) {
	super();
	this.nrpagine = nrpagine;
	this.isbn = isbn;
	this.lingua = lingua;
	this.data = data;
}

/**
 * Instantiates a new metadati.
 *
 * @param isbn the isbn
 * @param data the data
 */
public Metadati(String isbn,String data) {
	this.data = data;
	this.isbn = isbn; }

/**
 * To string.
 *
 * @return the string
 */
@Override
public String toString() {
	return "\nN° pagine: " + nrpagine + "\nISBN: " + isbn + "\nLingua: " + lingua + "\nData di inserimento: " + data
			+ "\nParole chiave=" + parole_chiave;
}

}
