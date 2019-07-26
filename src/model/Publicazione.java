package model;

import java.util.ArrayList;

public class Publicazione {
	private String titolo, descrizione, editore;
	private static int id;
	private Metadati metadati; // composizione
	private ArrayList <Sorgente> sorgenti;
	private ArrayList <Recensione> recensioni;
	private ArrayList <Capitolo> capitoli;
	private ArrayList <Autore> autori;
/*  private ArrayList <Like> likes;  // forse da aggiungere */
	public String getTitolo() {
		return titolo;
	}
	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}
	public String getDescrizione() {
		return descrizione;
	}
	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}
	public String getEditore() {
		return editore;
	}
	public void setEditore(String editore) {
		this.editore = editore;
	}
	public static int getId() {
		return id;
	}
	public static void setId(int id) {
		Publicazione.id = id;
	}
	public Metadati getMetadati() {
		return metadati;
	}
	public void setMetadati(Metadati metadati) {
		this.metadati = metadati;
	}
	public ArrayList<Sorgente> getSorgenti() {
		return sorgenti;
	}
	public void setSorgenti(ArrayList<Sorgente> sorgenti) {
		this.sorgenti = sorgenti;
	}
	public ArrayList<Recensione> getRecensioni() {
		return recensioni;
	}
	public void setRecensioni(ArrayList<Recensione> recensioni) {
		this.recensioni = recensioni;
	}
	public ArrayList<Capitolo> getCapitoli() {
		return capitoli;
	}
	public void setCapitoli(ArrayList<Capitolo> capitoli) {
		this.capitoli = capitoli;
	}
	public ArrayList<Autore> getAutori() {
		return autori;
	}
	public void setAutori(ArrayList<Autore> autori) {
		this.autori = autori;
	}
	public Publicazione(String titolo, String descrizione, String editore, Metadati metadati,
			ArrayList<Sorgente> sorgenti, ArrayList<Recensione> recensioni, ArrayList<Capitolo> capitoli,
			ArrayList<Autore> autori) {
		super();
		this.titolo = titolo;
		this.descrizione = descrizione;
		this.editore = editore;
		this.metadati = metadati;
		this.sorgenti = sorgenti;
		this.recensioni = recensioni;
		this.capitoli = capitoli;
		this.autori = autori;
	}
	@Override
	public String toString() {
		return "Publicazione [titolo=" + titolo + ", descrizione=" + descrizione + ", editore=" + editore
				+ ", metadati=" + metadati + ", sorgenti=" + sorgenti + ", recensioni=" + recensioni + "]";
	}

	
}
