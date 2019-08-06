package model;
public class Storico {
private String descrizione; // anche qui si fa un check sul tipo con try-catch
private String timestamp;
private int id_utente, id_pubblicazione;
public String getDescrizione() {
	return descrizione;
}
public void setDescrizione(String descrizione) {
	this.descrizione = descrizione;
}
public String getTimestamp() {
	return timestamp;
}
public void setTimestamp(String timestamp) {
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
public Storico(String descrizione, String timestamp, int id_utente, int id_pubblicazione) {
	super();
	this.descrizione = descrizione;
	this.timestamp = timestamp;
	this.id_utente = id_utente;
	this.id_pubblicazione = id_pubblicazione;
}
@Override
public String toString() {
	return "Storico [descrizione=" + descrizione + ", timestamp=" + timestamp + ", id_utente=" + id_utente
			+ ", id_pubblicazione=" + id_pubblicazione + "]";
}

}
