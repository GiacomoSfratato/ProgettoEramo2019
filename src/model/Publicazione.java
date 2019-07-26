package model;

import java.util.ArrayList;

public class Publicazione {
	private String titolo, descrizione, editore;
	private static int id;
	private Metadati metadati; // composizione
	private ArrayList <Sorgente> sorgenti;
	private ArrayList <Recensione> recensioni;
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
	public Publicazione(String titolo, String descrizione, String editore, int id, Metadati metadati,
			ArrayList<Sorgente> sorgenti, ArrayList<Recensione> recensioni) {
		super();
		this.titolo = titolo;
		this.descrizione = descrizione;
		this.editore = editore;
		this.id = id;
		this.metadati = metadati;
		this.sorgenti = sorgenti;
		this.recensioni = recensioni;
	}
	@Override
	public String toString() {
		return "Publicazione [titolo=" + titolo + ", descrizione=" + descrizione + ", editore=" + editore + ", id=" + id
				+ ", metadati=" + metadati + ", sorgenti=" + sorgenti + ", recensioni=" + recensioni + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((descrizione == null) ? 0 : descrizione.hashCode());
		result = prime * result + ((editore == null) ? 0 : editore.hashCode());
		result = prime * result + id;
		result = prime * result + ((metadati == null) ? 0 : metadati.hashCode());
		result = prime * result + ((recensioni == null) ? 0 : recensioni.hashCode());
		result = prime * result + ((sorgenti == null) ? 0 : sorgenti.hashCode());
		result = prime * result + ((titolo == null) ? 0 : titolo.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Publicazione other = (Publicazione) obj;
		if (descrizione == null) {
			if (other.descrizione != null)
				return false;
		} else if (!descrizione.equals(other.descrizione))
			return false;
		if (editore == null) {
			if (other.editore != null)
				return false;
		} else if (!editore.equals(other.editore))
			return false;
		if (id != other.id)
			return false;
		if (metadati == null) {
			if (other.metadati != null)
				return false;
		} else if (!metadati.equals(other.metadati))
			return false;
		if (recensioni == null) {
			if (other.recensioni != null)
				return false;
		} else if (!recensioni.equals(other.recensioni))
			return false;
		if (sorgenti == null) {
			if (other.sorgenti != null)
				return false;
		} else if (!sorgenti.equals(other.sorgenti))
			return false;
		if (titolo == null) {
			if (other.titolo != null)
				return false;
		} else if (!titolo.equals(other.titolo))
			return false;
		return true;
	}
	
}
