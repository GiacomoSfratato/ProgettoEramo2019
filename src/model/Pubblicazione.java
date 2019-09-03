package model;

import java.util.ArrayList;
import java.util.Date;

import model.Utente.Builder;

// TODO: Auto-generated Javadoc
/**
 * The Class Pubblicazione.
 */
public class Pubblicazione {
	
	/**
	 * The Class Builder.
	 */
	public static class Builder{ 
 /** The editore. */
 /* implementazione del pattern builder */
		private String titolo, descrizione, editore;
		
		/** The id. */
		private int id;
		
		/** The metadati. */
		private Metadati metadati; // composizione
		
		/** The sorgenti. */
		private ArrayList <Sorgente> sorgenti;
		
		/** The recensioni. */
		private ArrayList <Recensione> recensioni;
		
		/** The capitoli. */
		private ArrayList <Capitolo> capitoli;
		
		/** The autori. */
		private ArrayList <Autore> autori;
		
		/** The likes. */
		private ArrayList <Likes> likes;  // forse da levare 
		
		/** The storico. */
		private ArrayList <Storico> storico;
		
		/** The utente. */
		private String utente;
		
		/** The data. */
		private String data;
		
		/** The likes totali. */
		private int likes_totali;
		
		/**
		 * Instantiates a new builder.
		 */
		public Builder () {
		};
		
		/**
		 * Withtitolo.
		 *
		 * @param titolo the titolo
		 * @return the builder
		 */
		public Builder withtitolo(String titolo) {
			this.titolo=titolo;
			return this;
		}
		
		/**
		 * Withmetadati.
		 *
		 * @param metadati the metadati
		 * @return the builder
		 */
		public Builder withmetadati(Metadati metadati) {
			this.metadati = metadati;
			return this;
		}
		
		/**
		 * Withdescrizione.
		 *
		 * @param descrizione the descrizione
		 * @return the builder
		 */
		public Builder withdescrizione(String descrizione) {
			this.descrizione = descrizione;
			return this;
		}
		
		/**
		 * Witheditore.
		 *
		 * @param editore the editore
		 * @return the builder
		 */
		public Builder witheditore(String editore) {
			this.editore = editore;
			return this;
		}
		
		/**
		 * Withsorgenti.
		 *
		 * @param sorgenti the sorgenti
		 * @return the builder
		 */
		public Builder withsorgenti(ArrayList <Sorgente> sorgenti) {
			this.sorgenti = sorgenti;
			return this;
		}
		
		/**
		 * Withrecensioni.
		 *
		 * @param recensioni the recensioni
		 * @return the builder
		 */
		public Builder withrecensioni(ArrayList <Recensione> recensioni) {
			this.recensioni = recensioni;
			return this;
		}
		
		/**
		 * Withcapitoli.
		 *
		 * @param capitoli the capitoli
		 * @return the builder
		 */
		public Builder withcapitoli(ArrayList <Capitolo> capitoli) {
			this.capitoli = capitoli;
			return this;
		}
		
		/**
		 * Withid.
		 *
		 * @param id the id
		 * @return the builder
		 */
		public Builder withid(int id) {
			this.id = id;
			return this;
		}
		
		/**
		 * Withautori.
		 *
		 * @param autori the autori
		 * @return the builder
		 */
		public Builder withautori(ArrayList <Autore> autori) {
			this.autori = autori;
			return this;
		}
		
		/**
		 * Withlikes.
		 *
		 * @param likes the likes
		 * @return the builder
		 */
		public Builder withlikes(ArrayList <Likes> likes) {
			this.likes = likes;
			return this;
		}
		
		/**
		 * Withlikes totali.
		 *
		 * @param likes the likes
		 * @return the builder
		 */
		public Builder withlikes_totali(int likes) {
			this.likes_totali = likes;
			return this;
		}
		
		/**
		 * Withstorico.
		 *
		 * @param storico the storico
		 * @return the builder
		 */
		public Builder withstorico(ArrayList <Storico> storico) {
			this.storico = storico;
			return this;
		}
		
		/**
		 * Withdata.
		 *
		 * @param data the data
		 * @return the builder
		 */
		public Builder withdata(String data) {
			this.data = data;
			return this;
		}
		
		/**
		 * Withutente.
		 *
		 * @param utente the utente
		 * @return the builder
		 */
		public Builder withutente(String utente) {
			this.utente = utente;
			return this;
		}
		
		/**
		 * Builds the.
		 *
		 * @return the pubblicazione
		 */
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
	
	
	/** The editore. */
	private String titolo, descrizione, editore;
	
	/** The id. */
	private  int id;
	
	/** The metadati. */
	private Metadati metadati; // composizione
	
	/** The data. */
	private String data;
	
	/** The utente. */
	private String utente;
	
	/** The sorgenti. */
	private ArrayList <Sorgente> sorgenti;
	
	/** The recensioni. */
	private ArrayList <Recensione> recensioni;
	
	/** The capitoli. */
	private ArrayList <Capitolo> capitoli;
	
	/** The autori. */
	private ArrayList <Autore> autori;
	
	/** The likes. */
	private ArrayList <Likes> likes;  // forse da levare 
	
	/** The storico. */
	private ArrayList <Storico> storico;
	
	/** The likes totali. */
	private int likes_totali;
	
	/**
	 * Gets the storico.
	 *
	 * @return the storico
	 */
	public ArrayList<Storico> getStorico() {
		return storico;
	}
	
	/**
	 * Sets the storico.
	 *
	 * @param storico the new storico
	 */
	public void setStorico(ArrayList<Storico> storico) {
		this.storico = storico;
	}
	
	/**
	 * Gets the likes totali.
	 *
	 * @return the likes totali
	 */
	public int getLikes_totali() {
		return likes_totali;
	}
	
	/**
	 * Sets the likes totali.
	 *
	 * @param likes_totali the new likes totali
	 */
	public void setLikes_totali(int likes_totali) {
		this.likes_totali = likes_totali;
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
	 * Gets the utente.
	 *
	 * @return the utente
	 */
	public String getUtente() {
		return utente;
	}
	
	/**
	 * Sets the pubblicatore.
	 *
	 * @param utente the new pubblicatore
	 */
	public void setPubblicatore(String utente) {
		this.utente=utente;
	}
	
	/**
	 * Gets the likes.
	 *
	 * @return the likes
	 */
	public ArrayList<Likes> getLikes() {
		return likes;
	}
	
	/**
	 * Sets the likes.
	 *
	 * @param likes the new likes
	 */
	public void setLikes(ArrayList<Likes> likes) {
		this.likes = likes;
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
	 * Gets the editore.
	 *
	 * @return the editore
	 */
	public String getEditore() {
		return editore;
	}
	
	/**
	 * Sets the editore.
	 *
	 * @param editore the new editore
	 */
	public void setEditore(String editore) {
		this.editore = editore;
	}
	
	/**
	 * Gets the id.
	 *
	 * @return the id
	 */
	public int getId() {
		return id;
	}
	
	/**
	 * Sets the id.
	 *
	 * @param id the new id
	 */
	public void setId(int id) {
		this.id = id;
	}
	
	/**
	 * Gets the metadati.
	 *
	 * @return the metadati
	 */
	public Metadati getMetadati() {
		return metadati;
	}
	
	/**
	 * Sets the metadati.
	 *
	 * @param metadati the new metadati
	 */
	public void setMetadati(Metadati metadati) {
		this.metadati = metadati;
	}
	
	/**
	 * Gets the sorgenti.
	 *
	 * @return the sorgenti
	 */
	public ArrayList<Sorgente> getSorgenti() {
		return sorgenti;
	}
	
	/**
	 * Sets the sorgenti.
	 *
	 * @param sorgenti the new sorgenti
	 */
	public void setSorgenti(ArrayList<Sorgente> sorgenti) {
		this.sorgenti = sorgenti;
	}
	
	/**
	 * Gets the recensioni.
	 *
	 * @return the recensioni
	 */
	public ArrayList<Recensione> getRecensioni() {
		return recensioni;
	}
	
	/**
	 * Sets the recensioni.
	 *
	 * @param recensioni the new recensioni
	 */
	public void setRecensioni(ArrayList<Recensione> recensioni) {
		this.recensioni = recensioni;
	}
	
	/**
	 * Gets the capitoli.
	 *
	 * @return the capitoli
	 */
	public ArrayList<Capitolo> getCapitoli() {
		return capitoli;
	}
	
	/**
	 * Sets the capitoli.
	 *
	 * @param capitoli the new capitoli
	 */
	public void setCapitoli(ArrayList<Capitolo> capitoli) {
		this.capitoli = capitoli;
	}
	
	/**
	 * Gets the autori.
	 *
	 * @return the autori
	 */
	public ArrayList<Autore> getAutori() {
		return autori;
	}
	
	/**
	 * Sets the autori.
	 *
	 * @param autori the new autori
	 */
	public void setAutori(ArrayList<Autore> autori) {
		this.autori = autori;
	}
	
	/**
	 * Instantiates a new pubblicazione.
	 */
	private Pubblicazione() {};
	
	/**
	 * To string.
	 *
	 * @return the string
	 */
	@Override
	public String toString() {
		return "Pubblicazione [titolo=" + titolo + ", descrizione=" + descrizione + ", editore=" + editore
				+ ", metadati=" + metadati + ", data=" + data + ", pubblicatore=" + utente + ", sorgenti="
				+ sorgenti + ", recensioni=" + recensioni + ", capitoli=" + capitoli + ", autori=" + autori + ", likes="
				+ likes + ", storico=" + storico + ", likes_totali=" + likes_totali + "]";
	}

	
}
