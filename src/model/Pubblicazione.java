package model;

import java.util.ArrayList;
import java.util.Date;

import model.Utente.Builder;

public class Pubblicazione {
	public static class Builder{ /* implementazione del pattern builder */
		private String titolo, descrizione, editore;
		private int id;
		private Metadati metadati; // composizione
		private ArrayList <Sorgente> sorgenti;
		private ArrayList <Recensione> recensioni;
		private ArrayList <Capitolo> capitoli;
		private ArrayList <Autore> autori;
		private ArrayList <Likes> likes;  // forse da levare 
		private ArrayList <Storico> storico;
		private String utente;
		private String data;
		private int likes_totali;
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
		public Builder withlikes_totali(int likes) {
			this.likes_totali = likes;
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
		
		public Builder withutente(String utente) {
			this.utente = utente;
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
			pubblicazione.utente = this.utente;
			pubblicazione.likes_totali = this.likes_totali;
			return pubblicazione;
		}
	}
	
	
	private String titolo, descrizione, editore;
	private  int id;
	private Metadati metadati; // composizione
	private String data;
	private String utente;
	private ArrayList <Sorgente> sorgenti;
	private ArrayList <Recensione> recensioni;
	private ArrayList <Capitolo> capitoli;
	private ArrayList <Autore> autori;
	private ArrayList <Likes> likes;  // forse da levare 
	private ArrayList <Storico> storico;
	private int likes_totali;
	public ArrayList<Storico> getStorico() {
		return storico;
	}
	public void setStorico(ArrayList<Storico> storico) {
		this.storico = storico;
	}
	public int getLikes_totali() {
		return likes_totali;
	}
	public void setLikes_totali(int likes_totali) {
		this.likes_totali = likes_totali;
	}
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	public String getUtente() {
		return utente;
	}
	public void setPubblicatore(String utente) {
		this.utente=utente;
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
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
		return "Pubblicazione [titolo=" + titolo + ", descrizione=" + descrizione + ", editore=" + editore
				+ ", metadati=" + metadati + ", data=" + data + ", pubblicatore=" + utente + ", sorgenti="
				+ sorgenti + ", recensioni=" + recensioni + ", capitoli=" + capitoli + ", autori=" + autori + ", likes="
				+ likes + ", storico=" + storico + ", likes_totali=" + likes_totali + "]";
	}

	
}
