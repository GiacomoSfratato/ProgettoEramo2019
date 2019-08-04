package model;

import java.util.Date;

public class Recensione {
private static int id_utente, id_pubblicazione;
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
public static int getId_utente() {
	return id_utente;
}
public static void setId_utente(int id_utente) {
	Recensione.id_utente = id_utente;
}
public static int getId_pubblicazione() {
	return id_pubblicazione;
}
public static void setId_pubblicazione(int id_pubblicazione) {
	Recensione.id_pubblicazione = id_pubblicazione;
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
	return "\nRecensione:\n" +"Autore: " + autore +"\n" + "Contenuto: \"" + contenuto +"\"\n" + "Approvazione: " + approvazione +"\n" + "Data: " + timestamp +"\n";
}

}
