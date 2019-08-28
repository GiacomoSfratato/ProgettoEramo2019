package model;

import java.util.Date;

public class Recensione {
private int id_utente, id_pubblicazione;
private String titolo_pubblicazione;
private String autore;
private String contenuto, approvazione;
private Date timestamp;
public Recensione(String autore, String contenuto, String approvazione, Date timestamp) {
	super();
	this.autore = autore;
	this.contenuto = contenuto;
	this.approvazione = approvazione;
	this.timestamp = timestamp;
}

public Recensione(String titolo, String autore, String contenuto, String approvazione, Date timestamp) {
	super();
	this.titolo_pubblicazione = titolo;
	this.autore = autore;
	this.contenuto = contenuto;
	this.approvazione = approvazione;
	this.timestamp = timestamp;
}

public Recensione (int id_pubblicazione, int id_utente, String titolo, String contenuto, String approvazione, Date timestamp) {
	this.id_pubblicazione = id_pubblicazione;
	this.id_utente = id_utente;
	this.titolo_pubblicazione = titolo;
	this.contenuto = contenuto;
	this.approvazione = approvazione;
	this.timestamp = timestamp;
}
public int getId_utente() {
	return id_utente;
}
public void setId_utente(int id_utente) {
	this.id_utente = id_utente;
}
public int getId_pubblicazione() {
	return id_pubblicazione;
}
public void setId_pubblicazione(int id_pubblicazione) {
	this.id_pubblicazione = id_pubblicazione;
}
public String getTitoloPubblicazione() {
	return titolo_pubblicazione;
}
public void setTitoloPubblicazione(String titolo) {
	this.titolo_pubblicazione = titolo;
}
public String getAutore() {
	return autore;
}
public void setAutore(String autore) {
	this.autore = autore;
}
public String getContenuto() {
	return contenuto;
}
public void setContenuto(String contenuto) {
	this.contenuto = contenuto;
}
public String getApprovazione() {
	return approvazione;
}
public void setApprovazione(String approvazione) {
	this.approvazione = approvazione;
}
public Date getTimestamp() {
	return timestamp;
}
public void setTimestamp(Date timestamp) {
	this.timestamp = timestamp;
}
@Override
public String toString() {
	return "\nRecensione:\n" + "Titolo: " + titolo_pubblicazione +"\n" + "Autore: " + autore +"\n" + "Contenuto: \"" + contenuto +"\"\n" + "Approvazione: " + approvazione +"\n" + "Data: " + timestamp +"\n";
}

}
