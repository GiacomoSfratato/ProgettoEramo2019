package model;

import java.util.ArrayList;
import java.util.Date;

import model.Utente.Builder;

public class Pubblicazione {
	public static class Builder{ /* implementazione del pattern builder */
		private String titolo, descrizione, editore;
		private static int id;
		private Metadati metadati; // composizione
		private ArrayList <Sorgente> sorgenti;
		private ArrayList <Recensione> recensioni;
		private ArrayList <Capitolo> capitoli;
		private ArrayList <Autore> autori;
		private ArrayList <Likes> likes;  // forse da levare 
		private ArrayList <Storico> storico;
		private String pubblicatore;
		private String data;
		public Builder () {
		};
		public Builder withtitolo(String titolo) {
			this.titolo=titolo;
			return this;
		}
		public Builder withmetadati(Metadati metadati) {
			this.metadati = metadati;
			return this;
		}
		public Builder withdescrizione(String descrizione) {
			this.descrizione = descrizione;
			return this;
		}
		public Builder witheditore(String editore) {
			this.editore = editore;
			return this;
		}
		public Builder withsorgenti(ArrayList <Sorgente> sorgenti) {
			this.sorgenti = sorgenti;
			return this;
		}
		public Builder withrecensioni(ArrayList <Recensione> recensioni) {
			this.recensioni = recensioni;
			return this;
		}
		public Builder withcapitoli(ArrayList <Capitolo> capitoli) {
			this.capitoli = capitoli;
			return this;
		}
		public Builder withid(int id) {
			this.id = id;
			return this;
		}
		public Builder withautori(ArrayList <Autore> autori) {
			this.autori = autori;
			return this;
		}
		public Builder withlikes(ArrayList <Likes> likes) {
			this.likes = likes;
			return this;
		}
		public Builder withstorico(ArrayList <Storico> storico) {
			this.storico = storico;
			return this;
		}
		public Builder withdata(String data) {
			this.data = data;
			return this;
		}
		
		public Builder withpubblicatore(String pubblicatore) {
			this.pubblicatore = pubblicatore;
			return this;
		}
		
		public Pubblicazione build() {
			Pubblicazione pubblicazione = new Pubblicazione();
			pubblicazione.titolo=this.titolo;
			pubblicazione.descrizione=this.descrizione;
			pubblicazione.editore=this.editore;
			pubblicazione.sorgenti=this.sorgenti;
			pubblicazione.recensioni=this.recensioni;
			pubblicazione.capitoli=this.capitoli;
			pubblicazione.autori=this.autori;
			pubblicazione.id=this.id;
			pubblicazione.likes=this.likes;
			pubblicazione.storico=this.storico;
			pubblicazione.metadati=this.metadati;
			pubblicazione.data = this.data;
			pubblicazione.pubblicatore = this.pubblicatore;
			return pubblicazione;
		}
	}
	
	
	private String titolo, descrizione, editore;
	private static int id;
	private Metadati metadati; // composizione
	private String data;
	private String pubblicatore;
	private ArrayList <Sorgente> sorgenti;
	private ArrayList <Recensione> recensioni;
	private ArrayList <Capitolo> capitoli;
	private ArrayList <Autore> autori;
	private ArrayList <Likes> likes;  // forse da levare 
	private ArrayList <Storico> storico;
	
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	
	public String getPubblicatore() {
		return pubblicatore;
	}
	public void setPubblicatore(String pubblicatore) {
		this.pubblicatore=pubblicatore;
	}
	public ArrayList<Likes> getLikes() {
		return likes;
	}
	public void setLikes(ArrayList<Likes> likes) {
		this.likes = likes;
	}
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
		Pubblicazione.id = id;
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
	private Pubblicazione() {};
	
	@Override
	public String toString() {
		return "\nPubblicazione\nTitolo: " + titolo + "\nDescrizione: " + descrizione + "\nEditore: " + editore
				+ metadati + "\nSorgenti: " + sorgenti + "\nRecensioni: " + recensioni + "\nCapitoli: "
				+ capitoli + "\nAutori: " + autori + "\nLikes: " + likes + "\nStorico: " + storico + "\nAnno di pubblicazione: " + data + "\n";
	}

	
}
