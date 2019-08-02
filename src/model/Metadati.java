package model;

import java.util.*;

public class Metadati {
private static int id_pubblicazione;
private int nrpagine;
private String isbn, lingua, data;
private ArrayList<Parola_chiave> parole_chiave;
public static int getId_pubblicazione() {
	return id_pubblicazione;
}
public static void setId_pubblicazione(int id_pubblicazione) {
	Metadati.id_pubblicazione = id_pubblicazione;
}
public int getNrpagine() {
	return nrpagine;
}
public void setNrpagine(int nrpagine) {
	this.nrpagine = nrpagine;
}
public String getIsbn() {
	return isbn;
}
public void setIsbn(String isbn) {
	this.isbn = isbn;
}
public String getLingua() {
	return lingua;
}
public void setLingua(String lingua) {
	this.lingua = lingua;
}
public String getData() {
	return data;
}
public void setData(String data) {
	this.data = data;
}
public ArrayList<Parola_chiave> getParole_chiave() {
	return parole_chiave;
}
public void setParole_chiave(ArrayList<Parola_chiave> parole_chiave) {
	this.parole_chiave = parole_chiave;
}
public Metadati(int nrpagine, String isbn, String lingua, String data, ArrayList<Parola_chiave> parole_chiave) {
	super();
	this.nrpagine = nrpagine;
	this.isbn = isbn;
	this.lingua = lingua;
	this.data = data;
	this.parole_chiave = parole_chiave;
}
public Metadati(String isbn,String data) {
	this.data = data;
	this.isbn = isbn; }

@Override
public String toString() {
	return "Metadati [nrpagine=" + nrpagine + ", isbn=" + isbn + ", lingua=" + lingua + ", data=" + data
			+ ", parole_chiave=" + parole_chiave + "]";
}

}
